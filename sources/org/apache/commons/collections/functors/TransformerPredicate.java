package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

public final class TransformerPredicate implements Predicate, Serializable {
    private static final long serialVersionUID = -2407966402920578741L;
    private final Transformer iTransformer;

    public TransformerPredicate(Transformer transformer) {
        this.iTransformer = transformer;
    }

    public static Predicate getInstance(Transformer transformer) {
        if (transformer != null) {
            return new TransformerPredicate(transformer);
        }
        throw new IllegalArgumentException("The transformer to call must not be null");
    }

    public boolean evaluate(Object obj) {
        String str;
        Object transform = this.iTransformer.transform(obj);
        if (transform instanceof Boolean) {
            return ((Boolean) transform).booleanValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Transformer must return an instanceof Boolean, it was a ");
        if (transform == null) {
            str = "null object";
        } else {
            str = transform.getClass().getName();
        }
        stringBuffer.append(str);
        throw new FunctorException(stringBuffer.toString());
    }

    public Transformer getTransformer() {
        return this.iTransformer;
    }
}
