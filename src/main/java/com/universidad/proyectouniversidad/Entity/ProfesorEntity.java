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
@Table(name = "tblprofesor")
public class ProfesorEntity {

    @Id
    @Column(name = "id")
    private long id;
    private String name;
    private String last_name;
    private int phone;
    private String email;
    private String area_career;
    private String adress;

    @OneToOne
    @JoinColumn(name = "id_rol")
    private RolesEntity rol;

    @OneToMany(mappedBy = "profesor")
    private List<MateriaEntity> materiasEntity;

    public RolesEntity getRolesEntity() {
        return rol;
    }

    public void setRolesEntity(RolesEntity rol) {
        this.rol = rol;
    }

    public List<MateriaEntity> getMateriasEntity() {
        return materiasEntity;
    }

    public void setMateriasEntity(List<MateriaEntity> materiasEntity) {
        this.materiasEntity = materiasEntity;
    }

    public long getId() {
        return id;
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

    public String getArea_career() {
        return area_career;
    }

    public void setArea_career(String area_career) {
        this.area_career = area_career;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

}
