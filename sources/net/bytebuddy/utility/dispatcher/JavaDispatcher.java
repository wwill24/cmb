package net.bytebuddy.utility.dispatcher;

import com.facebook.internal.ServerProtocol;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.utility.Invoker;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

@HashCodeAndEqualsPlugin.Enhance
public class JavaDispatcher<T> implements PrivilegedAction<T> {
    private static final boolean ACCESS_CONTROLLER;
    private static final boolean GENERATE = Boolean.parseBoolean((String) doPrivileged(new GetSystemPropertyAction(GENERATE_PROPERTY)));
    public static final String GENERATE_PROPERTY = "net.bytebuddy.generate";
    /* access modifiers changed from: private */
    public static final Invoker INVOKER = ((Invoker) doPrivileged(new InvokerCreationAction()));
    /* access modifiers changed from: private */
    public static final DynamicClassLoader.Resolver RESOLVER = ((DynamicClassLoader.Resolver) doPrivileged(DynamicClassLoader.Resolver.CreationAction.INSTANCE));
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    @MaybeNull
    private final ClassLoader classLoader;
    private final boolean generate;
    private final Class<T> proxy;

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Container {
    }

    @Documented
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Defaults {
    }

    @HashCodeAndEqualsPlugin.Enhance
    private static class DirectInvoker implements Invoker {
        private DirectInvoker() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return getClass().hashCode();
        }

        public Object invoke(Method method, @MaybeNull Object obj, @MaybeNull Object[] objArr) throws IllegalAccessException, InvocationTargetException {
            return method.invoke(obj, objArr);
        }

