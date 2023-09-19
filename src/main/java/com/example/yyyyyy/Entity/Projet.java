package com.example.yyyyyy.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder
@Table( name = "Projet")
public class Projet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProjet")
    private Long idProjet;

    private String nom;
    private float cout_provisoire;
    private String technologie;
    private String situation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="projet")
    Set<Tache> taches;
    @ManyToOne(cascade = CascadeType.PERSIST)
    //@JsonIgnore
    Formation formation;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    User user;

}
