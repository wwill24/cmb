package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class ArrayTypeMatcher<T extends TypeDefinition> extends ElementMatcher.Junction.ForNonNullValues<T> {
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
        return "isArray()";
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(T t10) {
        return t10.isArray();
    }
}
