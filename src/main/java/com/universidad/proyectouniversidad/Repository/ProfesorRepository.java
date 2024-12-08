package com.universidad.proyectouniversidad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universidad.proyectouniversidad.Entity.ProfesorEntity;
@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorEntity,Long>{

}
