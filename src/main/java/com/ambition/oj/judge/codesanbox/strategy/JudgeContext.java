package com.ambition.oj.judge.codesanbox.strategy;

import com.ambition.oj.judge.codesanbox.model.JudgeInfo;
import com.ambition.oj.model.dto.question.JudgeCase;
import com.ambition.oj.model.entity.Question;
import com.ambition.oj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * @author Ambition
 * @date 2023/12/4 23:51
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;


}
