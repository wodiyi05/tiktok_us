package com.ruoyi.web.controller;

import com.ruoyi.common.utils.SecurityUtils;

public class TestPassword {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.encryptPassword("123"));

    }
}
