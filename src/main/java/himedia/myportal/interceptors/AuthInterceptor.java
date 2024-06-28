package himedia.myportal.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import himedia.myportal.services.UserService;
import himedia.myportal.services.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Override
	//	메서드 핸들러 작동 이전
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("AuthInterceptor");
		//	사용자가 로그인한 사용자?
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		UserService userService = context.getBean(UserServiceImpl.class);
		
		if (userService.isAuthenticated(request)) {
			logger.debug("인증된 사용자");
			return true;
		} else {
			logger.debug("인증되지 않은 사욧ㅇ자");
//			로그인 페이지로 리다이렉트
			response.sendRedirect(request.getContextPath() + "/users/login");
			return false;
		}
//		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}
