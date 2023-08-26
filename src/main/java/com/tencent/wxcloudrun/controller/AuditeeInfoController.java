package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.service.IAuditeeInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description: auditee_info
* @Author: jeecg-boot
* @Date:   2023-08-22
* @Version: V1.0
*/
@Slf4j
@Api(tags="auditee_info")
@RestController
@RequestMapping("/shenji/auditeeInfo")
public class AuditeeInfoController {
   @Autowired
   private IAuditeeInfoService auditeeInfoService;



}
