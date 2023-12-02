package com.ambition.oj.controller;


import co.elastic.clients.elasticsearch.nodes.Http;
import com.ambition.oj.common.BaseResponse;
import com.ambition.oj.common.ErrorCode;
import com.ambition.oj.common.ResultUtils;
import com.ambition.oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.ambition.oj.model.entity.User;
import com.ambition.oj.service.QuestionSubmitService;
import com.ambition.oj.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 题目提交 前端控制器
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@RestController
@RequestMapping("/oj/question/submit")
public class QuestionSubmitController {


    @Resource
    private QuestionSubmitService questionSubmitService;


    @Resource
    private UserService userService;


    /**
     * 用户提交题目
     *
     * @param questionSubmitAddRequest 提交题目的请求
     * @param request                  请求
     * @return 提交结果
     */
    @PostMapping("/submit")
    public BaseResponse addQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                          HttpServletRequest request) {
//      判断当前用户是否登陆
        User loginUser = userService.getLoginUser(request);
//        获取当前的用户id
        Long id = loginUser.getId();
        questionSubmitAddRequest.setUserId(id);
//        调用service层的方法
        Integer result = questionSubmitService.addQuestionSubmit(questionSubmitAddRequest);
        if (result == 0) {
            return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "提交失败");
        } else {
            return ResultUtils.success("提交成功");
        }
    }


}

