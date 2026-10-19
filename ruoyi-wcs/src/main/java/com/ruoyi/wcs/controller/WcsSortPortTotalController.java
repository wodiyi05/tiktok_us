package com.ruoyi.wcs.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.wcs.domain.WcsSortPortTotal;
import com.ruoyi.wcs.service.IWcsSortPortTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分拣口统计Controller
 * 
 * @author ruoyi
 * @date 2021-07-13
 */
@RestController
@RequestMapping("/wcs/sortPortTotal")
public class WcsSortPortTotalController extends BaseController
{
    @Autowired
    private IWcsSortPortTotalService wcsSortPortTotalService;

    /**
     * 查询分拣口统计列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:sortPortTotal:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsSortPortTotal wcsSortPortTotal)
    {
        startPage();
        List<WcsSortPortTotal> list = wcsSortPortTotalService.selectWcsSortPortTotalList(wcsSortPortTotal);
        return getDataTable(list);
    }

    /**
     * 导出分拣口统计列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:sortPortTotal:export')")
    @Log(title = "分拣口统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsSortPortTotal wcsSortPortTotal)
    {
        List<WcsSortPortTotal> list = wcsSortPortTotalService.selectWcsSortPortTotalList(wcsSortPortTotal);
        ExcelUtil<WcsSortPortTotal> util = new ExcelUtil<WcsSortPortTotal>(WcsSortPortTotal.class);
        return util.exportExcel(list, "Sorting Port Statistics Data");
    }

    /**
     * 获取分拣口统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:sortPortTotal:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsSortPortTotalService.selectWcsSortPortTotalById(id));
    }

    /**
     * 新增分拣口统计
     */
    @PreAuthorize("@ss.hasPermi('wcs:sortPortTotal:add')")
    @Log(title = "分拣口统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsSortPortTotal wcsSortPortTotal)
    {
        return toAjax(wcsSortPortTotalService.insertWcsSortPortTotal(wcsSortPortTotal));
    }

    /**
     * 修改分拣口统计
     */
    @PreAuthorize("@ss.hasPermi('wcs:sortPortTotal:edit')")
    @Log(title = "分拣口统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsSortPortTotal wcsSortPortTotal)
    {
        return toAjax(wcsSortPortTotalService.updateWcsSortPortTotal(wcsSortPortTotal));
    }

    /**
     * 删除分拣口统计
     */
    @PreAuthorize("@ss.hasPermi('wcs:sortPortTotal:remove')")
    @Log(title = "分拣口统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsSortPortTotalService.deleteWcsSortPortTotalByIds(ids));
    }
}
