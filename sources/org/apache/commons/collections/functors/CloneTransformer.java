package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections.Transformer;

public class CloneTransformer implements Transformer, Serializable {
    public static final Transformer INSTANCE = new CloneTransformer();
    static /* synthetic */ Class class$org$apache$commons$collections$functors$CloneTransformer = null;
    private static final long serialVersionUID = -8188742709499652567L;

    private CloneTransformer() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    public static Transformer getInstance() {
        return INSTANCE;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class cls = class$org$apache$commons$collections$functors$CloneTransformer;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.CloneTransformer");
            class$org$apache$commons$collections$functors$CloneTransformer = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class cls = class$org$apache$commons$collections$functors$CloneTransformer;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.CloneTransformer");
            class$org$apache$commons$collections$functors$CloneTransformer = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectOutputStream.defaultWriteObject();
    }

    public Object transform(Object obj) {
        if (obj == null) {
            return null;
        }
        return PrototypeFactory.getInstance(obj).create();
    }
}
