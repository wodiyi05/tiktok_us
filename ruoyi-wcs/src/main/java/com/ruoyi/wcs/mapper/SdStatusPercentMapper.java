package com.ruoyi.wcs.mapper;

import java.util.List;
import com.ruoyi.wcs.domain.SdStatusPercent;

/**
 * sdStatusPercentMapper接口
 * 
 * @author ruoyi
 * @date 2026-09-17
 */
public interface SdStatusPercentMapper 
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
     * 删除sdStatusPercent
     * 
     * @param id sdStatusPercentID
     * @return 结果
     */
    public int deleteSdStatusPercentById(Long id);

    /**
     * 批量删除sdStatusPercent
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSdStatusPercentByIds(Long[] ids);
}
