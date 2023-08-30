package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.entity.AppIdSecert;
import com.tencent.wxcloudrun.service.IAppIdSecertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description: app_id_secert
* @Author: jeecg-boot
* @Date:   2023-08-30
* @Version: V1.0
*/
@Slf4j
@Api(tags="app_id_secert")
@RestController
@RequestMapping("/shenji/appIdSecert")
public class AppIdSecertController {
   @Autowired
   private IAppIdSecertService appIdSecertService;


    @ApiOperation(value="app_id_secert-分页列表查询", notes="app_id_secert-分页列表查询")
    @GetMapping(value = "/getSecert")
    public ApiResponse getSecert(String appId) {

        AppIdSecert appIdSecert = appIdSecertService.getSecert(appId);
        return ApiResponse.ok(appIdSecert.getAppSecret());
    }


}
