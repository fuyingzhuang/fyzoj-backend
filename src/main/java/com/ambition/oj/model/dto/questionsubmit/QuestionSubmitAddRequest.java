package com.ambition.oj.model.dto.questionsubmit;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 题目提交
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;


    private String language;

    private String code;

    private String judgeInfo;

    private Integer status;

    private Long questionId;

    private Long userId;


}
