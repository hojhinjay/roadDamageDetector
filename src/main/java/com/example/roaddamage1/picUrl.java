package com.example.roaddamage1;

import com.example.roaddamage1.DO.UrlObjectDO;
import com.example.roaddamage1.service.PicUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class picUrl {
//    https://blog.csdn.net/justry_deng/article/details/80972817/   RequestBody可与RequestParam随便结合，无论post还是get
//    针对requestbody传入的必须是string类型

    @Autowired(required = false)
    private PicUrlService PicUrlService;





    @RequestMapping(path = "/picUrl",method = RequestMethod.POST)
    public Boolean picUrl(@RequestBody UrlObjectDO urlObjectDO,HttpServletRequest request,HttpServletResponse response) throws Exception {
        return PicUrlService.insertUrl(urlObjectDO);
    }



}
