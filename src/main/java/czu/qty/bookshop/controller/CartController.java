package czu.qty.bookshop.controller;

import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.pojo.*;
import czu.qty.bookshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * @create 2021-01-04-10:24
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;
    @Autowired
    private ICartItemService cartItemService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private IBookInfoService bookInfoService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/index")
    public String index(HttpSession session, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        List<BookInfo> bookInfos = bookInfoService.getAllBookInfo();
        session.setAttribute("bookInfos", bookInfos);
        User user = (User) session.getAttribute("user");
        Integer u_id = user.getU_id();
        Cart myCart = cartService.findMyCart(u_id);

        if (myCart == null) {
            cartService.addCart(u_id, u_id, 0.0);
            myCart = cartService.findMyCart(u_id);
        } else {
            Integer cart_id = myCart.getCart_id();
            PageInfo<Cartitem> allCartItem = cartItemService.getAllCartItem(cart_id, pageNum, pageSize);
            session.setAttribute("cartItems", allCartItem);
        }
        Double total_price = myCart.getTotal_price();
        session.setAttribute("total_price", total_price);
        Long countItem = cartItemService.getCountItem(myCart.getCart_id());
        session.setAttribute("countItem", countItem);

        return "/WEB-INF/pages/cart/cart";
    }

    @RequestMapping("/addItem")
    @ResponseBody
    @Transactional(rollbackFor = {Exception.class})
    public Result addCartItem(HttpSession session, String b_id, @RequestParam(defaultValue = "1") Integer num) {

        User user = (User) session.getAttribute("user");
        Integer u_id = user.getU_id();
        Book book = bookService.getBookById(b_id);

        if (num < 1) {
            //返回添加错误
            return new Result("404", "请输入大于1的数字!");
        } else if (num > book.getB_stock()) {
            //返回添加错误
            return new Result("404", "抱歉,当前商品库存不够,请输入减小数字尝试!谢谢配合!");
        }
        int addCartItem = 0;
        Double price = Double.valueOf(book.getB_price()) * num;
        Cart cart = cartService.findMyCart(u_id);
        int updateCart = 0;
        try {
            if (cart == null) {
                cartService.addCart(u_id, u_id, 0.0);
                Cartitem cartitem = cartItemService.checkCartItem(cart.getCart_id(), b_id);
                if (cartitem != null) {
                    cartItemService.updateCartItem(cart.getCart_id(), b_id, num, price);
                } else {
                    cartItemService.addCartItem(cart.getCart_id(), b_id, num, price, book.getImg_path(), book.getB_name());
                }
                updateCart = cartService.updateCart(u_id);
            } else {
                Cartitem cartitem = cartItemService.checkCartItem(cart.getCart_id(), b_id);
                if (cartitem != null) {
                    Integer oldNum = cartitem.getNum();
                    cartItemService.updateCartItem(cart.getCart_id(), b_id, num + oldNum, (double) ((book.getB_price()) * (num + oldNum)));
                } else {
                    cartItemService.addCartItem(cart.getCart_id(), b_id, num, price, book.getImg_path(), book.getB_name());
                }
//                addCartItem = cartItemService.addCartItem(cart.getCart_id(), book.getB_id(), num, price, book.getImg_path(),book.getB_name());
                Double allPrice = cartItemService.getAllPrice(cart.getCart_id());
                updateCart = cartService.updateCart(cart.getCart_id());
            }

        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        Integer b_stock = book.getB_stock();
        session.setAttribute("stock"+b_id,b_stock);

        if (updateCart > 0) {
            return new Result("200", "添加成功", null);
        } else {
            return new Result("404", "添加失败", null);
        }
    }

    @RequestMapping("/delCartItem")
    @ResponseBody
    @Transactional(rollbackFor = {Exception.class})
    public Result delCartItem(String b_id, HttpServletResponse response, HttpSession session) throws IOException {
        int del = 0;
        int updateCart = 0;
        Cart cart = (Cart) session.getAttribute("cart");
        try {
            Integer cart_id = cart.getCart_id();
            del = cartItemService.delCartItem(cart_id, b_id);
            updateCart = cartService.updateCart(cart_id);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        if (del > 0 && updateCart > 0) {
            return new Result("200", "删除成功", null);

        } else {
            return new Result("404", "删除失败", null);
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result updateNum(String b_id,Integer num,HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        Integer cart_id = cart.getCart_id();
        Book book = bookService.getBookById(b_id);
        Float b_price = book.getB_price();
        Double price = Double.valueOf(b_price * num);
        int update = cartItemService.updateCartItem(cart_id, b_id, num, price);
        if (update > 0){
            cartService.updateCart(cart_id);
            return new Result("200", "更新成功", null);
        }else{
            return new Result("404","更新失败",null);
        }
    }

    @RequestMapping("/checkout")
    @ResponseBody
    @Transactional(rollbackFor = {Exception.class})
    public Result checkoutCart(String sids, HttpSession session) {
        String[] arr = sids.split(":");

        Cart cart = (Cart) session.getAttribute("cart");
        Integer cart_id = cart.getCart_id();
        User user = (User) session.getAttribute("user");
        Integer u_id = user.getU_id();
        Long time = System.currentTimeMillis();

        String o_id = System.currentTimeMillis() + "" + u_id;

        if (arr != null) {
            //获取总价
            Float total_price = new Float(cart.getTotal_price());
            for (String id : arr) {
                //获取每本书的数量
                Integer bookNum = cartItemService.getCartItemByBidAndCartId(id, cart_id);

                Book book = bookService.getBookById(id);

                if (bookNum <= book.getB_stock()) {
                    //更新图书销量和库存
                    bookService.updateBookStock(book.getB_stock()-bookNum,book.getB_sales()+bookNum, id);
                } else {
//                    throw new MyNumException();
                    return new Result("404", "库存不足,请减少数量,库存量:"+book.getB_stock(), null);
                }
                //删除购物车选项
                cartItemService.delCartItem(cart_id, id);
                orderService.addOrderItem(o_id,id,book.getB_name(),bookNum,book.getB_price(),cart.getTotal_price(),book.getImg_path());
            }

            //添加到订单
            int updateCart = cartService.updateCart(cart_id);
            int add = orderService.addOrder(o_id, new Date(time), total_price, u_id);
            if (add >0){
                System.out.println("成功");

            }else{
                System.out.println("失败");
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            return new Result("200", "结算成功!", null);
        } else {
            return new Result("404", "结算失败!", null);
        }
    }

    @RequestMapping("/flushTable")
    public String flushTable(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize,HttpServletRequest request, HttpSession session){
        User user = (User) session.getAttribute("user");
        Integer u_id = user.getU_id();
        PageInfo<Cartitem> allCartItem = cartItemService.getAllCartItem(u_id, pageNum, pageSize);
        session.setAttribute("cartItems",allCartItem);

        Cart myCart = cartService.findMyCart(u_id);
        Double total_price = myCart.getTotal_price();
        session.setAttribute("total_price", total_price);
        Long countItem = cartItemService.getCountItem(myCart.getCart_id());
        session.setAttribute("countItem", countItem);

        return "/WEB-INF/pages/cart/cartBody";
    }

}

