package egovframework.WASTE.wst.service;

import egovframework.WASTE.cmmn.service.SearchVO;

/**  
 * @Class Name : WasteVO.java
 * @Description : WasteVO Class
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

public class WasteVO extends SearchVO {

	static final long serialVersionUID = -1623227925689663555L;

	private int wasteApplyNo;
	private int oid;
	private String requestNm;
	private String reqEmail;
	private String reqTelephone;
	private String reqTelephone1;
	private String reqTelephone2;
	private String reqTelephone3;
	private String reqMobile;
	private String reqMobile1;
	private String reqMobile2;
	private String reqMobile3;
	private String reqPost;
	private String reqPost1;
	private String reqPost2;
	private String reqAddr;
	private String reqNewAddr;
	private String reqBjdong;
	private String reqBunji;
	private String reqBunji1;
	private String reqBunji2;
	private String reqHjdong;
	private String accountNm;
	private String accEmail;
	private String accTelephone;
	private String accTelephone1;
	private String accTelephone2;
	private String accTelephone3;
	private String accMobile;
	private String accMobile1;
	private String accMobile2;
	private String accMobile3;
	private String accPost;
	private String accPost1;
	private String accPost2;
	private String accAddr;
	private String accNewAddr;
	private String accBjdong;
	private String accBunji;
	private String accBunji1;
	private String accBunji2;
	private String accHjdong;
	private String payType;
	private String price;
	private String detail;
	private String transaction;
	private String payStatus;
	private String dischargeDate;
	private String collectDate;
	private String showRecord;
	private String serialNo;
	private String managerId;
	private String userIp;
	private String creater;
	private String creationDate;
	private String updater;
	private String updateDate;
	
	private String cDateF;
	private String cDateT;
	
	private String hjdongNm;
	private String bjdongNm;
	
	private String year;
	private String month;
	private String date;
	
	private String sumPrice;
	
	
	public String getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReqTelephone1() {
		return reqTelephone1;
	}

	public void setReqTelephone1(String reqTelephone1) {
		this.reqTelephone1 = reqTelephone1;
	}

	public String getReqTelephone2() {
		return reqTelephone2;
	}

	public void setReqTelephone2(String reqTelephone2) {
		this.reqTelephone2 = reqTelephone2;
	}

	public String getReqTelephone3() {
		return reqTelephone3;
	}

	public void setReqTelephone3(String reqTelephone3) {
		this.reqTelephone3 = reqTelephone3;
	}

	public String getReqMobile1() {
		return reqMobile1;
	}

	public void setReqMobile1(String reqMobile1) {
		this.reqMobile1 = reqMobile1;
	}

	public String getReqMobile2() {
		return reqMobile2;
	}

	public void setReqMobile2(String reqMobile2) {
		this.reqMobile2 = reqMobile2;
	}

	public String getReqMobile3() {
		return reqMobile3;
	}

	public void setReqMobile3(String reqMobile3) {
		this.reqMobile3 = reqMobile3;
	}

	public String getAccTelephone1() {
		return accTelephone1;
	}

	public void setAccTelephone1(String accTelephone1) {
		this.accTelephone1 = accTelephone1;
	}

	public String getAccTelephone2() {
		return accTelephone2;
	}

	public void setAccTelephone2(String accTelephone2) {
		this.accTelephone2 = accTelephone2;
	}

	public String getAccTelephone3() {
		return accTelephone3;
	}

	public void setAccTelephone3(String accTelephone3) {
		this.accTelephone3 = accTelephone3;
	}

	public String getAccMobile1() {
		return accMobile1;
	}

	public void setAccMobile1(String accMobile1) {
		this.accMobile1 = accMobile1;
	}

	public String getAccMobile2() {
		return accMobile2;
	}

	public void setAccMobile2(String accMobile2) {
		this.accMobile2 = accMobile2;
	}

	public String getAccMobile3() {
		return accMobile3;
	}

	public void setAccMobile3(String accMobile3) {
		this.accMobile3 = accMobile3;
	}

	public String getHjdongNm() {
		return hjdongNm;
	}

	public void setHjdongNm(String hjdongNm) {
		this.hjdongNm = hjdongNm;
	}

	public String getBjdongNm() {
		return bjdongNm;
	}

	public void setBjdongNm(String bjdongNm) {
		this.bjdongNm = bjdongNm;
	}

	public String getReqBunji1() {
		return reqBunji1;
	}

	public void setReqBunji1(String reqBunji1) {
		this.reqBunji1 = reqBunji1;
	}

	public String getReqBunji2() {
		return reqBunji2;
	}

	public void setReqBunji2(String reqBunji2) {
		this.reqBunji2 = reqBunji2;
	}

	public String getAccBunji1() {
		return accBunji1;
	}

	public void setAccBunji1(String accBunji1) {
		this.accBunji1 = accBunji1;
	}

	public String getAccBunji2() {
		return accBunji2;
	}

	public void setAccBunji2(String accBunji2) {
		this.accBunji2 = accBunji2;
	}

	public String getcDateF() {
		return cDateF;
	}

	public void setcDateF(String cDateF) {
		this.cDateF = cDateF;
	}

	public String getcDateT() {
		return cDateT;
	}

	public void setcDateT(String cDateT) {
		this.cDateT = cDateT;
	}

	public int getWasteApplyNo() {
		return wasteApplyNo;
	}
	
	public void setWasteApplyNo(int wasteApplyNo) {
		this.wasteApplyNo = wasteApplyNo;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getRequestNm() {
		return requestNm;
	}
	public void setRequestNm(String requestNm) {
		this.requestNm = requestNm;
	}
	public String getReqEmail() {
		return reqEmail;
	}
	public void setReqEmail(String reqEmail) {
		this.reqEmail = reqEmail;
	}
	public String getReqTelephone() {
		return reqTelephone;
	}
	public void setReqTelephone(String reqTelephone) {
		this.reqTelephone = reqTelephone;
	}
	public String getReqMobile() {
		return reqMobile;
	}
	public void setReqMobile(String reqMobile) {
		this.reqMobile = reqMobile;
	}
	public String getReqPost() {
		return reqPost;
	}
	public void setReqPost(String reqPost) {
		this.reqPost = reqPost;
	}
	public String getReqPost1() {
		return reqPost1;
	}
	public void setReqPost1(String reqPost1) {
		this.reqPost1 = reqPost1;
	}
	public String getReqPost2() {
		return reqPost2;
	}
	public void setReqPost2(String reqPost2) {
		this.reqPost2 = reqPost2;
	}
	public String getReqAddr() {
		return reqAddr;
	}
	public void setReqAddr(String reqAddr) {
		this.reqAddr = reqAddr;
	}
	public String getReqNewAddr() {
		return reqNewAddr;
	}
	public void setReqNewAddr(String reqNewAddr) {
		this.reqNewAddr = reqNewAddr;
	}
	public String getReqBjdong() {
		return reqBjdong;
	}
	public void setReqBjdong(String reqBjdong) {
		this.reqBjdong = reqBjdong;
	}
	public String getReqBunji() {
		return reqBunji;
	}
	public void setReqBunji(String reqBunji) {
		this.reqBunji = reqBunji;
	}
	public String getReqHjdong() {
		return reqHjdong;
	}
	public void setReqHjdong(String reqHjdong) {
		this.reqHjdong = reqHjdong;
	}
	public String getAccountNm() {
		return accountNm;
	}
	public void setAccountNm(String accountNm) {
		this.accountNm = accountNm;
	}
	public String getAccEmail() {
		return accEmail;
	}
	public void setAccEmail(String accEmail) {
		this.accEmail = accEmail;
	}
	public String getAccTelephone() {
		return accTelephone;
	}
	public void setAccTelephone(String accTelephone) {
		this.accTelephone = accTelephone;
	}
	public String getAccMobile() {
		return accMobile;
	}
	public void setAccMobile(String accMobile) {
		this.accMobile = accMobile;
	}
	public String getAccPost() {
		return accPost;
	}
	public String getAccPost1() {
		return accPost1;
	}
	public void setAccPost1(String accPost1) {
		this.accPost1 = accPost1;
	}
	public String getAccPost2() {
		return accPost2;
	}
	public void setAccPost2(String accPost2) {
		this.accPost2 = accPost2;
	}
	public void setAccPost(String accPost) {
		this.accPost = accPost;
	}
	public String getAccAddr() {
		return accAddr;
	}
	public void setAccAddr(String accAddr) {
		this.accAddr = accAddr;
	}
	public String getAccNewAddr() {
		return accNewAddr;
	}
	public void setAccNewAddr(String accNewAddr) {
		this.accNewAddr = accNewAddr;
	}
	public String getAccBjdong() {
		return accBjdong;
	}
	public void setAccBjdong(String accBjdong) {
		this.accBjdong = accBjdong;
	}
	public String getAccBunji() {
		return accBunji;
	}
	public void setAccBunji(String accBunji) {
		this.accBunji = accBunji;
	}
	public String getAccHjdong() {
		return accHjdong;
	}
	public void setAccHjdong(String accHjdong) {
		this.accHjdong = accHjdong;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public String getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
	public String getShowRecord() {
		return showRecord;
	}
	public void setShowRecord(String showRecord) {
		this.showRecord = showRecord;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
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
