package com.example.gradruate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

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
 * @since 2022-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论id")
    @TableId(value = "cid", type = IdType.ID_WORKER)
    private String cid;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "用户id")
    private String userid;

    @ApiModelProperty(value = "书本id")
    private String bid;

    @ApiModelProperty(value = "父级评论id")
    private String pid;

    @ApiModelProperty(value = "回复对象")
    private String target;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private String createTime;
//头像
    private String avator;

    //二级评论
    @TableField(exist = false)
    private List<Comment> comments;
    @TableField(exist = false)
    private int size;


}
