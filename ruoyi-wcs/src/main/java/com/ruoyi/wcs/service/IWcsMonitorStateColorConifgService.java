package com.ruoyi.wcs.service;

import java.util.List;
import com.ruoyi.wcs.domain.WcsMonitorStateColorConifg;

/**
 * 颜色配置Service接口
 * 
 * @author ruoyi
 * @date 2021-10-12
 */
public interface IWcsMonitorStateColorConifgService 
{
    /**
     * 查询颜色配置
     * 
     * @param id 颜色配置ID
     * @return 颜色配置
     */
    public WcsMonitorStateColorConifg selectWcsMonitorStateColorConifgById(Long id);

    /**
     * 查询颜色配置列表
     * 
     * @param wcsMonitorStateColorConifg 颜色配置
     * @return 颜色配置集合
     */
    public List<WcsMonitorStateColorConifg> selectWcsMonitorStateColorConifgList(WcsMonitorStateColorConifg wcsMonitorStateColorConifg);

    /**
     * 新增颜色配置
     * 
     * @param wcsMonitorStateColorConifg 颜色配置
     * @return 结果
     */
    public int insertWcsMonitorStateColorConifg(WcsMonitorStateColorConifg wcsMonitorStateColorConifg);

    /**
     * 修改颜色配置
     * 
     * @param wcsMonitorStateColorConifg 颜色配置
     * @return 结果
     */
    public int updateWcsMonitorStateColorConifg(WcsMonitorStateColorConifg wcsMonitorStateColorConifg);

    /**
     * 批量删除颜色配置
     * 
     * @param ids 需要删除的颜色配置ID
     * @return 结果
     */
    public int deleteWcsMonitorStateColorConifgByIds(Long[] ids);

    /**
     * 删除颜色配置信息
     * 
     * @param id 颜色配置ID
     * @return 结果
     */
    public int deleteWcsMonitorStateColorConifgById(Long id);
}
