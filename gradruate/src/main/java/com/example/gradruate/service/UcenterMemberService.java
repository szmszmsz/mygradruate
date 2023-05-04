package com.example.gradruate.service;

import com.example.gradruate.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author szm
 * @since 2022-10-29
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    UcenterMember getOpenIdMember(String openid);

    String login(UcenterMember member);

    List<UcenterMember> queryParams(@Param("params") String params);

    void register(UcenterMember ucenterMember);

    UcenterMember getMemById(String id);

    int updateMegById(UcenterMember ucenterMember);
}
