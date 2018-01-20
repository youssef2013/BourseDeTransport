package fr.ufr.stgi.BourseDeTransport.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ufr.stgi.BourseDeTransport.converter.ColisFormToColisConverter;
import fr.ufr.stgi.BourseDeTransport.domain.Colis;
import fr.ufr.stgi.BourseDeTransport.form.ColisForm;
import fr.ufr.stgi.BourseDeTransport.repository.ColisRepository;
import fr.ufr.stgi.BourseDeTransport.service.ColisService;

@Service
public class ColisServiceImpl implements ColisService {

	private ColisRepository colisRepository;
	private ColisFormToColisConverter colisFormToColis;
	
	
	@Autowired
	public ColisServiceImpl(ColisRepository colisRepository, ColisFormToColisConverter colisFormToColis) {
		this.colisRepository = colisRepository;
		this.colisFormToColis = colisFormToColis;
	}

	@Override
	public List<Colis> listAll() {
		List<Colis> colisList = new ArrayList<>();
		colisRepository.findAll().forEach(colisList::add);
		return colisList;
	}

	@Override
	public Colis getById(Long id) {
		return colisRepository.findOne(id);
	}

	@Override
	public Colis saveOrUpdate(Colis colis) {
		colisRepository.save(colis);
		return colis;
	}

	@Override
	public void delete(Long id) {
		colisRepository.delete(id);
	}

	@Override
	public Colis saveOrUpdateColisForm(ColisForm colisForm) {
		Colis savedColis = colisRepository.save(colisFormToColis.convert(colisForm));
		return savedColis;
	}

}
