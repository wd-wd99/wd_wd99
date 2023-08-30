package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tencent.wxcloudrun.entity.AppIdSecert;


/**
 * @Description: app_id_secert
 * @Author: jeecg-boot
 * @Date:   2023-08-30
 * @Version: V1.0
 */
public interface IAppIdSecertService extends IService<AppIdSecert> {

    AppIdSecert getSecert(String appId);

}
