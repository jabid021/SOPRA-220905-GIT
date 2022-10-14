package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="participation")
public class Participation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="astronaute")
	private Astronaute astronaute;
	
	@ManyToOne
	@JoinColumn(name="mission")
	private Mission mission;
	
	public Participation() {	
	}

	public Participation(Astronaute astronaute, Mission mission) {
		this.astronaute = astronaute;
		this.mission = mission;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Astronaute getAstronaute() {
		return astronaute;
	}

	public void setAstronaute(Astronaute astronaute) {
		this.astronaute = astronaute;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	@Override
	public String toString() {
		return "Participation [id=" + id + ", astronaute=" + astronaute + ", mission=" + mission + "]";
	}
	
	
}
