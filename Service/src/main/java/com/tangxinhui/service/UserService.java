package com.tangxinhui.service;

import com.tangxinhui.domain.User;

/**
 * 用户service类
 */
public interface UserService {
//    List<User> selectAll(int page, int pageSize);
    User selectUserByUserName(String userName);
//    int selectCount(int pageSize);
//    boolean insert(User user);
//    boolean update(User user);
//    boolean delete(String userid);
}
