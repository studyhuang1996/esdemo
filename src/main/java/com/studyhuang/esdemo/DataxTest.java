package com.studyhuang.esdemo;

import com.alibaba.datax.core.Engine;
import org.joda.time.LocalTime;

/**
 * @author huang1996
 * @date 2021-03-02 22:23
 */
public class DataxTest {

    public static void main(String[] args) {
        System.setProperty("datax.home", getCurrentClasspath());
        System.setProperty("now", LocalTime.now().toString());// 替换job中的占位符
        String[] datxArgs = {"-job", getCurrentClasspath() + "/job/stream2stream.json", "-mode", "standalone", "-jobid", "-1"};
        try {
            Engine.entry(datxArgs);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentClasspath() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String currentClasspath = classLoader.getResource("datax.home").getPath();
        // 当前操作系统
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            // 删除path中最前面的/
            currentClasspath = currentClasspath.substring(1);
        }
        return currentClasspath;
    }

}
