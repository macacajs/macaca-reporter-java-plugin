package com.macacajs.reporter.models;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author houseshi
 */
@Data
public class StatsDataModel {
    /**
     *  套件
     */
    private Long suites;
    /**
     * 测试数量
     */
    private Long tests;
    /**
     * 通过数量
     */
    private Long passes;
    /**
     * 挂起数量
     */
    private Long pending;
    /**
     * 失败数量
     */
    private Long failures;
    /**
     * 开始时间
     */
    private LocalDateTime start;
    /**
     * 通过占比
     */
    private Long passPercent;
    /**
     * 挂起占比
     */
    private Long pendingPercent;
    /**
     * 其他状态的
     */
    private Long other;
    private Boolean hasOther;
    /**
     * 跳过的
     */
    private Long skipped;
    private Boolean hasSkipped;
    /**
     * 执行时长
     */
    private Long duration;
    private LocalDateTime end;
}
