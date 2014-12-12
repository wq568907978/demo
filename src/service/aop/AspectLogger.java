package service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.Advised;
import org.springframework.stereotype.Component;

//定义一个切面
@Component
@Aspect
public class AspectLogger {
	
	//定义一个切人点
	//execution 匹配    (* service.*.*(..))-- (任何返回类型,service包下的任何类,任何方法的任何类型的参数)
	private static final String pointCut = "execution(* service.*.*(..))";
	//一个aspect切面类可以定义多个切点
	private static final String pointCut2 = "execution(* web.emp.*.*(..))";
	
	@Before(pointCut)
	public void beforeMethod(){
		System.out.println("执行前置方法");
	}
	
	@Before(pointCut)
	public void afterMethod(){
		System.out.println("执行后置方法");
	}
	
	@Around(pointCut)
	public Object AroundMethod(ProceedingJoinPoint joinPoint){
		System.out.println("环绕前操作");
		//得到被代理对象方法执行所需的参数
		Object[] args = joinPoint.getArgs();
		Object obj = joinPoint.getTarget(); //被代理类对象
		Object object = null;
		try {
			object = joinPoint.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("环绕后操作");
		return object;
	}
	
	@Before(pointCut2)
	public void before(){
		System.out.println("heheheh");
	}
	
}
