package com.example.yyyyyy.Interfaces;

import com.example.yyyyyy.Entity.Formation;

import java.util.List;

public interface IFormation {


    Formation addOrUpdateFormation(Formation formation);

    void removeFormation(Long idFormation);

    Formation retriveFormation(Long idFormation);

    List<Formation> retrieveAllidFormation();
}
