package com.tencent.wxcloudrun.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 获取小程序电话号
 * @Author: wd
 * @Date:   2023-08-22
 * @Version: V1.0
 */
@RestController
@RequestMapping("/phoneNumber")
@Slf4j
public class PhoneNumberController {

    @GetMapping("/getPhoneNumber")
    public Object getPhoneNumber()
    {
        return 1;
    }

}
