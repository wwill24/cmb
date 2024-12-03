package net.bytebuddy.matcher;

import java.util.Iterator;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class CollectionElementMatcher<T> extends ElementMatcher.Junction.ForNonNullValues<Iterable<? extends T>> {
    private final int index;
    private final ElementMatcher<? super T> matcher;

    public CollectionElementMatcher(int i10, ElementMatcher<? super T> elementMatcher) {
        this.index = i10;
        this.matcher = elementMatcher;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CollectionElementMatcher collectionElementMatcher = (CollectionElementMatcher) obj;
        return this.index == collectionElementMatcher.index && this.matcher.equals(collectionElementMatcher.matcher);
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + this.index) * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "with(" + this.index + " matches " + this.matcher + ")";
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        for (int i10 = 0; i10 < this.index; i10++) {
            if (!it.hasNext()) {
                return false;
            }
            it.next();
        }
        if (!it.hasNext() || !this.matcher.matches(it.next())) {
            return false;
        }
        return true;
    }
}
