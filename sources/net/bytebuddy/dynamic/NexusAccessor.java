package net.bytebuddy.dynamic;

import com.facebook.internal.ServerProtocol;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassInjector;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class NexusAccessor {
    private static final boolean ACCESS_CONTROLLER;
    private static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(Dispatcher.CreationAction.INSTANCE));
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    @MaybeNull
    private final ReferenceQueue<? super ClassLoader> referenceQueue;

    protected interface Dispatcher {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Available implements Dispatcher {
            private final Method clean;
            private final Method register;

            protected Available(Method method, Method method2) {
                this.register = method;
                this.clean = method2;
            }

            public void clean(Reference<? extends ClassLoader> reference) {
                try {
                    this.clean.invoke((Object) null, new Object[]{reference});
                } catch (IllegalAccessException e10) {
                    throw new IllegalStateException(e10);
                } catch (InvocationTargetException e11) {
                    throw new IllegalStateException(e11.getTargetException());
                }
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Available available = (Available) obj;
                return this.register.equals(available.register) && this.clean.equals(available.clean);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.register.hashCode()) * 31) + this.clean.hashCode();
            }

            public boolean isAlive() {
                return true;
            }

            public void register(String str, @MaybeNull ClassLoader classLoader, @MaybeNull ReferenceQueue<? super ClassLoader> referenceQueue, int i10, LoadedTypeInitializer loadedTypeInitializer) {
                try {
                    this.register.invoke((Object) null, new Object[]{str, classLoader, referenceQueue, Integer.valueOf(i10), loadedTypeInitializer});
                } catch (IllegalAccessException e10) {
                    throw new IllegalStateException(e10);
                } catch (InvocationTargetException e11) {
                    throw new IllegalStateException(e11.getTargetException());
                }
            }
        }

        public enum CreationAction implements PrivilegedAction<Dispatcher> {
            INSTANCE;

            @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
            public Dispatcher run() {
                Class<Object> cls = Object.class;
                Class<String> cls2 = String.class;
                if (Boolean.getBoolean(Nexus.PROPERTY)) {
                    return new Unavailable("Nexus injection was explicitly disabled");
                }
                try {
                    Class cls3 = new ClassInjector.UsingReflection(ClassLoader.getSystemClassLoader(), ClassLoadingStrategy.NO_PROTECTION_DOMAIN).inject(Collections.singletonMap(TypeDescription.ForLoadedType.of(Nexus.class), ClassFileLocator.ForClassLoader.read((Class<?>) Nexus.class))).get(TypeDescription.ForLoadedType.of(Nexus.class));
                    return new Available(cls3.getMethod("register", new Class[]{cls2, ClassLoader.class, ReferenceQueue.class, Integer.TYPE, cls}), cls3.getMethod("clean", new Class[]{Reference.class}));
                } catch (Exception e10) {
                    try {
                        Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(Nexus.class.getName());
                        try {
                            JavaModule ofType = JavaModule.ofType(NexusAccessor.class);
                            JavaModule ofType2 = JavaModule.ofType(loadClass);
                            if (ofType != null && !ofType.canRead(ofType2)) {
                                Class<?> cls4 = Class.forName("java.lang.Module");
                                cls4.getMethod("addReads", new Class[]{cls4}).invoke(ofType.unwrap(), new Object[]{ofType2.unwrap()});
                            }
                            return new Available(loadClass.getMethod("register", new Class[]{cls2, ClassLoader.class, ReferenceQueue.class, Integer.TYPE, cls}), loadClass.getMethod("clean", new Class[]{Reference.class}));
                        } catch (Exception e11) {
                            return new Unavailable(e11.toString());
                        }
                    } catch (Exception unused) {
                        return new Unavailable(e10.toString());
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Unavailable implements Dispatcher {
            private final String message;

            protected Unavailable(String str) {
                this.message = str;
            }

            public void clean(Reference<? extends ClassLoader> reference) {
                throw new UnsupportedOperationException("Could not initialize Nexus accessor: " + this.message);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.message.hashCode();
            }

            public boolean isAlive() {
                return false;
            }

            public void register(String str, @MaybeNull ClassLoader classLoader, @MaybeNull ReferenceQueue<? super ClassLoader> referenceQueue, int i10, LoadedTypeInitializer loadedTypeInitializer) {
                throw new UnsupportedOperationException("Could not initialize Nexus accessor: " + this.message);
            }
        }

        void clean(Reference<? extends ClassLoader> reference);

        boolean isAlive();

        void register(String str, @MaybeNull ClassLoader classLoader, @MaybeNull ReferenceQueue<? super ClassLoader> referenceQueue, int i10, LoadedTypeInitializer loadedTypeInitializer);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class InitializationAppender implements ByteCodeAppender {
        private final int identification;

        public InitializationAppender(int i10) {
            this.identification = i10;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Class<Object> cls = Object.class;
            Class<String> cls2 = String.class;
            try {
                StackManipulation[] stackManipulationArr = new StackManipulation[1];
                StackManipulation[] stackManipulationArr2 = new StackManipulation[10];
                stackManipulationArr2[0] = MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(ClassLoader.class.getMethod("getSystemClassLoader", new Class[0])));
                stackManipulationArr2[1] = new TextConstant(Nexus.class.getName());
                stackManipulationArr2[2] = MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(ClassLoader.class.getMethod("loadClass", new Class[]{cls2})));
                stackManipulationArr2[3] = new TextConstant("initialize");
                ArrayFactory forType = ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Class.class));
                Class cls3 = Integer.TYPE;
                stackManipulationArr2[4] = forType.withValues(Arrays.asList(new StackManipulation[]{ClassConstant.of(TypeDescription.ForLoadedType.of(Class.class)), ClassConstant.of(TypeDescription.ForLoadedType.of(cls3))}));
                stackManipulationArr2[5] = MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(Class.class.getMethod("getMethod", new Class[]{cls2, Class[].class})));
                stackManipulationArr2[6] = NullConstant.INSTANCE;
                ArrayFactory forType2 = ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(cls));
                StackManipulation[] stackManipulationArr3 = new StackManipulation[2];
                stackManipulationArr3[0] = ClassConstant.of(methodDescription.getDeclaringType().asErasure());
                StackManipulation[] stackManipulationArr4 = new StackManipulation[2];
                try {
                    stackManipulationArr4[0] = IntegerConstant.forValue(this.identification);
                    stackManipulationArr4[1] = MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(Integer.class.getMethod("valueOf", new Class[]{cls3})));
                    stackManipulationArr3[1] = new StackManipulation.Compound(stackManipulationArr4);
                    stackManipulationArr2[7] = forType2.withValues(Arrays.asList(stackManipulationArr3));
                    stackManipulationArr2[8] = MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(Method.class.getMethod("invoke", new Class[]{cls, Object[].class})));
                    stackManipulationArr2[9] = Removal.SINGLE;
                    stackManipulationArr[0] = new StackManipulation.Compound(stackManipulationArr2);
                    return new ByteCodeAppender.Simple(stackManipulationArr).apply(methodVisitor, context, methodDescription);
                } catch (NoSuchMethodException e10) {
                    e = e10;
                    throw new IllegalStateException("Cannot locate method", e);
                }
            } catch (NoSuchMethodException e11) {
                e = e11;
                throw new IllegalStateException("Cannot locate method", e);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.identification == ((InitializationAppender) obj).identification;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.identification;
        }
    }

    static {
        boolean z10 = false;
        try {
            Class.forName("java.security.AccessController", false, (ClassLoader) null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        } catch (ClassNotFoundException unused) {
        } catch (SecurityException unused2) {
            z10 = true;
        }
        ACCESS_CONTROLLER = z10;
    }

    public NexusAccessor() {
        this((ReferenceQueue<? super ClassLoader>) null);
    }

    public static void clean(Reference<? extends ClassLoader> reference) {
        DISPATCHER.clean(reference);
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static boolean isAlive() {
        return DISPATCHER.isAlive();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0027 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r5 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L_0x0013
            return r1
        L_0x0013:
            java.lang.ref.ReferenceQueue<? super java.lang.ClassLoader> r2 = r4.referenceQueue
            net.bytebuddy.dynamic.NexusAccessor r5 = (net.bytebuddy.dynamic.NexusAccessor) r5
            java.lang.ref.ReferenceQueue<? super java.lang.ClassLoader> r5 = r5.referenceQueue
            if (r5 == 0) goto L_0x0024
            if (r2 == 0) goto L_0x0026
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0027
            return r1
        L_0x0024:
            if (r2 == 0) goto L_0x0027
        L_0x0026:
            return r1
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.NexusAccessor.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = getClass().hashCode() * 31;
        ReferenceQueue<? super ClassLoader> referenceQueue2 = this.referenceQueue;
        return referenceQueue2 != null ? hashCode + referenceQueue2.hashCode() : hashCode;
    }

    public void register(String str, @MaybeNull ClassLoader classLoader, int i10, LoadedTypeInitializer loadedTypeInitializer) {
        if (loadedTypeInitializer.isAlive()) {
            DISPATCHER.register(str, classLoader, this.referenceQueue, i10, loadedTypeInitializer);
        }
    }

    public NexusAccessor(@MaybeNull ReferenceQueue<? super ClassLoader> referenceQueue2) {
        this.referenceQueue = referenceQueue2;
    }
}
