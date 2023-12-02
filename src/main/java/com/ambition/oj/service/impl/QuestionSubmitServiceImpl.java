package com.ambition.oj.service.impl;

import com.ambition.oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.ambition.oj.model.entity.QuestionSubmit;
import com.ambition.oj.mapper.QuestionSubmitMapper;
import com.ambition.oj.service.QuestionSubmitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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


    @Override
    public Integer addQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest) {
        QuestionSubmit questionSubmit = new QuestionSubmit();
        BeanUtils.copyProperties(questionSubmitAddRequest, questionSubmit);
        // TODO 目前先保存到数据库中 后续需要添加判题机制
        return baseMapper.insert(questionSubmit);
    }


}
