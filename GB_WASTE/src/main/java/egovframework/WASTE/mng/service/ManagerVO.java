package egovframework.WASTE.mng.service;

import egovframework.WASTE.cmmn.service.SearchVO;

/**  
 * @Class Name : ManagerVO.java
 * @Description : ManagerVO Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017.04.05   미키    최초생성
 * 
 * @author 미키
 * @since 2017.04.05
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by 미키 All right reserved.
 */
public class ManagerVO extends SearchVO {
	
	static final long serialVersionUID = 9203755090095459192L;

	private int wasteMngNo;
	
	/** 관리자ID */
	private String managerId;
	/** 관리자명 */
	private String managerNm;
	/** 패스워드 */
	private String password;
	/** 전화번호 */
	private String telephone;
	private String telephone1;
	private String telephone2;
	private String telephone3;
	/** 핸드폰번호 */
	private String mobile;
	private String mobile1;
	private String mobile2;
	private String mobile3;
	/** 관리자유형 */
	private String managerType;
	
	private String creater;
	private String creationDate;
	private String updater;
	private String updateData;
	private String lastLogin;
	
	
	public String getTelephone1() {
		return telephone1;
	}
	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}
	public String getTelephone2() {
		return telephone2;
	}
	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}
	public String getTelephone3() {
		return telephone3;
	}
	public void setTelephone3(String telephone3) {
		this.telephone3 = telephone3;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public String getMobile3() {
		return mobile3;
	}
	public void setMobile3(String mobile3) {
		this.mobile3 = mobile3;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public int getWasteMngNo() {
		return wasteMngNo;
	}
	public void setWasteMngNo(int wasteMngNo) {
		this.wasteMngNo = wasteMngNo;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerNm() {
		return managerNm;
	}
	public void setManagerNm(String managerNm) {
		this.managerNm = managerNm;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getManagerType() {
		return managerType;
	}
	public void setManagerType(String managerType) {
		this.managerType = managerType;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public String getUpdateData() {
		return updateData;
	}
	public void setUpdateData(String updateData) {
		this.updateData = updateData;
	}
	
	
}
