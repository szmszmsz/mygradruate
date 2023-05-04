package com.example.gradruate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="未读消息", description="")
public class ReadMeg {
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    @ApiModelProperty(value = "时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty(value = "逻辑删除 0：未删除 1：已删除")
    private String logicDel;
    @ApiModelProperty(value = "用户id")
    private String uid;
    @ApiModelProperty(value = "是否已读 0：未读 1：已读")
    private String isRead;
    @ApiModelProperty(value = "信息")
    private String meg;

    private String isBackMeg;

    @ApiModelProperty(value = "昵称")
    private String nickname;


    @Override
    public String toString() {
        return "ReadMeg{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", logicDel='" + logicDel + '\'' +
                ", uid='" + uid + '\'' +
                ", isRead='" + isRead + '\'' +
                ", meg='" + meg + '\'' +
                ", isBackMeg='" + isBackMeg + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
