package com.universidad.proyectouniversidad.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblroles")
public class RolesEntity {
    @Id
    private long id;
    private String rol;

    @OneToOne(mappedBy = "rol")
    private EstudianteEntity estudianteEntity;

    @OneToOne(mappedBy = "rol")
    private ProfesorEntity profesorEntity;

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

    public EstudianteEntity getEstudianteEntity() {
        return estudianteEntity;
    }

    public void setEstudianteEntity(EstudianteEntity estudianteEntity) {
        this.estudianteEntity = estudianteEntity;
    }
}
