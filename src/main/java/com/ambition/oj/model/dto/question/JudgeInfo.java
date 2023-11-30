package com.ambition.oj.model.dto.question;

import lombok.Data;

/**
 * @author Ambition
 * @date 2023/11/30 23:24
 */
@Data
public class JudgeInfo {

    /**
     * 程序执行信息
     */
    private String message;

    /**
     * 消耗内存
     */
    private Long memory;

    /**
     * 消耗时间（KB）
     */
    private Long time;
}

