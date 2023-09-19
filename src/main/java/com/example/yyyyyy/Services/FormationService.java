package com.example.yyyyyy.Services;

import com.example.yyyyyy.Entity.Formation;
import com.example.yyyyyy.Interfaces.IFormation;
import com.example.yyyyyy.Repository.FormationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FormationService implements IFormation {
        private final FormationRepository formationRepository;

    @Override
        public Formation addOrUpdateFormation(Formation formation) {
            return formationRepository.save(formation);

        }
        @Override
        public void removeFormation(Long idFormation) {
            formationRepository.deleteById(idFormation);
        }

        @Override
        public Formation retriveFormation(Long idFormation) {
            return formationRepository.findById(idFormation).orElse(null );
        }
        @Override
        public List<Formation> retrieveAllidFormation() {
            return  formationRepository.findAll();

        }


}
