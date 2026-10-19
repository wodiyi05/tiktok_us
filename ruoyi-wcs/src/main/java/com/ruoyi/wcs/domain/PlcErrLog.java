package com.ruoyi.wcs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 历史报警对象 PLC_ERR_LOG
 * 
 * @author ruoyi
 * @date 2021-10-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlcErrLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private String errId;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String stnNo;

    /** dvc_id */
    private String dvcId;

    /** 报警信息 */
    @Excel(name = "报警信息")
    private String plcErr;

    /** 报警时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "报警时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createDate;

    /** DEAL_FLAG */
    private Long dealFlag;

    /** proPoint */
    private String propoint;

    /** proSeverity */
    private String proseverity;

    /** proClassification */
    private String proclassification;

    /** UPDATE_DATE */
    private Date updateDate;

}
