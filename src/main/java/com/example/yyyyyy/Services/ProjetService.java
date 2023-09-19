package com.example.yyyyyy.Services;

import com.example.yyyyyy.Entity.Projet;
import com.example.yyyyyy.Entity.User;
import com.example.yyyyyy.Interfaces.IProjet;
import com.example.yyyyyy.Repository.ProjetRepository;
import com.example.yyyyyy.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ProjetService implements IProjet {
    private final ProjetRepository projetRepository;
    private final UserRepository userRepository;

    @Override
    public Projet addOrUpdateProjet(Projet projet) {
        return projetRepository.save(projet);

    }
    @Override
    public void removeProjet(Long idProjet) {
        projetRepository.deleteById(idProjet);
    }

    @Override
    public Projet retriveProjet(Long idProjet) {
        return projetRepository.findById(idProjet).orElse(null );
    }
    @Override
    public List<Projet> retrieveAllProjets() {
        return  projetRepository.findAll();

    }

    @Override
    public Projet assignProjectToUser(Long id, Long idProjet){

        Projet projet=projetRepository.findById(idProjet).orElse(null);
        User user=userRepository.findById(id).orElse(null);
        projet.setUser(user);
        return projetRepository.save(projet);
    }
}
