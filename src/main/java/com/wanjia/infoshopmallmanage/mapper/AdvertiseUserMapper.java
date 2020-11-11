package com.wanjia.infoshopmallmanage.mapper;

import com.wanjia.infoshopmallmanage.entity.AdvertiseUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (AdvertiseUser)表数据库访问层
 *
 * @author wlj
 * @date 2020-09-27 13:33:44
 */
public interface AdvertiseUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdvertiseUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AdvertiseUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param advertiseUser 实例对象
     * @return 对象列表
     */
    List<AdvertiseUser> queryAll(AdvertiseUser advertiseUser);

    /**
     * 新增数据
     *
     * @param advertiseUser 实例对象
     * @return 影响行数
     */
    int insert(AdvertiseUser advertiseUser);

    /**
     * 修改数据
     *
     * @param advertiseUser 实例对象
     * @return 影响行数
     */
    int update(AdvertiseUser advertiseUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}