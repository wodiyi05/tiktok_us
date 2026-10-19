package com.ruoyi.wcs.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsBcrSuccessPercentMapper;
import com.ruoyi.wcs.domain.WcsBcrSuccessPercent;
import com.ruoyi.wcs.service.IWcsBcrSuccessPercentService;

/**
 * 扫码率Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-07
 */
@Service
public class WcsBcrSuccessPercentServiceImpl implements IWcsBcrSuccessPercentService 
{
    @Autowired
    private WcsBcrSuccessPercentMapper wcsBcrSuccessPercentMapper;

    /**
     * 查询扫码率
     * 
     * @param id 扫码率ID
     * @return 扫码率
     */
    @Override
    public WcsBcrSuccessPercent selectWcsBcrSuccessPercentById(Long id)
    {
        return wcsBcrSuccessPercentMapper.selectWcsBcrSuccessPercentById(id);
    }

    /**
     * 查询扫码率列表
     * 
     * @param wcsBcrSuccessPercent 扫码率
     * @return 扫码率
     */
    @Override
    public List<WcsBcrSuccessPercent> selectWcsBcrSuccessPercentList(WcsBcrSuccessPercent wcsBcrSuccessPercent)
    {
        return wcsBcrSuccessPercentMapper.selectWcsBcrSuccessPercentList(wcsBcrSuccessPercent);
    }

    /**
     * 新增扫码率
     * 
     * @param wcsBcrSuccessPercent 扫码率
     * @return 结果
     */
    @Override
    public int insertWcsBcrSuccessPercent(WcsBcrSuccessPercent wcsBcrSuccessPercent)
    {
        return wcsBcrSuccessPercentMapper.insertWcsBcrSuccessPercent(wcsBcrSuccessPercent);
    }

    /**
     * 修改扫码率
     * 
     * @param wcsBcrSuccessPercent 扫码率
     * @return 结果
     */
    @Override
    public int updateWcsBcrSuccessPercent(WcsBcrSuccessPercent wcsBcrSuccessPercent)
    {
        return wcsBcrSuccessPercentMapper.updateWcsBcrSuccessPercent(wcsBcrSuccessPercent);
    }

    /**
     * 批量删除扫码率
     * 
     * @param ids 需要删除的扫码率ID
     * @return 结果
     */
    @Override
    public int deleteWcsBcrSuccessPercentByIds(Long[] ids)
    {
        return wcsBcrSuccessPercentMapper.deleteWcsBcrSuccessPercentByIds(ids);
    }

    /**
     * 删除扫码率信息
     * 
     * @param id 扫码率ID
     * @return 结果
     */
    @Override
    public int deleteWcsBcrSuccessPercentById(Long id)
    {
        return wcsBcrSuccessPercentMapper.deleteWcsBcrSuccessPercentById(id);
    }
}
