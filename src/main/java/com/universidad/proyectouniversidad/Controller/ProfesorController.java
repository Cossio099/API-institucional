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

import com.universidad.proyectouniversidad.Entity.ProfesorEntity;
import com.universidad.proyectouniversidad.Service.ProfesorService;

@Controller
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public ProfesorEntity createProfesorController(@RequestBody ProfesorEntity profesorEntity){
        return profesorService.saveProfesorEntity(profesorEntity);
    }

    @GetMapping
    public List<ProfesorEntity> getProfesorController(){
        return profesorService.findAllProfesorEntity();
    }

    @GetMapping("/{id}")
    public Optional<ProfesorEntity> getByIdProfesorController(@PathVariable Long id){
        return profesorService.findByIdProfesorRepository(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProfesorController(@PathVariable Long id){
        profesorService.deleteByIdProfesorRepository(id);
    }

}
