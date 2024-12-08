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

import com.universidad.proyectouniversidad.Entity.EstudianteEntity;
import com.universidad.proyectouniversidad.Service.EstudianteService;

@Controller
@RequestMapping("/api/estudiantes")
public class EstudiantesController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public EstudianteEntity createEstudianteController(@RequestBody EstudianteEntity estudianteEntity){
        return estudianteService.saveEstudianteEntity(estudianteEntity);
    }

    @GetMapping
    public List<EstudianteEntity> getEstudianteController(){
        return estudianteService.listEstudianteEntity();
    }

    @GetMapping("/{id}")
    public Optional<EstudianteEntity> getByIdEstudianteController(@PathVariable Long id){
        return estudianteService.listFindByIdEstudianteEntity(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEstudianteController(@PathVariable Long id){
        estudianteService.deleteEstudianteEntity(id);
    }

}
