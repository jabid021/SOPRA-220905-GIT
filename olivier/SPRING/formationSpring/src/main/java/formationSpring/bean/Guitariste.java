package formationSpring.bean;

public class Guitariste implements Musicien {

	private Instrument instrument;

	@Override
	public void jouer() {
		System.out.println("le guitairste joue de son instrument, " + instrument);
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
