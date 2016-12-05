package fr.quintipio.fr.quintipio.modelArchiAngularJs.service;

import fr.quintipio.fr.quintipio.modelArchiAngularJs.model.Commune;

import java.util.List;

public interface CommuneService {

    List<Commune> findAllCommune();


    Commune findCommune(int idCommune);
}
