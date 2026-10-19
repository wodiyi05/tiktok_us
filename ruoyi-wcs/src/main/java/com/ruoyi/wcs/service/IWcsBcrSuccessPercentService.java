package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.WcsBcrSuccessPercent;

/**
 * 扫码率Service接口
 * 
 * @author ruoyi
 * @date 2021-07-07
 */
public interface IWcsBcrSuccessPercentService 
{
    /**
     * 查询扫码率
     * 
     * @param id 扫码率ID
     * @return 扫码率
     */
    public WcsBcrSuccessPercent selectWcsBcrSuccessPercentById(Long id);

    /**
     * 查询扫码率列表
     * 
     * @param wcsBcrSuccessPercent 扫码率
     * @return 扫码率集合
     */
    public List<WcsBcrSuccessPercent> selectWcsBcrSuccessPercentList(WcsBcrSuccessPercent wcsBcrSuccessPercent);

    /**
     * 新增扫码率
     * 
     * @param wcsBcrSuccessPercent 扫码率
     * @return 结果
     */
    public int insertWcsBcrSuccessPercent(WcsBcrSuccessPercent wcsBcrSuccessPercent);

    /**
     * 修改扫码率
     * 
     * @param wcsBcrSuccessPercent 扫码率
     * @return 结果
     */
    public int updateWcsBcrSuccessPercent(WcsBcrSuccessPercent wcsBcrSuccessPercent);

    /**
     * 批量删除扫码率
     * 
     * @param ids 需要删除的扫码率ID
     * @return 结果
     */
    public int deleteWcsBcrSuccessPercentByIds(Long[] ids);

    /**
     * 删除扫码率信息
     * 
     * @param id 扫码率ID
     * @return 结果
     */
    public int deleteWcsBcrSuccessPercentById(Long id);
}
