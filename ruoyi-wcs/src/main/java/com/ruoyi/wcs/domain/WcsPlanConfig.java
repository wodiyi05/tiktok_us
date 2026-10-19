package com.ruoyi.wcs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 分拣计划配置对象 wcs_plan_config
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsPlanConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 分拣计划编号 */
    @Excel(name = "分拣计划编号")
    private String planNo;

    /** 描述 */
    @Excel(name = "描述")
    private String planDesc;

    /** 计划启用 */
    @Excel(name = "计划启用")
    private String planStatus;

    /** 分拣区域 */
    @Excel(name = "分拣区域")
    private String logicalAddress;

    /** wcs地址 */
    @Excel(name = "wcs地址")
    private String wcsToPos;

    /** 分拣口启用 */
    @Excel(name = "分拣口启用")
    private String status;

    /** 分配数量 */
    @Excel(name = "分配数量")
    private Long qty;

    /** 已分配数量 */
    @Excel(name = "已分配数量")
    private Long qtyDeal;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createDate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date updateDate;

}
