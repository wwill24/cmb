package com.mparticle;

public interface Configuration<T> {
    void apply(T t10);

    Class<T> configures();
}
