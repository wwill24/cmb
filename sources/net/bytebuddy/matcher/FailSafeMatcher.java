package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class FailSafeMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private final boolean fallback;
    private final ElementMatcher<? super T> matcher;

    public FailSafeMatcher(ElementMatcher<? super T> elementMatcher, boolean z10) {
        this.matcher = elementMatcher;
        this.fallback = z10;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FailSafeMatcher failSafeMatcher = (FailSafeMatcher) obj;
        return this.fallback == failSafeMatcher.fallback && this.matcher.equals(failSafeMatcher.matcher);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + (this.fallback ? 1 : 0);
    }

    public boolean matches(@MaybeNull T t10) {
        try {
            return this.matcher.matches(t10);
        } catch (Exception unused) {
            return this.fallback;
        }
    }

    public String toString() {
        return "failSafe(try(" + this.matcher + ") or " + this.fallback + ")";
    }
}
