package com.ruoyi.wcs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsSortedStatusPercentMapper;
import com.ruoyi.wcs.domain.WcsSortedStatusPercent;
import com.ruoyi.wcs.service.IWcsSortedStatusPercentService;

/**
 * 分拣状态统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-01
 */
@Service
public class WcsSortedStatusPercentServiceImpl implements IWcsSortedStatusPercentService 
{
    @Autowired
    private WcsSortedStatusPercentMapper wcsSortedStatusPercentMapper;

    /**
     * 查询分拣状态统计
     * 
     * @param id 分拣状态统计ID
     * @return 分拣状态统计
     */
    @Override
    public WcsSortedStatusPercent selectWcsSortedStatusPercentById(Long id)
    {
        return wcsSortedStatusPercentMapper.selectWcsSortedStatusPercentById(id);
    }

    /**
     * 查询分拣状态统计列表
     * 
     * @param wcsSortedStatusPercent 分拣状态统计
     * @return 分拣状态统计
     */
    @Override
    public List<WcsSortedStatusPercent> selectWcsSortedStatusPercentList(WcsSortedStatusPercent wcsSortedStatusPercent)
    {
        return wcsSortedStatusPercentMapper.selectWcsSortedStatusPercentList(wcsSortedStatusPercent);
    }

    /**
     * 新增分拣状态统计
     * 
     * @param wcsSortedStatusPercent 分拣状态统计
     * @return 结果
     */
    @Override
    public int insertWcsSortedStatusPercent(WcsSortedStatusPercent wcsSortedStatusPercent)
    {
        return wcsSortedStatusPercentMapper.insertWcsSortedStatusPercent(wcsSortedStatusPercent);
    }

    /**
     * 修改分拣状态统计
     * 
     * @param wcsSortedStatusPercent 分拣状态统计
     * @return 结果
     */
    @Override
    public int updateWcsSortedStatusPercent(WcsSortedStatusPercent wcsSortedStatusPercent)
    {
        return wcsSortedStatusPercentMapper.updateWcsSortedStatusPercent(wcsSortedStatusPercent);
    }

    /**
     * 批量删除分拣状态统计
     * 
     * @param ids 需要删除的分拣状态统计ID
     * @return 结果
     */
    @Override
    public int deleteWcsSortedStatusPercentByIds(Long[] ids)
    {
        return wcsSortedStatusPercentMapper.deleteWcsSortedStatusPercentByIds(ids);
    }

    /**
     * 删除分拣状态统计信息
     * 
     * @param id 分拣状态统计ID
     * @return 结果
     */
    @Override
    public int deleteWcsSortedStatusPercentById(Long id)
    {
        return wcsSortedStatusPercentMapper.deleteWcsSortedStatusPercentById(id);
    }
}
