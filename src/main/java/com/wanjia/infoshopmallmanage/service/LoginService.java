package com.wanjia.infoshopmallmanage.service;

import com.wanjia.infoshopmallmanage.entity.Admin;
import com.wanjia.infoshopmallmanage.mapper.AdminMapper;
import com.wanjia.infoshopmallmanage.util.AuthJwtUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wlj
 * @date: 2020/10/13 11:16
 * @version: 1.0
 */
@Slf4j
@Service
public class LoginService {
    @Autowired
    private AdminMapper adminMapper;
    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    public RestResponse login(String account, String password) {
        Admin admin = adminMapper.selectByAccountAndPwd(account,password);
        if(admin != null){
            Map<String,Object> map = new HashMap<>();
            map.put("adminId",admin.getId());
            String token = AuthJwtUtil.sign(map);
            return RestResponse.ok("登录成功",token);
        }else{
            return RestResponse.fail("账户不存在或密码错误");
        }
    }

    /**
     * 修改密码
     * @param map
     * @return
     */
    public RestResponse changePassword(Map<String, Object> map) {
        if(adminMapper.changePassword(map)>0){
            return RestResponse.ok("修改密码成功");
        }
        return RestResponse.fail("修改密码失败");
    }
}
