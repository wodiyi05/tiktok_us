package com.ruoyi.wcs.mapper;

import java.util.List;
import com.ruoyi.wcs.domain.WcsTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * 下发任务Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Mapper // 加上这个注解，IDEA 就认识它了
public interface WcsTaskMapper 
{
    /**
     * 查询下发任务
     * 
     * @param id 下发任务ID
     * @return 下发任务
     */
    public WcsTask selectWcsTaskById(Long id);

    /**
     * 查询下发任务列表
     * 
     * @param wcsTask 下发任务
     * @return 下发任务集合
     */
    public List<WcsTask> selectWcsTaskList(WcsTask wcsTask);

    /**
     * 新增下发任务
     * 
     * @param wcsTask 下发任务
     * @return 结果
     */
    public int insertWcsTask(WcsTask wcsTask);

    /**
     * 修改下发任务
     * 
     * @param wcsTask 下发任务
     * @return 结果
     */
    public int updateWcsTask(WcsTask wcsTask);

    /**
     * 删除下发任务
     * 
     * @param id 下发任务ID
     * @return 结果
     */
    public int deleteWcsTaskById(Long id);

    /**
     * 批量删除下发任务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWcsTaskByIds(Long[] ids);
}
