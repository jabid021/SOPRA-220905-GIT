package formationSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import formationSpring.bean.Guitare;
import formationSpring.bean.Guitariste;
import formationSpring.bean.Instrument;
import formationSpring.bean.Musicien;
import formationSpring.bean.Pianiste;

@Configuration
public class AppConfig {

	@Bean
	public Musicien musicien(Instrument instrument) {
		Pianiste musicien = new Pianiste();
		musicien.setInstrument(instrument);
		return musicien;
	}

	@Bean
	public Instrument instrument() {
		return new Guitare();
	}
}
