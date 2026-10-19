package com.ruoyi.wcs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 分拣状态统计对象 wcs_sorted_status_percent
 *
 * @author ruoyi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsSortedStatusPercent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 扫码器 */
    @Excel(name = "BCR")
    private String bcr;

    /** 总数 */
    @Excel(name = "Total")
    private Long total;

    /** 成功率 */
    @Excel(name = "Success Percent")
    private String successPercent;

    /** 0 正常 */
    @Excel(name = "Normal")
    private Long normal;

    /** 1 没读到条码 */
    @Excel(name = "No Barcode")
    private Long noBarcode;

    /** 2 没读码器信息 */
    @Excel(name = "No Scanner")
    private Long noScanner;

    /** 3 多条码 */
    @Excel(name = "Multi Barcode")
    private Long multiBarcode;

    /** 4 未反馈目的地 */
    @Excel(name = "No Dest")
    private Long noDest;

    /** 5 出口满格 */
    @Excel(name = "Chute Full")
    private Long chuteFull;

    /** 6 出口故障或软关闭 */
    @Excel(name = "Chute Fault")
    private Long chuteFault;

    /** 7 目的地地址无效 */
    @Excel(name = "Invalid Dest")
    private Long invalidDest;

    /** 8 跟踪丢失 */
    @Excel(name = "Track Failed")
    private Long trackFailed;

    /** 9 目的地反馈延迟 */
    @Excel(name = "Dest Delay")
    private Long destDelay;

    /** 10 间距过小 */
    @Excel(name = "Distance Error 0")
    private Long distanceError0;

    /** 11 同周期跟踪丢失 */
    @Excel(name = "Distance Error 1")
    private Long distanceError1;

    /** 12 窗口内多组数据跟踪丢失 */
    @Excel(name = "Distance Error 2")
    private Long distanceError2;

    /** 13 跟踪数据未传出成功 */
    @Excel(name = "Distance Error 3")
    private Long distanceError3;

    /** 14 跟踪数据未传入成功 */
    @Excel(name = "Distance Error 4")
    private Long distanceError4;

    /** 15 跟踪数据冲突被覆盖 */
    @Excel(name = "Distance Error 5")
    private Long distanceError5;

    /** 16 占位不存在被抛弃 */
    @Excel(name = "Distance Error 6")
    private Long distanceError6;

    /** 17 数据被手动清除 */
    @Excel(name = "Missed Data")
    private Long missedData;

    /** 18 跟踪丢失 */
    @Excel(name = "Tracking Failed")
    private Long trackingFailed;

    /** 19 强制分拣 */
    @Excel(name = "Force Sorting")
    private Long forceSorting;

    /** 20 包裹检测异常 */
    @Excel(name = "Measure Fault")
    private Long measureFault;

    /** 21 包裹长度突变 */
    @Excel(name = "Parcel Length Fault")
    private Long parcelLengthFault;

    /** 22 包裹长度超长 */
    @Excel(name = "Exceed Max Length")
    private Long exceedMaxLength;

    /** 23 缓存道出箱完成 */
    @Excel(name = "Tote Exit Success")
    private Long toteExitSuccess;

    /** 99 其他 */
    @Excel(name = "Other")
    private Long other;

    /** 兜底未知状态 */
    @Excel(name = "Unknown State")
    private Long unknownState;

    /** 备用1 */
    private String temp1;

    /** 备用2 */
    private String temp2;

    /** 备用3 */
    private String temp3;

    /** 备用4 */
    private String temp4;

    /** 是否查询历史表标志位 (wcs_log_bak) */
    private Boolean isBak;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "Create Date", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createDate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Excel(name = "Update Date", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date updateDate;

}