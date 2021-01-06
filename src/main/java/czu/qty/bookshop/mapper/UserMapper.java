package czu.qty.bookshop.mapper;

import czu.qty.bookshop.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @create 2020-12-25-12:54
 */
@Mapper
public interface UserMapper {


    /**
     * 过程:将user表中的所有的数据存储到java内存中的list集合中
     *
     * 查询所有的用户的信息
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
    /**
     * 网站注册的用户名肯定是唯一的.
     *
     * 根据email来查询用户
     * @param email
     * @return 单个用户对象
     */
    User findById(String email);

    User findById1(String email,String password);



    //登录(账号密码)
    @Select("select * from user where u_name=#{u_name} and u_password = #{u_password}")
    User loginByNP(String u_name,String u_password);

    //检查是否注册邮箱
    @Select("select * from where email=#{email}")
    User loginByEmail(String email);

    //查询所有用户
    @Select("select * from user")
    List<User> getAllUser();

    //根据用户id查询用户信息(u_id)
    @Select("select * from user where u_id =#{u_id}")
    User getUserById(Integer u_id);

    //更新用户信息(u_id)
    @Update("update user set(u_name,u_password,email) values(#{u_name},#{u_password},#{email}) where u_id=#{u_id}")
    int updateUser(String u_name,String u_password,String email,Integer u_id);

    //删除用户信息(u_id)
    @Delete("delete from user where u_id=#{u_id}")
    int delUser(Integer u_id);

    //根据用户名模糊查询
    List<User> getUserFuzzy(String u_name);

}
