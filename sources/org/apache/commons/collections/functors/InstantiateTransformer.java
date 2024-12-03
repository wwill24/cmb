package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.Transformer;

public class InstantiateTransformer implements Transformer, Serializable {
    public static final Transformer NO_ARG_INSTANCE = new InstantiateTransformer();
    static /* synthetic */ Class class$org$apache$commons$collections$functors$InstantiateTransformer = null;
    private static final long serialVersionUID = 3786388740793356347L;
    private final Object[] iArgs;
    private final Class[] iParamTypes;

    private InstantiateTransformer() {
        this.iParamTypes = null;
        this.iArgs = null;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    public static Transformer getInstance(Class[] clsArr, Object[] objArr) {
        if ((clsArr == null && objArr != null) || ((clsArr != null && objArr == null) || (clsArr != null && objArr != null && clsArr.length != objArr.length))) {
            throw new IllegalArgumentException("Parameter types must match the arguments");
        } else if (clsArr == null || clsArr.length == 0) {
            return NO_ARG_INSTANCE;
        } else {
            return new InstantiateTransformer((Class[]) clsArr.clone(), (Object[]) objArr.clone());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class cls = class$org$apache$commons$collections$functors$InstantiateTransformer;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.InstantiateTransformer");
            class$org$apache$commons$collections$functors$InstantiateTransformer = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class cls = class$org$apache$commons$collections$functors$InstantiateTransformer;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.InstantiateTransformer");
            class$org$apache$commons$collections$functors$InstantiateTransformer = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectOutputStream.defaultWriteObject();
    }

    public Object transform(Object obj) {
        String str;
        try {
            if (obj instanceof Class) {
                return ((Class) obj).getConstructor(this.iParamTypes).newInstance(this.iArgs);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("InstantiateTransformer: Input object was not an instanceof Class, it was a ");
            if (obj == null) {
                str = "null object";
            } else {
                str = obj.getClass().getName();
            }
            stringBuffer.append(str);
            throw new FunctorException(stringBuffer.toString());
        } catch (NoSuchMethodException unused) {
            throw new FunctorException("InstantiateTransformer: The constructor must exist and be public ");
        } catch (InstantiationException e10) {
            throw new FunctorException("InstantiateTransformer: InstantiationException", e10);
        } catch (IllegalAccessException e11) {
            throw new FunctorException("InstantiateTransformer: Constructor must be public", e11);
        } catch (InvocationTargetException e12) {
            throw new FunctorException("InstantiateTransformer: Constructor threw an exception", e12);
        }
    }

    public InstantiateTransformer(Class[] clsArr, Object[] objArr) {
        this.iParamTypes = clsArr;
        this.iArgs = objArr;
    }
}
