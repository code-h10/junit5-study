package com.binary.junit.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SystemPropertyTest {

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = "test")
    public void onlyOnOsArchTest() {
        System.out.println("os.arch=test");
    }

}
