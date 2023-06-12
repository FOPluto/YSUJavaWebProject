package com.ysu.dao;

public class InfoItem {
    public double start_time;                           // 开始时间
    public double end_time;                             // 结束时间
    public String value;                                // 变量
    public String data;                                 // 数据
    public String type;                                 // 类型
    public String error;                                // 故障/类型
    public String store_type;                           // 存储方式
    public String infomation;                           // 备注信息
    public static final int BC_RT = 0X3F3F3F3F;
    public static final int RT_BC = 0x4F4F4F4F;

    public InfoItem(double start_time, double end_time, String value, String data, String type, String error, String store_type, String infomation) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.value = value;
        this.data = data;
        this.type = type;
        this.error = error;
        this.store_type = store_type;
        this.infomation = infomation;
    }

    @Override
    public String toString() {
        return "InfoItem{" +
                "start_time=" + start_time +
                ", end_time=" + end_time +
                ", value='" + value + '\'' +
                ", data='" + data + '\'' +
                ", type='" + type + '\'' +
                ", error='" + error + '\'' +
                ", store_type='" + store_type + '\'' +
                ", infomation='" + infomation + '\'' +
                '}';
    }

    public InfoItem() {

    }
}