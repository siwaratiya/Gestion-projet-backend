package com.example.yyyyyy.Services;


import com.example.yyyyyy.Entity.Tache;
import com.example.yyyyyy.Interfaces.ITache;
import com.example.yyyyyy.Repository.TacheRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TacheService implements ITache {
    private final TacheRepository
            tacheRepository;

    @Override
    public Tache addOrUpdateTache(Tache tache) {
        return tacheRepository.save(tache);

    }
    @Override
    public void removeTache(Long idTache) {
        tacheRepository.deleteById(idTache);
    }

    @Override
    public Tache retriveTache(Long idTache) {
        return tacheRepository.findById(idTache).orElse(null );
    }
    @Override
    public List<Tache> retrieveAllTaches() {
        return  tacheRepository.findAll();

    }
    @Override
    public Tache retriveTest(Long idTache) {
        return tacheRepository.findById(idTache).orElse(null);
    }

}
