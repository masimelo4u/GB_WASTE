package egovframework.WASTE.wst.web;

import java.net.InetAddress;
import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.WASTE.cmmn.service.CmmUseService;
import egovframework.WASTE.cmmn.service.SearchVO;
import egovframework.WASTE.wst.service.WasteService;
import egovframework.WASTE.wst.service.WasteSpecVO;
import egovframework.WASTE.wst.service.WasteVO;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import egovframework.WASTE.cmmn.DateUtil;
import egovframework.WASTE.hjd.service.HjdongVO;

/**
 * @Class Name : WasteController.java
 * @Description : WasteController Class
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
 * @ Copyright (C) by 미키 All right reserved.
 */

@Controller
@SessionAttributes(types = WasteVO.class)
public class WasteController {

	/** WasteService */
	@Resource(name = "wasteService")
	private WasteService wasteService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	/** cmmUseService */
	@Resource(name="cmmUseService")
	private CmmUseService cmmUseService;
	
	protected Log log = LogFactory.getLog(this.getClass());

	/**
	 * selectWasteList
	 * @param searchVO
	 * @return "/wst/wasteList"
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/wst/selectWasteList.do")
	public String selectWasteList(
			@ModelAttribute("searchVO") SearchVO searchVO, 
			ModelMap model,
			HttpSession session,
			HttpServletRequest request) throws Exception {
		log.debug("# Controller - selectWasteList START!");
		session.setAttribute("menu", "selectWasteList");

		WasteVO wasteVO = new WasteVO();
		
		String pageUnit = request.getParameter("pageUnit");
    	if(pageUnit == null || "".equals(pageUnit)) {
    		pageUnit = propertiesService.getInt("pageUnit")+"";
    	}
    	wasteVO.setPageUnit(Integer.parseInt(pageUnit));
    	wasteVO.setPageSize(propertiesService.getInt("pageSize"));
    	PaginationInfo paginationInfo = new PaginationInfo();
    	
    	String pageIndex = request.getParameter("pageNo");
    	if(pageIndex == null || "".equals(pageIndex)) {
    		wasteVO.setPageIndex(1);	
    	} else {
    		wasteVO.setPageIndex(Integer.parseInt(pageIndex));
    	}
		paginationInfo.setCurrentPageNo(wasteVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(wasteVO.getPageUnit());
		paginationInfo.setPageSize(wasteVO.getPageSize());
		
		wasteVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		wasteVO.setLastIndex(paginationInfo.getLastRecordIndex());
		wasteVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		wasteVO.setCollectDate(request.getParameter("collectDate"));
		wasteVO.setPayStatus(request.getParameter("payStatus"));
		wasteVO.setReqHjdong(request.getParameter("reqHjdong"));
		
		if(request.getParameter("cDateF") != null) {
			wasteVO.setcDateF(request.getParameter("cDateF"));
			wasteVO.setcDateT(request.getParameter("cDateT"));	
		} else {
			wasteVO.setcDateF(DateUtil.today("yyyy-MM-dd"));
			wasteVO.setcDateT(DateUtil.today("yyyy-MM-dd"));
		}
		wasteVO.setRequestNm(request.getParameter("requestNm"));

		List wasteList = wasteService.selectWasteList(wasteVO);
		model.addAttribute("resultList", wasteList);
		
		int totCnt = wasteService.selectWasteListTotCnt(wasteVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        model.addAttribute("pageUnit", pageUnit);
		
		model.addAttribute("collectDate", request.getParameter("collectDate"));
		model.addAttribute("payStatus", request.getParameter("payStatus"));
		model.addAttribute("reqHjdong", request.getParameter("reqHjdong"));
		model.addAttribute("cDateF", request.getParameter("cDateF"));
		model.addAttribute("cDateT", request.getParameter("cDateT"));
		model.addAttribute("requestNm", request.getParameter("requestNm"));

		return "/wst/wasteList";
	}
	
	/**
	 * addWasteApplyView
	 * @param SearchVO
	 * @return "/wst/wasteRegist"
	 * @exception Exception
	 */
    @RequestMapping("/wst/addWasteApplyView.do")
    public String addWasteApplyView(
            @ModelAttribute("searchVO") SearchVO searchVO
            , Model model)
            throws Exception {
//        model.addAttribute("sampleVO", new SampleVO());
        return "/wst/wasteRegist";
    }
    
