package com.example.roaddamage1.service;

import com.example.roaddamage1.DO.UrlObjectDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;


public interface PicUrlService extends BaseService<UrlObjectDO>{

    Boolean insertUrl(UrlObjectDO urlObjectDO)throws Exception;
}

