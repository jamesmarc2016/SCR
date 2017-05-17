package com.tangxinhui.constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 向页面输出消息
 * Created by xinhu on 2017/5/11.
 */
public class PageMessageUtil {

    /**
     * 输出消息
     * @param request
     * @param msg
     */
    public static void writeMessageToSession(HttpServletRequest request,String msg){
        HttpSession session = request.getSession();
        session.setAttribute("message",msg);
    }
}
