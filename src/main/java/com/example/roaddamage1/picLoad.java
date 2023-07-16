package com.example.roaddamage1;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.roaddamage1.DO.OrderManagerDO;
import com.example.roaddamage1.DTO.OrderManagerDTO;
import com.example.roaddamage1.VO.OrderManagerVO;
import com.example.roaddamage1.service.PicLoadService;
import com.example.roaddamage1.utils.JsonOut;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class picLoad {
//    https://blog.csdn.net/justry_deng/article/details/80972817/   RequestBody可与RequestParam随便结合，无论post还是get
//    针对requestbody传入的必须是string类型

    @Autowired(required = false)
    private PicLoadService picLoadService;

    @Autowired(required = false)
    private com.example.roaddamage1.service.Impl.OssServiceImpl OssServiceImpl;


    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public void post(@RequestBody(required = false) String data,HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(data);

        OrderManagerDO orderManagerDO = new Gson().fromJson(data, OrderManagerDO.class);

        OrderManagerDTO orderManagerDTO = BeanUtil.copyProperties(orderManagerDO, OrderManagerDTO.class);
        picLoadService.PatchOrderMessageStatus(orderManagerDTO);


              response.setContentType("application/text;charset=utf-8");
        try {
            JsonOut.out(response.getWriter(), data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(data);
    }

    //不带分页
    @RequestMapping(path = "/getInfo",method = RequestMethod.GET)
    public ArrayList<OrderManagerDTO> get(@RequestParam(required = false,name = "data")String data, HttpServletRequest request, HttpServletResponse response){
        ArrayList<OrderManagerDTO>  aa = picLoadService.getBatchInforamtionArrayList(data);
        return aa;
    }

    //带分页
//    https://codeleading.com/article/97431432312/
    @RequestMapping(path ={ "/get/{info}","/get"},method = RequestMethod.GET)
    public Page<OrderManagerVO> getLocation(@PathVariable(required = false) String info, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET");
//        System.out.println("get");
        Page<OrderManagerVO>  aa = picLoadService.getBatchInforamtion(info);
        return aa;

    }

    /**
     * 上传文件
     * @return Result
     */
    @PostMapping("/upload/file")
    @ResponseBody
    public String upload(@RequestParam("files") MultipartFile[] multipartFile, HttpServletRequest request){
        try {
            picLoadService.upload(multipartFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "200";
    }

    /**
     * 上传文件
     * @return Result
     */
    @PostMapping("/upload/Ossfile")
    @ResponseBody
    public String upload(@RequestParam("files") MultipartFile multipartFile, HttpServletRequest request) {
        String url = null;
        try {
            url = OssServiceImpl.uploadfile((multipartFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
    /**
     * 上传文件
     * @return Result
     */
    @PostMapping("/upload/Ossfile1")
    @ResponseBody
    public String upload1(@RequestParam("files") MultipartFile multipartFile, HttpServletRequest request) {
        String url = null;
        try {
            url = OssServiceImpl.uploadfile1((multipartFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
}
