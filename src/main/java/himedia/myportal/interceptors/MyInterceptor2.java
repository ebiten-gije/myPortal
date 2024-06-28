package himedia.myportal.interceptors;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyInterceptor2 implements HandlerInterceptor{
	
	Logger logger = LoggerFactory.getLogger(MyInterceptor2.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("myInterceptor2::preHandle");
		
		return true;
//		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("myInterceptor2::postHandle");
		
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("myInterceptor2::afterCompletion");
		
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
