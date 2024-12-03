package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Transformer;

public final class StringValueTransformer implements Transformer, Serializable {
    public static final Transformer INSTANCE = new StringValueTransformer();
    private static final long serialVersionUID = 7511110693171758606L;

    private StringValueTransformer() {
    }

    public static Transformer getInstance() {
        return INSTANCE;
    }

    public Object transform(Object obj) {
        return String.valueOf(obj);
    }
}
