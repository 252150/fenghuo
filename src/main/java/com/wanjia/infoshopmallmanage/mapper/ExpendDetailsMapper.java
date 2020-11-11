package com.wanjia.infoshopmallmanage.mapper;

import com.wanjia.infoshopmallmanage.entity.ExpendDetails;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ExpendDetails)表数据库访问层
 *
 * @author wlj
 * @date 2020-09-27 13:33:44
 */
public interface ExpendDetailsMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ExpendDetails queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ExpendDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param expendDetails 实例对象
     * @return 对象列表
     */
    List<ExpendDetails> queryAll(ExpendDetails expendDetails);

    /**
     * 新增数据
     *
     * @param expendDetails 实例对象
     * @return 影响行数
     */
    int insert(ExpendDetails expendDetails);

    /**
     * 修改数据
     *
     * @param expendDetails 实例对象
     * @return 影响行数
     */
    int update(ExpendDetails expendDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}