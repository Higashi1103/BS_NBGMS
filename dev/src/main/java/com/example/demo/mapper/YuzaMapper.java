package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Yuza;

@Mapper
public interface YuzaMapper {
	
	int insert(Yuza row);
	
	Yuza findByIdAndPwd(Yuza yuza);
	
    List<Yuza> findAll();
    
    void deleteById(String yuzaId);
    
    int countByYuzaId(@Param("yuzaId") String yuzaId);

}