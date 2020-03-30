package com.macacajs.reporter.models;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 *  ctx . runnable
 * @author houseshi
 */
@Data
public class RunnableModel {

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
    private String file;
    private String parent;
    private String ctx;
    @JSONField(name = "_events")
    private Object events;
    @JSONField(name = "_eventsCount")
    private Long eventsCount;
    private Object timer;
    private Long duration;
    private String state;
    private Object err;
    private String uuid;
    private String context;
    @JSONField(name = "_error")
    private String error;

}
