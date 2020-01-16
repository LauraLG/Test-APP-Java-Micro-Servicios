
package com.sboot.test.service;

import com.sboot.test.service.service.HelloWorldService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.annotation.DirtiesContext;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@DirtiesContext
public class HelloWorldServiceTest {

    private static final Logger LOGGER =  LoggerFactory.getLogger(HelloWorldServiceTest.class);

    @Autowired
    private HelloWorldService helloWorldService;

    /**
     * Verify service.helloWorldService.helloWorld() returns "service HelloWorld" when is called
     * @throws Exception
     */
    @Test
    public void helloWorldTest() throws Exception {

        LOGGER.info("Verify helloWorldService.helloWorld() returns \"service HelloWorld\" when is called");

        String result = helloWorldService.helloWorld();
        Assert.assertEquals("service HelloWorld", result);
    }
}