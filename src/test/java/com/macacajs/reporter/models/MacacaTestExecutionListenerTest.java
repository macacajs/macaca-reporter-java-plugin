package com.macacajs.reporter.models;

import com.macacajs.reporter.MacacaTestExecutionListener;
import org.junit.Test;
import java.io.IOException;

/**
 * @program: macaca-reporter-plugin
 * @description: test
 * @author: shixing
 * @create: 2020-04-02 20:36
 **/
public class MacacaTestExecutionListenerTest {
    String macacaReportJs = "module.exports = {\n" +
            "  \"stats\": {\n" +
            "    \"suites\": 0,\n" +
            "    \"tests\": 0,\n" +
            "    \"passes\": 0,\n" +
            "    pending: 0,\n" +
            "    failures: 0,\n" +
            "    start: new Date(),\n" +
            "    passPercent: 0,\n" +
            "    pendingPercent: 0,\n" +
            "    other: 0,\n" +
            "    hasOther: false,\n" +
            "    skipped: 1,\n" +
            "    hasSkipped: false,\n" +
            "    duration: 0,\n" +
            "    end: new Date()\n" +
            "  },\n" +
            "  suites: {\n" +
            "    \"title\": \"\",\n" +
            "    \"ctx\": {},\n" +
            "    \"suites\": [\n" +
            "      {\n" +
            "        \"title\": \"macaca-test/desktop-browser-sample.test.js\",\n" +
            "        \"ctx\": {\n" +
            "          \"_runnable\": {\n" +
            "            \"title\": \"\\\"after all\\\" hook\",\n" +
            "            \"body\": \"function () {\\n    opn(path.join(__dirname, '..', 'reports', 'index.html'));\\n  }\",\n" +
            "            \"async\": 0,\n" +
            "            \"sync\": true,\n" +
            "            \"_timeout\": 300000,\n" +
            "            \"_slow\": 75,\n" +
            "            \"_enableTimeouts\": true,\n" +
            "            \"timedOut\": false,\n" +
            "            \"_trace\": {},\n" +
            "            \"_retries\": -1,\n" +
            "            \"_currentRetry\": 0,\n" +
            "            \"pending\": false,\n" +
            "            \"type\": \"hook\",\n" +
            "            \"parent\": \"[Circular ~.suites.0]\",\n" +
            "            \"ctx\": \"[Circular ~.suites.0.ctx]\",\n" +
            "            \"_events\": {},\n" +
            "            \"_eventsCount\": 1,\n" +
            "            \"duration\": 4,\n" +
            "            \"_error\": null\n" +
            "          },\n" +
            "          \"test\": {\n" +
            "            \"title\": \"\\\"after all\\\" hook\",\n" +
            "            \"body\": \"function () {\\n    opn(path.join(__dirname, '..', 'reports', 'index.html'));\\n  }\",\n" +
            "            \"async\": 0,\n" +
            "            \"sync\": true,\n" +
            "            \"_timeout\": 300000,\n" +
            "            \"_slow\": 75,\n" +
            "            \"_enableTimeouts\": true,\n" +
            "            \"timedOut\": false,\n" +
            "            \"_trace\": {},\n" +
            "            \"_retries\": -1,\n" +
            "            \"_currentRetry\": 0,\n" +
            "            \"pending\": false,\n" +
            "            \"type\": \"hook\",\n" +
            "            \"parent\": \"[Circular ~.suites.0]\",\n" +
            "            \"ctx\": \"[Circular ~.suites.0.ctx]\",\n" +
            "            \"_events\": {},\n" +
            "            \"_eventsCount\": 1,\n" +
            "            \"duration\": 4,\n" +
            "            \"_error\": null\n" +
            "          }\n" +
            "        },\n" +
            "        \"suites\": [\n" +
            "          {\n" +
            "            \"title\": \"macaca desktop sample\",\n" +
            "            \"ctx\": {\n" +
            "              \"_runnable\": {\n" +
            "                \"title\": \"\\\"after all\\\" hook\",\n" +
            "                \"body\": \"() => {\\n      return driver\\n        .quit();\\n    }\",\n" +
            "                \"async\": 0,\n" +
            "                \"sync\": true,\n" +
            "                \"_timeout\": 300000,\n" +
            "                \"_slow\": 75,\n" +
            "                \"_enableTimeouts\": true,\n" +
            "                \"timedOut\": false,\n" +
            "                \"_trace\": {},\n" +
            "                \"_retries\": -1,\n" +
            "                \"_currentRetry\": 0,\n" +
            "                \"pending\": false,\n" +
            "                \"type\": \"hook\",\n" +
            "                \"parent\": \"[Circular ~.suites.0.suites.0]\",\n" +
            "                \"ctx\": \"[Circular ~.suites.0.suites.0.ctx]\",\n" +
            "                \"_events\": {},\n" +
            "                \"_eventsCount\": 1,\n" +
            "                \"timer\": {\n" +
            "                  \"0\": null,\n" +
            "                  \"_called\": false,\n" +
            "                  \"_idleTimeout\": -1,\n" +
            "                  \"_idlePrev\": null,\n" +
            "                  \"_idleNext\": null,\n" +
            "                  \"_idleStart\": 58337,\n" +
            "                  \"_onTimeout\": null,\n" +
            "                  \"_repeat\": null\n" +
            "                },\n" +
            "                \"duration\": 7,\n" +
            "                \"_error\": null\n" +
            "              },\n" +
            "              \"test\": {\n" +
            "                \"title\": \"\\\"after all\\\" hook\",\n" +
            "                \"body\": \"() => {\\n      return driver\\n        .quit();\\n    }\",\n" +
            "                \"async\": 0,\n" +
            "                \"sync\": true,\n" +
            "                \"_timeout\": 300000,\n" +
            "                \"_slow\": 75,\n" +
            "                \"_enableTimeouts\": true,\n" +
            "                \"timedOut\": false,\n" +
            "                \"_trace\": {},\n" +
            "                \"_retries\": -1,\n" +
            "                \"_currentRetry\": 0,\n" +
            "                \"pending\": false,\n" +
            "                \"type\": \"hook\",\n" +
            "                \"parent\": \"[Circular ~.suites.0.suites.0]\",\n" +
            "                \"ctx\": \"[Circular ~.suites.0.suites.0.ctx]\",\n" +
            "                \"_events\": {},\n" +
            "                \"_eventsCount\": 1,\n" +
            "                \"timer\": {\n" +
            "                  \"0\": null,\n" +
            "                  \"_called\": false,\n" +
            "                  \"_idleTimeout\": -1,\n" +
            "                  \"_idlePrev\": null,\n" +
            "                  \"_idleNext\": null,\n" +
            "                  \"_idleStart\": 58337,\n" +
            "                  \"_onTimeout\": null,\n" +
            "                  \"_repeat\": null\n" +
            "                },\n" +
            "                \"duration\": 7,\n" +
            "                \"_error\": null\n" +
            "              }\n" +
            "            },\n" +
            "            \"suites\": [],\n" +
            "            \"tests\": [\n" +
            "              {\n" +
            "                \"title\": \"#0 should be ok\",\n" +
            "                \"fullTitle\": \"macaca desktop sample--#0 should be ok\",\n" +
            "                \"duration\": 7509,\n" +
            "                \"state\": \"passed\",\n" +
            "                \"pass\": true,\n" +
            "                \"fail\": false,\n" +
            "                \"pending\": false,\n" +
            "                \"context\": \"\\\"https://avatars1.githubusercontent.com/u/9263023?v=4&s=460\\\"\",\n" +
            "                \"code\": \"const url = path.join(__dirname, './pages/desktop-sample.html');\\nreturn driver\\n  .get(`file://${url}`)\\n  .sleep(3000)\\n  .execute(`document.querySelector('#select').selectedIndex = 1`)\\n  .sleep(1000)\\n  .elementById('select')\\n  /*\\n  .getProperty('value')\\n  .then(value => {\\n    value.should.be.equal('2');\\n  })\\n  */\\n  .execute(`\\n    var element = document.querySelector('#hover_text');\\n    var event = document.createEvent('MouseEvent');\\n    event.initMouseEvent('mouseover', true, true);\\n    element.dispatchEvent(event);\\n  `)\\n  .elementById('hover_text')\\n  .getComputedCss('color')\\n  .then(value => {\\n    value.should.containEql('255');\\n  })\\n  // https://github.com/macacajs/macaca-electron#windowalert\\n  .execute(`\\n    var e = document.createElement('div');\\n    e.id = 'alert_msg';\\n    window.alert = function() {\\n      e.innerHTML = JSON.stringify(arguments[0]);\\n      document.body.appendChild(e);\\n    };\\n  `)\\n  .elementById('alert_button')\\n  .click()\\n  .elementById('alert_msg')\\n  .text()\\n  .then(value => {\\n    value.should.containEql('this message is from alert');\\n  })\\n  .sleep(3000);\",\n" +
            "                \"uuid\": \"03dacaa9-a969-4f88-bebd-5141fbe35cba\",\n" +
            "                \"skipped\": false\n" +
            "              },\n" +
            "              {\n" +
            "                \"title\": \"#1 should works with online pages\",\n" +
            "                \"fullTitle\": \"macaca desktop sample--#1 should works with online pages\",\n" +
            "                \"duration\": 20880,\n" +
            "                \"state\": \"passed\",\n" +
            "                \"pass\": true,\n" +
            "                \"fail\": false,\n" +
            "                \"pending\": false,\n" +
            "                \"context\": \"\\\"https://avatars1.githubusercontent.com/u/9263023?v=4&s=460\\\"\",\n" +
            "                \"code\": \"const initialURL = 'https://www.baidu.com';\\nreturn driver\\n  .get(initialURL)\\n  .sleep(3000)\\n  .elementById('kw')\\n  .sendKeys('macaca')\\n  .sleep(3000)\\n  .elementById('su')\\n  .click()\\n  .sleep(5000)\\n  .source()\\n  .then(function(html) {\\n    html.should.containEql('macaca');\\n  })\\n  .hasElementByCss('#head > div.head_wrapper')\\n  .then(function(hasHeadWrapper) {\\n    hasHeadWrapper.should.be.true();\\n  })\\n  .elementByXPathOrNull('//*[@id=\\\"kw\\\"]')\\n  .sendKeys(' elementByXPath')\\n  .sleep(3000)\\n  .elementById('su')\\n  .click()\\n  .sleep(5000)\\n  .saveScreenshot('pic1');\",\n" +
            "                \"uuid\": \"3ac3ba51-b26a-4fa6-9bd0-9fff568347ea\",\n" +
            "                \"skipped\": false\n" +
            "              },\n" +
            "              {\n" +
            "                \"title\": \"#2 should works with web\",\n" +
            "                \"fullTitle\": \"macaca desktop sample--#2 should works with web\",\n" +
            "                \"duration\": 12791,\n" +
            "                \"state\": \"passed\",\n" +
            "                \"pass\": true,\n" +
            "                \"fail\": false,\n" +
            "                \"pending\": false,\n" +
            "                \"context\": \"\\\"https://avatars1.githubusercontent.com/u/9263023?v=4&s=460\\\"\",\n" +
            "                \"code\": \"const initialURL = 'https://www.baidu.com';\\nreturn driver\\n  .get(initialURL)\\n  .sleep(3000)\\n  .elementById('kw')\\n  .sendKeys('Macaca')\\n  .sleep(3000)\\n  .elementById('su')\\n  .click()\\n  .sleep(5000)\\n  .source()\\n  .then(function(html) {\\n    html.should.containEql('Macaca');\\n  })\\n  .saveScreenshot('pic2');\",\n" +
            "                \"uuid\": \"0fadd3ca-8172-40a1-bf86-962d3a809bc8\",\n" +
            "                \"skipped\": false\n" +
            "              },\n" +
            "              {\n" +
            "                \"title\": \"#3 should works with iframe\",\n" +
            "                \"fullTitle\": \"macaca desktop sample--#3 should works with iframe\",\n" +
            "                \"duration\": 6994,\n" +
            "                \"state\": \"passed\",\n" +
            "                \"pass\": true,\n" +
            "                \"fail\": false,\n" +
            "                \"pending\": false,\n" +
            "                \"context\": \"\\\"https://avatars1.githubusercontent.com/u/9263023?v=4&s=460\\\"\",\n" +
            "                \"code\": \"const iframeURL = 'https://xudafeng.github.io/use-tinyMce-textEditor/';\\nreturn driver\\n  .get(iframeURL)\\n  .sleep(3000)\\n  .frame('mce_0_ifr')\\n  .elementById('tinymce')\\n  .sendKeys('这是一段测试')\\n  .sleep(3000)\\n  .takeScreenshot()\\n  .then(imgData => {\\n    const newImg = new Buffer(imgData, 'base64');\\n    const screenshotFolder = path.resolve(__dirname, '../screenshot');\\n    fs.writeFileSync(path.join(screenshotFolder, 'diff.png'), newImg.toString('binary'), 'binary')\\n    const oldImgPath = path.join(screenshotFolder, 'origin.png');\\n    const diffImgPath = path.join(screenshotFolder, 'diff.png');\\n    return true || diffImage(oldImgPath, newImg, 0.1, diffImgPath);\\n  })\\n  .then(result => {\\n    result.should.be.true();\\n  })\\n  .catch(e => {\\n    console.log(e);\\n  });\",\n" +
            "                \"uuid\": \"5797160a-75e5-4ab8-a6d4-ab1291e2973e\",\n" +
            "                \"skipped\": false\n" +
            "              }\n" +
            "            ],\n" +
            "            \"pending\": [],\n" +
            "            \"_beforeEach\": [],\n" +
            "            \"_beforeAll\": [],\n" +
            "            \"_afterEach\": [],\n" +
            "            \"_afterAll\": [\n" +
            "              {\n" +
            "                \"title\": \"\\\"after all\\\" hook\",\n" +
            "                \"body\": \"() => {\\n      return driver\\n        .quit();\\n    }\",\n" +
            "                \"async\": 0,\n" +
            "                \"sync\": true,\n" +
            "                \"_timeout\": 300000,\n" +
            "                \"_slow\": 75,\n" +
            "                \"_enableTimeouts\": true,\n" +
            "                \"timedOut\": false,\n" +
            "                \"_trace\": {},\n" +
            "                \"_retries\": -1,\n" +
            "                \"_currentRetry\": 0,\n" +
            "                \"pending\": false,\n" +
            "                \"type\": \"hook\",\n" +
            "                \"parent\": \"[Circular ~.suites.0.suites.0]\",\n" +
            "                \"ctx\": {\n" +
            "                  \"_runnable\": \"[Circular ~.suites.0.suites.0._afterAll.0]\",\n" +
            "                  \"test\": \"[Circular ~.suites.0.suites.0._afterAll.0]\"\n" +
            "                },\n" +
            "                \"_events\": {},\n" +
            "                \"_eventsCount\": 1,\n" +
            "                \"timer\": {\n" +
            "                  \"0\": null,\n" +
            "                  \"_called\": false,\n" +
            "                  \"_idleTimeout\": -1,\n" +
            "                  \"_idlePrev\": null,\n" +
            "                  \"_idleNext\": null,\n" +
            "                  \"_idleStart\": 58337,\n" +
            "                  \"_onTimeout\": null,\n" +
            "                  \"_repeat\": null\n" +
            "                },\n" +
            "                \"duration\": 7,\n" +
            "                \"_error\": null\n" +
            "              }\n" +
            "            ],\n" +
            "            \"root\": false,\n" +
            "            \"_timeout\": 300000,\n" +
            "            \"_enableTimeouts\": true,\n" +
            "            \"_slow\": 75,\n" +
            "            \"_retries\": -1,\n" +
            "            \"delayed\": false,\n" +
            "            \"parent\": \"[Circular ~.suites.0]\",\n" +
            "            \"file\": \"/macaca-test/desktop-browser-sample.test.js\",\n" +
            "            \"uuid\": \"529deb90-76b1-4962-995d-bf6797e84ce6\",\n" +
            "            \"fullFile\": \"macaca-test/desktop-browser-sample.test.js\",\n" +
            "            \"passes\": [\n" +
            "              {\n" +
            "                \"title\": \"#0 should be ok\",\n" +
            "                \"fullTitle\": \"macaca desktop sample--#0 should be ok\",\n" +
            "                \"duration\": 7509,\n" +
            "                \"state\": \"passed\",\n" +
            "                \"pass\": true,\n" +
            "                \"fail\": false,\n" +
            "                \"pending\": false,\n" +
            "                \"context\": \"\\\"https://avatars1.githubusercontent.com/u/9263023?v=4&s=460\\\"\",\n" +
            "                \"code\": \"const url = path.join(__dirname, './pages/desktop-sample.html');\\nreturn driver\\n  .get(`file://${url}`)\\n  .sleep(3000)\\n  .execute(`document.querySelector('#select').selectedIndex = 1`)\\n  .sleep(1000)\\n  .elementById('select')\\n  /*\\n  .getProperty('value')\\n  .then(value => {\\n    value.should.be.equal('2');\\n  })\\n  */\\n  .execute(`\\n    var element = document.querySelector('#hover_text');\\n    var event = document.createEvent('MouseEvent');\\n    event.initMouseEvent('mouseover', true, true);\\n    element.dispatchEvent(event);\\n  `)\\n  .elementById('hover_text')\\n  .getComputedCss('color')\\n  .then(value => {\\n    value.should.containEql('255');\\n  })\\n  // https://github.com/macacajs/macaca-electron#windowalert\\n  .execute(`\\n    var e = document.createElement('div');\\n    e.id = 'alert_msg';\\n    window.alert = function() {\\n      e.innerHTML = JSON.stringify(arguments[0]);\\n      document.body.appendChild(e);\\n    };\\n  `)\\n  .elementById('alert_button')\\n  .click()\\n  .elementById('alert_msg')\\n  .text()\\n  .then(value => {\\n    value.should.containEql('this message is from alert');\\n  })\\n  .sleep(3000);\",\n" +
            "                \"uuid\": \"03dacaa9-a969-4f88-bebd-5141fbe35cba\",\n" +
            "                \"skipped\": false\n" +
            "              },\n" +
            "              {\n" +
            "                \"title\": \"#1 should works with online pages\",\n" +
            "                \"fullTitle\": \"macaca desktop sample--#1 should works with online pages\",\n" +
            "                \"duration\": 20880,\n" +
            "                \"state\": \"passed\",\n" +
            "                \"pass\": true,\n" +
            "                \"fail\": false,\n" +
            "                \"pending\": false,\n" +
            "                \"context\": \"\\\"https://avatars1.githubusercontent.com/u/9263023?v=4&s=460\\\"\",\n" +
            "                \"code\": \"const initialURL = 'https://www.baidu.com';\\nreturn driver\\n  .get(initialURL)\\n  .sleep(3000)\\n  .elementById('kw')\\n  .sendKeys('macaca')\\n  .sleep(3000)\\n  .elementById('su')\\n  .click()\\n  .sleep(5000)\\n  .source()\\n  .then(function(html) {\\n    html.should.containEql('macaca');\\n  })\\n  .hasElementByCss('#head > div.head_wrapper')\\n  .then(function(hasHeadWrapper) {\\n    hasHeadWrapper.should.be.true();\\n  })\\n  .elementByXPathOrNull('//*[@id=\\\"kw\\\"]')\\n  .sendKeys(' elementByXPath')\\n  .sleep(3000)\\n  .elementById('su')\\n  .click()\\n  .sleep(5000)\\n  .saveScreenshot('pic1');\",\n" +
            "                \"uuid\": \"3ac3ba51-b26a-4fa6-9bd0-9fff568347ea\",\n" +
            "                \"skipped\": false\n" +
            "              },\n" +
            "              {\n" +
            "                \"title\": \"#2 should works with web\",\n" +
            "                \"fullTitle\": \"macaca desktop sample--#2 should works with web\",\n" +
            "                \"duration\": 12791,\n" +
            "                \"state\": \"passed\",\n" +
            "                \"pass\": true,\n" +
            "                \"fail\": false,\n" +
            "                \"pending\": false,\n" +
            "                \"context\": \"\\\"https://avatars1.githubusercontent.com/u/9263023?v=4&s=460\\\"\",\n" +
            "                \"code\": \"const initialURL = 'https://www.baidu.com';\\nreturn driver\\n  .get(initialURL)\\n  .sleep(3000)\\n  .elementById('kw')\\n  .sendKeys('Macaca')\\n  .sleep(3000)\\n  .elementById('su')\\n  .click()\\n  .sleep(5000)\\n  .source()\\n  .then(function(html) {\\n    html.should.containEql('Macaca');\\n  })\\n  .saveScreenshot('pic2');\",\n" +
            "                \"uuid\": \"0fadd3ca-8172-40a1-bf86-962d3a809bc8\",\n" +
            "                \"skipped\": false\n" +
            "              },\n" +
            "              {\n" +
            "                \"title\": \"#3 should works with iframe\",\n" +
            "                \"fullTitle\": \"macaca desktop sample--#3 should works with iframe\",\n" +
            "                \"duration\": 6994,\n" +
            "                \"state\": \"passed\",\n" +
            "                \"pass\": true,\n" +
            "                \"fail\": false,\n" +
            "                \"pending\": false,\n" +
            "                \"context\": \"\\\"https://avatars1.githubusercontent.com/u/9263023?v=4&s=460\\\"\",\n" +
            "                \"code\": \"const iframeURL = 'https://xudafeng.github.io/use-tinyMce-textEditor/';\\nreturn driver\\n  .get(iframeURL)\\n  .sleep(3000)\\n  .frame('mce_0_ifr')\\n  .elementById('tinymce')\\n  .sendKeys('这是一段测试')\\n  .sleep(3000)\\n  .takeScreenshot()\\n  .then(imgData => {\\n    const newImg = new Buffer(imgData, 'base64');\\n    const screenshotFolder = path.resolve(__dirname, '../screenshot');\\n    fs.writeFileSync(path.join(screenshotFolder, 'diff.png'), newImg.toString('binary'), 'binary')\\n    const oldImgPath = path.join(screenshotFolder, 'origin.png');\\n    const diffImgPath = path.join(screenshotFolder, 'diff.png');\\n    return true || diffImage(oldImgPath, newImg, 0.1, diffImgPath);\\n  })\\n  .then(result => {\\n    result.should.be.true();\\n  })\\n  .catch(e => {\\n    console.log(e);\\n  });\",\n" +
            "                \"uuid\": \"5797160a-75e5-4ab8-a6d4-ab1291e2973e\",\n" +
            "                \"skipped\": false\n" +
            "              }\n" +
            "            ],\n" +
            "            \"failures\": [],\n" +
            "            \"skipped\": [],\n" +
            "            \"totalTests\": 4,\n" +
            "            \"totalPasses\": 4,\n" +
            "            \"totalFailures\": 0,\n" +
            "            \"totalPending\": 0,\n" +
            "            \"totalSkipped\": 0,\n" +
            "            \"duration\": 48174\n" +
            "          }\n" +
            "        ],\n" +
            "        \"tests\": [],\n" +
            "        \"pending\": [],\n" +
            "        \"_beforeEach\": [],\n" +
            "        \"_beforeAll\": [\n" +
            "          {\n" +
            "            \"title\": \"\\\"before all\\\" hook\",\n" +
            "            \"body\": \"() => {\\n    return driver\\n      .init({\\n        platformName: 'desktop',\\n        browserName: browser,\\n        userAgent: `Mozilla/5.0 AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0 Safari/537.36 Macaca Custom UserAgent`,\\n        deviceScaleFactor: 2\\n      })\\n      .setWindowSize(1280, 800);\\n  }\",\n" +
            "            \"async\": 0,\n" +
            "            \"sync\": true,\n" +
            "            \"_timeout\": 300000,\n" +
            "            \"_slow\": 75,\n" +
            "            \"_enableTimeouts\": true,\n" +
            "            \"timedOut\": false,\n" +
            "            \"_trace\": {},\n" +
            "            \"_retries\": -1,\n" +
            "            \"_currentRetry\": 0,\n" +
            "            \"pending\": false,\n" +
            "            \"type\": \"hook\",\n" +
            "            \"parent\": \"[Circular ~.suites.0]\",\n" +
            "            \"ctx\": {\n" +
            "              \"_runnable\": {\n" +
            "                \"title\": \"\\\"after all\\\" hook\",\n" +
            "                \"body\": \"function () {\\n    opn(path.join(__dirname, '..', 'reports', 'index.html'));\\n  }\",\n" +
            "                \"async\": 0,\n" +
            "                \"sync\": true,\n" +
            "                \"_timeout\": 300000,\n" +
            "                \"_slow\": 75,\n" +
            "                \"_enableTimeouts\": true,\n" +
            "                \"timedOut\": false,\n" +
            "                \"_trace\": {},\n" +
            "                \"_retries\": -1,\n" +
            "                \"_currentRetry\": 0,\n" +
            "                \"pending\": false,\n" +
            "                \"type\": \"hook\",\n" +
            "                \"parent\": \"[Circular ~.suites.0]\",\n" +
            "                \"ctx\": \"[Circular ~.suites.0._beforeAll.0.ctx]\",\n" +
            "                \"_events\": {},\n" +
            "                \"_eventsCount\": 1,\n" +
            "                \"duration\": 4,\n" +
            "                \"_error\": null\n" +
            "              },\n" +
            "              \"test\": {\n" +
            "                \"title\": \"\\\"after all\\\" hook\",\n" +
            "                \"body\": \"function () {\\n    opn(path.join(__dirname, '..', 'reports', 'index.html'));\\n  }\",\n" +
            "                \"async\": 0,\n" +
            "                \"sync\": true,\n" +
            "                \"_timeout\": 300000,\n" +
            "                \"_slow\": 75,\n" +
            "                \"_enableTimeouts\": true,\n" +
            "                \"timedOut\": false,\n" +
            "                \"_trace\": {},\n" +
            "                \"_retries\": -1,\n" +
            "                \"_currentRetry\": 0,\n" +
            "                \"pending\": false,\n" +
            "                \"type\": \"hook\",\n" +
            "                \"parent\": \"[Circular ~.suites.0]\",\n" +
            "                \"ctx\": \"[Circular ~.suites.0._beforeAll.0.ctx]\",\n" +
            "                \"_events\": {},\n" +
            "                \"_eventsCount\": 1,\n" +
            "                \"duration\": 4,\n" +
            "                \"_error\": null\n" +
            "              }\n" +
            "            },\n" +
            "            \"_events\": {},\n" +
            "            \"_eventsCount\": 1,\n" +
            "            \"timer\": {\n" +
            "              \"0\": null,\n" +
            "              \"_called\": false,\n" +
            "              \"_idleTimeout\": -1,\n" +
            "              \"_idlePrev\": null,\n" +
            "              \"_idleNext\": null,\n" +
            "              \"_idleStart\": 818,\n" +
            "              \"_onTimeout\": null,\n" +
            "              \"_repeat\": null\n" +
            "            },\n" +
            "            \"duration\": 3254,\n" +
            "            \"_error\": null\n" +
            "          }\n" +
            "        ],\n" +
            "        \"_afterEach\": [\n" +
            "          {\n" +
            "            \"title\": \"\\\"after each\\\" hook\",\n" +
            "            \"body\": \"function () {\\n    return driver\\n      .customSaveScreenshot(this)\\n      .sleep(1000)\\n  }\",\n" +
            "            \"async\": 0,\n" +
            "            \"sync\": true,\n" +
            "            \"_timeout\": 300000,\n" +
            "            \"_slow\": 75,\n" +
            "            \"_enableTimeouts\": true,\n" +
            "            \"timedOut\": false,\n" +
            "            \"_trace\": {},\n" +
            "            \"_retries\": -1,\n" +
            "            \"_currentRetry\": 0,\n" +
            "            \"pending\": false,\n" +
            "            \"type\": \"hook\",\n" +
            "            \"parent\": \"[Circular ~.suites.0]\",\n" +
            "            \"ctx\": {\n" +
            "              \"_runnable\": {\n" +
            "                \"title\": \"\\\"after all\\\" hook\",\n" +
            "                \"body\": \"function () {\\n    opn(path.join(__dirname, '..', 'reports', 'index.html'));\\n  }\",\n" +
            "                \"async\": 0,\n" +
            "                \"sync\": true,\n" +
            "                \"_timeout\": 300000,\n" +
            "                \"_slow\": 75,\n" +
            "                \"_enableTimeouts\": true,\n" +
            "                \"timedOut\": false,\n" +
            "                \"_trace\": {},\n" +
            "                \"_retries\": -1,\n" +
            "                \"_currentRetry\": 0,\n" +
            "                \"pending\": false,\n" +
            "                \"type\": \"hook\",\n" +
            "                \"parent\": \"[Circular ~.suites.0]\",\n" +
            "                \"ctx\": \"[Circular ~.suites.0._afterEach.0.ctx]\",\n" +
            "                \"_events\": {},\n" +
            "                \"_eventsCount\": 1,\n" +
            "                \"duration\": 4,\n" +
            "                \"_error\": null\n" +
            "              },\n" +
            "              \"test\": {\n" +
            "                \"title\": \"\\\"after all\\\" hook\",\n" +
            "                \"body\": \"function () {\\n    opn(path.join(__dirname, '..', 'reports', 'index.html'));\\n  }\",\n" +
            "                \"async\": 0,\n" +
            "                \"sync\": true,\n" +
            "                \"_timeout\": 300000,\n" +
            "                \"_slow\": 75,\n" +
            "                \"_enableTimeouts\": true,\n" +
            "                \"timedOut\": false,\n" +
            "                \"_trace\": {},\n" +
            "                \"_retries\": -1,\n" +
            "                \"_currentRetry\": 0,\n" +
            "                \"pending\": false,\n" +
            "                \"type\": \"hook\",\n" +
            "                \"parent\": \"[Circular ~.suites.0]\",\n" +
            "                \"ctx\": \"[Circular ~.suites.0._afterEach.0.ctx]\",\n" +
            "                \"_events\": {},\n" +
            "                \"_eventsCount\": 1,\n" +
            "                \"duration\": 4,\n" +
            "                \"_error\": null\n" +
            "              }\n" +
            "            },\n" +
            "            \"_events\": {},\n" +
            "            \"_eventsCount\": 1,\n" +
            "            \"timer\": {\n" +
            "              \"0\": null,\n" +
            "              \"_called\": false,\n" +
            "              \"_idleTimeout\": -1,\n" +
            "              \"_idlePrev\": null,\n" +
            "              \"_idleNext\": null,\n" +
            "              \"_idleStart\": 57014,\n" +
            "              \"_onTimeout\": null,\n" +
            "              \"_repeat\": null\n" +
            "            },\n" +
            "            \"duration\": 1325,\n" +
            "            \"_error\": null\n" +
            "          }\n" +
            "        ],\n" +
            "        \"_afterAll\": [\n" +
            "          {\n" +
            "            \"title\": \"\\\"after all\\\" hook\",\n" +
            "            \"body\": \"function () {\\n    opn(path.join(__dirname, '..', 'reports', 'index.html'));\\n  }\",\n" +
            "            \"async\": 0,\n" +
            "            \"sync\": true,\n" +
            "            \"_timeout\": 300000,\n" +
            "            \"_slow\": 75,\n" +
            "            \"_enableTimeouts\": true,\n" +
            "            \"timedOut\": false,\n" +
            "            \"_trace\": {},\n" +
            "            \"_retries\": -1,\n" +
            "            \"_currentRetry\": 0,\n" +
            "            \"pending\": false,\n" +
            "            \"type\": \"hook\",\n" +
            "            \"parent\": \"[Circular ~.suites.0]\",\n" +
            "            \"ctx\": {\n" +
            "              \"_runnable\": \"[Circular ~.suites.0._afterAll.0]\",\n" +
            "              \"test\": \"[Circular ~.suites.0._afterAll.0]\"\n" +
            "            },\n" +
            "            \"_events\": {},\n" +
            "            \"_eventsCount\": 1,\n" +
            "            \"duration\": 4,\n" +
            "            \"_error\": null\n" +
            "          }\n" +
            "        ],\n" +
            "        \"root\": false,\n" +
            "        \"_timeout\": 300000,\n" +
            "        \"_enableTimeouts\": true,\n" +
            "        \"_slow\": 75,\n" +
            "        \"_retries\": -1,\n" +
            "        \"delayed\": false,\n" +
            "        \"parent\": \"[Circular ~]\",\n" +
            "        \"file\": \"/macaca-test/desktop-browser-sample.test.js\",\n" +
            "        \"uuid\": \"6284a170-c7a4-48ac-8d4a-801d717a5bbc\",\n" +
            "        \"fullFile\": \"macaca-test/desktop-browser-sample.test.js\",\n" +
            "        \"passes\": [],\n" +
            "        \"failures\": [],\n" +
            "        \"skipped\": [],\n" +
            "        \"totalTests\": 0,\n" +
            "        \"totalPasses\": 0,\n" +
            "        \"totalFailures\": 0,\n" +
            "        \"totalPending\": 0,\n" +
            "        \"totalSkipped\": 0,\n" +
            "        \"duration\": 0\n" +
            "      }\n" +
            "    ],\n" +
            "    \"tests\": [],\n" +
            "    \"pending\": [],\n" +
            "    \"_beforeEach\": [],\n" +
            "    \"_beforeAll\": [],\n" +
            "    \"_afterEach\": [],\n" +
            "    \"_afterAll\": [],\n" +
            "    \"root\": true,\n" +
            "    \"_timeout\": 2000,\n" +
            "    \"_enableTimeouts\": true,\n" +
            "    \"_slow\": 75,\n" +
            "    \"_retries\": -1,\n" +
            "    \"delayed\": false,\n" +
            "    \"_events\": {\n" +
            "      \"pre-require\": [\n" +
            "        null,\n" +
            "        null,\n" +
            "        null,\n" +
            "        null\n" +
            "      ]\n" +
            "    },\n" +
            "    \"_eventsCount\": 1,\n" +
            "    \"uuid\": \"590ecd0d-f1c8-4d26-b06d-3d9909f38541\",\n" +
            "    \"fullFile\": \"\",\n" +
            "    \"file\": \"\",\n" +
            "    \"passes\": [],\n" +
            "    \"failures\": [],\n" +
            "    \"skipped\": [],\n" +
            "    \"totalTests\": 0,\n" +
            "    \"totalPasses\": 0,\n" +
            "    \"totalFailures\": 0,\n" +
            "    \"totalPending\": 0,\n" +
            "    \"totalSkipped\": 0,\n" +
            "    \"duration\": 0,\n" +
            "    \"_totalTime\": 48174\n" +
            "  },\n" +
            "  current: {\n" +
            "    image: 'https://macacajs.github.io/macaca-logo/svg/monkey.svg',\n" +
            "    list: [{\n" +
            "      title: 'info1 title',\n" +
            "      value: 'info1 content'\n" +
            "    }, {\n" +
            "      title: 'info2 title',\n" +
            "      value: 'info2 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }, {\n" +
            "      title: 'info3 title',\n" +
            "      value: 'info3 content'\n" +
            "    }]\n" +
            "  }\n" +
            "};\n";

    @Test
    public void reportTest() throws IOException {
        MacacaTestExecutionListener.writeJs("report.js", macacaReportJs);
        MacacaTestExecutionListener.exec2();
    }
}
