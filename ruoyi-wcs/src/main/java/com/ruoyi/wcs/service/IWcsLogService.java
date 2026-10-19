package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.WcsLog;

/**
 * wcs日志Service接口
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
public interface IWcsLogService 
{
    /**
     * 查询wcs日志
     * 
     * @param id wcs日志ID
     * @return wcs日志
     */
    public WcsLog selectWcsLogById(Long id);

    /**
     * 查询wcs日志列表
     * 
     * @param wcsLog wcs日志
     * @return wcs日志集合
     */
    public List<WcsLog> selectWcsLogList(WcsLog wcsLog);

    /**
     * 新增wcs日志
     * 
     * @param wcsLog wcs日志
     * @return 结果
     */
    public int insertWcsLog(WcsLog wcsLog);

    /**
     * 修改wcs日志
     * 
     * @param wcsLog wcs日志
     * @return 结果
     */
    public int updateWcsLog(WcsLog wcsLog);

    /**
     * 批量删除wcs日志
     * 
     * @param ids 需要删除的wcs日志ID
     * @return 结果
     */
    public int deleteWcsLogByIds(Long[] ids);

    /**
     * 删除wcs日志信息
     * 
     * @param id wcs日志ID
     * @return 结果
     */
    public int deleteWcsLogById(Long id);
}
