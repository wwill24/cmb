package net.bytebuddy.build;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Comparator;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.EqualsMethod;
import net.bytebuddy.implementation.HashCodeMethod;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

@Enhance
public class HashCodeAndEqualsPlugin implements Plugin, Plugin.Factory, MethodAttributeAppender.Factory, MethodAttributeAppender {
    private static final MethodDescription.InDefinedShape ENHANCE_INCLUDE_SYNTHETIC_FIELDS;
    private static final MethodDescription.InDefinedShape ENHANCE_INVOKE_SUPER;
    private static final MethodDescription.InDefinedShape ENHANCE_PERMIT_SUBCLASS_EQUALITY;
    private static final MethodDescription.InDefinedShape ENHANCE_SIMPLE_COMPARISON_FIRST;
    private static final MethodDescription.InDefinedShape ENHANCE_USE_TYPE_HASH_CONSTANT;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape SORTED_VALUE = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Sorted.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly());
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape VALUE_HANDLING_VALUE = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(ValueHandling.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly());
    @ValueHandling(ValueHandling.Sort.REVERSE_NULLABILITY)
    @MaybeNull
    private final String annotationType;

    protected enum AnnotationOrderComparator implements Comparator<FieldDescription.InDefinedShape> {
        INSTANCE;

        public int compare(FieldDescription.InDefinedShape inDefinedShape, FieldDescription.InDefinedShape inDefinedShape2) {
            int i10;
            int i11;
            Class<Integer> cls = Integer.class;
            AnnotationDescription.Loadable<Sorted> ofType = inDefinedShape.getDeclaredAnnotations().ofType(Sorted.class);
            AnnotationDescription.Loadable<Sorted> ofType2 = inDefinedShape2.getDeclaredAnnotations().ofType(Sorted.class);
            if (ofType == null) {
                i10 = 0;
            } else {
                i10 = ((Integer) ofType.getValue(HashCodeAndEqualsPlugin.SORTED_VALUE).resolve(cls)).intValue();
            }
            if (ofType2 == null) {
                i11 = 0;
            } else {
                i11 = ((Integer) ofType2.getValue(HashCodeAndEqualsPlugin.SORTED_VALUE).resolve(cls)).intValue();
            }
            if (i10 > i11) {
                return -1;
            }
            if (i10 < i11) {
                return 1;
            }
            return 0;
        }
    }

    @Documented
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enhance {

        public enum InvokeSuper {
            IF_DECLARED {
                /* access modifiers changed from: protected */
                public EqualsMethod equalsMethod(TypeDescription typeDescription) {
                    TypeDescription.Generic superClass = typeDescription.getSuperClass();
                    while (superClass != null && !superClass.represents(Object.class)) {
                        if (superClass.asErasure().getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Enhance.class)) {
                            return EqualsMethod.requiringSuperClassEquality();
                        }
                        MethodList methodList = (MethodList) superClass.getDeclaredMethods().filter(ElementMatchers.isHashCode());
                        if (methodList.isEmpty()) {
                            superClass = superClass.getSuperClass();
                        } else if (((MethodDescription) methodList.getOnly()).isAbstract()) {
                            return EqualsMethod.isolated();
                        } else {
                            return EqualsMethod.requiringSuperClassEquality();
                        }
                    }
                    return EqualsMethod.isolated();
                }

                /* access modifiers changed from: protected */
                public HashCodeMethod hashCodeMethod(TypeDescription typeDescription, boolean z10, boolean z11) {
                    TypeDescription.Generic superClass = typeDescription.getSuperClass();
                    while (superClass != null && !superClass.represents(Object.class)) {
                        if (superClass.asErasure().getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Enhance.class)) {
                            return HashCodeMethod.usingSuperClassOffset();
                        }
                        MethodList methodList = (MethodList) superClass.getDeclaredMethods().filter(ElementMatchers.isHashCode());
                        if (methodList.isEmpty()) {
                            superClass = superClass.getSuperClass();
                        } else if (!((MethodDescription) methodList.getOnly()).isAbstract()) {
                            return HashCodeMethod.usingSuperClassOffset();
                        } else {
                            if (z10) {
                                return HashCodeMethod.usingTypeHashOffset(!z11);
                            }
                            return HashCodeMethod.usingDefaultOffset();
                        }
                    }
                    if (z10) {
                        return HashCodeMethod.usingTypeHashOffset(!z11);
                    }
                    return HashCodeMethod.usingDefaultOffset();
                }
            },
            IF_ANNOTATED {
                /* access modifiers changed from: protected */
                public EqualsMethod equalsMethod(TypeDescription typeDescription) {
                    TypeDescription.Generic superClass = typeDescription.getSuperClass();
                    if (superClass == null || !superClass.asErasure().getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Enhance.class)) {
                        return EqualsMethod.isolated();
                    }
                    return EqualsMethod.requiringSuperClassEquality();
                }

                /* access modifiers changed from: protected */
                public HashCodeMethod hashCodeMethod(TypeDescription typeDescription, boolean z10, boolean z11) {
                    TypeDescription.Generic superClass = typeDescription.getSuperClass();
                    if (superClass != null && superClass.asErasure().getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Enhance.class)) {
                        return HashCodeMethod.usingSuperClassOffset();
                    }
                    if (z10) {
                        return HashCodeMethod.usingTypeHashOffset(!z11);
                    }
                    return HashCodeMethod.usingDefaultOffset();
                }
            },
            ALWAYS {
                /* access modifiers changed from: protected */
                public EqualsMethod equalsMethod(TypeDescription typeDescription) {
                    return EqualsMethod.requiringSuperClassEquality();
                }

                /* access modifiers changed from: protected */
                public HashCodeMethod hashCodeMethod(TypeDescription typeDescription, boolean z10, boolean z11) {
                    return HashCodeMethod.usingSuperClassOffset();
                }
            },
            NEVER {
                /* access modifiers changed from: protected */
                public EqualsMethod equalsMethod(TypeDescription typeDescription) {
                    return EqualsMethod.isolated();
                }

                /* access modifiers changed from: protected */
                public HashCodeMethod hashCodeMethod(TypeDescription typeDescription, boolean z10, boolean z11) {
                    return z10 ? HashCodeMethod.usingTypeHashOffset(!z11) : HashCodeMethod.usingDefaultOffset();
                }
            };

            /* access modifiers changed from: protected */
            public abstract EqualsMethod equalsMethod(TypeDescription typeDescription);

            /* access modifiers changed from: protected */
            public abstract HashCodeMethod hashCodeMethod(TypeDescription typeDescription, boolean z10, boolean z11);
        }

        boolean includeSyntheticFields() default false;

        InvokeSuper invokeSuper() default InvokeSuper.IF_DECLARED;

        boolean permitSubclassEquality() default false;

        boolean simpleComparisonsFirst() default true;

        boolean useTypeHashConstant() default true;
    }

    @Documented
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Sorted {
        public static final int DEFAULT = 0;

        int value();
    }

    @Documented
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValueHandling {

        public enum Sort {
            IGNORE,
            REVERSE_NULLABILITY
        }

        Sort value();
    }

    @Enhance
    protected static class ValueMatcher extends ElementMatcher.Junction.ForNonNullValues<FieldDescription> {
        private final ValueHandling.Sort sort;

        protected ValueMatcher(ValueHandling.Sort sort2) {
            this.sort = sort2;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.sort.equals(((ValueMatcher) obj).sort);
        }

        public int hashCode() {
            return (super.hashCode() * 31) + this.sort.hashCode();
        }

        /* access modifiers changed from: protected */
        public boolean doMatch(FieldDescription fieldDescription) {
            AnnotationDescription.Loadable<ValueHandling> ofType = fieldDescription.getDeclaredAnnotations().ofType(ValueHandling.class);
            return ofType != null && ofType.getValue(HashCodeAndEqualsPlugin.VALUE_HANDLING_VALUE).load(ValueHandling.class.getClassLoader()).resolve(ValueHandling.Sort.class) == this.sort;
        }
    }

    @Enhance
    public static class WithNonNullableFields extends HashCodeAndEqualsPlugin {
        public WithNonNullableFields() {
            this((String) null);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (!HashCodeAndEqualsPlugin.super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return HashCodeAndEqualsPlugin.super.hashCode();
        }

        public /* bridge */ /* synthetic */ boolean matches(@MaybeNull Object obj) {
            return HashCodeAndEqualsPlugin.super.matches((TypeDescription) obj);
        }

        /* access modifiers changed from: protected */
        public ElementMatcher<FieldDescription> nonNullable(ElementMatcher<FieldDescription> elementMatcher) {
            return ElementMatchers.not(elementMatcher);
        }

        public WithNonNullableFields(@MaybeNull String str) {
            super(str);
        }
    }

    static {
        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Enhance.class).getDeclaredMethods();
        ENHANCE_INVOKE_SUPER = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("invokeSuper"))).getOnly();
        ENHANCE_SIMPLE_COMPARISON_FIRST = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("simpleComparisonsFirst"))).getOnly();
        ENHANCE_INCLUDE_SYNTHETIC_FIELDS = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("includeSyntheticFields"))).getOnly();
        ENHANCE_PERMIT_SUBCLASS_EQUALITY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("permitSubclassEquality"))).getOnly();
        ENHANCE_USE_TYPE_HASH_CONSTANT = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("useTypeHashConstant"))).getOnly();
    }

    public HashCodeAndEqualsPlugin() {
        this((String) null);
    }

    @SuppressFBWarnings(justification = "Annotation presence is required by matcher.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        ElementMatcher.Junction junction;
        ElementMatcher.Junction junction2;
        Class<Enhance.InvokeSuper> cls = Enhance.InvokeSuper.class;
        Class<Boolean> cls2 = Boolean.class;
        AnnotationDescription.Loadable<Enhance> ofType = typeDescription.getDeclaredAnnotations().ofType(Enhance.class);
        DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<?> receiverTypeDefinition = builder;
        if (((MethodList) typeDescription.getDeclaredMethods().filter(ElementMatchers.isHashCode())).isEmpty()) {
            DynamicType.Builder.MethodDefinition.ImplementationDefinition<?> method = builder.method(ElementMatchers.isHashCode());
            HashCodeMethod hashCodeMethod = ((Enhance.InvokeSuper) ofType.getValue(ENHANCE_INVOKE_SUPER).load(Enhance.class.getClassLoader()).resolve(cls)).hashCodeMethod(typeDescription, ((Boolean) ofType.getValue(ENHANCE_USE_TYPE_HASH_CONSTANT).resolve(cls2)).booleanValue(), ((Boolean) ofType.getValue(ENHANCE_PERMIT_SUBCLASS_EQUALITY).resolve(cls2)).booleanValue());
            if (((Boolean) ofType.getValue(ENHANCE_INCLUDE_SYNTHETIC_FIELDS).resolve(cls2)).booleanValue()) {
                junction2 = ElementMatchers.none();
            } else {
                junction2 = ElementMatchers.isSynthetic();
            }
            receiverTypeDefinition = method.intercept(hashCodeMethod.withIgnoredFields(junction2).withIgnoredFields(new ValueMatcher(ValueHandling.Sort.IGNORE)).withNonNullableFields(nonNullable(new ValueMatcher(ValueHandling.Sort.REVERSE_NULLABILITY))));
        }
        if (!((MethodList) typeDescription.getDeclaredMethods().filter(ElementMatchers.isEquals())).isEmpty()) {
            return receiverTypeDefinition;
        }
        EqualsMethod equalsMethod = ((Enhance.InvokeSuper) ofType.getValue(ENHANCE_INVOKE_SUPER).load(Enhance.class.getClassLoader()).resolve(cls)).equalsMethod(typeDescription);
        if (((Boolean) ofType.getValue(ENHANCE_INCLUDE_SYNTHETIC_FIELDS).resolve(cls2)).booleanValue()) {
            junction = ElementMatchers.none();
        } else {
            junction = ElementMatchers.isSynthetic();
        }
        EqualsMethod withFieldOrder = equalsMethod.withIgnoredFields(junction).withIgnoredFields(new ValueMatcher(ValueHandling.Sort.IGNORE)).withNonNullableFields(nonNullable(new ValueMatcher(ValueHandling.Sort.REVERSE_NULLABILITY))).withFieldOrder(AnnotationOrderComparator.INSTANCE);
        EqualsMethod equalsMethod2 = withFieldOrder;
        if (((Boolean) ofType.getValue(ENHANCE_SIMPLE_COMPARISON_FIRST).resolve(cls2)).booleanValue()) {
            equalsMethod2 = withFieldOrder.withPrimitiveTypedFieldsFirst().withEnumerationTypedFieldsFirst().withPrimitiveWrapperTypedFieldsFirst().withStringTypedFieldsFirst();
        }
        DynamicType.Builder.MethodDefinition.ImplementationDefinition<T> method2 = receiverTypeDefinition.method(ElementMatchers.isEquals());
        Implementation implementation = equalsMethod2;
        if (((Boolean) ofType.getValue(ENHANCE_PERMIT_SUBCLASS_EQUALITY).resolve(cls2)).booleanValue()) {
            implementation = equalsMethod2.withSubclassEquality();
        }
        return method2.intercept(implementation).attribute(this);
    }

    public void close() {
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
            java.lang.String r2 = r4.annotationType
            net.bytebuddy.build.HashCodeAndEqualsPlugin r5 = (net.bytebuddy.build.HashCodeAndEqualsPlugin) r5
            java.lang.String r5 = r5.annotationType
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
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.build.HashCodeAndEqualsPlugin.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = getClass().hashCode() * 31;
        String str = this.annotationType;
        return str != null ? hashCode + str.hashCode() : hashCode;
    }

    public Plugin make() {
        return this;
    }

    public MethodAttributeAppender make(TypeDescription typeDescription) {
        return this;
    }

    /* access modifiers changed from: protected */
    public ElementMatcher<FieldDescription> nonNullable(ElementMatcher<FieldDescription> elementMatcher) {
        return elementMatcher;
    }

    public HashCodeAndEqualsPlugin(@MaybeNull String str) {
        this.annotationType = str;
    }

    public boolean matches(@MaybeNull TypeDescription typeDescription) {
        return typeDescription != null && typeDescription.getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Enhance.class);
    }

    public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
        if (this.annotationType != null) {
            AnnotationVisitor visitParameterAnnotation = methodVisitor.visitParameterAnnotation(0, "L" + this.annotationType.replace('.', '/') + ";", true);
            if (visitParameterAnnotation != null) {
                visitParameterAnnotation.visitEnd();
            }
        }
    }
}
