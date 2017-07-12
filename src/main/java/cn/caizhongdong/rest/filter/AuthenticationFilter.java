package cn.caizhongdong.rest.filter;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.ext.Provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 身份验证  
 **/
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter{
	private static final Log log = LogFactory.getLog(AuthenticationFilter.class);


	@Override
	public void filter(ContainerRequestContext containerRequestContext) {
		String accessToken = containerRequestContext.getHeaderString("accessToken");
		if(accessToken == null){
			//尝试从cookie获取
			Cookie cookie = containerRequestContext.getCookies().get("accessToken");
            if(cookie!=null){
	            accessToken = cookie.getValue();
            }
		}
		if(log.isTraceEnabled()){
			log.trace("access token is " + accessToken);
		}
		
		if (accessToken != null && accessToken.trim().length() > 0) {


		}
	}
}
