package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.FunctorException;

public class InstantiateFactory implements Factory, Serializable {
    static /* synthetic */ Class class$org$apache$commons$collections$functors$InstantiateFactory = null;
    private static final long serialVersionUID = -7732226881069447957L;
    private final Object[] iArgs;
    private final Class iClassToInstantiate;
    private transient Constructor iConstructor = null;
    private final Class[] iParamTypes;

    public InstantiateFactory(Class cls) {
        this.iClassToInstantiate = cls;
        this.iParamTypes = null;
        this.iArgs = null;
        findConstructor();
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    private void findConstructor() {
        try {
            this.iConstructor = this.iClassToInstantiate.getConstructor(this.iParamTypes);
        } catch (NoSuchMethodException unused) {
            throw new IllegalArgumentException("InstantiateFactory: The constructor must exist and be public ");
        }
    }

    public static Factory getInstance(Class cls, Class[] clsArr, Object[] objArr) {
        if (cls == null) {
            throw new IllegalArgumentException("Class to instantiate must not be null");
        } else if ((clsArr == null && objArr != null) || ((clsArr != null && objArr == null) || (clsArr != null && objArr != null && clsArr.length != objArr.length))) {
            throw new IllegalArgumentException("Parameter types must match the arguments");
        } else if (clsArr == null || clsArr.length == 0) {
            return new InstantiateFactory(cls);
        } else {
            return new InstantiateFactory(cls, (Class[]) clsArr.clone(), (Object[]) objArr.clone());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class cls = class$org$apache$commons$collections$functors$InstantiateFactory;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.InstantiateFactory");
            class$org$apache$commons$collections$functors$InstantiateFactory = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class cls = class$org$apache$commons$collections$functors$InstantiateFactory;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.InstantiateFactory");
            class$org$apache$commons$collections$functors$InstantiateFactory = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectOutputStream.defaultWriteObject();
    }

    public Object create() {
        if (this.iConstructor == null) {
            findConstructor();
        }
        try {
            return this.iConstructor.newInstance(this.iArgs);
        } catch (InstantiationException e10) {
            throw new FunctorException("InstantiateFactory: InstantiationException", e10);
        } catch (IllegalAccessException e11) {
            throw new FunctorException("InstantiateFactory: Constructor must be public", e11);
        } catch (InvocationTargetException e12) {
            throw new FunctorException("InstantiateFactory: Constructor threw an exception", e12);
        }
    }

    public InstantiateFactory(Class cls, Class[] clsArr, Object[] objArr) {
        this.iClassToInstantiate = cls;
        this.iParamTypes = clsArr;
        this.iArgs = objArr;
        findConstructor();
    }
}
