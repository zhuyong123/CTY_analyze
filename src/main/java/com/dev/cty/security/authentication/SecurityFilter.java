package com.dev.cty.security.authentication;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dev.cty.entity.MobileUser;
import com.dev.cty.service.PropertyService;
import com.dev.cty.service.UserService;
import com.dev.cty.type.ErrorType;
import com.dev.cty.utils.KeyUtils;
import com.dev.cty.utils.SessionUtils;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {

	public static final String API_SECURITY_KEY = "session";
	
	private PropertyService propertyService;
	private UserService userService;
	private StringRedisTemplate redisTemplate;
	
    /**
     * Default constructor. 
     */
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Boolean flag = false;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		String session = req.getParameter(API_SECURITY_KEY);
		String url = req.getRequestURI();
		
		if(StringUtils.isEmpty(session)){
			String notValidateUrls= propertyService.getProperty("snapmatch.whitelist.url", "");
			if(StringUtils.isNotEmpty(notValidateUrls)){
				String urls[] = notValidateUrls.split(",");
				for(String urlTemp : urls){
					if(url.contains(urlTemp)){
						flag = true;
						break;
					}
				}
			}
			if(!flag){
				writeMsg(res);
				return;
			}
		}else{
//			String[] tokens = SessionUtils.decodeSession(session);
//			String id = StringUtils.lowerCase(tokens[0]);
//			String account = tokens[1];
//			if(!account.equals(getAuthByRedis(id))){
//				MobileUser user = new MobileUser();
//				user.setAccount(account);
//				user = userService.getByAccount(user);
//				if(user == null){
//					writeMsg(res);
//					return;
//				}else{
//					saveAuthToRedis(user.getId(),user.getAccount());
//				}
//			}
		}		
		chain.doFilter(request, response);
	}
	
	public String getAuthByRedis(String id){
		BoundHashOperations<String, String, String> hashOps = redisTemplate.boundHashOps(KeyUtils.getRequestPermission());
		String account = hashOps.get(id);
		return account;
	}
	
	public void saveAuthToRedis(Long id,String account){
		BoundHashOperations<String, String, String> hashOps = redisTemplate.boundHashOps(KeyUtils.getRequestPermission());
		hashOps.put(String.valueOf(id),account);
		Calendar expireData = Calendar.getInstance();
		expireData.add(Calendar.DAY_OF_MONTH, 1);
		redisTemplate.expireAt(KeyUtils.getRequestPermission(), expireData.getTime());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	   ServletContext  servletContext  = fConfig.getServletContext();
	   WebApplicationContext web = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	   propertyService = (PropertyService) web.getBean("propertyService");
	   userService = (UserService) web.getBean("userService");
	   redisTemplate = (StringRedisTemplate) web.getBean("stringRedisTemplate");
	}
	
	public void writeMsg(HttpServletResponse res) throws IOException{
		Map<String, Object> model = new TreeMap<String, Object>();
		model.put("errCode", ErrorType.ILLEGAL_REQUEST.value());
		model.put("errMsg", ErrorType.ILLEGAL_REQUEST);
		res.setHeader("Content-Type", "application/json;charset=utf-8");
		res.setStatus(HttpStatus.BAD_REQUEST.value());
		try {
			res.getWriter().print(JSONObject.fromObject(model));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			res.getWriter().close();
		}
	}
}
