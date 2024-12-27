package com.universidad.proyectouniversidad.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblroles")
public class RolesEntity {
    @Id
    private long id;
    @Column(name = "rol", nullable = false)
    private String rol;

    @OneToMany(mappedBy = "rolesEstudiante")
    private List<EstudianteEntity> estudianteEntity;

    @OneToMany(mappedBy = "rolesProfesor")
    private List<ProfesorEntity> profesorEntity;

    public List<ProfesorEntity> getProfesorEntity() {
        return profesorEntity;
    }

    public void setProfesorEntity(List<ProfesorEntity> profesorEntity) {
        this.profesorEntity = profesorEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<EstudianteEntity> getEstudianteEntity() {
        return estudianteEntity;
    }

    public void setEstudianteEntity(List<EstudianteEntity> estudianteEntity) {
        this.estudianteEntity = estudianteEntity;
    }
}
