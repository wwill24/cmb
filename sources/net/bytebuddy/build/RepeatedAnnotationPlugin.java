package net.bytebuddy.build;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class RepeatedAnnotationPlugin extends Plugin.ForElementMatcher {
    private static final MethodDescription.InDefinedShape VALUE = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Enhance.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly());

    @Documented
    @Target({ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enhance {
        Class<? extends Annotation> value();
    }

    @HashCodeAndEqualsPlugin.Enhance
    protected static class RepeatedAnnotationAppender implements TypeAttributeAppender {
        private final TypeDescription target;

        protected RepeatedAnnotationAppender(TypeDescription typeDescription) {
            this.target = typeDescription;
        }

        public void apply(ClassVisitor classVisitor, TypeDescription typeDescription, AnnotationValueFilter annotationValueFilter) {
            AnnotationVisitor visitAnnotation = classVisitor.visitAnnotation("Ljava/lang/annotation/Repeatable;", true);
            if (visitAnnotation != null) {
                visitAnnotation.visit("value", Type.getType(this.target.getDescriptor()));
                visitAnnotation.visitEnd();
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.target.equals(((RepeatedAnnotationAppender) obj).target);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.target.hashCode();
        }
    }

    public RepeatedAnnotationPlugin() {
        super(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class));
    }

    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        TypeDescription typeDescription2 = (TypeDescription) typeDescription.getDeclaredAnnotations().ofType(Enhance.class).getValue(VALUE).resolve(TypeDescription.class);
        if (!typeDescription2.isAnnotation()) {
            throw new IllegalStateException("Expected " + typeDescription2 + " to be an annotation type");
        } else if (typeDescription2.getDeclaredMethods().size() == 1 && ((MethodList) typeDescription2.getDeclaredMethods().filter(ElementMatchers.named("value"))).size() == 1 && ((MethodDescription.InDefinedShape) ((MethodList) typeDescription2.getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly()).getReturnType().isArray() && ((MethodDescription.InDefinedShape) ((MethodList) typeDescription2.getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly()).getReturnType().getComponentType().asErasure().equals(typeDescription)) {
            return builder.attribute(new RepeatedAnnotationAppender(typeDescription2));
        } else {
            throw new IllegalStateException("Expected " + typeDescription2 + " to declare exactly one property named value of an array type");
        }
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
        return obj != null && getClass() == obj.getClass();
    }

    public int hashCode() {
        return super.hashCode();
    }
}
