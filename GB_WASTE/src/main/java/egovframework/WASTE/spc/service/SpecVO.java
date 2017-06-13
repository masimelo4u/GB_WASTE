package egovframework.WASTE.spc.service;

import egovframework.WASTE.cmmn.service.SearchVO;

/**  
 * @Class Name : SpecVO.java
 * @Description : SpecVO Class
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

public class SpecVO extends SearchVO {

	static final long serialVersionUID = -2668712364029516338L;
	
	private int wasteSpecNo;
	private String sortCd;
	private String sortNm;
	private String item;
	private String spec;
	private String price;
	private String useYn;
	private String creater;
	private String updater;
	
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public int getWasteSpecNo() {
		return wasteSpecNo;
	}
	public void setWasteSpecNo(int wasteSpecNo) {
		this.wasteSpecNo = wasteSpecNo;
	}
	public String getSortCd() {
		return sortCd;
	}
	public void setSortCd(String sortCd) {
		this.sortCd = sortCd;
	}
	public String getSortNm() {
		return sortNm;
	}
	public void setSortNm(String sortNm) {
		this.sortNm = sortNm;
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
	
	
}
