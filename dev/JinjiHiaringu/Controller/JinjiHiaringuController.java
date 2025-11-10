package com.example.demo.controller.hiaringu;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.hiaringu.JinjiHiaringu;
import com.example.demo.mapper.hiaringu.JinjiHiaringuMapper;
import com.example.demo.service.hiaringu.JinjiHiaringuService;

@RestController
@RequestMapping("/api/hiaringu")
public class JinjiHiaringuController {

	private final JinjiHiaringuMapper mapper;

	@Autowired
	private JinjiHiaringuService hiaringuService;

	public JinjiHiaringuController(JinjiHiaringuMapper mapper) {
		this.mapper = mapper;
	}

	@GetMapping("/all")
	public List<JinjiHiaringu> getAll() {
		return mapper.findAll();
	}

	@GetMapping("/search")
	public List<JinjiHiaringu> search(@RequestParam("keyword") String keyword) {
		return mapper.search(keyword);
	}

	@GetMapping("/all-with-student")
	public List<Map<String, Object>> getAllHiaringu() {
		return hiaringuService.getAllHiaringuWithStudentInfo();
	}

	@GetMapping("/allGakusei")
	public List<Map<String, Object>> getAllGakusei() {
		return mapper.findAllGakusei();
	}

	@PostMapping("/insert")
	public String insertHiaringu(@RequestBody JinjiHiaringu hiaringu) {
		boolean result = hiaringuService.insertHiaringu(hiaringu);
		return result ? "success" : "fail";
	}
}
