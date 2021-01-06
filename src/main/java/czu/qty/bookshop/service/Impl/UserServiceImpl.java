package czu.qty.bookshop.service.Impl;

import czu.qty.bookshop.mapper.UserMapper;
import czu.qty.bookshop.pojo.User;
import czu.qty.bookshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @create 2020-12-25-22:53
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String email) {
        User user = userMapper.findById(email);
        return user;
    }

    public User login1(String email,String password)
    {
        User user=userMapper.findById1(email,password);
        return user;
    }

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateUser(user.getU_name(), user.getU_password(), user.getEmail(),user.getU_id());
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserById(Integer u_id) {
        return userMapper.getUserById(u_id);
    }

    @Override
    public List<User> getUserByNameFuzzy(String name) {
        return userMapper.getUserFuzzy(name);
    }

    @Override
    public int delUserInfo(Integer u_id) {
        return userMapper.delUser(u_id);
    }
}
