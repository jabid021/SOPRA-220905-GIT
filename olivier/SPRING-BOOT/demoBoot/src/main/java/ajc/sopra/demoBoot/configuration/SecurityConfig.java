package ajc.sopra.demoBoot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//configuration de la securite
//"ancienne version"
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//definir les regles sur les url
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/**") //urls concernaient par ma regle /**=>toutes les urls
			.csrf().disable()  //csrf à couper par simplicite
			.authorizeRequests() //definition les regles
				.antMatchers("/home").permitAll() // /home accessible à tout le monde
				.antMatchers("/admin/**").hasRole("ADMIN") // /admin avec n'importe quoi derriere accessible au utlisateur autentifié avec un role ADMIN
				.antMatchers("/inscription").anonymous() //utilisateur non autentifie
				.anyRequest().authenticated() //anyRequest à mettre en dernier toute les urls non traitées =>autentification
			.and()
				.formLogin(); //comment on va s'autentifier =>formulaire
				//pas de conf donc formulaire par defaut de spring
		// @formatter:on
	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
