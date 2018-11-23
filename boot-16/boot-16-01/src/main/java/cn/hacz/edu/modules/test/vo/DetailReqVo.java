package cn.hacz.edu.modules.test.vo;

public class DetailReqVo {
	private String token;
	private String loginName;
	private String name;
	private String bm;
	private String ajbh;
	private String jcType;
	private String ztType;
	
	
	@Override
	public String toString() {
		return "DetailReqVo [token=" + token + ", loginName=" + loginName + ", name=" + name + ", bm=" + bm + ", ajbh="
				+ ajbh + ", jcType=" + jcType + ", ztType=" + ztType + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getBm() {
		return bm;
	}
	public void setBm(String bm) {
		this.bm = bm;
	}
	public String getAjbh() {
		return ajbh;
	}
	public void setAjbh(String ajbh) {
		this.ajbh = ajbh;
	}
	public String getJcType() {
		return jcType;
	}
	public void setJcType(String jcType) {
		this.jcType = jcType;
	}
	public String getZtType() {
		return ztType;
	}
	public void setZtType(String ztType) {
		this.ztType = ztType;
	}
	

}
