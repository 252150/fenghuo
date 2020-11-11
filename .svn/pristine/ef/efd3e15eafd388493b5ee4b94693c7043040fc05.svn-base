package com.wanjia.infoshopmallmanage.mapper;

import com.wanjia.infoshopmallmanage.entity.MessType;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (MessType)表数据库访问层
 *
 * @author wlj
 * @date 2020-09-27 13:33:45
 */
public interface MessTypeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MessType queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MessType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param messType 实例对象
     * @return 对象列表
     */
    List<MessType> queryAll(MessType messType);

    /**
     * 新增数据
     *
     * @param messType 实例对象
     * @return 影响行数
     */
    int insert(MessType messType);

    /**
     * 修改数据
     *
     * @param messType 实例对象
     * @return 影响行数
     */
    int update(MessType messType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}