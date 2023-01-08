package com.example.gradruate.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.gradruate.entity.Comment;
import com.example.gradruate.entity.UcenterMember;
import com.example.gradruate.mapper.CommentMapper;
import com.example.gradruate.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.gradruate.service.UcenterMemberService;
import com.example.gradruate.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author szm
 * @since 2022-12-04
 */

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private UcenterMemberService ucenterMemberService;
    @Autowired
    private CommentService commentService;
    @Resource
    private CommentMapper commentMapper;
    //    添加一级评论
    @Override
    public Boolean addCommentFirst(Comment comment, HttpServletRequest request) {
         //随机生成评论id
        comment.setCid(IdUtil.simpleUUID());
        //评论者id
        String id = JwtUtils.getMemberIdByJwtToken(request);
        comment.setUserid(id);
        //根据用户id查找用户名称
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        UcenterMember u = ucenterMemberService.getOne(wrapper);
        comment.setAvator(u.getAvatar());
        comment.setUsername(u.getNickname());
        //创建时间
        String now = DateUtil.now();
        comment.setCreateTime(now);
        boolean b = commentService.save(comment);
        return b;
    }
    //    添加二级评论
//    @Override
//    public Boolean addCommentSecont(Comment comment, HttpServletRequest request) {
//        //随机生成评论id
//        comment.setCid(IdUtil.simpleUUID());
//        //评论者id
//        String id = JwtUtils.getMemberIdByJwtToken(request);
//        //根据用户id查找用户名称
//        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
//        wrapper.eq("id",id);
//        UcenterMember u = ucenterMemberService.getOne(wrapper);
//        comment.setAvator(u.getAvatar());
//        comment.setUsername(u.getNickname());
//        //创建时间
//        String now = DateUtil.now();
//        comment.setCreateTime(now);
//        boolean b = commentService.save(comment);
//        return null;
//    }
//查询一级评论
    @Override
    public List<Comment> selectBooksComments(String bid) {
        List<Comment> list = commentMapper.selectBooksComments(bid);
        return list;
    }
    //查询二级评论
    public Comment selectBooksSecondCommentsaaaa(String cid){
       Comment comment= commentMapper.selectBooksSecondComments(cid);//头评论
      List<Comment> list= commentMapper.selectBookSecond(cid);//评论的头评论的评论
        comment.setComments(list);
        comment.setSize(list.size());
        return comment;
    }




}
