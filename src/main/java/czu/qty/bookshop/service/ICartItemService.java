package czu.qty.bookshop.service;

import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.pojo.Cartitem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @create 2021-01-04-10:07
 */

public interface ICartItemService {

    //获取我的购物车中的所有商品项
    public PageInfo<Cartitem> getAllCartItem(Integer u_id, Integer pageNum, Integer pageSize);

    //查找某项是否存在
    public Cartitem checkCartItem(Integer cart_id,String b_id);

    //添加商品项   加入购物车
    public int addCartItem(Integer cart_id, String b_id, Integer num, Double price, String imgs,String b_name);

    //删除商品项   购买
    public int delCartItem(Integer cart_id, String b_id);

    //修改商品数量
    public int updateCartItem(Integer cart_id, String b_id, Integer num, Double price);

    //清空购物车
    public int delAllMyCartItem(Integer cart_id);

    //获取购物车中的总价
    public Double getAllPrice(Integer cart_id);

    //获取购物车中的商品数量
    public Long getCountItem(Integer cart_id);

    //根据b_id和cart_id输入
    public Integer getCartItemByBidAndCartId(String b_id,Integer cart_id);
}
