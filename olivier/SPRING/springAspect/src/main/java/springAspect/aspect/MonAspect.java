package springAspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import springAspect.model.Produit;

//classe qui contient le code à greffer quelque part
@Component
@Aspect
public class MonAspect {

	@Pointcut("execution(* springAspect.dao.ProduitDao.save(..))")
	public void methodeAIntercepter() {
		
	}
	
	//execution de la methode avant l'execution d'une autre methode
	@Before("methodeAIntercepter()")
	public void beforeSave(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget());
		System.out.println("avant save");
	}
	
	@After("methodeAIntercepter()")
	public void afterSave() {
		System.out.println("apres save");
	}
	
	@AfterReturning(pointcut = "methodeAIntercepter()",returning = "result")
	public void afterReturning(Produit result) {
		System.out.println("execution ok, id generé:"+result.getId());
	}
	
	@AfterThrowing(pointcut = "methodeAIntercepter()")
	public void afterThrowing() {
		System.out.println("exception");
	}
	
	@Around("methodeAIntercepter()")
	public Produit around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("execution around");
		Produit produit=(Produit)proceedingJoinPoint.proceed();
		System.out.println("apres proceed");
		return produit;
	}
}
