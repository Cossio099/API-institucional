package com.universidad.proyectouniversidad.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidad.proyectouniversidad.Entity.RolesEntity;
import com.universidad.proyectouniversidad.Repository.RolesRepository;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public RolesEntity saveRolesEntity(RolesEntity rolesEntity){
        return rolesRepository.save(rolesEntity);
    }

    public List<RolesEntity> listRolesEntity(){
        return rolesRepository.findAll();
    }

    public Optional<RolesEntity> listFindByIdRolesEntity(Long id){
        return rolesRepository.findById(id);
    }

    public void deleteByIdRolesEntity(Long id){
        rolesRepository.deleteById(id);
    }

    public void updateRolesEntity(RolesEntity rolesEntity){
        rolesRepository.save(rolesEntity);
    }

}
