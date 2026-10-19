package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.PlcErrLog;

/**
 * 历史报警Service接口
 * 
 * @author ruoyi
 * @date 2021-10-16
 */
public interface IPlcErrLogService 
{
    /**
     * 查询历史报警
     * 
     * @param errId 历史报警ID
     * @return 历史报警
     */
    public PlcErrLog selectPlcErrLogById(String errId);

    /**
     * 查询历史报警列表
     * 
     * @param plcErrLog 历史报警
     * @return 历史报警集合
     */
    public List<PlcErrLog> selectPlcErrLogList(PlcErrLog plcErrLog);

    /**
     * 新增历史报警
     * 
     * @param plcErrLog 历史报警
     * @return 结果
     */
    public int insertPlcErrLog(PlcErrLog plcErrLog);

    /**
     * 修改历史报警
     * 
     * @param plcErrLog 历史报警
     * @return 结果
     */
    public int updatePlcErrLog(PlcErrLog plcErrLog);

    /**
     * 批量删除历史报警
     * 
     * @param errIds 需要删除的历史报警ID
     * @return 结果
     */
    public int deletePlcErrLogByIds(String[] errIds);

    /**
     * 删除历史报警信息
     * 
     * @param errId 历史报警ID
     * @return 结果
     */
    public int deletePlcErrLogById(String errId);
}
