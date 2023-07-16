package com.example.roaddamage1.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.roaddamage1.DO.OrderManagerDO;
import com.example.roaddamage1.DO.UrlObjectDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface PicUrlMapper extends CoreMapper<UrlObjectDO> {

}