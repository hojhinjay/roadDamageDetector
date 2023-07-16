package com.example.roaddamage1.service.Impl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.roaddamage1.DTO.OrderManagerDTO;
import com.example.roaddamage1.VO.OrderManagerVO;
import com.example.roaddamage1.mapper.OrderManagerMapper;
import com.example.roaddamage1.service.PicLoadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;


@Service
public class PicLoadServiceImpl  extends BaseServiceImpl<OrderManagerMapper, OrderManagerDTO> implements PicLoadService {


    public Integer PatchOrderMessageStatus(OrderManagerDTO OrderManagerDTO) throws Exception{
        return this.baseMapper.PatchOrderMessageStatus(OrderManagerDTO);
    }

    public Page<OrderManagerVO> getBatchInforamtion(String info) {
        Page<OrderManagerDTO> pages = new Page<OrderManagerDTO>();
        //index = (起始页-1) * pageSize
//        limit ?,?
        pages.setCurrent(1);
        pages.setSize(10);
        Page<OrderManagerVO> orderManagerVOPage = this.baseMapper.getBatchInforamtion(pages,info,1);
        return orderManagerVOPage;
    }

    @Override
    public ArrayList<OrderManagerDTO> getBatchInforamtionArrayList(String info) {
       return this.baseMapper.getBatchInforamtionArrayList(info);
    }


    /**
     * 文件上传（相对路径）
     *
     * @param files 文件
     * @return 文件路径
     */
    public  String upload(MultipartFile[] files) throws Exception {
        StringBuilder imageUrl = new StringBuilder();
        for (MultipartFile uploadFile : files) {
            String realfilename = uploadFile.getOriginalFilename(); // 上传的文件：aaa.jpg
            // 2:截图文件名的后缀
            String imgSuffix = realfilename.substring(realfilename.lastIndexOf("."));// 拿到：.jpg
            // 3:生成的唯一的文件名：
            String newFileName = UUID.randomUUID().toString() + imgSuffix;// 将aaa.jpg改写成：SD23423k324-23423ms.jpg
            // 4：日期目录
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = dateFormat.format(new Date());// 日期目录：2021/10/27
            // 5: 指定文件上传以后的目录
            File targetPath = new File("D:\\androidImage", datePath);// 生成一个最终目录:F://tmp/avatar/2021/10/27
            if (!targetPath.exists()) targetPath.mkdirs(); // 如果目录不存在：F://tmp/avatar/2021/10/2
            // 递归创建
            // 6: 指定文件上传以后的服务器的完整的文件名
            File targetFileName = new File(targetPath, newFileName);// 文件上传以后在服务器上最终文件名和目录是：
            //F://tmp/avatar/2021/10/27/SD23423k324-23423ms.jpg
            // 7: 文件上传到指定的目录
            uploadFile.transferTo(targetFileName);
            imageUrl.append(targetFileName.getPath()).append(",");

        }
        int leng = imageUrl.toString().length();
        return imageUrl.toString().substring(0,leng-1);//删去最后一个逗号
    }

}
