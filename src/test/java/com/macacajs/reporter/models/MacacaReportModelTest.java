package com.macacajs.reporter.models;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class MacacaReportModelTest {

    @Test
    void parseStatsData() throws IOException {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("json-final.json");
        MacacaReportModel parsedObject = JSON.parseObject(resourceAsStream, MacacaReportModel.class);
        assertNotNull(parsedObject);
        assertEquals(parsedObject.getStats().getTests().intValue(), 5);
    }
}