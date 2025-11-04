package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Yuza;
import com.example.demo.service.YuzaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class YuzaController {

	@Autowired
	private YuzaService yuzaService;
	
//	登録入力チェック
	@RequestMapping(value = "/loginCheck")
	public String loginCheck(Yuza yuza, Model model, HttpSession session) {
		Yuza kekka = yuzaService.loginCheck(yuza);

		if (kekka != null) {
			session.setAttribute("currentYuza", kekka);
			return "redirect:/gakusei";
		}

		model.addAttribute("eraMsg", "IDまたはパスワードが間違っています。");
		return "login";
	}


//	マイページ画面
	@RequestMapping(value = "/maipeji")
	public String mypage(HttpSession session, Model model) {
		Yuza currentYuza = (Yuza) session.getAttribute("currentYuza");
		if (currentYuza == null) {
			return "redirect:/login";
		}
		model.addAttribute("currentYuza", currentYuza);
		return "maipeji";
	}

//	ログアウトバタンイベント
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
//		セッションから無効化にする
		session.invalidate();
		return "redirect:/login";
	}

//	セッションがタイムアウトしている場合の画面ジャンプ先
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

//	ユーザー一覧画面
	@RequestMapping(value = "/yuzaichiran")
	public String yuzaichiran(Model model, HttpSession session) {
		Yuza currentYuza = (Yuza) session.getAttribute("currentYuza");
		if (currentYuza == null) {
			return "redirect:/login";
		}
		List<Yuza> yuzas = yuzaService.getAllYuza();
		model.addAttribute("yuzas", yuzas);
		model.addAttribute("currentUserId", currentYuza.getYuzaId());
		return "yuzaichiran";
	}

//	ユーザー新規登録画面
	@GetMapping("/yuzaNew")
	public String toyuzaNew(HttpSession session) {
		Yuza currentYuza = (Yuza) session.getAttribute("currentYuza");
		if (currentYuza == null) {
			return "redirect:/login";
		}
		return "yuzashinki";
	}

//	ユーザー新規登録保存バタンイベント
	@PostMapping("/yuzaSave")
	public String yuzaSave(Yuza yuza) {
		// 作成時間自動セット
		yuza.setSakuseijikan(LocalDate.now().toString());
		yuzaService.insertYuza(yuza);
		// 一覧画面に戻る
		return "redirect:/yuzaichiran";
	}

//	ユーザー論理削除バタンイベント
	@PostMapping("/yuza/delete")
	public String deleteYuza(@RequestParam("yuzaId") String yuzaId, HttpSession session) {
		yuzaService.deleteYuzaById(yuzaId);
		Yuza currentYuza = (Yuza) session.getAttribute("currentYuza");
		if (currentYuza == null) {
			return "redirect:/login";
		}
		return "redirect:/yuzaichiran"; 
	}
	
	@GetMapping("/checkYuzaId")
	@ResponseBody
	public boolean checkYuzaId(@RequestParam String yuzaId) {
	    // 从数据库查询是否存在相同 ID
	    return yuzaService.existsByYuzaId(yuzaId);
	}
}
