package egovframework.WASTE.mng.service;

import java.util.List;

import egovframework.WASTE.cmmn.service.SearchVO;
import egovframework.WASTE.spc.service.SpecVO;

/**  
 * @Class Name : ManagerService.java
 * @Description : ManagerService Class
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

public interface ManagerService {
	
	/**
	 * selectMngList
	 * @param ManagerVO
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
    List selectMngList(ManagerVO managerVO) throws Exception;
    
	/**
	 * selectMngListTotCnt
	 * @param ManagerVO
	 * @return int
	 * @exception
	 */
    int selectMngListTotCnt(ManagerVO managerVO);
    
    /**
	 * selectMngNo
	 * @param ManagerVO
	 * @return int
	 * @exception
	 */
    int selectMngNo(ManagerVO managerVO);
    
    /**
	 * selectMngDtlNo
	 * @param ManagerDtlVO
	 * @return int
	 * @exception
	 */
    int selectMngDtlNo(ManagerDtlVO managerDtlVO);
    
    /**
	 * insertMngApply
	 * @param ManagerVO
	 * @return String
	 * @exception Exception
	 */
    String insertMngApply(ManagerVO managerVO) throws Exception;
    
    /**
	 * insertMngDtlApply
	 * @param ManagerDtlVO
	 * @return String
	 * @exception Exception
	 */
    String insertMngDtlApply(ManagerDtlVO managerDtlVO) throws Exception;
    
    /**
	 * selectMngView
	 * @param ManagerVO
	 * @return ManagerVO
	 * @exception Exception
	 */
    ManagerVO selectMngView(ManagerVO managerVO) throws Exception;
    
    /**
	 * selectMngDtlView
	 * @param ManagerDtlVO
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
    List selectMngDtlView(ManagerDtlVO managerDtlVO) throws Exception;
	
	/**
	 * selectHjdongList
	 * @param ManagerDtlVO
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
    List selectHjdongList(ManagerDtlVO managerDtlVO) throws Exception;
	
	/**
	 * deleteMngApply
	 * @param ManagerVO
	 * @return void
	 * @exception Exception
	 */
    void deleteMngApply(ManagerVO managerVO) throws Exception;
    
    /**
	 * deleteMngDtlApply
	 * @param ManagerDtlVO
	 * @return void
	 * @exception Exception
	 */
    void deleteMngDtlApply(ManagerDtlVO managerDtlVO) throws Exception;
    
    /**
	 * updateMngApply
	 * @param ManagerVO
	 * @return void
	 * @exception Exception
	 */
    void updateMngApply(ManagerVO managerVO) throws Exception;

}
