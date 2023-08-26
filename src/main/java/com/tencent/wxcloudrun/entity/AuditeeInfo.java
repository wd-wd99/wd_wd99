package com.tencent.wxcloudrun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description: auditee_info
 * @Author: jeecg-boot
 * @Date:   2023-08-22
 * @Version: V1.0
 */
@Data
@TableName("auditee_info")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AuditeeInfo {

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
	private Integer id;
	/**被审计人姓名*/
	private String auditeeName;
	/**被审计人员身份证号*/
	private String auditeeId;
	/**所属公司*/
	private String affiliatedCompany;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**删除标识 0 ：否 1：是*/
	private String isDeleted;
}
