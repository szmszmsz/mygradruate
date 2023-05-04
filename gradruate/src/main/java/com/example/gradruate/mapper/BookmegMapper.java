package com.example.gradruate.mapper;

import com.example.gradruate.entity.Bookmeg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.gradruate.entity.Bookmegs;
import com.example.gradruate.entity.vo.BookTypeProportion;
import com.example.gradruate.entity.vo.BookTypes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author szm
 * @since 2022-11-26
 */
@Mapper
public interface BookmegMapper extends BaseMapper<Bookmeg> {

    List<Bookmeg> selectHotBook();
    List<Bookmeg> queryBook(@Param("bookmegs") String bookmeg);

    List<BookTypeProportion> getBookType();

    List<BookTypes> getBookTypes();

    List<String> getUserName();

    List<Bookmegs> selectMultBook(@Param("bookmegs") String bookmegs);
}
