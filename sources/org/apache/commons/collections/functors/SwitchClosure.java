package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;

public class SwitchClosure implements Closure, Serializable {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure[] iClosures;
    private final Closure iDefault;
    private final Predicate[] iPredicates;

    public SwitchClosure(Predicate[] predicateArr, Closure[] closureArr, Closure closure) {
        this.iPredicates = predicateArr;
        this.iClosures = closureArr;
        this.iDefault = closure == null ? NOPClosure.INSTANCE : closure;
    }

    public static Closure getInstance(Predicate[] predicateArr, Closure[] closureArr, Closure closure) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(closureArr);
        if (predicateArr.length != closureArr.length) {
            throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
        } else if (predicateArr.length == 0) {
            return closure == null ? NOPClosure.INSTANCE : closure;
        } else {
            return new SwitchClosure(FunctorUtils.copy(predicateArr), FunctorUtils.copy(closureArr), closure);
        }
    }

    public void execute(Object obj) {
        int i10 = 0;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i10 >= predicateArr.length) {
                this.iDefault.execute(obj);
                return;
            } else if (predicateArr[i10].evaluate(obj)) {
                this.iClosures[i10].execute(obj);
                return;
            } else {
                i10++;
            }
        }
    }

    public Closure[] getClosures() {
        return this.iClosures;
    }

    public Closure getDefaultClosure() {
        return this.iDefault;
    }

    public Predicate[] getPredicates() {
        return this.iPredicates;
    }

    public static Closure getInstance(Map map) {
        if (map == null) {
            throw new IllegalArgumentException("The predicate and closure map must not be null");
        } else if (map.size() == 0) {
            return NOPClosure.INSTANCE;
        } else {
            Closure closure = (Closure) map.remove((Object) null);
            int size = map.size();
            if (size == 0) {
                return closure == null ? NOPClosure.INSTANCE : closure;
            }
            Closure[] closureArr = new Closure[size];
            Predicate[] predicateArr = new Predicate[size];
            int i10 = 0;
            for (Map.Entry entry : map.entrySet()) {
                predicateArr[i10] = (Predicate) entry.getKey();
                closureArr[i10] = (Closure) entry.getValue();
                i10++;
            }
            return new SwitchClosure(predicateArr, closureArr, closure);
        }
    }
}
