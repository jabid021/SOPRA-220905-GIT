package formationSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationSpring.bean.Musicien;
import formationSpring.config.AppConfig;

public class AppTest {
	public static void main(String[] args) {
		//lancement du context spring
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//spring
		//ctx.getBean(Musicien.class).jouer();
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);
		//fermeture du context
		ctx.close();
	}
}
