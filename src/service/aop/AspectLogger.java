package service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.Advised;
import org.springframework.stereotype.Component;

//����һ������
@Component
@Aspect
public class AspectLogger {
	
	//����һ�����˵�
	//execution ƥ��    (* service.*.*(..))-- (�κη�������,service���µ��κ���,�κη������κ����͵Ĳ���)
	private static final String pointCut = "execution(* service.*.*(..))";
	//һ��aspect��������Զ������е�
	private static final String pointCut2 = "execution(* web.emp.*.*(..))";
	
	@Before(pointCut)
	public void beforeMethod(){
		System.out.println("ִ��ǰ�÷���");
	}
	
	@Before(pointCut)
	public void afterMethod(){
		System.out.println("ִ�к��÷���");
	}
	
	@Around(pointCut)
	public Object AroundMethod(ProceedingJoinPoint joinPoint){
		System.out.println("����ǰ����");
		//�õ���������󷽷�ִ������Ĳ���
		Object[] args = joinPoint.getArgs();
		Object obj = joinPoint.getTarget(); //�����������
		Object object = null;
		try {
			object = joinPoint.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("���ƺ����");
		return object;
	}
	
	@Before(pointCut2)
	public void before(){
		System.out.println("heheheh");
	}
	
}
