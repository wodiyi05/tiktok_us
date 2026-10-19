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
import com.ruoyi.wcs.domain.WcsPosConfig1;
import com.ruoyi.wcs.service.IWcsPosConfig1Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * chute1Controller
 * 
 * @author ruoyi
 * @date 2026-06-16
 */
@RestController
@RequestMapping("/wcs/chute1")
public class WcsPosConfig1Controller extends BaseController
{
    @Autowired
    private IWcsPosConfig1Service wcsPosConfig1Service;

    /**
     * 查询chute1列表
     */
//    @PreAuthorize("@ss.hasPermi('wcs:chute1:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsPosConfig1 wcsPosConfig1)
    {
        startPage();
        List<WcsPosConfig1> list = wcsPosConfig1Service.selectWcsPosConfig1List(wcsPosConfig1);
        return getDataTable(list);
    }

    /**
     * 导出chute1列表
     */
//    @PreAuthorize("@ss.hasPermi('wcs:chute1:export')")
    @Log(title = "chute1", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsPosConfig1 wcsPosConfig1)
    {
        List<WcsPosConfig1> list = wcsPosConfig1Service.selectWcsPosConfig1List(wcsPosConfig1);
        ExcelUtil<WcsPosConfig1> util = new ExcelUtil<WcsPosConfig1>(WcsPosConfig1.class);
        return util.exportExcel(list, "chute1数据");
    }

    /**
     * 获取chute1详细信息
     */
//    @PreAuthorize("@ss.hasPermi('wcs:chute1:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsPosConfig1Service.selectWcsPosConfig1ById(id));
    }

    /**
     * 新增chute1
     */
//    @PreAuthorize("@ss.hasPermi('wcs:chute1:add')")
    @Log(title = "chute1", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsPosConfig1 wcsPosConfig1)
    {
        return toAjax(wcsPosConfig1Service.insertWcsPosConfig1(wcsPosConfig1));
    }

    /**
     * 修改chute1
     */
//    @PreAuthorize("@ss.hasPermi('wcs:chute1:edit')")
    @Log(title = "chute1", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsPosConfig1 wcsPosConfig1)
    {
//        return toAjax(wcsPosConfig1Service.updateWcsPosConfig1(wcsPosConfig1));

        // 1. 调用 Service 执行存储过程
        wcsPosConfig1Service.updateWcsPosConfig1(wcsPosConfig1);

        // 2. 存储过程执行完后，MyBatis会自动把出参塞回到传入的 wcsPosConfig1 对象中
        String code = wcsPosConfig1.getPCode();
        String msg = wcsPosConfig1.getPMsg();

        // 3. 根据存储过程的业务定义来判断成功失败 (假设 "200" 或 "0" 代表成功)
        if ("200".equals(code) || "0".equals(code)) {
            // 使用 AjaxResult.success()，前端 response.msg 就能直接拿到这个值
            return AjaxResult.success(msg);
        } else {
            return AjaxResult.error(msg != null ? msg : "存储过程执行失败");
        }
    }

    /**
     * 删除chute1
     */
//    @PreAuthorize("@ss.hasPermi('wcs:chute1:remove')")
    @Log(title = "chute1", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsPosConfig1Service.deleteWcsPosConfig1ByIds(ids));
    }
}
