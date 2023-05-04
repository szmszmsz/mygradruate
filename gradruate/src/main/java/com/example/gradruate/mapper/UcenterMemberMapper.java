package com.example.gradruate.mapper;

import com.example.gradruate.entity.UcenterMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author szm
 * @since 2022-10-29
 */
@Mapper
public interface UcenterMemberMapper extends BaseMapper<UcenterMember> {

    List<UcenterMember> queryParams(@Param("params") String params);

    UcenterMember getMemById(@Param("id")String id);

    int updateMegById(@Param("ucenterMember")UcenterMember ucenterMember);
}
