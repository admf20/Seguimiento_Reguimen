package com.example.Seguimiento_Reguimen.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Factura")
public class FacturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long id;

    private LocalDateTime fecha;

    //relaciones
    //un usuario tiene varias facturas
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserEntity usuario;

    //un proveedor tiene varias facturas
    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private ProveedorEntity proveedor;

    //una factura tiene muchos productos - esta es la relación de la tabla intermedia
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<FacturaProductoEntity> proveedores;

    public FacturaEntity() {}

    public FacturaEntity(Long id, LocalDateTime fecha, UserEntity usuario, ProveedorEntity proveedor, List<FacturaProductoEntity> proveedores) {
        this.id = id;
        this.fecha = fecha;
        this.usuario = usuario;
        this.proveedor = proveedor;
        this.proveedores = proveedores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public List<FacturaProductoEntity> getProductos() {
        return proveedores;
    }

    public void setProductos(List<FacturaProductoEntity> proveedores) {
        this.proveedores = proveedores;
    }

    @Override
    public String toString() {
        return "FacturaEntity{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", usuario=" + usuario +
                ", proveedor=" + proveedor +
                ", proveedores=" + proveedores +
                '}';
    }
}
