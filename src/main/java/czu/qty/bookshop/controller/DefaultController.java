package czu.qty.bookshop.controller;

import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.pojo.*;
import czu.qty.bookshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @create 2020-12-26-14:46
 */
@Controller
public class DefaultController {

    @Autowired
    private IBookKindService bookKindService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private IBookInfoService bookInfoService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IFavouriteService favouriteService;

    @Autowired
    private ICartService cartService;

    @GetMapping("/index")
    public String indexPage(HttpServletRequest request,HttpSession session) {
        List<BookKind> kinds = bookKindService.getAllBookKind();
        session.setAttribute("kinds", kinds);
        PageInfo<Book> allBook = bookService.getAllBook(null,null,1,10);
        request.setAttribute("books", allBook);
        User user = (User) session.getAttribute("user");

        if (user!= null){
            Integer u_id = user.getU_id();
            List<Book> allMyFavourite = favouriteService.getAll(u_id);
            session.setAttribute("myFavourite",allMyFavourite);
        }
        return "/index";
    }

}
