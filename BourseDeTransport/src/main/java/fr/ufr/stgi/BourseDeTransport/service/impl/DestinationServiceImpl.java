package fr.ufr.stgi.BourseDeTransport.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.ufr.stgi.BourseDeTransport.domain.Destination;
import fr.ufr.stgi.BourseDeTransport.form.DestinationForm;
import fr.ufr.stgi.BourseDeTransport.service.DestinataireService;

@Component
public class DestinationServiceImpl implements DestinataireService {

	@Override
	public List<Destination> listAll() {
		return null;
	}

	@Override
	public Destination getById(Long id) {
		return null;
	}

	@Override
	public Destination saveOrUpdate(Destination destination) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public Destination saveOrUpdateColisForm(DestinationForm destinationForm) {
		return null;
	}

}
