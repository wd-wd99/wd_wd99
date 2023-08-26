package com.tencent.wxcloudrun.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.entity.QueryInfo;
import com.tencent.wxcloudrun.mapper.QueryInfoMapper;
import com.tencent.wxcloudrun.service.IQueryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: query_info
 * @Author: jeecg-boot
 * @Date:   2023-08-22
 * @Version: V1.0
 */
@Service
public class QueryInfoServiceImpl extends ServiceImpl<QueryInfoMapper, QueryInfo> implements IQueryInfoService {

    @Autowired
    private QueryInfoMapper queryInfoMapper;
    /**
     * 新增查询人及被查询人信息
     *
     * @param queryInfo 查询人及被查询人信息
     * @return 结果
     */
    @Override
    public int insertQueryInfo(QueryInfo queryInfo)
    {
        return queryInfoMapper.insertQueryInfo(queryInfo);
    }


}
