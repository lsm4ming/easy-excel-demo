package com.example;

import java.util.ArrayList;
import java.util.List;

public class Tool {
    private static boolean finished;
    private static double maxMemoryUsage;

    public static void finished() {
        finished = true;
    }

    public static double getMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        return usedMemory / (1024.0 * 1024.0);
    }

    public static List<Student> getStudentList(int rows) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            Student student = new Student();
            student.setId(Long.valueOf(i));
            student.setAge(i);
            student.setAddress("地址" + i);
            student.setName("姓名" + i);
            student.setEmail("邮箱" + i);
            student.setPhone("手机号" + i);
            student.setSex("性别" + i);
            student.setStudentNo("学号" + i);
            student.setClazz("班级" + i);
            list.add(student);
        }
        return list;
    }

    // 性能监控
    public static void monitorThread() {
        long startTime = System.currentTimeMillis();
        new Thread(() -> {
            try {
                while (!finished) {
                    Thread.sleep(500);
                    double memoryUsage = getMemoryUsage();
                    if (memoryUsage > maxMemoryUsage) {
                        maxMemoryUsage = memoryUsage;
                    }
                    System.out.println("内存使用: " + getMemoryUsage() + " MB");
                }
                System.out.println("最大内存使用: " + maxMemoryUsage + " MB");
                System.out.println("总耗时: " + (System.currentTimeMillis() - startTime) / 1000.0 + " 秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
