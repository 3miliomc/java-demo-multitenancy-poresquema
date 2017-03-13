package com.demo.multitenancy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/** Repository configuration behavior. */
@Configuration
@EnableJpaAuditing
public class AppRepoConfig {

}