package com.example.yyyyyy.Controller;

import com.example.yyyyyy.Entity.Formation;
import com.example.yyyyyy.Entity.Projet;
import com.example.yyyyyy.Entity.Tache;
import com.example.yyyyyy.Interfaces.IProjet;
import com.example.yyyyyy.Interfaces.ITache;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Projet")
@RequiredArgsConstructor
public class ProjetController {

    private final IProjet iProjet;

    @PostMapping("/add")
        //@PreAuthorize("hasRole('admin')")
    Projet addProjet(@RequestBody Projet projet){
        return iProjet.addOrUpdateProjet(projet);

    }
    @GetMapping("/all")

    List<Projet> getallProjet(){
        return iProjet.retrieveAllProjets();

    }
    @DeleteMapping("/delete/{idProjet}")
    void deleteProjet(@PathVariable("idProjet") Long idProjet){
        iProjet.removeProjet(idProjet);
    }

    @PutMapping("/update")
    Projet updateProjet(@RequestBody Projet projet){
        return iProjet.addOrUpdateProjet(projet);
    }

    @GetMapping("/get/{idProjet}")
    Projet affichProjet(@PathVariable("idProjet") Long idProjet){
        return iProjet.retriveProjet(idProjet);
    }

    @PutMapping("/ass/{id}/{idProjet}")
    Projet updateProje(@PathVariable(value = "idProjet") Long idProjet,@PathVariable(value = "id") Long id){
        return iProjet.assignProjectToUser(id,idProjet);
    }
}
