package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections.Closure;

public class ForClosure implements Closure, Serializable {
    static /* synthetic */ Class class$org$apache$commons$collections$functors$ForClosure = null;
    private static final long serialVersionUID = -1190120533393621674L;
    private final Closure iClosure;
    private final int iCount;

    public ForClosure(int i10, Closure closure) {
        this.iCount = i10;
        this.iClosure = closure;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    public static Closure getInstance(int i10, Closure closure) {
        if (i10 <= 0 || closure == null) {
            return NOPClosure.INSTANCE;
        }
        if (i10 == 1) {
            return closure;
        }
        return new ForClosure(i10, closure);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class cls = class$org$apache$commons$collections$functors$ForClosure;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.ForClosure");
            class$org$apache$commons$collections$functors$ForClosure = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class cls = class$org$apache$commons$collections$functors$ForClosure;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.ForClosure");
            class$org$apache$commons$collections$functors$ForClosure = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectOutputStream.defaultWriteObject();
    }

    public void execute(Object obj) {
        for (int i10 = 0; i10 < this.iCount; i10++) {
            this.iClosure.execute(obj);
        }
    }

    public Closure getClosure() {
        return this.iClosure;
    }

    public int getCount() {
        return this.iCount;
    }
}
