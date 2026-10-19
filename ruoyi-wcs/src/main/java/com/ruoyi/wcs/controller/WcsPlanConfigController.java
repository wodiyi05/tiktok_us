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
import com.ruoyi.wcs.domain.WcsPlanConfig;
import com.ruoyi.wcs.service.IWcsPlanConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分拣计划配置Controller
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@RestController
@RequestMapping("/wcs/wcs_plan_config")
public class WcsPlanConfigController extends BaseController
{
    @Autowired
    private IWcsPlanConfigService wcsPlanConfigService;

    /**
     * 查询分拣计划配置列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_plan_config:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsPlanConfig wcsPlanConfig)
    {
        startPage();
        List<WcsPlanConfig> list = wcsPlanConfigService.selectWcsPlanConfigList(wcsPlanConfig);
        return getDataTable(list);
    }

    /**
     * 导出分拣计划配置列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_plan_config:export')")
    @Log(title = "分拣计划配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsPlanConfig wcsPlanConfig)
    {
        List<WcsPlanConfig> list = wcsPlanConfigService.selectWcsPlanConfigList(wcsPlanConfig);
        ExcelUtil<WcsPlanConfig> util = new ExcelUtil<WcsPlanConfig>(WcsPlanConfig.class);
        return util.exportExcel(list, "分拣计划配置数据");
    }

    /**
     * 获取分拣计划配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_plan_config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsPlanConfigService.selectWcsPlanConfigById(id));
    }

    /**
     * 新增分拣计划配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_plan_config:add')")
    @Log(title = "分拣计划配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsPlanConfig wcsPlanConfig)
    {
        return toAjax(wcsPlanConfigService.insertWcsPlanConfig(wcsPlanConfig));
    }

    /**
     * 修改分拣计划配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_plan_config:edit')")
    @Log(title = "分拣计划配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsPlanConfig wcsPlanConfig)
    {
        return toAjax(wcsPlanConfigService.updateWcsPlanConfig(wcsPlanConfig));
    }

    /**
     * 删除分拣计划配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_plan_config:remove')")
    @Log(title = "分拣计划配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsPlanConfigService.deleteWcsPlanConfigByIds(ids));
    }
}
