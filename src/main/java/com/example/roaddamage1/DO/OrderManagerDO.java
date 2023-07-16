package com.example.roaddamage1.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("yolo")
public class OrderManagerDO extends BaseDO {
    private String id;
    @TableField(value = "location")
    private String location;
    @TableField(value = "jingweidu")
    private String jingweidu;


}
