package ajc.sopra.formationSpringMvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
//activation des annotations de spring-mvc
@EnableWebMvc
//scan des packages contenant des beans(controller spring)
@ComponentScan({"ajc.sopra.formationSpringMvc.controller","ajc.sopra.formationSpringMvc.restcontroller"})
public class WebConfig implements WebMvcConfigurer{

	//definition d'url accessible directement
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//les urls qui commencent par /assets/nimportequoi on va chercher le fichier directement dans le dossier 
		//webapp du projet 
		//dans le dossier assets
		//sert pour les images,css, js
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	}
	
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		// les views pourront utiliser la jstl
		viewResolver.setViewClass(JstlView.class);
		// prefix à ajouter devant les String renvoyés par les controller
		viewResolver.setPrefix("/WEB-INF/views/");
		// suffic à ajouter apres les String renvoyés par les controller
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
