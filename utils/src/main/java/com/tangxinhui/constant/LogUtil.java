package com.tangxinhui.constant;

import com.tangxinhui.domain.Log;

/**
 * 日志帮助类
 */
public class LogUtil {

    public static Log setLog(String userid, String time, String type, String detail, String ip){
         Log log = new Log();
        log.setId(StringUtil.getUuid());
        log.setUserid(userid);
        log.setTime(time);
        log.setType(type);
        log.setDetail(detail);
        log.setIp(ip);
        return log;
    }
}
