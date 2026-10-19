package com.ruoyi.wcs.mapper;

import java.util.List;
import com.ruoyi.wcs.domain.WcsPlanConfig;

/**
 * 分拣计划配置Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
public interface WcsPlanConfigMapper 
{
    /**
     * 查询分拣计划配置
     * 
     * @param id 分拣计划配置ID
     * @return 分拣计划配置
     */
    public WcsPlanConfig selectWcsPlanConfigById(Long id);

    /**
     * 查询分拣计划配置列表
     * 
     * @param wcsPlanConfig 分拣计划配置
     * @return 分拣计划配置集合
     */
    public List<WcsPlanConfig> selectWcsPlanConfigList(WcsPlanConfig wcsPlanConfig);

    /**
     * 新增分拣计划配置
     * 
     * @param wcsPlanConfig 分拣计划配置
     * @return 结果
     */
    public int insertWcsPlanConfig(WcsPlanConfig wcsPlanConfig);

    /**
     * 修改分拣计划配置
     * 
     * @param wcsPlanConfig 分拣计划配置
     * @return 结果
     */
    public int updateWcsPlanConfig(WcsPlanConfig wcsPlanConfig);

    /**
     * 删除分拣计划配置
     * 
     * @param id 分拣计划配置ID
     * @return 结果
     */
    public int deleteWcsPlanConfigById(Long id);

    /**
     * 批量删除分拣计划配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWcsPlanConfigByIds(Long[] ids);
}
