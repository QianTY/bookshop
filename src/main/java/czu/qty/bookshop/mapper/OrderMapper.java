package czu.qty.bookshop.mapper;

import czu.qty.bookshop.pojo.Order;
import czu.qty.bookshop.pojo.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;
import java.util.List;

/**
 * @create 2020-12-28-14:17
 */
@Mapper
public interface OrderMapper{

    //根据用户id  订单号(可为null)获取Order
    public List<Order> getOrder(Integer u_id,String o_id);

    //删除订单  把对应订单的status字段改为0
    @Update("update `order` set status=0 where o_id=#{o_id}")
    public int delOrder(String o_id);


    @Select("select * from orderitem where o_id=#{o_id}")
    public List<OrderItem> getItemById(String o_id);

    //添加订单项
    @Insert("insert into orderitem(o_id,b_id,b_name,count,price,total_price,imgs) values(#{o_id},#{b_id},#{b_name},#{count},#{price},#{total_price},#{imgs})")
    public int addOrderItem(String o_id,String b_id,String b_name,Integer count,Float price,Double total_price,String imgs);

    //根据订单号获取Order
    @Select("select * from `order` where o_id=#{o_id}")
    public Order getOrderByOrderId(String o_id);

    //修改订单状态
    @Update("update `order` set(o_price,o_time,u_id) values(#{o_price},#{o_time}),#{u_id} where o_id=#{o_id}")
    public int updateOrder(String o_id,Float o_price ,Date o_time,Integer u_id);

    //查看所有订单
    @Select("select * from `order`")
    public List<Order> getAllOrder();

    //添加订单
    @Insert("insert into `order` (o_id,o_time,o_price,u_id) values(#{o_id},#{o_time},#{o_price},#{u_id})")
    public int addOrder(String o_id, Date o_time , Float o_price , Integer u_id);
}
