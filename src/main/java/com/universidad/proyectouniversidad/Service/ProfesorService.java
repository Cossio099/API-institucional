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

    public ProfesorEntity updateProfesorEntity(ProfesorEntity profesorEntity){
        Optional<ProfesorEntity> optionalProfesor = profesorRepository.findById(profesorEntity.getId());
        if (optionalProfesor.isPresent()) {
            ProfesorEntity existingProfesor = optionalProfesor.get();
            existingProfesor.setName(profesorEntity.getName());
            existingProfesor.setLast_name(profesorEntity.getLast_name());
            existingProfesor.setPhone(profesorEntity.getPhone());
            existingProfesor.setEmail(profesorEntity.getEmail());
            existingProfesor.setArea_career(profesorEntity.getArea_career());
            existingProfesor.setAddress(profesorEntity.getAddress());
            existingProfesor.setRolesEntity(profesorEntity.getRolesEntity());
            return profesorRepository.save(existingProfesor);
        } else {
            return null;
        }
    }
}
