package org.camelcode.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

	// execution(* example.ExampleService.*(..)) => Exécution de toutes les méthodes de l’interface ExampleService
	//Exécution de toutes les méthodes du package org.camelcode.itf et de ses sous-packages
	//@Pointcut("execution(* org.camelcode.otherstuff..*.*(..))")
	//@Pointcut("execution(* org.camelcode.itf..*.*(..))")
	@Pointcut("execution(* org.camelcode.itf.PageService.*(..))")
	public void businessMethods() { }

	@Around("businessMethods()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {

		long start = System.currentTimeMillis();

		Signature sig = pjp.getSignature();

		System.out.println("Going to call method: " + sig);
		System.out.println("For class: " + pjp.getTarget().getClass());
		System.out.println("Detail: " + sig.getDeclaringType().getName() + " " + sig.getName());
		
		Object [] args = pjp.getArgs();
		for (int i = 0; i < args.length; i++) {
			System.out.println("getArgs => " + args[i]);
		}

		try {
			Object output = pjp.proceed();
			System.out.println("Method execution completed.");
			return output;
		} catch (Exception e) {
			throw e;
		}  finally {
			long elapsedTime = System.currentTimeMillis() - start;
			System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
		}

	}
}