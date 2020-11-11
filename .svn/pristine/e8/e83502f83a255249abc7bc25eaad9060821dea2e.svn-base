package com.wanjia.infoshopmallmanage.mapper;

import com.wanjia.infoshopmallmanage.entity.AddressContact;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (AddressContact)表数据库访问层
 *
 * @author wlj
 * @date 2020-11-06 10:39:24
 */
public interface AddressContactMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AddressContact queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AddressContact> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param addressContact 实例对象
     * @return 对象列表
     */
    List<AddressContact> conditionQuery(AddressContact addressContact);

    /**
     * 新增数据
     *
     * @param addressContact 实例对象
     * @return 影响行数
     */
    int insert(AddressContact addressContact);

    /**
     * 修改数据
     *
     * @param addressContact 实例对象
     * @return 影响行数
     */
    int update(AddressContact addressContact);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}