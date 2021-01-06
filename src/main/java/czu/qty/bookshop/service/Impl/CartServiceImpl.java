package czu.qty.bookshop.service.Impl;

import czu.qty.bookshop.mapper.CartMapper;
import czu.qty.bookshop.pojo.Cart;
import czu.qty.bookshop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @create 2021-01-04-10:12
 */
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public int addCart(Integer u_id, Integer cart_id, Double total_price) {
        return cartMapper.addCart(u_id,cart_id,total_price);
    }

    @Override
    public int updateCart(Integer cart_id) {
        return cartMapper.updateCart(cart_id);
    }

    @Override
    public Cart findMyCart(Integer u_id) {
        return cartMapper.findMyCart(u_id);
    }
}
