package net.bytebuddy.implementation.attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.attribute.AnnotationAppender;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface RecordComponentAttributeAppender {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements RecordComponentAttributeAppender {
        private final List<RecordComponentAttributeAppender> recordComponentAttributeAppenders;

        public Compound(RecordComponentAttributeAppender... recordComponentAttributeAppenderArr) {
            this((List<? extends RecordComponentAttributeAppender>) Arrays.asList(recordComponentAttributeAppenderArr));
        }

        public void apply(RecordComponentVisitor recordComponentVisitor, RecordComponentDescription recordComponentDescription, AnnotationValueFilter annotationValueFilter) {
            for (RecordComponentAttributeAppender apply : this.recordComponentAttributeAppenders) {
                apply.apply(recordComponentVisitor, recordComponentDescription, annotationValueFilter);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.recordComponentAttributeAppenders.equals(((Compound) obj).recordComponentAttributeAppenders);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.recordComponentAttributeAppenders.hashCode();
        }

        public Compound(List<? extends RecordComponentAttributeAppender> list) {
            this.recordComponentAttributeAppenders = new ArrayList();
            for (RecordComponentAttributeAppender recordComponentAttributeAppender : list) {
                if (recordComponentAttributeAppender instanceof Compound) {
                    this.recordComponentAttributeAppenders.addAll(((Compound) recordComponentAttributeAppender).recordComponentAttributeAppenders);
                } else if (!(recordComponentAttributeAppender instanceof NoOp)) {
                    this.recordComponentAttributeAppenders.add(recordComponentAttributeAppender);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Explicit implements RecordComponentAttributeAppender, Factory {
        private final List<? extends AnnotationDescription> annotations;

        public Explicit(List<? extends AnnotationDescription> list) {
            this.annotations = list;
        }

        public void apply(RecordComponentVisitor recordComponentVisitor, RecordComponentDescription recordComponentDescription, AnnotationValueFilter annotationValueFilter) {
            AnnotationAppender annotationAppender = new AnnotationAppender.Default(new AnnotationAppender.Target.OnRecordComponent(recordComponentVisitor));
            for (AnnotationDescription append : this.annotations) {
                annotationAppender = annotationAppender.append(append, annotationValueFilter);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.annotations.equals(((Explicit) obj).annotations);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.annotations.hashCode();
        }

        public RecordComponentAttributeAppender make(TypeDescription typeDescription) {
            return this;
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

            public RecordComponentAttributeAppender make(TypeDescription typeDescription) {
                ArrayList arrayList = new ArrayList(this.factories.size());
                for (Factory make : this.factories) {
                    arrayList.add(make.make(typeDescription));
                }
                return new Compound((List<? extends RecordComponentAttributeAppender>) arrayList);
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

        RecordComponentAttributeAppender make(TypeDescription typeDescription);
    }

    public enum ForInstrumentedRecordComponent implements RecordComponentAttributeAppender, Factory {
        INSTANCE;

        public void apply(RecordComponentVisitor recordComponentVisitor, RecordComponentDescription recordComponentDescription, AnnotationValueFilter annotationValueFilter) {
            AnnotationAppender annotationAppender = (AnnotationAppender) recordComponentDescription.getType().accept(AnnotationAppender.ForTypeAnnotations.ofFieldType(new AnnotationAppender.Default(new AnnotationAppender.Target.OnRecordComponent(recordComponentVisitor)), annotationValueFilter));
            for (AnnotationDescription append : recordComponentDescription.getDeclaredAnnotations()) {
                annotationAppender = annotationAppender.append(append, annotationValueFilter);
            }
        }

        public RecordComponentAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }
    }

    public enum NoOp implements RecordComponentAttributeAppender, Factory {
        INSTANCE;

        public void apply(RecordComponentVisitor recordComponentVisitor, RecordComponentDescription recordComponentDescription, AnnotationValueFilter annotationValueFilter) {
        }

        public RecordComponentAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }
    }

    void apply(RecordComponentVisitor recordComponentVisitor, RecordComponentDescription recordComponentDescription, AnnotationValueFilter annotationValueFilter);
}
