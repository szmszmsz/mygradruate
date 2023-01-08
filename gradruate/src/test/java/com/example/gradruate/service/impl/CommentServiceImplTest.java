package com.example.gradruate.service.impl;

import com.example.gradruate.entity.Comment;
import com.example.gradruate.mapper.CommentMapper;
import com.example.gradruate.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceImplTest {
@Autowired
    CommentServiceImpl commentService;
@Autowired
    CommentMapper commentMapper;
    @Test
    void selectBooksComments() {
        List<Comment> m1058 = commentService.selectBooksComments("m1058");
        for (Comment m:m1058
             ) {
            System.out.println(m.toString());
        }
    }

    @Test
    void testSelectBooksComments() {
        List<Comment> m1058 = commentMapper.selectBooksComments("m1058");
        for (Comment m:m1058
        ) {
            System.out.println(m.toString());
        }
    }

    @Test
    void testSelectBooksComments1() {
        commentMapper.selectBooksComments("9eff1830fe934161a49e324fe8a76a4f");
    }

    @Test
    void selectBooksSecondComments() {
        Comment comment = commentService.selectBooksSecondCommentsaaaa("9eff1830fe934161a49e324fe8a76a4f");
        for (Comment co:comment.getComments()
             ) {
            System.out.println(co.toString()+"@@@@@@@@2");

        }
    }
}