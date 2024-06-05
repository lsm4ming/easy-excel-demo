package com.example;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

@Data
public class Student {
    @ExcelProperty("ID")
    private Long id;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty("地址")
    private String address;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("邮箱")
    private String email;

    @ExcelProperty("手机号")
    private String phone;

    @ExcelProperty("性别")
    private String sex;

    @ExcelProperty("学号")
    private String studentNo;

    @ExcelProperty("班级")
    private String clazz;
}
