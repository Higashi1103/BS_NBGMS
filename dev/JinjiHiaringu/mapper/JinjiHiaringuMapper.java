package com.example.demo.mapper.hiaringu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.example.demo.dito.hiaringu.GakuseiDTO;
import com.example.demo.entity.hiaringu.GakuseiKurasu;
import com.example.demo.entity.hiaringu.JinjiHiaringu;

@Mapper
public interface JinjiHiaringuMapper {

	 List<JinjiHiaringu> findAll();

	    List<JinjiHiaringu> search(String keyword);
	    
	    JinjiHiaringu findById(Integer id);
	    
	 //根据ID查询详细信息（含学生姓名和班级名）
	    Map<String, Object> findByIdWithDetails(@Param("id") Integer id);
	    
	    int insert(JinjiHiaringu record);
	    int update(JinjiHiaringu record);
	    int deleteById(Integer id);

	    List<Map<String, Object>> findAllWithStudentInfo();

	    //根据学生姓名查找学生ID和班级ID
	    GakuseiKurasu findGakuseiByName(String namae);
	    //插入谈话记录
	    int insertHiaringu(JinjiHiaringu hiaringu);
	    
	    int ethicalDelete(@Param("hiaringuId") Integer hiaringuId);
	    
	    //放大镜查找学生信息
	    List<Map<String, Object>> findAllGakusei();
	 // 新增：模糊搜索学生
	    List<GakuseiDTO> searchGakuseiByNamae(@Param("keyword") String keyword);
}


