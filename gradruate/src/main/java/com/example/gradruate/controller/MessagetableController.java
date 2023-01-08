package com.example.gradruate.controller;


import com.example.gradruate.commonutils.R;
import com.example.gradruate.entity.Messagetable;
import com.example.gradruate.service.MessagetableService;
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
@RequestMapping("/gradruate/messagetable")
@CrossOrigin
public class MessagetableController {
    @Autowired
    MessagetableService messagetableService;
    //存留言
    @PostMapping("/addMessage")
    public R addMessage(@RequestBody Messagetable messagetable, HttpServletRequest request){
        messagetableService.addMessage(messagetable,request);
        return R.ok().data("meg","发送成功");
    }
    //根据对话框查留言
    @GetMapping("/listMessage/{dialogID}")
    public R ListMessage(@PathVariable("dialogID") String dialogID,HttpServletRequest request){
       List<Messagetable> list= messagetableService.ListMessage(dialogID,request);
        return R.ok().data("list",list);
    }
}

