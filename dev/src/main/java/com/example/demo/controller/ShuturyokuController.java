package com.example.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.ShuturyokuDTO;
import com.example.demo.service.ShuturyokuService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ShuturyokuController {

	private final ShuturyokuService service;

	public ShuturyokuController(ShuturyokuService service) {
		this.service = service;
	}

//出力画面
	@GetMapping("/shuturyoku")
	public String showExportPage(Model model) {
		  // 从数据库取出所有班级
	    List<String> kurasuList = service.getKurasuList();

	    // 取出比当前时间早且最近的班级
	    String latestKurasu = service.getLatestKurasu();

	    // 如果没有符合条件的班级，就默认第一个
	    if (latestKurasu == null && !kurasuList.isEmpty()) {
	        latestKurasu = kurasuList.get(0);
	    }

	    // 传给前端
	    model.addAttribute("kurasuList", kurasuList);
	    model.addAttribute("defaultKurasu", latestKurasu);

	    return "shuturyoku";
	}

//出力バタンイベント
	@PostMapping("/export")
	public void exportExcel(@RequestParam(required = false) String kurasuNamae,
			@RequestParam(required = false) String year,
			@RequestParam List<String> fields,
			HttpServletResponse response) throws Exception {
//クラス条件
		kurasuNamae = (kurasuNamae == null || kurasuNamae.isBlank()) ? null : kurasuNamae.trim();
		year = (year == null || year.isBlank()) ? null : year.trim();

		List<ShuturyokuDTO> data = service.getExportData(kurasuNamae, year, fields);

		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Export");

			Map<String, String> headerMap = new HashMap<>();
			headerMap.put("kurasuId", "クラスID");
			headerMap.put("kurasuNamae", "クラス名前");
			headerMap.put("kurasuKamoku", "クラス科目");
			headerMap.put("kurasuMemo", "クラスメモ");
			headerMap.put("tantoSensei", "担当先生");
			headerMap.put("memo", "クラスメモ");
			headerMap.put("gakuseiId", "学生ID");
			headerMap.put("namae", "学生名前");
			headerMap.put("seibetsu", "性別");
			headerMap.put("seinengappi", "生年月日");
			headerMap.put("saishuGakureki", "最終学歴");
			headerMap.put("gogakuryoku", "語学力");
			headerMap.put("tensu", "点数");
			headerMap.put("hyouka", "評価");
			headerMap.put("sonota", "その他");
			headerMap.put("rirekiId", "点数履歴ID");
			headerMap.put("kagenTensu", "加減点数");
			headerMap.put("kagenRiyu", "加減理由");
			headerMap.put("hasseiBi", "加減発生日");
			headerMap.put("tensuBiko", "点数備考");
			headerMap.put("hiaringuId", "ヒアリングID");
			headerMap.put("hiaringuTantousya", "担当者");
			headerMap.put("hiaringuNichiji", "発生日時");
			headerMap.put("hiaringuJikan", "継続時間");
			headerMap.put("hiaringuBasyo", "発生場所");
			headerMap.put("hiaringuGenin", "ヒアリング原因");
			headerMap.put("hiaringuNaiyou", "ヒアリング内容");
			headerMap.put("hiaringuBiko", "ヒアリング備考");

			CellStyle classHeaderStyle = workbook.createCellStyle();
			CellStyle studentHeaderStyle = workbook.createCellStyle();
			CellStyle pointHeaderStyle = workbook.createCellStyle();
			CellStyle hearingHeaderStyle = workbook.createCellStyle();
			
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLACK.getIndex());
			
			for (CellStyle style : Arrays.asList(classHeaderStyle, studentHeaderStyle, pointHeaderStyle, hearingHeaderStyle)) {
			    style.setFont(headerFont);
			    style.setAlignment(HorizontalAlignment.CENTER);
			    style.setVerticalAlignment(VerticalAlignment.CENTER);
			    style.setBorderTop(BorderStyle.THIN);
			    style.setBorderBottom(BorderStyle.THIN);
			    style.setBorderLeft(BorderStyle.THIN);
			    style.setBorderRight(BorderStyle.THIN);
			    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			}
			
			
			classHeaderStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			studentHeaderStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			pointHeaderStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
			hearingHeaderStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());



			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			cellStyle.setBorderTop(BorderStyle.THIN);
			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);

			Row headerRow = sheet.createRow(0);
			for (int j = 0; j < fields.size(); j++) {
				String field = fields.get(j);
			    Cell cell = headerRow.createCell(j);
			    cell.setCellValue(headerMap.getOrDefault(field, field));

			    // 根据字段分组设定颜色
			    if (Arrays.asList("kurasuId", "kurasuNamae", "kurasuKamoku", "kurasuMemo", "tantoSensei").contains(field)) {
			        cell.setCellStyle(classHeaderStyle);
			    } else if (Arrays.asList("gakuseiId", "namae", "seibetsu", "seinengappi", "saishuGakureki", "gogakuryoku", "tensu", "hyouka", "sonota").contains(field)) {
			        cell.setCellStyle(studentHeaderStyle);
			    } else if (Arrays.asList("rirekiId", "kagenTensu", "kagenRiyu", "hasseiBi", "tensuBiko").contains(field)) {
			        cell.setCellStyle(pointHeaderStyle);
			    } else if (Arrays.asList("hiaringuId", "hiaringuTantousya", "hiaringuNichiji", "hiaringuJikan", "hiaringuBasyo", "hiaringuGenin", "hiaringuNaiyou", "hiaringuBiko").contains(field)) {
			        cell.setCellStyle(hearingHeaderStyle);
			    }
			}

			for (int j = 0; j < fields.size(); j++) {
			    sheet.autoSizeColumn(j);
			    int currentWidth = sheet.getColumnWidth(j);
			    sheet.setColumnWidth(j, (int) (currentWidth * 1.5));
			}

			for (int i = 0; i < data.size(); i++) {
				Row row = sheet.createRow(i + 1);
				ShuturyokuDTO dto = data.get(i);

				for (int j = 0; j < fields.size(); j++) {
					Cell cell = row.createCell(j);

					switch (fields.get(j)) {
					case "kurasuId":
						cell.setCellValue(dto.getKurasuId() != null ? dto.getKurasuId() : 0);
						break;
					case "kurasuNamae":
						cell.setCellValue(dto.getKurasuNamae() != null ? dto.getKurasuNamae() : "");
						break;
					case "kurasuKamoku":
						cell.setCellValue(dto.getKurasuKamoku() != null ? dto.getKurasuKamoku() : "");
						break;
					case "tantoSensei":
						cell.setCellValue(dto.getTantoSensei() != null ? dto.getTantoSensei() : "");
						break;
					case "memo":
					case "kurasuMemo":
						cell.setCellValue(dto.getMemo() != null ? dto.getMemo() : "");
						break;
					case "gakuseiId":
						cell.setCellValue(dto.getGakuseiId() != null ? dto.getGakuseiId() : 0);
						break;
					case "namae":
						cell.setCellValue(dto.getNamae() != null ? dto.getNamae() : "");
						break;
					case "seibetsu":
						cell.setCellValue(dto.getSeibetsu() != null ? dto.getSeibetsu() : "");
						break;
					case "seinengappi":
						cell.setCellValue(dto.getSeinengappi() != null ? dto.getSeinengappi() : "");
						break;
					case "saishuGakureki":
						cell.setCellValue(dto.getSaishuGakureki() != null ? dto.getSaishuGakureki() : "");
						break;
					case "gogakuryoku":
						cell.setCellValue(dto.getGogakuryoku() != null ? dto.getGogakuryoku() : "");
						break;
					case "tensu":
						cell.setCellValue(dto.getTensu() != null ? dto.getTensu() : 0);
						break;
					case "hyouka":
						cell.setCellValue(dto.getHyouka() != null ? dto.getHyouka() : "");
						break;
					case "sonota":
						cell.setCellValue(dto.getSonota() != null ? dto.getSonota() : "");
						break;
					case "rirekiId":
						cell.setCellValue(dto.getRirekiId() != null ? dto.getRirekiId() : 0);
						break;
					case "kagenTensu":
						cell.setCellValue(dto.getKagenTensu() != null ? dto.getKagenTensu() : "");
						break;
					case "gutaiRiyu":
						cell.setCellValue(dto.getGutaiRiyu() != null ? dto.getGutaiRiyu() : "");
						break;
					case "hasseiBi":
						cell.setCellValue(dto.getHasseiBi() != null ? dto.getHasseiBi() : "");
						break;
					case "tensuBiko":
						cell.setCellValue(dto.getTensuBiko() != null ? dto.getTensuBiko() : "");
						break;
					case "hiaringuId":
						cell.setCellValue(dto.getHiaringuId() != null ? dto.getHiaringuId() : 0);
						break;
					case "hiaringuTantousya":
						cell.setCellValue(dto.getHiaringuTantousya() != null ? dto.getHiaringuTantousya() : "");
						break;
					case "hiaringuNichiji":
						cell.setCellValue(dto.getHiaringuNichiji() != null ? dto.getHiaringuNichiji().toString() : "");
						break;
					case "hiaringuJikan":
						cell.setCellValue(dto.getHiaringuJikan() != null ? dto.getHiaringuJikan() : "");
						break;
					case "hiaringuBasyo":
						cell.setCellValue(dto.getHiaringuBasyo() != null ? dto.getHiaringuBasyo() : "");
						break;
					case "hiaringuGenin":
						cell.setCellValue(dto.getHiaringuGenin() != null ? dto.getHiaringuGenin() : "");
						break;
					case "hiaringuNaiyou":
						cell.setCellValue(dto.getHiaringuNaiyou() != null ? dto.getHiaringuNaiyou() : "");
						break;
					case "hiaringuBiko":
						cell.setCellValue(dto.getHiaringuBiko() != null ? dto.getHiaringuBiko() : "");
						break;
					default:
						cell.setCellValue("");
					}
					cell.setCellStyle(cellStyle);
				}
			}

			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			String fileName = "出力情報.xlsx";
			fileName = java.net.URLEncoder.encode(fileName, "UTF-8"); // 编码文件名（防乱码）
			response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + fileName);
			workbook.write(response.getOutputStream());
		}
	}
}