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
 * 题目
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Question对象", description="题目")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "标签列表（json 数组）")
    private String tags;

    @ApiModelProperty(value = "题目答案")
    private String answer;

    @ApiModelProperty(value = "题目提交数")
    @TableField("submitNum")
    private Integer submitNum;

    @ApiModelProperty(value = "题目通过数")
    @TableField("acceptedNum")
    private Integer acceptedNum;

    @ApiModelProperty(value = "判题用例（json 数组）")
    @TableField("judgeCase")
    private String judgeCase;

    @ApiModelProperty(value = "判题配置（json 对象）")
    @TableField("judgeConfig")
    private String judgeConfig;

    @ApiModelProperty(value = "点赞数")
    @TableField("thumbNum")
    private Integer thumbNum;

    @ApiModelProperty(value = "收藏数")
    @TableField("favourNum")
    private Integer favourNum;

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
