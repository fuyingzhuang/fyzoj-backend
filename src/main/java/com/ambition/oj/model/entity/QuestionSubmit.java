package com.ambition.oj.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 题目提交
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="QuestionSubmit对象", description="题目提交")
public class QuestionSubmit implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "编程语言")
    private String language;

    @ApiModelProperty(value = "用户代码")
    private String code;

    @ApiModelProperty(value = "判题信息（json 对象）")
    @TableField("judgeInfo")
    private String judgeInfo;

    @ApiModelProperty(value = "判题状态（0 - 待判题、1 - 判题中、2 - 成功、3 - 失败）")
    private Integer status;

    @ApiModelProperty(value = "题目 id")
    @TableField("questionId")
    private Long questionId;

    @ApiModelProperty(value = "创建用户 id")
    @TableField("userId")
    private Long userId;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "是否删除")
    @TableField("isDelete")
    @TableLogic
    private Integer isDelete;


}
