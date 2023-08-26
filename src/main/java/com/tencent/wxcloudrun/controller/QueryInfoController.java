package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.entity.AuditeeInfo;
import com.tencent.wxcloudrun.entity.QueryInfo;
import com.tencent.wxcloudrun.entity.WXContent;
import com.tencent.wxcloudrun.service.IAuditeeInfoService;
import com.tencent.wxcloudrun.service.IQueryInfoService;
import com.xkcoding.http.HttpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
* @Description: query_info
* @Author: jeecg-boot
* @Date:   2023-08-22
* @Version: V1.0
*/
@Slf4j
@Api(tags="query_info")
@RestController
@RequestMapping("/shenji/queryinfo")
public class QueryInfoController  {
   @Autowired
   private IQueryInfoService queryInfoService;

   @Autowired
   private IAuditeeInfoService auditeeInfoService;


    /**
     *根据身份证号查询auditee_info表然后将前端传过来的数据保存在query_info表中
     *
     */

    @ApiOperation(value="查询", notes="查询")
    @PostMapping(value = "/querydata")
    public ApiResponse querydata(@RequestBody QueryInfo queryInfo){
       if(queryInfo.getCode() != null){
           //通过appid和secret来获取token
           //WXContent.APPID是自定义的全局变量
           String tokenUrl = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", WXContent.APPID, WXContent.APPSECRET);
           JSONObject token = JSON.parseObject(HttpUtil.get(tokenUrl));

           //通过token和code来获取用户手机号
           String url = "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=" + token.getString("access_token");

           //封装请求体
           Map<String, String> paramMap = new HashMap<>();
           paramMap.put("code", queryInfo.getCode());
           String s = queryInfo.getCode();
           System.out.println(s);
           //封装请求头
           HttpHeaders headers = new HttpHeaders();
           headers.setContentType(MediaType.APPLICATION_JSON);

           HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(paramMap,headers);

           //通过RestTemplate发送请求，获取到用户手机号码
           RestTemplate restTemplate = new RestTemplate();
           ResponseEntity<Object> response = restTemplate.postForEntity(url, httpEntity, Object.class);
           Map<String, Object> map = new HashMap<>();
           map = (Map)response.getBody();
           map = (Map)map.get("phone_info");
           System.out.println(map.get("phoneNumber"));
           queryInfo.setSearcherPhone(map.get("phoneNumber").toString());
       }

        QueryWrapper<AuditeeInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_deleted",0);
        queryWrapper.eq("auditee_id",queryInfo.getAuditeeId());
        queryWrapper.eq("auditee_name",queryInfo.getAuditeeName());
        AuditeeInfo auditeeInfo = auditeeInfoService.getOne(queryWrapper);
        String message = "有与您查询条件相匹配的信息";
        if( auditeeInfo ==  null){
              message = "没有与您查询条件相匹配的信息";
        }else{
            queryInfo.setAffiliatedCompany(auditeeInfo.getAffiliatedCompany());
        }
        queryInfo.setQueryResult(message);
        queryInfoService.insertQueryInfo(queryInfo);
//		 queryInfoService.save(queryInfo);
         return ApiResponse.ok(message);

    }



}
