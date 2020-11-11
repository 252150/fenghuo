package com.wanjia.infoshopmallmanage.mapper;

import com.wanjia.infoshopmallmanage.entity.UserLevel;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (UserLevel)表数据库访问层
 *
 * @author wlj
 * @date 2020-09-27 13:33:46
 */
public interface UserLevelMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserLevel queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserLevel> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userLevel 实例对象
     * @return 对象列表
     */
    List<UserLevel> queryAll(UserLevel userLevel);
    
    /**
     * 	获取所有用户等级记录
     * 	@return
     */
    public List<UserLevel> getAllUserLevels();

    /**
     * 新增数据
     *
     * @param userLevel 实例对象
     * @return 影响行数
     */
    int insert(UserLevel userLevel);

    /**
     * 修改数据
     *
     * @param userLevel 实例对象
     * @return 影响行数
     */
    int update(UserLevel userLevel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);
    
    /**
     * 	根据level获取记录条数(验证新增记录时level是否重复)
     * 	@param level
     * 	@return
     */
    int getCountByLevel(Integer level);
    
    /**
     * 	根据levelName获取记录条数(验证新增记录时levelName是否重复)
     * 	@param levelName
     * 	@return
     */
    int getCountByLevelName(String levelName);
    
    /**
     * 	获取高级低分的记录条数(验证新增记录的合法性)
     * 	@param level
     * 	@param requireScore
     * @return
     */
    int getHighLevelLowScoreCount(@Param("level") Integer level,@Param("requireScore") Integer requireScore);
    
    /**
     * 	获取低级高分的记录条数(验证新增记录的合法性)
     * 	@param level
     * 	@param requireScore
     * @return
     */
    int getLowLevelHighScoreCount(@Param("level") Integer level,@Param("requireScore") Integer requireScore);

}