package czu.qty.bookshop.service;

import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.pojo.Order;
import czu.qty.bookshop.pojo.OrderItem;

import java.sql.Date;
import java.util.List;

/**
 * @create 2020-12-29-12:20
 */
public interface IOrderService {

    //添加订单项
    public int addOrderItem(String o_id,String b_id,String b_name,Integer count,Float price,Double total_price,String imgs);

    //获取所有Order
    public List<Order> getAllOrder();

    //根据订单ID查找订单详情
    public List<OrderItem> getItemById(String o_id);

    //根据用户id  订单号(可为null)获取Order
    public PageInfo<Order> getOrder(Integer u_id,String o_id,Integer pageNum, Integer pageSize);

    //删除订单  把对应订单的status字段改为0
    public int delOrder(String o_id);

    //根据订单号获取Order
    public Order getOrderByOrderId(String o_id);

    //修改订单状态
    public int updateOrder(Order order);

    //添加订单
    public int addOrder(String o_id, Date o_time , Float o_price , Integer u_id);

}
