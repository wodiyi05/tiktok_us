package com.ruoyi.wcs.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.PlcErrLogMapper;
import com.ruoyi.wcs.domain.PlcErrLog;
import com.ruoyi.wcs.service.IPlcErrLogService;

/**
 * 历史报警Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-16
 */
@Service
@DataSource(DataSourceType.SLAVE)
public class PlcErrLogServiceImpl implements IPlcErrLogService 
{
    @Autowired
    private PlcErrLogMapper plcErrLogMapper;

    /**
     * 查询历史报警
     * 
     * @param errId 历史报警ID
     * @return 历史报警
     */
    @Override
    public PlcErrLog selectPlcErrLogById(String errId)
    {
        return plcErrLogMapper.selectPlcErrLogById(errId);
    }

    /**
     * 查询历史报警列表
     * 
     * @param plcErrLog 历史报警
     * @return 历史报警
     */
    @Override
    public List<PlcErrLog> selectPlcErrLogList(PlcErrLog plcErrLog)
    {
        return plcErrLogMapper.selectPlcErrLogList(plcErrLog);
    }

    /**
     * 新增历史报警
     * 
     * @param plcErrLog 历史报警
     * @return 结果
     */
    @Override
    public int insertPlcErrLog(PlcErrLog plcErrLog)
    {
        return plcErrLogMapper.insertPlcErrLog(plcErrLog);
    }

    /**
     * 修改历史报警
     * 
     * @param plcErrLog 历史报警
     * @return 结果
     */
    @Override
    public int updatePlcErrLog(PlcErrLog plcErrLog)
    {
        return plcErrLogMapper.updatePlcErrLog(plcErrLog);
    }

    /**
     * 批量删除历史报警
     * 
     * @param errIds 需要删除的历史报警ID
     * @return 结果
     */
    @Override
    public int deletePlcErrLogByIds(String[] errIds)
    {
        return plcErrLogMapper.deletePlcErrLogByIds(errIds);
    }

    /**
     * 删除历史报警信息
     * 
     * @param errId 历史报警ID
     * @return 结果
     */
    @Override
    public int deletePlcErrLogById(String errId)
    {
        return plcErrLogMapper.deletePlcErrLogById(errId);
    }
}
