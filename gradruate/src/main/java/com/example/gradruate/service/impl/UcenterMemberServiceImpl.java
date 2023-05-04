package com.example.gradruate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.gradruate.commonutils.GuliException;
import com.example.gradruate.entity.UcenterMember;
import com.example.gradruate.mapper.UcenterMemberMapper;
import com.example.gradruate.service.UcenterMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.gradruate.utils.JwtUtils;
import com.example.gradruate.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author szm
 * @since 2022-10-29
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {
   @Resource
   UcenterMemberMapper ucenterMemberMapper;
    @Override
    public UcenterMember getOpenIdMember(String openid) {
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("openid",openid);
        UcenterMember member = baseMapper.selectOne(wrapper);

        return member;
    }

    @Override
    public String login(UcenterMember member) {
        String mobile = member.getMobile();
        String password = member.getPassword();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
            throw  new GuliException(20001,"登录失败");
        }

        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        UcenterMember mobileMember = baseMapper.selectOne(wrapper);

        if(mobileMember == null){
            throw  new GuliException(20001,"登录失败");
        }

        if(!MD5.encrypt(password) .equals(mobileMember.getPassword())){
            throw  new GuliException(20001,"登录失败");
        }

        if (mobileMember.getIsDisabled()){
            throw  new GuliException(20001,"登录失败");
        }

        String jwtToken = JwtUtils.getJwtToken(mobileMember.getId(), mobileMember.getNickname());

        return jwtToken;
    }

    @Override
    public List<UcenterMember> queryParams(String params) {

        return ucenterMemberMapper.queryParams(params);
    }

    @Override
    public void register(UcenterMember ucenterMember) {
        String password = ucenterMember.getPassword();
        String encrypt = MD5.encrypt(password);
        ucenterMember.setPassword(encrypt);
        ucenterMember.setIsDisabled(false);
        ucenterMemberMapper.insert(ucenterMember);
    }

    @Override
    public UcenterMember getMemById(String id) {
        return ucenterMemberMapper.getMemById(id);
    }

    @Override
    public int updateMegById(UcenterMember ucenterMember) {
        return ucenterMemberMapper.updateMegById(ucenterMember);
    }
}
