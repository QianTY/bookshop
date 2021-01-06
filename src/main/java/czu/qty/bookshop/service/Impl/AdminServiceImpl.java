package czu.qty.bookshop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.mapper.AdminMapper;
import czu.qty.bookshop.mapper.BookKindMapper;
import czu.qty.bookshop.mapper.BookMapper;
import czu.qty.bookshop.pojo.Admin;
import czu.qty.bookshop.pojo.Book;
import czu.qty.bookshop.pojo.BookKind;
import czu.qty.bookshop.pojo.Order;
import czu.qty.bookshop.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookKindMapper bookKindMapper;

    @Override
    public Admin adminLogin(Integer id, String password) {
        Admin admin=adminMapper.adminLogin(id,password);

        return admin;
    }

    @Override
    public PageInfo<Order> getOrder(Integer pageNum) {

        PageHelper.startPage(pageNum,5);
        List<Order> list =adminMapper.getOrder();
        PageInfo<Order> pageInfo=new PageInfo<>(list);

        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总未发货条数:"+pageInfo.getSize());
        return pageInfo;
    }

    @Override
    public int fahuo(Integer o_id, Date receipt_time) {
        return adminMapper.fahuo(o_id,receipt_time);
    }

    @Override
    public PageInfo<Book> getAllBookinfo(Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        List<Book> list =bookMapper.getAllBookinfo();
        PageInfo<Book> pageInfo=new PageInfo<>(list);

        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总未发货条数:"+pageInfo.getSize());
        return pageInfo;
    }

    @Override
    public Book getBookById(String b_id) {

        return bookMapper.getBookById(b_id);
    }

    @Override
    public List<BookKind> getBookType() {
        return bookKindMapper.getAllBookKind();
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.update(book.getB_id(),book.getB_name(), book.getB_price(),book.getF_name(),book.getB_author(),book.getB_sales(),book.getB_stock(),book.getImg_path());
    }

    @Override
    public int insertBook(Book book) {
        return bookMapper.addBook(book.getB_id(),book.getB_name(), book.getB_price(),book.getF_name(),book.getB_author(),book.getB_sales(),book.getB_stock(),book.getImg_path());
    }

}
