package com.example.gradruate.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.gradruate.entity.Messagetable;
import com.example.gradruate.entity.UcenterMember;
import com.example.gradruate.mapper.MessagetableMapper;
import com.example.gradruate.service.MessagetableService;
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
public class MessagetableServiceImpl extends ServiceImpl<MessagetableMapper, Messagetable> implements MessagetableService {
    @Autowired
    MessagetableService messagetableService;
    @Resource
    UcenterMemberService ucenterMemberService;
    //新增消息
    @Override
    public void addMessage(Messagetable messagetable, HttpServletRequest request) {
        String uid = JwtUtils.getMemberIdByJwtToken(request);
        messagetable.setUserID(uid);
        messagetable.setCreateTime(DateUtil.now());
        messagetableService.save(messagetable);

    }
    //根据ID查询信息
    List<Messagetable> list;
    @Override
    public List<Messagetable> ListMessage(String dialogID,HttpServletRequest request) {
        String uid = JwtUtils.getMemberIdByJwtToken(request);
        if (!uid.equals(dialogID)){
            QueryWrapper<Messagetable> messagetableQueryWrapper = new QueryWrapper<>();
            messagetableQueryWrapper.orderByAsc("createTime");
            messagetableQueryWrapper.eq("dialogID",dialogID);
            list= messagetableService.list(messagetableQueryWrapper);
            for (Messagetable c:list
            ) {
                QueryWrapper<UcenterMember> ucenterMemberQueryWrapper = new QueryWrapper<>();
                ucenterMemberQueryWrapper.eq("id",c.getUserID());
                UcenterMember one = ucenterMemberService.getOne(ucenterMemberQueryWrapper);
                c.setAvatar(one.getAvatar());
                c.setNickname(one.getNickname());

            }

        }

        return list;
    }
}
