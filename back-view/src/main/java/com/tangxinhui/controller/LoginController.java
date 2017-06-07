package com.tangxinhui.controller;

import com.tangxinhui.constant.*;
import com.tangxinhui.domain.Log;
import com.tangxinhui.domain.User;
import com.tangxinhui.service.LogService;
import com.tangxinhui.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登录与注销
 * Created by xinhu on 2017/5/11.
 */
@Controller
@RequestMapping(value = "/user")
public class LoginController {

    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    /**
     * 登录界面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        String time = CommonDate.getTime24();
        String ip = NetUtil.getIpAddress(request);

        Log log = LogUtil.setLog(null,time,Constants.LOG_TYPE_LOGIN,Constants.LOG_TYPE_LOGIN,ip);
        logService.insert(log);

        return "login";
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String time = CommonDate.getTime24();
        String ip = NetUtil.getIpAddress(request);

        Log log = LogUtil.setLog((String)session.getAttribute("userid"),time,Constants.LOG_TYPE_LOGOUT,Constants.LOG_TYPE_LOGOUT,ip);
        logService.insert(log);

        session.removeAttribute("userid");
        session.removeAttribute("login_status");
        PageMessageUtil.writeMessageToSession(request,Constants.LOGOUT_SUCCESS);
        return "redirect:/user/login";
    }

    /**
     * 登录操作
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request,User user) {
        HttpSession session = request.getSession();

        if(StringUtils.isEmpty(user.getUsername())){
            PageMessageUtil.writeMessageToSession(request,Constants.USERNAME_EMPTY);
            return "redirect:/user/login";
        }
        if(StringUtils.isEmpty(user.getPassword())){
            PageMessageUtil.writeMessageToSession(request,Constants.PASSWORD_EMPTY);
            return "redirect:/user/login";
        }

        User userDb = userService.selectUserByUserName(user.getUsername());

        if (userDb == null) {
            PageMessageUtil.writeMessageToSession(request,Constants.USERNAME_NOT_EXIT);
            return "redirect:/user/login";
        }
        //匹配密码
        if(!userDb.getPassword().equals(DigestUtil.md5Digest(user.getPassword()))){
            PageMessageUtil.writeMessageToSession(request,Constants.PASSWORD_INCORRECT);
            return "redirect:/user/login";
        }

        String time = CommonDate.getTime24();
        String ip = NetUtil.getIpAddress(request);

        Log log = LogUtil.setLog(userDb.getId(),time,Constants.LOG_TYPE_LOGIN,Constants.LOG_DETAIL_USER_LOGIN,ip);
        logService.insert(log);

        session.setAttribute("userid", user.getUsername());
        session.setAttribute("login_status", true);
        userDb.setLasttime(CommonDate.getTime24());
        userService.update(user);

        PageMessageUtil.writeMessageToSession(request,Constants.LOGIN_SUCCESS);
        return "redirect:/chat";
    }
}
