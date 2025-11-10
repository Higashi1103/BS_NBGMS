package com.example.demo.service.hiaringu;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dito.hiaringu.GakuseiDTO;
import com.example.demo.entity.hiaringu.GakuseiKurasu;
import com.example.demo.entity.hiaringu.JinjiHiaringu;
import com.example.demo.mapper.hiaringu.JinjiHiaringuMapper;

@Service
public class JinjiHiaringuService {
	
    @Autowired
    private JinjiHiaringuMapper mapper;
    
    public void ethicalDeleteHiaringu(Integer hiaringuId) {
        int result = mapper.ethicalDelete(hiaringuId);
        if (result == 0) {
            throw new RuntimeException("ヒアリング情報が見つかりませんでした。ID: " + hiaringuId);
        }
    }
    
    @Transactional
    public boolean insertHiaringu(JinjiHiaringu hiaringu) {
        //根据学生姓名查学生ID
        GakuseiKurasu gakusei = mapper.findGakuseiByName(hiaringu.getGakuseiNamae());
        if (gakusei == null) {
            throw new RuntimeException("該当する学生が存在しません: " + hiaringu.getGakuseiNamae());
        }
        //关联ID注入
        hiaringu.setGakuseiId(gakusei.getGakuseiId());
        hiaringu.setKurasuId(gakusei.getKurasuId());
        //插入谈话记录
        int result = mapper.insertHiaringu(hiaringu);
        return result > 0;
    }
    
 // 新增：模糊搜索学生
    public List<GakuseiDTO> searchByNamae(String keyword) {
        return mapper.searchGakuseiByNamae(keyword);
    }
 //获取详细信息（含学生姓名和班级名）
    public Map<String, Object> getDetailById(Integer id) {
        return mapper.findByIdWithDetails(id);
    }
    
    public List<Map<String, Object>> getAllHiaringuWithStudentInfo() {
        return mapper.findAllWithStudentInfo();
    }

    public List<JinjiHiaringu> getAll() {
        return mapper.findAll();
    }

    public JinjiHiaringu getById(Integer id) {
        return mapper.findById(id);
    }

    public int insert(JinjiHiaringu record) {
        return mapper.insert(record);
    }

    public int update(JinjiHiaringu record) {
        return mapper.update(record);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }
}
