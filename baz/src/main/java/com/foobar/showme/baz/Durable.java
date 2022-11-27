package com.foobar.showme.baz;

import java.io.Serializable;

public interface Durable<I extends Serializable & Comparable<I>> extends Serializable, Comparable<Durable<I>> {

  I getId ();

  void setId (I id);
}
