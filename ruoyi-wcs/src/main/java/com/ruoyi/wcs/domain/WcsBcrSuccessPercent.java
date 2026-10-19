package com.ruoyi.wcs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 扫码率对象 wcs_bcr_success_percent
 *
 * @author ruoyi
 * @date 2021-07-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsBcrSuccessPercent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 扫码器 */
    @Excel(name = "扫码器")
    private String bcr;

    /** 总数 */
    @Excel(name = "总数")
    private Long total;

    /** noread */
    @Excel(name = "noread")
    private Long noread;

    /** 000 */
//    @Excel(name = "000")
    private Long bar000;

    /** 777 */
//    @Excel(name = "777")
    private Long bar777;

        /** 空条码 */
//    @Excel(name = "空")
    private Long barEmpty;


    /** 扫码成功 */
    @Excel(name = "扫码成功")
    private Long barSuccess;

    /** 扫码成功率 */
    @Excel(name = "扫码成功率")
    private String successPercent;

    /** 000比率 */
//    @Excel(name = "000比率")
    private String bar000Percent;

    /** 777比率 */
//    @Excel(name = "777比率")
    private String bar777Percent;

    /** 空条码 */
//    @Excel(name = "空比率")
    private String barEmptyPercent;

    /** 是否查询历史表标志位 (wcs_log_bak) */
    private Boolean isBak;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTime;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifytime;


}