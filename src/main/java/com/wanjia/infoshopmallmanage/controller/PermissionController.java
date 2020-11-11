package com.wanjia.infoshopmallmanage.controller;

import com.wanjia.infoshopmallmanage.entity.Admin;
import com.wanjia.infoshopmallmanage.entity.Permission;
import com.wanjia.infoshopmallmanage.entity.Role;
import com.wanjia.infoshopmallmanage.service.PermissionService;
import com.wanjia.infoshopmallmanage.util.AuthJwtUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: wlj
 * @date: 2020/10/16 13:58
 * @version: 1.0
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Resource
    private PermissionService permissionService;
    @Autowired
    private HttpServletRequest request;
    /**
     * 所有角色
     * @return
     */
    @PostMapping("/getRole")
    public RestResponse getRole(@RequestBody Role role){
        return permissionService.getRole(role);
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("/addRole")
    public RestResponse addRole(@RequestBody Role role){
        String token = request.getHeader("Authorization");
        Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
        role.setCreateAdminId(adminId);
        return permissionService.addRole(role);
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @PostMapping("/updateRole")
    public RestResponse updateRole(@RequestBody Role role){
        return permissionService.updateRole(role);
    }

    /**
     * 添加权限资源
     * @param permission
     * @return
     */
    @PostMapping("/addPermission")
    public RestResponse addPermission(@RequestBody Permission permission){
        String token = request.getHeader("Authorization");
        Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
        permission.setCreateAdminId(adminId);
        return permissionService.addPermission(permission);
    }

    /**
     * 修改权限资源
     * @param permission
     * @return
     */
    @PostMapping("/updatePermission")
    public RestResponse updatePermission(@RequestBody Permission permission){
        return permissionService.updatePermission(permission);
    }

    /**
     * 查询权限资源
     * @param permission
     * @return
     */
    @PostMapping("/getPermission")
    public RestResponse getPermission(@RequestBody Permission permission){
        return permissionService.getPermission(permission);
    }

    /**
     * 查询角色信息及拥有的权限
     * @param roleId
     * @return
     */
    @GetMapping("/queryRole")
    public RestResponse queryRole(Long roleId){
        return permissionService.queryRole(roleId);
    }

    /**
     * 查询管理员
     * @param admin
     * @return
     */
    @PostMapping("/queryAdmin")
    public RestResponse queryAdmin(@RequestBody Admin admin){
        return permissionService.queryAdmin(admin);
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @PostMapping("/addAdmin")
    public RestResponse addAdmin(@RequestBody @Validated Admin admin){
        return permissionService.addAdmin(admin);
    }

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    @PostMapping("/updateAdmin")
    public RestResponse updateAdmin(@RequestBody Admin admin){
        return permissionService.updateAdmin(admin);
    }

    /**
     * 获取用户拥有的权限
     * @return
     */
    @GetMapping("/getAdminPermission")
    public RestResponse getAdminPermission(){
        String token = request.getHeader("Authorization");
        Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
        return permissionService.getAdminPermission(adminId);
    }

    /**
     * 获取登录用户信息
     * @return
     */
    @GetMapping("/AdminInfo")
    public RestResponse AdminInfo(){
        String token = request.getHeader("Authorization");
        Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
        return permissionService.AdminInfo(adminId);
    }
}
