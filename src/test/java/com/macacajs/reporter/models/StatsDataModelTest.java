package com.macacajs.reporter.models;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class StatsDataModelTest {


    @Test
    void parseStatsData() throws IOException {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("stats.json");
        StatsDataModel parsedObject = JSON.parseObject(resourceAsStream, StatsDataModel.class);
        assertNotNull(parsedObject);
        assertEquals(parsedObject.getTests().intValue(),5);
    }
}