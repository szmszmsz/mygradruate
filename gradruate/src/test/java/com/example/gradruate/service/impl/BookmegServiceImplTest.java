package com.example.gradruate.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.gradruate.commonutils.R;
import com.example.gradruate.controller.BookmegController;
import com.example.gradruate.entity.Bookmeg;
import com.example.gradruate.service.BookmegService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookmegServiceImplTest {
    @Autowired
    BookmegService bookmegService;
    @Test
    void getBookInfoLogList() {
        Page<Bookmeg> pageParam = new Page<>(1, 3);
//        Page<Bookmeg> bookInfoLogList =  bookmegService.getBookInfoLogList(pageNum, pageSize);
//        Page<Bookmeg> page = bookmegService.page(pageParam);//TODO
        List<Bookmeg> records = pageParam.getRecords();
//        System.out.println();

    }

    @Test
    void selectHotBook() {
        List<Bookmeg> bookmegs = bookmegService.selectHotBook();
//        for (Bookmeg b:bookmegs
//             ) {
//            System.out.println(b.getCreateTime());
//
//        }

    }

    @Test
    void selectBookById() {
        Bookmeg bookmeg = bookmegService.selectBookById("602sy");
        System.out.println(bookmeg.toString());
    }
}