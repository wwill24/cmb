package net.bytebuddy.matcher;

import java.util.Set;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class StringSetMatcher extends ElementMatcher.Junction.ForNonNullValues<String> {
    private final Set<String> values;

    public StringSetMatcher(Set<String> set) {
        this.values = set;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.values.equals(((StringSetMatcher) obj).values);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("in(");
        boolean z10 = true;
        for (String next : this.values) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(next);
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(String str) {
        return this.values.contains(str);
    }
}
