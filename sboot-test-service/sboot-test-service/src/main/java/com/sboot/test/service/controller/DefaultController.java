
package com.sboot.test.service.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sboot.test.service.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/DefaultController")
public class DefaultController {

    @Autowired
    HelloWorldService helloWorldService;

    /**
     *
     * @return String containing phrase to welcome
     */
    @RequestMapping("/helloWorld")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHelloWorld() {

        return helloWorldService.helloWorld();
    }

}