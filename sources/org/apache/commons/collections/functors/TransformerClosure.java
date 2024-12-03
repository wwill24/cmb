package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Transformer;

public class TransformerClosure implements Closure, Serializable {
    private static final long serialVersionUID = -5194992589193388969L;
    private final Transformer iTransformer;

    public TransformerClosure(Transformer transformer) {
        this.iTransformer = transformer;
    }

    public static Closure getInstance(Transformer transformer) {
        if (transformer == null) {
            return NOPClosure.INSTANCE;
        }
        return new TransformerClosure(transformer);
    }

    public void execute(Object obj) {
        this.iTransformer.transform(obj);
    }

    public Transformer getTransformer() {
        return this.iTransformer;
    }
}
