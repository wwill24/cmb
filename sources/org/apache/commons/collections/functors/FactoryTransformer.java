package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.Transformer;

public class FactoryTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = -6817674502475353160L;
    private final Factory iFactory;

    public FactoryTransformer(Factory factory) {
        this.iFactory = factory;
    }

    public static Transformer getInstance(Factory factory) {
        if (factory != null) {
            return new FactoryTransformer(factory);
        }
        throw new IllegalArgumentException("Factory must not be null");
    }

    public Factory getFactory() {
        return this.iFactory;
    }

    public Object transform(Object obj) {
        return this.iFactory.create();
    }
}
