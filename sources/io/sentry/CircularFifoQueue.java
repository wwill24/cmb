package io.sentry;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

final class CircularFifoQueue<E> extends AbstractCollection<E> implements Queue<E>, Serializable {
    private static final long serialVersionUID = -8423413834657610406L;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public transient E[] f30777a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public transient int f30778b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public transient int f30779c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public transient boolean f30780d = false;
    /* access modifiers changed from: private */
    public final int maxElements;

    class a implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        private int f30781a;

        /* renamed from: b  reason: collision with root package name */
        private int f30782b = -1;

        /* renamed from: c  reason: collision with root package name */
        private boolean f30783c;

        a() {
            this.f30781a = CircularFifoQueue.this.f30778b;
            this.f30783c = CircularFifoQueue.this.f30780d;
        }

        public boolean hasNext() {
            return this.f30783c || this.f30781a != CircularFifoQueue.this.f30779c;
        }

        public E next() {
            if (hasNext()) {
                this.f30783c = false;
                int i10 = this.f30781a;
                this.f30782b = i10;
                this.f30781a = CircularFifoQueue.this.q(i10);
                return CircularFifoQueue.this.f30777a[this.f30782b];
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            int i10 = this.f30782b;
            if (i10 == -1) {
                throw new IllegalStateException();
            } else if (i10 == CircularFifoQueue.this.f30778b) {
                CircularFifoQueue.this.remove();
                this.f30782b = -1;
            } else {
                int i11 = this.f30782b + 1;
                if (CircularFifoQueue.this.f30778b >= this.f30782b || i11 >= CircularFifoQueue.this.f30779c) {
                    while (i11 != CircularFifoQueue.this.f30779c) {
                        if (i11 >= CircularFifoQueue.this.maxElements) {
                            CircularFifoQueue.this.f30777a[i11 - 1] = CircularFifoQueue.this.f30777a[0];
                            i11 = 0;
                        } else {
                            CircularFifoQueue.this.f30777a[CircularFifoQueue.this.p(i11)] = CircularFifoQueue.this.f30777a[i11];
                            i11 = CircularFifoQueue.this.q(i11);
                        }
                    }
                } else {
                    System.arraycopy(CircularFifoQueue.this.f30777a, i11, CircularFifoQueue.this.f30777a, this.f30782b, CircularFifoQueue.this.f30779c - i11);
                }
                this.f30782b = -1;
                CircularFifoQueue circularFifoQueue = CircularFifoQueue.this;
                int unused = circularFifoQueue.f30779c = circularFifoQueue.p(circularFifoQueue.f30779c);
                CircularFifoQueue.this.f30777a[CircularFifoQueue.this.f30779c] = null;
                boolean unused2 = CircularFifoQueue.this.f30780d = false;
                this.f30781a = CircularFifoQueue.this.p(this.f30781a);
            }
        }
    }

    CircularFifoQueue(int i10) {
        if (i10 > 0) {
            E[] eArr = new Object[i10];
            this.f30777a = eArr;
            this.maxElements = eArr.length;
            return;
        }
        throw new IllegalArgumentException("The size must be greater than 0");
    }

    /* access modifiers changed from: private */
    public int p(int i10) {
        int i11 = i10 - 1;
        return i11 < 0 ? this.maxElements - 1 : i11;
    }

    /* access modifiers changed from: private */
    public int q(int i10) {
        int i11 = i10 + 1;
        if (i11 >= this.maxElements) {
            return 0;
        }
        return i11;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        boolean z10;
        objectInputStream.defaultReadObject();
        this.f30777a = new Object[this.maxElements];
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f30777a[i10] = objectInputStream.readObject();
        }
        this.f30778b = 0;
        if (readInt == this.maxElements) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f30780d = z10;
        if (z10) {
            this.f30779c = 0;
        } else {
            this.f30779c = readInt;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    public boolean add(E e10) {
        if (e10 != null) {
            if (r()) {
                remove();
            }
            E[] eArr = this.f30777a;
            int i10 = this.f30779c;
            int i11 = i10 + 1;
            this.f30779c = i11;
            eArr[i10] = e10;
            if (i11 >= this.maxElements) {
                this.f30779c = 0;
            }
            if (this.f30779c == this.f30778b) {
                this.f30780d = true;
            }
            return true;
        }
        throw new NullPointerException("Attempted to add null object to queue");
    }

    public void clear() {
        this.f30780d = false;
        this.f30778b = 0;
        this.f30779c = 0;
        Arrays.fill(this.f30777a, (Object) null);
    }

    public E element() {
        if (!isEmpty()) {
            return peek();
        }
        throw new NoSuchElementException("queue is empty");
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator<E> iterator() {
        return new a();
    }

    public boolean offer(E e10) {
        return add(e10);
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.f30777a[this.f30778b];
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    public boolean r() {
        return size() == this.maxElements;
    }

    public E remove() {
        if (!isEmpty()) {
            E[] eArr = this.f30777a;
            int i10 = this.f30778b;
            E e10 = eArr[i10];
            if (e10 != null) {
                int i11 = i10 + 1;
                this.f30778b = i11;
                eArr[i10] = null;
                if (i11 >= this.maxElements) {
                    this.f30778b = 0;
                }
                this.f30780d = false;
            }
            return e10;
        }
        throw new NoSuchElementException("queue is empty");
    }

    public int size() {
        int i10;
        int i11 = this.f30779c;
        int i12 = this.f30778b;
        if (i11 < i12) {
            return (this.maxElements - i12) + i11;
        }
        if (i11 != i12) {
            return i11 - i12;
        }
        if (this.f30780d) {
            i10 = this.maxElements;
        } else {
            i10 = 0;
        }
        return i10;
    }
}
