package com.example.Seguimiento_Reguimen.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Proveedor")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "contacto", nullable = false)
    private String contacto;

    //relaciones
    @OneToMany(mappedBy = "proveedor")
    private List<ProveedorProductoEntity> productos;

    public ProveedorEntity() {}

    public ProveedorEntity(Long id, String nombre, String contacto, List<ProveedorProductoEntity> productos) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.productos = productos;
    }

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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public List<ProveedorProductoEntity> getProductos() {
        return productos;
    }

    public void setProductos(List<ProveedorProductoEntity> productos) {
        this.productos = productos;
    }
}
