package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.WcsGuideConfig;

/**
 * 路由配置Service接口
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
public interface IWcsGuideConfigService 
{
    /**
     * 查询路由配置
     * 
     * @param id 路由配置ID
     * @return 路由配置
     */
    public WcsGuideConfig selectWcsGuideConfigById(Long id);

    /**
     * 查询路由配置列表
     * 
     * @param wcsGuideConfig 路由配置
     * @return 路由配置集合
     */
    public List<WcsGuideConfig> selectWcsGuideConfigList(WcsGuideConfig wcsGuideConfig);

    /**
     * 新增路由配置
     * 
     * @param wcsGuideConfig 路由配置
     * @return 结果
     */
    public int insertWcsGuideConfig(WcsGuideConfig wcsGuideConfig);

    /**
     * 修改路由配置
     * 
     * @param wcsGuideConfig 路由配置
     * @return 结果
     */
    public int updateWcsGuideConfig(WcsGuideConfig wcsGuideConfig);

    /**
     * 批量删除路由配置
     * 
     * @param ids 需要删除的路由配置ID
     * @return 结果
     */
    public int deleteWcsGuideConfigByIds(Long[] ids);

    /**
     * 删除路由配置信息
     * 
     * @param id 路由配置ID
     * @return 结果
     */
    public int deleteWcsGuideConfigById(Long id);
}
