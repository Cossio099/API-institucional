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

import com.universidad.proyectouniversidad.DTO.ProfesorDTO;
import com.universidad.proyectouniversidad.Entity.ProfesorEntity;
import com.universidad.proyectouniversidad.Entity.RolesEntity;
import com.universidad.proyectouniversidad.Service.ProfesorService;
import com.universidad.proyectouniversidad.Service.RolesService;

@Controller
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private RolesService rolesService;

    @PostMapping("/post")
    public ResponseEntity<String> createProfesorController(@RequestBody ProfesorDTO profesorDTO) {
        Optional<RolesEntity> rOptional = rolesService.listFindByIdRolesEntity(profesorDTO.getIdRol());
        if (!rOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        }
        RolesEntity rol = rOptional.get();

        ProfesorEntity profesorEntity = new ProfesorEntity();
        profesorEntity.setId(profesorDTO.getId());
        profesorEntity.setName(profesorDTO.getNombre());
        profesorEntity.setLast_name(profesorDTO.getApellido());
        profesorEntity.setPhone(profesorDTO.getTelefono());
        profesorEntity.setEmail(profesorDTO.getCorreo());
        profesorEntity.setArea_career(profesorDTO.getArea_carrera());
        profesorEntity.setAddress(profesorDTO.getDireccion());
        profesorEntity.setRolesEntity(rol);

        ProfesorEntity savedEntity = profesorService.saveProfesorEntity(profesorEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Profesor creado con id: " + savedEntity.getId());
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> updateProfesorController(@PathVariable Long id, @RequestBody ProfesorDTO profesorDTO) {
        Optional<ProfesorEntity> pOptional = profesorService.findByIdProfesorRepository(id);
        if (!pOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profesor no encontrado");
        }
        Optional<RolesEntity> rOptional = rolesService.listFindByIdRolesEntity(profesorDTO.getIdRol());
        if (!rOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");   
        }
        
        RolesEntity rol = rOptional.get();
        
        ProfesorEntity profesorEntity = pOptional.get();
        profesorEntity.setName(profesorDTO.getNombre());
        profesorEntity.setLast_name(profesorDTO.getApellido());
        profesorEntity.setPhone(profesorDTO.getTelefono());
        profesorEntity.setEmail(profesorDTO.getCorreo());
        profesorEntity.setArea_career(profesorDTO.getArea_carrera());
        profesorEntity.setAddress(profesorDTO.getDireccion());
        profesorEntity.setRolesEntity(rol);
        
        ProfesorEntity updatedEntity = profesorService.updateProfesorEntity(profesorEntity);

        if (updatedEntity != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Profesor actualizado con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profesor no encontrado");

        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getProfesorController(){
        List<ProfesorEntity> profesores = profesorService.findAllProfesorEntity();
        if (profesores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron profesores");
        }
        return ResponseEntity.status(HttpStatus.OK).body(profesores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdProfesorController(@PathVariable Long id){
        Optional<ProfesorEntity> profesor = profesorService.findByIdProfesorRepository(id);
        if (!profesor.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profesor no encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(profesor.get());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfesorController(@PathVariable Long id){
        profesorService.deleteByIdProfesorRepository(id);
        if (profesorService.findByIdProfesorRepository(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Profesor Eliminado con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profesor no encontrado");
            
        }
    }

}
