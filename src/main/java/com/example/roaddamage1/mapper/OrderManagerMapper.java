package com.example.roaddamage1.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.roaddamage1.DO.OrderManagerDO;
import com.example.roaddamage1.DTO.OrderManagerDTO;
import com.example.roaddamage1.VO.OrderManagerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface OrderManagerMapper extends CoreMapper<OrderManagerDTO> {
    Integer PatchOrderMessageStatus(OrderManagerDTO orderManagerDTO);
//    Integer PatchOrderMessageStatus(@Param("id")Long id);
    Page<OrderManagerVO> getBatchInforamtion(@Param("page") Page<OrderManagerDTO> page, @Param("info") String info, @Param("user_id") int user_id);

    ArrayList<OrderManagerDTO> getBatchInforamtionArrayList(@Param("info") String info);
}