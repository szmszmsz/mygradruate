package com.example.gradruate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="轮播图", description="")
public class Rotationchart implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String url;
    private String fileName;
}
