package com.sweethome.test;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestLoggerTest {
    @Test
    public void testPerformSomeTask() throws Exception {
        TestLogger log4J2PropertiesConf=new TestLogger();
        log4J2PropertiesConf.performSomeTask();
    }
}
