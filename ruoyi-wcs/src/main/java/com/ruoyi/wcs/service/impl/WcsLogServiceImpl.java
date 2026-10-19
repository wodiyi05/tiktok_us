package com.ruoyi.wcs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsLogMapper;
import com.ruoyi.wcs.domain.WcsLog;
import com.ruoyi.wcs.service.IWcsLogService;

/**
 * wcs日志Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Service
public class WcsLogServiceImpl implements IWcsLogService 
{
    @Autowired
    private WcsLogMapper wcsLogMapper;

    /**
     * 查询wcs日志
     * 
     * @param id wcs日志ID
     * @return wcs日志
     */
    @Override
    public WcsLog selectWcsLogById(Long id)
    {
        return wcsLogMapper.selectWcsLogById(id);
    }

    /**
     * 查询wcs日志列表
     * 
     * @param wcsLog wcs日志
     * @return wcs日志
     */
    @Override
    public List<WcsLog> selectWcsLogList(WcsLog wcsLog)
    {
        return wcsLogMapper.selectWcsLogList(wcsLog);
    }

    /**
     * 新增wcs日志
     * 
     * @param wcsLog wcs日志
     * @return 结果
     */
    @Override
    public int insertWcsLog(WcsLog wcsLog)
    {
        return wcsLogMapper.insertWcsLog(wcsLog);
    }

    /**
     * 修改wcs日志
     * 
     * @param wcsLog wcs日志
     * @return 结果
     */
    @Override
    public int updateWcsLog(WcsLog wcsLog)
    {
        return wcsLogMapper.updateWcsLog(wcsLog);
    }

    /**
     * 批量删除wcs日志
     * 
     * @param ids 需要删除的wcs日志ID
     * @return 结果
     */
    @Override
    public int deleteWcsLogByIds(Long[] ids)
    {
        return wcsLogMapper.deleteWcsLogByIds(ids);
    }

    /**
     * 删除wcs日志信息
     * 
     * @param id wcs日志ID
     * @return 结果
     */
    @Override
    public int deleteWcsLogById(Long id)
    {
        return wcsLogMapper.deleteWcsLogById(id);
    }
}
