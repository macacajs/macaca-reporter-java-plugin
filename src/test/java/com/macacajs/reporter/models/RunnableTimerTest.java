package com.macacajs.reporter.models;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class RunnableTimerTest {

    @Test
    void parseStatsData() throws IOException {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("timer.json");
        RunnableTimer parsedObject = JSON.parseObject(resourceAsStream, RunnableTimer.class);
        assertNotNull(parsedObject);
        assertNull(parsedObject.getIdleNext());
        assertEquals(parsedObject.getIdleTimeout().intValue(), -1);
    }
}