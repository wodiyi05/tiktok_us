package com.ruoyi.wcs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * wcs日志对象 wcs_log
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 作业名称 */
    @Excel(name = "workName")
    private String workName;

    /** 容器号 */
    @Excel(name = "barcode")
    private String barcode;

    /** 目标位置 */
    @Excel(name = "toPos")
    private String toPos;

    /** 当前位置 */
    @Excel(name = "curPos")
    private String curPos;

    /** bcr编号 */
    @Excel(name = "bcrNo")
    private String bcrNo;

    /** 分拣状态 */
    @Excel(name = "sortStatus")
    private String sortStatus;

    /** 执行代码 */
    @Excel(name = "workCode")
    private String workCode;

    /** 执行信息 */
    @Excel(name = "workMsg")
    private String workMsg;

    /** 执行函数 */
    @Excel(name = "workProc")
    private String workProc;

    /** 执行时间 */
    @Excel(name = "workSec")
    private Long workSec;

    /** dvc编号 */
    @Excel(name = "dvcNo")
    private String dvcNo;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "createDate", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createDate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "updateDate", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date updateDate;

    /** 备注1 */
    @Excel(name = "remark1")
    private String temp1;

    /** 备注2 */
    @Excel(name = "remark2")
    private String temp2;

    /** 备注3 */
    @Excel(name = "remark3")
    private String temp3;

    /** 备注4 */
    @Excel(name = "remark4")
    private String temp4;

    /** 备注5 */
    @Excel(name = "remark5")
    private String temp5;

    /** 任务号 */
    @Excel(name = "wcsTaskNum")
    private String wcsTaskNum;

    /** 状态 */
    @Excel(name = "status")
    private String status;

    /** 供包状态 */
    @Excel(name = "InductionStatus")
    private String InductionStatus;

    // ============= 新增字段 =============
    /**
     * 是否查询历史表标识 (非数据库字段)
     */
    private Boolean isHistory;

}
