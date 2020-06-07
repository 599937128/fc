package com.lv.web.controller.login;

import com.lv.web.constant.CommonsKey;
import com.lv.web.dto.login.LoginForm;
import com.lv.web.dto.user.User;
import com.lv.web.enums.StatusEnum;
import com.lv.web.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    /**
     * 网页端登录
     *
     * @param request
     * @param loginForm
     * @return
     */
    @RequestMapping(value = "/web/login", method = RequestMethod.POST)
    public Map login(HttpServletRequest request, @RequestBody LoginForm loginForm) {
        Map<String, Object> result = new HashMap<>();
        try {
            //查询当前用户
            String mobile = loginForm.getMobile();
            User user = userService.getUserByMobile(mobile);
            if (user != null && user.getPwd().equals(DigestUtils.md5Hex(loginForm.getPwd()).toUpperCase())) {
                //保存用户信息
                request.getSession().setAttribute("currentUserInfo", user);
                result.put(CommonsKey.CODE, StatusEnum.SUCCESS.getStatus());
                result.put(CommonsKey.DATA, user);
                result.put(CommonsKey.MSG, "登录成功");
            } else {
                result.put(CommonsKey.CODE, StatusEnum.UNAUTHORIZED.getStatus());
                result.put(CommonsKey.MSG, "用户名或密码错误");
            }
        } catch (Exception e) {
            logger.error("登陆异常：", e);
            result.put(CommonsKey.CODE, StatusEnum.DISPOSE_FAILED.getStatus());
            result.put(CommonsKey.MSG, "登陆失败");
        }
        return result;
    }

    /**
     * 退出
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/web/logout")
    public Map logout(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 删除session中的用户信息
            request.getSession().invalidate();
            result.put(CommonsKey.CODE, StatusEnum.SUCCESS.getStatus());
            result.put(CommonsKey.MSG, "退出成功");
        } catch (Exception e) {
            logger.error("登陆异常：", e);
            result.put(CommonsKey.CODE, StatusEnum.DISPOSE_FAILED.getStatus());
            result.put(CommonsKey.MSG, "退出失败");
        }
        return result;
    }

}
