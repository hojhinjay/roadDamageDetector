package com.example.roaddamage1.service.Impl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.roaddamage1.DO.UrlObjectDO;
import com.example.roaddamage1.mapper.PicUrlMapper;
import com.example.roaddamage1.service.PicUrlService;
import org.springframework.stereotype.Service;



@Service
public class PicUrlServiceImpl extends BaseServiceImpl<PicUrlMapper, UrlObjectDO> implements PicUrlService {


    @Override
    public Boolean insertUrl(UrlObjectDO UrlObjectDO) throws Exception {
        return this.save(UrlObjectDO);
    }

}
