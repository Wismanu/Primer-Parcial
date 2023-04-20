package com.PrimerParcial.app.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstname;
    @Column(name="Personaje_Fav")
    private String lastName;

    private String email;
    private String password;
    private String address;

    private LocalDate birthday;

}
