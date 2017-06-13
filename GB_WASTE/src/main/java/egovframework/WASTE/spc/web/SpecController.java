package egovframework.WASTE.spc.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.WASTE.cmmn.service.CmmUseService;
import egovframework.WASTE.cmmn.service.SearchVO;
import egovframework.WASTE.spc.service.SpecService;
import egovframework.WASTE.spc.service.SpecVO;
import egovframework.WASTE.wst.service.WasteSpecVO;
import egovframework.WASTE.wst.service.WasteVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : SpecController.java
 * @Description : SpecController Class
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
 * @ Copyright (C) by 미키 All right reserved.
 */

@Controller
@SessionAttributes(types = SpecVO.class)
public class SpecController {
	
	/** SpecService */
	@Resource(name = "specService")
	private SpecService specService;

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
	 *  selectPopSpecList
	 * @param SearchVO
	 * @param model
	 * @return "/popup/popSpecList"
	 * @exception Exception
	 */
    @RequestMapping("/popup/selectPopSpecList.do")
    public String selectPopSpecList(
            @ModelAttribute("searchVO") SearchVO searchVO
            , HttpServletRequest request
            , Model model)
            throws Exception {
    	log.debug("# Controller - selectPopSpecList START!");

//		WasteVO wasteVO = new WasteVO();
//
//		wasteVO.setCollectDate(request.getParameter("collectDate"));
//		wasteVO.setPayStatus(request.getParameter("payStatus"));
//		wasteVO.setReqHjdong(request.getParameter("reqHjdong"));
//		wasteVO.setcDateF(request.getParameter("cDateF"));
//		wasteVO.setcDateT(request.getParameter("cDateT"));
//		wasteVO.setRequestNm(request.getParameter("requestNm"));

//		List wasteList = wasteService.selectWasteList(wasteVO);
    	
//		model.addAttribute("resultList", wasteList);
		
//		model.addAttribute("collectDate", request.getParameter("collectDate"));
//		model.addAttribute("payStatus", request.getParameter("payStatus"));
//		model.addAttribute("reqHjdong", request.getParameter("reqHjdong"));
//		model.addAttribute("cDateF", request.getParameter("cDateF"));
//		model.addAttribute("cDateT", request.getParameter("cDateT"));
//		model.addAttribute("requestNm", request.getParameter("requestNm"));
    	
    	SpecVO specVO = new SpecVO();
    	List popSpecList = specService.selectPopSpecList(specVO);
    	
    	model.addAttribute("resultList", popSpecList);
    	model.addAttribute("rNum", request.getParameter("rNum"));
		
        return "/popup/popSpecList";
    }
    
    /**
	 *  selectSpecList
	 * @param SearchVO
	 * @param model
	 * @return "/spc/specList"
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/spc/selectSpecList.do")
    public String selectSpecList(
            @ModelAttribute("searchVO") SearchVO searchVO
            , HttpServletRequest request
            , HttpSession session
            , Model model)
            throws Exception {
    	log.debug("# Controller - selectSpecList START!");
    	session.setAttribute("menu", "selectSpecList");

    	SpecVO specVO = new SpecVO();
    	String pageUnit = request.getParameter("pageUnit");
    	if(pageUnit == null || "".equals(pageUnit)) {
    		pageUnit = propertiesService.getInt("pageUnit")+"";
    	}
    	specVO.setPageUnit(Integer.parseInt(pageUnit));
    	specVO.setPageSize(propertiesService.getInt("pageSize"));
    	PaginationInfo paginationInfo = new PaginationInfo();
    	
    	String pageIndex = request.getParameter("pageNo");
    	if(pageIndex == null || "".equals(pageIndex)) {
    		specVO.setPageIndex(1);	
    	} else {
    		specVO.setPageIndex(Integer.parseInt(pageIndex));
    	}
    	
		paginationInfo.setCurrentPageNo(specVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(specVO.getPageUnit());
		paginationInfo.setPageSize(specVO.getPageSize());
		
		specVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		specVO.setLastIndex(paginationInfo.getLastRecordIndex());
		specVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
    	specVO.setSortCd(request.getParameter("sortCd"));
    	specVO.setItem(request.getParameter("item"));
    	specVO.setUseYn(request.getParameter("useYn"));
    	
    	model.addAttribute("sortCd", request.getParameter("sortCd"));
    	model.addAttribute("item", request.getParameter("item"));
    	model.addAttribute("useYn", request.getParameter("useYn"));
    	model.addAttribute("pageUnit", pageUnit);
    	
    	List specList = specService.selectSpecList(specVO);
    	model.addAttribute("resultList", specList);
    	
    	int totCnt = specService.selectSpecListTotCnt(specVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
    	
        return "/spc/specList";
    }
    
    /**
	 * addSpecView
	 * @param SearchVO
	 * @return "/spc/specRegist"
	 * @exception Exception
	 */
    @RequestMapping("/spc/addSpecView.do")
    public String addSpecView(
            @ModelAttribute("searchVO") SearchVO searchVO
            , HttpServletRequest request
            , Model model)
            throws Exception {
        log.debug("# Controller - addSpecView START!");
        return "/spc/specRegist";
    }
    
