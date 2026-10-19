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
 * sdStatusPercent对象 sdStatusPercent
 * 
 * @author ruoyi
 * @date 2026-09-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SdStatusPercent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** bcr */
    @Excel(name = "bcr")
    private Long bcr;

    /** total */
    @Excel(name = "total")
    private Long total;

    /** successPercent */
    @Excel(name = "successPercent")
    private String successpercent;

    /** normal */
    @Excel(name = "normal")
    private Long normal;

    /** jam */
    @Excel(name = "jam")
    private Long jam;

    /** noDest */
    @Excel(name = "noDest")
    private Long nodest;

    /** chuteFull */
    @Excel(name = "chuteFull")
    private Long chutefull;

    /** chuteLock */
    @Excel(name = "chuteLock")
    private Long chutelock;

    /** invalidDest */
    @Excel(name = "invalidDest")
    private Long invaliddest;

    /** loseTrack */
    @Excel(name = "loseTrack")
    private Long losetrack;

    /** maxLoops */
    @Excel(name = "maxLoops")
    private Long maxloops;

    /** gapTollSmall */
    @Excel(name = "gapTollSmall")
    private Long gaptollsmall;

    /** parcelTooLarge */
    @Excel(name = "parcelTooLarge")
    private Long parceltoolarge;

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

    /** temp5 */
    @Excel(name = "temp5")
    private String temp5;

    /** create_date */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "create_date", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createDate;

    /** update_date */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "update_date", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date updateDate;

    /** 查询历史表标识（true查wcs_log_bak，false查wcs_log） */
    private Boolean history;

}
