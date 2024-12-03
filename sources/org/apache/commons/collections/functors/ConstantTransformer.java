package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Transformer;

public class ConstantTransformer implements Transformer, Serializable {
    public static final Transformer NULL_INSTANCE = new ConstantTransformer((Object) null);
    private static final long serialVersionUID = 6374440726369055124L;
    private final Object iConstant;

    public ConstantTransformer(Object obj) {
        this.iConstant = obj;
    }

    public static Transformer getInstance(Object obj) {
        if (obj == null) {
            return NULL_INSTANCE;
        }
        return new ConstantTransformer(obj);
    }

    public Object getConstant() {
        return this.iConstant;
    }

    public Object transform(Object obj) {
        return this.iConstant;
    }
}