        public Object newInstance(Constructor<?> constructor, Object[] objArr) throws InstantiationException, IllegalAccessException, InvocationTargetException {
            return constructor.newInstance(objArr);
        }
    }

    protected interface Dispatcher {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForConstructor implements Dispatcher {
            private final Constructor<?> constructor;

            protected ForConstructor(Constructor<?> constructor2) {
                this.constructor = constructor2;
            }

            public int apply(MethodVisitor methodVisitor, Method method) {
                Class[] parameterTypes = method.getParameterTypes();
                Class[] parameterTypes2 = this.constructor.getParameterTypes();
                methodVisitor.visitTypeInsn(Opcodes.NEW, Type.getInternalName(this.constructor.getDeclaringClass()));
                methodVisitor.visitInsn(89);
                int i10 = 1;
                for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                    Type type = Type.getType((Class<?>) parameterTypes[i11]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), i10);
                    Class cls = parameterTypes[i11];
                    Class cls2 = parameterTypes2[i11];
                    if (cls != cls2) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(cls2));
                    }
                    i10 += type.getSize();
                }
                methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getInternalName(this.constructor.getDeclaringClass()), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getConstructorDescriptor(this.constructor), false);
                methodVisitor.visitInsn(Opcodes.ARETURN);
                return i10 + 1;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.constructor.equals(((ForConstructor) obj).constructor);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.constructor.hashCode();
            }

            public Object invoke(Object[] objArr) throws Throwable {
                return JavaDispatcher.INVOKER.newInstance(this.constructor, objArr);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForContainerCreation implements Dispatcher {
            private final Class<?> target;

            protected ForContainerCreation(Class<?> cls) {
                this.target = cls;
            }

            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitVarInsn(21, 1);
                methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, Type.getInternalName(this.target));
                methodVisitor.visitInsn(Opcodes.ARETURN);
                return 1;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForContainerCreation) obj).target);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.target.hashCode();
            }

            public Object invoke(Object[] objArr) {
                return Array.newInstance(this.target, objArr[0].intValue());
            }
        }

        public enum ForDefaultValue implements Dispatcher {
            VOID((String) null, 0, Opcodes.RETURN, 0),
            BOOLEAN(Boolean.FALSE, 3, Opcodes.IRETURN, 1),
            BOOLEAN_REVERSE(Boolean.TRUE, 4, Opcodes.IRETURN, 1),
            BYTE((byte) 0, 3, Opcodes.IRETURN, 1),
            SHORT((short) 0, 3, Opcodes.IRETURN, 1),
            CHARACTER(0, 3, Opcodes.IRETURN, 1),
            INTEGER(0, 3, Opcodes.IRETURN, 1),
            LONG(0L, 9, Opcodes.LRETURN, 2),
            FLOAT(Float.valueOf(0.0f), 11, Opcodes.FRETURN, 1),
            DOUBLE(Double.valueOf(0.0d), 14, Opcodes.DRETURN, 2),
            REFERENCE((String) null, 1, Opcodes.ARETURN, 1);
            
            private final int load;
            private final int returned;
            private final int size;
            @MaybeNull
            private final Object value;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class OfNonPrimitiveArray implements Dispatcher {
                private final Class<?> componentType;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
                private final Object value;

                protected OfNonPrimitiveArray(Object obj, Class<?> cls) {
                    this.value = obj;
                    this.componentType = cls;
                }

                protected static Dispatcher of(Class<?> cls) {
                    return new OfNonPrimitiveArray(Array.newInstance(cls, 0), cls);
                }

                public int apply(MethodVisitor methodVisitor, Method method) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, Type.getInternalName(this.componentType));
                    methodVisitor.visitInsn(Opcodes.ARETURN);
                    return 1;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.componentType.equals(((OfNonPrimitiveArray) obj).componentType);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.componentType.hashCode();
                }

                public Object invoke(Object[] objArr) {
                    return this.value;
                }
            }

            protected enum OfPrimitiveArray implements Dispatcher {
                BOOLEAN(new boolean[0], 4),
                BYTE(new byte[0], 8),
                SHORT(new short[0], 9),
                CHARACTER(new char[0], 5),
                INTEGER(new int[0], 10),
                LONG(new long[0], 11),
                FLOAT(new float[0], 6),
                DOUBLE(new double[0], 7);
                
                private final int operand;
                private final Object value;

                private OfPrimitiveArray(Object obj, int i10) {
                    this.value = obj;
                    this.operand = i10;
                }

                public int apply(MethodVisitor methodVisitor, Method method) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitIntInsn(188, this.operand);
                    methodVisitor.visitInsn(Opcodes.ARETURN);
                    return 1;
                }

                public Object invoke(Object[] objArr) {
                    return this.value;
                }
            }

            private ForDefaultValue(@MaybeNull Object obj, int i10, int i11, int i12) {
                this.value = obj;
                this.load = i10;
                this.returned = i11;
                this.size = i12;
            }

            protected static Dispatcher of(Class<?> cls) {
                if (cls == Void.TYPE) {
                    return VOID;
                }
                Class<?> cls2 = Boolean.TYPE;
                if (cls == cls2) {
                    return BOOLEAN;
                }
                if (cls == Byte.TYPE) {
                    return BYTE;
                }
                if (cls == Short.TYPE) {
                    return SHORT;
                }
                if (cls == Character.TYPE) {
                    return CHARACTER;
                }
                Class<?> cls3 = Integer.TYPE;
                if (cls == cls3) {
                    return INTEGER;
                }
                Class<?> cls4 = Long.TYPE;
                if (cls == cls4) {
                    return LONG;
                }
                Class<?> cls5 = Float.TYPE;
                if (cls == cls5) {
                    return FLOAT;
                }
                if (cls == Double.TYPE) {
                    return DOUBLE;
                }
                if (!cls.isArray()) {
                    return REFERENCE;
                }
                if (cls.getComponentType() == cls2) {
                    return OfPrimitiveArray.BOOLEAN;
                }
                if (cls.getComponentType() == Byte.TYPE) {
                    return OfPrimitiveArray.BYTE;
                }
                if (cls.getComponentType() == Short.TYPE) {
                    return OfPrimitiveArray.SHORT;
                }
                if (cls.getComponentType() == Character.TYPE) {
                    return OfPrimitiveArray.CHARACTER;
                }
                if (cls.getComponentType() == cls3) {
                    return OfPrimitiveArray.INTEGER;
                }
                if (cls.getComponentType() == cls4) {
                    return OfPrimitiveArray.LONG;
                }
                if (cls.getComponentType() == cls5) {
                    return OfPrimitiveArray.FLOAT;
                }
                if (cls.getComponentType() == Double.TYPE) {
                    return OfPrimitiveArray.DOUBLE;
                }
                return OfNonPrimitiveArray.of(cls.getComponentType());
            }

            public int apply(MethodVisitor methodVisitor, Method method) {
                int i10 = this.load;
                if (i10 != 0) {
                    methodVisitor.visitInsn(i10);
                }
                methodVisitor.visitInsn(this.returned);
                return this.size;
            }

            @MaybeNull
            public Object invoke(Object[] objArr) {
                return this.value;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForInstanceCheck implements Dispatcher {
            private final Class<?> target;

            protected ForInstanceCheck(Class<?> cls) {
                this.target = cls;
            }

            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, Type.getInternalName(this.target));
                methodVisitor.visitInsn(Opcodes.IRETURN);
                return 1;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForInstanceCheck) obj).target);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.target.hashCode();
            }

            public Object invoke(Object[] objArr) {
                return Boolean.valueOf(this.target.isInstance(objArr[0]));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForNonStaticMethod implements Dispatcher {
            private static final Object[] NO_ARGUMENTS = new Object[0];
            private final Method method;

            protected ForNonStaticMethod(Method method2) {
                this.method = method2;
            }

            public int apply(MethodVisitor methodVisitor, Method method2) {
                int i10;
                Class<?> cls;
                Class<?> cls2;
                Class<?>[] parameterTypes = method2.getParameterTypes();
                Class<?>[] parameterTypes2 = this.method.getParameterTypes();
                int i11 = 1;
                for (int i12 = 0; i12 < parameterTypes.length; i12++) {
                    Type type = Type.getType(parameterTypes[i12]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), i11);
                    Class<?> cls3 = parameterTypes[i12];
                    if (i12 == 0) {
                        cls = this.method.getDeclaringClass();
                    } else {
                        cls = parameterTypes2[i12 - 1];
                    }
                    if (cls3 != cls) {
                        if (i12 == 0) {
                            cls2 = this.method.getDeclaringClass();
                        } else {
                            cls2 = parameterTypes2[i12 - 1];
                        }
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(cls2));
                    }
                    i11 += type.getSize();
                }
                if (this.method.getDeclaringClass().isInterface()) {
                    i10 = Opcodes.INVOKEINTERFACE;
                } else {
                    i10 = Opcodes.INVOKEVIRTUAL;
                }
                methodVisitor.visitMethodInsn(i10, Type.getInternalName(this.method.getDeclaringClass()), this.method.getName(), Type.getMethodDescriptor(this.method), this.method.getDeclaringClass().isInterface());
                methodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(Opcodes.IRETURN));
                return Math.max(i11 - 1, Type.getReturnType(this.method).getSize());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForNonStaticMethod) obj).method);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.method.hashCode();
            }

            public Object invoke(Object[] objArr) throws Throwable {
                Object[] objArr2;
                if (objArr.length == 1) {
                    objArr2 = NO_ARGUMENTS;
                } else {
                    int length = objArr.length - 1;
                    Object[] objArr3 = new Object[length];
                    System.arraycopy(objArr, 1, objArr3, 0, length);
                    objArr2 = objArr3;
                }
                return JavaDispatcher.INVOKER.invoke(this.method, objArr[0], objArr2);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForStaticMethod implements Dispatcher {
            private final Method method;

            protected ForStaticMethod(Method method2) {
                this.method = method2;
            }

            public int apply(MethodVisitor methodVisitor, Method method2) {
                Class[] parameterTypes = method2.getParameterTypes();
                Class[] parameterTypes2 = this.method.getParameterTypes();
                int i10 = 1;
                for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                    Type type = Type.getType((Class<?>) parameterTypes[i11]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), i10);
                    Class cls = parameterTypes[i11];
                    Class cls2 = parameterTypes2[i11];
                    if (cls != cls2) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(cls2));
                    }
                    i10 += type.getSize();
                }
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(this.method.getDeclaringClass()), this.method.getName(), Type.getMethodDescriptor(this.method), this.method.getDeclaringClass().isInterface());
                methodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(Opcodes.IRETURN));
                return Math.max(i10 - 1, Type.getReturnType(this.method).getSize());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForStaticMethod) obj).method);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.method.hashCode();
            }

            @MaybeNull
            public Object invoke(Object[] objArr) throws Throwable {
                return JavaDispatcher.INVOKER.invoke(this.method, (Object) null, objArr);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForUnresolvedMethod implements Dispatcher {
            private final String message;

            protected ForUnresolvedMethod(String str) {
                this.message = str;
            }

            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitTypeInsn(Opcodes.NEW, Type.getInternalName(IllegalStateException.class));
                methodVisitor.visitInsn(89);
                methodVisitor.visitLdcInsn(this.message);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getInternalName(IllegalStateException.class), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType((Class<?>) String.class)), false);
                methodVisitor.visitInsn(Opcodes.ATHROW);
                return 3;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.message.equals(((ForUnresolvedMethod) obj).message);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.message.hashCode();
            }

            public Object invoke(Object[] objArr) throws Throwable {
                throw new IllegalStateException("Could not invoke proxy: " + this.message);
            }
        }

        int apply(MethodVisitor methodVisitor, Method method);

        @MaybeNull
        Object invoke(Object[] objArr) throws Throwable;
    }

    protected static class DynamicClassLoader extends ClassLoader {
        @MaybeNull
        private static final String DUMP_FOLDER;
        private static final Object[] NO_ARGUMENT = new Object[0];
        private static final Class<?>[] NO_PARAMETER = new Class[0];

        protected interface Resolver {

            public enum CreationAction implements PrivilegedAction<Resolver> {
                INSTANCE;

                @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
                public Resolver run() {
                    Class<String> cls = String.class;
                    try {
                        Class<?> cls2 = Class.forName("java.lang.Module", false, (ClassLoader) null);
                        return new ForModuleSystem(Class.class.getMethod("getModule", new Class[0]), cls2.getMethod("isExported", new Class[]{cls}), cls2.getMethod("addExports", new Class[]{cls, cls2}), ClassLoader.class.getMethod("getUnnamedModule", new Class[0]));
                    } catch (Exception unused) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForModuleSystem implements Resolver {
                private final Method addExports;
                private final Method getModule;
                private final Method getUnnamedModule;
                private final Method isExported;

                protected ForModuleSystem(Method method, Method method2, Method method3, Method method4) {
                    this.getModule = method;
                    this.isExported = method2;
                    this.addExports = method3;
                    this.getUnnamedModule = method4;
                }

                @SuppressFBWarnings(justification = "Exception should always be wrapped for clarity.", value = {"REC_CATCH_EXCEPTION"})
                public void accept(@MaybeNull ClassLoader classLoader, Class<?> cls) {
                    Package packageR = cls.getPackage();
                    if (packageR != null) {
                        try {
                            Object invoke = this.getModule.invoke(cls, new Object[0]);
                            if (!((Boolean) this.isExported.invoke(invoke, new Object[]{packageR.getName()})).booleanValue()) {
                                this.addExports.invoke(invoke, new Object[]{packageR.getName(), this.getUnnamedModule.invoke(classLoader, new Object[0])});
                            }
                        } catch (Exception e10) {
                            throw new IllegalStateException("Failed to adjust module graph for dispatcher", e10);
                        }
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForModuleSystem forModuleSystem = (ForModuleSystem) obj;
                    return this.getModule.equals(forModuleSystem.getModule) && this.isExported.equals(forModuleSystem.isExported) && this.addExports.equals(forModuleSystem.addExports) && this.getUnnamedModule.equals(forModuleSystem.getUnnamedModule);
                }

                public int hashCode() {
                    return (((((((getClass().hashCode() * 31) + this.getModule.hashCode()) * 31) + this.isExported.hashCode()) * 31) + this.addExports.hashCode()) * 31) + this.getUnnamedModule.hashCode();
                }
            }

            public enum NoOp implements Resolver {
                INSTANCE;

                public void accept(@MaybeNull ClassLoader classLoader, Class<?> cls) {
                }
            }

            void accept(@MaybeNull ClassLoader classLoader, Class<?> cls);
        }

        static {
            String str;
            try {
                str = (String) JavaDispatcher.doPrivileged(new GetSystemPropertyAction(TypeWriter.DUMP_PROPERTY));
            } catch (Throwable unused) {
                str = null;
            }
            DUMP_FOLDER = str;
        }

        protected DynamicClassLoader(Class<?> cls) {
            super(cls.getClassLoader());
            JavaDispatcher.RESOLVER.accept(this, cls);
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0165 */
        @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Expected internal invocation.", value = {"REC_CATCH_EXCEPTION", "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected static net.bytebuddy.utility.Invoker invoker() {
            /*
                java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                java.lang.Class<net.bytebuddy.utility.Invoker> r1 = net.bytebuddy.utility.Invoker.class
                net.bytebuddy.jar.asm.ClassWriter r9 = new net.bytebuddy.jar.asm.ClassWriter
                r10 = 0
                r9.<init>(r10)
                net.bytebuddy.ClassFileVersion r2 = net.bytebuddy.ClassFileVersion.JAVA_V5
                net.bytebuddy.ClassFileVersion r2 = net.bytebuddy.ClassFileVersion.ofThisVm(r2)
                int r3 = r2.getMinorMajorVersion()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = net.bytebuddy.jar.asm.Type.getInternalName(r1)
                r2.append(r4)
                java.lang.String r11 = "$Dispatcher"
                r2.append(r11)
                java.lang.String r5 = r2.toString()
                java.lang.String r7 = net.bytebuddy.jar.asm.Type.getInternalName(r0)
                r12 = 1
                java.lang.String[] r8 = new java.lang.String[r12]
                java.lang.String r2 = net.bytebuddy.jar.asm.Type.getInternalName(r1)
                r8[r10] = r2
                r4 = 1
                r6 = 0
                r2 = r9
                r2.visit(r3, r4, r5, r6, r7, r8)
                net.bytebuddy.utility.GraalImageCode r2 = net.bytebuddy.utility.GraalImageCode.getCurrent()
                java.lang.reflect.Method[] r3 = r1.getMethods()
                net.bytebuddy.utility.MethodComparator r4 = net.bytebuddy.utility.MethodComparator.INSTANCE
                java.lang.Object[] r2 = r2.sorted(r3, r4)
                r8 = r2
                java.lang.reflect.Method[] r8 = (java.lang.reflect.Method[]) r8
                int r13 = r8.length
                r14 = r10
            L_0x004f:
                if (r14 >= r13) goto L_0x00f1
                r15 = r8[r14]
                java.lang.Class[] r2 = r15.getExceptionTypes()
                int r3 = r2.length
                java.lang.String[] r7 = new java.lang.String[r3]
                r3 = r10
            L_0x005b:
                int r4 = r2.length
                if (r3 >= r4) goto L_0x0069
                r4 = r2[r3]
                java.lang.String r4 = net.bytebuddy.jar.asm.Type.getInternalName(r4)
                r7[r3] = r4
                int r3 = r3 + 1
                goto L_0x005b
            L_0x0069:
                r3 = 1
                java.lang.String r4 = r15.getName()
                java.lang.String r5 = net.bytebuddy.jar.asm.Type.getMethodDescriptor(r15)
                r6 = 0
                r2 = r9
                net.bytebuddy.jar.asm.MethodVisitor r2 = r2.visitMethod(r3, r4, r5, r6, r7)
                r2.visitCode()
                java.lang.Class[] r3 = r15.getParameterTypes()
                int r3 = r3.length
                int r3 = r3 - r12
                net.bytebuddy.jar.asm.Type[] r3 = new net.bytebuddy.jar.asm.Type[r3]
                r4 = r10
                r5 = r12
            L_0x0085:
                java.lang.Class[] r6 = r15.getParameterTypes()
                int r6 = r6.length
                if (r4 >= r6) goto L_0x00ad
                java.lang.Class[] r6 = r15.getParameterTypes()
                r6 = r6[r4]
                net.bytebuddy.jar.asm.Type r6 = net.bytebuddy.jar.asm.Type.getType((java.lang.Class<?>) r6)
                if (r4 <= 0) goto L_0x009c
                int r7 = r4 + -1
                r3[r7] = r6
            L_0x009c:
                r7 = 21
                int r7 = r6.getOpcode(r7)
                r2.visitVarInsn(r7, r5)
                int r6 = r6.getSize()
                int r5 = r5 + r6
                int r4 = r4 + 1
                goto L_0x0085
            L_0x00ad:
                r17 = 182(0xb6, float:2.55E-43)
                java.lang.Class[] r4 = r15.getParameterTypes()
                r4 = r4[r10]
                java.lang.String r18 = net.bytebuddy.jar.asm.Type.getInternalName(r4)
                java.lang.String r19 = r15.getName()
                net.bytebuddy.jar.asm.Type r4 = net.bytebuddy.jar.asm.Type.getReturnType((java.lang.reflect.Method) r15)
                java.lang.String r20 = net.bytebuddy.jar.asm.Type.getMethodDescriptor(r4, r3)
                r21 = 0
                r16 = r2
                r16.visitMethodInsn(r17, r18, r19, r20, r21)
                net.bytebuddy.jar.asm.Type r3 = net.bytebuddy.jar.asm.Type.getReturnType((java.lang.reflect.Method) r15)
                r4 = 172(0xac, float:2.41E-43)
                int r3 = r3.getOpcode(r4)
                r2.visitInsn(r3)
                int r3 = r5 + -1
                net.bytebuddy.jar.asm.Type r4 = net.bytebuddy.jar.asm.Type.getReturnType((java.lang.reflect.Method) r15)
                int r4 = r4.getSize()
                int r3 = java.lang.Math.max(r3, r4)
                r2.visitMaxs(r3, r5)
                r2.visitEnd()
                int r14 = r14 + 1
                goto L_0x004f
            L_0x00f1:
                r3 = 1
                net.bytebuddy.jar.asm.Type r8 = net.bytebuddy.jar.asm.Type.VOID_TYPE
                net.bytebuddy.jar.asm.Type[] r2 = new net.bytebuddy.jar.asm.Type[r10]
                java.lang.String r5 = net.bytebuddy.jar.asm.Type.getMethodDescriptor(r8, r2)
                r6 = 0
                r7 = 0
                java.lang.String r4 = "<init>"
                r2 = r9
                net.bytebuddy.jar.asm.MethodVisitor r2 = r2.visitMethod(r3, r4, r5, r6, r7)
                r2.visitCode()
                r3 = 25
                r2.visitVarInsn(r3, r10)
                r14 = 183(0xb7, float:2.56E-43)
                java.lang.String r15 = net.bytebuddy.jar.asm.Type.getInternalName(r0)
                net.bytebuddy.jar.asm.Type[] r0 = new net.bytebuddy.jar.asm.Type[r10]
                java.lang.String r17 = net.bytebuddy.jar.asm.Type.getMethodDescriptor(r8, r0)
                r18 = 0
                java.lang.String r16 = "<init>"
                r13 = r2
                r13.visitMethodInsn(r14, r15, r16, r17, r18)
                r0 = 177(0xb1, float:2.48E-43)
                r2.visitInsn(r0)
                r2.visitMaxs(r12, r12)
                r2.visitEnd()
                r9.visitEnd()
                byte[] r5 = r9.toByteArray()
                java.lang.String r0 = "net.bytebuddy.dump"
                java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ all -> 0x0165 }
                if (r0 == 0) goto L_0x0165
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0165 }
                java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0165 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
                r4.<init>()     // Catch:{ all -> 0x0165 }
                java.lang.String r6 = r1.getName()     // Catch:{ all -> 0x0165 }
                r4.append(r6)     // Catch:{ all -> 0x0165 }
                java.lang.String r6 = "$Dispatcher.class"
                r4.append(r6)     // Catch:{ all -> 0x0165 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0165 }
                r3.<init>(r0, r4)     // Catch:{ all -> 0x0165 }
                r2.<init>(r3)     // Catch:{ all -> 0x0165 }
                r2.write(r5)     // Catch:{ all -> 0x015f }
                r2.close()     // Catch:{ all -> 0x0165 }
                goto L_0x0165
            L_0x015f:
                r0 = move-exception
                r3 = r0
                r2.close()     // Catch:{ all -> 0x0165 }
                throw r3     // Catch:{ all -> 0x0165 }
            L_0x0165:
                net.bytebuddy.utility.dispatcher.JavaDispatcher$DynamicClassLoader r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$DynamicClassLoader     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                r3.<init>(r1)     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                r0.<init>()     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                java.lang.String r2 = r1.getName()     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                r0.append(r2)     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                r0.append(r11)     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                java.lang.String r4 = r0.toString()     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                r6 = 0
                int r7 = r5.length     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher> r0 = net.bytebuddy.utility.dispatcher.JavaDispatcher.class
                java.security.ProtectionDomain r8 = r0.getProtectionDomain()     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                java.lang.Class r0 = r3.defineClass(r4, r5, r6, r7, r8)     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                java.lang.Class<?>[] r2 = NO_PARAMETER     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                java.lang.reflect.Constructor r0 = r0.getConstructor(r2)     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                java.lang.Object[] r2 = NO_ARGUMENT     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                java.lang.Object r0 = r0.newInstance(r2)     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                net.bytebuddy.utility.Invoker r0 = (net.bytebuddy.utility.Invoker) r0     // Catch:{ UnsupportedOperationException -> 0x01b4, Exception -> 0x0198 }
                return r0
            L_0x0198:
                r0 = move-exception
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Failed to create invoker for "
                r3.append(r4)
                java.lang.String r1 = r1.getName()
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                r2.<init>(r1, r0)
                throw r2
            L_0x01b4:
                net.bytebuddy.utility.dispatcher.JavaDispatcher$DirectInvoker r0 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$DirectInvoker
                r1 = 0
                r0.<init>()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.dispatcher.JavaDispatcher.DynamicClassLoader.invoker():net.bytebuddy.utility.Invoker");
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x013e */
        @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Expected internal invocation.", value = {"REC_CATCH_EXCEPTION", "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected static java.lang.Object proxy(java.lang.Class<?> r18, java.util.Map<java.lang.reflect.Method, net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher> r19) {
            /*
                java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                net.bytebuddy.jar.asm.ClassWriter r8 = new net.bytebuddy.jar.asm.ClassWriter
                r9 = 0
                r8.<init>(r9)
                net.bytebuddy.ClassFileVersion r1 = net.bytebuddy.ClassFileVersion.JAVA_V5
                net.bytebuddy.ClassFileVersion r1 = net.bytebuddy.ClassFileVersion.ofThisVm(r1)
                int r2 = r1.getMinorMajorVersion()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = net.bytebuddy.jar.asm.Type.getInternalName(r18)
                r1.append(r3)
                java.lang.String r10 = "$Proxy"
                r1.append(r10)
                java.lang.String r4 = r1.toString()
                java.lang.String r6 = net.bytebuddy.jar.asm.Type.getInternalName(r0)
                r11 = 1
                java.lang.String[] r7 = new java.lang.String[r11]
                java.lang.String r1 = net.bytebuddy.jar.asm.Type.getInternalName(r18)
                r7[r9] = r1
                r3 = 1
                r5 = 0
                r1 = r8
                r1.visit(r2, r3, r4, r5, r6, r7)
                java.util.Set r1 = r19.entrySet()
                java.util.Iterator r7 = r1.iterator()
            L_0x0042:
                boolean r1 = r7.hasNext()
                if (r1 == 0) goto L_0x00ce
                java.lang.Object r1 = r7.next()
                r12 = r1
                java.util.Map$Entry r12 = (java.util.Map.Entry) r12
                java.lang.Object r1 = r12.getKey()
                java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1
                java.lang.Class[] r1 = r1.getExceptionTypes()
                int r2 = r1.length
                java.lang.String[] r6 = new java.lang.String[r2]
                r2 = r9
            L_0x005d:
                int r3 = r1.length
                if (r2 >= r3) goto L_0x006b
                r3 = r1[r2]
                java.lang.String r3 = net.bytebuddy.jar.asm.Type.getInternalName(r3)
                r6[r2] = r3
                int r2 = r2 + 1
                goto L_0x005d
            L_0x006b:
                r2 = 1
                java.lang.Object r1 = r12.getKey()
                java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1
                java.lang.String r3 = r1.getName()
                java.lang.Object r1 = r12.getKey()
                java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1
                java.lang.String r4 = net.bytebuddy.jar.asm.Type.getMethodDescriptor(r1)
                r5 = 0
                r1 = r8
                net.bytebuddy.jar.asm.MethodVisitor r1 = r1.visitMethod(r2, r3, r4, r5, r6)
                r1.visitCode()
                java.lang.Object r2 = r12.getKey()
                java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2
                int r2 = r2.getModifiers()
                r2 = r2 & 8
                if (r2 != 0) goto L_0x0099
                r2 = r11
                goto L_0x009a
            L_0x0099:
                r2 = r9
            L_0x009a:
                java.lang.Object r3 = r12.getKey()
                java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
                java.lang.Class[] r3 = r3.getParameterTypes()
                int r4 = r3.length
                r5 = r9
            L_0x00a6:
                if (r5 >= r4) goto L_0x00b6
                r6 = r3[r5]
                net.bytebuddy.jar.asm.Type r6 = net.bytebuddy.jar.asm.Type.getType((java.lang.Class<?>) r6)
                int r6 = r6.getSize()
                int r2 = r2 + r6
                int r5 = r5 + 1
                goto L_0x00a6
            L_0x00b6:
                java.lang.Object r3 = r12.getValue()
                net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher r3 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher) r3
                java.lang.Object r4 = r12.getKey()
                java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4
                int r3 = r3.apply(r1, r4)
                r1.visitMaxs(r3, r2)
                r1.visitEnd()
                goto L_0x0042
            L_0x00ce:
                r2 = 1
                net.bytebuddy.jar.asm.Type r7 = net.bytebuddy.jar.asm.Type.VOID_TYPE
                net.bytebuddy.jar.asm.Type[] r1 = new net.bytebuddy.jar.asm.Type[r9]
                java.lang.String r4 = net.bytebuddy.jar.asm.Type.getMethodDescriptor(r7, r1)
                r5 = 0
                r6 = 0
                java.lang.String r3 = "<init>"
                r1 = r8
                net.bytebuddy.jar.asm.MethodVisitor r1 = r1.visitMethod(r2, r3, r4, r5, r6)
                r1.visitCode()
                r2 = 25
                r1.visitVarInsn(r2, r9)
                r13 = 183(0xb7, float:2.56E-43)
                java.lang.String r14 = net.bytebuddy.jar.asm.Type.getInternalName(r0)
                net.bytebuddy.jar.asm.Type[] r0 = new net.bytebuddy.jar.asm.Type[r9]
                java.lang.String r16 = net.bytebuddy.jar.asm.Type.getMethodDescriptor(r7, r0)
                r17 = 0
                java.lang.String r15 = "<init>"
                r12 = r1
                r12.visitMethodInsn(r13, r14, r15, r16, r17)
                r0 = 177(0xb1, float:2.48E-43)
                r1.visitInsn(r0)
                r1.visitMaxs(r11, r11)
                r1.visitEnd()
                r8.visitEnd()
                byte[] r4 = r8.toByteArray()
                java.lang.String r0 = DUMP_FOLDER
                if (r0 == 0) goto L_0x013e
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x013e }
                java.io.File r2 = new java.io.File     // Catch:{ all -> 0x013e }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x013e }
                r3.<init>()     // Catch:{ all -> 0x013e }
                java.lang.String r5 = r18.getName()     // Catch:{ all -> 0x013e }
                r3.append(r5)     // Catch:{ all -> 0x013e }
                java.lang.String r5 = "$Proxy.class"
                r3.append(r5)     // Catch:{ all -> 0x013e }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x013e }
                r2.<init>(r0, r3)     // Catch:{ all -> 0x013e }
                r1.<init>(r2)     // Catch:{ all -> 0x013e }
                r1.write(r4)     // Catch:{ all -> 0x0138 }
                r1.close()     // Catch:{ all -> 0x013e }
                goto L_0x013e
            L_0x0138:
                r0 = move-exception
                r2 = r0
                r1.close()     // Catch:{ all -> 0x013e }
                throw r2     // Catch:{ all -> 0x013e }
            L_0x013e:
                net.bytebuddy.utility.dispatcher.JavaDispatcher$DynamicClassLoader r2 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$DynamicClassLoader     // Catch:{ Exception -> 0x0173 }
                r1 = r18
                r2.<init>(r1)     // Catch:{ Exception -> 0x0171 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0171 }
                r0.<init>()     // Catch:{ Exception -> 0x0171 }
                java.lang.String r3 = r18.getName()     // Catch:{ Exception -> 0x0171 }
                r0.append(r3)     // Catch:{ Exception -> 0x0171 }
                r0.append(r10)     // Catch:{ Exception -> 0x0171 }
                java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x0171 }
                r5 = 0
                int r6 = r4.length     // Catch:{ Exception -> 0x0171 }
                java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher> r0 = net.bytebuddy.utility.dispatcher.JavaDispatcher.class
                java.security.ProtectionDomain r7 = r0.getProtectionDomain()     // Catch:{ Exception -> 0x0171 }
                java.lang.Class r0 = r2.defineClass(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0171 }
                java.lang.Class<?>[] r2 = NO_PARAMETER     // Catch:{ Exception -> 0x0171 }
                java.lang.reflect.Constructor r0 = r0.getConstructor(r2)     // Catch:{ Exception -> 0x0171 }
                java.lang.Object[] r2 = NO_ARGUMENT     // Catch:{ Exception -> 0x0171 }
                java.lang.Object r0 = r0.newInstance(r2)     // Catch:{ Exception -> 0x0171 }
                return r0
            L_0x0171:
                r0 = move-exception
                goto L_0x0176
            L_0x0173:
                r0 = move-exception
                r1 = r18
            L_0x0176:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Failed to create proxy for "
                r3.append(r4)
                java.lang.String r1 = r18.getName()
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                r2.<init>(r1, r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.dispatcher.JavaDispatcher.DynamicClassLoader.proxy(java.lang.Class, java.util.Map):java.lang.Object");
        }
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Instance {
    }

    @HashCodeAndEqualsPlugin.Enhance
    private static class InvokerCreationAction implements PrivilegedAction<Invoker> {
        private InvokerCreationAction() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return getClass().hashCode();
        }

        public Invoker run() {
            return DynamicClassLoader.invoker();
        }
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IsConstructor {
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IsStatic {
    }

    @Documented
    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Proxied {
        String value();
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class ProxiedInvocationHandler implements InvocationHandler {
        private static final Object[] NO_ARGUMENTS = new Object[0];
        private final String name;
        private final Map<Method, Dispatcher> targets;

        protected ProxiedInvocationHandler(String str, Map<Method, Dispatcher> map) {
            this.name = str;
            this.targets = map;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ProxiedInvocationHandler proxiedInvocationHandler = (ProxiedInvocationHandler) obj;
            return this.name.equals(proxiedInvocationHandler.name) && this.targets.equals(proxiedInvocationHandler.targets);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.targets.hashCode();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: boolean} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v1, types: [int] */
        /* JADX WARNING: type inference failed for: r1v5 */
        /* JADX WARNING: type inference failed for: r1v6 */
        /* JADX WARNING: Multi-variable type inference failed */
        @net.bytebuddy.utility.nullability.MaybeNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object invoke(java.lang.Object r4, java.lang.reflect.Method r5, @net.bytebuddy.utility.nullability.MaybeNull java.lang.Object[] r6) throws java.lang.Throwable {
            /*
                r3 = this;
                java.lang.Class r4 = r5.getDeclaringClass()
                java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                r1 = 0
                if (r4 != r0) goto L_0x0081
                java.lang.String r4 = r5.getName()
                java.lang.String r0 = "hashCode"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x001e
                int r4 = r3.hashCode()
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                return r4
            L_0x001e:
                java.lang.String r4 = r5.getName()
                java.lang.String r0 = "equals"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x004a
                r4 = r6[r1]
                if (r4 == 0) goto L_0x0045
                java.lang.Class r4 = r4.getClass()
                boolean r4 = java.lang.reflect.Proxy.isProxyClass(r4)
                if (r4 == 0) goto L_0x0045
                r4 = r6[r1]
                java.lang.reflect.InvocationHandler r4 = java.lang.reflect.Proxy.getInvocationHandler(r4)
                boolean r4 = r4.equals(r3)
                if (r4 == 0) goto L_0x0045
                r1 = 1
            L_0x0045:
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
                return r4
            L_0x004a:
                java.lang.String r4 = r5.getName()
                java.lang.String r6 = "toString"
                boolean r4 = r4.equals(r6)
                if (r4 == 0) goto L_0x006a
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Call proxy for "
                r4.append(r5)
                java.lang.String r5 = r3.name
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                return r4
            L_0x006a:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = "Unexpected object method: "
                r6.append(r0)
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                r4.<init>(r5)
                throw r4
            L_0x0081:
                java.util.Map<java.lang.reflect.Method, net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher> r4 = r3.targets
                java.lang.Object r4 = r4.get(r5)
                net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher r4 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher) r4
                if (r4 == 0) goto L_0x0094
                if (r6 != 0) goto L_0x008f
                java.lang.Object[] r6 = NO_ARGUMENTS     // Catch:{ InvocationTargetException -> 0x00b1 }
            L_0x008f:
                java.lang.Object r4 = r4.invoke(r6)     // Catch:{ InvocationTargetException -> 0x00b1 }
                return r4
            L_0x0094:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ InvocationTargetException -> 0x00b1 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ InvocationTargetException -> 0x00b1 }
                r6.<init>()     // Catch:{ InvocationTargetException -> 0x00b1 }
                java.lang.String r0 = "No proxy target found for "
                r6.append(r0)     // Catch:{ InvocationTargetException -> 0x00b1 }
                r6.append(r5)     // Catch:{ InvocationTargetException -> 0x00b1 }
                java.lang.String r6 = r6.toString()     // Catch:{ InvocationTargetException -> 0x00b1 }
                r4.<init>(r6)     // Catch:{ InvocationTargetException -> 0x00b1 }
                throw r4     // Catch:{ InvocationTargetException -> 0x00b1 }
            L_0x00ab:
                r4 = move-exception
                goto L_0x00b7
            L_0x00ad:
                r4 = move-exception
                goto L_0x00e1
            L_0x00af:
                r4 = move-exception
                goto L_0x00e2
            L_0x00b1:
                r4 = move-exception
                java.lang.Throwable r4 = r4.getTargetException()     // Catch:{ RuntimeException -> 0x00af, Error -> 0x00ad, all -> 0x00ab }
                throw r4     // Catch:{ RuntimeException -> 0x00af, Error -> 0x00ad, all -> 0x00ab }
            L_0x00b7:
                java.lang.Class[] r6 = r5.getExceptionTypes()
                int r0 = r6.length
            L_0x00bc:
                if (r1 >= r0) goto L_0x00ca
                r2 = r6[r1]
                boolean r2 = r2.isInstance(r4)
                if (r2 != 0) goto L_0x00c9
                int r1 = r1 + 1
                goto L_0x00bc
            L_0x00c9:
                throw r4
            L_0x00ca:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Failed to invoke proxy for "
                r0.append(r1)
                r0.append(r5)
                java.lang.String r5 = r0.toString()
                r6.<init>(r5, r4)
                throw r6
            L_0x00e1:
                throw r4
            L_0x00e2:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.dispatcher.JavaDispatcher.ProxiedInvocationHandler.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
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

    protected JavaDispatcher(Class<T> cls, @MaybeNull ClassLoader classLoader2, boolean z10) {
        this.proxy = cls;
        this.classLoader = classLoader2;
        this.generate = z10;
    }

    /* access modifiers changed from: private */
    @AccessControllerPlugin.Enhance
    public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static <T> PrivilegedAction<T> of(Class<T> cls) {
        return of(cls, (ClassLoader) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0039 A[RETURN] */
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
            boolean r2 = r4.generate
            net.bytebuddy.utility.dispatcher.JavaDispatcher r5 = (net.bytebuddy.utility.dispatcher.JavaDispatcher) r5
            boolean r3 = r5.generate
            if (r2 == r3) goto L_0x001c
            return r1
        L_0x001c:
            java.lang.Class<T> r2 = r4.proxy
            java.lang.Class<T> r3 = r5.proxy
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0027
            return r1
        L_0x0027:
            java.lang.ClassLoader r2 = r4.classLoader
            java.lang.ClassLoader r5 = r5.classLoader
            if (r5 == 0) goto L_0x0036
            if (r2 == 0) goto L_0x0038
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0039
            return r1
        L_0x0036:
            if (r2 == 0) goto L_0x0039
        L_0x0038:
            return r1
        L_0x0039:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.dispatcher.JavaDispatcher.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = ((getClass().hashCode() * 31) + this.proxy.hashCode()) * 31;
        ClassLoader classLoader2 = this.classLoader;
        if (classLoader2 != null) {
            hashCode += classLoader2.hashCode();
        }
        return (hashCode * 31) + (this.generate ? 1 : 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0260, code lost:
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0267, code lost:
        if (r6[r12].isArray() == false) goto L_0x0274;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0269, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        r6[r12] = r6[r12].getComponentType();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0274, code lost:
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x027a, code lost:
        if (r11 <= 0) goto L_0x0344;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0282, code lost:
        if (r6[r12].isPrimitive() != false) goto L_0x0312;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0284, code lost:
        r20 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x028c, code lost:
        r23 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0292, code lost:
        r24 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0296, code lost:
        r25 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02a1, code lost:
        if (r6[r12].isAssignableFrom(java.lang.Class.forName(((net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r5).value(), false, r1.classLoader)) == false) goto L_0x02d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02a3, code lost:
        r2 = new java.lang.StringBuilder();
        r11 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02aa, code lost:
        r3 = r11 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02ac, code lost:
        if (r11 <= 0) goto L_0x02b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02ae, code lost:
        r2.append('[');
        r11 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02b5, code lost:
        r2.append(org.bouncycastle.pqc.math.linearalgebra.Matrix.MATRIX_TYPE_RANDOM_LT);
        r2.append(((net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r5).value());
        r2.append(net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        r6[r12] = java.lang.Class.forName(r2.toString(), false, r1.classLoader);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02ff, code lost:
        throw new java.lang.IllegalStateException("Cannot resolve to component type: " + ((net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r5).value() + " at " + r12 + " of " + r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0300, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0303, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0306, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0309, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x030c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x030f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0312, code lost:
        r23 = r2;
        r24 = r4;
        r25 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0334, code lost:
        throw new java.lang.IllegalStateException("Primitive values are not supposed to be proxied: " + r12 + " of " + r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0335, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0336, code lost:
        r23 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x033a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x033b, code lost:
        r23 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x033f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0340, code lost:
        r23 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0344, code lost:
        r23 = r2;
        r24 = r4;
        r25 = r10;
        r2 = java.lang.Class.forName(((net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r5).value(), false, r1.classLoader);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x035d, code lost:
        if (r6[r12].isAssignableFrom(r2) == false) goto L_0x0362;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x035f, code lost:
        r6[r12] = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0388, code lost:
        throw new java.lang.IllegalStateException("Cannot resolve to type: " + r2.getName() + " at " + r12 + " of " + r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x054a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x054b, code lost:
        r2 = r0;
        r10 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x054f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0550, code lost:
        r2 = r0;
        r10 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0555, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0556, code lost:
        r2 = r0;
        r10 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x05c0, code lost:
        r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForUnresolvedMethod("Method not available on current VM: " + r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x05db, code lost:
        r3 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForDefaultValue.of(r14.getReturnType());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0600, code lost:
        r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForUnresolvedMethod("Class not available on current VM: " + r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x061b, code lost:
        r3 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForDefaultValue.of(r14.getReturnType());
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x024a A[Catch:{ ClassNotFoundException -> 0x056f, NoSuchMethodException -> 0x0565, all -> 0x055b }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03c5 A[SYNTHETIC, Splitter:B:167:0x03c5] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0420 A[Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x04c9 A[Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x04f8 A[Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x05c0  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x05db  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x0600  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x061b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T run() {
        /*
            r26 = this;
            r1 = r26
            java.lang.String r2 = "Instance check requires a boolean return type: "
            java.lang.String r3 = "Instance check requires a single regular-typed argument: "
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            r5 = 1
            r6 = 0
            java.lang.Class<java.lang.System> r7 = java.lang.System.class
            java.lang.String r8 = "getSecurityManager"
            java.lang.Class[] r9 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            java.lang.reflect.Method r7 = r7.getMethod(r8, r9)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            r8 = 0
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            java.lang.Object r7 = r7.invoke(r8, r9)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            if (r7 == 0) goto L_0x005d
            java.lang.String r8 = "java.lang.SecurityManager"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            java.lang.String r9 = "checkPermission"
            java.lang.Class[] r10 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            java.lang.Class<java.security.Permission> r11 = java.security.Permission.class
            r10[r6] = r11     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            java.lang.reflect.Method r8 = r8.getMethod(r9, r10)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            java.lang.RuntimePermission r10 = new java.lang.RuntimePermission     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            java.lang.String r11 = "net.bytebuddy.createJavaDispatcher"
            r10.<init>(r11)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            r9[r6] = r10     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            r8.invoke(r7, r9)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005d, InvocationTargetException -> 0x0048, IllegalAccessException -> 0x003e }
            goto L_0x005d
        L_0x003e:
            r0 = move-exception
            r2 = r0
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Failed to access security manager"
            r3.<init>(r4, r2)
            throw r3
        L_0x0048:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r2 = r2.getTargetException()
            boolean r3 = r2 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x0055
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2
            throw r2
        L_0x0055:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Failed to assert access rights using security manager"
            r3.<init>(r4, r2)
            throw r3
        L_0x005d:
            boolean r7 = r1.generate
            if (r7 == 0) goto L_0x0067
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            goto L_0x006c
        L_0x0067:
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
        L_0x006c:
            java.lang.Class<T> r8 = r1.proxy
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Defaults> r9 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults.class
            boolean r8 = r8.isAnnotationPresent(r9)
            java.lang.Class<T> r9 = r1.proxy
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied> r10 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied.class
            java.lang.annotation.Annotation r9 = r9.getAnnotation(r10)
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied r9 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r9
            java.lang.String r9 = r9.value()
            java.lang.ClassLoader r10 = r1.classLoader     // Catch:{ ClassNotFoundException -> 0x065d }
            java.lang.Class r9 = java.lang.Class.forName(r9, r6, r10)     // Catch:{ ClassNotFoundException -> 0x065d }
            boolean r10 = r1.generate
            if (r10 == 0) goto L_0x009f
            net.bytebuddy.utility.GraalImageCode r11 = net.bytebuddy.utility.GraalImageCode.getCurrent()
            java.lang.Class<T> r12 = r1.proxy
            java.lang.reflect.Method[] r12 = r12.getMethods()
            net.bytebuddy.utility.MethodComparator r13 = net.bytebuddy.utility.MethodComparator.INSTANCE
            java.lang.Object[] r11 = r11.sorted(r12, r13)
            java.lang.reflect.Method[] r11 = (java.lang.reflect.Method[]) r11
            goto L_0x00a5
        L_0x009f:
            java.lang.Class<T> r11 = r1.proxy
            java.lang.reflect.Method[] r11 = r11.getMethods()
        L_0x00a5:
            int r12 = r11.length
            r13 = r6
        L_0x00a7:
            if (r13 >= r12) goto L_0x0636
            r14 = r11[r13]
            java.lang.Class r15 = r14.getDeclaringClass()
            if (r15 != r4) goto L_0x00b3
            goto L_0x0143
        L_0x00b3:
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Instance> r15 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Instance.class
            boolean r15 = r14.isAnnotationPresent(r15)
            if (r15 == 0) goto L_0x0109
            java.lang.Class[] r15 = r14.getParameterTypes()
            int r15 = r15.length
            if (r15 != r5) goto L_0x00f4
            java.lang.Class[] r15 = r14.getParameterTypes()
            r15 = r15[r6]
            boolean r15 = r15.isAssignableFrom(r9)
            if (r15 == 0) goto L_0x00f4
            java.lang.Class r15 = r14.getReturnType()
            java.lang.Class r6 = java.lang.Boolean.TYPE
            if (r15 != r6) goto L_0x00df
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForInstanceCheck r6 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForInstanceCheck
            r6.<init>(r9)
            r7.put(r14, r6)
            goto L_0x0143
        L_0x00df:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r14)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            throw r3
        L_0x00f4:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r14)
            java.lang.String r3 = r4.toString()
            r2.<init>(r3)
            throw r2
        L_0x0109:
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Container> r6 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Container.class
            boolean r6 = r14.isAnnotationPresent(r6)
            if (r6 == 0) goto L_0x017d
            java.lang.Class[] r6 = r14.getParameterTypes()
            int r6 = r6.length
            if (r6 != r5) goto L_0x0166
            java.lang.Class[] r6 = r14.getParameterTypes()
            r15 = 0
            r6 = r6[r15]
            java.lang.Class r15 = java.lang.Integer.TYPE
            if (r6 != r15) goto L_0x0166
            java.lang.Class r6 = r14.getReturnType()
            boolean r6 = r6.isArray()
            if (r6 == 0) goto L_0x014f
            java.lang.Class r6 = r14.getReturnType()
            java.lang.Class r6 = r6.getComponentType()
            boolean r6 = r6.isAssignableFrom(r9)
            if (r6 == 0) goto L_0x014f
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForContainerCreation r6 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForContainerCreation
            r6.<init>(r9)
            r7.put(r14, r6)
        L_0x0143:
            r23 = r2
            r22 = r3
            r24 = r4
            r16 = r11
            r17 = r12
            goto L_0x0626
        L_0x014f:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Container creation requires an assignable array as return value: "
            r3.append(r4)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x0166:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Container creation requires a single int-typed argument: "
            r3.append(r4)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x017d:
            java.lang.String r6 = r9.getName()
            java.lang.String r15 = "java.lang.invoke.MethodHandles"
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x019e
            java.lang.String r6 = r14.getName()
            java.lang.String r15 = "lookup"
            boolean r6 = r6.equals(r15)
            if (r6 != 0) goto L_0x0196
            goto L_0x019e
        L_0x0196:
            java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
            java.lang.String r3 = "Cannot resolve Byte Buddy lookup via dispatcher"
            r2.<init>(r3)
            throw r2
        L_0x019e:
            java.lang.Class[] r6 = r14.getParameterTypes()     // Catch:{ ClassNotFoundException -> 0x05e7, NoSuchMethodException -> 0x05a7, all -> 0x057a }
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$IsStatic> r15 = net.bytebuddy.utility.dispatcher.JavaDispatcher.IsStatic.class
            boolean r15 = r14.isAnnotationPresent(r15)     // Catch:{ ClassNotFoundException -> 0x05e7, NoSuchMethodException -> 0x05a7, all -> 0x057a }
            if (r15 != 0) goto L_0x023d
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$IsConstructor> r15 = net.bytebuddy.utility.dispatcher.JavaDispatcher.IsConstructor.class
            boolean r15 = r14.isAnnotationPresent(r15)     // Catch:{ ClassNotFoundException -> 0x0230, NoSuchMethodException -> 0x0223, all -> 0x0216 }
            if (r15 == 0) goto L_0x01b4
            goto L_0x023d
        L_0x01b4:
            int r15 = r6.length     // Catch:{ ClassNotFoundException -> 0x0230, NoSuchMethodException -> 0x0223, all -> 0x0216 }
            if (r15 == 0) goto L_0x01f5
            r15 = 0
            r5 = r6[r15]     // Catch:{ ClassNotFoundException -> 0x0230, NoSuchMethodException -> 0x0223, all -> 0x0216 }
            boolean r5 = r5.isAssignableFrom(r9)     // Catch:{ ClassNotFoundException -> 0x0230, NoSuchMethodException -> 0x0223, all -> 0x0216 }
            if (r5 == 0) goto L_0x01d2
            int r5 = r6.length     // Catch:{ ClassNotFoundException -> 0x0230, NoSuchMethodException -> 0x0223, all -> 0x0216 }
            r15 = 1
            int r5 = r5 - r15
            java.lang.Class[] r15 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x0230, NoSuchMethodException -> 0x0223, all -> 0x0216 }
            r16 = r11
            r17 = r12
            r11 = 1
            r12 = 0
            java.lang.System.arraycopy(r6, r11, r15, r12, r5)     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            r6 = r15
            r5 = 1
            goto L_0x0242
        L_0x01d2:
            r16 = r11
            r17 = r12
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            r6.<init>()     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            java.lang.String r11 = "Cannot assign self type: "
            r6.append(r11)     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            r6.append(r9)     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            java.lang.String r11 = " on "
            r6.append(r11)     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            r6.append(r14)     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            java.lang.String r6 = r6.toString()     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            r5.<init>(r6)     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            throw r5     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
        L_0x01f5:
            r16 = r11
            r17 = r12
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            r6.<init>()     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            java.lang.String r11 = "Expected self type: "
            r6.append(r11)     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            r6.append(r14)     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            java.lang.String r6 = r6.toString()     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            r5.<init>(r6)     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            throw r5     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
        L_0x0210:
            r0 = move-exception
            goto L_0x021b
        L_0x0212:
            r0 = move-exception
            goto L_0x0228
        L_0x0214:
            r0 = move-exception
            goto L_0x0235
        L_0x0216:
            r0 = move-exception
            r16 = r11
            r17 = r12
        L_0x021b:
            r23 = r2
            r22 = r3
            r24 = r4
            goto L_0x0587
        L_0x0223:
            r0 = move-exception
            r16 = r11
            r17 = r12
        L_0x0228:
            r23 = r2
            r22 = r3
            r24 = r4
            goto L_0x05b4
        L_0x0230:
            r0 = move-exception
            r16 = r11
            r17 = r12
        L_0x0235:
            r23 = r2
            r22 = r3
            r24 = r4
            goto L_0x05f4
        L_0x023d:
            r16 = r11
            r17 = r12
            r5 = 0
        L_0x0242:
            java.lang.annotation.Annotation[][] r11 = r14.getParameterAnnotations()     // Catch:{ ClassNotFoundException -> 0x056f, NoSuchMethodException -> 0x0565, all -> 0x055b }
            r12 = 0
        L_0x0247:
            int r15 = r6.length     // Catch:{ ClassNotFoundException -> 0x056f, NoSuchMethodException -> 0x0565, all -> 0x055b }
            if (r12 >= r15) goto L_0x03b1
            int r15 = r12 + r5
            r15 = r11[r15]     // Catch:{ ClassNotFoundException -> 0x056f, NoSuchMethodException -> 0x0565, all -> 0x055b }
            r18 = r5
            int r5 = r15.length     // Catch:{ ClassNotFoundException -> 0x056f, NoSuchMethodException -> 0x0565, all -> 0x055b }
            r19 = r11
            r11 = 0
        L_0x0254:
            if (r11 >= r5) goto L_0x0399
            r20 = r5
            r5 = r15[r11]     // Catch:{ ClassNotFoundException -> 0x056f, NoSuchMethodException -> 0x0565, all -> 0x055b }
            r21 = r15
            boolean r15 = r5 instanceof net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied     // Catch:{ ClassNotFoundException -> 0x056f, NoSuchMethodException -> 0x0565, all -> 0x055b }
            if (r15 == 0) goto L_0x0389
            r11 = 0
        L_0x0261:
            r15 = r6[r12]     // Catch:{ ClassNotFoundException -> 0x056f, NoSuchMethodException -> 0x0565, all -> 0x055b }
            boolean r15 = r15.isArray()     // Catch:{ ClassNotFoundException -> 0x056f, NoSuchMethodException -> 0x0565, all -> 0x055b }
            if (r15 == 0) goto L_0x0274
            int r11 = r11 + 1
            r15 = r6[r12]     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            java.lang.Class r15 = r15.getComponentType()     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            r6[r12] = r15     // Catch:{ ClassNotFoundException -> 0x0214, NoSuchMethodException -> 0x0212, all -> 0x0210 }
            goto L_0x0261
        L_0x0274:
            java.lang.String r15 = " at "
            r22 = r3
            java.lang.String r3 = " of "
            if (r11 <= 0) goto L_0x0344
            r20 = r6[r12]     // Catch:{ ClassNotFoundException -> 0x033f, NoSuchMethodException -> 0x033a, all -> 0x0335 }
            boolean r20 = r20.isPrimitive()     // Catch:{ ClassNotFoundException -> 0x033f, NoSuchMethodException -> 0x033a, all -> 0x0335 }
            if (r20 != 0) goto L_0x0312
            r20 = r11
            r11 = r6[r12]     // Catch:{ ClassNotFoundException -> 0x033f, NoSuchMethodException -> 0x033a, all -> 0x0335 }
            r21 = r5
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied r21 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r21     // Catch:{ ClassNotFoundException -> 0x033f, NoSuchMethodException -> 0x033a, all -> 0x0335 }
            r23 = r2
            java.lang.String r2 = r21.value()     // Catch:{ ClassNotFoundException -> 0x030f, NoSuchMethodException -> 0x030c, all -> 0x0309 }
            r24 = r4
            java.lang.ClassLoader r4 = r1.classLoader     // Catch:{ ClassNotFoundException -> 0x0306, NoSuchMethodException -> 0x0303, all -> 0x0300 }
            r25 = r10
            r10 = 0
            java.lang.Class r2 = java.lang.Class.forName(r2, r10, r4)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            boolean r2 = r11.isAssignableFrom(r2)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            if (r2 == 0) goto L_0x02d7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r2.<init>()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r11 = r20
        L_0x02aa:
            int r3 = r11 + -1
            if (r11 <= 0) goto L_0x02b5
            r4 = 91
            r2.append(r4)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r11 = r3
            goto L_0x02aa
        L_0x02b5:
            r3 = 76
            r2.append(r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied r5 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r5     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r3 = r5.value()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r2.append(r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r3 = 59
            r2.append(r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r2 = r2.toString()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.ClassLoader r3 = r1.classLoader     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4 = 0
            java.lang.Class r2 = java.lang.Class.forName(r2, r4, r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r6[r12] = r2     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            goto L_0x03a1
        L_0x02d7:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4.<init>()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r6 = "Cannot resolve to component type: "
            r4.append(r6)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied r5 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r5     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r5 = r5.value()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4.append(r5)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4.append(r15)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4.append(r12)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4.append(r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4.append(r14)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r3 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r2.<init>(r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
        L_0x0300:
            r0 = move-exception
            goto L_0x0562
        L_0x0303:
            r0 = move-exception
            goto L_0x056c
        L_0x0306:
            r0 = move-exception
            goto L_0x0576
        L_0x0309:
            r0 = move-exception
            goto L_0x0560
        L_0x030c:
            r0 = move-exception
            goto L_0x056a
        L_0x030f:
            r0 = move-exception
            goto L_0x0574
        L_0x0312:
            r23 = r2
            r24 = r4
            r25 = r10
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4.<init>()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r5 = "Primitive values are not supposed to be proxied: "
            r4.append(r5)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4.append(r12)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4.append(r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4.append(r14)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r3 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r2.<init>(r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
        L_0x0335:
            r0 = move-exception
            r23 = r2
            goto L_0x0560
        L_0x033a:
            r0 = move-exception
            r23 = r2
            goto L_0x056a
        L_0x033f:
            r0 = move-exception
            r23 = r2
            goto L_0x0574
        L_0x0344:
            r23 = r2
            r24 = r4
            r25 = r10
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied r5 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r5     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r2 = r5.value()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.ClassLoader r4 = r1.classLoader     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r5 = 0
            java.lang.Class r2 = java.lang.Class.forName(r2, r5, r4)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4 = r6[r12]     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            boolean r4 = r4.isAssignableFrom(r2)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            if (r4 == 0) goto L_0x0362
            r6[r12] = r2     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            goto L_0x03a1
        L_0x0362:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r5.<init>()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r6 = "Cannot resolve to type: "
            r5.append(r6)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r5.append(r2)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r5.append(r15)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r5.append(r12)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r5.append(r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r5.append(r14)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r2 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            throw r4     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
        L_0x0389:
            r23 = r2
            r22 = r3
            r24 = r4
            r25 = r10
            int r11 = r11 + 1
            r5 = r20
            r15 = r21
            goto L_0x0254
        L_0x0399:
            r23 = r2
            r22 = r3
            r24 = r4
            r25 = r10
        L_0x03a1:
            int r12 = r12 + 1
            r5 = r18
            r11 = r19
            r3 = r22
            r2 = r23
            r4 = r24
            r10 = r25
            goto L_0x0247
        L_0x03b1:
            r23 = r2
            r22 = r3
            r24 = r4
            r25 = r10
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$IsConstructor> r2 = net.bytebuddy.utility.dispatcher.JavaDispatcher.IsConstructor.class
            boolean r2 = r14.isAnnotationPresent(r2)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r3 = " to "
            java.lang.String r4 = "Cannot assign "
            if (r2 == 0) goto L_0x0420
            java.lang.reflect.Constructor r2 = r9.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.Class r5 = r14.getReturnType()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            boolean r5 = r5.isAssignableFrom(r9)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            if (r5 == 0) goto L_0x03fd
            int r3 = r2.getModifiers()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x03e6
            int r3 = r9.getModifiers()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r3 = r3 & r4
            if (r3 != 0) goto L_0x03e3
            goto L_0x03e6
        L_0x03e3:
            r10 = r25
            goto L_0x03ea
        L_0x03e6:
            r2.setAccessible(r4)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r10 = 0
        L_0x03ea:
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForConstructor r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForConstructor     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r7.put(r14, r3)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            goto L_0x0626
        L_0x03f4:
            r0 = move-exception
            goto L_0x0587
        L_0x03f7:
            r0 = move-exception
            goto L_0x05b4
        L_0x03fa:
            r0 = move-exception
            goto L_0x05f4
        L_0x03fd:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r6.<init>()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r6.append(r4)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.Class r2 = r2.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r6.append(r2)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r6.append(r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r6.append(r14)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r2 = r6.toString()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r5.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            throw r5     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
        L_0x0420:
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied> r2 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied.class
            java.lang.annotation.Annotation r2 = r14.getAnnotation(r2)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied r2 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r2     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            if (r2 != 0) goto L_0x042f
            java.lang.String r2 = r14.getName()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            goto L_0x0433
        L_0x042f:
            java.lang.String r2 = r2.value()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
        L_0x0433:
            java.lang.reflect.Method r2 = r9.getMethod(r2, r6)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.Class r5 = r14.getReturnType()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.Class r6 = r2.getReturnType()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            boolean r5 = r5.isAssignableFrom(r6)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            if (r5 == 0) goto L_0x0527
            java.lang.Class[] r3 = r2.getExceptionTypes()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            int r4 = r3.length     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r5 = 0
        L_0x044b:
            java.lang.String r6 = "Resolved method for "
            if (r5 >= r4) goto L_0x04a2
            r10 = r3[r5]     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.Class<java.lang.RuntimeException> r11 = java.lang.RuntimeException.class
            boolean r11 = r11.isAssignableFrom(r10)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            if (r11 != 0) goto L_0x049b
            java.lang.Class<java.lang.Error> r11 = java.lang.Error.class
            boolean r11 = r11.isAssignableFrom(r10)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            if (r11 == 0) goto L_0x0462
            goto L_0x049b
        L_0x0462:
            java.lang.Class[] r11 = r14.getExceptionTypes()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            int r12 = r11.length     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r15 = 0
        L_0x0468:
            if (r15 >= r12) goto L_0x047a
            r18 = r3
            r3 = r11[r15]     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            boolean r3 = r3.isAssignableFrom(r10)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            if (r3 == 0) goto L_0x0475
            goto L_0x049d
        L_0x0475:
            int r15 = r15 + 1
            r3 = r18
            goto L_0x0468
        L_0x047a:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r3.<init>()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r3.append(r6)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r3.append(r14)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r4 = " throws undeclared checked exception "
            r3.append(r4)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r4 = r10.getName()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r3.append(r4)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r3 = r3.toString()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r2.<init>(r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
        L_0x049b:
            r18 = r3
        L_0x049d:
            int r5 = r5 + 1
            r3 = r18
            goto L_0x044b
        L_0x04a2:
            int r3 = r2.getModifiers()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x04ba
            java.lang.Class r3 = r2.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            int r3 = r3.getModifiers()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r3 = r3 & r4
            if (r3 != 0) goto L_0x04b7
            r3 = 1
            goto L_0x04bb
        L_0x04b7:
            r10 = r25
            goto L_0x04bf
        L_0x04ba:
            r3 = r4
        L_0x04bb:
            r2.setAccessible(r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r10 = 0
        L_0x04bf:
            int r3 = r2.getModifiers()     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            boolean r3 = java.lang.reflect.Modifier.isStatic(r3)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            if (r3 == 0) goto L_0x04f8
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$IsStatic> r3 = net.bytebuddy.utility.dispatcher.JavaDispatcher.IsStatic.class
            boolean r3 = r14.isAnnotationPresent(r3)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            if (r3 == 0) goto L_0x04db
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForStaticMethod r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForStaticMethod     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r7.put(r14, r3)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            goto L_0x0626
        L_0x04db:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r4.<init>()     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r4.append(r6)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r4.append(r14)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            java.lang.String r5 = " was expected to be static: "
            r4.append(r5)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r4.append(r2)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            java.lang.String r2 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            throw r3     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
        L_0x04f8:
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$IsStatic> r3 = net.bytebuddy.utility.dispatcher.JavaDispatcher.IsStatic.class
            boolean r3 = r14.isAnnotationPresent(r3)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            if (r3 != 0) goto L_0x050a
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForNonStaticMethod r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForNonStaticMethod     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r7.put(r14, r3)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            goto L_0x0626
        L_0x050a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r4.<init>()     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r4.append(r6)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r4.append(r14)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            java.lang.String r5 = " was expected to be virtual: "
            r4.append(r5)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r4.append(r2)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            java.lang.String r2 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
            throw r3     // Catch:{ ClassNotFoundException -> 0x03fa, NoSuchMethodException -> 0x03f7, all -> 0x03f4 }
        L_0x0527:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r6.<init>()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r6.append(r4)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.Class r2 = r2.getReturnType()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r6.append(r2)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r6.append(r3)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r6.append(r14)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            java.lang.String r2 = r6.toString()     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            r5.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
            throw r5     // Catch:{ ClassNotFoundException -> 0x0555, NoSuchMethodException -> 0x054f, all -> 0x054a }
        L_0x054a:
            r0 = move-exception
            r2 = r0
            r10 = r25
            goto L_0x0588
        L_0x054f:
            r0 = move-exception
            r2 = r0
            r10 = r25
            goto L_0x05b5
        L_0x0555:
            r0 = move-exception
            r2 = r0
            r10 = r25
            goto L_0x05f5
        L_0x055b:
            r0 = move-exception
            r23 = r2
            r22 = r3
        L_0x0560:
            r24 = r4
        L_0x0562:
            r25 = r10
            goto L_0x0587
        L_0x0565:
            r0 = move-exception
            r23 = r2
            r22 = r3
        L_0x056a:
            r24 = r4
        L_0x056c:
            r25 = r10
            goto L_0x05b4
        L_0x056f:
            r0 = move-exception
            r23 = r2
            r22 = r3
        L_0x0574:
            r24 = r4
        L_0x0576:
            r25 = r10
            goto L_0x05f4
        L_0x057a:
            r0 = move-exception
            r23 = r2
            r22 = r3
            r24 = r4
            r25 = r10
            r16 = r11
            r17 = r12
        L_0x0587:
            r2 = r0
        L_0x0588:
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unexpected error: "
            r4.append(r5)
            java.lang.String r2 = r2.getMessage()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            r7.put(r14, r3)
            goto L_0x0626
        L_0x05a7:
            r0 = move-exception
            r23 = r2
            r22 = r3
            r24 = r4
            r25 = r10
            r16 = r11
            r17 = r12
        L_0x05b4:
            r2 = r0
        L_0x05b5:
            if (r8 != 0) goto L_0x05db
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Defaults> r3 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults.class
            boolean r3 = r14.isAnnotationPresent(r3)
            if (r3 == 0) goto L_0x05c0
            goto L_0x05db
        L_0x05c0:
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Method not available on current VM: "
            r4.append(r5)
            java.lang.String r2 = r2.getMessage()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            goto L_0x05e3
        L_0x05db:
            java.lang.Class r2 = r14.getReturnType()
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher r3 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForDefaultValue.of(r2)
        L_0x05e3:
            r7.put(r14, r3)
            goto L_0x0626
        L_0x05e7:
            r0 = move-exception
            r23 = r2
            r22 = r3
            r24 = r4
            r25 = r10
            r16 = r11
            r17 = r12
        L_0x05f4:
            r2 = r0
        L_0x05f5:
            if (r8 != 0) goto L_0x061b
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Defaults> r3 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults.class
            boolean r3 = r14.isAnnotationPresent(r3)
            if (r3 == 0) goto L_0x0600
            goto L_0x061b
        L_0x0600:
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Class not available on current VM: "
            r4.append(r5)
            java.lang.String r2 = r2.getMessage()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            goto L_0x0623
        L_0x061b:
            java.lang.Class r2 = r14.getReturnType()
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher r3 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForDefaultValue.of(r2)
        L_0x0623:
            r7.put(r14, r3)
        L_0x0626:
            int r13 = r13 + 1
            r11 = r16
            r12 = r17
            r3 = r22
            r2 = r23
            r4 = r24
            r5 = 1
            r6 = 0
            goto L_0x00a7
        L_0x0636:
            r25 = r10
            if (r25 == 0) goto L_0x0641
            java.lang.Class<T> r2 = r1.proxy
            java.lang.Object r2 = net.bytebuddy.utility.dispatcher.JavaDispatcher.DynamicClassLoader.proxy(r2, r7)
            return r2
        L_0x0641:
            java.lang.Class<T> r2 = r1.proxy
            java.lang.ClassLoader r2 = r2.getClassLoader()
            r3 = 1
            java.lang.Class[] r3 = new java.lang.Class[r3]
            java.lang.Class<T> r4 = r1.proxy
            r5 = 0
            r3[r5] = r4
            net.bytebuddy.utility.dispatcher.JavaDispatcher$ProxiedInvocationHandler r4 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$ProxiedInvocationHandler
            java.lang.String r5 = r9.getName()
            r4.<init>(r5, r7)
            java.lang.Object r2 = java.lang.reflect.Proxy.newProxyInstance(r2, r3, r4)
            return r2
        L_0x065d:
            r0 = move-exception
            r23 = r2
            r22 = r3
            r24 = r4
            r2 = r0
            boolean r3 = r1.generate
            if (r3 == 0) goto L_0x067c
            net.bytebuddy.utility.GraalImageCode r3 = net.bytebuddy.utility.GraalImageCode.getCurrent()
            java.lang.Class<T> r4 = r1.proxy
            java.lang.reflect.Method[] r4 = r4.getMethods()
            net.bytebuddy.utility.MethodComparator r5 = net.bytebuddy.utility.MethodComparator.INSTANCE
            java.lang.Object[] r3 = r3.sorted(r4, r5)
            java.lang.reflect.Method[] r3 = (java.lang.reflect.Method[]) r3
            goto L_0x0682
        L_0x067c:
            java.lang.Class<T> r3 = r1.proxy
            java.lang.reflect.Method[] r3 = r3.getMethods()
        L_0x0682:
            int r4 = r3.length
            r15 = 0
        L_0x0684:
            if (r15 >= r4) goto L_0x073a
            r5 = r3[r15]
            java.lang.Class r6 = r5.getDeclaringClass()
            r10 = r24
            if (r6 != r10) goto L_0x0696
        L_0x0690:
            r11 = r22
            r6 = r23
            goto L_0x0730
        L_0x0696:
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Instance> r6 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Instance.class
            boolean r6 = r5.isAnnotationPresent(r6)
            if (r6 == 0) goto L_0x06fb
            java.lang.Class[] r6 = r5.getParameterTypes()
            int r6 = r6.length
            r11 = 1
            if (r6 != r11) goto L_0x06e4
            java.lang.Class[] r6 = r5.getParameterTypes()
            r11 = 0
            r6 = r6[r11]
            boolean r6 = r6.isPrimitive()
            if (r6 != 0) goto L_0x06e4
            java.lang.Class[] r6 = r5.getParameterTypes()
            r6 = r6[r11]
            boolean r6 = r6.isArray()
            if (r6 != 0) goto L_0x06e4
            java.lang.Class r6 = r5.getReturnType()
            java.lang.Class r11 = java.lang.Boolean.TYPE
            if (r6 != r11) goto L_0x06cd
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForDefaultValue r6 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForDefaultValue.BOOLEAN
            r7.put(r5, r6)
            goto L_0x0690
        L_0x06cd:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r6 = r23
            r3.append(r6)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x06e4:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r11 = r22
            r3.append(r11)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x06fb:
            r11 = r22
            r6 = r23
            if (r8 != 0) goto L_0x0725
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Defaults> r12 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults.class
            boolean r12 = r5.isAnnotationPresent(r12)
            if (r12 == 0) goto L_0x070a
            goto L_0x0725
        L_0x070a:
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod r12 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Type not available on current VM: "
            r13.append(r14)
            java.lang.String r14 = r2.getMessage()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            goto L_0x072d
        L_0x0725:
            java.lang.Class r12 = r5.getReturnType()
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher r12 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForDefaultValue.of(r12)
        L_0x072d:
            r7.put(r5, r12)
        L_0x0730:
            int r15 = r15 + 1
            r23 = r6
            r24 = r10
            r22 = r11
            goto L_0x0684
        L_0x073a:
            boolean r2 = r1.generate
            if (r2 == 0) goto L_0x0745
            java.lang.Class<T> r2 = r1.proxy
            java.lang.Object r2 = net.bytebuddy.utility.dispatcher.JavaDispatcher.DynamicClassLoader.proxy(r2, r7)
            return r2
        L_0x0745:
            java.lang.Class<T> r2 = r1.proxy
            java.lang.ClassLoader r2 = r2.getClassLoader()
            r3 = 1
            java.lang.Class[] r3 = new java.lang.Class[r3]
            java.lang.Class<T> r4 = r1.proxy
            r5 = 0
            r3[r5] = r4
            net.bytebuddy.utility.dispatcher.JavaDispatcher$ProxiedInvocationHandler r4 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$ProxiedInvocationHandler
            r4.<init>(r9, r7)
            java.lang.Object r2 = java.lang.reflect.Proxy.newProxyInstance(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.dispatcher.JavaDispatcher.run():java.lang.Object");
    }

    protected static <T> PrivilegedAction<T> of(Class<T> cls, @MaybeNull ClassLoader classLoader2) {
        return of(cls, classLoader2, GENERATE);
    }

    protected static <T> PrivilegedAction<T> of(Class<T> cls, @MaybeNull ClassLoader classLoader2, boolean z10) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("Expected an interface instead of " + cls);
        } else if (!cls.isAnnotationPresent(Proxied.class)) {
            throw new IllegalArgumentException("Expected " + cls.getName() + " to be annotated with " + Proxied.class.getName());
        } else if (!((Proxied) cls.getAnnotation(Proxied.class)).value().startsWith("java.security.")) {
            return new JavaDispatcher(cls, classLoader2, z10);
        } else {
            throw new IllegalArgumentException("Classes related to Java security cannot be proxied: " + cls.getName());
        }
    }
}
