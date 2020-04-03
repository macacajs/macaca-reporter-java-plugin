package com.macacajs.reporter.models;

import lombok.Data;

import java.util.List;

/**
 * @program: macaca-reporter-plugin
 * @description: 首页
 * @author: shixing
 * @create: 2020-04-02 20:15
 **/
@Data
public class CurrentModle {
    private String image;
    private List<CaseModel> list;

}
