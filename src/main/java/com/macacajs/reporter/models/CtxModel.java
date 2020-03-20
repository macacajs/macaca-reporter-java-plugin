package com.macacajs.reporter.models;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * SuitesDateTestModle . ctx
 * @author houseshi
 */
@Data
public class CtxModel {
    @JSONField(name = "_runnable")
    private EachRunnableModel runnable;
    private String test;
}
