package org.sk.sample.test;

import org.apache.commons.lang3.StringUtils;

import java.lang.management.ManagementFactory;

public class Printer {


    public static void printEnv(String fromClass) {

        System.out.println("Command line arguments in "+fromClass+": "+
                StringUtils.join(ManagementFactory.getRuntimeMXBean().getInputArguments(),','));
        System.out.println("Command line in "+fromClass+": "+ProcessHandle.current().info().commandLine());

    }
}
