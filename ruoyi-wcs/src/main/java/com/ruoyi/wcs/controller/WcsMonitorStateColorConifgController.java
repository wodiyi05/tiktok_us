package com.ruoyi.wcs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wcs.domain.WcsMonitorStateColorConifg;
import com.ruoyi.wcs.service.IWcsMonitorStateColorConifgService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 颜色配置Controller
 * 
 * @author ruoyi
 * @date 2021-10-12
 */
@RestController
@RequestMapping("/wcs/color_conifg")
public class WcsMonitorStateColorConifgController extends BaseController
{
    @Autowired
    private IWcsMonitorStateColorConifgService wcsMonitorStateColorConifgService;

    /**
     * 查询颜色配置列表
     */
//    @PreAuthorize("@ss.hasPermi('wcs:color_conifg:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsMonitorStateColorConifg wcsMonitorStateColorConifg)
    {
        startPage();
        List<WcsMonitorStateColorConifg> list = wcsMonitorStateColorConifgService.selectWcsMonitorStateColorConifgList(wcsMonitorStateColorConifg);
        return getDataTable(list);
    }

    /**
     * 生成排序后的数组
     */
//    @PreAuthorize("@ss.hasPermi('wcs:color_conifg:list')")
    @GetMapping("/sort_list")
    public WcsMonitorStateColorConifg sortList(WcsMonitorStateColorConifg wcsMonitorStateColorConifg)
    {

        List<WcsMonitorStateColorConifg> colorList = wcsMonitorStateColorConifgService.selectWcsMonitorStateColorConifgList(wcsMonitorStateColorConifg);
        //创建一个保存DevType的有序集合，用于下次遍历
        TreeSet<Integer> devTypeSet = new TreeSet<>();
        for(WcsMonitorStateColorConifg color : colorList){
            devTypeSet.add(Integer.valueOf(color.getDevType()));
        }
//        System.out.println(devTypeSet);
        //创建保存排序后数据的list
        ArrayList<TreeSet<WcsMonitorStateColorConifg>> colorSortList = new ArrayList<>();
        //根据设备类型集合中的最大值给排序数组添加n+1个数的元素
//        System.out.println(devTypeSet.last());
        for(int i=0;i<=devTypeSet.last();i++){
            colorSortList.add(new TreeSet<>());
        }
//        System.out.println(colorSortList);
        //每遍历一次devType就将该次数据放入到一个有序集合中去
        //因为sql中已经根据devType和devState进项排序，所以不会打乱devState集合们的顺序
        for(Integer i:devTypeSet){
            TreeSet<WcsMonitorStateColorConifg> devStateSet = new TreeSet<>();
            for(WcsMonitorStateColorConifg color : colorList){
                if(Integer.valueOf(color.getDevType())==i){
                    devStateSet.add(color);
                }
            }
            colorSortList.add(i,devStateSet);

        }
        //将多于最大值的集合移除
        colorSortList.subList(devTypeSet.last()+1,colorSortList.size()).clear();


        WcsMonitorStateColorConifg sortColor = new WcsMonitorStateColorConifg();

        sortColor.setColorArr(colorSortList);
        return sortColor;
    }

    /**
     * 导出颜色配置列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:color_conifg:export')")
    @Log(title = "颜色配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsMonitorStateColorConifg wcsMonitorStateColorConifg)
    {
        List<WcsMonitorStateColorConifg> list = wcsMonitorStateColorConifgService.selectWcsMonitorStateColorConifgList(wcsMonitorStateColorConifg);
        ExcelUtil<WcsMonitorStateColorConifg> util = new ExcelUtil<WcsMonitorStateColorConifg>(WcsMonitorStateColorConifg.class);
        return util.exportExcel(list, "颜色配置数据");
    }

    /**
     * 获取颜色配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:color_conifg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsMonitorStateColorConifgService.selectWcsMonitorStateColorConifgById(id));
    }

    /**
     * 新增颜色配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:color_conifg:add')")
    @Log(title = "颜色配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsMonitorStateColorConifg wcsMonitorStateColorConifg)
    {
        return toAjax(wcsMonitorStateColorConifgService.insertWcsMonitorStateColorConifg(wcsMonitorStateColorConifg));
    }

    /**
     * 修改颜色配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:color_conifg:edit')")
    @Log(title = "颜色配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsMonitorStateColorConifg wcsMonitorStateColorConifg)
    {
        return toAjax(wcsMonitorStateColorConifgService.updateWcsMonitorStateColorConifg(wcsMonitorStateColorConifg));
    }

    /**
     * 删除颜色配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:color_conifg:remove')")
    @Log(title = "颜色配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsMonitorStateColorConifgService.deleteWcsMonitorStateColorConifgByIds(ids));
    }
}
