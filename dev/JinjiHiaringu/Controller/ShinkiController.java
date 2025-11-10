package com.example.demo.controller.hiaringu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dito.hiaringu.GakuseiDTO;
import com.example.demo.entity.hiaringu.JinjiHiaringu;
import com.example.demo.service.hiaringu.JinjiHiaringuService;

@Controller
@RequestMapping("/jinjihiaringu")
public class ShinkiController {
	
    @Autowired
    private JinjiHiaringuService service;
    
    //显示新增界面
    @GetMapping("/hiaringuShinki")
	public String showshinkiPage() {
	    return "hiaringu/hiaringuShinki";
	}
   
    //处理新增提交
    @PostMapping("/insert")
    @ResponseBody
    public Map<String, Object> insertHiaringu(@RequestBody JinjiHiaringu hiaringu){
    	Map<String, Object> resultMap = new HashMap<>();
    	try {
            boolean success = service.insertHiaringu(hiaringu);
            resultMap.put("success", success);
            resultMap.put("message", success ? "登録成功" : "登録失敗");
        } catch (Exception e) {
        	resultMap.put("success", false);
        	resultMap.put("message", e.getMessage());
        }
        return resultMap;
    }
    
    //搜索学生接口
    @GetMapping("/api/searchGakusei")
    @ResponseBody
    public List<GakuseiDTO> searchGakusei(@RequestParam("keyword") String keyword) {
        return service.searchByNamae(keyword);
    }
}

