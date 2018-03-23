package com.example.demo;

import com.example.demo.service.JUnitTestService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestJUnitTestService {

    @Test
    public void testJoinMethod() {
        List<String> stringList = Arrays.asList("Hey", "Jason");

        final JUnitTestService service = new JUnitTestService();

        Assert.assertEquals("Hey,Jason", service.addStringsTogether(stringList));
    }

}
