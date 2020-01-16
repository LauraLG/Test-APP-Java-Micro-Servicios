
package com.sboot.test.service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldServiceImpl.class);

    /**
     *
     * @return String 'service HelloWorld'
     */
    @Override
    public String helloWorld() {
        LOG.info("service HelloWorld");
        return "service HelloWorld";
    }


}