package com.zemnnni.config.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.*;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * @작성자 : DATA
 * @파일명 : Log4j2Config
 * @작성일 : 2025-05-12
 * @설명 :
 */

@Component
public class Log4j2Config {
    @PostConstruct
    public void init() {
        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

        builder.setStatusLevel(Level.ERROR);
        builder.setConfigurationName("log4j2Config");

        // 콘솔 Appender 설정
        AppenderComponentBuilder consoleAppender = builder.newAppender("Console", "CONSOLE")
                .addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);

        LayoutComponentBuilder layoutBuilder = builder.newLayout("PatternLayout")
                .addAttribute("pattern", "%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n");

        consoleAppender.add(layoutBuilder);
        builder.add(consoleAppender);

        // Root Logger 설정
        builder.add(builder.newRootLogger(Level.INFO)
                .add(builder.newAppenderRef("Console")));

        // LoggerContext에 적용
        Configurator.initialize(builder.build());
    }
}
