package egovframework.WASTE.spc.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.WASTE.spc.service.SpecVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**  
 * @Class Name : SpecDAO.java
 * @Description : SpecDAO Class
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

@Repository("specDAO")
public class SpecDAO extends EgovAbstractDAO {
	
	/**
	 * selectPopSpecList
	 * @param SpecVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPopSpecList(SpecVO specVO) throws Exception {
        return list("specDAO.selectPopSpecList", specVO);
    }
    
    /**
	 * selectSpecList
	 * @param SpecVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectSpecList(SpecVO specVO) throws Exception {
        return list("specDAO.selectSpecList", specVO);
    }
    public int selectSpecListTotCnt(SpecVO specVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("specDAO.selectSpecListTotCnt", specVO);
    }
    
    /**
	 * insertSpecApply
	 * @param SpecVO
	 * @return String
	 * @exception Exception
	 */
    public String insertSpecApply(SpecVO specVO) throws Exception {
        return (String)insert("specDAO.insertSpecApply", specVO);
    }
    
    /**
	 * selectSpecApplyNo
	 * @param SpecVO
	 * @return int
	 * @exception
	 */
    public int selectSpecApplyNo(SpecVO specVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("specDAO.selectSpecApplyNo", specVO);
    }
    
    /**
	 * selectSpecView
	 * @param SpecVO
	 * @return SpecVO
	 * @exception Exception
	 */
	public SpecVO selectSpecView(SpecVO specVO) throws Exception {
        return (SpecVO)getSqlMapClientTemplate().queryForObject("specDAO.selectSpecView", specVO);
    }
	
	/**
	 * updateSpecApply
	 * @param SpecVO
	 * @return void
	 * @exception Exception
	 */
    public void updateSpecApply(SpecVO specVO) throws Exception {
        update("specDAO.updateSpecApply", specVO);
    }
    
    /**
	 * deleteSpecApply
	 * @param SpecVO
	 * @return void 
	 * @exception Exception
	 */
    public void deleteSpecApply(SpecVO specVO) throws Exception {
        delete("specDAO.deleteSpecApply", specVO);
    }
    
}
