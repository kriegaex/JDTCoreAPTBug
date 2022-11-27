package com.foobar.showme.baz;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@MappedSuperclass
public abstract class TimestampedJPADurable<I extends Serializable & Comparable<I>, D extends TimestampedJPADurable<I, D>> extends JPADurable<I, D> {

  private Date created;
  private Date lastUpdated;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created", nullable = false, updatable = false)
  public synchronized Date getCreated () {

    return created;
  }

  public synchronized D setCreated (Date created) {

    this.created = created;

    return (D)this;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "last_updated")
  public synchronized Date getLastUpdated () {

    return lastUpdated;
  }

  public synchronized D setLastUpdated (Date lastUpdated) {

    this.lastUpdated = lastUpdated;

    return (D)this;
  }
}
