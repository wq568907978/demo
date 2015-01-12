package web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionExpireInterceptor extends HandlerInterceptorAdapter{
	
	/**
	 * controller���� ,ִ��ǰ����
	 * */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("session�ѹ���1");
		return super.preHandle(request, response, handler);
	}
	
	/**
	 * controller���� ,ִ�к�,��ͼ����ǰ,����
	 * */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("session�ѹ���2");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	/**
	 * ��ͼ������,����
	 * */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("session�ѹ���3");
		super.afterCompletion(request, response, handler, ex);
	}
	
}
