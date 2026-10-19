package com.ruoyi.wcs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 下发任务对象 wcs_task
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增id */
    private Long id;

    /** 任务号 */
    @Excel(name = "taskNo")
    private String taskNo;

    /** 容器号 */
    @Excel(name = "barcode")
    private String barcode;

    /** 当前位置 */
    @Excel(name = "curPos")
    private String curPos;

    /** 目标位置 */
    @Excel(name = "sorting chute number")
    private String toPos;

    /** 优先级 */
    @Excel(name = "priority")
    private String priority;

    /** 任务类型 */
    @Excel(name = "taskType")
    private String taskType;

    /** 任务状态 */
    @Excel(name = "status")
    private String status;

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

    /** 图片文件夹相对路径 */
    @Excel(name = "图片路径")
    private String url;

    /**
     * 是否查询历史表标识 (非数据库字段)
     */
    private Boolean isHistory;

}
