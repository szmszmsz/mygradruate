package com.example.gradruate.service;

import com.example.gradruate.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author szm
 * @since 2022-12-04
 */
public interface CommentService extends IService<Comment> {
    //    添加一级评论
    Boolean addCommentFirst(Comment comment, HttpServletRequest request);

    List<Comment> selectBooksComments(String bid);

//    Boolean addCommentSecont(Comment comment, HttpServletRequest request);
    public Comment  selectBooksSecondCommentsaaaa(String cid);
}
