package com.ruoyi.wcs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 路由配置对象 wcs_guide_config
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsGuideConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增id */
    private Long id;

    /** 目标位置 */
    @Excel(name = "目标位置")
    private String wcsToPos;

    /** 向导/bcr */
    @Excel(name = "向导/bcr")
    private String guide;

    /** 转向地址 */
    @Excel(name = "转向地址")
    private String plcToPos;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createDate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date updateDate;

    /** 备用1 */
    @Excel(name = "备用1")
    private String temp1;

    /** 备用2 */
    @Excel(name = "备用2")
    private String temp2;

    /** 备用3 */
    @Excel(name = "备用3")
    private String temp3;

}
