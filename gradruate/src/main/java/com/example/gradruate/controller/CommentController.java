package com.example.gradruate.controller;


import com.example.gradruate.commonutils.R;
import com.example.gradruate.entity.Bookmeg;
import com.example.gradruate.entity.Com;
import com.example.gradruate.entity.Comment;
import com.example.gradruate.service.CommentService;
import com.example.gradruate.service.impl.CommentServiceImpl;
import com.example.gradruate.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author szm
 * @since 2022-12-04
 */
@RestController
@RequestMapping("/gradruate/comment")
@CrossOrigin
public class CommentController {
    @Autowired
    CommentServiceImpl commentServices;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentServiceImpl commentServicei
            ;
//    添加一级评论和二级评论
    @PostMapping("/firstComment")
    public R addCommentFirst(@RequestBody Comment comment, HttpServletRequest request){
        String id = JwtUtils.getMemberIdByJwtToken(request);
        comment.setUserid(id);
        Boolean i= commentService.addCommentFirst(comment,request);
            if(i==true){
                return R.ok().data("meg","评论成功");
            }
            else {
                return R.ok().data("meg","评论失败");
            }
    }
//添加二级评论
//    @GetMapping("/secondComment")//pid记录的是一级评论的主键，
//    public R getcomment(@RequestBody Comment comment, HttpServletRequest request){
//        String id = JwtUtils.getMemberIdByJwtToken(request);
//        comment.setUserid(id);
//        Boolean i=commentService.addCommentSecont(comment,request);
//        return R.ok().data("meg","okkkkkkkkkkkkkkkkkkkkkkk");
//    }
//查询所有一级评论 TODO(添加分页)
    @GetMapping("/list/{bid}")//bid为书本id
    public R getListComment(@PathVariable("bid") String bid){
      List<Comment> listFirst= commentService.selectBooksComments(bid);//查询一级评论
//        List<Comment> listSecond= commentService.selectBooksSecondComments(bid);
        return R.ok().data("list",listFirst);

    }
    //查询二级评论
    @GetMapping("/queryScond/{cid}")//cid为评论的唯一主键
    public R getListSecondComment(@PathVariable("cid") String cid){
       Comment comment = commentServices.selectBooksSecondCommentsaaaa(cid);

        return R.ok().data("list",comment);

    }
    @GetMapping("/test")//cid为评论的唯一主键
    public R getListtest(){

        return R.ok().data("meg",1);

    }
}

