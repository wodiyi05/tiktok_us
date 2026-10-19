package com.ruoyi.wcs.service.impl;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsTaskMapper;
import com.ruoyi.wcs.domain.WcsTask;
import com.ruoyi.wcs.service.IWcsTaskService;

/**
 * 下发任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Service
public class WcsTaskServiceImpl implements IWcsTaskService 
{
    @Autowired
    private WcsTaskMapper wcsTaskMapper;

    /**
     * 查询下发任务
     * 
     * @param id 下发任务ID
     * @return 下发任务
     */
    @Override
    public WcsTask selectWcsTaskById(Long id)
    {
        return wcsTaskMapper.selectWcsTaskById(id);
    }

    /**
     * 查询下发任务列表
     * 
     * @param wcsTask 下发任务
     * @return 下发任务
     */
    @Override
    public List<WcsTask> selectWcsTaskList(WcsTask wcsTask)
    {
        return wcsTaskMapper.selectWcsTaskList(wcsTask);
    }

    /**
     * 新增下发任务
     * 
     * @param wcsTask 下发任务
     * @return 结果
     */
    @Override
    public int insertWcsTask(WcsTask wcsTask)
    {
        return wcsTaskMapper.insertWcsTask(wcsTask);
    }

    /**
     * 修改下发任务
     * 
     * @param wcsTask 下发任务
     * @return 结果
     */
    @Override
    public int updateWcsTask(WcsTask wcsTask)
    {
        return wcsTaskMapper.updateWcsTask(wcsTask);
    }

    /**
     * 批量删除下发任务
     * 
     * @param ids 需要删除的下发任务ID
     * @return 结果
     */
    @Override
    public int deleteWcsTaskByIds(Long[] ids)
    {
        return wcsTaskMapper.deleteWcsTaskByIds(ids);
    }

    /**
     * 删除下发任务信息
     * 
     * @param id 下发任务ID
     * @return 结果
     */
    @Override
    public int deleteWcsTaskById(Long id)
    {
        return wcsTaskMapper.deleteWcsTaskById(id);
    }

    /**
     * 导入下发任务数据
     *
     * @param taskList 任务数据列表
     * @param isUpdateSupport 是否支持更新
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importWcsTask(List<WcsTask> taskList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(taskList) || taskList.size() == 0)
        {
            throw new CustomException("导入任务数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (WcsTask task : taskList)
        {
            try
            {
                // 可选逻辑：这里可以加入业务排重逻辑。
                // 比如根据 taskNo 查询是否已存在：
                // WcsTask query = new WcsTask();
                // query.setTaskNo(task.getTaskNo());
                // List<WcsTask> existTasks = wcsTaskMapper.selectWcsTaskList(query);
// ==========================================
                // 【新增逻辑】：判断 taskType 如果为空，则赋予默认值 "offline"
                // ==========================================
                if (StringUtils.isEmpty(task.getTaskType())) {
                    task.setTaskType("offline");
                }
                // 为了演示，这里直接执行新增逻辑
                task.setCreateBy(operName); // 记录创建人
                this.insertWcsTask(task);
                successNum++;
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>条码 " + task.getBarcode() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }

        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条。");
        }
        return successMsg.toString();
    }
}
