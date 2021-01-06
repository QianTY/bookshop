package czu.qty.bookshop.mapper;

import czu.qty.bookshop.pojo.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @create 2021-01-01-17:03
 */
@Mapper
public interface CartMapper {

    //新建购物车
    @Insert("insert into cart(u_id,cart_id,total_price) values(#{u_id},#{cart_id},#{total_price})")
    public int addCart(Integer u_id,Integer cart_id,Double total_price);

    //修改购物车

    public int updateCart(Integer cart_id);

    //查找购物车
    @Select("select * from cart where u_id=#{u_id}")
    public Cart findMyCart(Integer u_id);

}
