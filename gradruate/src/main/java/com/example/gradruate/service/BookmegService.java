package com.example.gradruate.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.gradruate.entity.Bookmeg;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gradruate.entity.Bookmegs;
import com.example.gradruate.entity.vo.BookTypeProportion;
import com.example.gradruate.entity.vo.BookTypes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author szm
 * @since 2022-11-26
 */

public interface BookmegService extends IService<Bookmeg> {

    List<Bookmeg> selectHotBook();

    Bookmeg selectBookById(String bid);
    List<Bookmeg> queryBook(@Param("bookmegs") String bookmeg);

    List<BookTypeProportion> getBookType();

    List<BookTypes> getBookTypes();

    List<String> getUserName();
    List<Bookmegs> selectMultBook(String bookmegs);
}
