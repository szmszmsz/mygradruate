package com.example.gradruate.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.gradruate.commonutils.CommonPage;
import com.example.gradruate.commonutils.R;
import com.example.gradruate.entity.Bookmeg;
import com.example.gradruate.entity.Com;
import com.example.gradruate.entity.UcenterMember;
import com.example.gradruate.service.BookmegService;
import com.example.gradruate.service.UcenterMemberService;
import com.example.gradruate.service.impl.UcenterMemberServiceImpl;
import com.example.gradruate.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author szm
 * @since 2022-11-26
 */
@RestController
@RequestMapping("/gradruate/bookmeg")
@CrossOrigin
public class BookmegController {
    /**
     * 根据用户ID添加图书
     * */
    @Autowired
    BookmegService bookmegService;

    @Autowired
    UcenterMemberServiceImpl ucenterMemberService;
//添加图书
    @PostMapping("/add")
    public  R addBook(@RequestBody Bookmeg bookmeg, HttpServletRequest request){
        String id = JwtUtils.getMemberIdByJwtToken(request);
        bookmeg.setUid(id);
        String bid = RandomUtil.randomString(5);
        bookmeg.setBid(bid);
        bookmeg.setCreateTime( DateUtil.now());

        boolean save = bookmegService.save(bookmeg);
        if (save==true){
            return R.ok().data("meg","添加成功");
        }else {
            return   R.ok().data("meg","失败");
        }
    }
    /**
     * 根据用户ID查找出图书并分页
     * */
    @GetMapping("/get")
    public R selectBookByUId(HttpServletRequest request){
        String uid = JwtUtils.getMemberIdByJwtToken(request);
        QueryWrapper<Bookmeg> wrapper = new QueryWrapper<>();
         wrapper.eq("uid", uid);
        List<Bookmeg> list = bookmegService.list(wrapper);

        return R.ok().data("list",list);
    }
//传入页码和页数查找图书
    @GetMapping("/page/{pageNum}/{pageSize}")
    public R selectBookByPage(@PathVariable(value = "pageSize") Integer pageSize,
                              @PathVariable(value = "pageNum") Integer pageNum,HttpServletRequest request){
        String uid = JwtUtils.getMemberIdByJwtToken(request);
        QueryWrapper<Bookmeg> wrapper = new QueryWrapper<>();
        wrapper.eq("uid", uid);
        Page<Bookmeg> pageParam = new Page<>(pageNum, pageSize);
        bookmegService.page(pageParam);//TODO
        bookmegService.page(pageParam,wrapper);
        List<Bookmeg> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("records", records).data("meg",total);
    }
//获取热门图书（按时间获取）
    @GetMapping("/hotBook")
    public R selectHotBook(){
      List<Bookmeg> books= bookmegService.selectHotBook();
        return R.ok().data("hotbook",books);
    }

    //根据书本ID查找图书信息(我的信息)
    @GetMapping("/getbook/{bid}")
    public R selectBookById(@PathVariable("bid") String bid){
        Bookmeg book= bookmegService.selectBookById(bid);
        return R.ok().data("book",book);
    }
    //查询所有图书并分页（首页的）
    @GetMapping("/indexPage/{pageNum}/{pageSize}")
    public R selectIndexBookByPage(@PathVariable(value = "pageSize") Integer pageSize,
                              @PathVariable(value = "pageNum") Integer pageNum,HttpServletRequest request){
        Page<Bookmeg> pageParam = new Page<>(pageNum, pageSize);
        bookmegService.page(pageParam);//TODO
        bookmegService.page(pageParam);
        List<Bookmeg> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("records", records).data("meg",total);
    }


    //查询所有图书不分页（首页的）
    @GetMapping("/indexPage")
    public R selectIndexBook(HttpServletRequest request){
        List<Bookmeg> list = bookmegService.list();
        for (Bookmeg b:list
             ) {
            QueryWrapper<UcenterMember> ucenterMemberQueryWrapper = new QueryWrapper<>();
            ucenterMemberQueryWrapper.eq("id",b.getUid());
            UcenterMember one = ucenterMemberService.getOne(ucenterMemberQueryWrapper);
            b.setUcenterMember(one);
        }
        return R.ok().data("records", list).data("meg",list.size());
    }

    //查询图书分类不分页
    @GetMapping("/typeBook/{typeName}")
    public R selectTypeBook(@PathVariable(value = "typeName") String typeName,HttpServletRequest request){
        QueryWrapper<Bookmeg> bookmegQueryWrapper = new QueryWrapper<>();
        bookmegQueryWrapper.eq("genre",typeName);
        List<Bookmeg> list = bookmegService.list(bookmegQueryWrapper);
        for (Bookmeg bookmeg:list
             ) {
            QueryWrapper<UcenterMember> ucenterMemberQueryWrapper = new QueryWrapper<>();
            ucenterMemberQueryWrapper.eq("id",bookmeg.getUid());
            UcenterMember one = ucenterMemberService.getOne(ucenterMemberQueryWrapper);
            bookmeg.setUcenterMember(one);

        }
        
        return R.ok().data("records", list).data("meg",list.size());
    }
    @GetMapping("/query/{bookmeg}")
    public R  queryBook(@PathVariable("bookmeg") String bookmeg){
        List<Bookmeg> bookmegs = bookmegService.queryBook(bookmeg);

        return R.ok().data("list",bookmegs);
    }
    //删除书籍id
    @GetMapping("/delete/{bid}")
    public R deleteBookByBid(@PathVariable("bid") String bid){
        QueryWrapper<Bookmeg> bookmegQueryWrapper = new QueryWrapper<>();
        bookmegQueryWrapper.eq("bid" ,bid);
        boolean remove = bookmegService.remove(bookmegQueryWrapper);
        return R.ok().data("remove","删除成功");
    }

}

