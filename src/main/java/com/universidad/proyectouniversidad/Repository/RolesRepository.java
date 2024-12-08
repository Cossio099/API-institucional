package com.universidad.proyectouniversidad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universidad.proyectouniversidad.Entity.RolesEntity;
@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> {

}
