package com.macacajs.reporter.models;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * SuitesDateTestCalssModle . ctx . runnable . Timer
 *
 * @author houseshi
 */
@Data
public class RunnableTimer {
    @JSONField(name = "_idleTimeout")
    private Long idleTimeout;
    @JSONField(name = "_idlePrev")
    private Long idlePrev;
    @JSONField(name = "_idleNext")
    private Long idleNext;
    @JSONField(name = "_idleStart")
    private Long idleStart;
    @JSONField(name = "_onTimeout")
    private Long onTimeout;
    @JSONField(name = "_repeat")
    private Long repeat;
    @JSONField(name = "_destroyed")
    private Boolean destroyed;
}
