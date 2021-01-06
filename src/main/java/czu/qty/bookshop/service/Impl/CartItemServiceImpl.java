package czu.qty.bookshop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.mapper.CartItemMapper;
import czu.qty.bookshop.mapper.CartMapper;
import czu.qty.bookshop.pojo.Book;
import czu.qty.bookshop.pojo.Cartitem;
import czu.qty.bookshop.service.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @create 2021-01-04-10:13
 */
@Service
public class CartItemServiceImpl implements ICartItemService {

    @Autowired
    private CartItemMapper cartItemMapper;

    @Override
    public PageInfo<Cartitem> getAllCartItem(Integer u_id, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<Cartitem> list = cartItemMapper.getAllCartItem(u_id);

        PageInfo<Cartitem> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public Cartitem checkCartItem(Integer cart_id, String b_id) {
        return cartItemMapper.checkCartItem(cart_id,b_id);
    }

    @Override
    public int addCartItem(Integer cart_id, String b_id, Integer num, Double price, String imgs, String b_name) {
        return cartItemMapper.addCartItem(cart_id, b_id, num, price, imgs, b_name);
    }

    @Override
    public int delCartItem(Integer cart_id, String b_id) {
        return cartItemMapper.delCartItem(cart_id, b_id);
    }

    @Override
    public int updateCartItem(Integer cart_id, String b_id, Integer num, Double price) {
        return cartItemMapper.updateCartItem(cart_id, b_id, num, price);
    }

    @Override
    public int delAllMyCartItem(Integer cart_id) {
        return cartItemMapper.delAllMyCartItem(cart_id);
    }

    @Override
    public Double getAllPrice(Integer cart_id) {
        return cartItemMapper.getAllPrice(cart_id);
    }

    @Override
    public Long getCountItem(Integer cart_id) {
        return cartItemMapper.getCountItem(cart_id);
    }

    @Override
    public Integer getCartItemByBidAndCartId(String b_id, Integer cart_id) {
        return cartItemMapper.getCartItemByBidAndCartId(b_id,cart_id);
    }
}
