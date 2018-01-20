package fr.ufr.stgi.BourseDeTransport.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.ufr.stgi.BourseDeTransport.domain.Colis;
import fr.ufr.stgi.BourseDeTransport.form.ColisForm;

@Component
public class ColisToColisFormConverter implements Converter<Colis, ColisForm> {

	@Override
	public ColisForm convert(Colis colis) {
		ColisForm colisForm = new ColisForm();
		colisForm.setPoids(colis.getPoids());
		colisForm.setAdresse(colis.getAdresse());
		colisForm.setQuantite(colis.getQuantite());
		colisForm.setType(colis.getType());
		colisForm.setVolume(colis.getVolume());
		
		return colisForm;
	}

}
