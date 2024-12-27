package com.universidad.proyectouniversidad.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblmateria")
public class MateriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_profesor",nullable = false)
    private ProfesorEntity profesor;
    @ManyToOne
    @JoinColumn(name = "id_estudiante",nullable = false)
    private EstudianteEntity estudiante;
    private int dificult;
    private int num_credits;
    private String description;


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ProfesorEntity getProfesor() {
        return profesor;
    }
    public void setProfesor(ProfesorEntity profesor) {
        this.profesor = profesor;
    }
    public EstudianteEntity getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = estudiante;
    }
    public int getDificult() {
        return dificult;
    }
    public void setDificult(int dificult) {
        this.dificult = dificult;
    }
    public int getNum_credits() {
        return num_credits;
    }
    public void setNum_credits(int num_credits) {
        this.num_credits = num_credits;
    }

}
