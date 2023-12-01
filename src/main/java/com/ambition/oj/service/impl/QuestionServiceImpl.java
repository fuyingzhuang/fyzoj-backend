package com.ambition.oj.service.impl;

import com.ambition.oj.model.entity.Question;
import com.ambition.oj.mapper.QuestionMapper;
import com.ambition.oj.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 题目 服务实现类
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

}
