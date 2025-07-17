package com.example.Seguimiento_Reguimen.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String description;

    //relaciones
    //un producto tiene varios proveedores - se hace la relación con la tabla intermedia
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ProveedorProductoEntity> proveedores;

    public ProductoEntity() {}

    public ProductoEntity(Long id, String nombre, String description, List<ProveedorProductoEntity> proveedores) {
        id = id;
        this.nombre = nombre;
        this.description = description;
        this.proveedores = proveedores;
    }

    public Long getid() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProveedorProductoEntity> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<ProveedorProductoEntity> proveedores) {
        this.proveedores = proveedores;
    }
}
