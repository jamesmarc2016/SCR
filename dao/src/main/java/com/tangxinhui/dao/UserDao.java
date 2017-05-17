package com.tangxinhui.dao;

import com.tangxinhui.domain.User;
import org.springframework.stereotype.Service;

/**
 * 用户dao
 * Created by xinhu on 2017/5/11.
 */
@Service(value = "userDao")
public interface UserDao {

    /**
     * 查找用户
     * @param userName
     * @return
     */
    User selectUserByUserName(String userName);
}
