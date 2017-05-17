package com.tangxinhui.controller;

import com.tangxinhui.constant.Constants;
import com.tangxinhui.constant.DigestUtil;
import com.tangxinhui.constant.PageMessageUtil;
import com.tangxinhui.domain.User;
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

    /**
     * 登录界面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
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

        PageMessageUtil.writeMessageToSession(request,Constants.LOGIN_SUCCESS);
        return "redirect:/chat";

//        User user = userService.selectUserByUserid(userid);
//        if (user == null) {
//        } else {
//            if (!user.getPassword().equals(password)) {
//                attributes.addFlashAttribute("error", defined.LOGIN_PASSWORD_ERROR);
//                return "redirect:/user/login";
//            } else {
//                if (user.getStatus() != 1) {
//                    attributes.addFlashAttribute("error", defined.LOGIN_USERID_DISABLED);
//                    return "redirect:/user/login";
//                } else {
//                    logService.insert(logUtil.setLog(userid, date.getTime24(), defined.LOG_TYPE_LOGIN, defined.LOG_DETAIL_USER_LOGIN, netUtil.getIpAddress(request)));
//                    session.setAttribute("userid", userid);
//                    session.setAttribute("login_status", true);
//                    user.setLasttime(date.getTime24());
//                    userService.update(user);
//                    attributes.addFlashAttribute("message", defined.LOGIN_SUCCESS);
//                    return "redirect:/chat";
//                }
//            }
//        }
    }
}
