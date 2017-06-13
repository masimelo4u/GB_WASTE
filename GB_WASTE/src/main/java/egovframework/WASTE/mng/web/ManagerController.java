package egovframework.WASTE.mng.web;

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
import egovframework.WASTE.mng.service.ManagerDtlVO;
import egovframework.WASTE.mng.service.ManagerService;
import egovframework.WASTE.mng.service.ManagerVO;
import egovframework.WASTE.spc.service.SpecVO;
import egovframework.WASTE.wst.service.WasteSpecVO;
import egovframework.WASTE.wst.service.WasteVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**  
 * @Class Name : ManagerController.java
 * @Description : ManagerController Class
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
 * @ Copyright (C) by 미키 All right reserved.
 */

@Controller
@SessionAttributes(types=ManagerVO.class)
public class ManagerController {
	
	/** EgovSampleService */
    @Resource(name = "managerService")
    private ManagerService managerService;
    
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
	 *  selectMngList
	 * @param SearchVO
	 * @param model
	 * @return "/mng/managerList"
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value="/mng/selectMngList.do")
    public String selectMngList(
    		@ModelAttribute("searchVO") SearchVO searchVO 
    		, HttpServletRequest request
    		, HttpSession session
    		, ModelMap model)
            throws Exception {
    	log.debug("# Controller - selectMngList START!");
    	session.setAttribute("menu", "selectMngList");

    	ManagerVO managerVO = new ManagerVO();
    	String pageUnit = request.getParameter("pageUnit");
    	if(pageUnit == null || "".equals(pageUnit)) {
    		pageUnit = propertiesService.getInt("pageUnit")+"";
    	}
    	managerVO.setPageUnit(Integer.parseInt(pageUnit));
    	managerVO.setPageSize(propertiesService.getInt("pageSize"));
    	PaginationInfo paginationInfo = new PaginationInfo();
    	
    	String pageIndex = request.getParameter("pageNo");
    	if(pageIndex == null || "".equals(pageIndex)) {
    		managerVO.setPageIndex(1);	
    	} else {
    		managerVO.setPageIndex(Integer.parseInt(pageIndex));
    	}
    	
		paginationInfo.setCurrentPageNo(managerVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(managerVO.getPageUnit());
		paginationInfo.setPageSize(managerVO.getPageSize());
		
		managerVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		managerVO.setLastIndex(paginationInfo.getLastRecordIndex());
		managerVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		managerVO.setSearchCondition(request.getParameter("searchCondition"));
		managerVO.setSearchKeyword(request.getParameter("searchKeyword"));
		
		model.addAttribute("searchCondition", request.getParameter("searchCondition"));
		model.addAttribute("searchKeyword", request.getParameter("searchKeyword"));
    	model.addAttribute("pageUnit", pageUnit);
    	
    	List managerList = managerService.selectMngList(managerVO);
    	model.addAttribute("resultList", managerList);
    	
    	int totCnt = managerService.selectMngListTotCnt(managerVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/mng/managerList";
    } 
    
    /**
	 * addMngView
	 * @param SearchVO
	 * @return "/mng/managerRegist"
	 * @exception Exception
	 */
    @RequestMapping("/mng/addMngView.do")
    public String addMngView(
            @ModelAttribute("searchVO") SearchVO searchVO
            , HttpServletRequest request
            , Model model)
            throws Exception {
        log.debug("# Controller - addMngView START!");
        return "/mng/managerRegist";
    }
    
    /**
	 * addMngApply
	 * @param SearchVO
	 * @return "/mng/addMngApply.do"
	 * @exception Exception
	 */
	@RequestMapping("/mng/addMngApply.do")
    public String addMngApply(
    		@ModelAttribute("searchVO") SearchVO searchVO,
            BindingResult bindingResult, 
            Model model, 
            HttpServletRequest request,
            SessionStatus status) 
    throws Exception {
    	log.debug("# Controller - addMngApply START!");
    	
    	ManagerVO managerVO = new ManagerVO();
    	
    	int wasteMngNo = managerService.selectMngNo(managerVO);
    	managerVO.setWasteMngNo(wasteMngNo);
    	
    	managerVO.setManagerId(request.getParameter("managerId"));
    	managerVO.setPassword(request.getParameter("password"));
    	managerVO.setManagerNm(request.getParameter("managerNm"));
    	managerVO.setTelephone(request.getParameter("telephone1")+"-"+request.getParameter("telephone2")+"-"+request.getParameter("telephone3"));
    	managerVO.setMobile(request.getParameter("mobile1")+"-"+request.getParameter("mobile2")+"-"+request.getParameter("mobile3"));
    	managerVO.setManagerType(request.getParameter("managerType"));
    	managerVO.setCreater("");
    	managerVO.setUpdater("");
    	managerVO.setLastLogin("");
    	
    	// Server-Side Validation
    	beanValidator.validate(managerVO, bindingResult);
    	
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("managerVO", managerVO);
			return cmmUseService.redirectMsg(model, "등록 중 오류가 발생했습니다.", "/mng/addMngView.do");
    	}
    	managerService.insertMngApply(managerVO);
    	
    	ManagerDtlVO managerDtlVO = new ManagerDtlVO();
    	
    	String hjdongCd = request.getParameter("hjdongCd");
    	String hjdongNm = request.getParameter("hjdongNm");
    	
    	String[] arrHjdongCd = hjdongCd.split(",");
    	String[] arrHjdongNm = hjdongNm.split(",");
    	
    	for(int cnt=0; cnt<arrHjdongCd.length; cnt++) {
    		managerDtlVO.setWasteMngDtlNo(managerService.selectMngDtlNo(managerDtlVO));
    		managerDtlVO.setHjdongCd(arrHjdongCd[cnt]);
    		managerDtlVO.setHjdongNm(arrHjdongNm[cnt]);
    		managerDtlVO.setCreater("");
    		managerDtlVO.setUpdater("");
    		managerDtlVO.setManagerId(managerVO.getManagerId());
    		
    		managerService.insertMngDtlApply(managerDtlVO);
    	}
    	
    	return cmmUseService.redirectMsg(model, "등록이 완료되었습니다.", "/mng/selectMngList.do");

	}
	
	/**
	 * updateMngView
	 * @param SearchVO
	 * @return "/mng/managerUpdate"
	 * @exception Exception
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/mng/updateMngView.do")
    public String updateMngView(
            HttpServletRequest request,
            Model model)
            throws Exception {
        log.debug("# Controller - updateMngView START!");
        
        int wasteMngNo = Integer.parseInt(request.getParameter("mngNo"));
        model.addAttribute("mngNo", wasteMngNo);
        
        ManagerVO managerVO = new ManagerVO();
        managerVO.setWasteMngNo(wasteMngNo);
        
        ManagerVO managerResult = new ManagerVO();
        managerResult = managerService.selectMngView(managerVO);
        
        String telephoneResult = managerResult.getTelephone();
        
        if(!"".equals(telephoneResult) && telephoneResult != null) {
             String[] telephone = telephoneResult.split("-");
             
             managerResult.setTelephone1(telephone[0]);
             managerResult.setTelephone2(telephone[1]);
             managerResult.setTelephone3(telephone[2]);
        }
        
        String mobileResult = managerResult.getMobile();
        
        if(!"".equals(mobileResult) && mobileResult != null) {
        	String[] mobile = mobileResult.split("-");
        	
            managerResult.setMobile1(mobile[0]);
            managerResult.setMobile2(mobile[1]);
            managerResult.setMobile3(mobile[2]);	
        }
        
        model.addAttribute("managerResult", managerResult);
        
        ManagerDtlVO managerDtlVO = new ManagerDtlVO();
        managerDtlVO.setManagerId(managerResult.getManagerId());
        
        List managerDtlResult = managerService.selectMngDtlView(managerDtlVO);
    	model.addAttribute("managerDtlResult", managerDtlResult);
    	
    	List hjdongList = managerService.selectHjdongList(managerDtlVO);
    	hjdongList.removeAll(managerDtlResult);
    	model.addAttribute("hjdongList", hjdongList);
        
        return "/mng/managerUpdate";
    }
    
    /**
	 * deleteMngApply
	 * @param SearchVO
	 * @return "/mng/selectWasteMngList.do"
	 * @exception Exception
	 */
    @RequestMapping("/mng/deleteMngApply.do")
    public String deleteMngApply(
            @ModelAttribute("searchVO") SearchVO searchVO,
            Model model, 
            HttpServletRequest request,
            SessionStatus status)
            throws Exception {
    	log.debug("# Controller - deleteMngApply START!");
    	ManagerVO managerVO = new ManagerVO();
    	
    	managerVO.setWasteMngNo(Integer.parseInt(request.getParameter("mngNo")));	
    	managerService.deleteMngApply(managerVO);
    	
    	ManagerDtlVO managerDtlVO = new ManagerDtlVO();
    	
    	managerDtlVO.setManagerId(request.getParameter("managerId"));	
    	managerService.deleteMngDtlApply(managerDtlVO);
    	
        status.setComplete();
        return cmmUseService.redirectMsg(model, "삭제가 완료되었습니다.", "/mng/selectMngList.do");
    }
    
    /**
	 * updateMngApply
	 * @param SearchVO
	 * @return "/mng/selectMngList.do"
	 * @exception Exception
	 */
	@RequestMapping("/mng/updateMngApply.do")
    public String updateMngApply(
    		@ModelAttribute("searchVO") SearchVO searchVO,
            BindingResult bindingResult, 
            Model model, 
            HttpServletRequest request,
            SessionStatus status) 
    throws Exception {
		log.debug("# Controller - updateMngApply START!");
		
		ManagerVO managerVO = new ManagerVO();
		managerVO.setWasteMngNo(Integer.parseInt(request.getParameter("mngNo")));	

		managerVO.setManagerNm(request.getParameter("managerNm"));
		managerVO.setTelephone(request.getParameter("telephone1")+"-"+request.getParameter("telephone2")+"-"+request.getParameter("telephone3"));
		if(!"".equals(request.getParameter("mobile2")) && !"".equals(request.getParameter("mobile3"))) {
			managerVO.setMobile(request.getParameter("mobile1")+"-"+request.getParameter("mobile2")+"-"+request.getParameter("mobile3"));	
		} else {
			managerVO.setMobile("");
		}
    	managerVO.setManagerType(request.getParameter("managerType"));
    	managerVO.setUpdater("");
		
		// Server-Side Validation
    	beanValidator.validate(managerVO, bindingResult);
    	
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("managerVO", managerVO);
			return cmmUseService.redirectMsg(model, "수정 중 오류가 발생했습니다.", "/mng/updateMngView.do");
    	}
    	managerService.updateMngApply(managerVO);

    	ManagerDtlVO managerDtlVO = new ManagerDtlVO();
    	managerDtlVO.setManagerId(request.getParameter("managerId"));
    	
    	managerService.deleteMngDtlApply(managerDtlVO);
    	
    	String hjdongCd = request.getParameter("hjdongCd");
    	String hjdongNm = request.getParameter("hjdongNm");
    	
    	String[] arrHjdongCd = hjdongCd.split(",");
    	String[] arrHjdongNm = hjdongNm.split(",");
    	
    	for(int cnt=0; cnt<arrHjdongCd.length; cnt++) {
    		managerDtlVO.setWasteMngDtlNo(managerService.selectMngDtlNo(managerDtlVO));
    		
    		managerDtlVO.setHjdongCd(arrHjdongCd[cnt]);
    		managerDtlVO.setHjdongNm(arrHjdongNm[cnt]);
    		managerDtlVO.setCreater("");
    		managerDtlVO.setUpdater("");
    		managerDtlVO.setManagerId(request.getParameter("managerId"));
    		
    		managerService.insertMngDtlApply(managerDtlVO);
    	}
		status.setComplete();
        return cmmUseService.redirectMsg(model, "수정이 완료되었습니다.", "/mng/selectMngList.do");
	}
	
	/**
	 * updatePwdView
	 * @param SearchVO
	 * @return "/mng/pwdUpdate"
	 * @exception Exception
	 */
    @RequestMapping("/mng/updatePwdView.do")
    public String updatePwdView(
            @ModelAttribute("searchVO") SearchVO searchVO
            , HttpServletRequest request
            , HttpSession session
            , Model model)
            throws Exception {
        log.debug("# Controller - updatePwdView START!");
        session.setAttribute("menu", "updatePwdView");
        
        return "/mng/pwdUpdate";
    }
	
}
