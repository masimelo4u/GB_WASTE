package egovframework.WASTE.hjd.web;

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
import egovframework.WASTE.hjd.service.HjdongService;
import egovframework.WASTE.hjd.service.HjdongVO;
import egovframework.WASTE.mng.service.ManagerDtlVO;
import egovframework.WASTE.mng.service.ManagerVO;
import egovframework.WASTE.spc.service.SpecVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**  
 * @Class Name : HjdongController.java
 * @Description : HjdongController Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017.06.09   미키    최초생성
 * 
 * @author 미키
 * @since 2017.06.09
 * @version 1.0
 * @see
 * 
 * @ Copyright (C) by 미키 All right reserved.
 */

@Controller
@SessionAttributes(types=HjdongVO.class)
public class HjdongController {
	
	/** EgovSampleService */
    @Resource(name = "hjdongService")
    private HjdongService hjdongService;
    
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
	 *  selectHjdongList
	 * @param SearchVO
	 * @param model
	 * @return "/hjd/hjdongList"
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value="/hjd/selectHjdongList.do")
    public String selectHjdongList(
    		@ModelAttribute("searchVO") SearchVO searchVO 
    		, HttpServletRequest request
    		, HttpSession session
    		, ModelMap model)
            throws Exception {
    	log.debug("# Controller - selectHjdongList START!");
    	session.setAttribute("menu", "selectHjdongList");
    	
    	HjdongVO hjdongVO = new HjdongVO();
    	
    	String pageUnit = request.getParameter("pageUnit");
    	if(pageUnit == null || "".equals(pageUnit)) {
    		pageUnit = propertiesService.getInt("pageUnit")+"";
    	}
    	hjdongVO.setPageUnit(Integer.parseInt(pageUnit));
    	hjdongVO.setPageSize(propertiesService.getInt("pageSize"));
    	PaginationInfo paginationInfo = new PaginationInfo();
    	
    	String pageIndex = request.getParameter("pageNo");
    	if(pageIndex == null || "".equals(pageIndex)) {
    		hjdongVO.setPageIndex(1);	
    	} else {
    		hjdongVO.setPageIndex(Integer.parseInt(pageIndex));
    	}
    	
		paginationInfo.setCurrentPageNo(hjdongVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(hjdongVO.getPageUnit());
		paginationInfo.setPageSize(hjdongVO.getPageSize());
		
		hjdongVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		hjdongVO.setLastIndex(paginationInfo.getLastRecordIndex());
		hjdongVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		hjdongVO.setBjdongNm(request.getParameter("bjdongNm"));
		hjdongVO.setOid(request.getParameter("oid"));
    	
    	model.addAttribute("bjdongNm", request.getParameter("bjdongNm"));
    	model.addAttribute("oid", request.getParameter("oid"));
    	
    	model.addAttribute("pageUnit", pageUnit);
    	
    	List hjdongList = hjdongService.selectHjdongList(hjdongVO);
    	model.addAttribute("resultList", hjdongList);
    	
    	int totCnt = hjdongService.selectHjdongListTotCnt(hjdongVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);

        return "/hjd/hjdongList";
    } 
    
    /**
	 * addHjdongView
	 * @param SearchVO
	 * @return "/hjd/hjdongRegist"
	 * @exception Exception
	 */
    @RequestMapping("/hjd/addHjdongView.do")
    public String addHjdongView(
            @ModelAttribute("searchVO") SearchVO searchVO
            , HttpServletRequest request
            , Model model)
            throws Exception {
        log.debug("# Controller - addHjdongView START!");
        
        return "/hjd/hjdongRegist";
    }
    
    /**
	 * addHjdongApply
	 * @param SearchVO
	 * @return "/hjd/addHjdongApply.do"
	 * @exception Exception
	 */
	@RequestMapping("/hjd/addHjdongApply.do")
    public String addHjdongApply(
    		@ModelAttribute("searchVO") SearchVO searchVO,
            BindingResult bindingResult, 
            Model model, 
            HttpServletRequest request,
            SessionStatus status) 
    throws Exception {
    	log.debug("# Controller - addHjdongApply START!");
    	
    	HjdongVO hjdongVO = new HjdongVO();
    	
    	int wasteHjdongNo = hjdongService.selectHjdongNo(hjdongVO);
    	hjdongVO.setWasteHjdongNo(wasteHjdongNo);
    	
    	hjdongVO.setBjdongNm(request.getParameter("bjdongNm"));
    	hjdongVO.setBunji1(request.getParameter("bunji1"));
    	hjdongVO.setBunji2(request.getParameter("bunji2"));
    	hjdongVO.setHjdongNm(request.getParameter("hjdongNm"));
    	hjdongVO.setOid(request.getParameter("bjdongNm")+request.getParameter("bunji1")+"-"+request.getParameter("bunji2"));
    	
    	hjdongVO.setCreater("");
    	hjdongVO.setUpdater("");
    	
    	// Server-Side Validation
    	beanValidator.validate(hjdongVO, bindingResult);
    	
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("hjdongVO", hjdongVO);
			return cmmUseService.redirectMsg(model, "등록 중 오류가 발생했습니다.", "/hjd/addHjdongView.do");
    	}
    	hjdongService.insertHjdongApply(hjdongVO);
    	
    	return cmmUseService.redirectMsg(model, "등록이 완료되었습니다.", "/hjd/selectHjdongList.do");

	}
	
	/**
	 *  updateHjdongView
	 * @param SearchVO
	 * @return "/hjd/hjdongUpdate"
	 * @exception Exception
	 */
	@RequestMapping("/hjd/updateHjdongView.do")
    public String updateHjdongView(
            HttpServletRequest request,
            Model model)
            throws Exception {
    	log.debug("# Controller - updateHjdongView START!");
    	
    	int wasteHjdongNo = Integer.parseInt(request.getParameter("hjdongNo"));
    	
    	HjdongVO hjdongVO = new HjdongVO();
    	hjdongVO.setWasteHjdongNo(wasteHjdongNo);
    	
    	HjdongVO hjdongResult = new HjdongVO();
    	hjdongResult = hjdongService.selectHjdongView(hjdongVO);
    	
    	model.addAttribute("hjdongResult", hjdongResult);
    	
        return "/hjd/hjdongUpdate";
    }
	
	/**
	 * updateHjdongApply
	 * @param SearchVO
	 * @return "/hjd/selectHjdongList.do"
	 * @exception Exception
	 */
	@RequestMapping("/hjd/updateHjdongApply.do")
    public String updateHjdongApply(
    		@ModelAttribute("searchVO") SearchVO searchVO,
            BindingResult bindingResult, 
            Model model, 
            HttpServletRequest request,
            SessionStatus status) 
    throws Exception {
		log.debug("# Controller - updateHjdongApply START!");
		
		HjdongVO hjdongVO = new HjdongVO();
		
		hjdongVO.setWasteHjdongNo(Integer.parseInt(request.getParameter("hjdongNo")));
		
		hjdongVO.setBjdongNm(request.getParameter("bjdongNm"));
		hjdongVO.setBunji1(request.getParameter("bunji1"));
		hjdongVO.setBunji2(request.getParameter("bunji2"));
		hjdongVO.setHjdongNm(request.getParameter("hjdongNm"));
		hjdongVO.setOid(request.getParameter("bjdongNm")+request.getParameter("bunji1")+"-"+request.getParameter("bunji2"));
    	
		// Server-Side Validation
    	beanValidator.validate(hjdongVO, bindingResult);
    	
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("hjdongVO", hjdongVO);
			return cmmUseService.redirectMsg(model, "수정 중 오류가 발생했습니다.", "/hjd/updateHjdongView.do");
    	}
    	log.debug(hjdongVO);
    	hjdongService.updateHjdongApply(hjdongVO);
		
		status.setComplete();
        return cmmUseService.redirectMsg(model, "수정이 완료되었습니다.", "/hjd/selectHjdongList.do");
	}
	
	/**
	 * deleteHjdongApply
	 * @param SearchVO
	 * @return "/spc/spcList.do"
	 * @exception Exception
	 */
    @RequestMapping("/hjd/deleteHjdongApply.do")
    public String deleteHjdongApply(
            @ModelAttribute("searchVO") SearchVO searchVO,
            Model model, 
            HttpServletRequest request,
            SessionStatus status)
            throws Exception {
    	log.debug("# Controller - deleteHjdongApply START!");
    	
    	HjdongVO hjdongVO = new HjdongVO();
    	hjdongVO.setWasteHjdongNo(Integer.parseInt(request.getParameter("hjdongNo")));
    	
    	hjdongService.deleteHjdongApply(hjdongVO);
    	
        status.setComplete();
        return cmmUseService.redirectMsg(model, "삭제가 완료되었습니다.", "/hjd/selectHjdongList.do");
    }

}
