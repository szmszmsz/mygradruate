package com.example.gradruate;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.gradruate.entity.Bookmeg;
import com.example.gradruate.service.BookmegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class Tsest {
    @Autowired
    BookmegService bookmegService;
   @Test
    public void Mytest(){
//       String bytes = RandomUtil.randomString(5);
////
////       System.out.println(bytes);
//
       //当前时间
       Date date = DateUtil.date();
      System.out.println(date);
//当前时间
       Date date2 = DateUtil.date(Calendar.getInstance());
      System.out.println(date2);
//当前时间
       Date date3 = DateUtil.date(System.currentTimeMillis());
      System.out.println(date3);
//当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
       String now = DateUtil.now();
      System.out.println(now);
//当前日期字符串，格式：yyyy-MM-dd
       String today= DateUtil.today();
       DateUtil.parse(today);
      System.out.println(DateUtil.parse( DateUtil.today()));
//       QueryWrapper<Bookmeg> wrapper = new QueryWrapper<>();
//       wrapper.eq("uid", "1");
//       List<Bookmeg> list = bookmegService.list(wrapper);

   }
}
