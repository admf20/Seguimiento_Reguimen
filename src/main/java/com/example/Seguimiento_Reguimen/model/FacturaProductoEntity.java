package com.example.Seguimiento_Reguimen.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Factura_Producto")
public class FacturaProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_cantidad")
    private Double precio;

    //relaciones
    // 🔹 Muchas entradas de esta tabla pertenecen a una factura
    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false)
    private FacturaEntity factura;

    // 🔹 Muchas entradas de esta tabla pertenecen a un producto
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductoEntity producto;

    public FacturaProductoEntity() {}

    public FacturaProductoEntity(Long id, Integer cantidad, Double precio, FacturaEntity factura, ProductoEntity producto) {
        Id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.factura = factura;
        this.producto = producto;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
}
