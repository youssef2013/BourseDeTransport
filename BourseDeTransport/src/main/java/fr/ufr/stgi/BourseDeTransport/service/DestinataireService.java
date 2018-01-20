package fr.ufr.stgi.BourseDeTransport.service;

import java.util.List;

import fr.ufr.stgi.BourseDeTransport.domain.Destination;
import fr.ufr.stgi.BourseDeTransport.form.DestinationForm;

public interface DestinataireService {

	List<Destination> listAll();

	Destination getById(Long id);

	Destination saveOrUpdate(Destination destination);

	void delete(Long id);

	Destination saveOrUpdateColisForm(DestinationForm destinationForm);
}
