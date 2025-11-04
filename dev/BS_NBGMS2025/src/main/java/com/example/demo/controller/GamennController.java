package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GamennController {
	
	
	
	@GetMapping("/kurasu")
    public String kurasu() {
        return "kurasu/kurasu"; // 对应 templates/kurasu.html
    }
	
	@GetMapping("/gakusei")
    public String gakusei() {
        return "gakusei/gakusei"; // 
    }
	
	@GetMapping("/tensu")
    public String tensu() {
        return "tensu/tensu"; // 
    }
	
	@GetMapping("/hiaringu")
    public String hiaringu() {
        return "hiaringu/hiaringu"; // 
    }
	
	@GetMapping("/")
    public String login() {
        return "login"; // 
    }
	

	
	
	@RequestMapping(value = "/kurasushousai")
    public String kurasushousai() {
        return "kurasu/kurasushousai"; // 
    }
	
	@RequestMapping(value = "/gakuseishousai")
    public String gakuseishousai() {
        return "gakusei/gakuseishousai"; // 
    }
	
	@RequestMapping(value = "/hiaringushousai")
    public String hiaringushousai() {
        return "hiaringu/hiaringushousai"; // 
    }
	
	@RequestMapping(value = "/tensushousai")
    public String tensushousai() {
        return "tensu/tensushousai"; // 
    }
	
}
