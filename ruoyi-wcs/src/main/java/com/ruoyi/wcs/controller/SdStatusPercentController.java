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
import com.ruoyi.wcs.domain.SdStatusPercent;
import com.ruoyi.wcs.service.ISdStatusPercentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * sdStatusPercentController
 * 
 * @author ruoyi
 * @date 2026-09-17
 */
@RestController
@RequestMapping("/wcs/sdStatusPercent")
public class SdStatusPercentController extends BaseController
{
    @Autowired
    private ISdStatusPercentService sdStatusPercentService;

    /**
     * 查询sdStatusPercent列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:sdStatusPercent:list')")
    @GetMapping("/list")
    public TableDataInfo list(SdStatusPercent sdStatusPercent)
    {
        startPage();
        List<SdStatusPercent> list = sdStatusPercentService.selectSdStatusPercentList(sdStatusPercent);
        return getDataTable(list);
    }

    /**
     * 导出sdStatusPercent列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:sdStatusPercent:export')")
    @Log(title = "sdStatusPercent", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SdStatusPercent sdStatusPercent)
    {
        List<SdStatusPercent> list = sdStatusPercentService.selectSdStatusPercentList(sdStatusPercent);
        ExcelUtil<SdStatusPercent> util = new ExcelUtil<SdStatusPercent>(SdStatusPercent.class);
        return util.exportExcel(list, "sdStatusPercent");
    }

    /**
     * 获取sdStatusPercent详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:sdStatusPercent:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sdStatusPercentService.selectSdStatusPercentById(id));
    }

    /**
     * 新增sdStatusPercent
     */
    @PreAuthorize("@ss.hasPermi('wcs:sdStatusPercent:add')")
    @Log(title = "sdStatusPercent", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SdStatusPercent sdStatusPercent)
    {
        return toAjax(sdStatusPercentService.insertSdStatusPercent(sdStatusPercent));
    }

    /**
     * 修改sdStatusPercent
     */
    @PreAuthorize("@ss.hasPermi('wcs:sdStatusPercent:edit')")
    @Log(title = "sdStatusPercent", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SdStatusPercent sdStatusPercent)
    {
        return toAjax(sdStatusPercentService.updateSdStatusPercent(sdStatusPercent));
    }

    /**
     * 删除sdStatusPercent
     */
    @PreAuthorize("@ss.hasPermi('wcs:sdStatusPercent:remove')")
    @Log(title = "sdStatusPercent", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sdStatusPercentService.deleteSdStatusPercentByIds(ids));
    }
}
