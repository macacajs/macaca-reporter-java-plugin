package com.macacajs.reporter.models;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * 测试套件运行信息
 * @author houseshi
 */
@Data
public class SuitesDataModel {
    private String title;
    private Object ctx;
    private List<SuitesDataModel> suites;
    private List<TestsModel> tests;
    private List<TestsModel> pending;
    @JSONField(name = "_beforeEach")
    private List<EachRunnableModel> beforeEach;
    @JSONField(name = "_beforeAll")
    private List<EachRunnableModel> beforeAll;
    @JSONField(name = "_afterEach")
    private List<EachRunnableModel> afterEach;
    @JSONField(name = "_afterAll")
    private List<EachRunnableModel> afterAll;
    private Boolean root;
    @JSONField(name = "_timeout")
    private Long timeout;
    @JSONField(name = "_enableTimeouts")
    private Boolean enableTimeouts;
    @JSONField(name = "_slow")
    private Long slow;
    @JSONField(name = "_retries")
    private Long retries;
    @JSONField(name = "_onlyTests")
    private List<TestsModel> onlyTests;
    @JSONField(name = "_onlySuites")
    private List<TestsModel> onlySuites;
    private Boolean delayed;
    private String parent;
    private Object events;
    private Long eventsCount;
    private String uuid;
    private String fullFile;
    private String file;
    private List<TestsModel> passes;
    private List<TestsModel> failures;
    private List<TestsModel> skipped;
    private Long totalTests;
    private Long totalPasses;
    private Long totalFailures;
    private Long totalPending;
    private Long totalSkipped;
    private Long duration;
    @JSONField(name = "_totalTime")
    private Long totalTime;
}
