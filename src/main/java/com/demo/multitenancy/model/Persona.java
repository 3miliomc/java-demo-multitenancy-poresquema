package com.demo.multitenancy.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/** Person data model. */
@Entity
@Table(name = "gente")
public class Persona extends EntityBase {

  /** First name. */
  private String firstName;

  /** Last name. */
  private String lastName;

  /** First name getter. */
  public String getFirstName() {
    return this.firstName;
  }

  /** First name setter. */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /** Last name getter. */
  public String getLastName() {
    return this.lastName;
  }

  /** Last name setter. */
  public void setLastName(final String lastname) {
    this.lastName = lastname;
  }

  /** String representation. */
  @Override
  public String toString() {
    return "Person [firstName=" + this.firstName + ", lastName=" + this.lastName
        + "]";
  }
}

