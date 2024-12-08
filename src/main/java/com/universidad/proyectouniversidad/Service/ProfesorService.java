package com.universidad.proyectouniversidad.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidad.proyectouniversidad.Entity.ProfesorEntity;
import com.universidad.proyectouniversidad.Repository.ProfesorRepository;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public ProfesorEntity saveProfesorEntity(ProfesorEntity profesorEntity){
        return profesorRepository.save(profesorEntity);
    }

    public List<ProfesorEntity> findAllProfesorEntity(){
        return profesorRepository.findAll();
    }

    public Optional<ProfesorEntity> findByIdProfesorRepository(Long id){
        return profesorRepository.findById(id);
    }

    public void deleteByIdProfesorRepository(Long id){
        profesorRepository.deleteById(id);
    }

}
