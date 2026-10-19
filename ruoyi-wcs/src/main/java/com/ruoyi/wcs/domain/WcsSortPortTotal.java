package com.ruoyi.wcs.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分拣口统计对象 wcs_sort_port_total (按小时统计改造)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsSortPortTotal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "DATES")
    private String dates;

    @Excel(name = "DVCNO")
    private String dvcNo;

    @Excel(name = "CHUTE")
    private String chute;

    @Excel(name = "TOTAL")
    private Long total;

    @Excel(name = "00:00")
    private Long hour0;
    @Excel(name = "01:00")
    private Long hour1;
    @Excel(name = "02:00")
    private Long hour2;
    @Excel(name = "03:00")
    private Long hour3;
    @Excel(name = "04:00")
    private Long hour4;
    @Excel(name = "05:00")
    private Long hour5;
    @Excel(name = "06:00")
    private Long hour6;
    @Excel(name = "07:00")
    private Long hour7;
    @Excel(name = "08:00")
    private Long hour8;
    @Excel(name = "09:00")
    private Long hour9;
    @Excel(name = "10:00")
    private Long hour10;
    @Excel(name = "11:00")
    private Long hour11;
    @Excel(name = "12:00")
    private Long hour12;
    @Excel(name = "13:00")
    private Long hour13;
    @Excel(name = "14:00")
    private Long hour14;
    @Excel(name = "15:00")
    private Long hour15;
    @Excel(name = "16:00")
    private Long hour16;
    @Excel(name = "17:00")
    private Long hour17;
    @Excel(name = "18:00")
    private Long hour18;
    @Excel(name = "19:00")
    private Long hour19;
    @Excel(name = "20:00")
    private Long hour20;
    @Excel(name = "21:00")
    private Long hour21;
    @Excel(name = "22:00")
    private Long hour22;
    @Excel(name = "23:00")
    private Long hour23;

    /** 是否查询历史表标志位 (wcs_log_bak) */
    private Boolean isBak;
}