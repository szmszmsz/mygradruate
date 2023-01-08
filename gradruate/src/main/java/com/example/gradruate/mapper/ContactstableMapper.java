package com.example.gradruate.mapper;

import com.example.gradruate.entity.Contactstable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author szm
 * @since 2022-12-15
 */
@Mapper
public interface ContactstableMapper extends BaseMapper<Contactstable> {

    Contactstable queryDialog(@Param("otherUid") String otherid, @Param("uid") String uid);

    Contactstable getOneContact(@Param("uid") String uid, @Param("otherUid") String otherid);
}
