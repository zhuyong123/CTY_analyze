package com.dev.cty.controller;   
  
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.cty.service.UserService;
  
@Controller  
@RequestMapping("/BasicInfo.do")   
public class BasicInfoController extends BaseController{   
    protected final transient Log log = LogFactory.getLog(BasicInfoController.class);   
    @Autowired  
    private UserService userService;   
    
    @RequestMapping(params = "method=getChargesStandard")
    public String getChargesStandard(HttpServletRequest request,ModelMap modelMap){
		return null;
    	
    }
    
    
}