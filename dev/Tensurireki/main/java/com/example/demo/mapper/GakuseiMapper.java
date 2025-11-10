package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.Gakusei;

@Mapper
public interface GakuseiMapper {
	
	@Select("SELECT gakusei_id AS gakuseiId, namae, tensu FROM gakusei WHERE gakusei_id = #{gakuseiId}")
    Gakusei getGakuseiTensu(@Param("gakuseiId") Integer gakuseiId);

    @Update("UPDATE gakusei SET tensu = #{gakusei.tensu} WHERE gakusei_id = #{gakusei.gakuseiId}")
    int updateGakuseiTensu(@Param("gakusei") Gakusei gakusei);
}
