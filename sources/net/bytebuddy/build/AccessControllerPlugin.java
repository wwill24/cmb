package net.bytebuddy.build;

import com.facebook.internal.ServerProtocol;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class AccessControllerPlugin extends Plugin.ForElementMatcher implements Plugin.Factory {
    private static final String ACCESS_CONTROLLER = "java.security.AccessController";
    private static final Object[] EMPTY = new Object[0];
    private static final String NAME = "ACCESS_CONTROLLER";
    /* access modifiers changed from: private */
    public static final Map<MethodDescription.SignatureToken, MethodDescription.SignatureToken> SIGNATURES;
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    @MaybeNull
    private final String property;

    @HashCodeAndEqualsPlugin.Enhance
    protected static class AccessControlWrapper implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {
        private final String name;

        protected static class PrefixingMethodVisitor extends MethodVisitor {
            private final Implementation.Context.FrameGeneration frameGeneration;
            private final TypeDescription instrumentedType;
            private final String name;
            private final int offset;
            private final MethodDescription.SignatureToken token;

            protected PrefixingMethodVisitor(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodDescription.SignatureToken signatureToken, String str, int i10, Implementation.Context.FrameGeneration frameGeneration2) {
                super(OpenedClassReader.ASM_API, methodVisitor);
                this.instrumentedType = typeDescription;
                this.token = signatureToken;
                this.name = str;
                this.offset = i10;
                this.frameGeneration = frameGeneration2;
            }

            public void visitCode() {
                this.mv.visitCode();
                this.mv.visitFieldInsn(Opcodes.GETSTATIC, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(Boolean.TYPE));
                Label label = new Label();
                this.mv.visitJumpInsn(Opcodes.IFEQ, label);
                int i10 = this.offset;
                for (TypeDescription next : this.token.getParameterTypes()) {
                    this.mv.visitVarInsn(Type.getType(next.getDescriptor()).getOpcode(21), i10);
                    if (next.equals(JavaType.ACCESS_CONTROL_CONTEXT.getTypeStub())) {
                        this.mv.visitTypeInsn(192, next.getInternalName());
                    }
                    i10 += next.getStackSize().getSize();
                }
                this.mv.visitMethodInsn(Opcodes.INVOKESTATIC, AccessControllerPlugin.ACCESS_CONTROLLER.replace('.', '/'), this.token.getName(), this.token.getDescriptor(), false);
                this.mv.visitInsn(Type.getType(this.token.getReturnType().getDescriptor()).getOpcode(Opcodes.IRETURN));
                this.mv.visitLabel(label);
                this.frameGeneration.same(this.mv, this.token.getParameterTypes());
            }

            public void visitMaxs(int i10, int i11) {
                this.mv.visitMaxs(Math.max(Math.max(StackSize.of((Collection<? extends TypeDefinition>) this.token.getParameterTypes()), this.token.getReturnType().getStackSize().getSize()), i10), i11);
            }
        }

        protected AccessControlWrapper(String str) {
            this.name = str;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.name.equals(((AccessControlWrapper) obj).name);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.name.hashCode();
        }

        public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i10, int i11) {
            MethodDescription.SignatureToken signatureToken = (MethodDescription.SignatureToken) AccessControllerPlugin.SIGNATURES.get(((MethodDescription.InDefinedShape) methodDescription.asDefined()).asSignatureToken());
            if (signatureToken == null) {
                throw new IllegalStateException(methodDescription + " does not have a method with a matching signature in " + AccessControllerPlugin.ACCESS_CONTROLLER);
            } else if (methodDescription.isPublic() || methodDescription.isProtected()) {
                throw new IllegalStateException(methodDescription + " is either public or protected what is not permitted to avoid context leaks");
            } else {
                return new PrefixingMethodVisitor(methodVisitor, typeDescription, signatureToken, this.name, methodDescription.isStatic() ^ true ? 1 : 0, context.getFrameGeneration());
            }
        }
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enhance {
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static abstract class Initializer implements ByteCodeAppender {
        private final TypeDescription instrumentedType;
        private final String name;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class WithProperty extends Initializer {
            private final String property;

            protected WithProperty(TypeDescription typeDescription, String str, String str2) {
                super(typeDescription, str);
                this.property = str2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.property.equals(((WithProperty) obj).property);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.property.hashCode();
            }

            /* access modifiers changed from: protected */
            public int onAccessController(MethodVisitor methodVisitor) {
                Class<String> cls = String.class;
                methodVisitor.visitLdcInsn(this.property);
                methodVisitor.visitLdcInsn(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(System.class), "getProperty", Type.getMethodDescriptor(Type.getType((Class<?>) cls), Type.getType((Class<?>) cls), Type.getType((Class<?>) cls)), false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(Boolean.class), "parseBoolean", Type.getMethodDescriptor(Type.getType((Class<?>) Boolean.TYPE), Type.getType((Class<?>) cls)), false);
                return 2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class WithoutProperty extends Initializer {
            protected WithoutProperty(TypeDescription typeDescription, String str) {
                super(typeDescription, str);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }

            public int hashCode() {
                return super.hashCode();
            }

            /* access modifiers changed from: protected */
            public int onAccessController(MethodVisitor methodVisitor) {
                methodVisitor.visitInsn(4);
                return 1;
            }
        }

        protected Initializer(TypeDescription typeDescription, String str) {
            this.instrumentedType = typeDescription;
            this.name = str;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            MethodVisitor methodVisitor2 = methodVisitor;
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            Label label4 = new Label();
            Label label5 = new Label();
            methodVisitor2.visitTryCatchBlock(label, label2, label3, Type.getInternalName(ClassNotFoundException.class));
            methodVisitor2.visitTryCatchBlock(label, label2, label4, Type.getInternalName(SecurityException.class));
            methodVisitor2.visitLabel(label);
            methodVisitor2.visitLdcInsn(AccessControllerPlugin.ACCESS_CONTROLLER);
            methodVisitor2.visitInsn(3);
            methodVisitor2.visitInsn(1);
            String internalName = Type.getInternalName(Class.class);
            Type type = Type.getType((Class<?>) Class.class);
            Class cls = Boolean.TYPE;
            MethodVisitor methodVisitor3 = methodVisitor;
            methodVisitor3.visitMethodInsn(Opcodes.INVOKESTATIC, internalName, "forName", Type.getMethodDescriptor(type, Type.getType((Class<?>) String.class), Type.getType((Class<?>) cls), Type.getType((Class<?>) ClassLoader.class)), false);
            methodVisitor2.visitInsn(87);
            int onAccessController = onAccessController(methodVisitor);
            methodVisitor2.visitFieldInsn(Opcodes.PUTSTATIC, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(cls));
            methodVisitor2.visitLabel(label2);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label5);
            methodVisitor2.visitLabel(label3);
            context.getFrameGeneration().same1(methodVisitor2, TypeDescription.ForLoadedType.of(ClassNotFoundException.class), Collections.emptyList());
            methodVisitor2.visitInsn(87);
            methodVisitor2.visitInsn(3);
            methodVisitor2.visitFieldInsn(Opcodes.PUTSTATIC, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(cls));
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label5);
            methodVisitor2.visitLabel(label4);
            context.getFrameGeneration().same1(methodVisitor2, TypeDescription.ForLoadedType.of(SecurityException.class), Collections.emptyList());
            methodVisitor2.visitInsn(87);
            methodVisitor2.visitInsn(4);
            methodVisitor2.visitFieldInsn(Opcodes.PUTSTATIC, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(cls));
            methodVisitor2.visitLabel(label5);
            context.getFrameGeneration().same(methodVisitor2, Collections.emptyList());
            return new ByteCodeAppender.Size(Math.max(3, onAccessController), 0);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Initializer initializer = (Initializer) obj;
            return this.name.equals(initializer.name) && this.instrumentedType.equals(initializer.instrumentedType);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.name.hashCode();
        }

        /* access modifiers changed from: protected */
        public abstract int onAccessController(MethodVisitor methodVisitor);
    }

    static {
        Class<Object> cls = Object.class;
        HashMap hashMap = new HashMap();
        SIGNATURES = hashMap;
        hashMap.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedAction.class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedAction.class)));
        hashMap.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedAction.class)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedAction.class)));
        MethodDescription.SignatureToken signatureToken = new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedAction.class), TypeDescription.ForLoadedType.of(cls));
        TypeDescription of2 = TypeDescription.ForLoadedType.of(cls);
        JavaType javaType = JavaType.ACCESS_CONTROL_CONTEXT;
        hashMap.put(signatureToken, new MethodDescription.SignatureToken("doPrivileged", of2, TypeDescription.ForLoadedType.of(PrivilegedAction.class), javaType.getTypeStub()));
        hashMap.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedAction.class), TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Permission[].class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedAction.class), javaType.getTypeStub(), TypeDescription.ForLoadedType.of(Permission[].class)));
        hashMap.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedAction.class), TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Permission[].class)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedAction.class), javaType.getTypeStub(), TypeDescription.ForLoadedType.of(Permission[].class)));
        hashMap.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class)));
        hashMap.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class)));
        hashMap.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), TypeDescription.ForLoadedType.of(cls)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), javaType.getTypeStub()));
        hashMap.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Permission[].class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), javaType.getTypeStub(), TypeDescription.ForLoadedType.of(Permission[].class)));
        hashMap.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Permission[].class)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), javaType.getTypeStub(), TypeDescription.ForLoadedType.of(Permission[].class)));
        hashMap.put(new MethodDescription.SignatureToken("getContext", TypeDescription.ForLoadedType.of(cls), new TypeDescription[0]), new MethodDescription.SignatureToken("getContext", javaType.getTypeStub(), new TypeDescription[0]));
        hashMap.put(new MethodDescription.SignatureToken("checkPermission", TypeDescription.ForLoadedType.of(Void.TYPE), TypeDescription.ForLoadedType.of(Permission.class)), new MethodDescription.SignatureToken("checkPermission", TypeDescription.ForLoadedType.of(Void.TYPE), TypeDescription.ForLoadedType.of(Permission.class)));
    }

    public AccessControllerPlugin() {
        this((String) null);
    }

    @SuppressFBWarnings(justification = "Collision is unlikely and buffer overhead not justified.", value = {"SBSC_USE_STRINGBUFFER_CONCATENATION"})
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        ByteCodeAppender byteCodeAppender;
        String str = NAME;
        while (!((FieldList) typeDescription.getDeclaredFields().filter(ElementMatchers.named(str))).isEmpty()) {
            str = str + "$";
        }
        DynamicType.Builder<T> visit = builder.defineField(str, (java.lang.reflect.Type) Boolean.TYPE, Visibility.PRIVATE, Ownership.STATIC, FieldManifestation.FINAL).visit(new AsmVisitorWrapper.ForDeclaredMethods().method((ElementMatcher<? super MethodDescription>) ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class), new AccessControlWrapper(str)));
        String str2 = this.property;
        if (str2 == null) {
            byteCodeAppender = new Initializer.WithoutProperty(typeDescription, str);
        } else {
            byteCodeAppender = new Initializer.WithProperty(typeDescription, str, str2);
        }
        return visit.initializer(byteCodeAppender);
    }

    public void close() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
        /*
            r4 = this;
            boolean r0 = super.equals(r5)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            r0 = 1
            if (r4 != r5) goto L_0x000c
            return r0
        L_0x000c:
            if (r5 != 0) goto L_0x000f
            return r1
        L_0x000f:
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L_0x001a
            return r1
        L_0x001a:
            java.lang.String r2 = r4.property
            net.bytebuddy.build.AccessControllerPlugin r5 = (net.bytebuddy.build.AccessControllerPlugin) r5
            java.lang.String r5 = r5.property
            if (r5 == 0) goto L_0x002b
            if (r2 == 0) goto L_0x002d
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x002e
            return r1
        L_0x002b:
            if (r2 == 0) goto L_0x002e
        L_0x002d:
            return r1
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.build.AccessControllerPlugin.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.property;
        return str != null ? hashCode + str.hashCode() : hashCode;
    }

    public Plugin make() {
        return this;
    }

    @Plugin.Factory.UsingReflection.Priority(Integer.MAX_VALUE)
    public AccessControllerPlugin(@MaybeNull String str) {
        super(ElementMatchers.declaresMethod(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class)));
        this.property = str;
    }
}
