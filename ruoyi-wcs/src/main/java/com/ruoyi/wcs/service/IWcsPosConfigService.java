package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.WcsPosConfig;

/**
 * 出口配置Service接口
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
public interface IWcsPosConfigService 
{
    /**
     * 查询出口配置
     * 
     * @param id 出口配置ID
     * @return 出口配置
     */
    public WcsPosConfig selectWcsPosConfigById(Long id);

    /**
     * 查询出口配置列表
     * 
     * @param wcsPosConfig 出口配置
     * @return 出口配置集合
     */
    public List<WcsPosConfig> selectWcsPosConfigList(WcsPosConfig wcsPosConfig);

    /**
     * 新增出口配置
     * 
     * @param wcsPosConfig 出口配置
     * @return 结果
     */
    public int insertWcsPosConfig(WcsPosConfig wcsPosConfig);

    /**
     * 修改出口配置
     * 
     * @param wcsPosConfig 出口配置
     * @return 结果
     */
    public int updateWcsPosConfig(WcsPosConfig wcsPosConfig);

    /**
     * 批量删除出口配置
     * 
     * @param ids 需要删除的出口配置ID
     * @return 结果
     */
    public int deleteWcsPosConfigByIds(Long[] ids);

    /**
     * 删除出口配置信息
     * 
     * @param id 出口配置ID
     * @return 结果
     */
    public int deleteWcsPosConfigById(Long id);
}
