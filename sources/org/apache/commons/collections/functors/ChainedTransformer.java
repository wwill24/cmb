package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Transformer;

public class ChainedTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = 3514945074733160196L;
    private final Transformer[] iTransformers;

    public ChainedTransformer(Transformer[] transformerArr) {
        this.iTransformers = transformerArr;
    }

    public static Transformer getInstance(Transformer[] transformerArr) {
        FunctorUtils.validate(transformerArr);
        if (transformerArr.length == 0) {
            return NOPTransformer.INSTANCE;
        }
        return new ChainedTransformer(FunctorUtils.copy(transformerArr));
    }

    public Transformer[] getTransformers() {
        return this.iTransformers;
    }

    public Object transform(Object obj) {
        int i10 = 0;
        while (true) {
            Transformer[] transformerArr = this.iTransformers;
            if (i10 >= transformerArr.length) {
                return obj;
            }
            obj = transformerArr[i10].transform(obj);
            i10++;
        }
    }

    public static Transformer getInstance(Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Transformer collection must not be null");
        } else if (collection.size() == 0) {
            return NOPTransformer.INSTANCE;
        } else {
            Transformer[] transformerArr = new Transformer[collection.size()];
            int i10 = 0;
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                transformerArr[i10] = (Transformer) it.next();
                i10++;
            }
            FunctorUtils.validate(transformerArr);
            return new ChainedTransformer(transformerArr);
        }
    }

    public static Transformer getInstance(Transformer transformer, Transformer transformer2) {
        if (transformer == null || transformer2 == null) {
            throw new IllegalArgumentException("Transformers must not be null");
        }
        return new ChainedTransformer(new Transformer[]{transformer, transformer2});
    }
}
