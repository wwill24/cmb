package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.NamedElement.WithOptionalName;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class IsNamedMatcher<T extends NamedElement.WithOptionalName> extends ElementMatcher.Junction.ForNonNullValues<T> {
    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "isNamed()";
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(T t10) {
        return t10.isNamed();
    }
}
