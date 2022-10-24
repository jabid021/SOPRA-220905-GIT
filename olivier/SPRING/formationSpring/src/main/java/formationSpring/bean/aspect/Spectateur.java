package formationSpring.bean.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Spectateur {

	@Pointcut("execution(* formationSpring.bean.Musicien.jouer())")
	public void intercept() {
		
	}
	
	@Before("intercept()")
	public void installation() {
		System.out.println("le public s'installe");
	}
	
	@AfterReturning(pointcut = "intercept()")
	public void applaudir() {
		System.out.println("le public applaudit");
	}
	
	@AfterThrowing(pointcut = "intercept()")
	public void siffler() {
		System.out.println("le public siffle");
	}
	
	@After("intercept()")
	public void partir() {
		System.out.println("le public part");
	}
}
