package czu.qty.bookshop.service;

import czu.qty.bookshop.pojo.User;

import java.util.List;

public interface IUserService {
    /**
     * 登录业务 - 根据邮箱查找用户,如果查找不到,则返回null,否则返回表中的单行数据
     * @param email
     * @return
     */
    User login(String email);

    User login1(String email, String password);

    //更新用户信息
    public int updateUserInfo(User user);

    //查看所有用户
    public List<User> getAllUser();

    //根据id查找用户
    public User getUserById(Integer u_id);

    //根据用户名模糊查询用户
    public List<User> getUserByNameFuzzy(String name);

    //根据id删除用户信息
    public int delUserInfo(Integer u_id);
}
