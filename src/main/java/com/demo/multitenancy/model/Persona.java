package com.demo.multitenancy.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/** Persona data model. */
@Entity
@Table(name = "personas")
public class Persona extends EntityBase {

  /** First name. */
  private String nombre;

  private String apellido;

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(final String firstName) {
    this.nombre = firstName;
  }

  public String getApellido() {
    return this.apellido;
  }

  public void setApellido(final String lastname) {
    this.apellido = lastname;
  }

  @Override
  public String toString() {
    return "Persona [nombre=" + this.nombre + ", apellido=" + this.apellido
        + "]";
  }
}

