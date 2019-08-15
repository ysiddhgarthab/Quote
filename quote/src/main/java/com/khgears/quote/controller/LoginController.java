package com.khgears.quote.controller;

import com.khgears.quote.config.WebSecurityConfig;
import com.khgears.quote.pojo.Quote;
import com.khgears.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


/**
 * 控制器
 *
 */
@Controller
public class LoginController {
    @Autowired
    QuoteService quoteService;

    //密码加密
    public static String encodeByMd5(String string) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        Base64.Encoder base64Encoder = Base64.getEncoder();
        //第一次加密
        String firstEncode = base64Encoder.encodeToString(md5.digest(string.getBytes("utf-8")));
        //第二次加密
        String secondEncode = base64Encoder.encodeToString(md5.digest(firstEncode.getBytes("utf-8")));
        // 加密字符串
        return base64Encoder.encodeToString(md5.digest(secondEncode.getBytes("utf-8")));
    }

    @PostMapping("/loginPost")
    public String loginPost(String account, String password, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String, Object> map = new HashMap<>();
        Quote h=quoteService.get(38);
        System.out.println(h.getItemcode());
        System.out.println(encodeByMd5(password));
        if (!"123456".equals(password)) {
            map.put("success", false);
            map.put("message", "密码错误");
            return "redirect:/login";
        }

        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, "user");
        session.setAttribute("username","agni.ye");

        map.put("success", true);
        map.put("message", "登录成功");
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }

}