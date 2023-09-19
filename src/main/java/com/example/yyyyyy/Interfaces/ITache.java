package com.example.yyyyyy.Interfaces;


import com.example.yyyyyy.Entity.Tache;

import java.util.List;

public interface ITache {
    Tache addOrUpdateTache(Tache tache);



    void removeTache(Long idTache);

    Tache retriveTache(Long idTache);

    List<Tache> retrieveAllTaches();

    Tache retriveTest(Long idTache);
}
