package net.bytebuddy.build;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.ToStringMethod;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class ToStringPlugin implements Plugin, Plugin.Factory {
    private static final MethodDescription.InDefinedShape ENHANCE_INCLUDE_SYNTHETIC_FIELDS;
    private static final MethodDescription.InDefinedShape ENHANCE_PREFIX;

    @Documented
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enhance {

        public enum Prefix {
            FULLY_QUALIFIED(ToStringMethod.PrefixResolver.Default.FULLY_QUALIFIED_CLASS_NAME),
            CANONICAL(ToStringMethod.PrefixResolver.Default.CANONICAL_CLASS_NAME),
            SIMPLE(ToStringMethod.PrefixResolver.Default.SIMPLE_CLASS_NAME);
            
            private final ToStringMethod.PrefixResolver.Default prefixResolver;

            private Prefix(ToStringMethod.PrefixResolver.Default defaultR) {
                this.prefixResolver = defaultR;
            }

            /* access modifiers changed from: protected */
            public ToStringMethod.PrefixResolver.Default getPrefixResolver() {
                return this.prefixResolver;
            }
        }

        boolean includeSyntheticFields() default false;

        Prefix prefix() default Prefix.SIMPLE;
    }

    @Documented
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Exclude {
    }

    static {
        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Enhance.class).getDeclaredMethods();
        ENHANCE_PREFIX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("prefix"))).getOnly();
        ENHANCE_INCLUDE_SYNTHETIC_FIELDS = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("includeSyntheticFields"))).getOnly();
    }

    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        ElementMatcher.Junction junction;
        AnnotationDescription.Loadable<Enhance> ofType = typeDescription.getDeclaredAnnotations().ofType(Enhance.class);
        if (!((MethodList) typeDescription.getDeclaredMethods().filter(ElementMatchers.isToString())).isEmpty()) {
            return builder;
        }
        DynamicType.Builder.MethodDefinition.ImplementationDefinition<?> method = builder.method(ElementMatchers.isToString());
        ToStringMethod prefixedBy = ToStringMethod.prefixedBy((ToStringMethod.PrefixResolver) ((Enhance.Prefix) ofType.getValue(ENHANCE_PREFIX).load(Enhance.class.getClassLoader()).resolve(Enhance.Prefix.class)).getPrefixResolver());
        if (((Boolean) ofType.getValue(ENHANCE_INCLUDE_SYNTHETIC_FIELDS).resolve(Boolean.class)).booleanValue()) {
            junction = ElementMatchers.none();
        } else {
            junction = ElementMatchers.isSynthetic();
        }
        return method.intercept(prefixedBy.withIgnoredFields(junction).withIgnoredFields(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Exclude.class)));
    }

    public void close() {
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

    public Plugin make() {
        return this;
    }

    public boolean matches(@MaybeNull TypeDescription typeDescription) {
        return typeDescription != null && typeDescription.getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Enhance.class);
    }
}
