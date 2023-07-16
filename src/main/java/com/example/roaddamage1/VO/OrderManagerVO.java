package com.example.roaddamage1.VO;

import com.example.roaddamage1.DO.UrlObjectDO;
import lombok.Data;

@Data
public class OrderManagerVO {
    private String id;
    private String location;
    private String jingweidu;
    private int userId = 1;
    //private com.example.roaddamage1.DO.UrlObjectDO UrlObjectDO;
private String picUrl;
}
