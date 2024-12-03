package net.bytebuddy.description.annotation;

import java.util.Arrays;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface AnnotationSource {

    public enum Empty implements AnnotationSource {
        INSTANCE;

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Empty();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Explicit implements AnnotationSource {
        private final List<? extends AnnotationDescription> annotations;

        public Explicit(AnnotationDescription... annotationDescriptionArr) {
            this((List<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.annotations.equals(((Explicit) obj).annotations);
        }

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.annotations.hashCode();
        }

        public Explicit(List<? extends AnnotationDescription> list) {
            this.annotations = list;
        }
    }

    AnnotationList getDeclaredAnnotations();
}
