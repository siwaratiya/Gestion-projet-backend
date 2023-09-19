package com.example.yyyyyy.Entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder
@Table( name = "Tache")
public class Tache implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTache")
    private Long idTache;
    private String titre;
    private String description;
    @ManyToOne(cascade = CascadeType.PERSIST)
    //@JsonIgnore
    Projet projet;

}