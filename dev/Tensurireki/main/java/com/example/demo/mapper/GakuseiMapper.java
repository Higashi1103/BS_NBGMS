package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.Gakusei;

@Mapper
public interface GakuseiMapper {
	
	//結合テスト
	@Select("SELECT gakusei_id AS gakuseiId, namae, tensu FROM gakusei WHERE gakusei_id = #{gakuseiId}")
    Gakusei getGakuseiDetail(@Param("gakuseiId") Integer gakuseiId);

    @Update("UPDATE gakusei SET tensu = #{gakusei.tensu} WHERE gakusei_id = #{gakusei.gakuseiId}")
    int updateGakuseiInfo(@Param("gakusei") Gakusei gakusei);
	
	//単体テスト
    @Select("SELECT tensu FROM gakusei WHERE gakusei_id = #{gakuseiId}")
    Integer getCurrentScore(@Param("gakuseiId") Integer gakuseiId);

    @Update("UPDATE gakusei SET tensu = #{newScore} WHERE gakusei_id = #{gakuseiId}")
    void updateScore(@Param("gakuseiId") Integer gakuseiId, @Param("newScore") Integer newScore);
	
}
