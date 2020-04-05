package com.macacajs.reporter.models;


import lombok.Data;

/**
 *                 "title": "#0 should be ok",
 *                         "fullTitle": "macaca-test/desktop-browser-sample.test.js -- macaca desktop sample -- #0 should be ok",
 *                         "duration": 18,
 *                         "state": "failed",
 *                         "pass": false,
 *                         "fail": true,
 *                         "pending": false,
 *                         "context": "\"../screenshots/6f0b3552-4f97-4e71-a1f5-5a81bb035849.png\"",
 *                         "code": "return driver\n  .nlpSection(`\n    访问 https://www.baidu.com\n    等待 3秒\n    在第一个输入框输入 Macaca\n    点击百度一下按钮\n  `);",
 *                         "uuid": "2c6f09ef-069c-4394-bc8d-3da8f403dc2c",
 *                         "skipped": false
 * @author houseshi
 */
@Data
public class TestsModel {
    private String title;
    private String fullTitle;
    private Long duration;
    private String state;
    private Boolean pass;
    private Boolean fail;
    private Boolean pending;
    private String context;
    private String code;
    private String uuid;
    private Boolean skipped;
}
