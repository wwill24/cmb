package net.bytebuddy.asm;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class TypeReferenceAdjustment extends AsmVisitorWrapper.AbstractBase {
    private final ElementMatcher.Junction<? super TypeDescription> filter;
    private final boolean strict;

    protected TypeReferenceAdjustment(boolean z10, ElementMatcher.Junction<? super TypeDescription> junction) {
        this.strict = z10;
        this.filter = junction;
    }

    public static TypeReferenceAdjustment relaxed() {
        return new TypeReferenceAdjustment(false, ElementMatchers.none());
    }

    public static TypeReferenceAdjustment strict() {
        return new TypeReferenceAdjustment(true, ElementMatchers.none());
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TypeReferenceAdjustment typeReferenceAdjustment = (TypeReferenceAdjustment) obj;
        return this.strict == typeReferenceAdjustment.strict && this.filter.equals(typeReferenceAdjustment.filter);
    }

    public TypeReferenceAdjustment filter(ElementMatcher<? super TypeDescription> elementMatcher) {
        return new TypeReferenceAdjustment(this.strict, this.filter.or(elementMatcher));
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + (this.strict ? 1 : 0)) * 31) + this.filter.hashCode();
    }

    public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i10, int i11) {
        return new TypeReferenceClassVisitor(classVisitor, this.strict, this.filter, typePool);
    }

    protected static class TypeReferenceClassVisitor extends ClassVisitor {
        /* access modifiers changed from: private */
        @AlwaysNull
        public static final AnnotationVisitor IGNORE_ANNOTATION = null;
        @AlwaysNull
        private static final FieldVisitor IGNORE_FIELD = null;
        @AlwaysNull
        private static final MethodVisitor IGNORE_METHOD = null;
        private final ElementMatcher<? super TypeDescription> filter;
        /* access modifiers changed from: private */
        public final Set<String> observedTypes = new HashSet();
        private final boolean strict;
        private final TypePool typePool;
        private final Set<String> visitedInnerTypes = new HashSet();

        protected class TypeReferenceAnnotationVisitor extends AnnotationVisitor {
            protected TypeReferenceAnnotationVisitor(AnnotationVisitor annotationVisitor) {
                super(OpenedClassReader.ASM_API, annotationVisitor);
            }

            public void visit(String str, Object obj) {
                TypeReferenceClassVisitor.this.resolve(obj);
                super.visit(str, obj);
            }

            @MaybeNull
            public AnnotationVisitor visitAnnotation(String str, String str2) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str2).getInternalName());
                AnnotationVisitor visitAnnotation = super.visitAnnotation(str, str2);
                if (visitAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            @MaybeNull
            public AnnotationVisitor visitArray(String str) {
                AnnotationVisitor visitArray = super.visitArray(str);
                if (visitArray != null) {
                    return new TypeReferenceAnnotationVisitor(visitArray);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public void visitEnum(String str, String str2, String str3) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str2).getInternalName());
                super.visitEnum(str, str2, str3);
            }
        }

        protected class TypeReferenceFieldVisitor extends FieldVisitor {
            protected TypeReferenceFieldVisitor(FieldVisitor fieldVisitor) {
                super(OpenedClassReader.ASM_API, fieldVisitor);
            }

            @MaybeNull
            public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitAnnotation = super.visitAnnotation(str, z10);
                if (visitAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }
        }

        protected class TypeReferenceMethodVisitor extends MethodVisitor {
            protected TypeReferenceMethodVisitor(MethodVisitor methodVisitor) {
                super(OpenedClassReader.ASM_API, methodVisitor);
            }

            @MaybeNull
            public AnnotationVisitor visitAnnotation(String str, boolean z10) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitAnnotation = super.visitAnnotation(str, z10);
                if (visitAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            @MaybeNull
            public AnnotationVisitor visitAnnotationDefault() {
                AnnotationVisitor visitAnnotationDefault = super.visitAnnotationDefault();
                if (visitAnnotationDefault != null) {
                    return new TypeReferenceAnnotationVisitor(visitAnnotationDefault);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public void visitFieldInsn(int i10, String str, String str2, String str3) {
                TypeReferenceClassVisitor.this.observeInternalName(str);
                TypeReferenceClassVisitor.this.resolve(Type.getType(str3));
                super.visitFieldInsn(i10, str, str2, str3);
            }

            @MaybeNull
            public AnnotationVisitor visitInsnAnnotation(int i10, @MaybeNull TypePath typePath, String str, boolean z10) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitInsnAnnotation = super.visitInsnAnnotation(i10, typePath, str, z10);
                if (visitInsnAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitInsnAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
                TypeReferenceClassVisitor.this.resolve(Type.getType(str2));
                TypeReferenceClassVisitor.this.resolve(handle);
                for (Object resolve : objArr) {
                    TypeReferenceClassVisitor.this.resolve(resolve);
                }
                super.visitInvokeDynamicInsn(str, str2, handle, objArr);
            }

            public void visitLdcInsn(Object obj) {
                TypeReferenceClassVisitor.this.resolve(obj);
                super.visitLdcInsn(obj);
            }

            @MaybeNull
            public AnnotationVisitor visitLocalVariableAnnotation(int i10, @MaybeNull TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z10) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitLocalVariableAnnotation = super.visitLocalVariableAnnotation(i10, typePath, labelArr, labelArr2, iArr, str, z10);
                if (visitLocalVariableAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitLocalVariableAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public void visitMethodInsn(int i10, String str, String str2, String str3, boolean z10) {
                TypeReferenceClassVisitor.this.observeInternalName(str);
                TypeReferenceClassVisitor.this.resolve(Type.getType(str3));
                super.visitMethodInsn(i10, str, str2, str3, z10);
            }

            public void visitMultiANewArrayInsn(String str, int i10) {
                TypeReferenceClassVisitor.this.resolve(Type.getType(str));
                super.visitMultiANewArrayInsn(str, i10);
            }

            @MaybeNull
            public AnnotationVisitor visitParameterAnnotation(int i10, String str, boolean z10) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitParameterAnnotation = super.visitParameterAnnotation(i10, str, z10);
                if (visitParameterAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitParameterAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            @MaybeNull
            public AnnotationVisitor visitTryCatchAnnotation(int i10, @MaybeNull TypePath typePath, String str, boolean z10) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitTryCatchAnnotation = super.visitTryCatchAnnotation(i10, typePath, str, z10);
                if (visitTryCatchAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitTryCatchAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public void visitTryCatchBlock(Label label, Label label2, Label label3, @MaybeNull String str) {
                if (str != null) {
                    TypeReferenceClassVisitor.this.observedTypes.add(str);
                }
                super.visitTryCatchBlock(label, label2, label3, str);
            }

            @MaybeNull
            public AnnotationVisitor visitTypeAnnotation(int i10, @MaybeNull TypePath typePath, String str, boolean z10) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitTypeAnnotation = super.visitTypeAnnotation(i10, typePath, str, z10);
                if (visitTypeAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitTypeAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public void visitTypeInsn(int i10, String str) {
                TypeReferenceClassVisitor.this.observeInternalName(str);
                super.visitTypeInsn(i10, str);
            }
        }

        protected TypeReferenceClassVisitor(ClassVisitor classVisitor, boolean z10, ElementMatcher<? super TypeDescription> elementMatcher, TypePool typePool2) {
            super(OpenedClassReader.ASM_API, classVisitor);
            this.typePool = typePool2;
            this.strict = z10;
            this.filter = elementMatcher;
        }

        /* access modifiers changed from: private */
        public void observeInternalName(String str) {
            int lastIndexOf = str.lastIndexOf(91);
            if (lastIndexOf != -1) {
                str = str.substring(lastIndexOf + 2, str.length() - 1);
            }
            this.observedTypes.add(str);
        }

        /* access modifiers changed from: protected */
        public void resolve(Type type) {
            if (type.getSort() == 11) {
                resolve(type.getReturnType());
                for (Type resolve : type.getArgumentTypes()) {
                    resolve(resolve);
                }
                return;
            }
            while (type.getSort() == 9) {
                type = type.getElementType();
            }
            if (type.getSort() == 10) {
                this.observedTypes.add(type.getInternalName());
            }
        }

        public void visit(int i10, int i11, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
            if (str3 != null) {
                this.observedTypes.add(str3);
            }
            if (strArr != null) {
                this.observedTypes.addAll(Arrays.asList(strArr));
            }
            super.visit(i10, i11, str, str2, str3, strArr);
        }

        @MaybeNull
        public AnnotationVisitor visitAnnotation(String str, boolean z10) {
            this.observedTypes.add(Type.getType(str).getInternalName());
            AnnotationVisitor visitAnnotation = super.visitAnnotation(str, z10);
            if (visitAnnotation != null) {
                return new TypeReferenceAnnotationVisitor(visitAnnotation);
            }
            return IGNORE_ANNOTATION;
        }

        @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public void visitEnd() {
            String str;
            for (String next : this.observedTypes) {
                if (this.visitedInnerTypes.add(next)) {
                    TypePool.Resolution describe = this.typePool.describe(next.replace('/', '.'));
                    if (describe.isResolved()) {
                        TypeDescription resolve = describe.resolve();
                        if (!this.filter.matches(resolve)) {
                            while (resolve != null && resolve.isNestedClass()) {
                                String internalName = resolve.getInternalName();
                                String str2 = null;
                                if (resolve.isMemberType()) {
                                    str = resolve.getDeclaringType().getInternalName();
                                } else {
                                    str = null;
                                }
                                if (!resolve.isAnonymousType()) {
                                    str2 = resolve.getSimpleName();
                                }
                                super.visitInnerClass(internalName, str, str2, resolve.getModifiers());
                                do {
                                    try {
                                        resolve = resolve.getEnclosingType();
                                        if (resolve == null || this.visitedInnerTypes.add(resolve.getInternalName())) {
                                        }
                                        resolve = resolve.getEnclosingType();
                                        break;
                                    } catch (RuntimeException e10) {
                                        if (this.strict) {
                                            throw e10;
                                        }
                                    }
                                } while (this.visitedInnerTypes.add(resolve.getInternalName()));
                            }
                        } else {
                            continue;
                        }
                    } else if (this.strict) {
                        throw new IllegalStateException("Could not locate type for: " + next.replace('/', '.'));
                    }
                }
            }
            super.visitEnd();
        }

        @MaybeNull
        public FieldVisitor visitField(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
            FieldVisitor visitField = super.visitField(i10, str, str2, str3, obj);
            if (visitField == null) {
                return IGNORE_FIELD;
            }
            resolve(Type.getType(str2));
            return new TypeReferenceFieldVisitor(visitField);
        }

        public void visitInnerClass(String str, String str2, String str3, int i10) {
            this.visitedInnerTypes.add(str);
            super.visitInnerClass(str, str2, str3, i10);
        }

        @MaybeNull
        public MethodVisitor visitMethod(int i10, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
            MethodVisitor visitMethod = super.visitMethod(i10, str, str2, str3, strArr);
            if (visitMethod == null) {
                return IGNORE_METHOD;
            }
            resolve(Type.getType(str2));
            if (strArr != null) {
                this.observedTypes.addAll(Arrays.asList(strArr));
            }
            return new TypeReferenceMethodVisitor(visitMethod);
        }

        public void visitNestHost(String str) {
            this.observedTypes.add(str);
            super.visitNestHost(str);
        }

        public void visitNestMember(String str) {
            this.observedTypes.add(str);
            super.visitNestMember(str);
        }

        public void visitOuterClass(String str, String str2, String str3) {
            this.observedTypes.add(str);
            super.visitOuterClass(str, str2, str3);
        }

        @MaybeNull
        public RecordComponentVisitor visitRecordComponent(String str, String str2, @MaybeNull String str3) {
            this.observedTypes.add(Type.getType(str2).getInternalName());
            return super.visitRecordComponent(str, str2, str3);
        }

        @MaybeNull
        public AnnotationVisitor visitTypeAnnotation(int i10, @MaybeNull TypePath typePath, String str, boolean z10) {
            this.observedTypes.add(Type.getType(str).getInternalName());
            AnnotationVisitor visitTypeAnnotation = super.visitTypeAnnotation(i10, typePath, str, z10);
            if (visitTypeAnnotation != null) {
                return new TypeReferenceAnnotationVisitor(visitTypeAnnotation);
            }
            return IGNORE_ANNOTATION;
        }

        /* access modifiers changed from: protected */
        public void resolve(Handle handle) {
            this.observedTypes.add(handle.getOwner());
            Type type = Type.getType(handle.getDesc());
            resolve(type.getReturnType());
            for (Type resolve : type.getArgumentTypes()) {
                resolve(resolve);
            }
        }

        /* access modifiers changed from: protected */
        public void resolve(ConstantDynamic constantDynamic) {
            Type type = Type.getType(constantDynamic.getDescriptor());
            resolve(type.getReturnType());
            for (Type resolve : type.getArgumentTypes()) {
                resolve(resolve);
            }
            resolve(constantDynamic.getBootstrapMethod());
            for (int i10 = 0; i10 < constantDynamic.getBootstrapMethodArgumentCount(); i10++) {
                resolve(constantDynamic.getBootstrapMethodArgument(i10));
            }
        }

        /* access modifiers changed from: protected */
        public void resolve(Object obj) {
            if (obj instanceof Type) {
                resolve((Type) obj);
            } else if (obj instanceof Handle) {
                resolve((Handle) obj);
            } else if (obj instanceof ConstantDynamic) {
                resolve((ConstantDynamic) obj);
            }
        }
    }
}
