package com.wanjia.infoshopmallmanage.mapper;

import com.wanjia.infoshopmallmanage.entity.EnvParas;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * (EnvParas)表数据库访问层
 *
 * @author wlj
 * @date 2020-09-27 13:33:44
 */
public interface EnvParasMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EnvParas queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EnvParas> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param envParas 实例对象
     * @return 对象列表
     */
    List<EnvParas> queryAll(EnvParas envParas);

    /**
     * 新增数据
     *
     * @param envParas 实例对象
     * @return 影响行数
     */
    int insert(EnvParas envParas);

    /**
     * 修改数据
     *
     * @param envParas 实例对象
     * @return 影响行数
     */
    int update(EnvParas envParas);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);
    
    /**
     * 	更新默认文件配置记录
     * 	@param paraKey
     * 	@param updateTime
     * 	@return
     */
    int updateRecordByParaKey(@Param("paraKey") String paraKey,@Param("updateTime") Date updateTime);
    
    /**
     * 查询key值
     * @param key
     * @return
     */
    String selectByKey(String key);

    /**
     * 根据key修改值
     * @param envParas
     * @return
     */
    int updateByParaKey(EnvParas envParas);
}