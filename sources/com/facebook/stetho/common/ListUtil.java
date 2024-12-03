package com.facebook.stetho.common;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class ListUtil {

    private static final class FiveItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;
        private final E mItem3;
        private final E mItem4;

        public FiveItemImmutableList(E e10, E e11, E e12, E e13, E e14) {
            this.mItem0 = e10;
            this.mItem1 = e11;
            this.mItem2 = e12;
            this.mItem3 = e13;
            this.mItem4 = e14;
        }

        public E get(int i10) {
            if (i10 == 0) {
                return this.mItem0;
            }
            if (i10 == 1) {
                return this.mItem1;
            }
            if (i10 == 2) {
                return this.mItem2;
            }
            if (i10 == 3) {
                return this.mItem3;
            }
            if (i10 == 4) {
                return this.mItem4;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 5;
        }
    }

    private static final class FourItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;
        private final E mItem3;

        public FourItemImmutableList(E e10, E e11, E e12, E e13) {
            this.mItem0 = e10;
            this.mItem1 = e11;
            this.mItem2 = e12;
            this.mItem3 = e13;
        }

        public E get(int i10) {
            if (i10 == 0) {
                return this.mItem0;
            }
            if (i10 == 1) {
                return this.mItem1;
            }
            if (i10 == 2) {
                return this.mItem2;
            }
            if (i10 == 3) {
                return this.mItem3;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 4;
        }
    }

    private static final class ImmutableArrayList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final Object[] mArray;

        public ImmutableArrayList(Object[] objArr) {
            this.mArray = objArr;
        }

        public E get(int i10) {
            return this.mArray[i10];
        }

        public int size() {
            return this.mArray.length;
        }
    }

    private interface ImmutableList<E> extends List<E>, RandomAccess {
    }

    private static final class OneItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem;

        public OneItemImmutableList(E e10) {
            this.mItem = e10;
        }

        public E get(int i10) {
            if (i10 == 0) {
                return this.mItem;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 1;
        }
    }

    private static final class ThreeItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;

        public ThreeItemImmutableList(E e10, E e11, E e12) {
            this.mItem0 = e10;
            this.mItem1 = e11;
            this.mItem2 = e12;
        }

        public E get(int i10) {
            if (i10 == 0) {
                return this.mItem0;
            }
            if (i10 == 1) {
                return this.mItem1;
            }
            if (i10 == 2) {
                return this.mItem2;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 3;
        }
    }

    private static final class TwoItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;

        public TwoItemImmutableList(E e10, E e11) {
            this.mItem0 = e10;
            this.mItem1 = e11;
        }

        public E get(int i10) {
            if (i10 == 0) {
                return this.mItem0;
            }
            if (i10 == 1) {
                return this.mItem1;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 2;
        }
    }

    private ListUtil() {
    }

    public static <T> List<T> copyToImmutableList(List<T> list) {
        if (list instanceof ImmutableList) {
            return list;
        }
        int size = list.size();
        if (size == 0) {
            return Collections.emptyList();
        }
        if (size == 1) {
            return new OneItemImmutableList(list.get(0));
        }
        if (size == 2) {
            return new TwoItemImmutableList(list.get(0), list.get(1));
        }
        if (size == 3) {
            return new ThreeItemImmutableList(list.get(0), list.get(1), list.get(2));
        }
        if (size == 4) {
            return new FourItemImmutableList(list.get(0), list.get(1), list.get(2), list.get(3));
        }
        if (size != 5) {
            return new ImmutableArrayList(list.toArray());
        }
        return new FiveItemImmutableList(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
    }

    public static <T> boolean identityEquals(List<? extends T> list, List<? extends T> list2) {
        if (list == list2) {
            return true;
        }
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (list.get(i10) != list2.get(i10)) {
                return false;
            }
        }
        return true;
    }

    public static <T> List<T> newImmutableList(T t10) {
        return new OneItemImmutableList(t10);
    }

    public static <T> List<T> newImmutableList(T t10, T t11) {
        return new TwoItemImmutableList(t10, t11);
    }
}
