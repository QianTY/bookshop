package czu.qty.bookshop.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.mapper.BookMapper;
import czu.qty.bookshop.pojo.Book;
import czu.qty.bookshop.pojo.Order;
import czu.qty.bookshop.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderTest {
    @Autowired
    IOrderService orderService;
    @Autowired
    BookMapper bookMapper;

    @Test
    public void orderTest(){
//        Integer u_id=1;
//        String o_id=null;
//
//        System.out.println(orderService.getOrder(u_id,o_id,1,5).getList());

//        Book book=bookMapper.getBookById("1");
    }

}
