package com.tabwu.qiniuyun.utils.test;

/**
 * @ProjectName: qiNiuYun
 * @Author: tabwu
 * @Date: 2022/1/20 12:28
 * @Description:
 */
public abstract class UserServiceImpl {

    public abstract void findAll();

    public void test() {
        findAll();

        System.out.println("test method execute");
    }
}
