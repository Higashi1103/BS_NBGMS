package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.Gakusei;

@Mapper
public interface GakuseiMapper {
	
    Gakusei getGakuseiDetail(@Param("gakuseiId") Integer gakuseiId);

    int updateGakuseiInfo(@Param("gakusei") Gakusei gakusei);	
}
