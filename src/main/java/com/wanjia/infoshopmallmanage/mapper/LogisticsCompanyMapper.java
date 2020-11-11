package com.wanjia.infoshopmallmanage.mapper;

import com.wanjia.infoshopmallmanage.entity.LogisticsCompany;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (LogisticsCompany)表数据库访问层
 *
 * @author wlj
 * @date 2020-10-21 09:13:50
 */
public interface LogisticsCompanyMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LogisticsCompany queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LogisticsCompany> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param logisticsCompany 实例对象
     * @return 对象列表
     */
    List<LogisticsCompany> conditionQuery(LogisticsCompany logisticsCompany);

    /**
     * 新增数据
     *
     * @param logisticsCompany 实例对象
     * @return 影响行数
     */
    int insert(LogisticsCompany logisticsCompany);

    /**
     * 修改数据
     *
     * @param logisticsCompany 实例对象
     * @return 影响行数
     */
    int update(LogisticsCompany logisticsCompany);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    LogisticsCompany selectByCode(String code);

    List<LogisticsCompany> selectAll();

}