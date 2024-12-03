package net.bytebuddy.implementation.attribute;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Array;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.jar.asm.TypeReference;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface AnnotationAppender {
    @AlwaysNull
    public static final String NO_NAME = null;

    /* renamed from: net.bytebuddy.implementation.attribute.AnnotationAppender$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$lang$annotation$RetentionPolicy;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                java.lang.annotation.RetentionPolicy[] r0 = java.lang.annotation.RetentionPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$lang$annotation$RetentionPolicy = r0
                java.lang.annotation.RetentionPolicy r1 = java.lang.annotation.RetentionPolicy.RUNTIME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$lang$annotation$RetentionPolicy     // Catch:{ NoSuchFieldError -> 0x001d }
                java.lang.annotation.RetentionPolicy r1 = java.lang.annotation.RetentionPolicy.CLASS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$lang$annotation$RetentionPolicy     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.lang.annotation.RetentionPolicy r1 = java.lang.annotation.RetentionPolicy.SOURCE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.implementation.attribute.AnnotationAppender.AnonymousClass1.<clinit>():void");
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForTypeAnnotations implements TypeDescription.Generic.Visitor<AnnotationAppender> {
        private static final char COMPONENT_TYPE_PATH = '[';
        private static final String EMPTY_TYPE_PATH = "";
        private static final char INDEXED_TYPE_DELIMITER = ';';
        private static final char INNER_CLASS_PATH = '.';
        private static final int SUPER_CLASS_INDEX = -1;
        public static final boolean VARIABLE_ON_INVOKEABLE = false;
        public static final boolean VARIABLE_ON_TYPE = true;
        private static final char WILDCARD_TYPE_PATH = '*';
        private final AnnotationAppender annotationAppender;
        private final AnnotationValueFilter annotationValueFilter;
        private final String typePath;
        private final int typeReference;

        protected ForTypeAnnotations(AnnotationAppender annotationAppender2, AnnotationValueFilter annotationValueFilter2, TypeReference typeReference2) {
            this(annotationAppender2, annotationValueFilter2, typeReference2.getValue(), "");
        }

        private AnnotationAppender apply(TypeDescription.Generic generic, String str) {
            AnnotationAppender annotationAppender2 = this.annotationAppender;
            for (AnnotationDescription append : generic.getDeclaredAnnotations()) {
                annotationAppender2 = annotationAppender2.append(append, this.annotationValueFilter, this.typeReference, str);
            }
            return annotationAppender2;
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofExceptionType(AnnotationAppender annotationAppender2, AnnotationValueFilter annotationValueFilter2, int i10) {
            return new ForTypeAnnotations(annotationAppender2, annotationValueFilter2, TypeReference.newExceptionReference(i10));
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofFieldType(AnnotationAppender annotationAppender2, AnnotationValueFilter annotationValueFilter2) {
            return new ForTypeAnnotations(annotationAppender2, annotationValueFilter2, TypeReference.newTypeReference(19));
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofInterfaceType(AnnotationAppender annotationAppender2, AnnotationValueFilter annotationValueFilter2, int i10) {
            return new ForTypeAnnotations(annotationAppender2, annotationValueFilter2, TypeReference.newSuperTypeReference(i10));
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofMethodParameterType(AnnotationAppender annotationAppender2, AnnotationValueFilter annotationValueFilter2, int i10) {
            return new ForTypeAnnotations(annotationAppender2, annotationValueFilter2, TypeReference.newFormalParameterReference(i10));
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofMethodReturnType(AnnotationAppender annotationAppender2, AnnotationValueFilter annotationValueFilter2) {
            return new ForTypeAnnotations(annotationAppender2, annotationValueFilter2, TypeReference.newTypeReference(20));
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofReceiverType(AnnotationAppender annotationAppender2, AnnotationValueFilter annotationValueFilter2) {
            return new ForTypeAnnotations(annotationAppender2, annotationValueFilter2, TypeReference.newTypeReference(21));
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofSuperClass(AnnotationAppender annotationAppender2, AnnotationValueFilter annotationValueFilter2) {
            return new ForTypeAnnotations(annotationAppender2, annotationValueFilter2, TypeReference.newSuperTypeReference(-1));
        }

        public static AnnotationAppender ofTypeVariable(AnnotationAppender annotationAppender2, AnnotationValueFilter annotationValueFilter2, boolean z10, List<? extends TypeDescription.Generic> list) {
            return ofTypeVariable(annotationAppender2, annotationValueFilter2, z10, 0, list);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForTypeAnnotations forTypeAnnotations = (ForTypeAnnotations) obj;
            return this.typeReference == forTypeAnnotations.typeReference && this.typePath.equals(forTypeAnnotations.typePath) && this.annotationAppender.equals(forTypeAnnotations.annotationAppender) && this.annotationValueFilter.equals(forTypeAnnotations.annotationValueFilter);
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.annotationAppender.hashCode()) * 31) + this.annotationValueFilter.hashCode()) * 31) + this.typeReference) * 31) + this.typePath.hashCode();
        }

        protected ForTypeAnnotations(AnnotationAppender annotationAppender2, AnnotationValueFilter annotationValueFilter2, int i10, String str) {
            this.annotationAppender = annotationAppender2;
            this.annotationValueFilter = annotationValueFilter2;
            this.typeReference = i10;
            this.typePath = str;
        }

        public static AnnotationAppender ofTypeVariable(AnnotationAppender annotationAppender2, AnnotationValueFilter annotationValueFilter2, boolean z10, int i10, List<? extends TypeDescription.Generic> list) {
            int i11;
            int i12;
            if (z10) {
                i11 = 17;
                i12 = 0;
            } else {
                i11 = 18;
                i12 = 1;
            }
            for (TypeDescription.Generic generic : list.subList(i10, list.size())) {
                int value = TypeReference.newTypeParameterReference(i12, i10).getValue();
                for (AnnotationDescription append : generic.getDeclaredAnnotations()) {
                    annotationAppender2 = annotationAppender2.append(append, annotationValueFilter2, value, "");
                }
                int i13 = (((TypeDescription.Generic) generic.getUpperBounds().get(0)).getSort().isTypeVariable() || !((TypeDescription.Generic) generic.getUpperBounds().get(0)).isInterface()) ? 0 : 1;
                for (TypeDescription.Generic accept : generic.getUpperBounds()) {
                    annotationAppender2 = (AnnotationAppender) accept.accept(new ForTypeAnnotations(annotationAppender2, annotationValueFilter2, TypeReference.newTypeParameterBoundReference(i11, i10, i13)));
                    i13++;
                }
                i10++;
            }
            return annotationAppender2;
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public AnnotationAppender onGenericArray(TypeDescription.Generic generic) {
            TypeDescription.Generic componentType = generic.getComponentType();
            AnnotationAppender apply = apply(generic, this.typePath);
            AnnotationValueFilter annotationValueFilter2 = this.annotationValueFilter;
            int i10 = this.typeReference;
            return (AnnotationAppender) componentType.accept(new ForTypeAnnotations(apply, annotationValueFilter2, i10, this.typePath + '['));
        }

        public AnnotationAppender onNonGenericType(TypeDescription.Generic generic) {
            StringBuilder sb2 = new StringBuilder(this.typePath);
            for (int i10 = 0; i10 < generic.asErasure().getInnerClassCount(); i10++) {
                sb2.append('.');
            }
            AnnotationAppender apply = apply(generic, sb2.toString());
            TypeDescription.Generic componentType = generic.getComponentType();
            if (componentType == null) {
                return apply;
            }
            AnnotationValueFilter annotationValueFilter2 = this.annotationValueFilter;
            int i11 = this.typeReference;
            return (AnnotationAppender) componentType.accept(new ForTypeAnnotations(apply, annotationValueFilter2, i11, this.typePath + '['));
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: net.bytebuddy.implementation.attribute.AnnotationAppender} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.bytebuddy.implementation.attribute.AnnotationAppender onParameterizedType(net.bytebuddy.description.type.TypeDescription.Generic r10) {
            /*
                r9 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = r9.typePath
                r0.<init>(r1)
                r1 = 0
                r2 = r1
            L_0x0009:
                net.bytebuddy.description.type.TypeDescription r3 = r10.asErasure()
                int r3 = r3.getInnerClassCount()
                if (r2 >= r3) goto L_0x001b
                r3 = 46
                r0.append(r3)
                int r2 = r2 + 1
                goto L_0x0009
            L_0x001b:
                java.lang.String r2 = r0.toString()
                net.bytebuddy.implementation.attribute.AnnotationAppender r2 = r9.apply(r10, r2)
                net.bytebuddy.description.type.TypeDescription$Generic r3 = r10.getOwnerType()
                if (r3 == 0) goto L_0x003a
                net.bytebuddy.implementation.attribute.AnnotationAppender$ForTypeAnnotations r4 = new net.bytebuddy.implementation.attribute.AnnotationAppender$ForTypeAnnotations
                net.bytebuddy.implementation.attribute.AnnotationValueFilter r5 = r9.annotationValueFilter
                int r6 = r9.typeReference
                java.lang.String r7 = r9.typePath
                r4.<init>(r2, r5, r6, r7)
                java.lang.Object r2 = r3.accept(r4)
                net.bytebuddy.implementation.attribute.AnnotationAppender r2 = (net.bytebuddy.implementation.attribute.AnnotationAppender) r2
            L_0x003a:
                net.bytebuddy.description.type.TypeList$Generic r10 = r10.getTypeArguments()
                java.util.Iterator r10 = r10.iterator()
            L_0x0042:
                boolean r3 = r10.hasNext()
                if (r3 == 0) goto L_0x007a
                java.lang.Object r3 = r10.next()
                net.bytebuddy.description.type.TypeDescription$Generic r3 = (net.bytebuddy.description.type.TypeDescription.Generic) r3
                net.bytebuddy.implementation.attribute.AnnotationAppender$ForTypeAnnotations r4 = new net.bytebuddy.implementation.attribute.AnnotationAppender$ForTypeAnnotations
                net.bytebuddy.implementation.attribute.AnnotationValueFilter r5 = r9.annotationValueFilter
                int r6 = r9.typeReference
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = r0.toString()
                r7.append(r8)
                int r8 = r1 + 1
                r7.append(r1)
                r1 = 59
                r7.append(r1)
                java.lang.String r1 = r7.toString()
                r4.<init>(r2, r5, r6, r1)
                java.lang.Object r1 = r3.accept(r4)
                r2 = r1
                net.bytebuddy.implementation.attribute.AnnotationAppender r2 = (net.bytebuddy.implementation.attribute.AnnotationAppender) r2
                r1 = r8
                goto L_0x0042
            L_0x007a:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.implementation.attribute.AnnotationAppender.ForTypeAnnotations.onParameterizedType(net.bytebuddy.description.type.TypeDescription$Generic):net.bytebuddy.implementation.attribute.AnnotationAppender");
        }

        public AnnotationAppender onTypeVariable(TypeDescription.Generic generic) {
            return apply(generic, this.typePath);
        }

        public AnnotationAppender onWildcard(TypeDescription.Generic generic) {
            TypeDescription.Generic generic2;
            TypeList.Generic lowerBounds = generic.getLowerBounds();
            if (lowerBounds.isEmpty()) {
                generic2 = (TypeDescription.Generic) generic.getUpperBounds().getOnly();
            } else {
                generic2 = (TypeDescription.Generic) lowerBounds.getOnly();
            }
            AnnotationAppender apply = apply(generic, this.typePath);
            AnnotationValueFilter annotationValueFilter2 = this.annotationValueFilter;
            int i10 = this.typeReference;
            return (AnnotationAppender) generic2.accept(new ForTypeAnnotations(apply, annotationValueFilter2, i10, this.typePath + '*'));
        }
    }

    public interface Target {

        @HashCodeAndEqualsPlugin.Enhance
        public static class OnField implements Target {
            private final FieldVisitor fieldVisitor;

            public OnField(FieldVisitor fieldVisitor2) {
                this.fieldVisitor = fieldVisitor2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldVisitor.equals(((OnField) obj).fieldVisitor);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.fieldVisitor.hashCode();
            }

            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z10) {
                return this.fieldVisitor.visitAnnotation(str, z10);
            }

            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z10, int i10, String str2) {
                return this.fieldVisitor.visitTypeAnnotation(i10, TypePath.fromString(str2), str, z10);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OnMethod implements Target {
            private final MethodVisitor methodVisitor;

            public OnMethod(MethodVisitor methodVisitor2) {
                this.methodVisitor = methodVisitor2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodVisitor.equals(((OnMethod) obj).methodVisitor);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.methodVisitor.hashCode();
            }

            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z10) {
                return this.methodVisitor.visitAnnotation(str, z10);
            }

            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z10, int i10, String str2) {
                return this.methodVisitor.visitTypeAnnotation(i10, TypePath.fromString(str2), str, z10);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OnMethodParameter implements Target {
            private final MethodVisitor methodVisitor;
            private final int parameterIndex;

            public OnMethodParameter(MethodVisitor methodVisitor2, int i10) {
                this.methodVisitor = methodVisitor2;
                this.parameterIndex = i10;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                OnMethodParameter onMethodParameter = (OnMethodParameter) obj;
                return this.parameterIndex == onMethodParameter.parameterIndex && this.methodVisitor.equals(onMethodParameter.methodVisitor);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.methodVisitor.hashCode()) * 31) + this.parameterIndex;
            }

            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z10) {
                return this.methodVisitor.visitParameterAnnotation(this.parameterIndex, str, z10);
            }

            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z10, int i10, String str2) {
                return this.methodVisitor.visitTypeAnnotation(i10, TypePath.fromString(str2), str, z10);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OnRecordComponent implements Target {
            private final RecordComponentVisitor recordComponentVisitor;

            public OnRecordComponent(RecordComponentVisitor recordComponentVisitor2) {
                this.recordComponentVisitor = recordComponentVisitor2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.recordComponentVisitor.equals(((OnRecordComponent) obj).recordComponentVisitor);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.recordComponentVisitor.hashCode();
            }

            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z10) {
                return this.recordComponentVisitor.visitAnnotation(str, z10);
            }

            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z10, int i10, String str2) {
                return this.recordComponentVisitor.visitTypeAnnotation(i10, TypePath.fromString(str2), str, z10);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OnType implements Target {
            private final ClassVisitor classVisitor;

            public OnType(ClassVisitor classVisitor2) {
                this.classVisitor = classVisitor2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.classVisitor.equals(((OnType) obj).classVisitor);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.classVisitor.hashCode();
            }

            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z10) {
                return this.classVisitor.visitAnnotation(str, z10);
            }

            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z10, int i10, String str2) {
                return this.classVisitor.visitTypeAnnotation(i10, TypePath.fromString(str2), str, z10);
            }
        }

        @MaybeNull
        AnnotationVisitor visit(String str, boolean z10);

        @MaybeNull
        AnnotationVisitor visit(String str, boolean z10, int i10, String str2);
    }

    AnnotationAppender append(AnnotationDescription annotationDescription, AnnotationValueFilter annotationValueFilter);

    AnnotationAppender append(AnnotationDescription annotationDescription, AnnotationValueFilter annotationValueFilter, int i10, String str);

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements AnnotationAppender {
        private final Target target;

        public Default(Target target2) {
            this.target = target2;
        }

        public static void apply(AnnotationVisitor annotationVisitor, TypeDescription typeDescription, @MaybeNull String str, Object obj) {
            if (typeDescription.isArray()) {
                AnnotationVisitor visitArray = annotationVisitor.visitArray(str);
                int length = Array.getLength(obj);
                TypeDescription componentType = typeDescription.getComponentType();
                for (int i10 = 0; i10 < length; i10++) {
                    apply(visitArray, componentType, AnnotationAppender.NO_NAME, Array.get(obj, i10));
                }
                visitArray.visitEnd();
            } else if (typeDescription.isAnnotation()) {
                handle(annotationVisitor.visitAnnotation(str, typeDescription.getDescriptor()), (AnnotationDescription) obj, AnnotationValueFilter.Default.APPEND_DEFAULTS);
            } else if (typeDescription.isEnum()) {
                annotationVisitor.visitEnum(str, typeDescription.getDescriptor(), ((EnumerationDescription) obj).getValue());
            } else if (typeDescription.represents(Class.class)) {
                annotationVisitor.visit(str, Type.getType(((TypeDescription) obj).getDescriptor()));
            } else {
                annotationVisitor.visit(str, obj);
            }
        }

        private void doAppend(AnnotationDescription annotationDescription, boolean z10, AnnotationValueFilter annotationValueFilter) {
            AnnotationVisitor visit = this.target.visit(annotationDescription.getAnnotationType().getDescriptor(), z10);
            if (visit != null) {
                handle(visit, annotationDescription, annotationValueFilter);
            }
        }

        private static void handle(AnnotationVisitor annotationVisitor, AnnotationDescription annotationDescription, AnnotationValueFilter annotationValueFilter) {
            for (MethodDescription.InDefinedShape inDefinedShape : annotationDescription.getAnnotationType().getDeclaredMethods()) {
                if (annotationValueFilter.isRelevant(annotationDescription, inDefinedShape)) {
                    apply(annotationVisitor, inDefinedShape.getReturnType().asErasure(), inDefinedShape.getName(), annotationDescription.getValue(inDefinedShape).resolve());
                }
            }
            annotationVisitor.visitEnd();
        }

        public AnnotationAppender append(AnnotationDescription annotationDescription, AnnotationValueFilter annotationValueFilter) {
            int i10 = AnonymousClass1.$SwitchMap$java$lang$annotation$RetentionPolicy[annotationDescription.getRetention().ordinal()];
            if (i10 == 1) {
                doAppend(annotationDescription, true, annotationValueFilter);
            } else if (i10 == 2) {
                doAppend(annotationDescription, false, annotationValueFilter);
            } else if (i10 != 3) {
                throw new IllegalStateException("Unexpected retention policy: " + annotationDescription.getRetention());
            }
            return this;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.target.equals(((Default) obj).target);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.target.hashCode();
        }

        private void doAppend(AnnotationDescription annotationDescription, boolean z10, AnnotationValueFilter annotationValueFilter, int i10, String str) {
            AnnotationVisitor visit = this.target.visit(annotationDescription.getAnnotationType().getDescriptor(), z10, i10, str);
            if (visit != null) {
                handle(visit, annotationDescription, annotationValueFilter);
            }
        }

        public AnnotationAppender append(AnnotationDescription annotationDescription, AnnotationValueFilter annotationValueFilter, int i10, String str) {
            int i11 = AnonymousClass1.$SwitchMap$java$lang$annotation$RetentionPolicy[annotationDescription.getRetention().ordinal()];
            if (i11 == 1) {
                doAppend(annotationDescription, true, annotationValueFilter, i10, str);
            } else if (i11 == 2) {
                doAppend(annotationDescription, false, annotationValueFilter, i10, str);
            } else if (i11 != 3) {
                throw new IllegalStateException("Unexpected retention policy: " + annotationDescription.getRetention());
            }
            return this;
        }
    }
}
