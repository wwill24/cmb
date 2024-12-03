package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class NameMatcher<T extends NamedElement> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final ElementMatcher<String> matcher;

    public NameMatcher(ElementMatcher<String> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((NameMatcher) obj).matcher);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "name(" + this.matcher + ")";
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(T t10) {
        return this.matcher.matches(t10.getActualName());
    }
}
