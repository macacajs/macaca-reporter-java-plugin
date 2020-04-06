package com.macacajs.reporter;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.macacajs.reporter.models.*;
import lombok.SneakyThrows;
import org.junit.platform.engine.TestExecutionResult;

import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

import java.io.*;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;


/**
 * @author niaoshuai & shixing
 */

public class MacacaTestExecutionListener implements TestExecutionListener {
    MacacaReportModel macacaReportModel;
    StatsDataModel planStats;
    SuitesDataModel planSuites;
    CurrentModle currentModle;
    CaseModel caseModel;
    List<CaseModel> caseModels;
    List<SuitesDataModel> testClassSuitesList ;
    SuitesDataModel testClassSuites;
    CtxModel testClassCtxModel;

    /**
     * 测试类对象的列表与对象
      */
    List<SuitesDataModel> caseSuitesList ;
    SuitesDataModel caseSuites;
    /**
     * 前置与后置
     */
    EachRunnableModel eachRunnable;
    /**
     * 测试对象
      */
    TestsModel tests;

    String testPlanId,
            parentId,
            childId,
            planName = getPlanName(),
            logo = getLogo();
    int     passes = 0,
            failures = 0,
            skipped = 0;
    LocalDateTime testStar, testEnd,
            caseSuitesStar , caseSuitesEnd;
    List<TestsModel> testsModelList;
    List<TestsModel> passTestModleList ;
    List<TestsModel> failuresTestModleList ;

