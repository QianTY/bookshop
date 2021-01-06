package czu.qty.bookshop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Or;
import czu.qty.bookshop.mapper.OrderMapper;
import czu.qty.bookshop.pojo.Order;
import czu.qty.bookshop.pojo.OrderItem;
import czu.qty.bookshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @create 2020-12-29-12:21
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int addOrderItem(String o_id, String b_id, String b_name, Integer count, Float price, Double total_price, String imgs) {
        return orderMapper.addOrderItem(o_id,b_id,b_name,count,price,total_price,imgs);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderMapper.getAllOrder();
    }

    @Override
    public List<OrderItem> getItemById(String o_id) {
        return orderMapper.getItemById(o_id);
    }



    @Override
    public PageInfo<Order> getOrder(Integer u_id,String o_id,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Order> list=orderMapper.getOrder(u_id,o_id);
        PageInfo<Order> pageInfo=new PageInfo<>(list);
        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总的条数:"+pageInfo.getSize());
        return pageInfo;
    }

    @Override
    public int delOrder(String o_id) {
        return orderMapper.delOrder(o_id);
    }


    @Override
    public Order getOrderByOrderId(String o_id) {
        return orderMapper.getOrderByOrderId(o_id);
    }

    @Override
    public int updateOrder(Order order) {
        return 0;
    }

    @Override
    public int addOrder(String o_id, Date o_time, Float o_price, Integer u_id) {
        return orderMapper.addOrder(o_id,o_time,o_price,u_id);
    }


}
