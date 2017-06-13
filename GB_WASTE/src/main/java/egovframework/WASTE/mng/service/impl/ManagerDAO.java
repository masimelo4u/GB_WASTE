package egovframework.WASTE.mng.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.WASTE.cmmn.service.SearchVO;
import egovframework.WASTE.mng.service.ManagerDtlVO;
import egovframework.WASTE.mng.service.ManagerVO;
import egovframework.WASTE.spc.service.SpecVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**  
 * @Class Name : ManagerDAO.java
 * @Description : ManagerDAO Class
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

@Repository("managerDAO")
public class ManagerDAO extends EgovAbstractDAO {
	
	
	/**
	 * selectMngList
	 * @param ManagerVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectMngList(ManagerVO managerVO) throws Exception {
        return list("managerDAO.selectMngList", managerVO);
    }
    
    /**
	 * selectMngListTotCnt
	 * @param ManagerVO
	 * @return int
	 * @exception Exception
	 */
    public int selectMngListTotCnt(ManagerVO managerVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("managerDAO.selectMngListTotCnt", managerVO);
    }
    
    /**
	 * selectMngNo
	 * @param ManagerVO
	 * @return int
	 * @exception
	 */
    public int selectMngNo(ManagerVO managerVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("managerDAO.selectMngNo", managerVO);
    }
    
    /**
	 * selectMngDtlNo
	 * @param ManagerDtlVO
	 * @return int
	 * @exception
	 */
    public int selectMngDtlNo(ManagerDtlVO managerDtlVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("managerDAO.selectMngDtlNo", managerDtlVO);
    }
    
    /**
	 * insertMngApply
	 * @param ManagerVO
	 * @return String
	 * @exception Exception
	 */
    public String insertMngApply(ManagerVO managerVO) throws Exception {
        return (String)insert("managerDAO.insertMngApply", managerVO);
    }
    
    /**
	 * insertMngDtlApply
	 * @param ManagerDtlVO
	 * @return String
	 * @exception Exception
	 */
    public String insertMngDtlApply(ManagerDtlVO managerDtlVO) throws Exception {
        return (String)insert("managerDAO.insertMngDtlApply", managerDtlVO);
    }
    
    /**
	 * selectMngView
	 * @param ManagerVO
	 * @return ManagerVO
	 * @exception Exception
	 */
	public ManagerVO selectMngView(ManagerVO managerVO) throws Exception {
        return (ManagerVO)getSqlMapClientTemplate().queryForObject("managerDAO.selectMngView", managerVO);
    }
	
	/**
	 * selectMngDtlView
	 * @param ManagerDtlVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectMngDtlView(ManagerDtlVO managerDtlVO) throws Exception {
        return list("managerDAO.selectMngDtlView", managerDtlVO);
    }
    
    /**
	 * selectHjdongList
	 * @param ManagerDtlVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectHjdongList(ManagerDtlVO managerDtlVO) throws Exception {
        return list("managerDAO.selectHjdongList", managerDtlVO);
    }
    
    /**
	 * deleteMngApply
	 * @param ManagerVO
	 * @return void 
	 * @exception Exception
	 */
    public void deleteMngApply(ManagerVO managerVO) throws Exception {
        delete("managerDAO.deleteMngApply", managerVO);
    }
    
    /**
	 * deleteMngDtlApply
	 * @param ManagerDtlVO
	 * @return void 
	 * @exception Exception
	 */
    public void deleteMngDtlApply(ManagerDtlVO managerDtlVO) throws Exception {
        delete("managerDAO.deleteMngDtlApply", managerDtlVO);
    }
    
    /**
	 * updateMngApply
	 * @param ManagerVO
	 * @return void
	 * @exception Exception
	 */
    public void updateMngApply(ManagerVO managerVO) throws Exception {
        update("managerDAO.updateMngApply", managerVO);
    }

}
