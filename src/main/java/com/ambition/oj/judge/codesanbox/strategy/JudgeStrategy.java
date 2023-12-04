package com.ambition.oj.judge.codesanbox.strategy;

import com.ambition.oj.judge.codesanbox.model.JudgeInfo;

/**
 * @author Ambition
 * @date 2023/12/4 23:51
 * 判题策略 策略模式
 */
public interface JudgeStrategy {
    JudgeInfo doJudge(JudgeContext judgeContext);
}
