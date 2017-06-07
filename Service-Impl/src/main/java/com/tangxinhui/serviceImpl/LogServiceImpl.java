package com.tangxinhui.serviceImpl;

import com.tangxinhui.constant.StringUtil;
import com.tangxinhui.dao.LogDao;
import com.tangxinhui.domain.Log;
import com.tangxinhui.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xinhu on 2017/5/16.
 */
@Service(value = "logService")
public class LogServiceImpl implements LogService{

    @Resource
    private LogDao logDao;

    public List<Log> selectAll(int page, int pageSize) {
        return logDao.selectAll(page, pageSize);
    }

    public List<Log> selectLogByUserid(String userid, int page, int pageSize) {
        int start = 1;
        int end = pageSize;
        if(page != 1) {
            start = pageSize * (page - 1) + 1;
            end = pageSize * page;
        }
        return logDao.selectLogByUserid(userid, start, end);
    }

    public int selectCount(int pageSize) {
        int pageCount = Integer.parseInt(logDao.selectCount().getUserid());
        return pageCount % pageSize == 0 ? pageCount/pageSize : pageCount/pageSize + 1;
    }

    public int selectCountByUserid(String userid, int pageSize) {
        int pageCount = Integer.parseInt(logDao.selectCountByUserid(userid).getUserid());
        return pageCount % pageSize == 0 ? pageCount/pageSize : pageCount/pageSize + 1;
    }

    public boolean insert(Log log) {
        log.setId(StringUtil.getUuid());
        return logDao.insert(log);
    }

    public boolean delete(String id) {
        return logDao.delete(id);
    }

    public boolean deleteThisUser(String userid) {
        return logDao.deleteThisUser(userid);
    }

    public boolean deleteAll() {
        return logDao.deleteAll();
    }
}
