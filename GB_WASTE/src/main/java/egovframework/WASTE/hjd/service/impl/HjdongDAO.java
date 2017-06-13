package egovframework.WASTE.hjd.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.WASTE.hjd.service.HjdongVO;
import egovframework.WASTE.mng.service.ManagerVO;
import egovframework.WASTE.spc.service.SpecVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**  
 * @Class Name : HjdongDAO.java
 * @Description : HjdongDAO Class
 * @Modification Information  
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017.06.12   미키    최초생성
 * 
 * @author 미키
 * @since 2017.06.12
 * @version 1.0
 * @see
 * 
 * @ Copyright (C) by 미키 All right reserved.
 */
@Repository("hjdongDAO")
public class HjdongDAO extends EgovAbstractDAO {

	/**
	 * selectHjdongList
	 * @param HjdongVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectHjdongList(HjdongVO hjdongVO) throws Exception {
        return list("hjdongDAO.selectHjdongList", hjdongVO);
    }
    public int selectHjdongListTotCnt(HjdongVO hjdongVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("hjdongDAO.selectHjdongListTotCnt", hjdongVO);
    }
    
    /**
	 * selectHjdongNo
	 * @param HjdongVO
	 * @return int
	 * @exception
	 */
    public int selectHjdongNo(HjdongVO hjdongVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("hjdongDAO.selectHjdongNo", hjdongVO);
    }
    
    /**
	 * insertHjdongApply
	 * @param HjdongVO
	 * @return String
	 * @exception Exception
	 */
    public String insertHjdongApply(HjdongVO hjdongVO) throws Exception {
        return (String)insert("hjdongDAO.insertHjdongApply", hjdongVO);
    }
    
    /**
	 * selectHjdongView
	 * @param HjdongVO
	 * @return HjdongVO
	 * @exception Exception
	 */
	public HjdongVO selectHjdongView(HjdongVO hjdongVO) throws Exception {
        return (HjdongVO)getSqlMapClientTemplate().queryForObject("hjdongDAO.selectHjdongView", hjdongVO);
    }
	
	/**
	 * updateHjdongApply
	 * @param HjdongVO
	 * @return void
	 * @exception Exception
	 */
    public void updateHjdongApply(HjdongVO hjdongVO) throws Exception {
        update("hjdongDAO.updateHjdongApply", hjdongVO);
    }
    
    /**
	 * deleteHjdongApply
	 * @param HjdongVO
	 * @return void 
	 * @exception Exception
	 */
    public void deleteHjdongApply(HjdongVO hjdongVO) throws Exception {
        delete("hjdongDAO.deleteHjdongApply", hjdongVO);
    }
    
    
}
