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
import com.ruoyi.wcs.domain.WcsMemType;
import com.ruoyi.wcs.service.IWcsMemTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 参数类型配置Controller
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@RestController
@RequestMapping("/wcs/wcs_mem_type")
public class WcsMemTypeController extends BaseController
{
    @Autowired
    private IWcsMemTypeService wcsMemTypeService;

    /**
     * 查询参数类型配置列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_mem_type:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsMemType wcsMemType)
    {
        startPage();
        List<WcsMemType> list = wcsMemTypeService.selectWcsMemTypeList(wcsMemType);
        return getDataTable(list);
    }

    /**
     * 导出参数类型配置列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_mem_type:export')")
    @Log(title = "参数类型配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsMemType wcsMemType)
    {
        List<WcsMemType> list = wcsMemTypeService.selectWcsMemTypeList(wcsMemType);
        ExcelUtil<WcsMemType> util = new ExcelUtil<WcsMemType>(WcsMemType.class);
        return util.exportExcel(list, "参数类型配置数据");
    }

    /**
     * 获取参数类型配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_mem_type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsMemTypeService.selectWcsMemTypeById(id));
    }

    /**
     * 新增参数类型配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_mem_type:add')")
    @Log(title = "参数类型配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsMemType wcsMemType)
    {
        return toAjax(wcsMemTypeService.insertWcsMemType(wcsMemType));
    }

    /**
     * 修改参数类型配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_mem_type:edit')")
    @Log(title = "参数类型配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsMemType wcsMemType)
    {
        return toAjax(wcsMemTypeService.updateWcsMemType(wcsMemType));
    }

    /**
     * 删除参数类型配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_mem_type:remove')")
    @Log(title = "参数类型配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsMemTypeService.deleteWcsMemTypeByIds(ids));
    }
}
