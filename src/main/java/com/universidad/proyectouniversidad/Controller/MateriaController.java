package com.universidad.proyectouniversidad.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.universidad.proyectouniversidad.DTO.MateriaDTO;
import com.universidad.proyectouniversidad.Entity.EstudianteEntity;
import com.universidad.proyectouniversidad.Entity.MateriaEntity;
import com.universidad.proyectouniversidad.Entity.ProfesorEntity;
import com.universidad.proyectouniversidad.Service.EstudianteService;
import com.universidad.proyectouniversidad.Service.MateriaService;
import com.universidad.proyectouniversidad.Service.ProfesorService;

@Controller
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/post")
    public ResponseEntity<?> createMateriaController(@RequestBody MateriaDTO materiaDTO){
        Optional<ProfesorEntity> pOptional = profesorService.findByIdProfesorRepository(materiaDTO.getId_profesor());
        Optional<EstudianteEntity> eOptional = estudianteService.listFindByIdEstudianteEntity(materiaDTO.getId_estudiante());
        
        if (!pOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Profesor no encontrado");
        }
        if (!eOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Estudiante no encontrado");
        }

        ProfesorEntity profesor = pOptional.get();
        EstudianteEntity estudiante = eOptional.get();

        MateriaEntity materiaEntity = new MateriaEntity();
        materiaEntity.setDificult(materiaDTO.getDificultad());
        materiaEntity.setNum_credits(materiaDTO.getNumeroCreditos());
        materiaEntity.setDescription(materiaDTO.getDescripcion());
        materiaEntity.setProfesor(profesor);
        materiaEntity.setEstudiante(estudiante);

        MateriaEntity savedEntity = materiaService.saveMateriaEntity(materiaEntity);
        return ResponseEntity.ok("Materia creada con id: " + savedEntity.getId());
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> updateMateriaController(@PathVariable Long id, @RequestBody MateriaDTO materiaDTO){
        Optional<MateriaEntity> mOptional = materiaService.finByIdMateriaEntity(id);
        Optional<ProfesorEntity> pOptional = profesorService.findByIdProfesorRepository(materiaDTO.getId_profesor());
        Optional<EstudianteEntity> eOptional = estudianteService.listFindByIdEstudianteEntity(materiaDTO.getId_estudiante());
        
        if (!mOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Materia no encontrada");
        }
        if (!pOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Profesor no encontrado");
        }
        if (!eOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Estudiante no encontrado");
        }

        ProfesorEntity profesor = pOptional.get();
        EstudianteEntity estudiante = eOptional.get();

        MateriaEntity materiaEntity = mOptional.get();
        materiaEntity.setDificult(materiaDTO.getDificultad());
        materiaEntity.setNum_credits(materiaDTO.getNumeroCreditos());
        materiaEntity.setDescription(materiaDTO.getDescripcion());
        materiaEntity.setProfesor(profesor);
        materiaEntity.setEstudiante(estudiante);

        MateriaEntity savedEntity = materiaService.saveMateriaEntity(materiaEntity);
        return ResponseEntity.ok("Materia actualizada con id: " + savedEntity.getId());
    }

    @GetMapping
    public ResponseEntity<?> getMateriaController(){
        List<MateriaEntity> materia = materiaService.ListMateriaEntity();
        return ResponseEntity.ok(materia);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdMateriaController(@PathVariable Long id){
        Optional<MateriaEntity> materia = materiaService.finByIdMateriaEntity(id);
        if (!materia.isPresent()) {
            return ResponseEntity.badRequest().body("Materia no encontrada");
        }
        return ResponseEntity.ok(materia.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMateriaController(@PathVariable Long id){
        Optional<MateriaEntity> materia = materiaService.finByIdMateriaEntity(id);
        if (!materia.isPresent()) {
            return ResponseEntity.badRequest().body("Materia no encontrada");
        }
        materiaService.deleteByIdMateriaEntity(id);
        return ResponseEntity.ok("Materia eliminada con exito");
    }

}
