package fr.orsys.fx.calendrier_gif.service;

import java.time.LocalDate;
import java.util.List;

import fr.orsys.fx.calendrier_gif.business.Gif;
import fr.orsys.fx.calendrier_gif.business.GifDistant;
import fr.orsys.fx.calendrier_gif.business.Jour;
import fr.orsys.fx.calendrier_gif.business.Utilisateur;

public interface GifService {

	GifDistant ajouterGifDistant(LocalDate idJour, String url, Utilisateur utilisateur);

	GifDistant ajouterGifDistant(GifDistant gifDistant, Utilisateur utilisateur);

	Gif recupererGif(Long idGif);

	Gif mettreAJourLegende(Gif gif, String nouvelleLegende);

	Gif recupererGifParJour(Jour jour);

	List<Gif> recupererGifsParLegende(String legende);

	List<Gif> gifParNbReactions();
	
}
