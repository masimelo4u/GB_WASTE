package egovframework.WASTE.wst.service;

import java.util.List;

import egovframework.WASTE.cmmn.service.SearchVO;
import egovframework.WASTE.hjd.service.HjdongVO;
import egovframework.example.sample.service.SampleVO;

/**  
 * @Class Name : WasteService.java
 * @Description : WasteService Class
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
public interface WasteService {
	
	/**
	 * selectWasteList
	 * @param WasteVO
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
    List selectWasteList(WasteVO wasteVO) throws Exception;
	
	/**
	 * selectWasteListTotCnt
	 * @param WasteVO
	 * @return int
	 * @exception
	 */
    int selectWasteListTotCnt(WasteVO wasteVO);
    
    /**
	 * selectWasteItemList
	 * @param WasteVO
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
    List selectWasteItemList(WasteVO wasteVO) throws Exception;
	
	/**
	 * insertWasteApply
	 * @param WasteVO
	 * @return String
	 * @exception Exception
	 */
    String insertWasteApply(WasteVO wasteVO) throws Exception;
    
    /**
	 * insertWasteSpec
	 * @param WasteSpecVO
	 * @return String
	 * @exception Exception
	 */
    String insertWasteSpec(WasteSpecVO wasteSpecVO) throws Exception;
    
    /**
	 * selectWasteApplyNo
	 * @param WasteVO
	 * @return int
	 * @exception
	 */
    int selectWasteApplyNo(WasteVO wasteVO);
    
    /**
	 * selectWasteApplyOid
	 * @param WasteVO
	 * @return OID
	 * @exception
	 */
    int selectWasteApplyOid(WasteVO wasteVO);
    
    /**
	 * selectReqHjdong
	 * @param HjdongVO
	 * @return HjdongVO
	 * @exception Exception
	 */
    HjdongVO selectReqHjdong(HjdongVO hjdongVO) throws Exception;
    
    /**
	 * selectWasteApplyDtl
	 * @param WasteVO
	 * @return WasteVO
	 * @exception Exception
	 */
    WasteVO selectWasteApplyDtl(WasteVO wasteVO) throws Exception;
    
    /**
	 * selectWasteSpecList
	 * @param wasteSpecVO
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
    List selectWasteSpecList(WasteSpecVO wasteSpecVO) throws Exception;
	
	/**
	 * updateWasteApply
	 * @param WasteVO
	 * @return void
	 * @exception Exception
	 */
    void updateWasteApply(WasteVO wasteVO) throws Exception;
    
    /**
	 * deleteWasteApplySpec
	 * @param wasteSpecVO
	 * @return void
	 * @exception Exception
	 */
    void deleteWasteApplySpec(WasteSpecVO wasteSpecVO) throws Exception;
    
    /**
	 * deleteWasteApply
	 * @param WasteVO
	 * @return void
	 * @exception Exception
	 */
    void deleteWasteApply(WasteVO wasteVO) throws Exception;

}
