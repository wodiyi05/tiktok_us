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
import com.ruoyi.wcs.domain.WcsPosConfig;
import com.ruoyi.wcs.service.IWcsPosConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出口配置Controller
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@RestController
@RequestMapping("/wcs/wcs_pos_config")
public class WcsPosConfigController extends BaseController
{
    @Autowired
    private IWcsPosConfigService wcsPosConfigService;

    /**
     * 查询出口配置列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_pos_config:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsPosConfig wcsPosConfig)
    {
        startPage();
        List<WcsPosConfig> list = wcsPosConfigService.selectWcsPosConfigList(wcsPosConfig);
        return getDataTable(list);
    }

    /**
     * 导出出口配置列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_pos_config:export')")
    @Log(title = "出口配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsPosConfig wcsPosConfig)
    {
        List<WcsPosConfig> list = wcsPosConfigService.selectWcsPosConfigList(wcsPosConfig);
        ExcelUtil<WcsPosConfig> util = new ExcelUtil<WcsPosConfig>(WcsPosConfig.class);
        return util.exportExcel(list, "出口配置数据");
    }

    /**
     * 获取出口配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_pos_config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsPosConfigService.selectWcsPosConfigById(id));
    }

    /**
     * 新增出口配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_pos_config:add')")
    @Log(title = "出口配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsPosConfig wcsPosConfig)
    {
        return toAjax(wcsPosConfigService.insertWcsPosConfig(wcsPosConfig));
    }

    /**
     * 修改出口配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_pos_config:edit')")
    @Log(title = "出口配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsPosConfig wcsPosConfig)
    {
        return toAjax(wcsPosConfigService.updateWcsPosConfig(wcsPosConfig));
    }

    /**
     * 删除出口配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_pos_config:remove')")
    @Log(title = "出口配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsPosConfigService.deleteWcsPosConfigByIds(ids));
    }
}
