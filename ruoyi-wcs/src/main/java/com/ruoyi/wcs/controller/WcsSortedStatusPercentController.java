package com.ruoyi.wcs.controller;

import java.util.List;
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
import com.ruoyi.wcs.domain.WcsSortedStatusPercent;
import com.ruoyi.wcs.service.IWcsSortedStatusPercentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分拣状态统计Controller
 * 
 * @author ruoyi
 * @date 2022-09-01
 */
@RestController
@RequestMapping("/wcs/wcs_sorted_status_percent")
public class WcsSortedStatusPercentController extends BaseController
{
    @Autowired
    private IWcsSortedStatusPercentService wcsSortedStatusPercentService;

    /**
     * 查询分拣状态统计列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_sorted_status_percent:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsSortedStatusPercent wcsSortedStatusPercent)
    {
        startPage();
        List<WcsSortedStatusPercent> list = wcsSortedStatusPercentService.selectWcsSortedStatusPercentList(wcsSortedStatusPercent);
        return getDataTable(list);
    }

    /**
     * 导出分拣状态统计列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_sorted_status_percent:export')")
    @Log(title = "分拣状态统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsSortedStatusPercent wcsSortedStatusPercent)
    {
        List<WcsSortedStatusPercent> list = wcsSortedStatusPercentService.selectWcsSortedStatusPercentList(wcsSortedStatusPercent);
        ExcelUtil<WcsSortedStatusPercent> util = new ExcelUtil<WcsSortedStatusPercent>(WcsSortedStatusPercent.class);
        return util.exportExcel(list, "Sorting Status Statistics Data");
    }

    /**
     * 获取分拣状态统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_sorted_status_percent:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsSortedStatusPercentService.selectWcsSortedStatusPercentById(id));
    }

    /**
     * 新增分拣状态统计
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_sorted_status_percent:add')")
    @Log(title = "分拣状态统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsSortedStatusPercent wcsSortedStatusPercent)
    {
        return toAjax(wcsSortedStatusPercentService.insertWcsSortedStatusPercent(wcsSortedStatusPercent));
    }

    /**
     * 修改分拣状态统计
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_sorted_status_percent:edit')")
    @Log(title = "分拣状态统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsSortedStatusPercent wcsSortedStatusPercent)
    {
        return toAjax(wcsSortedStatusPercentService.updateWcsSortedStatusPercent(wcsSortedStatusPercent));
    }

    /**
     * 删除分拣状态统计
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_sorted_status_percent:remove')")
    @Log(title = "分拣状态统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsSortedStatusPercentService.deleteWcsSortedStatusPercentByIds(ids));
    }
}
