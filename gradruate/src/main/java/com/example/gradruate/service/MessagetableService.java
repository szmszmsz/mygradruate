package com.example.gradruate.service;

import com.example.gradruate.entity.Messagetable;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author szm
 * @since 2022-12-15
 */
public interface MessagetableService extends IService<Messagetable> {

    void addMessage(Messagetable messagetable, HttpServletRequest request);

    List<Messagetable> ListMessage(String dialogID,HttpServletRequest request);
}
