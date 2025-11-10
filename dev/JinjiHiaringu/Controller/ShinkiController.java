package com.example.demo.controller.hiaringu;

import java.time.LocalDateTime;
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
import com.example.demo.entity.Yuza;
import com.example.demo.entity.hiaringu.JinjiHiaringu;
import com.example.demo.service.hiaringu.JinjiHiaringuService;

import jakarta.servlet.http.HttpSession;

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
    public Map<String, Object> insertHiaringu(
            @RequestBody JinjiHiaringu hiaringu,
            HttpSession session) {
        
        Map<String, Object> resultMap = new HashMap<>();
        
        try {
            //从 session 获取登录用户
            Yuza loginUser = (Yuza) session.getAttribute("currentYuza");

            // 设置作成者信息 (根据Yuza类的实际字段调整方法名)
            hiaringu.setSakuseisha(loginUser.getYuzaNamae());
            
            // 设置作成日时
            hiaringu.setSakuseiNichiji(LocalDateTime.now());
            
            //更新者字段
            if (hiaringu.getKoushinsha() == null) {
                hiaringu.setKoushinsha(loginUser.getYuzaNamae());
                hiaringu.setKoushinNichiji(LocalDateTime.now());
            }       
            //插入
            boolean success = service.insertHiaringu(hiaringu);
            
            resultMap.put("success", success);
            resultMap.put("message", success ? "登録成功" : "登録失敗");
            
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("message", "登録に失敗しました: " + e.getMessage());
            e.printStackTrace();  //打印详细错误信息到控制台
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
