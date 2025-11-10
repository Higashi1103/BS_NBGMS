package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Gakusei;
import com.example.demo.entity.GakuseiExample;

@Mapper
public interface GakuseiMapper {

	// 三表联查 : 显示学生一览表画面内容
	List<Gakusei> getGakuseiKurasuTensuList(Gakusei gakusei);

	// 三表联查 : 显示学生详细画面内容
	Gakusei getGakuseiDetail(Gakusei gakusei);

	// 三表联查 : 显示学生更新画面内容
	Gakusei getGakuseiById(Gakusei gakusei);

	// 三表联查 : 学生情报更新处理
	int updateGakuseiInfo(Gakusei gakusei);

	// 查班级表 : 学生新规画面-放大镜功能(班级名模糊検索)
	List<Gakusei> searchByKurasuNamae(@Param("kurasuNamae") String kurasuNamae);

	// 学生情报删除(论理删除)
	void deleteGakuseiInfo(int gakuseiId);

	long countByExample(GakuseiExample example);

	int deleteByExample(GakuseiExample example);

	int deleteByPrimaryKey(Integer gakuseiId);

	int insert(Gakusei row);

	int insertSelective(Gakusei row);

	List<Gakusei> selectByExample(GakuseiExample example);

	Gakusei selectByPrimaryKey(Integer gakuseiId);

	int updateByExampleSelective(@Param("row") Gakusei row, @Param("example") GakuseiExample example);

	int updateByExample(@Param("row") Gakusei row, @Param("example") GakuseiExample example);

	int updateByPrimaryKeySelective(Gakusei row);

	int updateByPrimaryKey(Gakusei row);
}
