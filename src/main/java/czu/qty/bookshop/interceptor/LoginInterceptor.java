package czu.qty.bookshop.interceptor;

import czu.qty.bookshop.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 本类用来演示: 登录拦截器
 *
 * @author: success
 * @date: 2020/12/29 1:34 下午
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入controller层中的某个方法之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        System.out.println("===进入到了拦截器====");

        //判断session作用域中是否存在user对象
        User user = (User) request.getSession().getAttribute("user");

        if(user == null){
            //原生的servlet的重定向的语法
            response.sendRedirect("/user/login");
            return false;
        }

        //return true;//放行...
        return true;//拦截,禁止往下执行...
    }
}
