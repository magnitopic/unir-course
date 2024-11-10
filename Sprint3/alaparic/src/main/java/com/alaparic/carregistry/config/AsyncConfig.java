package com.alaparic.carregistry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);    // Minimum number of threads
        executor.setMaxPoolSize(10);    // Maximum number of threads
        executor.setQueueCapacity(100); // Queue capacity for tasks when all threads are busy
        executor.setThreadNamePrefix("AsyncThread-");
        executor.initialize();
        return executor;
    }
}