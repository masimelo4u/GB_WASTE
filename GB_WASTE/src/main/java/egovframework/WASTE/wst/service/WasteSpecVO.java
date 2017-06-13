package egovframework.WASTE.wst.service;

import egovframework.WASTE.cmmn.service.SearchVO;

/**  
 * @Class Name : WasteSpecVO.java
 * @Description : WasteSpecVO Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017.04.19   미키    최초생성
 * 
 * @author 미키
 * @since 2017.04.19
 * @version 1.0
 * @see
 * 
 *  Copyright (C) by 미키 All right reserved.
 */
public class WasteSpecVO extends SearchVO {

	static final long serialVersionUID = -2909601111222999017L;

	private int wasteApplySpecNo;
	private int oid;
	private String item;
	private String spec;
	private String price;
	private String amount;
	private String creater;
	private String creationDate;
	private String updater;
	private String updateDate;
	private int applyNo;
	
	
	public int getWasteApplySpecNo() {
		return wasteApplySpecNo;
	}
	public void setWasteApplySpecNo(int wasteApplySpecNo) {
		this.wasteApplySpecNo = wasteApplySpecNo;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
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
	public int getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}
	
	
}
