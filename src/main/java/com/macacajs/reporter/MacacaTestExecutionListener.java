package com.macacajs.reporter;

import com.alibaba.fastjson.JSON;
import com.macacajs.reporter.models.*;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author niaoshuai
 */
public class MacacaTestExecutionListener implements TestExecutionListener {

    private final MacacaReportModel macacaReportModel;

    private final Map<String,SuitesDataModel> allExecutionMap;
    private final Map<String,EachRunnableModel> runnableModelMap;

    public MacacaTestExecutionListener() {
        this.macacaReportModel = new MacacaReportModel();
        allExecutionMap = new HashMap<>();
        runnableModelMap = new HashMap<>();
    }

    /**
     * 测试计划启动
     * @param testPlan
     */
    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        // 初始化
        macacaReportModel.setSuites(new SuitesDataModel());
        macacaReportModel.setStats(new StatsDataModel());

        StatsDataModel stats = macacaReportModel.getStats();
        stats.setStart(LocalDateTime.now());
    }


    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        StatsDataModel stats = macacaReportModel.getStats();
        stats.setEnd(LocalDateTime.now());
        long startEpochSecond = stats.getEnd().toInstant(ZoneOffset.of("+")).getEpochSecond();
        long endEpochSecond = stats.getStart().toInstant(ZoneOffset.of("+")).getEpochSecond();
        stats.setDuration(startEpochSecond - endEpochSecond);

        System.out.println(JSON.toJSONString(allExecutionMap));
    }

    /**
     * 每个测试用例开始
     * @param testIdentifier
     */
    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        SuitesDataModel parentSuites = new SuitesDataModel();
        parentSuites.setParent(testIdentifier.getParentId().get());
        parentSuites.setUuid(testIdentifier.getUniqueId());
        parentSuites.setTitle(testIdentifier.getDisplayName());
        allExecutionMap.put(parentSuites.getUuid(),parentSuites);

        EachRunnableModel eachRunnableModel = new EachRunnableModel();
        eachRunnableModel.setUuid(testIdentifier.getUniqueId());
        eachRunnableModel.setTitle(testIdentifier.getDisplayName());
        eachRunnableModel.setPending(true);
        runnableModelMap.put(testIdentifier.getUniqueId(),eachRunnableModel);
    }

    /**
     * 每个测试用例结束
     * @param testIdentifier
     * @param testExecutionResult
     */
    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        EachRunnableModel eachRunnableModel = runnableModelMap.get(testIdentifier.getUniqueId());
        eachRunnableModel.setPending(false);
        eachRunnableModel.setTimedOut(false);

    }

    /**
     * 忽略的测试
     * @param testIdentifier
     * @param reason
     */
    @Override
    public void executionSkipped(TestIdentifier testIdentifier, String reason) {

    }


}
