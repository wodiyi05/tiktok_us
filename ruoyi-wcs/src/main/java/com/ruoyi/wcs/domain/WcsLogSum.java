package com.ruoyi.wcs.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * log_sum对象 wcs_log_sum
 * 
 * @author ruoyi
 * @date 2026-09-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsLogSum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** date (改为String，接收存储过程格式化后的时间字符串) */
    @Excel(name = "date")
    private String date;

    /** 以下为新增查询参数字段 */
    private String dvcNo;      // PLC编号
    private String statType;   // 统计类型 (Hour 或 Day)
    private String his;        // 是否查询历史表 (0 或 1)

    /** total */
    @Excel(name = "total")
    private Long total;

    /** normal */
    @Excel(name = "normal")
    private Long normal;

    /** reject */
    @Excel(name = "reject")
    private Long reject;

    /** noread */
    @Excel(name = "noread")
    private Long noread;

    /** notask */
    @Excel(name = "notask")
    private Long notask;

    /** apitimeout */
    @Excel(name = "apitimeout")
    private Long apitimeout;

    /** dropfail */
    @Excel(name = "dropfail")
    private Long dropfail;

    /** chutelock */
    @Excel(name = "chutelock")
    private Long chutelock;

    /** chutefull */
    @Excel(name = "chutefull")
    private Long chutefull;

    /** multiplebarcodes */
    @Excel(name = "multiplebarcodes")
    private Long multiplebarcodes;

    /** gaptoosmall */
    @Excel(name = "gaptoosmall")
    private Long gaptoosmall;

    /** parceltoolarge */
    @Excel(name = "parceltoolarge")
    private Long parceltoolarge;

    /** parcellost */
    @Excel(name = "parcellost")
    private Long parcellost;

    /** plctimeout */
    @Excel(name = "plctimeout")
    private Long plctimeout;

    /** temp1 */
    @Excel(name = "temp1")
    private String temp1;

    /** temp2 */
    @Excel(name = "temp2")
    private String temp2;

    /** temp3 */
    @Excel(name = "temp3")
    private String temp3;

    /** temp4 */
    @Excel(name = "temp4")
    private String temp4;

}
