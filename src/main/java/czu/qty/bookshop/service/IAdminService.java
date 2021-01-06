package czu.qty.bookshop.service;

import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.pojo.Admin;
import czu.qty.bookshop.pojo.Book;
import czu.qty.bookshop.pojo.BookKind;
import czu.qty.bookshop.pojo.Order;

import java.sql.Date;
import java.util.List;

public interface IAdminService {
    /**
     * 管理员登录
     * @param id
     * @param password
     * @return
     */
    public Admin adminLogin(Integer id, String password);

    //获取所有未发货的订单
    public PageInfo<Order> getOrder(Integer pageNum);

//  发货  is_receipt-1  填写发货日期
    public int fahuo(Integer o_id, Date receipt_time);

    //    获取所有的书
    public PageInfo<Book> getAllBookinfo(Integer pageNum);

    //    获取id对应的书
    public Book getBookById(String b_id);

    //    获取图书类型
    public List<BookKind> getBookType();

    //    更新图书
    public int updateBook(Book book);

    //    添加图书
    public int insertBook(Book book);


}
