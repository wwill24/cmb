package net.bytebuddy.build;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.modifier.FieldPersistence;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.SyntheticState;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class CachedReturnPlugin extends Plugin.ForElementMatcher implements Plugin.Factory {
    private static final String ADVICE_INFIX = "$Advice$";
    private static final MethodDescription.InDefinedShape ENHANCE_VALUE = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Enhance.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly());
    private static final String NAME_INFIX = "_";
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
    private final Map<TypeDescription, TypeDescription> adviceByType;
    private final ClassFileLocator classFileLocator;
    private final boolean ignoreExistingFields;
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
    private final RandomString randomString;

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface CacheField {
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class CacheFieldOffsetMapping implements Advice.OffsetMapping {
        private final String name;

        protected CacheFieldOffsetMapping(String str) {
            this.name = str;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.name.equals(((CacheFieldOffsetMapping) obj).name);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.name.hashCode();
        }

        public Advice.OffsetMapping.Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Advice.ArgumentHandler argumentHandler, Advice.OffsetMapping.Sort sort) {
            return new Advice.OffsetMapping.Target.ForField.ReadWrite((FieldDescription) ((FieldList) typeDescription.getDeclaredFields().filter(ElementMatchers.named(this.name))).getOnly());
        }
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enhance {
        String value() default "";
    }

    public CachedReturnPlugin() {
        this(false);
    }

    @SuppressFBWarnings(justification = "Annotation presence is required by matcher.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator2) {
        Ownership ownership;
        FieldPersistence fieldPersistence;
        TypeDescription typeDescription2;
        DynamicType.Builder<T> builder2 = builder;
        for (MethodDescription.InDefinedShape inDefinedShape : (MethodList) typeDescription.getDeclaredMethods().filter(ElementMatchers.not(ElementMatchers.isBridge()).and(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class)))) {
            if (inDefinedShape.isAbstract()) {
                throw new IllegalStateException("Cannot cache the value of an abstract method: " + inDefinedShape);
            } else if (!inDefinedShape.getParameters().isEmpty()) {
                throw new IllegalStateException("Cannot cache the value of a method with parameters: " + inDefinedShape);
            } else if (!inDefinedShape.getReturnType().represents(Void.TYPE)) {
                String str = (String) inDefinedShape.getDeclaredAnnotations().ofType(Enhance.class).getValue(ENHANCE_VALUE).resolve(String.class);
                if (str.length() == 0) {
                    str = inDefinedShape.getName() + "_" + this.randomString.nextString();
                } else if (this.ignoreExistingFields && !((FieldList) typeDescription.getDeclaredFields().filter(ElementMatchers.named(str))).isEmpty()) {
                    return builder2;
                }
                TypeDescription asErasure = inDefinedShape.getReturnType().asErasure();
                ModifierContributor.ForField[] forFieldArr = new ModifierContributor.ForField[4];
                if (inDefinedShape.isStatic()) {
                    ownership = Ownership.STATIC;
                } else {
                    ownership = Ownership.MEMBER;
                }
                forFieldArr[0] = ownership;
                if (inDefinedShape.isStatic()) {
                    fieldPersistence = FieldPersistence.PLAIN;
                } else {
                    fieldPersistence = FieldPersistence.TRANSIENT;
                }
                forFieldArr[1] = fieldPersistence;
                forFieldArr[2] = Visibility.PRIVATE;
                forFieldArr[3] = SyntheticState.SYNTHETIC;
                DynamicType.Builder.FieldDefinition.Optional.Valuable<?> defineField = builder2.defineField(str, (TypeDefinition) asErasure, forFieldArr);
                Advice.WithCustomMapping bind = Advice.withCustomMapping().bind(CacheField.class, (Advice.OffsetMapping) new CacheFieldOffsetMapping(str));
                Map<TypeDescription, TypeDescription> map = this.adviceByType;
                if (inDefinedShape.getReturnType().isPrimitive()) {
                    typeDescription2 = inDefinedShape.getReturnType().asErasure();
                } else {
                    typeDescription2 = TypeDescription.ForLoadedType.of(Object.class);
                }
                builder2 = defineField.visit(bind.to(map.get(typeDescription2), this.classFileLocator).on(ElementMatchers.is(inDefinedShape)));
            } else {
                throw new IllegalStateException("Cannot cache void result for " + inDefinedShape);
            }
        }
        return builder2;
    }

    public void close() {
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CachedReturnPlugin cachedReturnPlugin = (CachedReturnPlugin) obj;
        return this.ignoreExistingFields == cachedReturnPlugin.ignoreExistingFields && this.classFileLocator.equals(cachedReturnPlugin.classFileLocator);
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + (this.ignoreExistingFields ? 1 : 0)) * 31) + this.classFileLocator.hashCode();
    }

    public Plugin make() {
        return this;
    }

    public CachedReturnPlugin(boolean z10) {
        super(ElementMatchers.declaresMethod(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class)));
        this.ignoreExistingFields = z10;
        this.randomString = new RandomString();
        ClassFileLocator of2 = ClassFileLocator.ForClassLoader.of(CachedReturnPlugin.class.getClassLoader());
        this.classFileLocator = of2;
        TypePool of3 = TypePool.Default.of(of2);
        this.adviceByType = new HashMap();
        Class[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Object.class};
        for (int i10 = 0; i10 < 9; i10++) {
            Class cls = clsArr[i10];
            Map<TypeDescription, TypeDescription> map = this.adviceByType;
            TypeDescription of4 = TypeDescription.ForLoadedType.of(cls);
            map.put(of4, of3.describe(CachedReturnPlugin.class.getName() + ADVICE_INFIX + cls.getSimpleName()).resolve());
        }
    }
}
