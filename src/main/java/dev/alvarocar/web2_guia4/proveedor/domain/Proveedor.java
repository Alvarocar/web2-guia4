package dev.alvarocar.web2_guia4.proveedor.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@NamedQueries({@NamedQuery(name = "Proveedor.getTodo", query="SELECT e FROM Proveedor e")})
public class Proveedor implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Integer id;
  @Column
  private String nombre;

  public Proveedor() {}

  public Proveedor(Integer id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
