package com.lv.web.controller.login;

import com.lv.web.constant.CommonsKey;
import com.lv.web.dto.user.User;
import com.lv.web.enums.StatusEnum;
import com.lv.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @PostMapping("/user/register")
    public Map register(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.addUser(user);
            result.put(CommonsKey.CODE, StatusEnum.SUCCESS.getStatus());
            result.put(CommonsKey.MSG, "注册成功");
            return result;
        } catch (Exception e) {
            logger.error("注册失败---{}", e);
            e.printStackTrace();
            result.put(CommonsKey.CODE, StatusEnum.DISPOSE_FAILED.getStatus());
            result.put(CommonsKey.MSG, "注册失败");
        }
        return result;
    }
}
