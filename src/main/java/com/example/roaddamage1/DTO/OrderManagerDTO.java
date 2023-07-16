package com.example.roaddamage1.DTO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
@Data
public class OrderManagerDTO {
    private String id;
    @TableField(value = "location")
    private String location;
    @TableField(value = "jingweidu")
    private String jingweidu;
    @TableField(value = "user_id")
    private int userId = 1;
}
