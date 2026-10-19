package com.ruoyi.wcs.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.wcs.domain.WcsBcrSuccessPercent;
import com.ruoyi.wcs.service.IWcsBcrSuccessPercentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 扫码率Controller
 * 
 * @author ruoyi
 * @date 2021-07-07
 */
@RestController
@RequestMapping("/wcs/bcr_percent")
public class WcsBcrSuccessPercentController extends BaseController
{
    @Autowired
    private IWcsBcrSuccessPercentService wcsBcrSuccessPercentService;

    /**
     * 查询扫码率列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:bcr_percent:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsBcrSuccessPercent wcsBcrSuccessPercent)
    {
        startPage();
        List<WcsBcrSuccessPercent> list = wcsBcrSuccessPercentService.selectWcsBcrSuccessPercentList(wcsBcrSuccessPercent);
        return getDataTable(list);
    }

    /**
     * 导出扫码率列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:bcr_percent:export')")
    @Log(title = "扫码率", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsBcrSuccessPercent wcsBcrSuccessPercent)
    {
        List<WcsBcrSuccessPercent> list = wcsBcrSuccessPercentService.selectWcsBcrSuccessPercentList(wcsBcrSuccessPercent);
        ExcelUtil<WcsBcrSuccessPercent> util = new ExcelUtil<WcsBcrSuccessPercent>(WcsBcrSuccessPercent.class);
        return util.exportExcel(list, "Scan Rate Data");
    }

    /**
     * 获取扫码率详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:bcr_percent:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsBcrSuccessPercentService.selectWcsBcrSuccessPercentById(id));
    }

    /**
     * 新增扫码率
     */
    @PreAuthorize("@ss.hasPermi('wcs:bcr_percent:add')")
    @Log(title = "扫码率", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsBcrSuccessPercent wcsBcrSuccessPercent)
    {
        return toAjax(wcsBcrSuccessPercentService.insertWcsBcrSuccessPercent(wcsBcrSuccessPercent));
    }

    /**
     * 修改扫码率
     */
    @PreAuthorize("@ss.hasPermi('wcs:bcr_percent:edit')")
    @Log(title = "扫码率", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsBcrSuccessPercent wcsBcrSuccessPercent)
    {
        return toAjax(wcsBcrSuccessPercentService.updateWcsBcrSuccessPercent(wcsBcrSuccessPercent));
    }

    /**
     * 删除扫码率
     */
    @PreAuthorize("@ss.hasPermi('wcs:bcr_percent:remove')")
    @Log(title = "扫码率", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsBcrSuccessPercentService.deleteWcsBcrSuccessPercentByIds(ids));
    }
}
