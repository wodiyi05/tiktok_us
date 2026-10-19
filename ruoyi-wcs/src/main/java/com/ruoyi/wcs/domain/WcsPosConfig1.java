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
 * chute1对象 wcs_pos_config1
 * 
 * @author ruoyi
 * @date 2026-06-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsPosConfig1 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** chuteCode */
    @Excel(name = "chuteCode")
    private String wmsToPos;

    /** plc_pos */
    @Excel(name = "plc_pos")
    private String plcToPos;

    /** isPrinted */
    @Excel(name = "isPrinted")
    private String isprinted;

    /** stn_st */
    @Excel(name = "stn_st")
    private String stnSt;

    /** Parcels_Number */
    @Excel(name = "Parcels_Number")
    private Long parcelNum;

    /** Current_TO */
    @Excel(name = "Current_TO")
    private String curTo;

    /** Last_TO */
    @Excel(name = "Last_TO")
    private String lastTo;

    /** pos_desc1 */
    @Excel(name = "pos_desc1")
    private String posDesc;

    /** pos_desc2 */
    @Excel(name = "pos_desc2")
    private String posDesc2;

    /** Last_Parcel */
    @Excel(name = "Last_Parcel")
    private String lastParcel;

    /** stn_type */
    @Excel(name = "stn_type")
    private String stnType;

    /** led_no */
    @Excel(name = "led_no")
    private String ledNo;

    /** stn_mode */
    @Excel(name = "stn_mode")
    private String stnMode;

    /** wcs_pos */
    @Excel(name = "wcs_pos")
    private String wcsToPos;

    /** stn_no */
    @Excel(name = "stn_no")
    private String stnNo;

    /** temp1 */
    @Excel(name = "temp1")
    private String temp1;

    /** temp2 */
    @Excel(name = "temp2")
    private String temp2;

    /** temp3 */
    @Excel(name = "temp3")
    private String temp3;

    /** create_date */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "create_date", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createDate;

    /** update_date */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "update_date", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date updateDate;

    /** 存储过程返回状态码 */
    private String pCode;

    /** 存储过程返回信息 */
    private String pMsg;

    /** 打印类型：1-普通打印，2-补打 */
    private Integer printType;

}
