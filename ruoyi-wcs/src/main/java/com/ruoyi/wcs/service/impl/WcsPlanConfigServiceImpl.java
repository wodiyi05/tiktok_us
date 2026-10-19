package com.ruoyi.wcs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsPlanConfigMapper;
import com.ruoyi.wcs.domain.WcsPlanConfig;
import com.ruoyi.wcs.service.IWcsPlanConfigService;

/**
 * 分拣计划配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Service
public class WcsPlanConfigServiceImpl implements IWcsPlanConfigService 
{
    @Autowired
    private WcsPlanConfigMapper wcsPlanConfigMapper;

    /**
     * 查询分拣计划配置
     * 
     * @param id 分拣计划配置ID
     * @return 分拣计划配置
     */
    @Override
    public WcsPlanConfig selectWcsPlanConfigById(Long id)
    {
        return wcsPlanConfigMapper.selectWcsPlanConfigById(id);
    }

    /**
     * 查询分拣计划配置列表
     * 
     * @param wcsPlanConfig 分拣计划配置
     * @return 分拣计划配置
     */
    @Override
    public List<WcsPlanConfig> selectWcsPlanConfigList(WcsPlanConfig wcsPlanConfig)
    {
        return wcsPlanConfigMapper.selectWcsPlanConfigList(wcsPlanConfig);
    }

    /**
     * 新增分拣计划配置
     * 
     * @param wcsPlanConfig 分拣计划配置
     * @return 结果
     */
    @Override
    public int insertWcsPlanConfig(WcsPlanConfig wcsPlanConfig)
    {
        return wcsPlanConfigMapper.insertWcsPlanConfig(wcsPlanConfig);
    }

    /**
     * 修改分拣计划配置
     * 
     * @param wcsPlanConfig 分拣计划配置
     * @return 结果
     */
    @Override
    public int updateWcsPlanConfig(WcsPlanConfig wcsPlanConfig)
    {
        return wcsPlanConfigMapper.updateWcsPlanConfig(wcsPlanConfig);
    }

    /**
     * 批量删除分拣计划配置
     * 
     * @param ids 需要删除的分拣计划配置ID
     * @return 结果
     */
    @Override
    public int deleteWcsPlanConfigByIds(Long[] ids)
    {
        return wcsPlanConfigMapper.deleteWcsPlanConfigByIds(ids);
    }

    /**
     * 删除分拣计划配置信息
     * 
     * @param id 分拣计划配置ID
     * @return 结果
     */
    @Override
    public int deleteWcsPlanConfigById(Long id)
    {
        return wcsPlanConfigMapper.deleteWcsPlanConfigById(id);
    }
}
