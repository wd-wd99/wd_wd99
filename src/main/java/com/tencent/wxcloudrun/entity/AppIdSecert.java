package com.tencent.wxcloudrun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: app_id_secert
 * @Author: jeecg-boot
 * @Date:   2023-08-30
 * @Version: V1.0
 */
@Data
@TableName("app_id_secert")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="app_id_secert对象", description="app_id_secert")
public class AppIdSecert {

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
	private Integer id;
	/**appId*/
    @ApiModelProperty(value = "appId")
	private String appId;
	/**appSecret*/

    @ApiModelProperty(value = "appSecret")
	private String appSecret;
}
