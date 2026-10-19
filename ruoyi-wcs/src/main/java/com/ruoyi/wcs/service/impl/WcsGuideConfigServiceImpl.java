package com.ruoyi.wcs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsGuideConfigMapper;
import com.ruoyi.wcs.domain.WcsGuideConfig;
import com.ruoyi.wcs.service.IWcsGuideConfigService;

/**
 * 路由配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Service
public class WcsGuideConfigServiceImpl implements IWcsGuideConfigService 
{
    @Autowired
    private WcsGuideConfigMapper wcsGuideConfigMapper;

    /**
     * 查询路由配置
     * 
     * @param id 路由配置ID
     * @return 路由配置
     */
    @Override
    public WcsGuideConfig selectWcsGuideConfigById(Long id)
    {
        return wcsGuideConfigMapper.selectWcsGuideConfigById(id);
    }

    /**
     * 查询路由配置列表
     * 
     * @param wcsGuideConfig 路由配置
     * @return 路由配置
     */
    @Override
    public List<WcsGuideConfig> selectWcsGuideConfigList(WcsGuideConfig wcsGuideConfig)
    {
        return wcsGuideConfigMapper.selectWcsGuideConfigList(wcsGuideConfig);
    }

    /**
     * 新增路由配置
     * 
     * @param wcsGuideConfig 路由配置
     * @return 结果
     */
    @Override
    public int insertWcsGuideConfig(WcsGuideConfig wcsGuideConfig)
    {
        return wcsGuideConfigMapper.insertWcsGuideConfig(wcsGuideConfig);
    }

    /**
     * 修改路由配置
     * 
     * @param wcsGuideConfig 路由配置
     * @return 结果
     */
    @Override
    public int updateWcsGuideConfig(WcsGuideConfig wcsGuideConfig)
    {
        return wcsGuideConfigMapper.updateWcsGuideConfig(wcsGuideConfig);
    }

    /**
     * 批量删除路由配置
     * 
     * @param ids 需要删除的路由配置ID
     * @return 结果
     */
    @Override
    public int deleteWcsGuideConfigByIds(Long[] ids)
    {
        return wcsGuideConfigMapper.deleteWcsGuideConfigByIds(ids);
    }

    /**
     * 删除路由配置信息
     * 
     * @param id 路由配置ID
     * @return 结果
     */
    @Override
    public int deleteWcsGuideConfigById(Long id)
    {
        return wcsGuideConfigMapper.deleteWcsGuideConfigById(id);
    }
}
