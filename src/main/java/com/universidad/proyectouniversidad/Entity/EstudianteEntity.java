package com.universidad.proyectouniversidad.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblestudiante")
public class EstudianteEntity {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private String name;
    private String last_name;
    private int phone;
    private String email;
    private String career;
    private String address;
    @OneToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private RolesEntity rol;
    @OneToMany(mappedBy = "estudiante")
    private List<MateriaEntity> materiasEntity;
    public long getId() {
        return id;
    }
    public RolesEntity getRol() {
        return rol;
    }
    public void setRol(RolesEntity rol) {
        this.rol = rol;
    }
    public List<MateriaEntity> getMateriasEntity() {
        return materiasEntity;
    }
    public void setMateriasEntity(List<MateriaEntity> materiasEntity) {
        this.materiasEntity = materiasEntity;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCareer() {
        return career;
    }
    public void setCareer(String career) {
        this.career = career;
    }
    public String getAdress() {
        return address;
    }
    public void setAdress(String adress) {
        this.address = adress;
    }

}
