package com.ruoyi.wcs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 出口配置对象 wcs_pos_config
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsPosConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** wms地址 */
    @Excel(name = "wms地址")
    private String wmsToPos;

    /** wcs地址 */
    @Excel(name = "wcs地址")
    private String wcsToPos;

    /** plc地址 */
    @Excel(name = "plc地址")
    private String plcToPos;

    /** 描述 */
    @Excel(name = "描述")
    private String posDesc;

    /** 站台编号 */
    @Excel(name = "站台编号")
    private String stnNo;

    /** 站台模式 */
    @Excel(name = "站台模式")
    private String stnMode;

    /** 站台状态 */
    @Excel(name = "站台状态")
    private String stnSt;

    /** 站台类型 */
    @Excel(name = "站台类型")
    private String stnType;

    /** led编号 */
    @Excel(name = "led编号")
    private String ledNo;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createDate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date updateDate;

    /** 备注1 */
    @Excel(name = "备注1")
    private String temp1;

    /** 备注2 */
    @Excel(name = "备注2")
    private String temp2;

    /** 备注3 */
    @Excel(name = "备注3")
    private String temp3;

}