    /**
	 * addWasteApply
	 * @param SearchVO
	 * @return "/wst/wasteList.do"
	 * @exception Exception
	 */
	@RequestMapping("/wst/addWasteApply.do")
    public String addWasteApply(
    		@ModelAttribute("searchVO") SearchVO searchVO,
            BindingResult bindingResult, 
            Model model, 
            HttpServletRequest request,
            SessionStatus status) 
    throws Exception {
    	log.debug("# Controller - addWasteApply START!");
    	WasteVO wasteVO = new WasteVO();
    	
    	int wasteApplyNo = wasteService.selectWasteApplyNo(wasteVO);
    	int oid = wasteService.selectWasteApplyOid(wasteVO);
    	wasteVO.setWasteApplyNo(wasteApplyNo);
    	wasteVO.setOid(oid);
    	wasteVO.setRequestNm(request.getParameter("requestNm"));
    	wasteVO.setReqTelephone(request.getParameter("reqTelephone1")+"-"+request.getParameter("reqTelephone2")+"-"+request.getParameter("reqTelephone3"));
    	wasteVO.setReqMobile(request.getParameter("reqMobile1")+"-"+request.getParameter("reqMobile2")+"-"+request.getParameter("reqMobile3"));
    	wasteVO.setReqEmail(request.getParameter("reqEmail"));
    	
    	wasteVO.setReqPost(request.getParameter("reqPost1")+"-"+request.getParameter("reqPost2"));
    	wasteVO.setReqPost1(request.getParameter("reqPost1"));
    	wasteVO.setReqPost2(request.getParameter("reqPost2"));
    	wasteVO.setReqAddr(request.getParameter("reqAddr"));
    	wasteVO.setReqNewAddr(request.getParameter("reqNewAddr1")+"-"+request.getParameter("reqNewAddr2"));
    	wasteVO.setReqBunji1(request.getParameter("reqBunji1"));
    	wasteVO.setReqBunji2(request.getParameter("reqBunji2"));
    	wasteVO.setReqBunji(wasteVO.getReqBunji1()+"-"+wasteVO.getReqBunji2());
    	
    	wasteVO.setAccPost(request.getParameter("accPost1")+"-"+request.getParameter("accPost2"));
    	wasteVO.setAccPost1(request.getParameter("accPost1"));
    	wasteVO.setAccPost2(request.getParameter("accPost2"));
    	wasteVO.setAccAddr(request.getParameter("accAddr"));
    	wasteVO.setAccNewAddr(request.getParameter("accNewAddr1")+"-"+request.getParameter("accNewAddr2"));
    	wasteVO.setAccBunji1(request.getParameter("accBunji1"));
    	wasteVO.setAccBunji2(request.getParameter("accBunji2"));
    	wasteVO.setAccBunji(wasteVO.getAccBunji1()+"-"+wasteVO.getAccBunji2());
    	
    	wasteVO.setPrice(request.getParameter("price").replaceAll("\\,", ""));
    	wasteVO.setDischargeDate(request.getParameter("year")+"-"+String.format("%02d", Integer.parseInt(request.getParameter("month")))+"-"+String.format("%02d", Integer.parseInt(request.getParameter("date")))+" "+"00:00:00");
    	wasteVO.setDetail(request.getParameter("detail"));
    	
    	wasteVO.setPayType("other");
//    	wasteVO.setTransaction("");
    	wasteVO.setPayStatus("N");
//    	wasteVO.setCollectDate("");
    	wasteVO.setShowRecord("Y");
    	wasteVO.setSerialNo(DateUtil.today()+"_"+wasteVO.getWasteApplyNo());
    	
    	InetAddress local = InetAddress.getLocalHost();
    	String userIp = local.getHostAddress();
    	wasteVO.setUserIp(userIp);
//    	wasteVO.setCreater("");
//    	wasteVO.setUpdater("");
    	
    	HjdongVO hjdongVO = new HjdongVO();
    	hjdongVO.setOid(request.getParameter("reqBjdong")+request.getParameter("reqBunji1")+"-"+request.getParameter("reqBunji2"));
    	
    	HjdongVO hjdongResult = new HjdongVO();
    	hjdongResult = wasteService.selectReqHjdong(hjdongVO);
    	
    	wasteVO.setReqBjdong(hjdongResult.getBjdongNm());
    	wasteVO.setReqHjdong(hjdongResult.getHjdongNm());
    	
    	wasteVO.setManagerId(hjdongResult.getHjdongNm());
    	
    	hjdongVO.setOid(request.getParameter("accBjdong")+request.getParameter("accBunji1")+"-"+request.getParameter("accBunji2"));
    	hjdongResult = wasteService.selectReqHjdong(hjdongVO);
    	
    	wasteVO.setAccBjdong(hjdongResult.getBjdongNm());
    	wasteVO.setAccHjdong(hjdongResult.getHjdongNm());
    	
    	// Server-Side Validation
    	beanValidator.validate(wasteVO, bindingResult);
    	
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("wasteVO", wasteVO);
			return cmmUseService.redirectMsg(model, "등록 중 오류가 발생했습니다.", "/wst/addWasteApplyView.do");
    	}
    	wasteService.insertWasteApply(wasteVO);
    	
