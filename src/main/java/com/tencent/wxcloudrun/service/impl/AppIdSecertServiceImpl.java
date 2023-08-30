package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.entity.AppIdSecert;
import com.tencent.wxcloudrun.mapper.AppIdSecertMapper;
import com.tencent.wxcloudrun.service.IAppIdSecertService;
import org.springframework.stereotype.Service;

/**
 * @Description: app_id_secert
 * @Author: jeecg-boot
 * @Date:   2023-08-30
 * @Version: V1.0
 */
@Service
public class AppIdSecertServiceImpl extends ServiceImpl<AppIdSecertMapper, AppIdSecert> implements IAppIdSecertService {

    @Override
    public AppIdSecert getSecert(String appId) {
        QueryWrapper<AppIdSecert> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("app_id",appId);
        AppIdSecert appIdSecert = getOne(queryWrapper);
        return appIdSecert;
    }
}
