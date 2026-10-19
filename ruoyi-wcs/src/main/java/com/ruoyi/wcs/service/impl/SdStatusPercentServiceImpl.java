package com.ruoyi.wcs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.SdStatusPercentMapper;
import com.ruoyi.wcs.domain.SdStatusPercent;
import com.ruoyi.wcs.service.ISdStatusPercentService;

/**
 * sdStatusPercentService业务层处理
 * 
 * @author ruoyi
 * @date 2026-09-17
 */
@Service
public class SdStatusPercentServiceImpl implements ISdStatusPercentService 
{
    @Autowired
    private SdStatusPercentMapper sdStatusPercentMapper;

    /**
     * 查询sdStatusPercent
     * 
     * @param id sdStatusPercentID
     * @return sdStatusPercent
     */
    @Override
    public SdStatusPercent selectSdStatusPercentById(Long id)
    {
        return sdStatusPercentMapper.selectSdStatusPercentById(id);
    }

    /**
     * 查询sdStatusPercent列表
     * 
     * @param sdStatusPercent sdStatusPercent
     * @return sdStatusPercent
     */
    @Override
    public List<SdStatusPercent> selectSdStatusPercentList(SdStatusPercent sdStatusPercent)
    {
        return sdStatusPercentMapper.selectSdStatusPercentList(sdStatusPercent);
    }

    /**
     * 新增sdStatusPercent
     * 
     * @param sdStatusPercent sdStatusPercent
     * @return 结果
     */
    @Override
    public int insertSdStatusPercent(SdStatusPercent sdStatusPercent)
    {
        return sdStatusPercentMapper.insertSdStatusPercent(sdStatusPercent);
    }

    /**
     * 修改sdStatusPercent
     * 
     * @param sdStatusPercent sdStatusPercent
     * @return 结果
     */
    @Override
    public int updateSdStatusPercent(SdStatusPercent sdStatusPercent)
    {
        return sdStatusPercentMapper.updateSdStatusPercent(sdStatusPercent);
    }

    /**
     * 批量删除sdStatusPercent
     * 
     * @param ids 需要删除的sdStatusPercentID
     * @return 结果
     */
    @Override
    public int deleteSdStatusPercentByIds(Long[] ids)
    {
        return sdStatusPercentMapper.deleteSdStatusPercentByIds(ids);
    }

    /**
     * 删除sdStatusPercent信息
     * 
     * @param id sdStatusPercentID
     * @return 结果
     */
    @Override
    public int deleteSdStatusPercentById(Long id)
    {
        return sdStatusPercentMapper.deleteSdStatusPercentById(id);
    }
}