    /**
     * 开始执行测试计划
     * @param testPlan
     */
    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        //计划开始
        planStats = new StatsDataModel();
        planSuites = new SuitesDataModel();
        currentModle = new CurrentModle();
        caseModels = new ArrayList<>();
        planStats.setStart(LocalDateTime.now());
        Set<TestIdentifier> setRoots = testPlan.getRoots();
        for(TestIdentifier ti : setRoots){
            testPlanId = ti.getUniqueId();
            if(!testPlanId.isEmpty()){
                return;
            }
        }
    }

    /**
     * 用例执行
     *
     * @param testIdentifier
     */
    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        String uuqueid = testIdentifier.getUniqueId();
        Optional<String> parentOpt = testIdentifier.getParentId();
        String pid = null;
        if(parentOpt.isPresent()){
            pid = parentOpt.get();
        }

        if (pid == null) {
            /*
             *   共执行两次 ， 开始一次 ，结束一次
             *   初始化 测试套件 对象 列表
             */
            if(testClassSuitesList==null){
                testClassSuitesList = new ArrayList<>();
                testClassSuites = new SuitesDataModel();
                caseSuitesList = new ArrayList<>();
                testClassCtxModel =  new CtxModel();
            }else {
                testClassSuitesList.add(testClassSuites);
                String date = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
                testClassSuites.setTitle(planName);
                testClassSuites.setFile(date+"-"+planName);
                testClassSuites.setFullFile(testIdentifier.getLegacyReportingName());
                testClassSuites.setParent(parentId);
                testClassSuites.setUuid(uuqueid);
            }
        } else if (testPlanId.equals(pid)) {
            /*
             * 写入berfor
             * 初始化case对象 列表
             */
            testsModelList = new ArrayList<>();
            passTestModleList = new ArrayList<>();
            failuresTestModleList = new ArrayList<>();
            caseSuites = new SuitesDataModel();
            caseSuitesStar = LocalDateTime.now();

            parentId = uuqueid;
            //写入berfor
            eachRunnable = new EachRunnableModel();
            List<EachRunnableModel> eachRunnableList = new ArrayList<>();
            eachRunnable.setTitle(testIdentifier.getDisplayName() + testIdentifier.getLegacyReportingName());
            eachRunnable.setBody(testIdentifier.getSource().toString());
            eachRunnable.setParent(this.getClass().getSimpleName());

            eachRunnableList.add(eachRunnable);
            //添加测试类的before
            eachRunnable.setAsync((long) 0);
            eachRunnable.setSync(true);
            eachRunnable.setTimeout((long) 2000);
            eachRunnable.setSlow((long) 75);
            eachRunnable.setEnableTimeouts(true);
            eachRunnable.setTimedOut(true);
            eachRunnable.setTrace(new Object());
            eachRunnable.setRetries((long) -1);
            eachRunnable.setCurrentRetry((long) 0);
            eachRunnable.setPending(false);
            eachRunnable.setType(testIdentifier.getType().name());
            eachRunnable.setParent(parentId);
            eachRunnable.setCtx(new CtxModel());
            eachRunnable.setEvents(new EventsModel());
            eachRunnable.setEventsCount((long) 1);
            eachRunnable.setTimer(new RunnableTimer());
            eachRunnable.setDuration((long) 0);
            eachRunnable.setErr(null);

            caseSuites.setBeforeAll(new ArrayList<>());
            caseSuites.setBeforeEach(eachRunnableList);
            CtxModel caseSuitesCtx = new CtxModel();
            caseSuitesCtx.setRunnable(eachRunnable);
            caseSuitesCtx.setTest(eachRunnable);
            caseSuites.setCtx(caseSuitesCtx);
            /*
             * 初始化测试类的 用例列表
             * 填充ctc
             */
            testClassCtxModel.setRunnable(new EachRunnableModel());
            testClassCtxModel.setTest(new EachRunnableModel());
            //填充classSuites
            testClassSuites.setCtx(testClassCtxModel);
            testClassSuites.setTests(new ArrayList<>());
            testClassSuites.setPending(new ArrayList<>());
            testClassSuites.setBeforeAll(new ArrayList<>());
            testClassSuites.setBeforeEach(new ArrayList<>());

        } else if (parentId.equals(pid)) {
            //写入case
            testStar = LocalDateTime.now();
            childId = uuqueid;
            tests = new TestsModel();
            tests.setTitle(testIdentifier.getDisplayName());
            tests.setFullTitle(testIdentifier.getDisplayName());
            tests.setUuid(childId);
        }
    }

    /**
     * 用例执行完成
     *
     * @param testIdentifier
     */
    @SneakyThrows
    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        testEnd = LocalDateTime.now();
        String uuqueid = testIdentifier.getUniqueId();
        Optional<String> parentOpt = testIdentifier.getParentId();
        String pid = null;
        if(parentOpt.isPresent()){
            pid = parentOpt.get();
        }
        if (pid.equals(parentId) && childId.equals(uuqueid)) {
            //case结束
            caseModel = new CaseModel();
            Duration duration = Duration.between(testStar, testEnd);
            tests.setDuration(duration.toMillis());
            if ("SUCCESSFUL".equals(testExecutionResult.getStatus().name())) {
                tests.setFail(false);
                tests.setPass(true);
                tests.setSkipped(false);
                tests.setPending(false);
                tests.setCode("成功");
                tests.setState("true");
                passes++;
                passTestModleList.add(tests);
                caseModel.setTitle(testIdentifier.getDisplayName());
                caseModel.setValue(testExecutionResult.getStatus().name());
            } else {
                tests.setContext(imageNow(testIdentifier.getDisplayName()));
                tests.setPass(false);
                tests.setFail(true);
                tests.setSkipped(false);
                tests.setPending(false);
                tests.setState("false");
                tests.setCode("失败原因："+testExecutionResult.getThrowable().get().getMessage());
                failures++;
                failuresTestModleList.add(tests);
                caseModel.setTitle(testIdentifier.getUniqueId());
                caseModel.setValue(testExecutionResult.getStatus().name());
            }
            testsModelList.add(tests);
            caseModels.add(caseModel);
        } else if (uuqueid.equals(parentId)) {
            caseSuitesEnd = LocalDateTime.now();

            //   测试类结束 写入 after
            eachRunnable = new EachRunnableModel();
            List<EachRunnableModel> eachRunnableList = new ArrayList<>();

            eachRunnable.setTitle(testIdentifier.getDisplayName() + testIdentifier.getLegacyReportingName());
            eachRunnable.setBody(testIdentifier.getSource().toString());
            eachRunnable.setParent(this.getClass().getSimpleName());
            eachRunnableList.add(eachRunnable);
            //  添加测试类的before
            caseSuites.setAfterAll(new ArrayList<>());
            caseSuites.setAfterEach(eachRunnableList);
            caseSuites.setTests(testsModelList);
            caseSuites.setPasses(passTestModleList);
            caseSuites.setFailures(failuresTestModleList);
            //  caseSuites 数据填充
            caseSuites.setTitle(testIdentifier.getDisplayName());
            caseSuites.setSuites(new ArrayList<>());
            caseSuites.setRoot(false);
            caseSuites.setTimeout((long) 3000);
            caseSuites.setEnableTimeouts(true);
            caseSuites.setSlow((long)75);
            caseSuites.setRetries((long) -1);
            caseSuites.setDelayed(false);
            caseSuites.setParent(testIdentifier.getParentId().get());
            caseSuites.setFile(testIdentifier.getLegacyReportingName());
            caseSuites.setFullFile(testIdentifier.getLegacyReportingName());
            caseSuites.setUuid(testIdentifier.getUniqueId());
            caseSuites.setSkipped(new ArrayList<>());
            caseSuites.setTotalTests((long)(passTestModleList.size()+failuresTestModleList.size()));
            caseSuites.setTotalPasses((long)passTestModleList.size());
            caseSuites.setTotalFailures((long)failuresTestModleList.size());
            caseSuites.setTotalSkipped((long) 0);
            caseSuites.setTotalPending((long) 0);
            Duration duration = Duration.between(caseSuitesStar,caseSuitesEnd);
            caseSuites.setDuration(duration.toMillis());

            caseSuitesList.add(caseSuites);
            // testClassSuites 数据填充
            testClassSuites.setAfterEach(new ArrayList<>());
            testClassSuites.setAfterAll(new ArrayList<>());
            testClassSuites.setRoot(false);
            testClassSuites.setTimeout((long) 3000);
            testClassSuites.setEnableTimeouts(false);
            testClassSuites.setSlow((long) 75);
            testClassSuites.setRetries((long) -1);
            testClassSuites.setDelayed(false);
            testClassSuites.setPasses(new ArrayList<>());
            testClassSuites.setFailures(new ArrayList<>());
            testClassSuites.setSkipped(new ArrayList<>());
            testClassSuites.setTotalFailures((long) 0);
            testClassSuites.setTotalPasses((long) 0);
            testClassSuites.setTotalPending((long) 0);
            testClassSuites.setTotalTests((long)0);
            testClassSuites.setTotalSkipped((long)0);
            testClassSuites.setDuration((long) 0);

            // 测试用例 suite集合添加到 testclasssuites
            testClassSuites.setSuites(caseSuitesList);
        }
    }

    /**
     * 测试计划执行结束
     *
     * @param testPlan
     */
    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        //填充suties
        List<TestsModel> test =  new ArrayList<>();
        List<EachRunnableModel> runnableModels = new ArrayList<>();
        planSuites.setAfterAll(runnableModels);
        planSuites.setBeforeAll(runnableModels);

        planSuites.setCtx(new CtxModel());
        planSuites.setTests(test);
        planSuites.setPending(test);
        planSuites.setBeforeEach(runnableModels);
        planSuites.setAfterEach(runnableModels);
        planSuites.setRoot(true);
        planSuites.setTimeout((long) 2000);
        planSuites.setEnableTimeouts(true);
        planSuites.setSlow((long) 100);
        planSuites.setRetries((long) -1);
        planSuites.setDelayed(false);
        planSuites.setEvents(new EventsModel());
        planSuites.setEventsCount((long) 1);
        planSuites.setUuid(testPlanId);
        planSuites.setTitle("");
        planSuites.setFile("");
        planSuites.setPasses(test);
        planSuites.setFailures(test);
        planSuites.setSkipped(test);
        planSuites.setTotalTests((long) 0);
        planSuites.setTotalSkipped((long) 0);
        planSuites.setTotalFailures((long) 0);
        planSuites.setTotalPending((long) 0);
        planSuites.setTotalPasses((long) 0);
        planSuites.setTotalTime((long) 0);
        planSuites.setSuites(testClassSuitesList);

        //  planStats
        int testCount = failures+passes+skipped;
        planStats.setEnd(LocalDateTime.now());
        Duration duration = Duration.between(planStats.getStart(), planStats.getEnd());
        planStats.setDuration(duration.toMillis());
        planStats.setFailures((long)failures);
        planStats.setPasses((long)passes);
        planStats.setSkipped((long)skipped);
        planStats.setSuites((long)planSuites.getSuites().size());
        planStats.setHasOther(false);
        planStats.setOther((long)0);
        planStats.setHasSkipped(false);
        planStats.setTests((long)testCount);
        planStats.setPassPercent(numberFormat(passes,testCount));
        planStats.setPending((long)0);

        //  设置logo 面板数据
        macacaReportModel = new MacacaReportModel();
        macacaReportModel.setStats(planStats);
        macacaReportModel.setSuites(planSuites);

        if(logo != null){
            currentModle.setImage(logo);
            currentModle.setList(caseModels);
            macacaReportModel.setCurrent(currentModle);
        }

        String reportJson = "module.exports = " + JSONObject.toJSONString(macacaReportModel, SerializerFeature.DisableCircularReferenceDetect);
        try {
            writeJs("report.js",reportJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
        exec2();
    }

    /**
     * 执行跳过
     * @param testIdentifier
     */
    @Override
    public void executionSkipped(TestIdentifier testIdentifier, String reason) {
        skipped++;
    }


    /*
     *  ======================================== 一些方法 ==============================================
     */

    /**
     * 输出 Js
     * @param name  文件名
     * @param content  内容
     * @throws Exception
     */
    public static void writeJs(String name, String content) throws IOException {
        OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream(name), "utf-8");
        System.out.println("正在生成报告："+content);
        oStreamWriter.append(content);
        oStreamWriter.close();
    }

    /**
     * 判断是否存在logo
     * @return
     */
    private static String getLogo(){
        String logoUrl = System.getProperty("logo");
        if(logoUrl != null){
            return logoUrl;
        }
        return null;
    }
    /**
     * 判断是否这是logo
     * @return
     */
    private static String getPlanName(){
        String planName = System.getProperty("planName");
        if(planName != null){
            return planName;
        }
        return "Macaca测试报告";
    }

    /**
     * js生成后 执行cmd生成报告
     * @return
     */
    public static void exec2(){
        String cmd = isWindows() ? "macaca-reporter.cmd -d  report.js" : "macaca-reporter -d  report.js";
        Runtime run = Runtime.getRuntime();
        try {
            Process p = run.exec(cmd);
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
            inBr.close();
            in.close();
        } catch (Exception var7) {
            System.out.println("报告失败了："+var7.getMessage());
        }
    }

    /**
     * 是否windows
     * @return
     */
    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    /**
     * 图片转码
     * @param imgPath
     * @return
     */
    private static String imageToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回Base64编码过的字节数组字符串
        String base64Image = "data:image/png;base64,"+ Base64.getEncoder().encodeToString(Objects.requireNonNull(data));
        return base64Image;
    }

    /**
     * 判断图片路径下是否有该方法的截图生成截图
     * @param name
     * @return
     * @throws IOException
     */
    private static String imageNow(String name) throws IOException {
        File file = new File(System.getProperty("user.dir")+File.separator+"screenshot");
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {
                String filePath = fileList[i].getCanonicalPath();
                if(filePath.indexOf(name)>0){
                    return imageToBase64(filePath);
                }
            }
        }
        return null;
    }

    /**
     * 计算
     * @param passes
     * @param count
     * @return
     */
    public double numberFormat(int passes ,int count){
        if(count==0){
            return 0;
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format( ((float) passes /  (float)count)*100);
        double passPercent = Double.valueOf(result);
        System.out.println(result);
        return  passPercent;
    }

}
