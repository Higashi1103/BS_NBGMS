package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.TensuHenkouRireki;
import com.example.demo.service.TensuService;

@Controller
public class TensuController {

	@Autowired
	TensuService tensuService;

	// 一覧表示
	@RequestMapping(value = "/tensu")
	public String showTensuList(Model model) {
		List<TensuHenkouRireki> list = tensuService.findAll();
		model.addAttribute("tensuList", list);
		return "tensu/tensu";
	}

	// 詳細表示
	@RequestMapping(value = "/tensushousai")
	public String showTensuShousaiList(@RequestParam("rirekiId") Integer rirekiId,
			Model model) {
		TensuHenkouRireki rirekiShousai = tensuService.findByRirekiId(rirekiId);
		
		if(rirekiShousai == null) {
		    rirekiShousai = new TensuHenkouRireki(); 
		}
		
		model.addAttribute("tensuShousaiList", rirekiShousai);
		return "tensu/tensushousai";
	}

	// 編集フォーム表示
	@GetMapping(value = "/tensushousaihenko")
	public String showTensuShousaHenkoList(@RequestParam("rirekiId") Integer rirekiId,
			Model model) {
		TensuHenkouRireki rirekiHenko = tensuService.findByRirekiId(rirekiId);
		model.addAttribute("tensuShousaiHenkoList", rirekiHenko);
		return "tensu/tensushousaihenko";
	}

	// 名前検索 (Ajax)
	@GetMapping("/tensushousaihenko/searchByNamae")
	@ResponseBody
	public List<TensuHenkouRireki> searchByNamae(@RequestParam("namae") String namae) {
		return tensuService.findByNamaeContaining(namae);
	}

	// 編集内容更新
	@PostMapping("/tensushousaihenko/update")
	public String updateTensu(@ModelAttribute TensuHenkouRireki update, Model model,
			RedirectAttributes redirectAttributes) {
		tensuService.updateTensu(update);
		
		redirectAttributes.addFlashAttribute("alertType", "update");
	    redirectAttributes.addFlashAttribute("alertMsg", "更新成功");

		TensuHenkouRireki rirekiHenko = tensuService.findByRirekiId(update.getRirekiId());
		model.addAttribute("tensuShousaiHenkoList", rirekiHenko);

		return "redirect:/tensushousaihenko?rirekiId=" + update.getRirekiId();
	}

	// 削除
	@PostMapping("/tensushousaisakujyo")
	public String deleteTensu(@RequestParam("rirekiId") Integer rirekiId, Model model,
			RedirectAttributes redirectAttributes) {

		TensuHenkouRireki rirekiSakujyo = tensuService.findByRirekiId(rirekiId);

		rirekiSakujyo.setDeleteFlag(1);
		tensuService.updateDeleteFlag(rirekiSakujyo);

		tensuService.updateGakuseiScore(
				rirekiSakujyo.getGakuseiId(),
				rirekiSakujyo.getKagenTensu(),
				1);

		TensuHenkouRireki rirekiShousai = tensuService.findByRirekiId(rirekiId);
		
		model.addAttribute("tensuShousaiList", rirekiShousai);

		redirectAttributes.addFlashAttribute("alertType", "delete");
		redirectAttributes.addFlashAttribute("alertMsg", "削除成功");

		return "redirect:/tensushousai?rirekiId=" + rirekiId;
	}

	//新規作成フォームとデフォルトの日付設定
	@GetMapping(value = "/tensushinki")
	public String showTensuShinkiForm(Model model) {
		TensuHenkouRireki tensu = new TensuHenkouRireki();
		tensu.setHasseiBi(LocalDate.now().toString());
		model.addAttribute("tensuShinki", tensu);
		return "tensu/tensushinki";
	}

	// 新規作成データ保存
	@RequestMapping(value = "/tensushinki/save")
	public String saveTensuShinki(@ModelAttribute TensuHenkouRireki tensuShinki,
			RedirectAttributes redirectAttributes,
			Model model) {
		tensuService.saveNewRecord(tensuShinki);

		tensuService.updateGakuseiScore(
				tensuShinki.getGakuseiId(),
				tensuShinki.getKagenTensu(),
				0);

		TensuHenkouRireki newForm = new TensuHenkouRireki();
		newForm.setHasseiBi(LocalDate.now().toString());
		model.addAttribute("tensuShinki", newForm);

		redirectAttributes.addFlashAttribute("alertType", "new");
		redirectAttributes.addFlashAttribute("alertMsg", "新規成功");

		return "redirect:/tensushinki";
	}

}

//	@PostMapping("/tensu/updateScore")
//	public String updateTensuAfterChange(@RequestParam("gakuseiId") Integer gakuseiId,
//	                                     @RequestParam("kagenTensu") String kagenTensu,
//	                                     RedirectAttributes redirectAttrs) {
//	    return "redirect:/tensu";}

// 編集フォーム表示(拡大鏡付き)
//	@GetMapping(value = "/tensushousaihenko")
//	public String showTensuShousaHenkoList(@RequestParam("gakuseiId") Integer gakuseiId,
//	                                       @RequestParam(value = "rirekiId", required = false) Integer rirekiId,
//	                                       Model model) {
//	    TensuHenkouRireki rireki = null;
//	    if (rirekiId != null) {
//	        // 履歴IDがある場合はデータベースから取得
//	        rireki = tensuService.findByRirekiId(rirekiId);
//	    }
//	    if (rireki == null) {
//	        // 履歴が存在しない場合、新しいオブジェクトを作成し、学生IDだけセット
//	        rireki = new TensuHenkouRireki();
//	        rireki.setGakuseiId(gakuseiId);
//	    }
//	    model.addAttribute("tensuShousaiHenkoList", rireki);
//	    model.addAttribute("gakuseiId", gakuseiId);
//	    return "tensu/tensushousaihenko";
//	}

//	@PostMapping("/tensushousaisakujyo")
//	public String deleteTensu(@RequestParam("rirekiId") Integer rirekiId, RedirectAttributes redirectAttrs) {		
//		TensuHenkouRireki rireki = new TensuHenkouRireki();
//		rireki.setRirekiId(rirekiId);
//		rireki.setDeleteFlag(1);
//		redirectAttrs.addFlashAttribute("alertType", "delete");
//		redirectAttrs.addFlashAttribute("alertMsg", "削除成功");
//		tensuService.updateDeleteFlag(rireki);
//		return "redirect:/tensu";
//	}

//	redirectAttrs.addFlashAttribute("alertType", "new");
//	redirectAttrs.addFlashAttribute("alertMsg", "新規成功");
//	return "redirect:/tensushinki";

// 新規作成データ保存
//@RequestMapping(value = "/tensushinki/save")
//public String saveTensuShinki(@ModelAttribute TensuHenkouRireki tensuShinki,
//		Model model) {
//	tensuService.saveNewRecord(tensuShinki);
//
//	tensuService.updateGakuseiScore(
//			tensuShinki.getGakuseiId(),
//			tensuShinki.getKagenTensu(),
//			1);
//	
//    TensuHenkouRireki newForm = new TensuHenkouRireki();
//    newForm.setHasseiBi(LocalDate.now().toString());
//    model.addAttribute("tensuShinki", newForm);
//
//	model.addAttribute("alertType", "new");
//	model.addAttribute("alertMsg", "新規成功");
//	return "tensu/tensushinki";
//}