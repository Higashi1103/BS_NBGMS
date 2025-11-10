package com.example.demo.controller.hiaringu;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.hiaringu.JinjiHiaringu;
import com.example.demo.service.hiaringu.JinjiHiaringuService;

@Controller
@RequestMapping("/hiaringu")
public class SyousaiController {
    @Autowired
    private JinjiHiaringuService hiaringuService; 

    @GetMapping("/hiaringuSyousai")
   public String showHiaringuSyousai(@RequestParam("id") int hiaringuId, Model model) {
        //获取学生姓名和班级名
        Map<String, Object> hiaringu = hiaringuService.getDetailById(hiaringuId);
        model.addAttribute("hiaringu", hiaringu);
        return "hiaringu/hiaringuSyousai";
    }
    
    @PostMapping("/ethicalDelete")
    @ResponseBody
    public Map<String, Object> ethicalDelete(@RequestParam("id") Integer hiaringuId) {
        Map<String, Object> result = new HashMap<>();
        try {
        	hiaringuService.ethicalDeleteHiaringu(hiaringuId);
            result.put("success", true);
            result.put("message", "削除が完了しました");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }
    
    @GetMapping("/hiaringuKoushin")
    public String showHiaringuKoushin(@RequestParam("id") Integer hiaringuId, Model model) {
        //获取学生姓名和班级名
        Map<String, Object> hiaringu = hiaringuService.getDetailById(hiaringuId);
        model.addAttribute("hiaringu", hiaringu);
        return "hiaringu/hiaringuKoushin";
    }

   
    @GetMapping("/update")
    public String updateHiaringuSyousai(@RequestParam("id") Integer hiaringuId, Model model) {
        //获取学生姓名和班级名
        Map<String, Object> hiaringu = hiaringuService.getDetailById(hiaringuId);
        if (hiaringu == null) {
            model.addAttribute("errorMessage", "該当データが存在しません。");
            return "error";
        }
        model.addAttribute("hiaringu", hiaringu);
        return "hiaringu/hiaringuKoushin";
    }
    
    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> updateHiaringu(@RequestBody JinjiHiaringu hiaringu){
    	Map<String, Object> result = new HashMap<>();
    	try {
            int rows = hiaringuService.update(hiaringu);
            result.put("success", rows > 0);
            result.put("message", rows > 0 ? "更新成功" : "更新失敗");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }
}
