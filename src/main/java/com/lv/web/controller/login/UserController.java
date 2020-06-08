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

import javax.validation.Valid;
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
    public Map register(@Valid @RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            User userByMobile = userService.getUserByMobile(user.getMobile());
            if (null == userByMobile) {
                userService.addUser(user);
                result.put(CommonsKey.CODE, StatusEnum.SUCCESS.getStatus());
                result.put(CommonsKey.MSG, "注册成功");
            } else {
                result.put(CommonsKey.CODE, StatusEnum.FAIL.getStatus());
                result.put(CommonsKey.MSG, "该手机号已经被注册");
            }
            return result;
        } catch (Exception e) {
            logger.error("注册失败", e);
            e.printStackTrace();
            result.put(CommonsKey.CODE, StatusEnum.DISPOSE_FAILED.getStatus());
            result.put(CommonsKey.MSG, "注册失败");
        }
        return result;
    }

    /**
     * 用户更新(后期功能)
     *
     * @param user
     * @return
     */
    @PostMapping("/user/update")
    public Map updateUser(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.updateUser(user);
            result.put(CommonsKey.CODE, StatusEnum.FAIL.getStatus());
            result.put(CommonsKey.MSG, "该手机号已经被注册");
            return result;
        } catch (Exception e) {
            logger.error("更新用户信息失败", e);
            e.printStackTrace();
            result.put(CommonsKey.CODE, StatusEnum.DISPOSE_FAILED.getStatus());
            result.put(CommonsKey.MSG, "更新用户信息失败");
        }
        return result;
    }

    /**
     * 用户信息获取(后期功能)
     *
     * @param user
     * @return
     */
    @PostMapping("/user/get")
    public Map getUser(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            User userById = userService.getUserById(user.getId());
            if (null == userById) {
                result.put(CommonsKey.CODE, StatusEnum.RESULT_DATA_EMPTY.getStatus());
                result.put(CommonsKey.MSG, "没有该用户信息");
            } else {
                result.put(CommonsKey.DATA, userById);
                result.put(CommonsKey.CODE, StatusEnum.SUCCESS.getStatus());
                result.put(CommonsKey.MSG, "获取用户数据成功");
            }
            return result;
        } catch (Exception e) {
            logger.error("获取用户信息失败", e);
            e.printStackTrace();
            result.put(CommonsKey.CODE, StatusEnum.DISPOSE_FAILED.getStatus());
            result.put(CommonsKey.MSG, "获取用户数据失败");
        }
        return result;
    }
}
