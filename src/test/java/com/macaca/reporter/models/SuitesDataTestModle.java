package com.macaca.reporter.models;

import lombok.Data;

/**
 *  "suites": {
 *     "title": "",
 *     "ctx": {},
 *     "suites": [{}，{}}} 此处的对象
 *       ……
 *       }
 */
@Data
public class SuitesDataTestModle {
    private String title;
    private Object ctx;
    private Object[] suites;
    private Object[] tests;
    private Object[]  pending;
    private Object[] beforeEach;
    private Object[] beforeAll;
    private Object[] afterEach;
    private Object[] afterAll;
    private Boolean root;
    private Long timeout;
    private Boolean enableTimeouts;
    private Long slow;
    private Long retries;
    private Object[] onlyTests;
    private Object[] onlySuites;
    private Boolean delayed;
    private String parent;
    private String file;
    private String uuid;
    private String fullFile;
    private Object[] passes;
    private Object[] failures;
    private Object[] skipped;
    private Long totalTests;
    private Long totalPasses;
    private Long totalFailures;
    private Long totalPending;
    private Long totalSkipped;
    private Long duration;
}
