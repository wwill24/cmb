package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class BooleanMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private static final BooleanMatcher<?> FALSE = new BooleanMatcher<>(false);
    private static final BooleanMatcher<?> TRUE = new BooleanMatcher<>(true);
    protected final boolean matches;

    public BooleanMatcher(boolean z10) {
        this.matches = z10;
    }

    public static <T> ElementMatcher.Junction<T> of(boolean z10) {
        return z10 ? TRUE : FALSE;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matches == ((BooleanMatcher) obj).matches;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + (this.matches ? 1 : 0);
    }

    public boolean matches(@MaybeNull T t10) {
        return this.matches;
    }

    public String toString() {
        return Boolean.toString(this.matches);
    }
}
