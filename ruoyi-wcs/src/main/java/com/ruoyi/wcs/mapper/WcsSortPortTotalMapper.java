package com.ruoyi.wcs.mapper;

import java.util.List;
import com.ruoyi.wcs.domain.WcsSortPortTotal;

/**
 * 分拣口统计Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
public interface WcsSortPortTotalMapper 
{
    /**
     * 查询分拣口统计
     * 
     * @param id 分拣口统计ID
     * @return 分拣口统计
     */
    public WcsSortPortTotal selectWcsSortPortTotalById(Long id);

    /**
     * 查询分拣口统计列表
     * 
     * @param wcsSortPortTotal 分拣口统计
     * @return 分拣口统计集合
     */
    public List<WcsSortPortTotal> selectWcsSortPortTotalList(WcsSortPortTotal wcsSortPortTotal);

    /**
     * 新增分拣口统计
     * 
     * @param wcsSortPortTotal 分拣口统计
     * @return 结果
     */
    public int insertWcsSortPortTotal(WcsSortPortTotal wcsSortPortTotal);

    /**
     * 修改分拣口统计
     * 
     * @param wcsSortPortTotal 分拣口统计
     * @return 结果
     */
    public int updateWcsSortPortTotal(WcsSortPortTotal wcsSortPortTotal);

    /**
     * 删除分拣口统计
     * 
     * @param id 分拣口统计ID
     * @return 结果
     */
    public int deleteWcsSortPortTotalById(Long id);

    /**
     * 批量删除分拣口统计
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWcsSortPortTotalByIds(Long[] ids);
}
