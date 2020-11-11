package com.wanjia.infoshopmallmanage.mapper;

import com.wanjia.infoshopmallmanage.entity.CompanyStaff;
import com.wanjia.infoshopmallmanage.entity.CompanyStaffNHS;

import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (CompanyStaff)表数据库访问层
 *
 * @author wlj
 * @date 2020-10-13 10:10:20
 */
public interface CompanyStaffMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CompanyStaff queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CompanyStaff> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param companyStaff 实例对象
     * @return 对象列表
     */
    List<CompanyStaff> conditionQuery(CompanyStaff companyStaff);

    /**
     * 新增数据
     *
     * @param companyStaff 实例对象
     * @return 影响行数
     */
    int insert(CompanyStaff companyStaff);

    /**
     * 修改数据
     *
     * @param companyStaff 实例对象
     * @return 影响行数
     */
    int update(CompanyStaff companyStaff);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);
    
    /**
     * 	获取待处理的加入公司的申请信息
     * 	@param adminId
     */
    List<CompanyStaffNHS> getCompanyStaffs(Long adminId);
    
    /**
     * 	获取员工信息(不包括自己(企业掌控人))
     */
    List<CompanyStaffNHS> getStaffs(Long adminId);
}