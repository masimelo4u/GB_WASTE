package egovframework.WASTE.hjd.service;

import java.util.List;

import egovframework.WASTE.mng.service.ManagerVO;
import egovframework.WASTE.spc.service.SpecVO;

/**  
 * @Class Name : HjdongService.java
 * @Description : HjdongService Class
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
public interface HjdongService {
	
	/**
	 * selectSpecList
	 * @param SpecVO
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
    List selectHjdongList(HjdongVO hjdongVO) throws Exception;
	
	int selectHjdongListTotCnt(HjdongVO hjdongVO);
	
	/**
	 * selectHjdongNo
	 * @param HjdongVO
	 * @return int
	 * @exception
	 */
    int selectHjdongNo(HjdongVO hjdongVO);
    
    /**
	 * insertHjdongApply
	 * @param HjdongVO
	 * @return String
	 * @exception Exception
	 */
    String insertHjdongApply(HjdongVO hjdongVO) throws Exception;
    
    /**
	 * selectHjdongView
	 * @param HjdongVO
	 * @return HjdongVO
	 * @exception Exception
	 */
    HjdongVO selectHjdongView(HjdongVO hjdongVO) throws Exception;
    
    /**
	 * updateHjdongApply
	 * @param HjdongVO
	 * @return void
	 * @exception Exception
	 */
    void updateHjdongApply(HjdongVO hjdongVO) throws Exception;
    
    /**
	 * deleteHjdongApply
	 * @param HjdongVO
	 * @return void
	 * @exception Exception
	 */
    void deleteHjdongApply(HjdongVO hjdongVO) throws Exception;

}
