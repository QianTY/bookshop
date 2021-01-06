package czu.qty.bookshop.mapper;

import czu.qty.bookshop.pojo.Cartitem;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @create 2021-01-04-9:27
 */
@Mapper
public interface CartItemMapper {

    //根据b_id和cart_id输入
    @Select("select num from cartitem where cart_id = #{cart_id} and b_id = #{b_id}")
    public Integer getCartItemByBidAndCartId(String b_id,Integer cart_id);

    //获取我的购物车中的所有商品项
    @Select("select * from cartitem where cart_id=(select cart_id from cart where u_id=#{u_id})")
    public List<Cartitem> getAllCartItem(Integer u_id);

    //查找某项是否存在
    @Select("select * from cartitem where cart_id=#{cart_id} and b_id = #{b_id}")
    public Cartitem checkCartItem(Integer cart_id,String b_id);

    //添加商品项   加入购物车
    @Insert("insert into cartitem(cart_id,b_id,num,price,imgs,b_name) values(#{cart_id},#{b_id},#{num},#{price},#{imgs},#{b_name})")
    public int addCartItem(Integer cart_id, String b_id, Integer num, Double price, String imgs,String b_name);

    //删除商品项   购买
    @Delete("delete from cartitem where cart_id=#{cart_id} and b_id=#{b_id}")
    public int delCartItem(Integer cart_id, String b_id);

    //修改商品数量
    @Update("update cartitem set num=#{num},price=#{price} where cart_id=#{cart_id} and b_id=#{b_id}")
    public int updateCartItem(Integer cart_id, String b_id, Integer num, Double price);

    //清空购物车
    @Delete("delete from cartitem where cart_id=#{cart_id}")
    public int delAllMyCartItem(Integer cart_id);

    //获取购物车中的总价
    @Select("select sum(price) from cartitem where cart_id = #{cart_id}")
    public Double getAllPrice(Integer cart_id);

    //获取购物车中的商品数量
    @Select("select sum(num) from cartitem where cart_id=#{cart_id}")
    public Long getCountItem(Integer cart_id);
}
