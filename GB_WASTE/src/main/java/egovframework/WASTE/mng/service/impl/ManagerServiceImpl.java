package egovframework.WASTE.mng.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.WASTE.cmmn.service.SearchVO;
import egovframework.WASTE.mng.service.ManagerDtlVO;
import egovframework.WASTE.mng.service.ManagerService;
import egovframework.WASTE.mng.service.ManagerVO;
import egovframework.WASTE.spc.service.SpecVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

/**  
 * @Class Name : ManagerServiceImpl.java
 * @Description : ManagerServiceImpl Class
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

@Service("managerService")
public class ManagerServiceImpl extends AbstractServiceImpl implements ManagerService {
	
	/** ManagerDAO */
    @Resource(name="managerDAO")
    private ManagerDAO managerDAO;
    
    /** ID Generation */
    @Resource(name="egovIdGnrService")    
    private EgovIdGnrService egovIdGnrService;

    /**
	 * selectMngList
	 * @param ManagerVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectMngList(ManagerVO managerVO) throws Exception {
        return managerDAO.selectMngList(managerVO);
    }

    /**
	 * selectMngListTotCnt
	 * @param ManagerVO
	 * @return int
	 * @exception Exception
	 */
    public int selectMngListTotCnt(ManagerVO managerVO) {
		return managerDAO.selectMngListTotCnt(managerVO);
	}
    
    /**
	 * selectMngNo
	 * @param ManagerVO
	 * @return int
	 * @exception
	 */
	public int selectMngNo(ManagerVO managerVO) {
		// TODO Auto-generated method stub
		return managerDAO.selectMngNo(managerVO);
	}
	
	/**
	 * selectMngDtlNo
	 * @param ManagerDtlVO
	 * @return int
	 * @exception
	 */
	public int selectMngDtlNo(ManagerDtlVO managerDtlVO) {
		// TODO Auto-generated method stub
		return managerDAO.selectMngDtlNo(managerDtlVO);
	}
	
	/**
	 * insertMngApply
	 * @param ManagerVO
	 * @return String
	 * @exception Exception
	 */
    public String insertMngApply(ManagerVO managerVO) throws Exception {
    	// TODO Auto-generated method stub
        return managerDAO.insertMngApply(managerVO);
    }
    
    /**
	 * insertMngDtlApply
	 * @param ManagerDtlVO
	 * @return String
	 * @exception Exception
	 */
    public String insertMngDtlApply(ManagerDtlVO managerDtlVO) throws Exception {
    	// TODO Auto-generated method stub
        return managerDAO.insertMngDtlApply(managerDtlVO);
    }
    
    /**
	 * selectMngView
	 * @param ManagerVO
	 * @return ManagerVO
	 * @exception
	 */
	public ManagerVO selectMngView(ManagerVO managerVO) throws Exception {
		// TODO Auto-generated method stub
		return managerDAO.selectMngView(managerVO);
	}
	
	/**
	 * selectMngDtlView
	 * @param ManagerDtlVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectMngDtlView(ManagerDtlVO managerDtlVO) throws Exception {
        return managerDAO.selectMngDtlView(managerDtlVO);
    }
    
    /**
	 * selectHjdongList
	 * @param ManagerDtlVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectHjdongList(ManagerDtlVO managerDtlVO) throws Exception {
        return managerDAO.selectHjdongList(managerDtlVO);
    }
    
    /**
	 * deleteMngApply
	 * @param ManagerVO
	 * @return void
	 * @exception Exception
	 */
    public void deleteMngApply(ManagerVO managerVO) throws Exception {
        managerDAO.deleteMngApply(managerVO);
    }
    
    /**
	 * deleteMngDtlApply
	 * @param ManagerDtlVO
	 * @return void
	 * @exception Exception
	 */
    public void deleteMngDtlApply(ManagerDtlVO managerDtlVO) throws Exception {
        managerDAO.deleteMngDtlApply(managerDtlVO);
    }
    
    /**
	 * updateMngApply
	 * @param ManagerVO
	 * @return void
	 * @exception Exception
	 */
    public void updateMngApply(ManagerVO managerVO) throws Exception {
        managerDAO.updateMngApply(managerVO);
    }
    
}
