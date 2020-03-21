package com.macacajs.reporter.models;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 测试套件运行信息
 * @author houseshi
 */
@Data
public class SuitesDataModel {
    private String title;
    private Object ctx;
    private SuitesDataModel[] suites;
    private Object[] tests;
    private Object[]  pending;
    @JSONField(name = "_beforeEach")
    private Object[] beforeEach;
    @JSONField(name = "_beforeAll")
    private Object[] beforeAll;
    @JSONField(name = "_afterEach")
    private Object[] afterEach;
    @JSONField(name = "_afterAll")
    private Object[] afterAll;
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
    private Object[] onlyTests;
    @JSONField(name = "_onlySuites")
    private Object[] onlySuites;
    private Boolean delayed;
    private String parent;
    private Object events;
    private Long eventsCount;
    private String uuid;
    private String fullFile;
    private String file;
    private Object[] passes;
    private Object[] failures;
    private Object[] skipped;
    private Long totalTests;
    private Long totalPasses;
    private Long totalFailures;
    private Long totalPending;
    private Long totalSkipped;
    private Long duration;
    @JSONField(name = "_totalTime")
    private Long totalTime;
}
