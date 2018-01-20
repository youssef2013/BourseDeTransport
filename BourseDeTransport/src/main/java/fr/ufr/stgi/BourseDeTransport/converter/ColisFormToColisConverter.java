package fr.ufr.stgi.BourseDeTransport.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import fr.ufr.stgi.BourseDeTransport.domain.Colis;
import fr.ufr.stgi.BourseDeTransport.form.ColisForm;

@Component
public class ColisFormToColisConverter implements Converter<ColisForm, Colis> {

	@Override
	public Colis convert(ColisForm colisForm) {
		Colis colis = new Colis();
		if (colisForm.getId() != null  && !StringUtils.isEmpty(colisForm.getId())) {
			colis.setId(colisForm.getId());
		}
		colis.setPoids(colisForm.getPoids());
		colis.setAdresse(colisForm.getAdresse());
		colis.setQuantite(colisForm.getQuantite());
		colis.setType(colisForm.getType());
		colis.setVolume(colisForm.getVolume());
		
		return colis;
	}

}
