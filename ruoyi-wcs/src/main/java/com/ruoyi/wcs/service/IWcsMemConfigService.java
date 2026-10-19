package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.WcsMemConfig;

/**
 * wcs参数配置Service接口
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
public interface IWcsMemConfigService 
{
    /**
     * 查询wcs参数配置
     * 
     * @param id wcs参数配置ID
     * @return wcs参数配置
     */
    public WcsMemConfig selectWcsMemConfigById(Long id);

    /**
     * 查询wcs参数配置列表
     * 
     * @param wcsMemConfig wcs参数配置
     * @return wcs参数配置集合
     */
    public List<WcsMemConfig> selectWcsMemConfigList(WcsMemConfig wcsMemConfig);

    /**
     * 新增wcs参数配置
     * 
     * @param wcsMemConfig wcs参数配置
     * @return 结果
     */
    public int insertWcsMemConfig(WcsMemConfig wcsMemConfig);

    /**
     * 修改wcs参数配置
     * 
     * @param wcsMemConfig wcs参数配置
     * @return 结果
     */
    public int updateWcsMemConfig(WcsMemConfig wcsMemConfig);

    /**
     * 批量删除wcs参数配置
     * 
     * @param ids 需要删除的wcs参数配置ID
     * @return 结果
     */
    public int deleteWcsMemConfigByIds(Long[] ids);

    /**
     * 删除wcs参数配置信息
     * 
     * @param id wcs参数配置ID
     * @return 结果
     */
    public int deleteWcsMemConfigById(Long id);

    /**
     * 调用离线上传存储过程
     *
     * @param paramMap 包含输入参数 p_input 和输出参数 p_code, p_msg 的 map
     */
    public void executeOfflineUpload(java.util.Map<String, Object> paramMap);
}
