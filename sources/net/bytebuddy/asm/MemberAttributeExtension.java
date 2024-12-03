package net.bytebuddy.asm;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public abstract class MemberAttributeExtension<T> {
    protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
    protected final T attributeAppenderFactory;

    public static class ForField extends MemberAttributeExtension<FieldAttributeAppender.Factory> implements AsmVisitorWrapper.ForDeclaredFields.FieldVisitorWrapper {

        private static class FieldAttributeVisitor extends FieldVisitor {
            private final AnnotationValueFilter annotationValueFilter;
            private final FieldAttributeAppender fieldAttributeAppender;
            private final FieldDescription fieldDescription;

            public void visitEnd() {
                this.fieldAttributeAppender.apply(this.fv, this.fieldDescription, this.annotationValueFilter);
                super.visitEnd();
            }

            private FieldAttributeVisitor(FieldVisitor fieldVisitor, FieldDescription fieldDescription2, FieldAttributeAppender fieldAttributeAppender2, AnnotationValueFilter annotationValueFilter2) {
                super(OpenedClassReader.ASM_API, fieldVisitor);
                this.fieldDescription = fieldDescription2;
                this.fieldAttributeAppender = fieldAttributeAppender2;
                this.annotationValueFilter = annotationValueFilter2;
            }
        }

        public ForField() {
            this(AnnotationValueFilter.Default.APPEND_DEFAULTS);
        }

        public ForField annotate(Annotation... annotationArr) {
            return annotate((List<? extends Annotation>) Arrays.asList(annotationArr));
        }

        public ForField attribute(FieldAttributeAppender.Factory factory) {
            return new ForField(this.annotationValueFilterFactory, new FieldAttributeAppender.Factory.Compound((FieldAttributeAppender.Factory) this.attributeAppenderFactory, factory));
        }

        public AsmVisitorWrapper on(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
            return new AsmVisitorWrapper.ForDeclaredFields().field(elementMatcher, this);
        }

        public FieldVisitor wrap(TypeDescription typeDescription, FieldDescription.InDefinedShape inDefinedShape, FieldVisitor fieldVisitor) {
            return new FieldAttributeVisitor(fieldVisitor, inDefinedShape, ((FieldAttributeAppender.Factory) this.attributeAppenderFactory).make(typeDescription), this.annotationValueFilterFactory.on((FieldDescription) inDefinedShape));
        }

        public ForField(AnnotationValueFilter.Factory factory) {
            this(factory, FieldAttributeAppender.NoOp.INSTANCE);
        }

        public ForField annotate(List<? extends Annotation> list) {
            return annotate((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
        }

        protected ForField(AnnotationValueFilter.Factory factory, FieldAttributeAppender.Factory factory2) {
            super(factory, factory2);
        }

        public ForField annotate(AnnotationDescription... annotationDescriptionArr) {
            return annotate((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
        }

        public ForField annotate(Collection<? extends AnnotationDescription> collection) {
            return attribute(new FieldAttributeAppender.Explicit(new ArrayList(collection)));
        }
    }

    public static class ForMethod extends MemberAttributeExtension<MethodAttributeAppender.Factory> implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {

        private static class AttributeAppendingMethodVisitor extends MethodVisitor {
            private final AnnotationValueFilter annotationValueFilter;
            private boolean applicable;
            private final MethodAttributeAppender methodAttributeAppender;
            private final MethodDescription methodDescription;

            public void visitCode() {
                if (this.applicable) {
                    this.methodAttributeAppender.apply(this.mv, this.methodDescription, this.annotationValueFilter);
                    this.applicable = false;
                }
                super.visitCode();
            }

            public void visitEnd() {
                if (this.applicable) {
                    this.methodAttributeAppender.apply(this.mv, this.methodDescription, this.annotationValueFilter);
                    this.applicable = false;
                }
                super.visitEnd();
            }

            private AttributeAppendingMethodVisitor(MethodVisitor methodVisitor, MethodDescription methodDescription2, MethodAttributeAppender methodAttributeAppender2, AnnotationValueFilter annotationValueFilter2) {
                super(OpenedClassReader.ASM_API, methodVisitor);
                this.methodDescription = methodDescription2;
                this.methodAttributeAppender = methodAttributeAppender2;
                this.annotationValueFilter = annotationValueFilter2;
                this.applicable = true;
            }
        }

        public ForMethod() {
            this(AnnotationValueFilter.Default.APPEND_DEFAULTS);
        }

        public ForMethod annotateMethod(Annotation... annotationArr) {
            return annotateMethod((List<? extends Annotation>) Arrays.asList(annotationArr));
        }

        public ForMethod annotateParameter(int i10, Annotation... annotationArr) {
            return annotateParameter(i10, (List<? extends Annotation>) Arrays.asList(annotationArr));
        }

        public ForMethod attribute(MethodAttributeAppender.Factory factory) {
            return new ForMethod(this.annotationValueFilterFactory, new MethodAttributeAppender.Factory.Compound((MethodAttributeAppender.Factory) this.attributeAppenderFactory, factory));
        }

        public AsmVisitorWrapper on(ElementMatcher<? super MethodDescription> elementMatcher) {
            return new AsmVisitorWrapper.ForDeclaredMethods().invokable(elementMatcher, this);
        }

        public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i10, int i11) {
            return new AttributeAppendingMethodVisitor(methodVisitor, methodDescription, ((MethodAttributeAppender.Factory) this.attributeAppenderFactory).make(typeDescription), this.annotationValueFilterFactory.on(methodDescription));
        }

        public ForMethod(AnnotationValueFilter.Factory factory) {
            this(factory, MethodAttributeAppender.NoOp.INSTANCE);
        }

        public ForMethod annotateMethod(List<? extends Annotation> list) {
            return annotateMethod((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
        }

        public ForMethod annotateParameter(int i10, List<? extends Annotation> list) {
            return annotateParameter(i10, (Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
        }

        protected ForMethod(AnnotationValueFilter.Factory factory, MethodAttributeAppender.Factory factory2) {
            super(factory, factory2);
        }

        public ForMethod annotateMethod(AnnotationDescription... annotationDescriptionArr) {
            return annotateMethod((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
        }

        public ForMethod annotateParameter(int i10, AnnotationDescription... annotationDescriptionArr) {
            return annotateParameter(i10, (Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
        }

        public ForMethod annotateMethod(Collection<? extends AnnotationDescription> collection) {
            return attribute(new MethodAttributeAppender.Explicit(new ArrayList(collection)));
        }

        public ForMethod annotateParameter(int i10, Collection<? extends AnnotationDescription> collection) {
            if (i10 >= 0) {
                return attribute(new MethodAttributeAppender.Explicit(i10, (List<? extends AnnotationDescription>) new ArrayList(collection)));
            }
            throw new IllegalArgumentException("Parameter index cannot be negative: " + i10);
        }
    }

    protected MemberAttributeExtension(AnnotationValueFilter.Factory factory, T t10) {
        this.annotationValueFilterFactory = factory;
        this.attributeAppenderFactory = t10;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MemberAttributeExtension memberAttributeExtension = (MemberAttributeExtension) obj;
        return this.annotationValueFilterFactory.equals(memberAttributeExtension.annotationValueFilterFactory) && this.attributeAppenderFactory.equals(memberAttributeExtension.attributeAppenderFactory);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.annotationValueFilterFactory.hashCode()) * 31) + this.attributeAppenderFactory.hashCode();
    }
}
