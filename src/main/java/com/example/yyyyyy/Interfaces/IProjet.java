package com.example.yyyyyy.Interfaces;

import com.example.yyyyyy.Entity.Projet;

import java.util.List;

public interface IProjet {
    Projet addOrUpdateProjet(Projet projet);

    void removeProjet(Long idProjet);

    Projet retriveProjet(Long idProjet);

    List<Projet> retrieveAllProjets();

    Projet assignProjectToUser(Long id, Long idProjet);
}
