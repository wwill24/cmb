package io.sentry;

import java.util.Queue;

final class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
    private static final long serialVersionUID = 1;

    private SynchronizedQueue(Queue<E> queue) {
        super(queue);
    }

    static <E> SynchronizedQueue<E> f(Queue<E> queue) {
        return new SynchronizedQueue<>(queue);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Queue<E> b() {
        return (Queue) super.b();
    }

    public E element() {
        E element;
        synchronized (this.lock) {
            element = b().element();
        }
        return element;
    }

    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.lock) {
            equals = b().equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.lock) {
            hashCode = b().hashCode();
        }
        return hashCode;
    }

    public boolean offer(E e10) {
        boolean offer;
        synchronized (this.lock) {
            offer = b().offer(e10);
        }
        return offer;
    }

    public E peek() {
        E peek;
        synchronized (this.lock) {
            peek = b().peek();
        }
        return peek;
    }

    public E poll() {
        E poll;
        synchronized (this.lock) {
            poll = b().poll();
        }
        return poll;
    }

    public E remove() {
        E remove;
        synchronized (this.lock) {
            remove = b().remove();
        }
        return remove;
    }

    public Object[] toArray() {
        Object[] array2;
        synchronized (this.lock) {
            array2 = b().toArray();
        }
        return array2;
    }

    public <T> T[] toArray(T[] tArr) {
        T[] array2;
        synchronized (this.lock) {
            array2 = b().toArray(tArr);
        }
        return array2;
    }
}
