package com.example.yyyyyy.Controller;

import com.example.yyyyyy.Entity.Tache;
import com.example.yyyyyy.Interfaces.ITache;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Tache")
@RequiredArgsConstructor
public class TacheController {
    private final ITache iTache;

    @PostMapping("/add")

    Tache addMedicalcard(@RequestBody Tache tache ){
        return iTache.addOrUpdateTache(tache);

    }
    @GetMapping("/all")
    List<Tache> getallMedicalcard(){
        return iTache.retrieveAllTaches();

    }
    @DeleteMapping("/delete/{idTache}")
    void deletetest(@PathVariable("idTache") Long idTache){
        iTache.removeTache(idTache);
    }

    @PutMapping("/update")
    Tache updateTest(@RequestBody Tache tache){
        return iTache.addOrUpdateTache(tache);
    }

    @GetMapping("/get/{idTache}")
    Tache affichtache(@PathVariable("idTache") Long idTache){
        return iTache.retriveTest(idTache);
    }
}
