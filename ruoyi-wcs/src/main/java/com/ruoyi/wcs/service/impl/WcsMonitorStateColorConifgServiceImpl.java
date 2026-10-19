package com.ruoyi.wcs.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wcs.mapper.WcsMonitorStateColorConifgMapper;
import com.ruoyi.wcs.domain.WcsMonitorStateColorConifg;
import com.ruoyi.wcs.service.IWcsMonitorStateColorConifgService;

/**
 * 颜色配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-12
 */
@Service
@DataSource(DataSourceType.SLAVE)
public class WcsMonitorStateColorConifgServiceImpl implements IWcsMonitorStateColorConifgService 
{
    @Autowired
    private WcsMonitorStateColorConifgMapper wcsMonitorStateColorConifgMapper;

    /**
     * 查询颜色配置
     * 
     * @param id 颜色配置ID
     * @return 颜色配置
     */
    @Override
    public WcsMonitorStateColorConifg selectWcsMonitorStateColorConifgById(Long id)
    {
        return wcsMonitorStateColorConifgMapper.selectWcsMonitorStateColorConifgById(id);
    }

    /**
     * 查询颜色配置列表
     * 
     * @param wcsMonitorStateColorConifg 颜色配置
     * @return 颜色配置
     */
    @Override
    public List<WcsMonitorStateColorConifg> selectWcsMonitorStateColorConifgList(WcsMonitorStateColorConifg wcsMonitorStateColorConifg)
    {
        List<WcsMonitorStateColorConifg> colorList = wcsMonitorStateColorConifgMapper.selectWcsMonitorStateColorConifgList(wcsMonitorStateColorConifg);
        //创建一个保存DevType的有序集合，用于下次遍历
        TreeSet<Integer> devTypeSet = new TreeSet<>();
        for(WcsMonitorStateColorConifg color : colorList){
            devTypeSet.add(Integer.valueOf(color.getDevType()));
        }
//        System.out.println(devTypeSet);
        //创建保存排序后数据的list
        ArrayList<TreeSet<Integer>> colorSortList = new ArrayList<>();
        //根据设备类型集合中的最大值给排序数组添加n+1个数的元素
//        System.out.println(devTypeSet.last());
        for(int i=0;i<=devTypeSet.last();i++){
            colorSortList.add(new TreeSet<>());
        }
//        System.out.println(colorSortList);
        //每遍历一次devType就将该次数据放入到一个有序集合中去
        //因为sql中已经根据devType和devState进项排序，所以不会打乱devState集合们的顺序
         for(Integer i:devTypeSet){
             TreeSet<Integer> devStateSet = new TreeSet<>();
             for(WcsMonitorStateColorConifg color : colorList){
                if(Integer.valueOf(color.getDevType())==i){
                    devStateSet.add(Integer.valueOf(color.getDevState()));
                }
            }
             colorSortList.add(i,devStateSet);

        }
         //将多于最大值的集合移除
         colorSortList.subList(devTypeSet.last()+1,colorSortList.size()).clear();
//        System.out.println(colorSortList);

        return colorList;
    }


    /**
     * 新增颜色配置
     * 
     * @param wcsMonitorStateColorConifg 颜色配置
     * @return 结果
     */
    @Override
    public int insertWcsMonitorStateColorConifg(WcsMonitorStateColorConifg wcsMonitorStateColorConifg)
    {
        return wcsMonitorStateColorConifgMapper.insertWcsMonitorStateColorConifg(wcsMonitorStateColorConifg);
    }

    /**
     * 修改颜色配置
     * 
     * @param wcsMonitorStateColorConifg 颜色配置
     * @return 结果
     */
    @Override
    public int updateWcsMonitorStateColorConifg(WcsMonitorStateColorConifg wcsMonitorStateColorConifg)
    {
        return wcsMonitorStateColorConifgMapper.updateWcsMonitorStateColorConifg(wcsMonitorStateColorConifg);
    }

    /**
     * 批量删除颜色配置
     * 
     * @param ids 需要删除的颜色配置ID
     * @return 结果
     */
    @Override
    public int deleteWcsMonitorStateColorConifgByIds(Long[] ids)
    {
        return wcsMonitorStateColorConifgMapper.deleteWcsMonitorStateColorConifgByIds(ids);
    }

    /**
     * 删除颜色配置信息
     * 
     * @param id 颜色配置ID
     * @return 结果
     */
    @Override
    public int deleteWcsMonitorStateColorConifgById(Long id)
    {
        return wcsMonitorStateColorConifgMapper.deleteWcsMonitorStateColorConifgById(id);
    }
}
