package czu.qty.bookshop.controller;

import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.pojo.Book;
import czu.qty.bookshop.pojo.Result;
import czu.qty.bookshop.pojo.User;
import czu.qty.bookshop.service.IFavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @create 2021-01-01-16:32
 */
@Controller
@RequestMapping("/favourite")
public class FavouriteController {

    @Autowired
    private IFavouriteService favouriteService;


    @RequestMapping("/index")
    public void index(HttpSession session, String b_id, HttpServletRequest request , HttpServletResponse response) throws IOException {
        User user = (User) session.getAttribute("user");
        Integer u_id = user.getU_id();

        if(favouriteService.getFavouriteByUidAndBid(u_id,b_id) != null){
            response.sendRedirect("/favourite/del?b_id="+b_id);
        }else{
            response.sendRedirect("/favourite/add?b_id="+b_id);
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result addFavourite(HttpSession session, String b_id){
        User user = (User) session.getAttribute("user");
        Integer u_id = user.getU_id();

        int i = favouriteService.addFavourite(u_id, b_id);

        if (i > 0 ){
            return new Result("200","收藏成功",null);
        }else{
            return new Result("404","收藏失败",null);
        }
    }

    @RequestMapping("/del")
    @ResponseBody
    public Result delFavourite(HttpSession session, String b_id){
        User user = (User) session.getAttribute("user");
        Integer u_id = user.getU_id();
        int i = favouriteService.delFavourite(u_id, b_id);
        if (i > 0 ){
            return new Result("200","已取消收藏",null);
        }else{
            return new Result("500","取消收藏失败,请稍后重试",null);
        }
    }

    @RequestMapping("/out")
    public String delonly(HttpSession session, HttpServletRequest request,String b_id){
        //获取一下当前登录的用户

        User user= (User) session.getAttribute("user");
        Integer u_id = user.getU_id();
        System.out.println("----3-----");
        if(b_id!=null)
        {
           favouriteService.delFavourite2(u_id,b_id);
        }
        List<Book> bookinfo =favouriteService.getAll(user.getU_id());
        request.setAttribute("bookinfo",bookinfo);
        return "/WEB-INF/pages/Common/favouritedel";
    }

    @RequestMapping("/delmore1")
   public String delmore1(HttpSession session, HttpServletRequest request) {
        User user= (User) session.getAttribute("user");
        Integer u_id = user.getU_id();
        System.out.println("----2-----");
        List<Book> bookinfo =favouriteService.getAll(user.getU_id());
        request.setAttribute("bookinfo",bookinfo);
        return "/WEB-INF/pages/Common/favouritedelmore";
    }
    @RequestMapping("/delmore2")
    public String delmore(HttpSession session, HttpServletRequest request, String sids){
        User user= (User) session.getAttribute("user");
        Integer u_id = user.getU_id();
        //对sids进行字符串的切割
        String[] arr = sids.split(":");
        System.out.println("----3-----");
        if(arr!=null)
        {
            for (String id : arr) {
                favouriteService.delFavourite2(u_id,id);
            }
        }
        List<Book> bookinfo =favouriteService.getAll(user.getU_id());
        request.setAttribute("bookinfo",bookinfo);
        return "/WEB-INF/pages/Common/favouritedelmore";
    }


    @GetMapping("/getall")
    public String getAllFavourite(HttpSession session, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "12") Integer pageSize){
        User user = (User) session.getAttribute("user");
        Integer u_id = user.getU_id();
        PageInfo<Book> allMyFavourite = favouriteService.getAllMyFavourite(u_id, pageNum, pageSize);
        session.setAttribute("Myfavourite",allMyFavourite);
        return "/WEB-INF/pages";
    }

    @GetMapping("/fav")
        public String fav(){
        return "/WEB-INF/pages/user/favourite";
        }

}
