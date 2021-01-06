package czu.qty.bookshop.mapper;

import czu.qty.bookshop.pojo.Admin;
import czu.qty.bookshop.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;
import java.util.List;

@Mapper
public interface AdminMapper {

    /**
     * 管理员登录
     * @param id
     * @param password
     * @return
     */
    public Admin adminLogin(@Param("id") Integer id, @Param("password") String password);

    //获取所有未发货的订单
    @Select("select * from `order` where is_receipt=0")
    public List<Order> getOrder();

//    给订单发货  is_receipt=1  填写发货日期
    @Update("update `order` set is_receipt=1 , receipt_time=#{receipt_time} where o_id=#{o_id}")
    public int fahuo(Integer o_id, Date receipt_time);

}
