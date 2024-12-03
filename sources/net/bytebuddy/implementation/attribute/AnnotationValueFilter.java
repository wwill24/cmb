package net.bytebuddy.implementation.attribute;

import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDescription;

public interface AnnotationValueFilter {

    public enum Default implements AnnotationValueFilter, Factory {
        SKIP_DEFAULTS {
            public boolean isRelevant(AnnotationDescription annotationDescription, MethodDescription.InDefinedShape inDefinedShape) {
                AnnotationValue<?, ?> defaultValue = inDefinedShape.getDefaultValue();
                if (defaultValue == null || !defaultValue.equals(annotationDescription.getValue(inDefinedShape))) {
                    return true;
                }
                return false;
            }
        },
        APPEND_DEFAULTS {
            public boolean isRelevant(AnnotationDescription annotationDescription, MethodDescription.InDefinedShape inDefinedShape) {
                return true;
            }
        };

        public AnnotationValueFilter on(FieldDescription fieldDescription) {
            return this;
        }

        public AnnotationValueFilter on(MethodDescription methodDescription) {
            return this;
        }

        public AnnotationValueFilter on(RecordComponentDescription recordComponentDescription) {
            return this;
        }

        public AnnotationValueFilter on(TypeDescription typeDescription) {
            return this;
        }
    }

    public interface Factory {
        AnnotationValueFilter on(FieldDescription fieldDescription);

        AnnotationValueFilter on(MethodDescription methodDescription);

        AnnotationValueFilter on(RecordComponentDescription recordComponentDescription);

        AnnotationValueFilter on(TypeDescription typeDescription);
    }

    boolean isRelevant(AnnotationDescription annotationDescription, MethodDescription.InDefinedShape inDefinedShape);
}
