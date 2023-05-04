package com.example.gradruate.controller;



import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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



    @PostMapping("register")
    public R registerUser(@RequestBody UcenterMember ucenterMember){
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        QueryWrapper<UcenterMember> mobile = wrapper.eq("mobile", ucenterMember.getMobile());
        UcenterMember one = memberService.getOne(mobile);
        if (one==null){
            memberService.register(ucenterMember);
            return R.ok().data("meg","ok");
        }

        return R.ok().data("meg","no");
    }


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

        List<UcenterMember> list=ucenterMemberMapper.queryParams(params);
        return R.ok().data("members",list);
    }


    //根据用户id 获取用户信息
    @GetMapping("getUserInfoOrder/{id}")
    public R getUserInfoOrder(@PathVariable String id){
        UcenterMember member = memberService.getMemById(id);

//        UcenterMemberOrder ucenterMemberOrder = new UcenterMemberOrder();
//        BeanUtils.copyProperties(member,ucenterMemberOrder);//将member对象里的内容复制到ucenterMemberOrder对象里
        return R.ok().data("member",member);
    }

    //根据用户id 获取用户信息
    @PostMapping("/updataMeg")
    public R updataMeg(@RequestBody UcenterMember ucenterMember){

        memberService.updateMegById(ucenterMember);

//        UcenterMemberOrder ucenterMemberOrder = new UcenterMemberOrder();
//        BeanUtils.copyProperties(member,ucenterMemberOrder);//将member对象里的内容复制到ucenterMemberOrder对象里
        return R.ok().data("member","ok");
    }
//    //查询某一天注册人数
//    @GetMapping("countRegister/{day}")
//    public R countRegister(@PathVariable String day){
//        Integer count=memberService.countRegisterDay(day);
//        return R.ok().data("countRegister",count);
//    }

}


