package fr.ufr.stgi.BourseDeTransport.service;

import java.util.List;

import fr.ufr.stgi.BourseDeTransport.domain.Colis;
import fr.ufr.stgi.BourseDeTransport.form.ColisForm;

public interface ColisService {

    List<Colis> listAll();

    Colis getById(Long id);

    Colis saveOrUpdate(Colis product);

    void delete(Long id);

    Colis saveOrUpdateColisForm(ColisForm colisForm);
}
