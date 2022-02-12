package fr.orsys.fx.calendrier_gif.business;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Jour {

	@Id
	private LocalDate date;
	
	@Min(20)
	@Max(50)
	private int nbPoints;
	
	@OneToOne
	private Gif gif;
	
	public Jour() {
	}
	
	public Jour(LocalDate date, int nbPoints) {
		this.date = date;
		this.nbPoints = nbPoints;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public Gif getGif() {
		return gif;
	}

	public void setGif(Gif gif) {
		this.gif = gif;
	}

	public String toString() {
		return date.getDayOfMonth() + "/" +  date.getMonthValue();
	}
	
}