package egovframework.WASTE.wst.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.WASTE.cmmn.service.SearchVO;
import egovframework.WASTE.hjd.service.HjdongVO;
import egovframework.WASTE.wst.service.WasteSpecVO;
import egovframework.WASTE.wst.service.WasteVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**  
 * @Class Name : WasteDAO.java
 * @Description : WasteDAO Class
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

@Repository("wasteDAO")
public class WasteDAO extends EgovAbstractDAO {
	
	/**
	 * selectWasteList
	 * @param WasteVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectWasteList(WasteVO wasteVO) throws Exception {
        return list("wasteDAO.selectWasteList", wasteVO);
    }
    
    /**
	 * selectWasteListTotCnt
	 * @param WasteVO
	 * @return int
	 * @exception
	 */
    public int selectWasteListTotCnt(WasteVO wasteVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("wasteDAO.selectWasteListTotCnt", wasteVO);
    }
    
    /**
	 * selectWasteItemList
	 * @param WasteVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectWasteItemList(WasteVO wasteVO) throws Exception {
        return list("wasteDAO.selectWasteItemList", wasteVO);
    }
    
    /**
	 * insertWasteApply
	 * @param WasteVO
	 * @return String
	 * @exception Exception
	 */
    public String insertWasteApply(WasteVO wasteVO) throws Exception {
        return (String)insert("wasteDAO.insertWasteApply", wasteVO);
    }
    
    /**
	 * insertWasteSpec
	 * @param WasteSpecVO
	 * @return String
	 * @exception Exception
	 */
    public String insertWasteSpec(WasteSpecVO wasteSpecVO) throws Exception {
        return (String)insert("wasteDAO.insertWasteSpec", wasteSpecVO);
    }
    
    /**
	 * selectWasteApplyNo
	 * @param WasteVO
	 * @return int
	 * @exception
	 */
    public int selectWasteApplyNo(WasteVO wasteVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("wasteDAO.selectWasteApplyNo", wasteVO);
    }
    
    /**
	 * selectWasteApplyOid
	 * @param WasteVO
	 * @return int
	 * @exception
	 */
    public int selectWasteApplyOid(WasteVO wasteVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("wasteDAO.selectWasteApplyOid", wasteVO);
    }
    
    /**
	 * selectReqHjdong
	 * @param vo - HjdongVO
	 * @return HjdongVO
	 * @exception Exception
	 */
	public HjdongVO selectReqHjdong(HjdongVO hjdongVO) throws Exception {
        return (HjdongVO)getSqlMapClientTemplate().queryForObject("wasteDAO.selectReqHjdong", hjdongVO);
        
    }
	
	/**
	 * selectWasteApplyDtl
	 * @param vo - WasteVO
	 * @return WasteVO
	 * @exception Exception
	 */
	public WasteVO selectWasteApplyDtl(WasteVO wasteVO) throws Exception {
        return (WasteVO)getSqlMapClientTemplate().queryForObject("wasteDAO.selectWasteApplyDtl", wasteVO);
        
    }
	
	/**
	 * selectWasteSpecList
	 * @param WasteSpecVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectWasteSpecList(WasteSpecVO wasteSpecVO) throws Exception {
        return list("wasteDAO.selectWasteSpecList", wasteSpecVO);
    }
    
    /**
	 * updateWasteApply
	 * @param WasteVO
	 * @return void
	 * @exception Exception
	 */
    public void updateWasteApply(WasteVO wasteVO) throws Exception {
        update("wasteDAO.updateWasteApply", wasteVO);
    }
    
    /**
	 * deleteWasteApplySpec
	 * @param WasteSpecVO
	 * @return void 
	 * @exception Exception
	 */
    public void deleteWasteApplySpec(WasteSpecVO wasteSpecVO) throws Exception {
        delete("wasteDAO.deleteWasteApplySpec", wasteSpecVO);
    }
    
    /**
	 * deleteWasteApply
	 * @param WasteVO
	 * @return void 
	 * @exception Exception
	 */
    public void deleteWasteApply(WasteVO wasteVO) throws Exception {
        delete("wasteDAO.deleteWasteApply", wasteVO);
    }

}
