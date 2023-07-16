package com.example.roaddamage1.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("urlObject")
public class UrlObjectDO {
    @TableField("user_id")
    private int userId;
    @TableField("pic_url")
    private String picUrl;

    public UrlObjectDO(int userId, String picUrl) {
        this.userId = userId;
        this.picUrl = picUrl;
    }
}
