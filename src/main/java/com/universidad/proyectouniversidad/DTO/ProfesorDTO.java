package com.universidad.proyectouniversidad.DTO;

public class ProfesorDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private int telefono;
    private String correo;
    private String area_carrera;
    private String direccion;
    private long idRol;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getArea_carrera() {
        return area_carrera;
    }
    public void setArea_carrera(String area_carrera) {
        this.area_carrera = area_carrera;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public long getIdRol() {
        return idRol;
    }
    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

}
