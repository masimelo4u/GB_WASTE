package egovframework.WASTE.hjd.service;

import egovframework.WASTE.cmmn.service.SearchVO;

/**  
 * @Class Name : HjdongVO.java
 * @Description : HjdongVO Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017.05.10   미키    최초생성
 * 
 * @author 미키
 * @since 2017.05.10
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by 미키 All right reserved.
 */

public class HjdongVO extends SearchVO {

	static final long serialVersionUID = -3542130649360102227L;
	
	private int wasteHjdongNo;
	private String hjdongNm;
	private String bunji1;
	private String bunji2;
	private String bjdongNm;
	private String creater;
	private String creationDate;
	private String updater;
	private String updateDate;
	
	private String post;
	private String doro;
	private String bjdongCd;
	private String oid;

	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getDoro() {
		return doro;
	}
	public void setDoro(String doro) {
		this.doro = doro;
	}
	public String getBjdongCd() {
		return bjdongCd;
	}
	public void setBjdongCd(String bjdongCd) {
		this.bjdongCd = bjdongCd;
	}
	public int getWasteHjdongNo() {
		return wasteHjdongNo;
	}
	public void setWasteHjdongNo(int wasteHjdongNo) {
		this.wasteHjdongNo = wasteHjdongNo;
	}
	public String getHjdongNm() {
		return hjdongNm;
	}
	public void setHjdongNm(String hjdongNm) {
		this.hjdongNm = hjdongNm;
	}
	public String getBunji1() {
		return bunji1;
	}
	public void setBunji1(String bunji1) {
		this.bunji1 = bunji1;
	}
	public String getBunji2() {
		return bunji2;
	}
	public void setBunji2(String bunji2) {
		this.bunji2 = bunji2;
	}
	public String getBjdongNm() {
		return bjdongNm;
	}
	public void setBjdongNm(String bjdongNm) {
		this.bjdongNm = bjdongNm;
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
