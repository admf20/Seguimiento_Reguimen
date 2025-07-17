package com.example.Seguimiento_Reguimen.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Proveedor_Producto")
public class ProveedorProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "precio_base", nullable = false)
    private Double precio;

    //relaciones
    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductoEntity producto;

    public ProveedorProductoEntity() {}

    public ProveedorProductoEntity(Long id, Double precio, ProveedorEntity proveedor, ProductoEntity producto) {
        Id = id;
        this.precio = precio;
        this.proveedor = proveedor;
        this.producto = producto;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
}
