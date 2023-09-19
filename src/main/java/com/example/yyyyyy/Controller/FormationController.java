package com.example.yyyyyy.Controller;

import com.example.yyyyyy.Entity.Formation;
import com.example.yyyyyy.Entity.Tache;
import com.example.yyyyyy.Interfaces.IFormation;
import com.example.yyyyyy.Interfaces.ITache;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Formation")
@RequiredArgsConstructor
public class FormationController {
    private final IFormation iFormation;

    @PostMapping("/add")
    Formation addFormation(@RequestBody Formation formation ){
        return iFormation.addOrUpdateFormation(formation);

    }
    @GetMapping("/all")
    List<Formation> getalliFormation(){
        return iFormation.retrieveAllidFormation();

    }
    @DeleteMapping("/delete/{idFormation}")
    void deleteFormation(@PathVariable("idFormation") Long idFormation){
        iFormation.removeFormation(idFormation);
    }

    @PutMapping("/update")
    Formation updateFormation(@RequestBody Formation formation){
        return iFormation.addOrUpdateFormation(formation);
    }

    @GetMapping("/get/{idFormation}")
    Formation affichformation(@PathVariable("idFormation") Long idFormation){
        return iFormation.retriveFormation(idFormation);
    }
}
