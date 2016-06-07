package com.dev.cty.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {
	
	
	/** The remote addr. */
	private String remoteAddr;

	/**
	 * Inits the binder.
	 * 
	 * @param binder the binder
	 * @param request the request
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) {
		remoteAddr = request.getRemoteAddr();
	}

	/**
	 * Gets the remote addr.
	 * 
	 * @return the remote addr
	 */
	public String getRemoteAddr() {
		return remoteAddr;
	}
	
	 public String sendMessages(HttpServletResponse response, Object json)
	    		throws Exception {
	    		response.setContentType("application/json");
	    		response.setContentType("text/json; charset=utf-8");
	    		response.setCharacterEncoding("UTF-8");
	    		response.getWriter().print(json);
	    		return null;
		}
}
