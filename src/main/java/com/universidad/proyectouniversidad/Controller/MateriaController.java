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

import com.universidad.proyectouniversidad.Entity.MateriaEntity;
import com.universidad.proyectouniversidad.Service.MateriaService;

@Controller
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @PostMapping
    public MateriaEntity createMateriaController(@RequestBody MateriaEntity materiaEntity){
        return materiaService.saveMateriaEntity(materiaEntity);
    }

    @GetMapping
    public List<MateriaEntity> getMateriaController(){
        return materiaService.ListMateriaEntity();
    }

    @GetMapping("/{id}")
    public Optional<MateriaEntity> getByIdMateriaController(@PathVariable Long id){
        return materiaService.finByIdMateriaEntity(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMateriaController(@PathVariable Long id){
        materiaService.deleteByIdMateriaEntity(id);
    }

}
