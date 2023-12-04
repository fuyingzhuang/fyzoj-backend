package com.ambition.oj.judge;

import com.ambition.oj.model.entity.QuestionSubmit;
import com.ambition.oj.model.vo.QuestionSubmitVO;

/**
 * @author Ambition
 * @date 2023/12/4 23:14
 * 判题服务 后续可以单独抽象出来
 */
public interface JudgeService {

    QuestionSubmit doJudge(long questionSubmitId);
}
