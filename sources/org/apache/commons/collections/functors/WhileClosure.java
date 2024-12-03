package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;

public class WhileClosure implements Closure, Serializable {
    static /* synthetic */ Class class$org$apache$commons$collections$functors$WhileClosure = null;
    private static final long serialVersionUID = -3110538116913760108L;
    private final Closure iClosure;
    private final boolean iDoLoop;
    private final Predicate iPredicate;

    public WhileClosure(Predicate predicate, Closure closure, boolean z10) {
        this.iPredicate = predicate;
        this.iClosure = closure;
        this.iDoLoop = z10;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    public static Closure getInstance(Predicate predicate, Closure closure, boolean z10) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        } else if (closure != null) {
            return new WhileClosure(predicate, closure, z10);
        } else {
            throw new IllegalArgumentException("Closure must not be null");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class cls = class$org$apache$commons$collections$functors$WhileClosure;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.WhileClosure");
            class$org$apache$commons$collections$functors$WhileClosure = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class cls = class$org$apache$commons$collections$functors$WhileClosure;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.WhileClosure");
            class$org$apache$commons$collections$functors$WhileClosure = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectOutputStream.defaultWriteObject();
    }

    public void execute(Object obj) {
        if (this.iDoLoop) {
            this.iClosure.execute(obj);
        }
        while (this.iPredicate.evaluate(obj)) {
            this.iClosure.execute(obj);
        }
    }

    public Closure getClosure() {
        return this.iClosure;
    }

    public Predicate getPredicate() {
        return this.iPredicate;
    }

    public boolean isDoLoop() {
        return this.iDoLoop;
    }
}
