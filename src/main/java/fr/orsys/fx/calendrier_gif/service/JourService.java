package fr.orsys.fx.calendrier_gif.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.orsys.fx.calendrier_gif.business.Jour;

public interface JourService {

	Jour ajouterJour(LocalDate date);
	Jour enregistrerJour(Jour jour);
	
	Page<Jour> recupererJours(Pageable pageable);

	List<Jour> recupererJours();

	Jour recupererJour(LocalDate idJour);

	boolean supprimerJour(LocalDate date);
	
	long compterJours();
}
