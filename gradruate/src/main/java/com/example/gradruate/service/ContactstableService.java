package com.example.gradruate.service;

import com.example.gradruate.entity.Contactstable;
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
public interface ContactstableService extends IService<Contactstable> {

    Contactstable queryDialog(String otherid, String uid);
    //
    List<Contactstable> queryAllDialog(HttpServletRequest request);


}
