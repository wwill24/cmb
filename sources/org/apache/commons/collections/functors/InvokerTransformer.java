package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.Transformer;

public class InvokerTransformer implements Transformer, Serializable {
    static /* synthetic */ Class class$org$apache$commons$collections$functors$InvokerTransformer = null;
    private static final long serialVersionUID = -8653385846894047688L;
    private final Object[] iArgs;
    private final String iMethodName;
    private final Class[] iParamTypes;

    private InvokerTransformer(String str) {
        this.iMethodName = str;
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

    public static Transformer getInstance(String str) {
        if (str != null) {
            return new InvokerTransformer(str);
        }
        throw new IllegalArgumentException("The method to invoke must not be null");
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class cls = class$org$apache$commons$collections$functors$InvokerTransformer;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.InvokerTransformer");
            class$org$apache$commons$collections$functors$InvokerTransformer = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class cls = class$org$apache$commons$collections$functors$InvokerTransformer;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.InvokerTransformer");
            class$org$apache$commons$collections$functors$InvokerTransformer = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectOutputStream.defaultWriteObject();
    }

    public Object transform(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj.getClass().getMethod(this.iMethodName, this.iParamTypes).invoke(obj, this.iArgs);
        } catch (NoSuchMethodException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("InvokerTransformer: The method '");
            stringBuffer.append(this.iMethodName);
            stringBuffer.append("' on '");
            stringBuffer.append(obj.getClass());
            stringBuffer.append("' does not exist");
            throw new FunctorException(stringBuffer.toString());
        } catch (IllegalAccessException unused2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("InvokerTransformer: The method '");
            stringBuffer2.append(this.iMethodName);
            stringBuffer2.append("' on '");
            stringBuffer2.append(obj.getClass());
            stringBuffer2.append("' cannot be accessed");
            throw new FunctorException(stringBuffer2.toString());
        } catch (InvocationTargetException e10) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("InvokerTransformer: The method '");
            stringBuffer3.append(this.iMethodName);
            stringBuffer3.append("' on '");
            stringBuffer3.append(obj.getClass());
            stringBuffer3.append("' threw an exception");
            throw new FunctorException(stringBuffer3.toString(), e10);
        }
    }

    public static Transformer getInstance(String str, Class[] clsArr, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("The method to invoke must not be null");
        } else if ((clsArr == null && objArr != null) || ((clsArr != null && objArr == null) || (clsArr != null && objArr != null && clsArr.length != objArr.length))) {
            throw new IllegalArgumentException("The parameter types must match the arguments");
        } else if (clsArr == null || clsArr.length == 0) {
            return new InvokerTransformer(str);
        } else {
            return new InvokerTransformer(str, (Class[]) clsArr.clone(), (Object[]) objArr.clone());
        }
    }

    public InvokerTransformer(String str, Class[] clsArr, Object[] objArr) {
        this.iMethodName = str;
        this.iParamTypes = clsArr;
        this.iArgs = objArr;
    }
}
