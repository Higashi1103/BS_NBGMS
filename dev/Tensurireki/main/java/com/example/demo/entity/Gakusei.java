package com.example.demo.entity;

public class Gakusei {

	private Integer gakuseiId;
	private String namae;
	private Integer tensu;

	public Gakusei() {
	}

	public Gakusei(Integer gakuseiId, String namae, Integer tensu) {
		this.gakuseiId = gakuseiId;
		this.namae = namae;
		this.tensu = tensu;
	}

	public Integer getGakuseiId() {
		return gakuseiId;
	}

	public void setGakuseiId(Integer gakuseiId) {
		this.gakuseiId = gakuseiId;
	}

	public String getNamae() {
		return namae;
	}

	public void setNamae(String namae) {
		this.namae = namae;
	}

	public Integer getTensu() {
		return tensu;
	}

	public void setTensu(Integer tensu) {
		this.tensu = tensu;
	}

}
