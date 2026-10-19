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
import com.ruoyi.wcs.domain.WcsLogSum;
import com.ruoyi.wcs.service.IWcsLogSumService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * log_sumController
 * 
 * @author ruoyi
 * @date 2026-09-11
 */
@RestController
@RequestMapping("/wcs/sortSum")
public class WcsLogSumController extends BaseController
{
    @Autowired
    private IWcsLogSumService wcsLogSumService;

    /**
     * 查询log_sum列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:sortSum:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsLogSum wcsLogSum)
    {
// 🚨 核心修改：删除或注释掉 startPage(); 阻止 PageHelper 拦截并改写存储过程 SQL
        // startPage();
        List<WcsLogSum> list = wcsLogSumService.selectWcsLogSumList(wcsLogSum);
        return getDataTable(list);
    }

    /**
     * 导出log_sum列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:sortSum:export')")
    @Log(title = "log_sum", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsLogSum wcsLogSum)
    {
        List<WcsLogSum> list = wcsLogSumService.selectWcsLogSumList(wcsLogSum);
        ExcelUtil<WcsLogSum> util = new ExcelUtil<WcsLogSum>(WcsLogSum.class);
        return util.exportExcel(list, "SortSum");
    }

    /**
     * 获取log_sum详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:sortSum:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsLogSumService.selectWcsLogSumById(id));
    }

    /**
     * 新增log_sum
     */
    @PreAuthorize("@ss.hasPermi('wcs:sortSum:add')")
    @Log(title = "log_sum", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsLogSum wcsLogSum)
    {
        return toAjax(wcsLogSumService.insertWcsLogSum(wcsLogSum));
    }

    /**
     * 修改log_sum
     */
    @PreAuthorize("@ss.hasPermi('wcs:sortSum:edit')")
    @Log(title = "log_sum", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsLogSum wcsLogSum)
    {
        return toAjax(wcsLogSumService.updateWcsLogSum(wcsLogSum));
    }

    /**
     * 删除log_sum
     */
    @PreAuthorize("@ss.hasPermi('wcs:sortSum:remove')")
    @Log(title = "log_sum", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsLogSumService.deleteWcsLogSumByIds(ids));
    }
}
