package com.ruoyi.wcs.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsStnMapper;
import com.ruoyi.wcs.domain.WcsStn;
import com.ruoyi.wcs.service.IWcsStnService;

/**
 * 设备监控Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
@Service
@DataSource(DataSourceType.SLAVE)
public class WcsStnServiceImpl implements IWcsStnService 
{
    @Autowired
    private WcsStnMapper wcsStnMapper;

    /**
     * 查询设备监控
     * 
     * @param stnId 设备监控ID
     * @return 设备监控
     */
    @Override
    public WcsStn selectWcsStnById(String stnId)
    {
        return wcsStnMapper.selectWcsStnById(stnId);
    }

    /**
     * 查询设备监控列表
     * 
     * @param wcsStn 设备监控
     * @return 设备监控
     */
    @Override
    public List<WcsStn> selectWcsStnList(WcsStn wcsStn)
    {
        return wcsStnMapper.selectWcsStnList(wcsStn);
    }

    /**
     * 新增设备监控
     * 
     * @param wcsStn 设备监控
     * @return 结果
     */
    @Override
    public int insertWcsStn(WcsStn wcsStn)
    {
        wcsStnMapper.insertWcsStn(wcsStn);
        return 1;
    }

    /**
     * 修改设备监控
     * 
     * @param wcsStn 设备监控
     * @return 结果
     */
    @Override
    public int updateWcsStn(WcsStn wcsStn)
    {
        return wcsStnMapper.updateWcsStn(wcsStn);
    }

    /**
     * 批量删除设备监控
     * 
     * @param stnIds 需要删除的设备监控ID
     * @return 结果
     */
    @Override
    public int deleteWcsStnByIds(String[] stnIds)
    {
        return wcsStnMapper.deleteWcsStnByIds(stnIds);
    }

    /**
     * 删除设备监控信息
     * 
     * @param stnId 设备监控ID
     * @return 结果
     */
    @Override
    public int deleteWcsStnById(String stnId)
    {
        return wcsStnMapper.deleteWcsStnById(stnId);
    }
}
