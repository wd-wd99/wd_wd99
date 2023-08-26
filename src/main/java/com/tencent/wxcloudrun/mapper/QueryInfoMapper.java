package com.tencent.wxcloudrun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tencent.wxcloudrun.entity.QueryInfo;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Description: query_info
 * @Author: jeecg-boot
 * @Date:   2023-08-22
 * @Version: V1.0
 */
@Mapper
public interface QueryInfoMapper extends BaseMapper<QueryInfo> {

    /**
     * 新增查询人及被查询人信息
     *
     * @param queryInfo 查询人及被查询人信息
     * @return 结果
     */
    int insertQueryInfo(QueryInfo queryInfo);

}
