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

import com.universidad.proyectouniversidad.DTO.EstudianteDTO;
import com.universidad.proyectouniversidad.Entity.EstudianteEntity;
import com.universidad.proyectouniversidad.Entity.RolesEntity;
import com.universidad.proyectouniversidad.Service.EstudianteService;
import com.universidad.proyectouniversidad.Service.RolesService;

@Controller
@RequestMapping("/api/estudiantes")
public class EstudiantesController {

    @Autowired
    private EstudianteService estudianteService;
    @Autowired
    private RolesService rolesService;

    @PostMapping("/post")
    public ResponseEntity<String> createEstudianteController(@RequestBody EstudianteDTO estudianteDTO){
        Optional<RolesEntity> rOptional = rolesService.listFindByIdRolesEntity(estudianteDTO.getIdRol());
        
        if (!rOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        }
        RolesEntity rol = rOptional.get();

        EstudianteEntity estudianteEntity = new EstudianteEntity();
        estudianteEntity.setId(estudianteDTO.getId());
        estudianteEntity.setName(estudianteDTO.getNombre());
        estudianteEntity.setLast_name(estudianteDTO.getApellido());
        estudianteEntity.setPhone(estudianteDTO.getTelefono());
        estudianteEntity.setEmail(estudianteDTO.getCorreo());
        estudianteEntity.setCareer(estudianteDTO.getCarrera());
        estudianteEntity.setAddress(estudianteDTO.getDireccion());
        estudianteEntity.setRol(rol);

        EstudianteEntity savedEntity = estudianteService.saveEstudianteEntity(estudianteEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Estudiante creado con id: " + savedEntity.getId());
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> updateEstudianteController(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO){
        Optional<RolesEntity> rOptional = rolesService.listFindByIdRolesEntity(estudianteDTO.getIdRol());
        
        if (!rOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        }
        RolesEntity rol = rOptional.get();

        Optional<EstudianteEntity> eOptional = estudianteService.listFindByIdEstudianteEntity(id);
        if (!eOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado");
        }
        EstudianteEntity estudianteEntity = eOptional.get();
        estudianteEntity.setName(estudianteDTO.getNombre());
        estudianteEntity.setLast_name(estudianteDTO.getApellido());
        estudianteEntity.setPhone(estudianteDTO.getTelefono());
        estudianteEntity.setEmail(estudianteDTO.getCorreo());
        estudianteEntity.setCareer(estudianteDTO.getCarrera());
        estudianteEntity.setAddress(estudianteDTO.getDireccion());
        estudianteEntity.setRol(rol);

        EstudianteEntity savedEntity = estudianteService.saveEstudianteEntity(estudianteEntity);

        if (savedEntity != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Estudiante actualizado con exito");
            
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado");
    }

    @GetMapping("/get")
    public ResponseEntity<?> getEstudianteController(){
        List<EstudianteEntity> estudiantes = estudianteService.listEstudianteEntity();
        if (estudiantes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron estudiantes");
        }
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdEstudianteController(@PathVariable Long id){
        Optional<EstudianteEntity> estudiante = estudianteService.listFindByIdEstudianteEntity(id);
        if (!estudiante.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado");
            
        }
        return ResponseEntity.ok(estudiante.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstudianteController(@PathVariable Long id){
        estudianteService.deleteEstudianteEntity(id);
        if (estudianteService.listFindByIdEstudianteEntity(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Estudiante eliminado con exito");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado");
    }

}
