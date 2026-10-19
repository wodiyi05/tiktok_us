package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.WcsStn;

/**
 * 设备监控Service接口
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
public interface IWcsStnService 
{
    /**
     * 查询设备监控
     * 
     * @param stnId 设备监控ID
     * @return 设备监控
     */
    public WcsStn selectWcsStnById(String stnId);

    /**
     * 查询设备监控列表
     * 
     * @param wcsStn 设备监控
     * @return 设备监控集合
     */
    public List<WcsStn> selectWcsStnList(WcsStn wcsStn);

    /**
     * 新增设备监控
     * 
     * @param wcsStn 设备监控
     * @return 结果
     */
    public int insertWcsStn(WcsStn wcsStn);

    /**
     * 修改设备监控
     * 
     * @param wcsStn 设备监控
     * @return 结果
     */
    public int updateWcsStn(WcsStn wcsStn);

    /**
     * 批量删除设备监控
     * 
     * @param stnIds 需要删除的设备监控ID
     * @return 结果
     */
    public int deleteWcsStnByIds(String[] stnIds);

    /**
     * 删除设备监控信息
     * 
     * @param stnId 设备监控ID
     * @return 结果
     */
    public int deleteWcsStnById(String stnId);
}
