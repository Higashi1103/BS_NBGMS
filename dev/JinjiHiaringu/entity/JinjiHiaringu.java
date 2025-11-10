package com.example.demo.entity.hiaringu;

import java.time.LocalDateTime;

public class JinjiHiaringu {	    
	private Integer hiaringuId;
    private Integer gakuseiId;
    private String tantousya;
    private LocalDateTime hiaringuNichiji;
    private String hiaringuJikan;
    private String hiaringuBasyo;
    private String hiaringuGenin;
    private String hiaringuNaiyou;
    private String bikou;
    private String sakuseisha;
    private LocalDateTime sakuseiNichiji;
    private String koushinsha;
    private LocalDateTime koushinNichiji;
    //预留字段
    private String yobi1; 
    private String yobi2; 
    private String yobi3;
    
 // 预留字段：后续关联时可直接使用
    private String gakuseiNamae; //前端输入
    private Integer kurasuId;  
       
    
	public String getGakuseiNamae() {
		return gakuseiNamae;
	}
	public void setGakuseiNamae(String gakuseiNamae) {
		this.gakuseiNamae = gakuseiNamae;
	}

	public Integer getKurasuId() {
		return kurasuId;
	}
	public void setKurasuId(Integer kurasuId) {
		this.kurasuId = kurasuId;
	}
	public Integer getHiaringuId() {
		return hiaringuId;
	}
	public void setHiaringuId(Integer hiaringuId) {
		this.hiaringuId = hiaringuId;
	}
	public Integer getGakuseiId() {
		return gakuseiId;
	}
	public void setGakuseiId(Integer gakuseiId) {
		this.gakuseiId = gakuseiId;
	}
	public String getTantousya() {
		return tantousya;
	}
	public void setTantousya(String tantousya) {
		this.tantousya = tantousya;
	}
	public LocalDateTime getHiaringuNichiji() {
		return hiaringuNichiji;
	}
	public void setHiaringuNichiji(LocalDateTime hiaringuNichiji) {
		this.hiaringuNichiji = hiaringuNichiji;
	}
	public String getHiaringuJikan() {
		return hiaringuJikan;
	}
	public void setHiaringuJikan(String hiaringuJikan) {
		this.hiaringuJikan = hiaringuJikan;
	}
	public String getHiaringuBasyo() {
		return hiaringuBasyo;
	}
	public void setHiaringuBasyo(String hiaringuBasyo) {
		this.hiaringuBasyo = hiaringuBasyo;
	}
	public String getHiaringuGenin() {
		return hiaringuGenin;
	}
	public void setHiaringuGenin(String hiaringuGenin) {
		this.hiaringuGenin = hiaringuGenin;
	}
	public String getHiaringuNaiyou() {
		return hiaringuNaiyou;
	}
	public void setHiaringuNaiyou(String hiaringuNaiyou) {
		this.hiaringuNaiyou = hiaringuNaiyou;
	}
	public String getBikou() {
		return bikou;
	}
	public void setBikou(String bikou) {
		this.bikou = bikou;
	}
	public String getSakuseisha() {
		return sakuseisha;
	}
	public void setSakuseisha(String sakuseisha) {
		this.sakuseisha = sakuseisha;
	}
	public LocalDateTime getSakuseiNichiji() {
		return sakuseiNichiji;
	}
	public void setSakuseiNichiji(LocalDateTime sakuseiNichiji) {
		this.sakuseiNichiji = sakuseiNichiji;
	}
	public String getKoushinsha() {
		return koushinsha;
	}
	public void setKoushinsha(String koushinsha) {
		this.koushinsha = koushinsha;
	}
	public LocalDateTime getKoushinNichiji() {
		return koushinNichiji;
	}
	public void setKoushinNichiji(LocalDateTime koushinNichiji) {
		this.koushinNichiji = koushinNichiji;
	}
	public String getYobi1() {
		return yobi1;
	}
	public void setYobi1(String yobi1) {
		this.yobi1 = yobi1;
	}
	public String getYobi2() {
		return yobi2;
	}
	public void setYobi2(String yobi2) {
		this.yobi2 = yobi2;
	}
	public String getYobi3() {
		return yobi3;
	}
	public void setYobi3(String yobi3) {
		this.yobi3 = yobi3;
	} 
}
