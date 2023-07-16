package com.example.roaddamage1.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.roaddamage1.DO.OrderManagerDO;
import com.example.roaddamage1.DTO.OrderManagerDTO;
import com.example.roaddamage1.VO.OrderManagerVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Mapper
public interface PicLoadService extends BaseService<OrderManagerDTO>{
    public Integer PatchOrderMessageStatus(OrderManagerDTO OrderManagerDO) throws Exception;

    public Page<OrderManagerVO> getBatchInforamtion(String info);

    public ArrayList<OrderManagerDTO> getBatchInforamtionArrayList(String info);

    String upload(MultipartFile[] files)throws Exception;

}
