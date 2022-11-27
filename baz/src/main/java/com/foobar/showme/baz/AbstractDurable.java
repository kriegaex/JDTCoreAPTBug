package com.foobar.showme.baz;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractDurable<I extends Serializable & Comparable<I>, D extends AbstractDurable<I, D>> implements Durable<I> {

  private static final ThreadLocal<Set<Durable<?>>> IN_USE_SET_LOCAL = ThreadLocal.withInitial(HashSet::new);

  public int compareTo (Durable<I> durable) {

    if (!this.getClass().isAssignableFrom(durable.getClass())) {
      throw new RuntimeException("This is an error");
    }

    if (getId() == null) {
      if (durable.getId() == null) {

        return 0;
      } else {

        return -1;
      }
    }

    if (durable.getId() == null) {

      return 1;
    }

    return durable.getId().compareTo(getId());
  }

  @Override
  public int hashCode () {

    if (getId() == null) {

      return super.hashCode();
    }

    int h = getId().hashCode();

    h ^= (h >>> 20) ^ (h >>> 12);

    return h ^ (h >>> 7) ^ (h >>> 4);
  }

  @Override
  public boolean equals (Object obj) {

    if (obj instanceof Durable) {
      if ((((Durable<?>)obj).getId() == null) || (getId() == null)) {
        return super.equals(obj);
      } else {
        return ((Durable<?>)obj).getId().equals(getId());
      }
    }

    return false;
  }
}
