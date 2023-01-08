package com.example.gradruate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author szm
 * @since 2022-12-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Messagetable对象", description="")
public class Messagetable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息主键")
    @TableId(value = "megID", type = IdType.AUTO)
    private Integer megID;

    @ApiModelProperty(value = "对话框ID")
    @TableField("dialogID")
    private String dialogID;

    @ApiModelProperty(value = "用户ID")
    @TableField("userID")
    private String userID;

    @ApiModelProperty(value = "消息内容")
    private String message;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private String createTime;

    @ApiModelProperty(value = "头像")
    @TableField(exist = false)
    private String avatar;

    @ApiModelProperty(value = "昵称")
    @TableField(exist = false)
    private String nickname;


}
