package com.ambition.oj.service.impl;

import com.ambition.oj.judge.codesanbox.CodeSandBoxFactory;
import com.ambition.oj.judge.codesanbox.CodeSandBoxProxy;
import com.ambition.oj.judge.codesanbox.CodeSandbox;
import com.ambition.oj.judge.codesanbox.model.ExecuteCodeRequest;
import com.ambition.oj.judge.codesanbox.model.ExecuteCodeResponse;
import com.ambition.oj.judge.codesanbox.model.JudgeInfo;
import com.ambition.oj.model.dto.question.JudgeCase;
import com.ambition.oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.ambition.oj.model.entity.Question;
import com.ambition.oj.model.entity.QuestionSubmit;
import com.ambition.oj.mapper.QuestionSubmitMapper;
import com.ambition.oj.model.enums.QuestionSubmitLanguageEnum;
import com.ambition.oj.service.QuestionService;
import com.ambition.oj.service.QuestionSubmitService;
import com.ambition.oj.utils.GsonUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * <p>
 * 题目提交 服务实现类
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit> implements QuestionSubmitService {


    @Resource
    private QuestionService questionService;

    @Override
    public Integer addQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest) {
        QuestionSubmit questionSubmit = new QuestionSubmit();
        BeanUtils.copyProperties(questionSubmitAddRequest, questionSubmit);
        CodeSandbox codeSandbox = CodeSandBoxFactory.createThirdPartyCodeSandbox("remote");
        codeSandbox = new CodeSandBoxProxy(codeSandbox);
        String code = questionSubmitAddRequest.getCode();
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
//        根据题目id获取题目信息
        Long questionId = questionSubmitAddRequest.getQuestionId();
        Question questionInfo = questionService.getById(questionId);
        String judgeCaseStr = questionInfo.getJudgeCase();
        // 将judgeCase转换成List<JudgeCase>
        // [{"input":"123","output":"21new Gson();
        Gson gson = GsonUtils.getGson();
        List<JudgeCase> judgeCaseList = gson.fromJson(judgeCaseStr, new TypeToken<List<JudgeCase>>() {
        }.getType());
        String inputStr = "";
        String outputStr = "";
        for (JudgeCase jc : judgeCaseList) {
            inputStr += jc.getInput() + " ";
            outputStr += jc.getOutput() + " ";
        }

//        List<String> inputList = Arrays.asList("1 2", "3 4");
        List<String> inputList = Arrays.asList(inputStr, outputStr);
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        // 将 executeCode 包装在 CompletableFuture 中

        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        String json = GsonUtils.getGson().toJson(executeCodeResponse);
        questionSubmit.setJudgeInfo(json);
        return baseMapper.insert(questionSubmit);
    }


}
