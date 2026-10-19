package com.ruoyi.wcs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 参数类型配置对象 wcs_mem_type
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsMemType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 参数编号 */
    @Excel(name = "参数编号")
    private String memTypeCode;

    /** 参数名称 */
    @Excel(name = "参数名称")
    private String memTypeName;

    /** 参数描述 */
    @Excel(name = "参数描述")
    private String memTypeDesc;

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

}
