package com.macacajs.reporter.models;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class EventsModelTest {

    @Test
    void parseEvents() throws IOException {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("event.json");
        EventsModel parsedObject = JSON.parseObject(resourceAsStream, EventsModel.class);
        assertNotNull(parsedObject);
        assertEquals(parsedObject.getPreRequire().length,4);
    }
}