package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.ShuturyokuDTO;

@Mapper
public interface ShuturyokuMapper {
	// 获取班级列表，按 KURASU_ID DESC 排序（最新班级在前）
	List<String> selectDistinctKurasu(); 

    // 导出数据
    List<ShuturyokuDTO> selectExportData(@Param("kurasuNamae") String kurasuNamae,
                                         @Param("year") String year,
                                         @Param("fields") List<String> fields);
}