    /**
	 * addSpecApply
	 * @param SearchVO
	 * @return "/wst/wasteList.do"
	 * @exception Exception
	 */
	@RequestMapping("/spc/addSpecApply.do")
    public String addSpecApply(
    		@ModelAttribute("searchVO") SearchVO searchVO,
            BindingResult bindingResult, 
            Model model, 
            HttpServletRequest request,
            SessionStatus status) 
    throws Exception {
    	log.debug("# Controller - addSpecApply START!");
    	SpecVO specVO = new SpecVO();
    	
    	int wasteSpecNo = specService.selectSpecApplyNo(specVO);
    	specVO.setWasteSpecNo(wasteSpecNo);
    	
    	String sortCd = request.getParameter("sortCd");
    	String sortNm = "";
    	if("1".equals(sortCd)) {
    		sortNm = "가전제품";
    	} else if("2".equals(sortCd)) {
    		sortNm = "냉난방기";
    	} else if("3".equals(sortCd)) {
    		sortNm = "주방용품";
    	} else if("4".equals(sortCd)) {
    		sortNm = "가구류";
    	} else if("5".equals(sortCd)) {
    		sortNm = "학습사무기기";
    	} else if("6".equals(sortCd)) {
    		sortNm = "생활용품";
    	} else if("7".equals(sortCd)) {
    		sortNm = "기타";
    	} else if("8".equals(sortCd)) {
    		sortNm = "면제품목";
    	}
    	specVO.setSortCd(sortCd);
    	specVO.setSortNm(sortNm);
    	
    	specVO.setItem(request.getParameter("item"));
    	specVO.setSpec(request.getParameter("spec"));
    	specVO.setPrice(request.getParameter("price"));
    	specVO.setUseYn(request.getParameter("useYn"));
    	specVO.setCreater("");
    	specVO.setUpdater("");
    	
    	// Server-Side Validation
    	beanValidator.validate(specVO, bindingResult);
    	
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("specVO", specVO);
			return cmmUseService.redirectMsg(model, "등록 중 오류가 발생했습니다.", "/spc/addSpecView.do");
    	}
    	log.debug(specVO);
    	specService.insertSpecApply(specVO);
    	
    	return cmmUseService.redirectMsg(model, "등록이 완료되었습니다.", "/spc/selectSpecList.do");
	}
	
	/**
	 *  updateSpecView
	 * @param SearchVO
	 * @return "/spc/specUpdate"
	 * @exception Exception
	 */
	@RequestMapping("/spc/updateSpecView.do")
    public String updateSpecView(
//    		@ModelAttribute("searchVO") SpecVO specVO,
            HttpServletRequest request,
            Model model)
            throws Exception {
    	log.debug("# Controller - updateSpecView START!");
    	
    	int wasteSpecNo = Integer.parseInt(request.getParameter("specNo"));
    	log.debug(wasteSpecNo);
    	
    	SpecVO specVO = new SpecVO();
    	specVO.setWasteSpecNo(wasteSpecNo);
    	
    	SpecVO specResult = new SpecVO();
    	specResult = specService.selectSpecView(specVO);
    	
    	model.addAttribute("specResult", specResult);
    	
        return "/spc/specUpdate";
    }
	
	/**
	 * updateSpecApply
	 * @param SearchVO
	 * @return "/spc/selectSpecList.do"
	 * @exception Exception
	 */
	@RequestMapping("/spc/updateSpecApply.do")
    public String updateSpecApply(
    		@ModelAttribute("searchVO") SearchVO searchVO,
            BindingResult bindingResult, 
            Model model, 
            HttpServletRequest request,
            SessionStatus status) 
    throws Exception {
		log.debug("# Controller - updateSpecApply START!");
		
		SpecVO specVO = new SpecVO();
		
    	specVO.setWasteSpecNo(Integer.parseInt(request.getParameter("wasteSpecNo")));
    	
    	String sortCd = request.getParameter("sortCd");
    	String sortNm = "";
    	if("1".equals(sortCd)) {
    		sortNm = "가전제품";
    	} else if("2".equals(sortCd)) {
    		sortNm = "냉난방기";
    	} else if("3".equals(sortCd)) {
    		sortNm = "주방용품";
    	} else if("4".equals(sortCd)) {
    		sortNm = "가구류";
    	} else if("5".equals(sortCd)) {
    		sortNm = "학습사무기기";
    	} else if("6".equals(sortCd)) {
    		sortNm = "생활용품";
    	} else if("7".equals(sortCd)) {
    		sortNm = "기타";
    	} else if("8".equals(sortCd)) {
    		sortNm = "면제품목";
    	}
    	specVO.setSortCd(sortCd);
    	specVO.setSortNm(sortNm);
    	
    	specVO.setItem(request.getParameter("item"));
    	specVO.setSpec(request.getParameter("spec"));
    	specVO.setPrice(request.getParameter("price"));
    	specVO.setUseYn(request.getParameter("useYn"));
		
		// Server-Side Validation
    	beanValidator.validate(specVO, bindingResult);
    	
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("specVO", specVO);
			return cmmUseService.redirectMsg(model, "수정 중 오류가 발생했습니다.", "/spc/updateSpecView.do");
    	}
    	log.debug(specVO);
    	specService.updateSpecApply(specVO);
		
		status.setComplete();
        return cmmUseService.redirectMsg(model, "수정이 완료되었습니다.", "/spc/selectSpecList.do");
	}
	
	/**
	 * deleteSpecApply
	 * @param SearchVO
	 * @return "/spc/spcList.do"
	 * @exception Exception
	 */
    @RequestMapping("/spc/deleteSpecApply.do")
    public String deleteSpecApply(
            @ModelAttribute("searchVO") SearchVO searchVO,
            Model model, 
            HttpServletRequest request,
            SessionStatus status)
            throws Exception {
    	log.debug("# Controller - deleteSpecApply START!");
    	SpecVO specVO = new SpecVO();
    	
    	specVO.setWasteSpecNo(Integer.parseInt(request.getParameter("wasteSpecNo")));
    	specService.deleteSpecApply(specVO);
    	
        status.setComplete();
        return cmmUseService.redirectMsg(model, "삭제가 완료되었습니다.", "/spc/selectSpecList.do");
    }
}

