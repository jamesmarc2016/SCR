package com.tangxinhui.dao;

import com.tangxinhui.domain.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日志dao
 * Created by xinhu on 2017/5/16.
 */
@Service(value = "logDao")
public interface LogDao {

    /**
     * 查找所有日志
     * @param offset
     * @param limit
     * @return
     */
    List<Log> selectAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据用户id查找
     * @param userid
     * @param offset
     * @param limit
     * @return
     */
    List<Log> selectLogByUserid(@Param("userid") String userid, @Param("offset") int offset, @Param("limit") int limit);

    Log selectCount();

    Log selectCountByUserid(@Param("userid") String userid);

    boolean insert(Log log);

    boolean delete(String id);

    boolean deleteThisUser(String userid);

    boolean deleteAll();
}
