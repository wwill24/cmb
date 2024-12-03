package net.bytebuddy.matcher;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.matcher.FilterableList;

public interface FilterableList<T, S extends FilterableList<T, S>> extends List<T> {

    public static abstract class AbstractBase<T, S extends FilterableList<T, S>> extends AbstractList<T> implements FilterableList<T, S> {
        private static final int ONLY = 0;

        public S filter(ElementMatcher<? super T> elementMatcher) {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (elementMatcher.matches(next)) {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() == size()) {
                return this;
            }
            return wrap(arrayList);
        }

        public T getOnly() {
            if (size() == 1) {
                return get(0);
            }
            throw new IllegalStateException("size = " + size());
        }

        /* access modifiers changed from: protected */
        public abstract S wrap(List<T> list);

        public S subList(int i10, int i11) {
            return wrap(super.subList(i10, i11));
        }
    }

    public static class Empty<T, S extends FilterableList<T, S>> extends AbstractList<T> implements FilterableList<T, S> {
        public S filter(ElementMatcher<? super T> elementMatcher) {
            return this;
        }

        public T get(int i10) {
            throw new IndexOutOfBoundsException("index = " + i10);
        }

        public T getOnly() {
            throw new IllegalStateException("size = 0");
        }

        public int size() {
            return 0;
        }

        public S subList(int i10, int i11) {
            if (i10 == i11 && i11 == 0) {
                return this;
            }
            if (i10 > i11) {
                throw new IllegalArgumentException("fromIndex(" + i10 + ") > toIndex(" + i11 + ")");
            }
            throw new IndexOutOfBoundsException("fromIndex = " + i10);
        }
    }

    S filter(ElementMatcher<? super T> elementMatcher);

    T getOnly();

    S subList(int i10, int i11);
}
