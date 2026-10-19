package com.ruoyi.wcs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsMemTypeMapper;
import com.ruoyi.wcs.domain.WcsMemType;
import com.ruoyi.wcs.service.IWcsMemTypeService;

/**
 * 参数类型配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Service
public class WcsMemTypeServiceImpl implements IWcsMemTypeService 
{
    @Autowired
    private WcsMemTypeMapper wcsMemTypeMapper;

    /**
     * 查询参数类型配置
     * 
     * @param id 参数类型配置ID
     * @return 参数类型配置
     */
    @Override
    public WcsMemType selectWcsMemTypeById(Long id)
    {
        return wcsMemTypeMapper.selectWcsMemTypeById(id);
    }

    /**
     * 查询参数类型配置列表
     * 
     * @param wcsMemType 参数类型配置
     * @return 参数类型配置
     */
    @Override
    public List<WcsMemType> selectWcsMemTypeList(WcsMemType wcsMemType)
    {
        return wcsMemTypeMapper.selectWcsMemTypeList(wcsMemType);
    }

    /**
     * 新增参数类型配置
     * 
     * @param wcsMemType 参数类型配置
     * @return 结果
     */
    @Override
    public int insertWcsMemType(WcsMemType wcsMemType)
    {
        return wcsMemTypeMapper.insertWcsMemType(wcsMemType);
    }

    /**
     * 修改参数类型配置
     * 
     * @param wcsMemType 参数类型配置
     * @return 结果
     */
    @Override
    public int updateWcsMemType(WcsMemType wcsMemType)
    {
        return wcsMemTypeMapper.updateWcsMemType(wcsMemType);
    }

    /**
     * 批量删除参数类型配置
     * 
     * @param ids 需要删除的参数类型配置ID
     * @return 结果
     */
    @Override
    public int deleteWcsMemTypeByIds(Long[] ids)
    {
        return wcsMemTypeMapper.deleteWcsMemTypeByIds(ids);
    }

    /**
     * 删除参数类型配置信息
     * 
     * @param id 参数类型配置ID
     * @return 结果
     */
    @Override
    public int deleteWcsMemTypeById(Long id)
    {
        return wcsMemTypeMapper.deleteWcsMemTypeById(id);
    }
}
