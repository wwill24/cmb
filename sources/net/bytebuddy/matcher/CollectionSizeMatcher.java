package net.bytebuddy.matcher;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.Iterable;
import java.util.Collection;
import java.util.Iterator;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.apache.commons.beanutils.PropertyUtils;

@HashCodeAndEqualsPlugin.Enhance
public class CollectionSizeMatcher<T extends Iterable<?>> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final int size;

    public CollectionSizeMatcher(int i10) {
        this.size = i10;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.size == ((CollectionSizeMatcher) obj).size;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.size;
    }

    public String toString() {
        return "ofSize(" + this.size + PropertyUtils.MAPPED_DELIM2;
    }

    /* access modifiers changed from: protected */
    @SuppressFBWarnings(justification = "Iteration required to count size of an iterable.", value = {"DLS_DEAD_LOCAL_STORE"})
    public boolean doMatch(T t10) {
        if (!(t10 instanceof Collection)) {
            Iterator it = t10.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                it.next();
                i10++;
            }
            if (i10 == this.size) {
                return true;
            }
            return false;
        } else if (((Collection) t10).size() == this.size) {
            return true;
        } else {
            return false;
        }
    }
}
