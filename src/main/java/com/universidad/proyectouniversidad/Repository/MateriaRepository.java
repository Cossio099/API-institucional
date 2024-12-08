package com.universidad.proyectouniversidad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universidad.proyectouniversidad.Entity.MateriaEntity;
@Repository
public interface MateriaRepository extends JpaRepository<MateriaEntity, Long>{

}
