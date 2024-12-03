package net.bytebuddy.matcher;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance(permitSubclassEquality = true)
public class CachingMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private static final Object NULL_VALUE = new Object();
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
    protected final ConcurrentMap<? super T, Boolean> map;
    private final ElementMatcher<? super T> matcher;

    @SuppressFBWarnings(justification = "Equality does not consider eviction size.", value = {"EQ_DOESNT_OVERRIDE_EQUALS"})
    public static class WithInlineEviction<S> extends CachingMatcher<S> {
        private final int evictionSize;

        public WithInlineEviction(ElementMatcher<? super S> elementMatcher, ConcurrentMap<? super S, Boolean> concurrentMap, int i10) {
            super(elementMatcher, concurrentMap);
            this.evictionSize = i10;
        }

        /* access modifiers changed from: protected */
        public boolean onCacheMiss(@MaybeNull S s10) {
            if (this.map.size() >= this.evictionSize) {
                Iterator<Map.Entry<? super T, Boolean>> it = this.map.entrySet().iterator();
                it.next();
                it.remove();
            }
            return CachingMatcher.super.onCacheMiss(s10);
        }
    }

    public CachingMatcher(ElementMatcher<? super T> elementMatcher, ConcurrentMap<? super T, Boolean> concurrentMap) {
        this.matcher = elementMatcher;
        this.map = concurrentMap;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CachingMatcher) && this.matcher.equals(((CachingMatcher) obj).matcher);
    }

    public int hashCode() {
        return (CachingMatcher.class.hashCode() * 31) + this.matcher.hashCode();
    }

    public boolean matches(@MaybeNull T t10) {
        T t11;
        ConcurrentMap<? super T, Boolean> concurrentMap = this.map;
        if (t10 == null) {
            t11 = NULL_VALUE;
        } else {
            t11 = t10;
        }
        Boolean bool = concurrentMap.get(t11);
        if (bool == null) {
            bool = Boolean.valueOf(onCacheMiss(t10));
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    public boolean onCacheMiss(@MaybeNull T t10) {
        boolean matches = this.matcher.matches(t10);
        ConcurrentMap<? super T, Boolean> concurrentMap = this.map;
        if (t10 == null) {
            t10 = NULL_VALUE;
        }
        concurrentMap.put(t10, Boolean.valueOf(matches));
        return matches;
    }

    public String toString() {
        return "cached(" + this.matcher + ")";
    }
}
