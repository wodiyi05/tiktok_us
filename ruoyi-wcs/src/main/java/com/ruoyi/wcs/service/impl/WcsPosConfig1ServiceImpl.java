package com.ruoyi.wcs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsPosConfig1Mapper;
import com.ruoyi.wcs.domain.WcsPosConfig1;
import com.ruoyi.wcs.service.IWcsPosConfig1Service;

/**
 * chute1Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-16
 */
@Service
public class WcsPosConfig1ServiceImpl implements IWcsPosConfig1Service 
{
    @Autowired
    private WcsPosConfig1Mapper wcsPosConfig1Mapper;

    /**
     * 查询chute1
     * 
     * @param id chute1ID
     * @return chute1
     */
    @Override
    public WcsPosConfig1 selectWcsPosConfig1ById(Long id)
    {
        return wcsPosConfig1Mapper.selectWcsPosConfig1ById(id);
    }

    /**
     * 查询chute1列表
     * 
     * @param wcsPosConfig1 chute1
     * @return chute1
     */
    @Override
    public List<WcsPosConfig1> selectWcsPosConfig1List(WcsPosConfig1 wcsPosConfig1)
    {
        return wcsPosConfig1Mapper.selectWcsPosConfig1List(wcsPosConfig1);
    }

    /**
     * 新增chute1
     * 
     * @param wcsPosConfig1 chute1
     * @return 结果
     */
    @Override
    public int insertWcsPosConfig1(WcsPosConfig1 wcsPosConfig1)
    {
        return wcsPosConfig1Mapper.insertWcsPosConfig1(wcsPosConfig1);
    }

    /**
     * 修改chute1
     * 
     * @param wcsPosConfig1 chute1
     * @return 结果
     */
    @Override
    public int updateWcsPosConfig1(WcsPosConfig1 wcsPosConfig1)
    {
        return wcsPosConfig1Mapper.updateWcsPosConfig1(wcsPosConfig1);
    }

    /**
     * 批量删除chute1
     * 
     * @param ids 需要删除的chute1ID
     * @return 结果
     */
    @Override
    public int deleteWcsPosConfig1ByIds(Long[] ids)
    {
        return wcsPosConfig1Mapper.deleteWcsPosConfig1ByIds(ids);
    }

    /**
     * 删除chute1信息
     * 
     * @param id chute1ID
     * @return 结果
     */
    @Override
    public int deleteWcsPosConfig1ById(Long id)
    {
        return wcsPosConfig1Mapper.deleteWcsPosConfig1ById(id);
    }
}
