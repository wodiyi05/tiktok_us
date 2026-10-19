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
import com.ruoyi.wcs.domain.WcsStn;
import com.ruoyi.wcs.service.IWcsStnService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备监控Controller
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
@RestController
@RequestMapping("/wcs/WCS_STN")
public class WcsStnController extends BaseController
{
    @Autowired
    private IWcsStnService wcsStnService;

    /**
     * 查询设备监控列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:WCS_STN:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsStn wcsStn)
    {
        startPage();
        List<WcsStn> list = wcsStnService.selectWcsStnList(wcsStn);
        return getDataTable(list);
    }

    /**
     * 导出设备监控列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:WCS_STN:export')")
    @Log(title = "设备监控", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsStn wcsStn)
    {
        List<WcsStn> list = wcsStnService.selectWcsStnList(wcsStn);
        ExcelUtil<WcsStn> util = new ExcelUtil<WcsStn>(WcsStn.class);
        return util.exportExcel(list, "设备监控数据");
    }

    /**
     * 获取设备监控详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:WCS_STN:query')")
    @GetMapping(value = "/{stnId}")
    public AjaxResult getInfo(@PathVariable("stnId") String stnId)
    {
        return AjaxResult.success(wcsStnService.selectWcsStnById(stnId));
    }

    /**
     * 新增设备监控
     */
    @PreAuthorize("@ss.hasPermi('wcs:WCS_STN:add')")
    @Log(title = "设备监控", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsStn wcsStn)
    {

//        System.out.println(wcsStn.getParams().get("type"));
        return toAjax(wcsStnService.insertWcsStn(wcsStn));
    }

    /**
     * 修改设备监控
     */
    @PreAuthorize("@ss.hasPermi('wcs:WCS_STN:edit')")
    @Log(title = "设备监控", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsStn wcsStn)
    {
        return toAjax(wcsStnService.updateWcsStn(wcsStn));
    }

    /**
     * 删除设备监控
     */
    @PreAuthorize("@ss.hasPermi('wcs:WCS_STN:remove')")
    @Log(title = "设备监控", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stnIds}")
    public AjaxResult remove(@PathVariable String[] stnIds)
    {
        return toAjax(wcsStnService.deleteWcsStnByIds(stnIds));
    }
}
