package net.bytebuddy.matcher;

import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.apache.commons.beanutils.PropertyUtils;

@HashCodeAndEqualsPlugin.Enhance
public class CollectionOneToOneMatcher<T> extends ElementMatcher.Junction.ForNonNullValues<Iterable<? extends T>> {
    private final List<? extends ElementMatcher<? super T>> matchers;

    public CollectionOneToOneMatcher(List<? extends ElementMatcher<? super T>> list) {
        this.matchers = list;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matchers.equals(((CollectionOneToOneMatcher) obj).matchers);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.matchers.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("containing(");
        boolean z10 = true;
        for (Object next : this.matchers) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(next);
        }
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean doMatch(java.lang.Iterable<? extends T> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof java.util.Collection
            r1 = 0
            if (r0 == 0) goto L_0x0015
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            int r0 = r0.size()
            java.util.List<? extends net.bytebuddy.matcher.ElementMatcher<? super T>> r2 = r4.matchers
            int r2 = r2.size()
            if (r0 == r2) goto L_0x0015
            return r1
        L_0x0015:
            java.util.List<? extends net.bytebuddy.matcher.ElementMatcher<? super T>> r0 = r4.matchers
            java.util.Iterator r0 = r0.iterator()
            java.util.Iterator r5 = r5.iterator()
        L_0x001f:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x003c
            java.lang.Object r2 = r5.next()
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x003b
            java.lang.Object r3 = r0.next()
            net.bytebuddy.matcher.ElementMatcher r3 = (net.bytebuddy.matcher.ElementMatcher) r3
            boolean r2 = r3.matches(r2)
            if (r2 != 0) goto L_0x001f
        L_0x003b:
            return r1
        L_0x003c:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.matcher.CollectionOneToOneMatcher.doMatch(java.lang.Iterable):boolean");
    }
}
