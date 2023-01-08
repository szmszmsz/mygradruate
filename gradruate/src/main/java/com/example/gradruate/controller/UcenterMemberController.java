package com.example.gradruate.controller;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONParser;
import cn.hutool.json.JSONUtil;
import com.example.gradruate.commonutils.R;
import com.example.gradruate.entity.UcenterMember;
import com.example.gradruate.mapper.UcenterMemberMapper;
import com.example.gradruate.service.UcenterMemberService;
import com.example.gradruate.utils.JwtUtils;
import com.google.gson.JsonArray;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-09-08
 */
@RestController
@RequestMapping("/member")
@CrossOrigin
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService memberService;
    @Resource
    UcenterMemberMapper ucenterMemberMapper;
    @PostMapping("login")
    public R loginUser(@RequestBody UcenterMember member){
        String token=memberService.login(member);
        return R.ok().data("token",token);
    }
//
//    @PostMapping("register")
//    public R registerUser(@RequestBody RegisterVo registerVo){
//        memberService.register(registerVo);
//        return R.ok();
//    }


    @GetMapping("getMemberInfo")
    public R getMemberInfo(HttpServletRequest request){
        String id = JwtUtils.getMemberIdByJwtToken(request);
        UcenterMember member = memberService.getById(id);
        return R.ok().data("userInfo",member.toString());
    }

    @GetMapping("/wcgetMemberInfo")
    public R getwcMemberInfo(HttpServletRequest request){
        String id = JwtUtils.getMemberIdByJwtToken(request);
        UcenterMember member = memberService.getById(id);
        return R.ok().data("userInfo",JSONUtil.toJsonStr(member));
    }
    /**
     * 获取所有注册人员信息
     * */
    @GetMapping("/getAllMembers")
    public R getAllMembers(){
        List<UcenterMember> list = memberService.list();
        return R.ok().data("members",list);
    }

    /**
     * 多条件查询
     * */
    @GetMapping("/queryParams/{params}")
    public R queryParams(@PathVariable("params") String params){
        System.out.println(params);
        List<UcenterMember> list=ucenterMemberMapper.queryParams(params);
        return R.ok().data("members",list);
    }


//    //根据用户id 获取用户信息
//    @PostMapping("getUserInfoOrder/{id}")
//    public UcenterMemberOrder getUserInfoOrder(@PathVariable String id){
//        UcenterMember member = memberService.getById(id);
//        UcenterMemberOrder ucenterMemberOrder = new UcenterMemberOrder();
//        BeanUtils.copyProperties(member,ucenterMemberOrder);//将member对象里的内容复制到ucenterMemberOrder对象里
//        return ucenterMemberOrder;
//    }
//    //查询某一天注册人数
//    @GetMapping("countRegister/{day}")
//    public R countRegister(@PathVariable String day){
//        Integer count=memberService.countRegisterDay(day);
//        return R.ok().data("countRegister",count);
//    }

}


