package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.WcsPosConfig1;

/**
 * chute1Service接口
 * 
 * @author ruoyi
 * @date 2026-06-16
 */
public interface IWcsPosConfig1Service 
{
    /**
     * 查询chute1
     * 
     * @param id chute1ID
     * @return chute1
     */
    public WcsPosConfig1 selectWcsPosConfig1ById(Long id);

    /**
     * 查询chute1列表
     * 
     * @param wcsPosConfig1 chute1
     * @return chute1集合
     */
    public List<WcsPosConfig1> selectWcsPosConfig1List(WcsPosConfig1 wcsPosConfig1);

    /**
     * 新增chute1
     * 
     * @param wcsPosConfig1 chute1
     * @return 结果
     */
    public int insertWcsPosConfig1(WcsPosConfig1 wcsPosConfig1);

    /**
     * 修改chute1
     * 
     * @param wcsPosConfig1 chute1
     * @return 结果
     */
    public int updateWcsPosConfig1(WcsPosConfig1 wcsPosConfig1);

    /**
     * 批量删除chute1
     * 
     * @param ids 需要删除的chute1ID
     * @return 结果
     */
    public int deleteWcsPosConfig1ByIds(Long[] ids);

    /**
     * 删除chute1信息
     * 
     * @param id chute1ID
     * @return 结果
     */
    public int deleteWcsPosConfig1ById(Long id);
}
