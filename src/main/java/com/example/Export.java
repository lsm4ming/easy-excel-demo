package com.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.alibaba.excel.EasyExcel;

/**
 * Export
 *
 */
public class Export {
    public static void main(String[] args) {
        // mvn archetype:generate -DgroupId=com.example -DartifactId=easy-excel-demo
        // -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
        System.out.println("Hello World!");

        new Thread(() -> {
            exportBigExcel("big.xlsx");
        }).start();

        Tool.monitorThread();
    }

    public static void exportBigExcel(String fileName) {
        // 模拟生成100W条数据
        List<Student> list = Tool.getStudentList(1000000);
        EasyExcel.write(fileName, Student.class).inMemory(false).sheet("sheet1").doWrite(list);
        Tool.finished();
    }
}
