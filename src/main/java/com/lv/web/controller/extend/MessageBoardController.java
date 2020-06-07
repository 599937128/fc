package com.lv.web.controller.extend;

import com.lv.web.constant.CommonsKey;
import com.lv.web.dto.messageboard.MessageBoard;
import com.lv.web.dto.user.User;
import com.lv.web.enums.StatusEnum;
import com.lv.web.service.MessageBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (TMessageBoard)表控制层
 *
 * @author makejava
 * @since 2020-06-06 21:50:20
 */
@RestController
@RequestMapping("/")
public class MessageBoardController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 服务对象
     */
    @Autowired
    private MessageBoardService tMessageBoardService;

    /**
     * 留言
     *
     * @param messageBoard
     * @return
     */
    @PostMapping("/message/leave")
    public Map leaveMessage(HttpServletRequest request, @Valid @RequestBody MessageBoard messageBoard) {
        Map<String, Object> result = new HashMap<>();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("currentUserInfo");
            messageBoard.setLeaveUserId(user.getId());
            tMessageBoardService.insert(messageBoard);
            result.put(CommonsKey.CODE, StatusEnum.SUCCESS.getStatus());
            result.put(CommonsKey.MSG, "留言成功");
            return result;
        } catch (Exception e) {
            logger.error("留言失败", e);
            e.printStackTrace();
            result.put(CommonsKey.CODE, StatusEnum.DISPOSE_FAILED.getStatus());
            result.put(CommonsKey.MSG, "留言失败");
        }
        return result;
    }

    /**
     * 获取当前用户的留言板留言信息
     *
     * @param request
     * @return
     */
    @PostMapping("/message/list")
    public Map getMessages(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("currentUserInfo");
            List<MessageBoard> messageBoards = tMessageBoardService.queryAllByUserId(user.getId());
            result.put(CommonsKey.DATA, messageBoards);
            result.put(CommonsKey.CODE, StatusEnum.SUCCESS.getStatus());
            result.put(CommonsKey.MSG, "获取留言列表成功");
            return result;
        } catch (Exception e) {
            logger.error("获取留言列表成功失败", e);
            e.printStackTrace();
            result.put(CommonsKey.CODE, StatusEnum.DISPOSE_FAILED.getStatus());
            result.put(CommonsKey.MSG, "获取留言列表成功失败");
        }
        return result;
    }

    /**
     * 删除留言
     *
     * @param messageBoard
     * @return
     */
    @PostMapping("/message/del")
    public Map delMessage(@Valid @RequestBody MessageBoard messageBoard) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (null == messageBoard.getLeaveUserId()) {
                result.put(CommonsKey.CODE, StatusEnum.FAIL.getStatus());
                result.put(CommonsKey.MSG, "非法操作");
            } else {
                boolean deleteByLeaveUserId = tMessageBoardService.deleteByLeaveUserId(messageBoard.getLeaveUserId());
                if (deleteByLeaveUserId) {
                    result.put(CommonsKey.CODE, StatusEnum.SUCCESS.getStatus());
                    result.put(CommonsKey.MSG, "删除留言成功");
                } else {
                    result.put(CommonsKey.CODE, StatusEnum.FAIL.getStatus());
                    result.put(CommonsKey.MSG, "删除留言失败");
                }
            }
            return result;
        } catch (Exception e) {
            logger.error("留言失败", e);
            e.printStackTrace();
            result.put(CommonsKey.CODE, StatusEnum.DISPOSE_FAILED.getStatus());
            result.put(CommonsKey.MSG, "留言失败");
        }
        return result;
    }


}