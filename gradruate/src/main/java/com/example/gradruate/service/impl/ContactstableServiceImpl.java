package com.example.gradruate.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.gradruate.commonutils.R;
import com.example.gradruate.entity.Contactstable;
import com.example.gradruate.entity.UcenterMember;
import com.example.gradruate.mapper.ContactstableMapper;
import com.example.gradruate.service.ContactstableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.gradruate.service.UcenterMemberService;
import com.example.gradruate.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author szm
 * @since 2022-12-15
 */

@Service
public class ContactstableServiceImpl extends ServiceImpl<ContactstableMapper, Contactstable> implements ContactstableService {
    @Resource
    ContactstableMapper contactstableMapper;
    @Resource
    UcenterMemberService ucenterMemberService;
    @Resource
    ContactstableService contactstableService;
    Contactstable  onen=null;
    Contactstable  onen1=null;
    List<Contactstable> list;
    @Override
    public Contactstable queryDialog(String otherid, String uid) {
        return contactstableMapper.queryDialog(otherid, uid);
    }
    /**查询登录者的对话框*/
    @Override
    @Transactional
    public List<Contactstable> queryAllDialog(HttpServletRequest request) {
        String uid = JwtUtils.getMemberIdByJwtToken(request);

        if (uid.length() != 0){

        QueryWrapper<Contactstable> contactstableQueryWrapper = new QueryWrapper<>();
        contactstableQueryWrapper.eq("userID",uid);
//        contactstableQueryWrapper.eq("userID",uid).or().eq("OtherUserID", uid);
         list = contactstableService.list(contactstableQueryWrapper);

        for (Contactstable c:
        list) {
            QueryWrapper<UcenterMember> ucenterMemberQueryWrapper = new QueryWrapper<>();
            //判断对方id
            if(uid.equals(c.getOtherUserID())){
                ucenterMemberQueryWrapper.eq("id",c.getUserID());
            }else{
                ucenterMemberQueryWrapper.eq("id",c.getOtherUserID());
            }
            UcenterMember one = ucenterMemberService.getOne(ucenterMemberQueryWrapper);
            c.setAvatar(one.getAvatar());
            c.setNickname(one.getNickname());
        }
        }
        return list;
    }

//添加对话框
    public Contactstable getDialog(String otherid, HttpServletRequest request) {

        String uid = JwtUtils.getMemberIdByJwtToken(request);
        QueryWrapper<Contactstable> contactstableQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Contactstable> contactstableQueryWrapper1 = new QueryWrapper<>();
//        contactstableQueryWrapper.eq("userID", uid).or().eq("userID", otherid).eq("OtherUserID", otherid).or().eq("OtherUserID", uid);;
//
        contactstableQueryWrapper.eq("userID", uid).eq("OtherUserID", otherid);
        contactstableQueryWrapper1.eq("userID", otherid).eq("OtherUserID", uid);

        if (uid.length() != 0 && !otherid.equals(uid)) {//!otherid.equals(uid),自己与自己不能建立对话框
            onen = contactstableService.getOne(contactstableQueryWrapper);
            onen1 = contactstableService.getOne(contactstableQueryWrapper1);

            if (onen == null&& onen1==null) {
//            等于空就新建一个对话框
                String s = IdUtil.randomUUID();
                Contactstable contactstable = new Contactstable(uid, otherid,s);
                Contactstable contactstable1 = new Contactstable(otherid,uid,s);
                contactstableService.save(contactstable1);
                contactstableService.save(contactstable);

                return contactstable;
            }
            if (onen == null&& onen1!=null){
                String dialogID = onen1.getDialogID();
                Contactstable contactstable = new Contactstable(uid, otherid,dialogID);
                contactstableService.save(contactstable);

                return contactstable;
            }else if(onen != null&& onen1==null){

                String dialogID = onen.getDialogID();
                Contactstable contactstable1 = new Contactstable(otherid,uid,dialogID);
                contactstableService.save(contactstable1);

                return onen1;
            }


        }

            return onen;
    }
}