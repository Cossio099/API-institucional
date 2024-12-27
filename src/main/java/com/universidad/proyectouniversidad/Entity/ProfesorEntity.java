package com.universidad.proyectouniversidad.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblprofesor")
public class ProfesorEntity {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String last_name;
    @Column(name = "phone", nullable = false)
    private int phone;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "area_career", nullable = false)
    private String area_career;
    @Column(name = "address", nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private RolesEntity rolesProfesor;

    @OneToMany(mappedBy = "profesor")
    private List<MateriaEntity> materiasEntity;

    public RolesEntity getRolesEntity() {
        return rolesProfesor;
    }

    public void setRolesEntity(RolesEntity rolesProfesor) {
        this.rolesProfesor = rolesProfesor;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
