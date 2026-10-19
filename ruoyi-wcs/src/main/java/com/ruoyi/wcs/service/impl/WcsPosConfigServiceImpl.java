package com.ruoyi.wcs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsPosConfigMapper;
import com.ruoyi.wcs.domain.WcsPosConfig;
import com.ruoyi.wcs.service.IWcsPosConfigService;

/**
 * 出口配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Service
public class WcsPosConfigServiceImpl implements IWcsPosConfigService 
{
    @Autowired
    private WcsPosConfigMapper wcsPosConfigMapper;

    /**
     * 查询出口配置
     * 
     * @param id 出口配置ID
     * @return 出口配置
     */
    @Override
    public WcsPosConfig selectWcsPosConfigById(Long id)
    {
        return wcsPosConfigMapper.selectWcsPosConfigById(id);
    }

    /**
     * 查询出口配置列表
     * 
     * @param wcsPosConfig 出口配置
     * @return 出口配置
     */
    @Override
    public List<WcsPosConfig> selectWcsPosConfigList(WcsPosConfig wcsPosConfig)
    {
        return wcsPosConfigMapper.selectWcsPosConfigList(wcsPosConfig);
    }

    /**
     * 新增出口配置
     * 
     * @param wcsPosConfig 出口配置
     * @return 结果
     */
    @Override
    public int insertWcsPosConfig(WcsPosConfig wcsPosConfig)
    {
        return wcsPosConfigMapper.insertWcsPosConfig(wcsPosConfig);
    }

    /**
     * 修改出口配置
     * 
     * @param wcsPosConfig 出口配置
     * @return 结果
     */
    @Override
    public int updateWcsPosConfig(WcsPosConfig wcsPosConfig)
    {
        return wcsPosConfigMapper.updateWcsPosConfig(wcsPosConfig);
    }

    /**
     * 批量删除出口配置
     * 
     * @param ids 需要删除的出口配置ID
     * @return 结果
     */
    @Override
    public int deleteWcsPosConfigByIds(Long[] ids)
    {
        return wcsPosConfigMapper.deleteWcsPosConfigByIds(ids);
    }

    /**
     * 删除出口配置信息
     * 
     * @param id 出口配置ID
     * @return 结果
     */
    @Override
    public int deleteWcsPosConfigById(Long id)
    {
        return wcsPosConfigMapper.deleteWcsPosConfigById(id);
    }
}
