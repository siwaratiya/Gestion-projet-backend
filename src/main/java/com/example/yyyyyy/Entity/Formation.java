package com.example.yyyyyy.Entity;

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
@Table( name = "Formation")
public class Formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFormation")
    private Long idFormation;

    private String sujet;
    private float duree;
    private String description;
    private String localisation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="formation")
    Set<Projet> projets;
}
