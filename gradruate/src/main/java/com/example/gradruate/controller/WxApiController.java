package com.example.gradruate.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import cn.hutool.json.JSONArray;
import com.alibaba.fastjson.JSON;
import com.example.gradruate.entity.UcenterMember;
import com.example.gradruate.service.UcenterMemberService;
import com.example.gradruate.utils.ConstantWxUtils;
import com.example.gradruate.utils.HttpClientUtils;
import com.example.gradruate.utils.JwtUtils;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

@CrossOrigin
@Controller
@RequestMapping("/educenter/wx")
public class WxApiController {
    @Autowired
    private UcenterMemberService memberService;
    String jwtToken;

    @GetMapping("callback")
    public String callback(String code, String state, HttpServletResponse response){
       try {
//
////            从redis中将state获取出来，和当前传入的state作比较
////            如果一致则放行，如果不一致则抛出异常：非法访问
//
////            向认证服务器发送请求换取access_token
            String baseAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                    "?appid=%s" +
                    "&secret=%s" +
                    "&code=%s" +
                    "&grant_type=authorization_code";

            String accectTokenUrl = String.format(
                    baseAccessTokenUrl,
                    ConstantWxUtils.WX_OPEN_APP_ID,
                    ConstantWxUtils.WX_OPEN_APP_SECRET,
                    code
            );
            String accessTokenInfo = HttpClientUtils.get(accectTokenUrl);

            Gson gson = new Gson();
            HashMap mapAccessToken = gson.fromJson(accessTokenInfo, HashMap.class);
            String access_token = (String)mapAccessToken.get("access_token");
            String openid = (String)mapAccessToken.get("openid");
//////            ===============================================================================
////
////
//////=======================================================================================================
         UcenterMember member= memberService.getOpenIdMember(openid);//扫描后获取微信的openId,到数据库中查询，如果有就没必要根据openID继续查微信的昵称和头像，直接登录就可以了

        if (member==null){
//             //访问微信的资源服务器，获取用户信息
             String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                     "?access_token=%s" +
                    "&openid=%s";
//
            String userInfoUrl = String.format(baseUserInfoUrl, access_token, openid);
            String userInfo = HttpClientUtils.get(userInfoUrl);



             HashMap userInfoMap = gson.fromJson(userInfo, HashMap.class);
            String nickname =(String) userInfoMap.get("nickname");
            String headimgurl =(String) userInfoMap.get("headimgurl");
             member = new UcenterMember();
           member.setOpenid(openid);
            member.setNickname(nickname);
             member.setAvatar(headimgurl);
             member.setGmtCreate( DateUtil.today());
             memberService.save(member);
            jwtToken = JwtUtils.getJwtToken(member.getId(), member.getNickname());
            return "redirect:http://localhost:3000?token="+jwtToken;
//            Cookie cookie = new Cookie("guli_ucenter",jwtToken);
//            response.addCookie(cookie);
        }else{
            jwtToken = JwtUtils.getJwtToken(member.getId(), member.getNickname());

//            Cookie cookie = new Cookie("guli_ucenter",jwtToken);
//            response.addCookie(cookie);
            return "redirect:http://localhost:3000?token="+jwtToken;
//            return "redirect:http://localhost:3000?token="+jwtToken;
//            return "redirect:http://localhost:3000";
//            return "redirect:http://www.baidu.com";
        }
//}
       }catch (Exception e){
            e.printStackTrace();

        }
       finally {

       }
//        Cookie cookie = new Cookie("guli_ucenter",jwtToken);
//        response.addCookie(cookie);
//        return "redirect:http://localhost:3000";
        return "redirect:http://localhost:3000";
    }





    @GetMapping("login")
    public String getWxCode(){
        // 微信开放平台授权baseUrl
        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";

       String redirectUrl= ConstantWxUtils.WX_OPEN_REDIRECT_URL;
        try {
            redirectUrl = URLEncoder.encode(redirectUrl, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = String.format(
                baseUrl,
                ConstantWxUtils.WX_OPEN_APP_ID,
                redirectUrl,
                "atguigu"
        );
        return "redirect:"+url;
    }
}