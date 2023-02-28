package com.codegym.utils;

import java.util.Arrays;
import java.util.List;

public class LogUtils {
    private static final String pathLog = "./data/log.txt";

    public static void logging(StackTraceElement[] stackTraceElements) {
        List<StackTraceElement> list = Arrays.asList(stackTraceElements);

        FileUtils.writeDataToFileAppend(pathLog, list, true);
    }
}
