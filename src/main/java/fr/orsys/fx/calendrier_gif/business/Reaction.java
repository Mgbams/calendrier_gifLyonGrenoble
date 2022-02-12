package fr.orsys.fx.calendrier_gif.business;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Gif gif;
	
	@ManyToOne
	private Utilisateur utilisateur;

	@ManyToOne
	private Emotion emotion;
	
	private LocalDateTime dateHeure;
	
	public Reaction() {
		dateHeure = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Gif getGif() {
		return gif;
	}

	public void setGif(Gif gif) {
		this.gif = gif;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Emotion getEmotion() {
		return emotion;
	}

	public void setEmotion(Emotion emotion) {
		this.emotion = emotion;
	}

	public void setDateHeure(LocalDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}

	public LocalDateTime getDateHeure() {
		return dateHeure;
	}

	@Override
	public String toString() {
		return "Reaction [id=" + id + ", gif=" + gif + ", utilisateur=" + utilisateur + ", emotion=" + emotion
				+ ", dateHeure=" + dateHeure + "]";
	}
	
}