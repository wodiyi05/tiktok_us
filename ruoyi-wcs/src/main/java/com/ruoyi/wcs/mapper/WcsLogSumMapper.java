package com.ruoyi.wcs.mapper;

import java.util.List;
import com.ruoyi.wcs.domain.WcsLogSum;

/**
 * log_sumMapper接口
 * 
 * @author ruoyi
 * @date 2026-09-11
 */
public interface WcsLogSumMapper 
{
    /**
     * 查询log_sum
     * 
     * @param id log_sumID
     * @return log_sum
     */
    public WcsLogSum selectWcsLogSumById(Long id);

    /**
     * 查询log_sum列表
     * 
     * @param wcsLogSum log_sum
     * @return log_sum集合
     */
    public List<WcsLogSum> selectWcsLogSumList(WcsLogSum wcsLogSum);

    /**
     * 新增log_sum
     * 
     * @param wcsLogSum log_sum
     * @return 结果
     */
    public int insertWcsLogSum(WcsLogSum wcsLogSum);

    /**
     * 修改log_sum
     * 
     * @param wcsLogSum log_sum
     * @return 结果
     */
    public int updateWcsLogSum(WcsLogSum wcsLogSum);

    /**
     * 删除log_sum
     * 
     * @param id log_sumID
     * @return 结果
     */
    public int deleteWcsLogSumById(Long id);

    /**
     * 批量删除log_sum
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWcsLogSumByIds(Long[] ids);
}
