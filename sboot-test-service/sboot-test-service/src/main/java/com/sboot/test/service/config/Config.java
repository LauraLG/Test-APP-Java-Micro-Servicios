
package com.sboot.test.service.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan
@EntityScan(basePackages = "com.sboot.test.service.model")
@EnableJpaRepositories(basePackages = "com.sboot.test.service.repository")
public class Config {


}
