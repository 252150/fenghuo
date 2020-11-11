package com.wanjia.infoshopmallmanage.mapper;

import com.wanjia.infoshopmallmanage.entity.Company;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Company)表数据库访问层
 *
 * @author wlj
 * @date 2020-10-13 10:10:20
 */
public interface CompanyMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Company queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Company> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param company 实例对象
     * @return 对象列表
     */
    List<Company> conditionQuery(Company company);

    /**
     * 新增数据
     *
     * @param company 实例对象
     * @return 影响行数
     */
    int insert(Company company);

    /**
     * 修改数据
     *
     * @param company 实例对象
     * @return 影响行数
     */
    int update(Company company);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);
    
    /**
     * 	获取当前用户管理的公司信息
     * 	@param adminId
     * 	@return
     */
    Company getCompanyInfoByAdminId(Long adminId);
}