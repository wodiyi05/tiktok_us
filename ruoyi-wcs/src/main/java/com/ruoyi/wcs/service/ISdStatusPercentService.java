package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.SdStatusPercent;

/**
 * sdStatusPercentService接口
 * 
 * @author ruoyi
 * @date 2026-09-17
 */
public interface ISdStatusPercentService 
{
    /**
     * 查询sdStatusPercent
     * 
     * @param id sdStatusPercentID
     * @return sdStatusPercent
     */
    public SdStatusPercent selectSdStatusPercentById(Long id);

    /**
     * 查询sdStatusPercent列表
     * 
     * @param sdStatusPercent sdStatusPercent
     * @return sdStatusPercent集合
     */
    public List<SdStatusPercent> selectSdStatusPercentList(SdStatusPercent sdStatusPercent);

    /**
     * 新增sdStatusPercent
     * 
     * @param sdStatusPercent sdStatusPercent
     * @return 结果
     */
    public int insertSdStatusPercent(SdStatusPercent sdStatusPercent);

    /**
     * 修改sdStatusPercent
     * 
     * @param sdStatusPercent sdStatusPercent
     * @return 结果
     */
    public int updateSdStatusPercent(SdStatusPercent sdStatusPercent);

    /**
     * 批量删除sdStatusPercent
     * 
     * @param ids 需要删除的sdStatusPercentID
     * @return 结果
     */
    public int deleteSdStatusPercentByIds(Long[] ids);

    /**
     * 删除sdStatusPercent信息
     * 
     * @param id sdStatusPercentID
     * @return 结果
     */
    public int deleteSdStatusPercentById(Long id);
}
