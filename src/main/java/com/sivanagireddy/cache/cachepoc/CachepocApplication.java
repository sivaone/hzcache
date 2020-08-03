package com.sivanagireddy.cache.cachepoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachepocApplication {

    public static void main(String[] args) {
        SpringApplication.run(CachepocApplication.class, args);
    }

}
