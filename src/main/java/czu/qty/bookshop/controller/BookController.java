package czu.qty.bookshop.controller;

import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.pojo.Book;
import czu.qty.bookshop.pojo.Result;
import czu.qty.bookshop.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @create 2020-12-27-1:18
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/details")
    public String getBookDetail(HttpServletRequest request,String b_id){
        Book book = bookService.getBookById(b_id);
        request.setAttribute("bookDetail",book);
        return "/WEB-INF/pages/book/bookdetails";
    }

    @RequestMapping("/search")
    public String seachByName(String b_name,String type, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, HttpServletRequest request){
        PageInfo<Book> books = bookService.getAllBook(b_name,type,pageNum,pageSize);
        request.setAttribute("books",books);

        request.setAttribute("name",b_name);
        request.setAttribute("type",type);

        return "/index";
    }

    //功能尚未完成

    @RequestMapping("/del")
    @ResponseBody
    public Result delBook(HttpSession session ,String b_id){
        int i = bookService.delBookById(b_id);
        if (i< 0){
            return  new Result("404","删除失败",null);
        }
        return new Result("200","删除成功",null);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result addBook(Book book){

        return new Result("200","添加成功",null);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result updateBook(Book book){
        int update = bookService.update(book.getB_id(), book.getB_name(), book.getB_price(), book.getF_name(), book.getB_author(), book.getB_sales(), book.getB_stock(), book.getImg_path());
        if (update > 0)
        return new Result("200" , "更新成功",null);
        return new Result("404","更新失败",null);
    }
}
