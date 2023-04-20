package com.procesos.concesionario.repository;

import com.procesos.concesionario.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
