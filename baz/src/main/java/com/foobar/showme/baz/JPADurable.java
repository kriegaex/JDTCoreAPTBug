package com.foobar.showme.baz;

import java.io.Serializable;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@Access(AccessType.PROPERTY)
public abstract class JPADurable<I extends Serializable & Comparable<I>, D extends JPADurable<I, D>> extends AbstractDurable<I, D> {

  private I id;

  @Override
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false, updatable = false)
  public synchronized I getId () {

    return id;
  }

  @Override
  public synchronized void setId (I id) {

    this.id = id;
  }
}
