package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.WcsMemType;

/**
 * 参数类型配置Service接口
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
public interface IWcsMemTypeService 
{
    /**
     * 查询参数类型配置
     * 
     * @param id 参数类型配置ID
     * @return 参数类型配置
     */
    public WcsMemType selectWcsMemTypeById(Long id);

    /**
     * 查询参数类型配置列表
     * 
     * @param wcsMemType 参数类型配置
     * @return 参数类型配置集合
     */
    public List<WcsMemType> selectWcsMemTypeList(WcsMemType wcsMemType);

    /**
     * 新增参数类型配置
     * 
     * @param wcsMemType 参数类型配置
     * @return 结果
     */
    public int insertWcsMemType(WcsMemType wcsMemType);

    /**
     * 修改参数类型配置
     * 
     * @param wcsMemType 参数类型配置
     * @return 结果
     */
    public int updateWcsMemType(WcsMemType wcsMemType);

    /**
     * 批量删除参数类型配置
     * 
     * @param ids 需要删除的参数类型配置ID
     * @return 结果
     */
    public int deleteWcsMemTypeByIds(Long[] ids);

    /**
     * 删除参数类型配置信息
     * 
     * @param id 参数类型配置ID
     * @return 结果
     */
    public int deleteWcsMemTypeById(Long id);
}
