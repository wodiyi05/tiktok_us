package com.ruoyi.wcs.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

/**
 * 颜色配置对象 wcs_monitor_state_color_conifg
 * 
 * @author ruoyi
 * @date 2021-10-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WcsMonitorStateColorConifg extends BaseEntity implements Comparable<WcsMonitorStateColorConifg>
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 设备状态 */
    @Excel(name = "设备状态")
    private String devState;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String devType;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String devName;


    /** rgb颜色 */
    @Excel(name = "rgb颜色")
    private String rgbColor;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 显示 */
    @Excel(name = "显示")
    private String isShow;

    /** 创建时间 */
    private Date creatime;

    /** 更新时间 */
    private Date modifytime;

    /** 排序后的双层数组 */
    private ArrayList<TreeSet<WcsMonitorStateColorConifg>> colorArr;

    public int compareTo(WcsMonitorStateColorConifg o) {
        //先按name排序
        if(Integer.valueOf(this.devState).compareTo(Integer.valueOf(o.getDevState()))>0)
            return 1;
        if(Integer.valueOf(this.devState).compareTo(Integer.valueOf(o.getDevState()))<0)
            return -1;
        return 0;
    }

}
