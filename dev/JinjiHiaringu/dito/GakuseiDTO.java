package com.example.demo.dito.hiaringu;

public class GakuseiDTO {
	private Long gakuseiId;
    private String namae;
    private String kurasuNamae;
    
    // 构造函数
    public GakuseiDTO() {}
    
    public GakuseiDTO(Long gakuseiId, String namae, String kurasuMei, String kurasuNamae) {
        this.gakuseiId = gakuseiId;
        this.namae = namae;
        this.kurasuNamae = kurasuNamae;
}

	public Long getGakuseiId() {
		return gakuseiId;
	}

	public void setGakuseiId(Long gakuseiId) {
		this.gakuseiId = gakuseiId;
	}

	public String getNamae() {
		return namae;
	}

	public void setNamae(String namae) {
		this.namae = namae;
	}

	public String getKurasuNamae() {
		return kurasuNamae;
	}

	public void setKurasuNamae(String kurasuNamae) {
		this.kurasuNamae = kurasuNamae;
	}
    
}
