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
import com.ruoyi.wcs.domain.WcsGuideConfig;
import com.ruoyi.wcs.service.IWcsGuideConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 路由配置Controller
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@RestController
@RequestMapping("/wcs/wcs_guide_config")
public class WcsGuideConfigController extends BaseController
{
    @Autowired
    private IWcsGuideConfigService wcsGuideConfigService;

    /**
     * 查询路由配置列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_guide_config:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsGuideConfig wcsGuideConfig)
    {
        startPage();
        List<WcsGuideConfig> list = wcsGuideConfigService.selectWcsGuideConfigList(wcsGuideConfig);
        return getDataTable(list);
    }

    /**
     * 导出路由配置列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_guide_config:export')")
    @Log(title = "路由配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsGuideConfig wcsGuideConfig)
    {
        List<WcsGuideConfig> list = wcsGuideConfigService.selectWcsGuideConfigList(wcsGuideConfig);
        ExcelUtil<WcsGuideConfig> util = new ExcelUtil<WcsGuideConfig>(WcsGuideConfig.class);
        return util.exportExcel(list, "路由配置数据");
    }

    /**
     * 获取路由配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_guide_config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsGuideConfigService.selectWcsGuideConfigById(id));
    }

    /**
     * 新增路由配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_guide_config:add')")
    @Log(title = "路由配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsGuideConfig wcsGuideConfig)
    {
        return toAjax(wcsGuideConfigService.insertWcsGuideConfig(wcsGuideConfig));
    }

    /**
     * 修改路由配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_guide_config:edit')")
    @Log(title = "路由配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsGuideConfig wcsGuideConfig)
    {
        return toAjax(wcsGuideConfigService.updateWcsGuideConfig(wcsGuideConfig));
    }

    /**
     * 删除路由配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_guide_config:remove')")
    @Log(title = "路由配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsGuideConfigService.deleteWcsGuideConfigByIds(ids));
    }
}
