package com.tangxinhui.service;

import com.tangxinhui.domain.Log;

import java.util.List;

/**
 * 日志service
 * Created by xinhu on 2017/5/16.
 */
public interface LogService {
    List<Log> selectAll(int page, int pageSize);
    List<Log> selectLogByUserid(String userid, int page, int pageSize);
    int selectCount(int pageSize);
    int selectCountByUserid(String userid, int pageSize);
    boolean insert(Log log);
    boolean delete(String id);
    boolean deleteThisUser(String userid);
    boolean deleteAll();
}
