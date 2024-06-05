package com.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

public class Import {
    public static void main(String[] args) {
        new Thread(() -> {
            List<Student> list = readExcel("big.xlsx");
            Tool.finished();
            System.out.println("读取到的数据量: " + list.size());
        }).start();

        Tool.monitorThread();
    }

    public static List<Student> readExcel(String filename) {
        List<Student> dataList = new ArrayList<>();
        EasyExcel.read(filename, Student.class, new DataListener(dataList)).sheet().doRead();
        return dataList;
    }

    public static class DataListener extends AnalysisEventListener<Student> {
        private List<Student> dataList;

        public DataListener(List<Student> dataList) {
            this.dataList = dataList;
        }

        @Override
        public void invoke(Student data, AnalysisContext context) {
            dataList.add(data);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            // 解析完成后的操作，例如关闭资源等
        }
    }

}