    	WasteSpecVO wasteSpecVO = new WasteSpecVO();
    	for(int i=1; i<=10; i++) {
    		if(!"".equals(request.getParameter("item"+i))) {
    			wasteSpecVO.setWasteApplySpecNo(i-1);
    			wasteSpecVO.setOid(oid);
        		wasteSpecVO.setItem(request.getParameter("item"+i));
        		wasteSpecVO.setSpec(request.getParameter("spec"+i));
        		wasteSpecVO.setPrice(request.getParameter("price"+i).replaceAll("\\,", ""));
        		wasteSpecVO.setAmount(request.getParameter("amount"+i));
        		wasteSpecVO.setApplyNo(wasteApplyNo);
        		
        		wasteService.insertWasteSpec(wasteSpecVO);
    		}
    	}
        status.setComplete();
        return cmmUseService.redirectMsg(model, "등록이 완료되었습니다.", "/wst/selectWasteList.do");
    }
    
	/**
	 *  updateWasteApplyView
	 * @param SearchVO
	 * @return "/wst/wasteUpdate"
	 * @exception Exception
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/wst/updateWasteApplyView.do")
    public String updateWasteApplyView(
            @ModelAttribute("searchVO") SearchVO searchVO,
            HttpServletRequest request,
            Model model)
            throws Exception {
    	log.debug("# Controller - updateWasteApplyView START!");
    	
    	int wasteApplyNo = Integer.parseInt(request.getParameter("applyNo"));
    	int oid = Integer.parseInt(request.getParameter("oid"));
    	
    	WasteVO wasteVO = new WasteVO();
    	wasteVO.setWasteApplyNo(wasteApplyNo);
    	wasteVO.setOid(oid);
    	
    	WasteVO wasteResult = new WasteVO();
    	wasteResult = wasteService.selectWasteApplyDtl(wasteVO);
    	
    	String reqTelephone = wasteResult.getReqTelephone();
    	if(reqTelephone != null) {
	    	String reqTArray[] = reqTelephone.split("-");
	    	
	    	wasteResult.setReqTelephone1(reqTArray[0]);
	    	wasteResult.setReqTelephone2(reqTArray[1]);
	    	wasteResult.setReqTelephone3(reqTArray[2]);
    	}
    	
    	String reqMobile = wasteResult.getReqMobile();
    	if(reqMobile != null) {
    		String reqMArray[] = reqMobile.split("-");
        	
        	wasteResult.setReqMobile1(reqMArray[0]);
        	wasteResult.setReqMobile2(reqMArray[1]);
        	wasteResult.setReqMobile3(reqMArray[2]);	
    	}
    	
    	String reqPost = wasteResult.getReqPost();
    	if(reqPost != null) {
    		String reqPArray[] = reqPost.split("-");

    		wasteResult.setReqPost1(reqPArray[0]);
        	wasteResult.setReqPost2(reqPArray[1]);
    	}
    	
    	String reqBunji = wasteResult.getReqBunji();
    	if(reqBunji != null) {
    		String reqBArray[] = reqBunji.split("-");

    		wasteResult.setReqBunji1(reqBArray[0]);
        	wasteResult.setReqBunji2(reqBArray[1]);
    	}
    	
    	if(wasteResult.getAccountNm() != null) {
    		String accTelephone = wasteResult.getAccTelephone();
        	if(accTelephone != null) {
        		String accTArray[] = accTelephone.split("-");
            	
            	wasteResult.setAccTelephone1(accTArray[0]);
            	wasteResult.setAccTelephone2(accTArray[1]);
            	wasteResult.setAccTelephone3(accTArray[2]);
        	}
        	
        	String accMobile = wasteResult.getAccMobile();
        	if(accMobile != null) {
        		String accMArray[] = accMobile.split("-");
            	
            	wasteResult.setAccMobile1(accMArray[0]);
            	wasteResult.setAccMobile2(accMArray[1]);
            	wasteResult.setAccMobile3(accMArray[2]);	
        	}	
    	}
    	
    	String accPost = wasteResult.getAccPost();
    	if(accPost != null) {
    		String accPArray[] = accPost.split("-");

    		wasteResult.setAccPost1(accPArray[0]);
        	wasteResult.setAccPost2(accPArray[1]);
    	}
    	
    	if(wasteResult.getAccBunji() != null) {
    		String accBunji = wasteResult.getAccBunji();
    		String accBArray[] = accBunji.split("-");

    		wasteResult.setAccBunji1(accBArray[0]);
        	wasteResult.setAccBunji2(accBArray[1]);
    	}
    	
//    	DecimalFormat df = new DecimalFormat("#,##0");
//    	wasteResult.setPrice(df.format(Integer.parseInt(wasteResult.getPrice())));
    	
    	String dischargeDate = wasteResult.getDischargeDate();
    	if(dischargeDate != null) {
    		String dischargeDArray[] = dischargeDate.split("-");
    		
    		wasteResult.setYear(dischargeDArray[0]);
    		wasteResult.setMonth(dischargeDArray[1]);
    		wasteResult.setDate(dischargeDArray[2]);
    	}
    	
    	model.addAttribute("wasteApplyDtl", wasteResult);
    	
    	WasteSpecVO wasteSpecVO = new WasteSpecVO();
    	wasteSpecVO.setApplyNo(wasteApplyNo);
    	wasteSpecVO.setOid(oid);
    	
    	List wasteSpecList = wasteService.selectWasteSpecList(wasteSpecVO);
    	WasteSpecVO wasteSpecEmpty = new WasteSpecVO(); 
    	if(wasteSpecList.size() < 10) {
    		int listSize = wasteSpecList.size();
    		for(int cnt=0; cnt<(10-listSize); cnt++) {
    			wasteSpecList.add(wasteSpecEmpty);	
//    			log.debug(cnt);
    		}
    	}
		model.addAttribute("wasteSpecList", wasteSpecList);
    	
        return "/wst/wasteUpdate";
    }
    
    /**
	 * updateWasteApply
	 * @param SearchVO
	 * @return "/wst/wasteList.do"
	 * @exception Exception
	 */
	@RequestMapping("/wst/updateWasteApply.do")
    public String updateWasteApply(
    		@ModelAttribute("searchVO") SearchVO searchVO,
            BindingResult bindingResult, 
            Model model, 
            HttpServletRequest request,
            SessionStatus status) 
    throws Exception {
		log.debug("# Controller - updateWasteApply START!");
    	WasteVO wasteVO = new WasteVO();
    	
  		wasteVO.setWasteApplyNo(Integer.parseInt(request.getParameter("wasteApplyNo")));	
   		wasteVO.setOid(Integer.parseInt(request.getParameter("oid")));	
    	
    	wasteVO.setRequestNm(request.getParameter("requestNm"));
    	wasteVO.setReqTelephone(request.getParameter("reqTelephone1")+"-"+request.getParameter("reqTelephone2")+"-"+request.getParameter("reqTelephone3"));
    	wasteVO.setReqMobile(request.getParameter("reqMobile1")+"-"+request.getParameter("reqMobile2")+"-"+request.getParameter("reqMobile3"));
    	wasteVO.setReqEmail(request.getParameter("reqEmail"));
    	
    	wasteVO.setReqPost(request.getParameter("reqPost1")+"-"+request.getParameter("reqPost2"));
    	wasteVO.setReqPost1(request.getParameter("reqPost1"));
    	wasteVO.setReqPost2(request.getParameter("reqPost2"));
    	wasteVO.setReqAddr(request.getParameter("reqAddr"));
    	wasteVO.setReqNewAddr(request.getParameter("reqNewAddr"));
    	wasteVO.setReqBunji1(request.getParameter("reqBunji1"));
    	wasteVO.setReqBunji2(request.getParameter("reqBunji2"));
    	wasteVO.setReqBunji(wasteVO.getReqBunji1()+"-"+wasteVO.getReqBunji2());
    	
    	wasteVO.setAccountNm(request.getParameter("accountNm"));
    	wasteVO.setAccTelephone(request.getParameter("accTelephone1")+"-"+request.getParameter("accTelephone2")+"-"+request.getParameter("accTelephone3"));
    	wasteVO.setAccMobile(request.getParameter("accMobile1")+"-"+request.getParameter("accMobile2")+"-"+request.getParameter("accMobile3"));
    	wasteVO.setAccEmail(request.getParameter("accEmail"));
    	
    	wasteVO.setAccPost(request.getParameter("accPost1")+"-"+request.getParameter("accPost2"));
    	wasteVO.setAccPost1(request.getParameter("accPost1"));
    	wasteVO.setAccPost2(request.getParameter("accPost2"));
    	wasteVO.setAccAddr(request.getParameter("accAddr"));
    	wasteVO.setAccNewAddr(request.getParameter("accNewAddr"));
    	wasteVO.setAccBunji1(request.getParameter("accBunji1"));
    	wasteVO.setAccBunji2(request.getParameter("accBunji2"));
    	wasteVO.setAccBunji(wasteVO.getAccBunji1()+"-"+wasteVO.getAccBunji2());
    	
    	wasteVO.setPrice(request.getParameter("price").replaceAll("\\,", ""));
    	wasteVO.setDischargeDate(request.getParameter("year")+"-"+String.format("%02d", Integer.parseInt(request.getParameter("month")))+"-"+String.format("%02d", Integer.parseInt(request.getParameter("date")))+" "+"00:00:00");
    	wasteVO.setDetail(request.getParameter("detail"));
    	
//    	wasteVO.setPayType(request.getParameter("payType"));
//    	wasteVO.setTransaction("");
    	wasteVO.setPayStatus(request.getParameter("payStatus"));
    	if(!"".equals(request.getParameter("collectDate"))) {
    		wasteVO.setCollectDate(request.getParameter("collectDate")+" "+"00:00:00");	
    	}
    	
//    	wasteVO.setShowRecord("Y");
//    	wasteVO.setSerialNo(DateUtil.today()+"_"+wasteVO.getWasteApplyNo());
    	
    	InetAddress local = InetAddress.getLocalHost();
    	String userIp = local.getHostAddress();
    	wasteVO.setUserIp(userIp);
//    	wasteVO.setCreater("");
//    	wasteVO.setUpdater("");
    	
    	HjdongVO hjdongVO = new HjdongVO();
    	
    	hjdongVO.setOid(request.getParameter("reqBjdong")+request.getParameter("reqBunji1")+"-"+request.getParameter("reqBunji2"));
    	
    	HjdongVO hjdongResult = new HjdongVO();
    	hjdongResult = wasteService.selectReqHjdong(hjdongVO);
    	
    	wasteVO.setReqBjdong(hjdongResult.getBjdongNm());
    	wasteVO.setReqHjdong(hjdongResult.getHjdongNm());
    	
    	if("".equals(request.getParameter("managerId"))) {
    		wasteVO.setManagerId(hjdongResult.getHjdongNm());	
    	} else {
    		wasteVO.setManagerId(request.getParameter("managerId"));
    	}
    	
    	hjdongVO.setOid(request.getParameter("accBjdong")+request.getParameter("accBunji1")+"-"+request.getParameter("accBunji2"));
    	hjdongResult = wasteService.selectReqHjdong(hjdongVO);
    	
    	wasteVO.setAccBjdong(hjdongResult.getBjdongNm());
    	wasteVO.setAccHjdong(hjdongResult.getHjdongNm());
		
		// Server-Side Validation
    	beanValidator.validate(wasteVO, bindingResult);
    	
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("wasteVO", wasteVO);
			return cmmUseService.redirectMsg(model, "수정 중 오류가 발생했습니다.", "/wst/updateWasteApplyView.do");
    	}
    	log.debug(wasteVO);
    	wasteService.updateWasteApply(wasteVO);
    	
    	WasteSpecVO wasteSpecVO = new WasteSpecVO();
    	wasteSpecVO.setOid(Integer.parseInt(request.getParameter("oid")));
		wasteSpecVO.setApplyNo(Integer.parseInt(request.getParameter("wasteApplyNo")));
		
    	wasteService.deleteWasteApplySpec(wasteSpecVO);
    	
    	for(int i=1; i<=10; i++) {
    		if(!"".equals(request.getParameter("item"+i))) {
    			wasteSpecVO.setWasteApplySpecNo(i-1);
        		wasteSpecVO.setItem(request.getParameter("item"+i));
        		wasteSpecVO.setSpec(request.getParameter("spec"+i));
        		wasteSpecVO.setPrice(request.getParameter("price"+i).replaceAll("\\,", ""));
        		wasteSpecVO.setAmount(request.getParameter("amount"+i));
        		
        		log.debug(wasteSpecVO);
        		wasteService.insertWasteSpec(wasteSpecVO);
    		}
    	}
    	
    	status.setComplete();
        return cmmUseService.redirectMsg(model, "수정이 완료되었습니다.", "/wst/selectWasteList.do");
		
	}
	
	/**
	 * deleteWasteApply
	 * @param SearchVO
	 * @return "/wst/wasteList.do"
	 * @exception Exception
	 */
    @RequestMapping("/wst/deleteWasteApply.do")
    public String deleteWasteApply(
            @ModelAttribute("searchVO") SearchVO searchVO,
            Model model, 
            HttpServletRequest request,
            SessionStatus status)
            throws Exception {
    	log.debug("# Controller - deleteWasteApply START!");
    	WasteVO wasteVO = new WasteVO();
    	
  		wasteVO.setWasteApplyNo(Integer.parseInt(request.getParameter("wasteApplyNo")));	
   		wasteVO.setOid(Integer.parseInt(request.getParameter("oid")));	
   		
    	wasteService.deleteWasteApply(wasteVO);
    	
    	WasteSpecVO wasteSpecVO = new WasteSpecVO();
    	
    	wasteSpecVO.setApplyNo(Integer.parseInt(request.getParameter("wasteApplyNo")));	
   		wasteSpecVO.setOid(Integer.parseInt(request.getParameter("oid")));
   		
   		wasteService.deleteWasteApplySpec(wasteSpecVO);
    	
        status.setComplete();
        return cmmUseService.redirectMsg(model, "삭제가 완료되었습니다.", "/wst/selectWasteList.do");
    }

}
