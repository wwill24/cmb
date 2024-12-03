package net.bytebuddy.implementation.attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.attribute.AnnotationAppender;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface MethodAttributeAppender {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements MethodAttributeAppender {
        private final List<MethodAttributeAppender> methodAttributeAppenders;

        public Compound(MethodAttributeAppender... methodAttributeAppenderArr) {
            this((List<? extends MethodAttributeAppender>) Arrays.asList(methodAttributeAppenderArr));
        }

        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            for (MethodAttributeAppender apply : this.methodAttributeAppenders) {
                apply.apply(methodVisitor, methodDescription, annotationValueFilter);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.methodAttributeAppenders.equals(((Compound) obj).methodAttributeAppenders);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.methodAttributeAppenders.hashCode();
        }

        public Compound(List<? extends MethodAttributeAppender> list) {
            this.methodAttributeAppenders = new ArrayList();
            for (MethodAttributeAppender methodAttributeAppender : list) {
                if (methodAttributeAppender instanceof Compound) {
                    this.methodAttributeAppenders.addAll(((Compound) methodAttributeAppender).methodAttributeAppenders);
                } else if (!(methodAttributeAppender instanceof NoOp)) {
                    this.methodAttributeAppenders.add(methodAttributeAppender);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Explicit implements MethodAttributeAppender, Factory {
        private final List<? extends AnnotationDescription> annotations;
        private final Target target;

        protected interface Target {

            public enum OnMethod implements Target {
                INSTANCE;

                public AnnotationAppender.Target make(MethodVisitor methodVisitor, MethodDescription methodDescription) {
                    return new AnnotationAppender.Target.OnMethod(methodVisitor);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OnMethodParameter implements Target {
                private final int parameterIndex;

                protected OnMethodParameter(int i10) {
                    this.parameterIndex = i10;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.parameterIndex == ((OnMethodParameter) obj).parameterIndex;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.parameterIndex;
                }

                public AnnotationAppender.Target make(MethodVisitor methodVisitor, MethodDescription methodDescription) {
                    if (this.parameterIndex < methodDescription.getParameters().size()) {
                        return new AnnotationAppender.Target.OnMethodParameter(methodVisitor, this.parameterIndex);
                    }
                    throw new IllegalArgumentException("Method " + methodDescription + " has less then " + this.parameterIndex + " parameters");
                }
            }

            AnnotationAppender.Target make(MethodVisitor methodVisitor, MethodDescription methodDescription);
        }

        public Explicit(int i10, List<? extends AnnotationDescription> list) {
            this((Target) new Target.OnMethodParameter(i10), list);
        }

        public static Factory of(MethodDescription methodDescription) {
            return new Factory.Compound(ofMethodAnnotations(methodDescription), ofParameterAnnotations(methodDescription));
        }

        public static Factory ofMethodAnnotations(MethodDescription methodDescription) {
            return new Explicit(methodDescription.getDeclaredAnnotations());
        }

        public static Factory ofParameterAnnotations(MethodDescription methodDescription) {
            ParameterList<?> parameters = methodDescription.getParameters();
            ArrayList arrayList = new ArrayList(parameters.size());
            Iterator<E> it = parameters.iterator();
            while (it.hasNext()) {
                ParameterDescription parameterDescription = (ParameterDescription) it.next();
                arrayList.add(new Explicit(parameterDescription.getIndex(), (List<? extends AnnotationDescription>) parameterDescription.getDeclaredAnnotations()));
            }
            return new Factory.Compound((List<? extends Factory>) arrayList);
        }

        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            AnnotationAppender annotationAppender = new AnnotationAppender.Default(this.target.make(methodVisitor, methodDescription));
            for (AnnotationDescription append : this.annotations) {
                annotationAppender = annotationAppender.append(append, annotationValueFilter);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Explicit explicit = (Explicit) obj;
            return this.target.equals(explicit.target) && this.annotations.equals(explicit.annotations);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.annotations.hashCode();
        }

        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }

        public Explicit(List<? extends AnnotationDescription> list) {
            this((Target) Target.OnMethod.INSTANCE, list);
        }

        protected Explicit(Target target2, List<? extends AnnotationDescription> list) {
            this.target = target2;
            this.annotations = list;
        }
    }

    public interface Factory {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements Factory {
            private final List<Factory> factories;

            public Compound(Factory... factoryArr) {
                this((List<? extends Factory>) Arrays.asList(factoryArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.factories.equals(((Compound) obj).factories);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.factories.hashCode();
            }

            public MethodAttributeAppender make(TypeDescription typeDescription) {
                ArrayList arrayList = new ArrayList(this.factories.size());
                for (Factory make : this.factories) {
                    arrayList.add(make.make(typeDescription));
                }
                return new Compound((List<? extends MethodAttributeAppender>) arrayList);
            }

            public Compound(List<? extends Factory> list) {
                this.factories = new ArrayList();
                for (Factory factory : list) {
                    if (factory instanceof Compound) {
                        this.factories.addAll(((Compound) factory).factories);
                    } else if (!(factory instanceof NoOp)) {
                        this.factories.add(factory);
                    }
                }
            }
        }

        MethodAttributeAppender make(TypeDescription typeDescription);
    }

    public enum ForInstrumentedMethod implements MethodAttributeAppender, Factory {
        EXCLUDING_RECEIVER {
            /* access modifiers changed from: protected */
            public AnnotationAppender appendReceiver(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, MethodDescription methodDescription) {
                return annotationAppender;
            }
        },
        INCLUDING_RECEIVER {
            /* access modifiers changed from: protected */
            public AnnotationAppender appendReceiver(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, MethodDescription methodDescription) {
                TypeDescription.Generic receiverType = methodDescription.getReceiverType();
                if (receiverType == null) {
                    return annotationAppender;
                }
                return (AnnotationAppender) receiverType.accept(AnnotationAppender.ForTypeAnnotations.ofReceiverType(annotationAppender, annotationValueFilter));
            }
        };

        /* access modifiers changed from: protected */
        public abstract AnnotationAppender appendReceiver(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, MethodDescription methodDescription);

        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            int i10 = 0;
            AnnotationAppender ofTypeVariable = AnnotationAppender.ForTypeAnnotations.ofTypeVariable((AnnotationAppender) methodDescription.getReturnType().accept(AnnotationAppender.ForTypeAnnotations.ofMethodReturnType(new AnnotationAppender.Default(new AnnotationAppender.Target.OnMethod(methodVisitor)), annotationValueFilter)), annotationValueFilter, false, methodDescription.getTypeVariables());
            for (AnnotationDescription append : (AnnotationList) methodDescription.getDeclaredAnnotations().filter(ElementMatchers.not(ElementMatchers.annotationType((ElementMatcher<? super TypeDescription>) ElementMatchers.nameStartsWith("jdk.internal."))))) {
                ofTypeVariable = ofTypeVariable.append(append, annotationValueFilter);
            }
            Iterator<E> it = methodDescription.getParameters().iterator();
            while (it.hasNext()) {
                ParameterDescription parameterDescription = (ParameterDescription) it.next();
                AnnotationAppender annotationAppender = (AnnotationAppender) parameterDescription.getType().accept(AnnotationAppender.ForTypeAnnotations.ofMethodParameterType(new AnnotationAppender.Default(new AnnotationAppender.Target.OnMethodParameter(methodVisitor, parameterDescription.getIndex())), annotationValueFilter, parameterDescription.getIndex()));
                for (AnnotationDescription append2 : parameterDescription.getDeclaredAnnotations()) {
                    annotationAppender = annotationAppender.append(append2, annotationValueFilter);
                }
            }
            AnnotationAppender appendReceiver = appendReceiver(ofTypeVariable, annotationValueFilter, methodDescription);
            for (TypeDescription.Generic accept : methodDescription.getExceptionTypes()) {
                appendReceiver = (AnnotationAppender) accept.accept(AnnotationAppender.ForTypeAnnotations.ofExceptionType(appendReceiver, annotationValueFilter, i10));
                i10++;
            }
        }

        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForReceiverType implements MethodAttributeAppender, Factory {
        private final TypeDescription.Generic receiverType;

        public ForReceiverType(TypeDescription.Generic generic) {
            this.receiverType = generic;
        }

        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            this.receiverType.accept(AnnotationAppender.ForTypeAnnotations.ofReceiverType(new AnnotationAppender.Default(new AnnotationAppender.Target.OnMethod(methodVisitor)), annotationValueFilter));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.receiverType.equals(((ForReceiverType) obj).receiverType);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.receiverType.hashCode();
        }

        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }
    }

    public enum NoOp implements MethodAttributeAppender, Factory {
        INSTANCE;

        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
        }

        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }
    }

    void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter);
}
