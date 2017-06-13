package egovframework.WASTE.spc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.WASTE.spc.service.SpecService;
import egovframework.WASTE.spc.service.SpecVO;
import egovframework.WASTE.wst.service.WasteVO;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

/**  
 * @Class Name : SpecServiceImpl.java
 * @Description : SpecServiceImpl Class
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

@Service("specService")
public class SpecServiceImpl extends AbstractServiceImpl implements SpecService {

	/** SpecDAO */
    @Resource(name="specDAO")
    private SpecDAO specDAO;
    
    /** ID Generation */
    @Resource(name="egovIdGnrService")    
    private EgovIdGnrService egovIdGnrService;

    /**
	 * selectPopSpecList
	 * @param SpecVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPopSpecList(SpecVO specVO) throws Exception {
        return specDAO.selectPopSpecList(specVO);
    }
    
    /**
	 * selectSpecList
	 * @param SpecVO
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectSpecList(SpecVO specVO) throws Exception {
        return specDAO.selectSpecList(specVO);
    }
    public int selectSpecListTotCnt(SpecVO specVO) {
		return specDAO.selectSpecListTotCnt(specVO);
	}
    
    /**
	 * insertSpecApply
	 * @param SpecVO
	 * @return String
	 * @exception Exception
	 */
    public String insertSpecApply(SpecVO specVO) throws Exception {
    	// TODO Auto-generated method stub
        return specDAO.insertSpecApply(specVO);
    }
    
    /**
	 * selectSpecApplyNo
	 * @param SpecVO
	 * @return int
	 * @exception
	 */
	public int selectSpecApplyNo(SpecVO specVO) {
		// TODO Auto-generated method stub
		return specDAO.selectSpecApplyNo(specVO);
	}
	
	/**
	 * selectSpecView
	 * @param SpecVO
	 * @return SpecVO
	 * @exception
	 */
	public SpecVO selectSpecView(SpecVO specVO) throws Exception {
		// TODO Auto-generated method stub
		return specDAO.selectSpecView(specVO);
	}
	
	/**
	 * updateSpecApply
	 * @param SpecVO
	 * @return void
	 * @exception Exception
	 */
    public void updateSpecApply(SpecVO specVO) throws Exception {
        specDAO.updateSpecApply(specVO);
    }
    
    /**
	 * deleteSpecApply
	 * @param SpecVO
	 * @return void
	 * @exception Exception
	 */
    public void deleteSpecApply(SpecVO specVO) throws Exception {
        specDAO.deleteSpecApply(specVO);
    }
	
}
