package net.bytebuddy.matcher;

import java.lang.annotation.ElementType;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class AnnotationTargetMatcher<T extends AnnotationDescription> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final ElementType elementType;

    public AnnotationTargetMatcher(ElementType elementType2) {
        this.elementType = elementType2;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.elementType.equals(((AnnotationTargetMatcher) obj).elementType);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.elementType.hashCode();
    }

    public String toString() {
        return "targetsElement(" + this.elementType + ")";
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(T t10) {
        return t10.isSupportedOn(this.elementType);
    }
}
