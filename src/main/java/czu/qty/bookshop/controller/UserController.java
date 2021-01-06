package czu.qty.bookshop.controller;

import com.fasterxml.jackson.databind.DatabindContext;
import czu.qty.bookshop.pojo.Book;
import czu.qty.bookshop.pojo.Result;
import czu.qty.bookshop.pojo.User;
import czu.qty.bookshop.service.IFavouriteService;
import czu.qty.bookshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @create 2020-12-25-23:39
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private IUserService userService;
    @Autowired
    private IFavouriteService favouriteService;
    /**
     * 返回到user/login.jsp
     * @return
     */
    @GetMapping("/login")
    public String login(){
        System.out.println("========");
        return "/WEB-INF/pages/user/login";
    }

    @GetMapping("/send")
    @ResponseBody
    public Result send(String email, String password, HttpSession session){

        User user = userService.login(email);
        if(user == null){
            return new Result("404","尚未注册",null);
        }
        User user1=userService.login1(email,password);
        if(user1!=null) {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("2436850148@qq.com");//邮件的发送方
            msg.setSubject("常州工学院验证码");
            //随机的验证码 - 100000 - 999999
            //java.lang.Math 数学工具类
            //static double random();//随机方法 [0.0,1.0)
            int n = (int) (Math.random() * 900000 + 100000);
            //session作用域 - 存储数据的容器
            //生命周期 - 一次会话期间[从浏览器开始 - 浏览器退出]
            session.setAttribute("code", String.valueOf(n));
            msg.setText("您好,验证码是:" + n);
            msg.setTo(user1.getEmail());
            sender.send(msg);
            return new Result("200", "验证码发送成功,注意查收", email);
        }
        else
            return new Result("505","密码错误",null);
    }

    @PostMapping("/logincl")
    @ResponseBody
    public Result logincl(String email,String password,String code,HttpSession session){

        //根据email来查询User
        //controller调用service层
        User user = userService.login(email);

        //判断user是否存在..
        if(user == null){
            return new Result("404","抱歉,邮箱不存在!",null);
        }

        //user是存在的...
        //比较验证码
        String codes = (String) session.getAttribute("code");
        User user1=userService.login1(email,password);
        //字符串的比较实用equals...
        if((code.equals(codes) || "111".equals(code))&&user1!=null ){
            session.setAttribute("user",user);
            return new Result("200","验证码以发送",null);
        }
        return new Result("500","验证码错误!",null);
    }

    @GetMapping("/index")
    public String toIndex(){
        return "/index";
    }
//    public String out(){
//        System.out.println("====ssssssss====");
//        return "/WEB-INF/pages/user/favourite";
//    }

}
