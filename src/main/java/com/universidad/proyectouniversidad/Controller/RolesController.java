package com.universidad.proyectouniversidad.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.universidad.proyectouniversidad.Entity.RolesEntity;
import com.universidad.proyectouniversidad.Service.RolesService;

@Controller
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @PostMapping("/post")
    public ResponseEntity<String> createRolesController(@RequestBody RolesEntity rolesEntity){
        RolesEntity savedRolesEntity = rolesService.saveRolesEntity(rolesEntity);
        if (savedRolesEntity.equals(savedRolesEntity)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Rol creado con id: " + savedRolesEntity.getId());
            
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El rol ya existe");
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> updateRolesController(@PathVariable Long id, @RequestBody RolesEntity rolesEntity){
        Optional<RolesEntity> rOptional = rolesService.listFindByIdRolesEntity(id);
        if (rOptional.isPresent()) {
            RolesEntity existingRoles = rOptional.get();
            existingRoles.setRol(rolesEntity.getRol());
            rolesService.updateRolesEntity(existingRoles);
            return ResponseEntity.status(HttpStatus.OK).body("Rol actualizado con exito");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
    }

    @GetMapping("/get")
    public ResponseEntity<?> getRolesController(){
        List<RolesEntity> roles = rolesService.listRolesEntity();
        if (roles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron roles");
        }
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdRolesController(@PathVariable Long id){
        Optional<RolesEntity> roles = rolesService.listFindByIdRolesEntity(id);
        if (roles.isPresent()) {
            return ResponseEntity.ok(roles.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByIdRolesController(@PathVariable Long id){
        rolesService.deleteByIdRolesEntity(id);
        if (rolesService.listFindByIdRolesEntity(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Rol eliminado con exito");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
    }

}
