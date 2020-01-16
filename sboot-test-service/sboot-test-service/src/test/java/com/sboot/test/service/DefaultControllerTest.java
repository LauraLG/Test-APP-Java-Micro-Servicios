
package com.sboot.test.service;

import com.sboot.test.service.controller.DefaultController;
import com.sboot.test.service.service.HelloWorldService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = DefaultController.class, secure = false)
@ActiveProfiles("dev")
public class DefaultControllerTest {

    private static final Logger LOGGER =  LoggerFactory.getLogger(DefaultControllerTest.class);

    private static String HELLO_WORLD_TEST_STRING = "Hello world test";
    private static String EMPTY_JSON_RESULT_TEST = "{}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloWorldService helloWorldService;

    /**
     * Verify controller.DefaultController.getHelloWorldTest() returns "Hello world test" and a 200 OK when a GET request is performed to /DefaultController/helloWorld
     * @throws Exception
     */
    @Test
    public void getHelloWorldTest() throws Exception {

        LOGGER.info("Verify controller.DefaultController.getHelloWorldTest() returns \"Hello world test\" and a 200 OK when a GET request is performed to /DefaultController/helloWorld");

        Mockito.when(
                this.helloWorldService.helloWorld()
        ).thenReturn(HELLO_WORLD_TEST_STRING);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders
                        .get("/DefaultController/helloWorld")
                        .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        Assert.assertEquals(HELLO_WORLD_TEST_STRING, result.getResponse().getContentAsString());
    }


    /**
     * Verify controller.DefaultController.getResultTest() returns a 404 NOT FOUND when a GET request is performed to a non existing page
     * @throws Exception
     */
    @Test
    public void get404ErrorTest() throws Exception {

        LOGGER.info("Verify controller.DefaultController.getResultTest() returns a 404 NOT FOUND when a GET request is performed to a non existing page");

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders
                        .get("/DefaultController/nonExistingPage");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
    }
}