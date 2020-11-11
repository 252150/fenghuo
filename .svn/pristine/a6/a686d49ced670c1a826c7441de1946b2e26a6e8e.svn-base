package com.wanjia.infoshopmallmanage.controller;

import com.wanjia.infoshopmallmanage.service.LoginService;
import com.wanjia.infoshopmallmanage.util.AuthJwtUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: wlj
 * @date: 2020/10/13 11:13
 * @version: 1.0
 */
@RestController
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private HttpServletRequest request;

    /**
     *  登录- 账号密码登录
     * @return
     */
    @PostMapping("/login")
    public RestResponse login(@RequestBody Map<String,Object> map){
        String account = "";
        if(map.containsKey("account")){
            account =  map.get("account").toString();
        }

        String password = "";
        if(map.containsKey("password")){
            password =  map.get("password").toString();
        }
        return loginService.login(account,password);
    }
    @GetMapping("/logout")
    public RestResponse logout(){
        return RestResponse.ok("退出成功");
    }

    /**
     * 修改密码
     * @param map
     * @return
     */
    @PostMapping("/changePassword")
    public RestResponse changePassword(@RequestBody Map<String,Object> map){
        String token = request.getHeader("Authorization");
        Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
        map.put("adminId",adminId);
        return loginService.changePassword(map);
    }

}
