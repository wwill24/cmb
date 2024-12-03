package com.google.firebase.components;

import java.util.List;

public interface ComponentRegistrarProcessor {
    public static final ComponentRegistrarProcessor NOOP = new g();

    List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar);
}
