package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class AccessibilityMatcher<T extends ByteCodeElement> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final TypeDescription typeDescription;

    public AccessibilityMatcher(TypeDescription typeDescription2) {
        this.typeDescription = typeDescription2;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((AccessibilityMatcher) obj).typeDescription);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.typeDescription.hashCode();
    }

    public String toString() {
        return "isAccessibleTo(" + this.typeDescription + ")";
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(T t10) {
        return t10.isAccessibleTo(this.typeDescription);
    }
}
