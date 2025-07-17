package com.example.Seguimiento_Reguimen.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Usuario")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    private String username;

    private String email;

    private String password;

    //relaciones
    // un usuario tiene muchas facturas
    @OneToMany(mappedBy = "usuario")
    private List<FacturaEntity> facturas;

    public UserEntity(){};

    public UserEntity(Long id, String username, String email, String password, List<FacturaEntity> facturas) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.facturas = facturas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<FacturaEntity> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaEntity> facturas) {
        this.facturas = facturas;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", facturas=" + facturas +
                '}';
    }
}
