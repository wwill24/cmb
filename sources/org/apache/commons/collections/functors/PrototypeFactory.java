package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.FunctorException;

public class PrototypeFactory {
    static /* synthetic */ Class class$org$apache$commons$collections$functors$PrototypeFactory$PrototypeCloneFactory;
    static /* synthetic */ Class class$org$apache$commons$collections$functors$PrototypeFactory$PrototypeSerializationFactory;

    static class PrototypeCloneFactory implements Factory, Serializable {
        private static final long serialVersionUID = 5604271422565175555L;
        private transient Method iCloneMethod;
        private final Object iPrototype;

        private void findCloneMethod() {
            try {
                this.iCloneMethod = this.iPrototype.getClass().getMethod("clone", (Class[]) null);
            } catch (NoSuchMethodException unused) {
                throw new IllegalArgumentException("PrototypeCloneFactory: The clone method must exist and be public ");
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            Class cls = PrototypeFactory.class$org$apache$commons$collections$functors$PrototypeFactory$PrototypeCloneFactory;
            if (cls == null) {
                cls = PrototypeFactory.class$("org.apache.commons.collections.functors.PrototypeFactory$PrototypeCloneFactory");
                PrototypeFactory.class$org$apache$commons$collections$functors$PrototypeFactory$PrototypeCloneFactory = cls;
            }
            FunctorUtils.checkUnsafeSerialization(cls);
            objectInputStream.defaultReadObject();
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Class cls = PrototypeFactory.class$org$apache$commons$collections$functors$PrototypeFactory$PrototypeCloneFactory;
            if (cls == null) {
                cls = PrototypeFactory.class$("org.apache.commons.collections.functors.PrototypeFactory$PrototypeCloneFactory");
                PrototypeFactory.class$org$apache$commons$collections$functors$PrototypeFactory$PrototypeCloneFactory = cls;
            }
            FunctorUtils.checkUnsafeSerialization(cls);
            objectOutputStream.defaultWriteObject();
        }

        public Object create() {
            if (this.iCloneMethod == null) {
                findCloneMethod();
            }
            try {
                return this.iCloneMethod.invoke(this.iPrototype, (Object[]) null);
            } catch (IllegalAccessException e10) {
                throw new FunctorException("PrototypeCloneFactory: Clone method must be public", e10);
            } catch (InvocationTargetException e11) {
                throw new FunctorException("PrototypeCloneFactory: Clone method threw an exception", e11);
            }
        }

        private PrototypeCloneFactory(Object obj, Method method) {
            this.iPrototype = obj;
            this.iCloneMethod = method;
        }
    }

