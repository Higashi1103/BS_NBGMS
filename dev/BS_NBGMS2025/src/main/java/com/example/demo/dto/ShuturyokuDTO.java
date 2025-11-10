package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ShuturyokuDTO {
	private Integer kurasuId;
	private String kurasuNamae;
	private String kurasuKamoku;
	private String tantoSensei;
	private String memo;

	private Integer gakuseiId;
	private String namae;
	private String seibetsu;
	private String seinengappi;
	private String saishuGakureki;
	private String gogakuryoku;
	private Integer tensu;
	private String hyouka;
	private String sonota;

	private Integer rirekiId;
	private String kagenTensu;
	private String gutaiRiyu;
	private String hasseiBi;
	private String tensuBiko;

	private Integer hiaringuId;
	private String hiaringuTantousya;
	private Date hiaringuNichiji;
	private String hiaringuJikan;
	private String hiaringuBasyo;
	private String hiaringuGenin;
	private String hiaringuNaiyou;
	private String hiaringuBiko;

}
