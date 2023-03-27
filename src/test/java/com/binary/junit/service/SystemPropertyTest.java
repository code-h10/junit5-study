package com.binary.junit.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SystemPropertyTest {

    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = "11.0.9")
    public void onlyOnJavaVersionTest() {
        System.out.println("java.version=" + System.getProperty("java.version"));
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = "x86_64")
    public void onlyOnOsArchTest() {
        System.out.println("os.arch=" + System.getProperty("os.arch"));
    }

}
