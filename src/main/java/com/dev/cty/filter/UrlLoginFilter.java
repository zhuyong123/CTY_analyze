
package com.dev.cty.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dev.cty.entity.MobileUser;
import com.dev.cty.utils.SessionUtils;
/**
 * @author 
 * @description
 * @reviewed_by
 */
public class UrlLoginFilter implements Filter {
    private static Log log = LogFactory.getLog(UrlLoginFilter.class);
    private static String[] writeUrls= new String[]{"login.do"}; 
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    		throws IOException, ServletException{
        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpServletResponse hresponse = (HttpServletResponse) response;
        MobileUser user = (MobileUser) hrequest.getSession().getAttribute(SessionUtils.SNAPMATCH_SESSION_NAME);
        String url = hrequest.getRequestURI();
        if(user!=null || isWriteUrl(url)){
        	chain.doFilter(hrequest, hresponse);
        }else{
        	((HttpServletResponse)response).sendRedirect("./login.jsp");
        }
    }

    public void init(FilterConfig arg0) throws ServletException {

    }
    
    public void destroy() {

    }
    
    private boolean isWriteUrl(String url){
    	for(String wirteUrl : writeUrls){
    		if(url.contains(wirteUrl)){
    			return true;
    		}
    	}
    	return false;
    }

    public Map<String,String> getParameterMap(String url) {
        String[] arr = url.split("&");
        Map<String,String> map_param = new HashMap<String,String>();
        String mapKey = "";
        String mapValue = "";
        for (int i = 0; i < arr.length; i++) {
            mapKey = arr[i].substring(0, arr[i].indexOf("="));
            mapValue = arr[i].substring(arr[i].indexOf("=") + 1, arr[i].length());
            map_param.put(mapKey, mapValue);
        }
        return map_param;
    }

}
