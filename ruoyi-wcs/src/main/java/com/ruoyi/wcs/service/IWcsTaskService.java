package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.WcsTask;

/**
 * 下发任务Service接口
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
public interface IWcsTaskService 
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
     * 批量删除下发任务
     * 
     * @param ids 需要删除的下发任务ID
     * @return 结果
     */
    public int deleteWcsTaskByIds(Long[] ids);

    /**
     * 删除下发任务信息
     * 
     * @param id 下发任务ID
     * @return 结果
     */
    public int deleteWcsTaskById(Long id);

    /**
     * 导入下发任务数据
     *
     * @param taskList 任务数据列表
     * @param isUpdateSupport 是否支持更新（如果数据已存在）
     * @param operName 操作用户
     * @return 导入结果信息
     */
    public String importWcsTask(List<WcsTask> taskList, Boolean isUpdateSupport, String operName);
}
