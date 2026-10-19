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
import com.ruoyi.wcs.domain.WcsMemConfig;
import com.ruoyi.wcs.service.IWcsMemConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * wcs参数配置Controller
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@RestController
@RequestMapping("/wcs/wcs_mem_config")
public class WcsMemConfigController extends BaseController
{
    @Autowired
    private IWcsMemConfigService wcsMemConfigService;

    /**
     * 查询wcs参数配置列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_mem_config:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsMemConfig wcsMemConfig)
    {
        startPage();
        List<WcsMemConfig> list = wcsMemConfigService.selectWcsMemConfigList(wcsMemConfig);
        return getDataTable(list);
    }

    /**
     * 导出wcs参数配置列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_mem_config:export')")
    @Log(title = "wcs参数配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsMemConfig wcsMemConfig)
    {
        List<WcsMemConfig> list = wcsMemConfigService.selectWcsMemConfigList(wcsMemConfig);
        ExcelUtil<WcsMemConfig> util = new ExcelUtil<WcsMemConfig>(WcsMemConfig.class);
        return util.exportExcel(list, "wcs参数配置数据");
    }

    /**
     * 获取wcs参数配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_mem_config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsMemConfigService.selectWcsMemConfigById(id));
    }

    /**
     * 新增wcs参数配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_mem_config:add')")
    @Log(title = "wcs参数配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsMemConfig wcsMemConfig)
    {
        return toAjax(wcsMemConfigService.insertWcsMemConfig(wcsMemConfig));
    }

    /**
     * 修改wcs参数配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_mem_config:edit')")
    @Log(title = "wcs参数配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsMemConfig wcsMemConfig)
    {
        return toAjax(wcsMemConfigService.updateWcsMemConfig(wcsMemConfig));
    }

    /**
     * 删除wcs参数配置
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_mem_config:remove')")
    @Log(title = "wcs参数配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsMemConfigService.deleteWcsMemConfigByIds(ids));
    }

    /**
     * 离线上传调用存储过程
     */
    @Log(title = "wcs参数配置", businessType = BusinessType.OTHER)
    @PostMapping("/offlineUpload")
    public AjaxResult offlineUpload(@RequestBody java.util.Map<String, String> params)
    {
        // 获取前端传来的输入参数（如 "0"）
        String inputParam = params.get("inputParam");

        // 构造 Map 用于传递 IN 参数并接收 OUT 参数
        java.util.Map<String, Object> paramMap = new java.util.HashMap<>();
        paramMap.put("p_input", inputParam);
        // 初始化输出参数，MyBatis 执行完后会将结果覆盖这两个 key
        paramMap.put("p_code", "");
        paramMap.put("p_msg", "");

        // 调用 Service
        wcsMemConfigService.executeOfflineUpload(paramMap);

        // 返回包含 p_code 和 p_msg 的 map 给前端
        return AjaxResult.success(paramMap);
    }
}
