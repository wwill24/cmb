package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

public class SwitchTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = -6404460890903469332L;
    private final Transformer iDefault;
    private final Predicate[] iPredicates;
    private final Transformer[] iTransformers;

    public SwitchTransformer(Predicate[] predicateArr, Transformer[] transformerArr, Transformer transformer) {
        this.iPredicates = predicateArr;
        this.iTransformers = transformerArr;
        this.iDefault = transformer == null ? ConstantTransformer.NULL_INSTANCE : transformer;
    }

    public static Transformer getInstance(Predicate[] predicateArr, Transformer[] transformerArr, Transformer transformer) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(transformerArr);
        if (predicateArr.length != transformerArr.length) {
            throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
        } else if (predicateArr.length == 0) {
            return transformer == null ? ConstantTransformer.NULL_INSTANCE : transformer;
        } else {
            return new SwitchTransformer(FunctorUtils.copy(predicateArr), FunctorUtils.copy(transformerArr), transformer);
        }
    }

    public Transformer getDefaultTransformer() {
        return this.iDefault;
    }

    public Predicate[] getPredicates() {
        return this.iPredicates;
    }

    public Transformer[] getTransformers() {
        return this.iTransformers;
    }

    public Object transform(Object obj) {
        int i10 = 0;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i10 >= predicateArr.length) {
                return this.iDefault.transform(obj);
            }
            if (predicateArr[i10].evaluate(obj)) {
                return this.iTransformers[i10].transform(obj);
            }
            i10++;
        }
    }

    public static Transformer getInstance(Map map) {
        if (map == null) {
            throw new IllegalArgumentException("The predicate and transformer map must not be null");
        } else if (map.size() == 0) {
            return ConstantTransformer.NULL_INSTANCE;
        } else {
            Transformer transformer = (Transformer) map.remove((Object) null);
            int size = map.size();
            if (size == 0) {
                return transformer == null ? ConstantTransformer.NULL_INSTANCE : transformer;
            }
            Transformer[] transformerArr = new Transformer[size];
            Predicate[] predicateArr = new Predicate[size];
            int i10 = 0;
            for (Map.Entry entry : map.entrySet()) {
                predicateArr[i10] = (Predicate) entry.getKey();
                transformerArr[i10] = (Transformer) entry.getValue();
                i10++;
            }
            return new SwitchTransformer(predicateArr, transformerArr, transformer);
        }
    }
}
