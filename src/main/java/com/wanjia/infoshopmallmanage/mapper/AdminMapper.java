package com.wanjia.infoshopmallmanage.mapper;

import com.wanjia.infoshopmallmanage.entity.Admin;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (Admin)表数据库访问层
 *
 * @author wlj
 * @date 2020-10-13 16:27:31
 */
public interface AdminMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Long id);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
   Admin  queryBysId(Long id);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param admin 实例对象
     * @return 对象列表
     */
    List<Admin> conditionQuery(Admin admin);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 根据账号密码查询
     * @param account
     * @param password
     * @return
     */
    Admin selectByAccountAndPwd(@Param("account") String account,@Param("password") String password);

    /**
     * 修改密码
     * @param map
     * @return
     */
    int changePassword(Map<String, Object> map);
}