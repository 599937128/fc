package com.lv.web.controller.login;

import com.lv.web.constant.CommonsKey;
import com.lv.web.dto.login.LoginForm;
import com.lv.web.dto.user.User;
import com.lv.web.enums.StatusEnum;
import com.lv.web.service.RedisService;
import com.lv.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    /**
     * 网页端登录
     *
     * @param request
     * @param loginForm
     * @return
     */
    @RequestMapping(value = "/web/login", method = RequestMethod.POST)
    @ResponseBody
    public Map login(HttpServletRequest request, @RequestBody LoginForm loginForm) {
        Map<String, Object> result = new HashMap<>();
        try {
            String validimage = (String) request.getSession().getAttribute("kaptchaSessionKey");
            // 密码登录
            if (validimage != null && validimage.equalsIgnoreCase(loginForm.getValidimage())) {
                //查询当前用户
                String mobile = loginForm.getUserName();
                User user = userService.getUserByUserName(mobile);
                if (user != null && user.getPassWord().endsWith(loginForm.getPwd())) {
                    //保存用户信息
                    request.getSession().setAttribute("currentUserInfo", user);
                    String sessionId = request.getParameter("sessionId");
                    result.put(CommonsKey.CODE, StatusEnum.SUCCESS.getStatus());
                    result.put(CommonsKey.DATA, user);
                    result.put(CommonsKey.MSG, "登录成功");
                } else {
                    result.put(CommonsKey.CODE, StatusEnum.UNAUTHORIZED.getStatus());
                    result.put(CommonsKey.MSG, "用户名或密码错误");
                }
            } else {
                result.put(CommonsKey.CODE, StatusEnum.UNAUTHORIZED.getStatus());
                result.put(CommonsKey.MSG, "图片验证码错误");
            }
        } catch (Exception e) {
            logger.error("登陆异常：", e);
            result.put(CommonsKey.CODE, StatusEnum.DISPOSE_FAILED.getStatus());
            result.put(CommonsKey.MSG, "登陆失败");
        }
        return result;
    }

    /**
     * 跳转到登陆页面
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login/index";
    }

    /**
     * 退出
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/web/logout")
    public String logout(HttpServletRequest request) throws Exception {
        // 清空Session
        request.getSession().invalidate();
        return "redirect:web/toLogin.action";
    }

}
