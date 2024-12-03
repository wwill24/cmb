package xn;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;

public final class a<T> implements List<T>, Comparable<List<? extends T>>, qk.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<T> f42510a;

    public a(List<? extends T> list) {
        j.g(list, FirebaseAnalytics.Param.ITEMS);
        this.f42510a = list;
    }

    public void add(int i10, T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i10, Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public int compareTo(List<? extends T> list) {
        j.g(list, "other");
        return b.a(this.f42510a.toString(), list.toString());
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return this.f42510a.contains(obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        return this.f42510a.containsAll(collection);
    }

    public int d() {
        return this.f42510a.size();
    }

    public T get(int i10) {
        return this.f42510a.get(i10);
    }

    public int indexOf(Object obj) {
        return this.f42510a.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.f42510a.isEmpty();
    }

    public Iterator<T> iterator() {
        return this.f42510a.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.f42510a.lastIndexOf(obj);
    }

    public ListIterator<T> listIterator() {
        return this.f42510a.listIterator();
    }

    public ListIterator<T> listIterator(int i10) {
        return this.f42510a.listIterator(i10);
    }

    public T remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(UnaryOperator<T> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public T set(int i10, T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return d();
    }

    public void sort(Comparator<? super T> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<T> subList(int i10, int i11) {
        return this.f42510a.subList(i10, i11);
    }

    public Object[] toArray() {
        return e.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        j.g(tArr, "array");
        return e.b(this, tArr);
    }
}
