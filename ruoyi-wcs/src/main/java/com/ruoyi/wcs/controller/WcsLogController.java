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
import com.ruoyi.wcs.domain.WcsLog;
import com.ruoyi.wcs.service.IWcsLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * wcs日志Controller
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@RestController
@RequestMapping("/wcs/wcs_log")
public class WcsLogController extends BaseController
{
    @Autowired
    private IWcsLogService wcsLogService;

    /**
     * 查询wcs日志列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_log:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsLog wcsLog)
    {
        startPage();
        List<WcsLog> list = wcsLogService.selectWcsLogList(wcsLog);
        return getDataTable(list);
    }

    /**
     * 导出wcs日志列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_log:export')")
    @Log(title = "wcs log", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsLog wcsLog)
    {
        List<WcsLog> list = wcsLogService.selectWcsLogList(wcsLog);
        ExcelUtil<WcsLog> util = new ExcelUtil<WcsLog>(WcsLog.class);
        return util.exportExcel(list, "wcs log");
    }

    /**
     * 获取wcs日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_log:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsLogService.selectWcsLogById(id));
    }

    /**
     * 新增wcs日志
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_log:add')")
    @Log(title = "wcs log", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsLog wcsLog)
    {
        return toAjax(wcsLogService.insertWcsLog(wcsLog));
    }

    /**
     * 修改wcs日志
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_log:edit')")
    @Log(title = "wcs log", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsLog wcsLog)
    {
        return toAjax(wcsLogService.updateWcsLog(wcsLog));
    }

    /**
     * 删除wcs日志
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_log:remove')")
    @Log(title = "wcs log", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsLogService.deleteWcsLogByIds(ids));
    }
}
