package com.ruoyi.wcs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsSortPortTotalMapper;
import com.ruoyi.wcs.domain.WcsSortPortTotal;
import com.ruoyi.wcs.service.IWcsSortPortTotalService;

/**
 * 分拣口统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
@Service
public class WcsSortPortTotalServiceImpl implements IWcsSortPortTotalService 
{
    @Autowired
    private WcsSortPortTotalMapper wcsSortPortTotalMapper;

    /**
     * 查询分拣口统计
     * 
     * @param id 分拣口统计ID
     * @return 分拣口统计
     */
    @Override
    public WcsSortPortTotal selectWcsSortPortTotalById(Long id)
    {
        return wcsSortPortTotalMapper.selectWcsSortPortTotalById(id);
    }

    /**
     * 查询分拣口统计列表
     * 
     * @param wcsSortPortTotal 分拣口统计
     * @return 分拣口统计
     */
    @Override
    public List<WcsSortPortTotal> selectWcsSortPortTotalList(WcsSortPortTotal wcsSortPortTotal)
    {
        return wcsSortPortTotalMapper.selectWcsSortPortTotalList(wcsSortPortTotal);
    }

    /**
     * 新增分拣口统计
     * 
     * @param wcsSortPortTotal 分拣口统计
     * @return 结果
     */
    @Override
    public int insertWcsSortPortTotal(WcsSortPortTotal wcsSortPortTotal)
    {
        return wcsSortPortTotalMapper.insertWcsSortPortTotal(wcsSortPortTotal);
    }

    /**
     * 修改分拣口统计
     * 
     * @param wcsSortPortTotal 分拣口统计
     * @return 结果
     */
    @Override
    public int updateWcsSortPortTotal(WcsSortPortTotal wcsSortPortTotal)
    {
        return wcsSortPortTotalMapper.updateWcsSortPortTotal(wcsSortPortTotal);
    }

    /**
     * 批量删除分拣口统计
     * 
     * @param ids 需要删除的分拣口统计ID
     * @return 结果
     */
    @Override
    public int deleteWcsSortPortTotalByIds(Long[] ids)
    {
        return wcsSortPortTotalMapper.deleteWcsSortPortTotalByIds(ids);
    }

    /**
     * 删除分拣口统计信息
     * 
     * @param id 分拣口统计ID
     * @return 结果
     */
    @Override
    public int deleteWcsSortPortTotalById(Long id)
    {
        return wcsSortPortTotalMapper.deleteWcsSortPortTotalById(id);
    }
}
