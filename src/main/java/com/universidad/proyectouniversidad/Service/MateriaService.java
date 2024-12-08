package com.universidad.proyectouniversidad.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidad.proyectouniversidad.Entity.MateriaEntity;
import com.universidad.proyectouniversidad.Repository.MateriaRepository;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public MateriaEntity saveMateriaEntity(MateriaEntity materiaEntity){
        return materiaRepository.save(materiaEntity);
    }

    public List<MateriaEntity> ListMateriaEntity(){
        return materiaRepository.findAll();
    }

    public Optional<MateriaEntity> finByIdMateriaEntity(Long id){
        return materiaRepository.findById(id);
    }

    public void deleteByIdMateriaEntity(Long id){
        materiaRepository.deleteById(id);
    }

}
