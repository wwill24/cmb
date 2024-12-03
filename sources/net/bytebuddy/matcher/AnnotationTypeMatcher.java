package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.apache.commons.beanutils.PropertyUtils;

@HashCodeAndEqualsPlugin.Enhance
public class AnnotationTypeMatcher<T extends AnnotationDescription> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final ElementMatcher<? super TypeDescription> matcher;

    public AnnotationTypeMatcher(ElementMatcher<? super TypeDescription> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((AnnotationTypeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "ofAnnotationType(" + this.matcher + PropertyUtils.MAPPED_DELIM2;
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(T t10) {
        return this.matcher.matches(t10.getAnnotationType());
    }
}
