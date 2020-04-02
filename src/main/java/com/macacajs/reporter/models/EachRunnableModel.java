package com.macacajs.reporter.models;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;


/**
 * _beforeEach \  _beforeAll \ _afterEach \ _afterAll
 * @author houseshi
 */
@Data
public class EachRunnableModel {
    private String title;
    private String body;
    private Long async;
    private Boolean sync;
    @JSONField(name = "_timeout")
    private Long timeout;
    @JSONField(name = "_slow")
    private Long slow;
    @JSONField(name = "_enableTimeouts")
    private Boolean enableTimeouts;
    private Boolean timedOut;
    @JSONField(name = "_trace")
    private Object trace;
    @JSONField(name = "_retries")
    private Long retries;
    @JSONField(name = "_currentRetry")
    private Long currentRetry;
    private Boolean pending;
    private String type;
    private String parent;
    private CtxModel ctx;
    @JSONField(name = "_events")
    private EventsModel events;
    @JSONField(name = "_eventsCount")
    private Long eventsCount;
    private RunnableTimer timer;
    private Long duration;
    private ErrModel err;
    private String uuid;
}
