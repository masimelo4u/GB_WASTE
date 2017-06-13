package egovframework.WASTE.cmmn.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import egovframework.WASTE.cmmn.service.CmmUseService;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("cmmUseService")
public class CmmUseServiceImpl extends AbstractServiceImpl implements CmmUseService {

	public String redirect(ModelMap model, String url) throws Exception {
		
		model.addAttribute("url", url);
		
		return "/cmmn/redirect";
		
	}
	public String redirectMsg(Model model, String msg, String url) throws Exception {
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "/cmmn/redirectMsg";
		
	}
	
	public String backMsg(ModelMap model, String msg) throws Exception {
		
		model.addAttribute("msg", msg);
		
		return "/cmmn/backMsg";
		
	}

	@Override
	public String popupRedirectMsg(ModelMap model, String msg, String url) throws Exception {
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "/cmmn/popupRedirectMsg";
	}
	
}
