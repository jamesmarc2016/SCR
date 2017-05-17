package com.tangxinhui.serviceImpl;

import com.tangxinhui.dao.UserDao;
import com.tangxinhui.domain.User;
import com.tangxinhui.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户service实现类
 * Created by xinhu on 2017/5/11.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;
    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    public User selectUserByUserName(String userName) {
        return userDao.selectUserByUserName(userName);
    }
}
