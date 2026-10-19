package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.WcsSortedStatusPercent;

/**
 * 分拣状态统计Service接口
 * 
 * @author ruoyi
 * @date 2022-09-01
 */
public interface IWcsSortedStatusPercentService 
{
    /**
     * 查询分拣状态统计
     * 
     * @param id 分拣状态统计ID
     * @return 分拣状态统计
     */
    public WcsSortedStatusPercent selectWcsSortedStatusPercentById(Long id);

    /**
     * 查询分拣状态统计列表
     * 
     * @param wcsSortedStatusPercent 分拣状态统计
     * @return 分拣状态统计集合
     */
    public List<WcsSortedStatusPercent> selectWcsSortedStatusPercentList(WcsSortedStatusPercent wcsSortedStatusPercent);

    /**
     * 新增分拣状态统计
     * 
     * @param wcsSortedStatusPercent 分拣状态统计
     * @return 结果
     */
    public int insertWcsSortedStatusPercent(WcsSortedStatusPercent wcsSortedStatusPercent);

    /**
     * 修改分拣状态统计
     * 
     * @param wcsSortedStatusPercent 分拣状态统计
     * @return 结果
     */
    public int updateWcsSortedStatusPercent(WcsSortedStatusPercent wcsSortedStatusPercent);

    /**
     * 批量删除分拣状态统计
     * 
     * @param ids 需要删除的分拣状态统计ID
     * @return 结果
     */
    public int deleteWcsSortedStatusPercentByIds(Long[] ids);

    /**
     * 删除分拣状态统计信息
     * 
     * @param id 分拣状态统计ID
     * @return 结果
     */
    public int deleteWcsSortedStatusPercentById(Long id);
}
