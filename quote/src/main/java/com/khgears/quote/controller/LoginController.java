//package com.khgears.quote.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;
//
////import com.khgears.quote.config.WebSecurityConfig;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.SessionAttribute;
//
///**
// * 控制器
// *
// */
//@Controller
//public class LoginController {
//
////    @GetMapping("/")
////    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
////        model.addAttribute("name", account);
////        return "index";
////    }
////
////    @GetMapping("/login")
////    public String login() {
////        return "login";
////    }
//
//    @PostMapping("/loginPost")
//    public String loginPost(String account, String password, HttpSession session) {
//        Map<String, Object> map = new HashMap<>();
//        if (!"123456".equals(password)) {
//            map.put("success", false);
//            map.put("message", "密码错误");
//            return "redirect:/login";
//        }
//
//        // 设置session
//        session.setAttribute(WebSecurityConfig.SESSION_KEY, "agni");
//        session.setAttribute("username","agni.ye");
//
//        map.put("success", true);
//        map.put("message", "登录成功");
//        return "redirect:/";
//    }
//
//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//        // 移除session
//        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
//        return "redirect:/login";
//    }
//
//}