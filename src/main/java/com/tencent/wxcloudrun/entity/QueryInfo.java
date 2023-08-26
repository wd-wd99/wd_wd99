package com.tencent.wxcloudrun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description: query_info
 * @Author: wd
 * @Date:   2023-08-22
 * @Version: V1.0
 */
@Data
@TableName("query_info")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="query_info对象", description="query_info")
public class QueryInfo {

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
	private Long id;
	/**查询人姓名*/
    @ApiModelProperty(value = "查询人姓名")
	private String searcherName;
	/**查询人手机号*/
    @ApiModelProperty(value = "查询人手机号")
	private String searcherPhone;
	/**被审计人除名者姓名*/
    @ApiModelProperty(value = "被审计人除名者姓名")
	private String auditeeName;
	/**被审计人除名者身份证号*/
    @ApiModelProperty(value = "被审计人除名者身份证号")
	private String auditeeId;
	/**所属公司*/
    @ApiModelProperty(value = "所属公司")
	private String affiliatedCompany;
	/**查询用途*/
	@ApiModelProperty(value = "查询用途")
	private String queryPurpose;
	/**查询结果*/
	@ApiModelProperty(value = "查询结果")
	private String queryResult;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**code*/
	@ApiModelProperty(value = "code")
	private String code;
}
