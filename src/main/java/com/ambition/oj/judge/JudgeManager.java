package com.ambition.oj.judge;

import com.ambition.oj.judge.codesanbox.model.JudgeInfo;
import com.ambition.oj.judge.codesanbox.strategy.DefaultJudgeStrategy;
import com.ambition.oj.judge.codesanbox.strategy.JavaLanguageJudgeStrategy;
import com.ambition.oj.judge.codesanbox.strategy.JudgeContext;
import com.ambition.oj.judge.codesanbox.strategy.JudgeStrategy;
import com.ambition.oj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * @author Ambition
 * @date 2023/12/5 00:06
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext 上下文
     * @return 判题结果
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
