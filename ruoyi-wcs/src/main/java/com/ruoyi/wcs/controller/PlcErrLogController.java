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
import com.ruoyi.wcs.domain.PlcErrLog;
import com.ruoyi.wcs.service.IPlcErrLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 历史报警Controller
 * 
 * @author ruoyi
 * @date 2021-10-16
 */
@RestController
@RequestMapping("/wcs/PLC_ERR_LOG")
public class PlcErrLogController extends BaseController
{
    @Autowired
    private IPlcErrLogService plcErrLogService;

    /**
     * 查询历史报警列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:PLC_ERR_LOG:list')")
    @GetMapping("/list")
    public TableDataInfo list(PlcErrLog plcErrLog)
    {
        startPage();
        List<PlcErrLog> list = plcErrLogService.selectPlcErrLogList(plcErrLog);
        return getDataTable(list);
    }

    /**
     * 导出历史报警列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:PLC_ERR_LOG:export')")
    @Log(title = "历史报警", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PlcErrLog plcErrLog)
    {
        List<PlcErrLog> list = plcErrLogService.selectPlcErrLogList(plcErrLog);
        ExcelUtil<PlcErrLog> util = new ExcelUtil<PlcErrLog>(PlcErrLog.class);
        return util.exportExcel(list, "历史报警数据");
    }

    /**
     * 获取历史报警详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:PLC_ERR_LOG:query')")
    @GetMapping(value = "/{errId}")
    public AjaxResult getInfo(@PathVariable("errId") String errId)
    {
        return AjaxResult.success(plcErrLogService.selectPlcErrLogById(errId));
    }

    /**
     * 新增历史报警
     */
    @PreAuthorize("@ss.hasPermi('wcs:PLC_ERR_LOG:add')")
    @Log(title = "历史报警", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PlcErrLog plcErrLog)
    {
        return toAjax(plcErrLogService.insertPlcErrLog(plcErrLog));
    }

    /**
     * 修改历史报警
     */
    @PreAuthorize("@ss.hasPermi('wcs:PLC_ERR_LOG:edit')")
    @Log(title = "历史报警", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PlcErrLog plcErrLog)
    {
        return toAjax(plcErrLogService.updatePlcErrLog(plcErrLog));
    }

    /**
     * 删除历史报警
     */
    @PreAuthorize("@ss.hasPermi('wcs:PLC_ERR_LOG:remove')")
    @Log(title = "历史报警", businessType = BusinessType.DELETE)
	@DeleteMapping("/{errIds}")
    public AjaxResult remove(@PathVariable String[] errIds)
    {
        return toAjax(plcErrLogService.deletePlcErrLogByIds(errIds));
    }
}
