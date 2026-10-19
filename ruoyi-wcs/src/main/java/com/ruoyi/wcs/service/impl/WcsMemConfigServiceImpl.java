package com.ruoyi.wcs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsMemConfigMapper;
import com.ruoyi.wcs.domain.WcsMemConfig;
import com.ruoyi.wcs.service.IWcsMemConfigService;

/**
 * wcs参数配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Service
public class WcsMemConfigServiceImpl implements IWcsMemConfigService 
{
    @Autowired
    private WcsMemConfigMapper wcsMemConfigMapper;

    /**
     * 查询wcs参数配置
     * 
     * @param id wcs参数配置ID
     * @return wcs参数配置
     */
    @Override
    public WcsMemConfig selectWcsMemConfigById(Long id)
    {
        return wcsMemConfigMapper.selectWcsMemConfigById(id);
    }

    /**
     * 查询wcs参数配置列表
     * 
     * @param wcsMemConfig wcs参数配置
     * @return wcs参数配置
     */
    @Override
    public List<WcsMemConfig> selectWcsMemConfigList(WcsMemConfig wcsMemConfig)
    {
        return wcsMemConfigMapper.selectWcsMemConfigList(wcsMemConfig);
    }

    /**
     * 新增wcs参数配置
     * 
     * @param wcsMemConfig wcs参数配置
     * @return 结果
     */
    @Override
    public int insertWcsMemConfig(WcsMemConfig wcsMemConfig)
    {
        return wcsMemConfigMapper.insertWcsMemConfig(wcsMemConfig);
    }

    /**
     * 修改wcs参数配置
     * 
     * @param wcsMemConfig wcs参数配置
     * @return 结果
     */
    @Override
    public int updateWcsMemConfig(WcsMemConfig wcsMemConfig)
    {
        return wcsMemConfigMapper.updateWcsMemConfig(wcsMemConfig);
    }

    /**
     * 批量删除wcs参数配置
     * 
     * @param ids 需要删除的wcs参数配置ID
     * @return 结果
     */
    @Override
    public int deleteWcsMemConfigByIds(Long[] ids)
    {
        return wcsMemConfigMapper.deleteWcsMemConfigByIds(ids);
    }

    /**
     * 删除wcs参数配置信息
     * 
     * @param id wcs参数配置ID
     * @return 结果
     */
    @Override
    public int deleteWcsMemConfigById(Long id)
    {
        return wcsMemConfigMapper.deleteWcsMemConfigById(id);
    }

    /**
     * 调用离线上传存储过程
     *
     * @param paramMap 包含输入参数 p_input 和输出参数 p_code, p_msg 的 map
     */
    @Override
    public void executeOfflineUpload(java.util.Map<String, Object> paramMap)
    {
        wcsMemConfigMapper.executeOfflineUpload(paramMap);
    }
}
