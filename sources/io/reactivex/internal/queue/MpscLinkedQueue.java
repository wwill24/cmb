package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicReference;
import yj.h;

public final class MpscLinkedQueue<T> implements h<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<T>> f30589a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<T>> f30590b = new AtomicReference<>();

    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        public E a() {
            E b10 = b();
            e((Object) null);
            return b10;
        }

        public E b() {
            return this.value;
        }

        public LinkedQueueNode<E> c() {
            return (LinkedQueueNode) get();
        }

        public void d(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void e(E e10) {
            this.value = e10;
        }

        LinkedQueueNode(E e10) {
            e(e10);
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        e(linkedQueueNode);
        f(linkedQueueNode);
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> a() {
        return this.f30590b.get();
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> c() {
        return this.f30590b.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.poll()
            if (r0 == 0) goto L_0x000d
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.queue.MpscLinkedQueue.clear():void");
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> d() {
        return this.f30589a.get();
    }

    /* access modifiers changed from: package-private */
    public void e(LinkedQueueNode<T> linkedQueueNode) {
        this.f30590b.lazySet(linkedQueueNode);
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> f(LinkedQueueNode<T> linkedQueueNode) {
        return this.f30589a.getAndSet(linkedQueueNode);
    }

    public boolean isEmpty() {
        return c() == d();
    }

    public boolean offer(T t10) {
        if (t10 != null) {
            LinkedQueueNode linkedQueueNode = new LinkedQueueNode(t10);
            f(linkedQueueNode).d(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T poll() {
        LinkedQueueNode c10;
        LinkedQueueNode a10 = a();
        LinkedQueueNode c11 = a10.c();
        if (c11 != null) {
            T a11 = c11.a();
            e(c11);
            return a11;
        } else if (a10 == d()) {
            return null;
        } else {
            do {
                c10 = a10.c();
            } while (c10 == null);
            T a12 = c10.a();
            e(c10);
            return a12;
        }
    }
}
