package com.universidad.proyectouniversidad.DTO;

public class MateriaDTO {
    private Long id;
    private int dificultad;
    private String descripcion;
    private int numeroCreditos;
    private long id_estudiante;
    private long id_profesor;
    

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getDificultad() {
        return dificultad;
    }
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
    public int getNumeroCreditos() {
        return numeroCreditos;
    }
    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }
    public long getId_estudiante() {
        return id_estudiante;
    }
    public void setId_estudiante(long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }
    public long getId_profesor() {
        return id_profesor;
    }
    public void setId_profesor(long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
