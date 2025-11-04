package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Yuza;
import com.example.demo.mapper.YuzaMapper;

@Service
public class YuzaService {
	@Autowired
	private YuzaMapper yuzaMapper;
	
	public Yuza loginCheck(Yuza yuza) {
		return yuzaMapper.findByIdAndPwd(yuza) ;
	}
	
	public List<Yuza> getAllYuza() {
        return yuzaMapper.findAll();
    }
	
	public void insertYuza(Yuza yuza) {
        yuzaMapper.insert(yuza);
    }
	
	public void deleteYuzaById(String yuzaId) {
	    yuzaMapper.deleteById(yuzaId);
	}
	
	public boolean existsByYuzaId(String yuzaId) {
	    return yuzaMapper.countByYuzaId(yuzaId) > 0;
	}

}
