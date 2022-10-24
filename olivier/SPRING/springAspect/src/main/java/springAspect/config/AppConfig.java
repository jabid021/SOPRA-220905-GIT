package springAspect.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"springAspect.dao","springAspect.aspect"})
//permet activation de l'annotation @Aspect
@EnableAspectJAutoProxy
public class AppConfig {

}
