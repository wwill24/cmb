package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Closure;

public class ChainedClosure implements Closure, Serializable {
    private static final long serialVersionUID = -3520677225766901240L;
    private final Closure[] iClosures;

    public ChainedClosure(Closure[] closureArr) {
        this.iClosures = closureArr;
    }

    public static Closure getInstance(Closure[] closureArr) {
        FunctorUtils.validate(closureArr);
        if (closureArr.length == 0) {
            return NOPClosure.INSTANCE;
        }
        return new ChainedClosure(FunctorUtils.copy(closureArr));
    }

    public void execute(Object obj) {
        int i10 = 0;
        while (true) {
            Closure[] closureArr = this.iClosures;
            if (i10 < closureArr.length) {
                closureArr[i10].execute(obj);
                i10++;
            } else {
                return;
            }
        }
    }

    public Closure[] getClosures() {
        return this.iClosures;
    }

    public static Closure getInstance(Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Closure collection must not be null");
        } else if (collection.size() == 0) {
            return NOPClosure.INSTANCE;
        } else {
            Closure[] closureArr = new Closure[collection.size()];
            int i10 = 0;
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                closureArr[i10] = (Closure) it.next();
                i10++;
            }
            FunctorUtils.validate(closureArr);
            return new ChainedClosure(closureArr);
        }
    }

    public static Closure getInstance(Closure closure, Closure closure2) {
        if (closure == null || closure2 == null) {
            throw new IllegalArgumentException("Closures must not be null");
        }
        return new ChainedClosure(new Closure[]{closure, closure2});
    }
}
