package com.universidad.proyectouniversidad.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.universidad.proyectouniversidad.Entity.RolesEntity;
import com.universidad.proyectouniversidad.Service.RolesService;

@Controller
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @PostMapping
    public RolesEntity createRolesController(@RequestBody RolesEntity rolesEntity){
        return rolesService.saveRolesEntity(rolesEntity);
    }

    @GetMapping("/get")
    public List<RolesEntity> getRolesController(){
        return rolesService.listRolesEntity();
    }

    @GetMapping("/get/{id}")
    public Optional<RolesEntity> getByIdRolesController(@PathVariable Long id){
        return rolesService.listFindByIdRolesEntity(id);
    }

    @DeleteMapping("/{id}")
    public void deleteByIdRolesController(@PathVariable Long id){
        rolesService.deleteByIdRolesEntity(id);
    }

}
