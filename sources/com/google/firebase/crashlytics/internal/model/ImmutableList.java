package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class ImmutableList<E> implements List<E>, RandomAccess {
    private final List<E> immutableList;

    private ImmutableList(List<E> list) {
        this.immutableList = Collections.unmodifiableList(list);
    }

    @NonNull
    public static <E> ImmutableList<E> from(E... eArr) {
        return new ImmutableList<>(Arrays.asList(eArr));
    }

    public boolean add(@NonNull E e10) {
        return this.immutableList.add(e10);
    }

    public boolean addAll(@NonNull Collection<? extends E> collection) {
        return this.immutableList.addAll(collection);
    }

    public void clear() {
        this.immutableList.clear();
    }

    public boolean contains(Object obj) {
        return this.immutableList.contains(obj);
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.immutableList.containsAll(collection);
    }

    public boolean equals(Object obj) {
        return this.immutableList.equals(obj);
    }

    @NonNull
    public E get(int i10) {
        return this.immutableList.get(i10);
    }

    public int hashCode() {
        return this.immutableList.hashCode();
    }

    public int indexOf(Object obj) {
        return this.immutableList.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.immutableList.isEmpty();
    }

    @NonNull
    public Iterator<E> iterator() {
        return this.immutableList.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.immutableList.lastIndexOf(obj);
    }

    @NonNull
    public ListIterator<E> listIterator() {
        return this.immutableList.listIterator();
    }

    public boolean remove(Object obj) {
        return this.immutableList.remove(obj);
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.immutableList.removeAll(collection);
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.immutableList.retainAll(collection);
    }

    @NonNull
    public E set(int i10, @NonNull E e10) {
        return this.immutableList.set(i10, e10);
    }

    public int size() {
        return this.immutableList.size();
    }

    @NonNull
    public List<E> subList(int i10, int i11) {
        return this.immutableList.subList(i10, i11);
    }

    public Object[] toArray() {
        return this.immutableList.toArray();
    }

    @NonNull
    public static <E> ImmutableList<E> from(@NonNull List<E> list) {
        return new ImmutableList<>(list);
    }

    public void add(int i10, @NonNull E e10) {
        this.immutableList.add(i10, e10);
    }

    public boolean addAll(int i10, @NonNull Collection<? extends E> collection) {
        return this.immutableList.addAll(i10, collection);
    }

    @NonNull
    public ListIterator<E> listIterator(int i10) {
        return this.immutableList.listIterator(i10);
    }

    public E remove(int i10) {
        return this.immutableList.remove(i10);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.immutableList.toArray(tArr);
    }
}
