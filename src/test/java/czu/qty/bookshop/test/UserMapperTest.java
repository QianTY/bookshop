package czu.qty.bookshop.test;

import czu.qty.bookshop.mapper.UserMapper;
import czu.qty.bookshop.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @create 2020-12-25-14:42
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        List<User> users = userMapper.getUserFuzzy(null);
        for (User user : users){
            System.out.println(user);
        }
//        if (q > 0 ){
//            System.out.println("1111");
//        }
    }

}