    static class PrototypeSerializationFactory implements Factory, Serializable {
        private static final long serialVersionUID = -8704966966139178833L;
        private final Serializable iPrototype;

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            Class cls = PrototypeFactory.class$org$apache$commons$collections$functors$PrototypeFactory$PrototypeSerializationFactory;
            if (cls == null) {
                cls = PrototypeFactory.class$("org.apache.commons.collections.functors.PrototypeFactory$PrototypeSerializationFactory");
                PrototypeFactory.class$org$apache$commons$collections$functors$PrototypeFactory$PrototypeSerializationFactory = cls;
            }
            FunctorUtils.checkUnsafeSerialization(cls);
            objectInputStream.defaultReadObject();
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Class cls = PrototypeFactory.class$org$apache$commons$collections$functors$PrototypeFactory$PrototypeSerializationFactory;
            if (cls == null) {
                cls = PrototypeFactory.class$("org.apache.commons.collections.functors.PrototypeFactory$PrototypeSerializationFactory");
                PrototypeFactory.class$org$apache$commons$collections$functors$PrototypeFactory$PrototypeSerializationFactory = cls;
            }
            FunctorUtils.checkUnsafeSerialization(cls);
            objectOutputStream.defaultWriteObject();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|(2:26|27)|28|29|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0027 */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x004b A[SYNTHETIC, Splitter:B:26:0x004b] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object create() {
            /*
                r5 = this;
                java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
                r1 = 512(0x200, float:7.175E-43)
                r0.<init>(r1)
                r1 = 0
                java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ ClassNotFoundException -> 0x003e, IOException -> 0x0034, all -> 0x002f }
                r2.<init>(r0)     // Catch:{ ClassNotFoundException -> 0x003e, IOException -> 0x0034, all -> 0x002f }
                java.io.Serializable r3 = r5.iPrototype     // Catch:{ ClassNotFoundException -> 0x003e, IOException -> 0x0034, all -> 0x002f }
                r2.writeObject(r3)     // Catch:{ ClassNotFoundException -> 0x003e, IOException -> 0x0034, all -> 0x002f }
                java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ ClassNotFoundException -> 0x003e, IOException -> 0x0034, all -> 0x002f }
                byte[] r3 = r0.toByteArray()     // Catch:{ ClassNotFoundException -> 0x003e, IOException -> 0x0034, all -> 0x002f }
                r2.<init>(r3)     // Catch:{ ClassNotFoundException -> 0x003e, IOException -> 0x0034, all -> 0x002f }
                java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ ClassNotFoundException -> 0x002d, IOException -> 0x002b }
                r1.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x002d, IOException -> 0x002b }
                java.lang.Object r1 = r1.readObject()     // Catch:{ ClassNotFoundException -> 0x002d, IOException -> 0x002b }
                r2.close()     // Catch:{ IOException -> 0x0027 }
            L_0x0027:
                r0.close()     // Catch:{ IOException -> 0x002a }
            L_0x002a:
                return r1
            L_0x002b:
                r1 = move-exception
                goto L_0x0038
            L_0x002d:
                r1 = move-exception
                goto L_0x0042
            L_0x002f:
                r2 = move-exception
                r4 = r2
                r2 = r1
                r1 = r4
                goto L_0x0049
            L_0x0034:
                r2 = move-exception
                r4 = r2
                r2 = r1
                r1 = r4
            L_0x0038:
                org.apache.commons.collections.FunctorException r3 = new org.apache.commons.collections.FunctorException     // Catch:{ all -> 0x0048 }
                r3.<init>((java.lang.Throwable) r1)     // Catch:{ all -> 0x0048 }
                throw r3     // Catch:{ all -> 0x0048 }
            L_0x003e:
                r2 = move-exception
                r4 = r2
                r2 = r1
                r1 = r4
            L_0x0042:
                org.apache.commons.collections.FunctorException r3 = new org.apache.commons.collections.FunctorException     // Catch:{ all -> 0x0048 }
                r3.<init>((java.lang.Throwable) r1)     // Catch:{ all -> 0x0048 }
                throw r3     // Catch:{ all -> 0x0048 }
            L_0x0048:
                r1 = move-exception
            L_0x0049:
                if (r2 == 0) goto L_0x004e
                r2.close()     // Catch:{ IOException -> 0x004e }
            L_0x004e:
                r0.close()     // Catch:{ IOException -> 0x0051 }
            L_0x0051:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.functors.PrototypeFactory.PrototypeSerializationFactory.create():java.lang.Object");
        }

        private PrototypeSerializationFactory(Serializable serializable) {
            this.iPrototype = serializable;
        }
    }

    private PrototypeFactory() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        if ((r7 instanceof java.io.Serializable) != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        return new org.apache.commons.collections.functors.PrototypeFactory.PrototypeSerializationFactory((java.io.Serializable) r7, (org.apache.commons.collections.functors.PrototypeFactory.AnonymousClass1) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        throw new java.lang.IllegalArgumentException("The prototype must be cloneable via a public clone method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r7.getClass().getConstructor(new java.lang.Class[]{r7.getClass()});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        return new org.apache.commons.collections.functors.InstantiateFactory(r7.getClass(), new java.lang.Class[]{r7.getClass()}, new java.lang.Object[]{r7});
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.commons.collections.Factory getInstance(java.lang.Object r7) {
        /*
            if (r7 != 0) goto L_0x0005
            org.apache.commons.collections.Factory r7 = org.apache.commons.collections.functors.ConstantFactory.NULL_INSTANCE
            return r7
        L_0x0005:
            r0 = 0
            java.lang.Class r1 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x0016 }
            java.lang.String r2 = "clone"
            java.lang.reflect.Method r1 = r1.getMethod(r2, r0)     // Catch:{ NoSuchMethodException -> 0x0016 }
            org.apache.commons.collections.functors.PrototypeFactory$PrototypeCloneFactory r2 = new org.apache.commons.collections.functors.PrototypeFactory$PrototypeCloneFactory     // Catch:{ NoSuchMethodException -> 0x0016 }
            r2.<init>(r7, r1)     // Catch:{ NoSuchMethodException -> 0x0016 }
            return r2
        L_0x0016:
            java.lang.Class r1 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x003d }
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x003d }
            java.lang.Class r4 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x003d }
            r5 = 0
            r3[r5] = r4     // Catch:{ NoSuchMethodException -> 0x003d }
            r1.getConstructor(r3)     // Catch:{ NoSuchMethodException -> 0x003d }
            org.apache.commons.collections.functors.InstantiateFactory r1 = new org.apache.commons.collections.functors.InstantiateFactory     // Catch:{ NoSuchMethodException -> 0x003d }
            java.lang.Class r3 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x003d }
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x003d }
            java.lang.Class r6 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x003d }
            r4[r5] = r6     // Catch:{ NoSuchMethodException -> 0x003d }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x003d }
            r2[r5] = r7     // Catch:{ NoSuchMethodException -> 0x003d }
            r1.<init>(r3, r4, r2)     // Catch:{ NoSuchMethodException -> 0x003d }
            return r1
        L_0x003d:
            boolean r1 = r7 instanceof java.io.Serializable
            if (r1 == 0) goto L_0x0049
            org.apache.commons.collections.functors.PrototypeFactory$PrototypeSerializationFactory r1 = new org.apache.commons.collections.functors.PrototypeFactory$PrototypeSerializationFactory
            java.io.Serializable r7 = (java.io.Serializable) r7
            r1.<init>(r7)
            return r1
        L_0x0049:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "The prototype must be cloneable via a public clone method"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.functors.PrototypeFactory.getInstance(java.lang.Object):org.apache.commons.collections.Factory");
    }
}
