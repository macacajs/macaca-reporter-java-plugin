package com.macaca.reporter.models;

import lombok.Data;


/**
 * _beforeEach \  _beforeAll \ _afterEach \ _afterAll
 */
@Data
public class EachRunnableModle {
    private String title;
    private String body;
    private Long async;
    private Boolean sync;
    private Long timeout;
    private Long slow;
    private Boolean enableTimeouts;
    private Boolean timedOut;
    private Object trace;
    private Long retries;
    private Long currentRetry;
    private Boolean pending;
    private String type;
    private String parent;
    private String ctx;
    private Object events;
    private Long eventsCount;
    private Object timer;
    private Long duration;
    private String error;
}
