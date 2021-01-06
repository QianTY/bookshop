package czu.qty.bookshop.controller;

import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.pojo.Order;
import czu.qty.bookshop.pojo.OrderItem;
import czu.qty.bookshop.pojo.Result;
import czu.qty.bookshop.pojo.User;
import czu.qty.bookshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @create 2020-12-28-14:20
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/index")
    public String showAllOrder(String o_id,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize, HttpSession session){

//        User user = (User) session.getAttribute("user");
        User user=new User(1,"wwc","123","18921517603@163.com",1);
        Integer u_id = user.getU_id();

        PageInfo<Order> order=orderService.getOrder(u_id,o_id,pageNum,pageSize);

        //List<Order> orders = orderService.getAllOrder();
        session.setAttribute("order_id",o_id);
        session.setAttribute("orders",order);
        System.out.println(o_id);
        return "/WEB-INF/pages/order/order";
    }

    @GetMapping("/item")
    public String orderItem(HttpSession session,String o_id){
        List<OrderItem> item=orderService.getItemById(o_id);
        session.setAttribute("item",item);
        return "/WEB-INF/pages/order/order_item";
    }

    @RequestMapping("/del")
    @ResponseBody
    public Result delOrder(String o_id){
        int flag=orderService.delOrder(o_id);
        System.out.println(flag);
        return new Result("500","删除成功",null);
    }

    @GetMapping("/getDetail")
    public String getDetails(){
        return "/WEB-INF/pages/order/order_item";
    }

    @GetMapping("/addOrder")
    public String addOrder(){
        return null;
    }



}
