package fr.quintipio.fr.quintipio.modelArchiAngularJs.service;

import fr.quintipio.fr.quintipio.modelArchiAngularJs.dao.CommuneDao;
import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.Commune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("communeService")
@Transactional
public class CommuneServiceImpl implements CommuneService {

    @Autowired
    private CommuneDao communeDao;

    @Override
    public List<Commune> findAllCommune() {
        List<Commune> retour = new ArrayList<>();
        communeDao.findAll().forEach(x->retour.add(x));
        return retour;
    }

    @Override
    public Commune findCommune(int idCommune) {
        return communeDao.findOne(idCommune);
    }
}
