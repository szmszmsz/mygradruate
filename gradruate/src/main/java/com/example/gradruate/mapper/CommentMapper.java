package com.example.gradruate.mapper;

import com.example.gradruate.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author szm
 * @since 2022-12-04
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    //获取一级评论的全部评论
    List<Comment> selectBooksComments(@Param("bid") String bid);
//获取头二级评论
    Comment selectBooksSecondComments(@Param("cid")String cid);
    //获取二级评论
    List<Comment> selectBookSecond(@Param("bid") String bid);
}
