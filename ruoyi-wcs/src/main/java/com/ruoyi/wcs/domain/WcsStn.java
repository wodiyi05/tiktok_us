package com.ruoyi.wcs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 设备监控对象 WCS_STN
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsStn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private String stnId;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String stnNo;

    /** stn_tp */
    @Excel(name = "stn_tp")
    private String stnTp;

    /** 设备状态 */
    @Excel(name = "设备状态")
    private String stnSt;

    /** STN_LOGIC_NO */
    private String stnLogicNo;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createDate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date updateDate;

    /** 备注 */
    @Excel(name = "备注")
    private String comments;

    /** PLC编号 */
    @Excel(name = "PLC编号")
    private String dvcId;

    /** FLEX_PEN_COLOR */
    private String flexPenColor;

    /** FLEX_PATH */
    private String flexPath;

    /** TIME_HOUR */
    private String timeHour;

    /** TIME_SECOND */
    private String timeSecond;

    /** 报警设备类型 */
    @Excel(name = "报警设备类型")
    private String errTp;

    /** 报警 */
    @Excel(name = "报警")
    private String plcErr;

    /** STN_NO_BCR */
    private String stnNoBcr;

    /** 历史报警 */
    @Excel(name = "历史报警")
    private String plcErrOld;

    /** 线体名称 */
    @Excel(name = "线体名称")
    private String controlName;

    /** 启动 */
    @Excel(name = "启动")
    private String controlStart;

    /** 停止 */
    @Excel(name = "停止")
    private String controlStop;

    /** 复位 */
    @Excel(name = "复位")
    private String controlReset;

}
