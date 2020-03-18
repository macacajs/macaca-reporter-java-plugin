package com.macaca.reporter.models;

import lombok.Data;

/**
 * 测试套件运行信息
 */

/*
  "suites": {
    "title": "",
    "ctx": {},
    "suites": [{},{}],
    "tests": [],
    "pending": [],
    "_beforeEach": [],
    "_beforeAll": [],
    "_afterEach": [],
    "_afterAll": [],
    "root": true,
    "_timeout": 2000,
    "_enableTimeouts": true,
    "_slow": 75,
    "_retries": -1,
    "_onlyTests": [],
    "_onlySuites": [],
    "delayed": false,
    "_events": {},
    "_eventsCount": 1,
    "uuid": "b64f1357-2cb2-4687-9bff-f3266f01a6c5",
    "fullFile": "",
    "file": "",
    "passes": [],
    "failures": [],
    "skipped": [],
    "totalTests": 0,
    "totalPasses": 0,
    "totalFailures": 0,
    "totalPending": 0,
    "totalSkipped": 0,
    "duration": 0,
    "_totalTime": 90295
  }
 */
@Data
public class SuitesDataModle {
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
    private Long totalTime;



}
