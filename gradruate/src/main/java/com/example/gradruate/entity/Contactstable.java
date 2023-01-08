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
@ApiModel(value="Contactstable对象", description="")
public class Contactstable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "contactsId", type = IdType.AUTO)
    private Integer contactsId;

    @ApiModelProperty(value = "用户id")
    @TableField("userID")
    private String userID;

    @ApiModelProperty(value = "其他用户ID")
    @TableField("OtherUserID")
    private String OtherUserID;

    @ApiModelProperty(value = "对话框ID")
    @TableField("dialogID")
    private String dialogID;

//    @ApiModelProperty(value = "用户信息")
//    @TableField(exist = false)
//    private UcenterMember ucenterMember;

    @ApiModelProperty(value = "头像")
    @TableField(exist = false)
    private String avatar;

    @ApiModelProperty(value = "昵称")
    @TableField(exist = false)
    private String nickname;

    public Contactstable(String userID, String otherUserID, String dialogID) {
        this.userID = userID;
        OtherUserID = otherUserID;
        this.dialogID = dialogID;
    }
}
