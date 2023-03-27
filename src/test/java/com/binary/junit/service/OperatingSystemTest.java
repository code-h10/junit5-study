package com.binary.junit.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLOutput;

@ExtendWith(SpringExtension.class)
public class OperatingSystemTest {

    @Test
    @EnabledOnOs(OS.MAC)
    public void onOnMacOs() {
        System.out.println("This is Computer Mac");
    }

    @Test
    @DisabledOnOs(OS.MAC)
    public void notOnMacOs() {
        System.out.println("This is Computer Mac");
    }


    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void notOnJava8() {
        System.out.println("Java 8");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    public void onlyOnJava11() {
        System.out.println("Java 11");
    }


    @Test
    @EnabledForJreRange(max = JRE.JAVA_11)
    public void fromJava8To11() {
        System.out.println("From Java 8 To Java 11");
    }


    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX})
    public void onOnMacOrLinux() {
        System.out.println("This is Computer Mac Or Linux");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void onOnWindow() {
        System.out.println("This is Computer Windows");
    }

}
