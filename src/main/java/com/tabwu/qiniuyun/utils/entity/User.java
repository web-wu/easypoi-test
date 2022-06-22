package com.tabwu.qiniuyun.utils.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: qiNiuYun
 * @Author: tabwu
 * @Date: 2021/12/18 17:11
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget("user")
public class User implements Serializable {

    @Excel(name = "id")
    private Integer id;
    @Excel(name = "年龄")
    private Integer age;
    @Excel(name = "用户名")
    private String username;
    @Excel(name = "密码")
    private String password;
    @Excel(name = "生日",width = 20,format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    @Excel(name = "地址",width = 30)
    private String address;
}
