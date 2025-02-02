package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "departamentos")
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
            generator = "departamentos_clave_seq")
    @SequenceGenerator(name = "departamentos_clave_seq",
            sequenceName = "departamentos_clave_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "clave")
    private long clave;

    private String nombre;
    
    // Relación @OneToMany a Empleado, usando una sola lista para evitar duplicación
    @JsonIgnore
    @OneToMany(mappedBy = "depto", fetch = FetchType.LAZY)
    private List<Empleado> empleados;

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
