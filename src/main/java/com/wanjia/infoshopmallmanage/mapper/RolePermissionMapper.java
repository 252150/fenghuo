package com.wanjia.infoshopmallmanage.mapper;

import com.wanjia.infoshopmallmanage.entity.RolePermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (RolePermission)表数据库访问层
 *
 * @author wlj
 * @date 2020-09-27 13:33:45
 */
public interface RolePermissionMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RolePermission queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RolePermission> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rolePermission 实例对象
     * @return 对象列表
     */
    List<RolePermission> queryAll(RolePermission rolePermission);

    /**
     * 新增数据
     *
     * @param rolePermission 实例对象
     * @return 影响行数
     */
    int insert(RolePermission rolePermission);

    /**
     * 修改数据
     *
     * @param rolePermission 实例对象
     * @return 影响行数
     */
    int update(RolePermission rolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 批量给角色添加权限
     * @param roleId
     * @param permissionIds
     * @return
     */
    int insertPermission(@Param("roleId") Long roleId,@Param("permissionIds") List<Long> permissionIds);

    /**
     * 删除角色权限
     * @param roleId
     * @return
     */
    int deleteByRoleId(Long roleId);

    /**
     * 根据角色id查询权限id
     * @param roleId
     * @return
     */
    List<Long> rolePermissionByRoleId(Long roleId);
}