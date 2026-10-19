package com.ruoyi.wcs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsLogSumMapper;
import com.ruoyi.wcs.domain.WcsLogSum;
import com.ruoyi.wcs.service.IWcsLogSumService;

/**
 * log_sumService业务层处理
 * 
 * @author ruoyi
 * @date 2026-09-11
 */
@Service
public class WcsLogSumServiceImpl implements IWcsLogSumService 
{
    @Autowired
    private WcsLogSumMapper wcsLogSumMapper;

    /**
     * 查询log_sum
     * 
     * @param id log_sumID
     * @return log_sum
     */
    @Override
    public WcsLogSum selectWcsLogSumById(Long id)
    {
        return wcsLogSumMapper.selectWcsLogSumById(id);
    }

    /**
     * 查询log_sum列表
     * 
     * @param wcsLogSum log_sum
     * @return log_sum
     */
    @Override
    public List<WcsLogSum> selectWcsLogSumList(WcsLogSum wcsLogSum)
    {
        return wcsLogSumMapper.selectWcsLogSumList(wcsLogSum);
    }

    /**
     * 新增log_sum
     * 
     * @param wcsLogSum log_sum
     * @return 结果
     */
    @Override
    public int insertWcsLogSum(WcsLogSum wcsLogSum)
    {
        return wcsLogSumMapper.insertWcsLogSum(wcsLogSum);
    }

    /**
     * 修改log_sum
     * 
     * @param wcsLogSum log_sum
     * @return 结果
     */
    @Override
    public int updateWcsLogSum(WcsLogSum wcsLogSum)
    {
        return wcsLogSumMapper.updateWcsLogSum(wcsLogSum);
    }

    /**
     * 批量删除log_sum
     * 
     * @param ids 需要删除的log_sumID
     * @return 结果
     */
    @Override
    public int deleteWcsLogSumByIds(Long[] ids)
    {
        return wcsLogSumMapper.deleteWcsLogSumByIds(ids);
    }

    /**
     * 删除log_sum信息
     * 
     * @param id log_sumID
     * @return 结果
     */
    @Override
    public int deleteWcsLogSumById(Long id)
    {
        return wcsLogSumMapper.deleteWcsLogSumById(id);
    }
}
