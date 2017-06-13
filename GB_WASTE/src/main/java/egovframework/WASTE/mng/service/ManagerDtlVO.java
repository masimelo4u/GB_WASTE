package egovframework.WASTE.mng.service;

import egovframework.WASTE.cmmn.service.SearchVO;

/**  
 * @Class Name : ManagerDtlVO.java
 * @Description : ManagerDtlVO Class
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
public class ManagerDtlVO extends SearchVO {

	static final long serialVersionUID = -7190009748037603151L;
	
	private int wasteMngDtlNo;
	
	/** 해당동면 코드 */
	private String hjdongCd;
	/** 해당동면 명 */
	private String hjdongNm;

	private String creater;
	private String creationDate;
	private String updater;
	private String updateDate;
	private String managerId;
	
	
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public int getWasteMngDtlNo() {
		return wasteMngDtlNo;
	}
	public void setWasteMngDtlNo(int wasteMngDtlNo) {
		this.wasteMngDtlNo = wasteMngDtlNo;
	}
	public String getHjdongCd() {
		return hjdongCd;
	}
	public void setHjdongCd(String hjdongCd) {
		this.hjdongCd = hjdongCd;
	}
	public String getHjdongNm() {
		return hjdongNm;
	}
	public void setHjdongNm(String hjdongNm) {
		this.hjdongNm = hjdongNm;
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
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	

}
