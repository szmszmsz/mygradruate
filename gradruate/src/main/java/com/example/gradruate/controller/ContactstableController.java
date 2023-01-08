package com.example.gradruate.controller;


import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.gradruate.commonutils.R;
import com.example.gradruate.entity.Contactstable;
import com.example.gradruate.service.impl.ContactstableServiceImpl;
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
 * @since 2022-12-15
 */
@RestController
@RequestMapping("/gradruate/contactstable")
@CrossOrigin
public class ContactstableController {

    @Autowired
    ContactstableServiceImpl contactstableService;
        /**查找是否有相应的对话框*/
    @GetMapping("/findDialog/{uid}")
    public R findDialog(@PathVariable("uid") String otherid, HttpServletRequest request){
        Contactstable dialogid=null;
        if(!otherid.equals("undefined")){
            dialogid=contactstableService.getDialog(otherid,request);
        }
        return R.ok().data("dialogid",dialogid);
    }

    /**查询登陆者的所有对话框*/
    @GetMapping("/queryDialog")
    public R queryDialog(HttpServletRequest request){
        System.out.println("######");
        List<Contactstable> dialogid=contactstableService.queryAllDialog(request);

        return R.ok().data("dialogids",dialogid);
    }

    /**查询登陆者的所有对话框*/
    @GetMapping("/delDialog/{contactsId}")
    public R delDialog(@PathVariable("contactsId") String contactsId){
        QueryWrapper<Contactstable> contactstableQueryWrapper = new QueryWrapper<>();
        contactstableQueryWrapper.eq("contactsId",contactsId);
        boolean b=contactstableService.remove(contactstableQueryWrapper);
        return R.ok().data("sucess","删除成功");
    }


}

