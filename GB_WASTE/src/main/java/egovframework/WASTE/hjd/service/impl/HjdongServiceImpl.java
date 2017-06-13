package egovframework.WASTE.hjd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.WASTE.hjd.service.HjdongService;
import egovframework.WASTE.hjd.service.HjdongVO;
import egovframework.WASTE.mng.service.ManagerVO;
import egovframework.WASTE.spc.service.SpecVO;
import egovframework.WASTE.spc.service.impl.SpecDAO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

/**  
 * @Class Name : HjdongServiceImpl.java
 * @Description : HjdongServiceImpl Class
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
@Service("hjdongService")
public class HjdongServiceImpl extends AbstractServiceImpl implements HjdongService {

	/** HjdongDAO */
    @Resource(name="hjdongDAO")
    private HjdongDAO hjdongDAO;
    
    /** ID Generation */
    @Resource(name="egovIdGnrService")    
    private EgovIdGnrService egovIdGnrService;
    
    /**
	 * selectSpecList
	 * @param SpecVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectHjdongList(HjdongVO hjdongVO) throws Exception {
        return hjdongDAO.selectHjdongList(hjdongVO);
    }
    public int selectHjdongListTotCnt(HjdongVO hjdongVO) {
		return hjdongDAO.selectHjdongListTotCnt(hjdongVO);
	}
    
    /**
	 * selectHjdongNo
	 * @param HjdongVO
	 * @return int
	 * @exception
	 */
	public int selectHjdongNo(HjdongVO hjdongVO) {
		// TODO Auto-generated method stub
		return hjdongDAO.selectHjdongNo(hjdongVO);
	}
	
	/**
	 * insertHjdongApply
	 * @param HjdongVO
	 * @return String
	 * @exception Exception
	 */
    public String insertHjdongApply(HjdongVO hjdongVO) throws Exception {
    	// TODO Auto-generated method stub
        return hjdongDAO.insertHjdongApply(hjdongVO);
    }
    
    /**
	 * selectHjdongView
	 * @param HjdongVO
	 * @return HjdongVO
	 * @exception
	 */
	public HjdongVO selectHjdongView(HjdongVO hjdongVO) throws Exception {
		// TODO Auto-generated method stub
		return hjdongDAO.selectHjdongView(hjdongVO);
	}
	
	/**
	 * updateHjdongApply
	 * @param HjdongVO
	 * @return void
	 * @exception Exception
	 */
    public void updateHjdongApply(HjdongVO hjdongVO) throws Exception {
        hjdongDAO.updateHjdongApply(hjdongVO);
    }
    
    /**
	 * deleteHjdongApply
	 * @param HjdongVO
	 * @return void
	 * @exception Exception
	 */
    public void deleteHjdongApply(HjdongVO hjdongVO) throws Exception {
    	hjdongDAO.deleteHjdongApply(hjdongVO);
    }
    
}
