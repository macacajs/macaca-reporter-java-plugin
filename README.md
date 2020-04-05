
# macaca-reporter-plugin

Macaca Reporter Plugin For Java
<p align="center">
  <a href="//macacajs.github.io">
    <img
      alt="Macaca"
      src="https://macacajs.github.io/macaca-logo/svg/monkey.svg"
      width="200"
    />
  </a>
</p>

---

[Official Site](//macacajs.github.io/macaca-reporter/)

[![NPM version][npm-image]][npm-url]
[![build status][travis-image]][travis-url]
[![Test coverage][coveralls-image]][coveralls-url]
[![npm download][download-image]][download-url]

[npm-image]: https://img.shields.io/npm/v/macaca-reporter.svg?style=flat-square
[npm-url]: https://npmjs.org/package/macaca-reporter
[travis-image]: https://img.shields.io/travis/macacajs/macaca-reporter.svg?style=flat-square
[travis-url]: https://travis-ci.org/macacajs/macaca-reporter
[coveralls-image]: https://img.shields.io/coveralls/macacajs/macaca-reporter.svg?style=flat-square
[coveralls-url]: https://coveralls.io/r/macacajs/macaca-reporter?branch=master
[download-image]: https://img.shields.io/npm/dm/macaca-reporter.svg?style=flat-square
[download-url]: https://npmjs.org/package/macaca-reporter

---


## 使用方法

  以maven插件的形式进行开发，你只需要在pom文件中引入该插件即可。
  
```xml
        <dependency>
            <groupId>com.macacajs</groupId>
            <artifactId>macaca-reporter-plugin</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
```

## 依赖于junit5的实现
  我们实现了junit5的TestExecutionListener接口，在测试计划运行过程中，抓取测试数据，生成macaca-report所需要的json数据。
  根据 `macaca-reporter -d 'test/fixtures/final` 功能，生成对应的macaca测试报告。

  所以你需要使用mvn的指令去执行测试。

## 测试报告和json的保存位置

  json会保存到当前工程目录的`report.js`文件。
  报告文件也会即时生成保存到当前工程目录的 `/reports/index.html` 。 
  测试运行完成，你只需要查看`/reports/index.html`即可。
  
## 功能

#### 关于截图：

测试运行过程中用例如果执行失败，会在当前工程目录下的 `/screenshot`文件中进行抓取，根据`junit5`的`DisplayName`特性，获取文件名称并检查是否有包含该条测试的截图，将其转换为Base64图片编码，保存到json数据中。
所以建议保存截图使用`DisplayName`的方式命名，否则可能获取不到截图。

如：

```java
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        saveScreen(context.getDisplayName()+"_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()));
    }
```

#### 关于测试面板

我们引入了Macaca Current 的特性，你可以通过mvn命令指定增加项目logo图片。
引入之后会在首页显示出Current Screen 、 Current status两项，你也可以忽略这项功能。

```
mvn test -Dlogo=https://macacajs.github.io/macaca-logo/svg/monkey.svg
```

具体效果可以参考测试类： MacacaTestExecutionListenerTest生成的测试结果。

#### 关于测试计划名称

同测试面板，可以使用mvn进行配置 ，默认名称“Macaca测试报告”
```
mvn test -DplanName=这是一个测试计划名称
```

## 基于gitLab CI自动执行

我们增加了gitLab CI的配置模板，可供参考 。

## Contributors

|[houseshi](https://github.com/houseshi)<br/>|[niaoshuai](https://github.com/niaoshuai)<br/>|
| :---: | :---: | 


<!-- GITCONTRIBUTOR_END -->

## Sample

<div align="center">
  <img src="https://macacajs.github.io/macaca-reporter/assets/6d308bd9gy1fivuatxep5j21kw13dgs6.jpg" />
</div>

## License

The MIT License (MIT)
