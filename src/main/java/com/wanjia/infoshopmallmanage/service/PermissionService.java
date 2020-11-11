package com.wanjia.infoshopmallmanage.service;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.wanjia.infoshopmallmanage.entity.*;
import com.wanjia.infoshopmallmanage.mapper.*;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import com.wanjia.infoshopmallmanage.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

/**
 * @author: wlj
 * @date: 2020/10/12 17:27
 * @version: 1.0
 */
@Service
public class PermissionService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    /**
     * 获取用户角色
     * @param adminId
     * @return
     */
    public Role findRoleByAdminId(Long adminId) {
        return roleMapper.findRoleByAdminId(adminId);
    }

    /**
     * 获取角色权限
     * @param roleId
     * @return
     */
    public List<Permission> findPermsByRoleId(Long roleId){
        return permissionMapper.selectByRoleId(roleId);
    }

    /**
     * 所有角色
     * @return
     */
    public RestResponse getRole(Role role){
        List<Role> list = roleMapper.queryAll(role);
        return RestResponse.ok("查询成功",list);
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    public RestResponse addRole(Role role) {
        role.setCreateTime(new Date());
        if(roleMapper.insert(role)>0){
            //添加角色权限
            if (role.getPermissionIds() != null && !role.getPermissionIds().isEmpty()) {
                rolePermissionMapper.insertPermission(role.getRoleId(), role.getPermissionIds());
            }
            return RestResponse.ok("添加成功");
        }
        return RestResponse.fail("添加失败");
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    public RestResponse updateRole(Role role) {
        role.setUpdateTime(new Date());
        //超级管理员不能修改
        if(role.getRoleId()!=null && role.getRoleId()==1){
            return RestResponse.fail("非法操作");
        }
        if(roleMapper.update(role)>0){
            //删除之前的权限
            rolePermissionMapper.deleteByRoleId(role.getRoleId());
            //重新添加权限
            if( role.getPermissionIds() != null && !role.getPermissionIds().isEmpty()){
                rolePermissionMapper.insertPermission(role.getRoleId(), role.getPermissionIds());
            }
            return RestResponse.ok("修改成功");
        }
        return RestResponse.fail("修改失败");
    }

    /**
     * 添加权限资源
     * @param permission
     * @return
     */
    public RestResponse addPermission(Permission permission) {
        permission.setCreateTime(new Date());
        if(permissionMapper.insert(permission)>0){
            //给超级管理员添加权限
            RolePermission rolePermission = new RolePermission();
            rolePermission.setPermissionId(permission.getId());
            rolePermission.setRoleId(1L);
            rolePermissionMapper.insert(rolePermission);

            return RestResponse.ok("添加成功");
        }
        return RestResponse.fail("添加失败");
    }

    public RestResponse updatePermission(Permission permission){
        permission.setUpdateTime(new Date());
        if(permissionMapper.update(permission)>0){
            return RestResponse.ok("操作成功");
        }
        return RestResponse.fail("操作失败");
    }

    /**
     * 查询权限资源
     * @param permission
     * @return
     */
    public RestResponse getPermission(Permission permission){
        List<Permission> list = permissionMapper.queryAll(permission);
        return RestResponse.ok("查询成功", TreeUtil.createTree(list,"id","parentId","children"));
    }

    /**
     * 查询角色信息及拥有的权限
     * @param roleId
     * @return
     */
    public RestResponse queryRole(Long roleId){
        Role role = roleMapper.queryById(roleId);
        if(role != null){
            role.setPermissionIds(rolePermissionMapper.rolePermissionByRoleId(roleId));
            return RestResponse.ok("查询成功",role);
        }
        return RestResponse.fail("查询失败");
    }

    /**
     * 查询管理员
     * @param admin
     * @return
     */
    public RestResponse queryAdmin(Admin admin){
        int page = 1;
        int pageSize = 20;
        if(admin.getPage() != null){
            page = admin.getPage();
        }
        if(admin.getPageSize() != null){
            pageSize = admin.getPageSize();
        }
        PageMethod.startPage(page,pageSize);
        List<Admin> list = adminMapper.conditionQuery(admin);
        int total =(int) new PageInfo<Admin>(list).getTotal();
        return RestResponse.ok("查询成功",list).put("total",total);
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    public RestResponse addAdmin(Admin admin){
        if(adminMapper.insert(admin)>0){
            //添加角色
            AdminRole adminRole = new AdminRole();
            adminRole.setAdminId(admin.getId());
            adminRole.setRoleId(admin.getRoleId());
            adminRoleMapper.insert(adminRole);
            return RestResponse.ok("添加成功");
        }
        return RestResponse.fail("添加失败");
    }

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    public RestResponse updateAdmin(Admin admin) {
        if (adminMapper.update(admin) > 0) {
            //修改角色
            if (admin.getRoleId() != null) {
                AdminRole adminRole = new AdminRole();
                adminRole.setAdminId(admin.getId());
                adminRole.setRoleId(admin.getRoleId());
                adminRoleMapper.update(adminRole);
            }
            return RestResponse.ok("修改成功");
        }
        return RestResponse.fail("修改失败");
    }

    /**
     * 获取管理员拥有的权限
     * @return
     */
    public RestResponse getAdminPermission(Long adminId){
        Role role = roleMapper.findRoleByAdminId(adminId);
        if(role == null){
            return RestResponse.fail("该用户角色不存在或已被禁用");
        }
        List<Permission> list = permissionMapper.selectByRoleId(role.getRoleId());
        return RestResponse.ok("查询成功",TreeUtil.createTree(list,"id","parentId","children"));
    }

    /**
     * 获取登录用户信息
     * @param adminId
     * @return
     */
    public RestResponse AdminInfo(Long adminId){
        Admin admin = adminMapper.queryById(adminId);
        return RestResponse.ok("查询成功",admin);
    }
}
