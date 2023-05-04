package com.example.gradruate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * @since 2022-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Bookmeg对象", description="")
public class Bookmegs implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "书本id")
    @TableId(value = "bid", type = IdType.ID_WORKER)
    private String bid;

    @ApiModelProperty(value = "用户id")
    private String uid;

    @ApiModelProperty(value = "作者")
    private String autor;

    @ApiModelProperty(value = "出版社")
    private String press;

    @ApiModelProperty(value = "图书类型")
    private String genre;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "书名")
    private String bookname;

    @ApiModelProperty(value = "图书创建时间")
    @TableField("createTime")
    private String createTime;

    @ApiModelProperty(value = "封面")
    private String cover;
    @ApiModelProperty(value = "书名")
    private String name;

    private String nickname;



    //用户信息
    @TableField(exist = false)
    private UcenterMember ucenterMember;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Bookmegs{" +
                "bid='" + bid + '\'' +
                ", uid='" + uid + '\'' +
                ", autor='" + autor + '\'' +
                ", press='" + press + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", bookname='" + bookname + '\'' +
                ", createTime='" + createTime + '\'' +
                ", cover='" + cover + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", ucenterMember=" + ucenterMember +
                '}';
    }

    public Bookmegs() {
    }


    public Bookmegs(String bid, String uid, String autor, String press, String genre, String description, String bookname, String createTime, String cover, String name, UcenterMember ucenterMember) {
        this.bid = bid;
        this.uid = uid;
        this.autor = autor;
        this.press = press;
        this.genre = genre;
        this.description = description;
        this.bookname = bookname;
        this.createTime = createTime;
        this.cover = cover;
        this.name = name;
        this.ucenterMember = ucenterMember;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UcenterMember getUcenterMember() {
        return ucenterMember;
    }

    public void setUcenterMember(UcenterMember ucenterMember) {
        this.ucenterMember = ucenterMember;
    }
}
