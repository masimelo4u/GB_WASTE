package egovframework.WASTE.wst.service.impl;

import java.net.InetAddress;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.WASTE.cmmn.DateUtil;
import egovframework.WASTE.cmmn.service.SearchVO;
import egovframework.WASTE.hjd.service.HjdongVO;
import egovframework.WASTE.wst.service.WasteService;
import egovframework.WASTE.wst.service.WasteSpecVO;
import egovframework.WASTE.wst.service.WasteVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

/**  
 * @Class Name : WasteServiceImpl.java
 * @Description : WasteServiceImpl Class
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

@Service("wasteService")
public class WasteServiceImpl extends AbstractServiceImpl implements WasteService {

	/** WasteDAO */
    @Resource(name="wasteDAO")
    private WasteDAO wasteDAO;
    
    /** ID Generation */
    @Resource(name="egovIdGnrService")    
    private EgovIdGnrService egovIdGnrService;

    /**
	 * selectWasteList
	 * @param WasteVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectWasteList(WasteVO wasteVO) throws Exception {
    	// TODO Auto-generated method stub
        return wasteDAO.selectWasteList(wasteVO);
    }

    /**
	 * selectWasteListTotCnt
	 * @param WasteVO
	 * @return int
	 * @exception
	 */
	public int selectWasteListTotCnt(WasteVO wasteVO) {
		// TODO Auto-generated method stub
		return wasteDAO.selectWasteListTotCnt(wasteVO);
	}
	
	/**
	 * selectWasteItemList
	 * @param WasteVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectWasteItemList(WasteVO wasteVO) throws Exception {
    	// TODO Auto-generated method stub
        return wasteDAO.selectWasteItemList(wasteVO);
    }
    
    /**
	 * insertWasteApply
	 * @param WasteVO
	 * @return String
	 * @exception Exception
	 */
    public String insertWasteApply(WasteVO wasteVO) throws Exception {
    	// TODO Auto-generated method stub
        return wasteDAO.insertWasteApply(wasteVO);
    }
    
    /**
	 * insertWasteSpec
	 * @param WasteSpecVO
	 * @return String
	 * @exception Exception
	 */
    public String insertWasteSpec(WasteSpecVO wasteSpecVO) throws Exception {
    	// TODO Auto-generated method stub
        return wasteDAO.insertWasteSpec(wasteSpecVO);
    }
    
    /**
	 * selectWasteApplyNo
	 * @param WasteVO
	 * @return int
	 * @exception
	 */
	public int selectWasteApplyNo(WasteVO wasteVO) {
		// TODO Auto-generated method stub
		return wasteDAO.selectWasteApplyNo(wasteVO);
	}
	
	/**
	 * selectWasteApplyOid
	 * @param WasteVO
	 * @return int
	 * @exception
	 */
	public int selectWasteApplyOid(WasteVO wasteVO) {
		// TODO Auto-generated method stub
		return wasteDAO.selectWasteApplyOid(wasteVO);
	}

	/**
	 * selectReqHjdong
	 * @param HjdongVO
	 * @return HjdongVO
	 * @exception
	 */
	public HjdongVO selectReqHjdong(HjdongVO hjdongVO) throws Exception {
		// TODO Auto-generated method stub
		return wasteDAO.selectReqHjdong(hjdongVO);
	}
	
	/**
	 * selectWasteApplyDtl
	 * @param WasteVO
	 * @return WasteVO
	 * @exception
	 */
	public WasteVO selectWasteApplyDtl(WasteVO wasteVO) throws Exception {
		// TODO Auto-generated method stub
		return wasteDAO.selectWasteApplyDtl(wasteVO);
	}
	
	/**
	 * selectWasteSpecList
	 * @param WasteSpecVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectWasteSpecList(WasteSpecVO wasteSpecVO) throws Exception {
        return wasteDAO.selectWasteSpecList(wasteSpecVO);
    }
    
    /**
	 * updateWasteApply
	 * @param WasteVO
	 * @return void
	 * @exception Exception
	 */
    public void updateWasteApply(WasteVO wasteVO) throws Exception {
        wasteDAO.updateWasteApply(wasteVO);
    }
	
    /**
	 * deleteWasteApplySpec
	 * @param WasteVO
	 * @return void
	 * @exception Exception
	 */
    public void deleteWasteApplySpec(WasteSpecVO wasteSpecVO) throws Exception {
        wasteDAO.deleteWasteApplySpec(wasteSpecVO);
    }
    
    /**
	 * deleteWasteApply
	 * @param WasteVO
	 * @return void
	 * @exception Exception
	 */
    public void deleteWasteApply(WasteVO wasteVO) throws Exception {
        wasteDAO.deleteWasteApply(wasteVO);
    }
}
