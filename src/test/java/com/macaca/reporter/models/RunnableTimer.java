package com.macaca.reporter.models;


import lombok.Data;

/**
 * SuitesDateTestCalssModle . ctx . runnable . Timer
 *
 *  *             "timer": {
 *  *               "_idleTimeout": -1,
 *  *               "_idlePrev": null,
 *  *               "_idleNext": null,
 *  *               "_idleStart": 6664,
 *  *               "_onTimeout": null,
 *  *               "_repeat": null,
 *  *               "_destroyed": true
 *  *             },
 */
@Data
public class RunnableTimer {
    private Long idleTimeout;
    private Long idlePrev;
    private Long idleNext;
    private Long idleStart;
    private Long onTimeout;
    private Long repeat;
    private Boolean destroyed;
}
