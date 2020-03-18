package com.macaca.reporter.models;

import lombok.Data;

/**
 *  ctx . runnable
 */
@Data
public class RunnableModle {
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
    private String file;
    private String parent;
    private String ctx;
    private Object events;
    private Long eventsCount;
    private Object timer;
    private Long duration;
    private String state;
    private Object err;
    private String uuid;
    private String context;

}
