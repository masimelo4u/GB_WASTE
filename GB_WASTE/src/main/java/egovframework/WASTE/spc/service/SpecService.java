package egovframework.WASTE.spc.service;

import java.util.List;

import egovframework.WASTE.wst.service.WasteVO;
import egovframework.example.sample.service.SampleDefaultVO;

/**  
 * @Class Name : SpecService.java
 * @Description : SpecService Class
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
public interface SpecService {
	
	/**
	 * selectPopSpecList
	 * @param SpecVO
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
    List selectPopSpecList(SpecVO specVO) throws Exception;
	
	/**
	 * selectSpecList
	 * @param SpecVO
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
    List selectSpecList(SpecVO specVO) throws Exception;
	
	int selectSpecListTotCnt(SpecVO specVO);
	
	/**
	 * insertSpecApply
	 * @param SpecVO
	 * @return String
	 * @exception Exception
	 */
    String insertSpecApply(SpecVO specVO) throws Exception;
    
    /**
	 * selectSpecApplyNo
	 * @param SpecVO
	 * @return int
	 * @exception
	 */
    int selectSpecApplyNo(SpecVO specVO);
    
    /**
	 * selectSpecView
	 * @param SpecVO
	 * @return SpecVO
	 * @exception Exception
	 */
    SpecVO selectSpecView(SpecVO specVO) throws Exception;
    
    /**
	 * updateSpecApply
	 * @param SpecVO
	 * @return void
	 * @exception Exception
	 */
    void updateSpecApply(SpecVO specVO) throws Exception;
    
    /**
	 * deleteSpecApply
	 * @param SpecVO
	 * @return void
	 * @exception Exception
	 */
    void deleteSpecApply(SpecVO specVO) throws Exception;

}
