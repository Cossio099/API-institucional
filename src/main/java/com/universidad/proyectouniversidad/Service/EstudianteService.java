package com.universidad.proyectouniversidad.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidad.proyectouniversidad.Entity.EstudianteEntity;
import com.universidad.proyectouniversidad.Repository.EstudianteRepository;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public EstudianteEntity saveEstudianteEntity(EstudianteEntity estudianteEntity){
        return estudianteRepository.save(estudianteEntity);
    }

    public List<EstudianteEntity> listEstudianteEntity(){
        return estudianteRepository.findAll();
    }

    public Optional<EstudianteEntity> listFindByIdEstudianteEntity(Long id){
        return estudianteRepository.findById(id);
    }

    public void deleteEstudianteEntity(Long id){
        estudianteRepository.deleteById(id);
    }

}
