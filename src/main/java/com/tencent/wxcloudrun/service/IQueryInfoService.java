package com.tencent.wxcloudrun.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tencent.wxcloudrun.entity.QueryInfo;


/**
 * @Description: query_info
 * @Author: jeecg-boot
 * @Date:   2023-08-22
 * @Version: V1.0
 */
public interface IQueryInfoService extends IService<QueryInfo> {

    /**
     * 新增查询人及被查询人信息
     *
     * @param queryInfo 查询人及被查询人信息
     * @return 结果
     */
    public int insertQueryInfo(QueryInfo queryInfo);

}
