package web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionExpireInterceptor extends HandlerInterceptorAdapter{
	
	/**
	 * controller方法 ,执行前调用
	 * */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("session已过期1");
		return super.preHandle(request, response, handler);
	}
	
	/**
	 * controller方法 ,执行后,视图解析前,调用
	 * */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("session已过期2");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	/**
	 * 视图解析后,调用
	 * */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("session已过期3");
		super.afterCompletion(request, response, handler, ex);
	}
	
}
