package czu.qty.bookshop.service;

import czu.qty.bookshop.pojo.Cart;

/**
 * @create 2021-01-04-10:07
 */
public interface ICartService {

    //新建购物车
    public int addCart(Integer u_id,Integer cart_id,Double total_price);

    //修改购物车
    public int updateCart(Integer cart_id);

    //查找购物车
    public Cart findMyCart(Integer u_id);

}
