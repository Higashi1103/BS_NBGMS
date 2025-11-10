package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Yuza;

import jakarta.servlet.http.HttpSession;

@Controller
public class GamennController {
	
	
	
	@GetMapping("/kurasu")
    public String kurasu(HttpSession session,Model model) {
		Yuza loginUser = (Yuza) session.getAttribute("currentYuza");
	    model.addAttribute("loginUser", loginUser);
        return "kurasu/kurasu"; // 对应 templates/kurasu.html
    }
	
	@GetMapping("/gakusei")
    public String gakusei(HttpSession session,Model model) {
		Yuza loginUser = (Yuza) session.getAttribute("currentYuza");
	    model.addAttribute("loginUser", loginUser);
        return "gakusei/gakusei"; // 
    }
	
	@GetMapping("/tensu")
    public String tensu(HttpSession session,Model model) {
		Yuza loginUser = (Yuza) session.getAttribute("currentYuza");
	    model.addAttribute("loginUser", loginUser);
        return "tensu/tensu"; // 
    }
	
	@GetMapping("/hiaringu")
    public String hiaringu(HttpSession session,Model model) {
		Yuza loginUser = (Yuza) session.getAttribute("currentYuza");
	    model.addAttribute("loginUser", loginUser);
        return "hiaringu/hiaringu"; // 
    }
	
	@GetMapping("/")
    public String login() {
        return "login"; // 
    }
	

	
	
	@RequestMapping(value = "/kurasushousai")
    public String kurasushousai(HttpSession session,Model model) {
		Yuza loginUser = (Yuza) session.getAttribute("currentYuza");
	    model.addAttribute("loginUser", loginUser);
        return "kurasu/kurasushousai"; // 
    }
	
	@RequestMapping(value = "/gakuseishousai")
    public String gakuseishousai(HttpSession session,Model model) {
		Yuza loginUser = (Yuza) session.getAttribute("currentYuza");
	    model.addAttribute("loginUser", loginUser);
        return "gakusei/gakuseishousai"; // 
    }
	
	@RequestMapping(value = "/hiaringushousai")
    public String hiaringushousai(HttpSession session,Model model) {
		Yuza loginUser = (Yuza) session.getAttribute("currentYuza");
	    model.addAttribute("loginUser", loginUser);
        return "hiaringu/hiaringushousai"; // 
    }
	
	@RequestMapping(value = "/tensushousai")
    public String tensushousai(HttpSession session,Model model) {
		Yuza loginUser = (Yuza) session.getAttribute("currentYuza");
	    model.addAttribute("loginUser", loginUser);
        return "tensu/tensushousai"; // 
    }
	
}
