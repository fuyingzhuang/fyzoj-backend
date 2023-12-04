package com.ambition.oj.mapper;

import com.ambition.oj.model.entity.Question;
import com.ambition.oj.model.vo.UserBrowseQuestionVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 题目 Mapper 接口
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
public interface QuestionMapper extends BaseMapper<Question> {

}
