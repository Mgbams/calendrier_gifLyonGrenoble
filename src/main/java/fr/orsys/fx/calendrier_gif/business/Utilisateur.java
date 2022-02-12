package fr.orsys.fx.calendrier_gif.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur {

	private static final int NB_POINTS_INITIAL = 500;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nom;
	
	@NotBlank(message="Merci de préciser votre prénom")
	private String prenom;
	
	//@Email(message="Merci de préciser une adresse email au bon format")
	@NotBlank(message="Merci de préciser une adresse email")
	@Column(unique=true)
	// Big up Roman pour la regex !
	//@Pattern(regexp="^[A-Za-z0-9]([A-Za-z0-9-.])+[A-Za-z0-9]@orsys.fr$", message="Votre adresse doit faire partie du nom de domaine orsys.fr")
	private String email;
	
	@JsonIgnore
	@Size(min=3, message="Le mot de passe doit comporter au moins trois caractères")
	private String motDePasse;
	
	@ManyToOne
	@NotNull(message="Merci de choisir un thème")
	private Theme theme;
	
	private int nbPoints;

	private LocalDateTime dateHeureInscription;
	
	@JsonIgnore
	@OneToMany(mappedBy="utilisateur")
	private List<Gif> gifs;
	
	public Utilisateur() {
		nbPoints = NB_POINTS_INITIAL;
		setDateHeureInscription(LocalDateTime.now());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public List<Gif> getGifs() {
		return gifs;
	}

	public void setGifs(List<Gif> gifs) {
		this.gifs = gifs;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motDePasse="
				+ motDePasse + ", theme=" + theme + ", nbPoints=" + nbPoints + "]";
	}

	public LocalDateTime getDateHeureInscription() {
		return dateHeureInscription;
	}

	public void setDateHeureInscription(LocalDateTime dateHeureInscription) {
		this.dateHeureInscription = dateHeureInscription;
	}
	
}