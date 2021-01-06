package czu.qty.bookshop.config;

import czu.qty.bookshop.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 本类用来演示: Springboot扩展springmvc功能
 *
 * @author: success
 * @date: 2020/12/29 1:40 下午
 */
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")//拦截所有的路径
        .excludePathPatterns("/user/**","/css/**","/imgs/**","/plugins/**","/user/send","/user/out","/user/favourite","/book/search","/index","/WEB-INF/pages/Common","/manager/**");

    }
}
