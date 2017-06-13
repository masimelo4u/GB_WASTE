package egovframework.WASTE.cmmn.service;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

public interface CmmUseService {

    /**
     * 메시지를 출력하고 해당 URL로 리턴한다.
     * 
     * @param ModelMap, String, String
     * @return String
     * @throws Exception
     */
	String redirect(ModelMap model,String url) throws Exception;
	
    /**
     * 메시지를 출력하고 해당 URL로 리턴한다.
     * 
     * @param ModelMap, String, String
     * @return String
     * @throws Exception
     */
	String redirectMsg(Model model, String msg, String url) throws Exception;
	
	/**
	 * 메시지를 출력하고 history.back 한다.
	 * @param model
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	String backMsg(ModelMap model, String msg) throws Exception;
	
    /**
     * 메시지를 출력하고 부모창의 URL을 해당 URL로 리턴한다.
     * 
     * @param ModelMap, String, String
     * @return String
     * @throws Exception
     */
	String popupRedirectMsg(ModelMap model, String msg, String url) throws Exception;
}
