package com.example.gradruate.service.impl;

import com.example.gradruate.entity.Bookmeg;
import com.example.gradruate.entity.Bookmegs;
import com.example.gradruate.entity.UcenterMember;
import com.example.gradruate.entity.vo.BookTypeProportion;
import com.example.gradruate.entity.vo.BookTypes;
import com.example.gradruate.mapper.BookmegMapper;
import com.example.gradruate.service.BookmegService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.gradruate.service.UcenterMemberService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author szm
 * @since 2022-11-26
 */

@Service
public class BookmegServiceImpl extends ServiceImpl<BookmegMapper, Bookmeg> implements BookmegService {
    @Resource
    BookmegMapper bookmegMapper;
    @Autowired
    UcenterMemberService ucenterMemberService;
    @Autowired
    BookmegService bookmegService;

    @Override
    public List<Bookmegs> selectMultBook(String bookmegs) {
        return bookmegMapper.selectMultBook(bookmegs);
    }

    @Override
    public List<Bookmeg> selectHotBook() {
        List<Bookmeg> books= bookmegMapper.selectHotBook();
        for (Bookmeg b:books
        ) {
            QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();

            String uid1 = b.getUid();
            wrapper.eq("id",uid1);
            UcenterMember one = ucenterMemberService.getOne(wrapper);
           b.setUcenterMember(one);

        }
        return books;
    }
    //根据书本ID查找图书信息
    @Override
    public Bookmeg selectBookById(String bid) {
        QueryWrapper<Bookmeg> wrapper = new QueryWrapper<>();
        wrapper.eq("bid", bid);
        Bookmeg bookmeg =bookmegService.getOne(wrapper);
        return bookmeg;
    }

    @Override
    public List<Bookmeg> queryBook(String bookmeg) {
        return bookmegMapper.queryBook(bookmeg);
    }

    @Override
    public List<BookTypeProportion> getBookType() {
        return bookmegMapper.getBookType();
    }

    @Override
    public List<BookTypes> getBookTypes() {
        return bookmegMapper.getBookTypes();
    }

    @Override
    public List<String> getUserName() {
        return bookmegMapper.getUserName();
    }
    //多条件查询

}
