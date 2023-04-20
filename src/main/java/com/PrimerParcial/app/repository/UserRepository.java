package com.PrimerParcial.app.repository;

import com.PrimerParcial.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
