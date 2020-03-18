package com.macaca.reporter.models;

import lombok.Data;

@Data
/**
 *  "stats": {
 *     "suites": 5,
 *     "tests": 5,
 *     "passes": 4,
 *     "pending": 0,
 *     "failures": 3,
 *     "start": "2020-03-04T06:29:41.554Z",
 *     "passPercent": 80,
 *     "pendingPercent": 0,
 *     "other": 0,
 *     "hasOther": false,
 *     "skipped": 0,
 *     "hasSkipped": false,
 *     "duration": 90295,
 *     "end": "2020-03-04T06:31:30.348Z"
 *   }
 */
public class StatsDateModel {
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
    private String start;
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
    private String end;
}
