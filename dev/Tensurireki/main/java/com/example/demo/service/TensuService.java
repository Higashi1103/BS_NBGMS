package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Gakusei;
import com.example.demo.entity.TensuHenkouRireki;
import com.example.demo.mapper.GakuseiMapper;
import com.example.demo.mapper.TensuHenkouRirekiMapper;

@Service
public class TensuService {

	@Autowired
	TensuHenkouRirekiMapper tensuHenkouRirekiMapper;

	@Autowired
	GakuseiMapper gakuseiMapper;

//	点数変更メソード
	public void updateGakuseiScore(Integer gakuseiId, String kagenTensuStr, Integer isDelete) {
		Gakusei dbGakusei = gakuseiMapper.getGakuseiTensu(gakuseiId);
		int currentScore = dbGakusei.getTensu();
		int delta = Integer.parseInt(kagenTensuStr); 

		int newScore;
		if (isDelete == 1) {
			newScore = currentScore + Math.abs(delta);
		} else {
			newScore = currentScore + delta;
		}

		dbGakusei.setTensu(newScore);
		gakuseiMapper.updateGakuseiTensu(dbGakusei);
	}

	public List<TensuHenkouRireki> findAll() {
		return tensuHenkouRirekiMapper.findAll();
	}

	public List<TensuHenkouRireki> findByGakuseiId(Integer gakuseiId) {
		return tensuHenkouRirekiMapper.findByGakuseiId(gakuseiId);
	}

	//	制限あり、学生IDと名前のみ
	public List<TensuHenkouRireki> findByNamaeContaining(String namae) {
		return tensuHenkouRirekiMapper.findByNamaeContaining(namae);
	}

	public TensuHenkouRireki findByRirekiId(Integer rirekiId) {
		return tensuHenkouRirekiMapper.findByRirekiId(rirekiId);
	}

	@Transactional
	public void updateTensu(TensuHenkouRireki rireki) {
		if (rireki.getNewGakuseiId() == null) {
			rireki.setNewGakuseiId(rireki.getGakuseiId());
		}
		tensuHenkouRirekiMapper.updateTensu(rireki);
	}

	public void updateDeleteFlag(TensuHenkouRireki rireki) {
		tensuHenkouRirekiMapper.updateDeleteFlag(rireki);
	}

	public void saveNewRecord(TensuHenkouRireki rireki) {
		tensuHenkouRirekiMapper.insertTensuRecord(rireki);
	}
}

////新規のみ
//public void updateGakuseiScore(Integer gakuseiId, String kagenTensuStr,Integer isDelete) {
//
//	Gakusei gakusei = new Gakusei();
//	gakusei.setGakuseiId(gakuseiId);
//	Gakusei dbGakusei = gakuseiMapper.getGakuseiDetail(gakuseiId);
//
//	int newScore = dbGakusei.getTensu() + Integer.parseInt(kagenTensuStr);
//
//	dbGakusei.setTensu(newScore);
//    gakuseiMapper.updateGakuseiInfo(dbGakusei);
//}

////単体テスト
//public void updateGakuseiScore(Integer gakuseiId, String kagenTensuStr) {
//
//	Integer currentScore = tensuMapper.getCurrentScore(gakuseiId);
//    int delta = Integer.parseInt(kagenTensuStr);
//    int newScore = currentScore + delta;
//    
//    tensuMapper.updateScore(gakuseiId, newScore);
//    
//    System.out.println("分数更新成功 -> 学生ID: " + gakuseiId + ", 原分数: " + currentScore + ", 变化: " + delta + ", 新分数: " + newScore);
//}
