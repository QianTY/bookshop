package czu.qty.bookshop.controller;


import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.pojo.*;
import czu.qty.bookshop.service.IAdminService;
import czu.qty.bookshop.service.IBookInfoService;
import czu.qty.bookshop.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IAdminService adminService;
    @Autowired
    IBookService bookService;

    @GetMapping("")
    public String toAdminLogin(){
        return "/WEB-INF/pages/manager/astorlogin";
    }
    @GetMapping("/administrator")
    public String toAdminManager(){
        return "/WEB-INF/pages/manager/adminmanager";
    }
    @GetMapping("/adminorder")
    public String toAdminorder(){
        return "/WEB-INF/pages/manager/adminorder";
    }

    @GetMapping("/adminbook")
    public String toAdminbook(){
        return "/WEB-INF/pages/manager/administrator";
    }

    @RequestMapping("/updatebook")
    public String updatebook(String action,String b_id,HttpServletRequest request,HttpSession session){
//        System.out.println(action+b_id);
        if(action.equals("update")){    //更新操作
            Book book=adminService.getBookById(b_id);
            List<BookKind> bookKind=adminService.getBookType();
            request.setAttribute("bookkind",bookKind);
            session.setAttribute("action",action);
            if(book!=null){
                request.setAttribute("book",book);
            }
        }else if(action.equals("add")){ //增加操作
            System.out.println(action);
            List<BookKind> bookKind=adminService.getBookType();
            request.setAttribute("bookkind",bookKind);
            session.setAttribute("action",action);
        }
        return "/WEB-INF/pages/manager/update";
    }


    @RequestMapping("/booklist")
    public String toAdminBooklist(HttpServletRequest request,@RequestParam(defaultValue = "1") Integer pageNum){
        PageInfo<Book> book=adminService.getAllBookinfo(pageNum);
        request.setAttribute("book",book);
        return "/WEB-INF/pages/manager/adminstrator_content";
    }

    @RequestMapping("/item")
    public String getOrder(HttpSession session,@RequestParam(defaultValue = "1") Integer pageNum){
        PageInfo<Order> order=adminService.getOrder(pageNum);
        session.setAttribute("order",order);
        session.setAttribute("admin_order_pageNum",pageNum);
        return "/WEB-INF/pages/manager/adminorder_contant";
    }

    @PostMapping("/login")
    @ResponseBody
    public Result adminLogin(Integer id, String password){
        Admin admin=adminService.adminLogin(id,password);
        if(admin==null){
            return new Result("404","账号密码错误",null);
        }else{
            return new Result("200","登录成功",null);
        }
    }

    @RequestMapping("/fahuo")
    @ResponseBody
    public Result fahuo(Integer o_id) throws ParseException {
        Date nowDate=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String str=simpleDateFormat.format(nowDate);
        Date utilDate=simpleDateFormat.parse(str);
        java.sql.Date receipt_time = new java.sql.Date(utilDate.getTime());
        adminService.fahuo(o_id,receipt_time);

        return new Result("200","删除成功",null);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Result upload(MultipartFile file, HttpServletRequest request){

        //获取上传的文件的本来的名称
        String filename = file.getOriginalFilename();

        System.out.println("filename:"+filename);

        //指定上传到哪里 - 绝对地址
        String path = request.getServletContext().getRealPath("/imgs/");

        ///Users/admin/Documents/success/teaching/wksp/springboot-cg/src/main/webapp/imgs/
        System.out.println("path:"+path);

        //重新处理一下图片的名称 - 为了保持唯一性
        filename = UUID.randomUUID().toString()+filename;

        System.out.println("filename:"+filename);

        //拼接出新的图片的地址
        String newPath = path+filename;

        //1 - 新的文件长传到newPath中
        //构建一个File实例
        File f = new File(newPath);

        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String imgUrl="/imgs/"+filename;
        request.setAttribute("imgUrl",imgUrl);
        //2 - 更新product中的img_url

        return new Result("200","图片上传成功",filename);
    }

    @RequestMapping("/update")
    public String updateBook(Book book, HttpSession session){
        int flag;
        String action = (String) session.getAttribute("action");
        System.out.println(action);
        if (action.equals("update")){
            flag=adminService.updateBook(book);

            if (flag==1){
                session.setAttribute("result",200);
                return "redirect:/admin/adminbook";
            }
        }else if(action.equals("add")){

            Book book1=adminService.getBookById(book.getB_id());
            if(book1==null){
                flag=adminService.insertBook(book);
                if (flag==1){
                    session.setAttribute("result",200);
                }

            }else{
                session.setAttribute("result",404);
            }

        }

        return "redirect:/admin/adminbook";
    }
}
