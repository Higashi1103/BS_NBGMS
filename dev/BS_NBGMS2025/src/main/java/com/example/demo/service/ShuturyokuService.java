package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ShuturyokuDTO;
import com.example.demo.mapper.ShuturyokuMapper;

@Service
public class ShuturyokuService {

	@Autowired
	private ShuturyokuMapper mapper;

	public List<String> getKurasuList() {
		return mapper.selectDistinctKurasu();
	}

	public List<ShuturyokuDTO> getExportData(String kurasuNamae, String year, List<String> fields) {
		return mapper.selectExportData(kurasuNamae, year, fields);
	}

	// 最新のクラス
	public String getLatestKurasu() {
		List<String> kurasuList = getKurasuList(); // 先拿到所有班级名
	    if (kurasuList == null || kurasuList.isEmpty()) {
	        return null;
	    }

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
	    LocalDate now = LocalDate.now();

	    Optional<String> closest = kurasuList.stream()
	        .filter(k -> {
	            LocalDate date = LocalDate.parse(k + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));
	            return date.isBefore(now); // 只取早于今天的班级
	        })
	        .max(Comparator.comparing(k -> LocalDate.parse(k + "01", DateTimeFormatter.ofPattern("yyyyMMdd"))));

	    return closest.orElse(null); // 没有比当前时间早的返回 null
	}
}
