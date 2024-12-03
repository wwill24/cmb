package io.reactivex.internal.operators.observable;

import androidx.camera.view.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qj.s;
import qj.u;

public final class ObservableReplay<T> extends zj.a<T> implements wj.c {

    /* renamed from: e  reason: collision with root package name */
    static final a f30367e = new e();

    /* renamed from: a  reason: collision with root package name */
    final s<T> f30368a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<ReplayObserver<T>> f30369b;

    /* renamed from: c  reason: collision with root package name */
    final a<T> f30370c;

    /* renamed from: d  reason: collision with root package name */
    final s<T> f30371d;

    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements b<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        Node tail;

        BoundedReplayBuffer() {
            Node node = new Node((Object) null);
            this.tail = node;
            set(node);
        }

        /* access modifiers changed from: package-private */
        public final void a(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void b(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                int i10 = 1;
                do {
                    Node node = (Node) innerDisposable.a();
                    if (node == null) {
                        node = e();
                        innerDisposable.index = node;
                    }
                    while (!innerDisposable.c()) {
                        Node node2 = (Node) node.get();
                        if (node2 == null) {
                            innerDisposable.index = node;
                            i10 = innerDisposable.addAndGet(-i10);
                        } else if (NotificationLite.a(f(node2.value), innerDisposable.child)) {
                            innerDisposable.index = null;
                            return;
                        } else {
                            node = node2;
                        }
                    }
                    innerDisposable.index = null;
                    return;
                } while (i10 != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public Object c(Object obj) {
            return obj;
        }

        public final void complete() {
            a(new Node(c(NotificationLite.d())));
            l();
        }

        public final void d(Throwable th2) {
            a(new Node(c(NotificationLite.h(th2))));
            l();
        }

        /* access modifiers changed from: package-private */
        public Node e() {
            return (Node) get();
        }

        /* access modifiers changed from: package-private */
        public Object f(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public final void g() {
            this.size--;
            h((Node) ((Node) get()).get());
        }

        /* access modifiers changed from: package-private */
        public final void h(Node node) {
            set(node);
        }

        public final void i(T t10) {
            a(new Node(c(NotificationLite.o(t10))));
            k();
        }

        /* access modifiers changed from: package-private */
        public final void j() {
            Node node = (Node) get();
            if (node.value != null) {
                Node node2 = new Node((Object) null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void k();

        /* access modifiers changed from: package-private */
        public void l() {
            j();
        }
    }

    static final class InnerDisposable<T> extends AtomicInteger implements tj.b {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final u<? super T> child;
        Object index;
        final ReplayObserver<T> parent;

        InnerDisposable(ReplayObserver<T> replayObserver, u<? super T> uVar) {
            this.parent = replayObserver;
            this.child = uVar;
        }

        /* access modifiers changed from: package-private */
        public <U> U a() {
            return this.index;
        }

        public boolean c() {
            return this.cancelled;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.parent.e(this);
                this.index = null;
            }
        }
    }

    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        Node(Object obj) {
            this.value = obj;
        }
    }

    static final class ReplayObserver<T> extends AtomicReference<tj.b> implements u<T>, tj.b {

        /* renamed from: a  reason: collision with root package name */
        static final InnerDisposable[] f30372a = new InnerDisposable[0];

        /* renamed from: b  reason: collision with root package name */
        static final InnerDisposable[] f30373b = new InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;
        final b<T> buffer;
        boolean done;
        final AtomicReference<InnerDisposable[]> observers = new AtomicReference<>(f30372a);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        ReplayObserver(b<T> bVar) {
            this.buffer = bVar;
        }

        public void a(tj.b bVar) {
            if (DisposableHelper.i(this, bVar)) {
                f();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                if (innerDisposableArr == f30373b) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!h.a(this.observers, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public boolean c() {
            return this.observers.get() == f30373b;
        }

        public void d(T t10) {
            if (!this.done) {
                this.buffer.i(t10);
                f();
            }
        }

        public void dispose() {
            this.observers.set(f30373b);
            DisposableHelper.a(this);
        }

        /* access modifiers changed from: package-private */
        public void e(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i10 = -1;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        } else if (innerDisposableArr[i11].equals(innerDisposable)) {
                            i10 = i11;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i10 >= 0) {
                        if (length == 1) {
                            innerDisposableArr2 = f30372a;
                        } else {
                            InnerDisposable[] innerDisposableArr3 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i10);
                            System.arraycopy(innerDisposableArr, i10 + 1, innerDisposableArr3, i10, (length - i10) - 1);
                            innerDisposableArr2 = innerDisposableArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!h.a(this.observers, innerDisposableArr, innerDisposableArr2));
        }

        /* access modifiers changed from: package-private */
        public void f() {
            for (InnerDisposable b10 : this.observers.get()) {
                this.buffer.b(b10);
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            for (InnerDisposable b10 : this.observers.getAndSet(f30373b)) {
                this.buffer.b(b10);
            }
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.complete();
                g();
            }
        }

        public void onError(Throwable th2) {
            if (!this.done) {
                this.done = true;
                this.buffer.d(th2);
                g();
                return;
            }
            bk.a.s(th2);
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int i10) {
            this.limit = i10;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            if (this.size > this.limit) {
                g();
            }
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements b<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        UnboundedReplayBuffer(int i10) {
            super(i10);
        }

        public void b(InnerDisposable<T> innerDisposable) {
            int i10;
            if (innerDisposable.getAndIncrement() == 0) {
                u<? super T> uVar = innerDisposable.child;
                int i11 = 1;
                while (!innerDisposable.c()) {
                    int i12 = this.size;
                    Integer num = (Integer) innerDisposable.a();
                    if (num != null) {
                        i10 = num.intValue();
                    } else {
                        i10 = 0;
                    }
                    while (i10 < i12) {
                        if (!NotificationLite.a(get(i10), uVar) && !innerDisposable.c()) {
                            i10++;
                        } else {
                            return;
                        }
                    }
                    innerDisposable.index = Integer.valueOf(i10);
                    i11 = innerDisposable.addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void complete() {
            add(NotificationLite.d());
            this.size++;
        }

        public void d(Throwable th2) {
            add(NotificationLite.h(th2));
            this.size++;
        }

        public void i(T t10) {
            add(NotificationLite.o(t10));
            this.size++;
        }
    }

    interface a<T> {
        b<T> call();
    }

    interface b<T> {
        void b(InnerDisposable<T> innerDisposable);

        void complete();

        void d(Throwable th2);

        void i(T t10);
    }

    static final class c<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f30374a;

        c(int i10) {
            this.f30374a = i10;
        }

        public b<T> call() {
            return new SizeBoundReplayBuffer(this.f30374a);
        }
    }

    static final class d<T> implements s<T> {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicReference<ReplayObserver<T>> f30375a;

        /* renamed from: b  reason: collision with root package name */
        private final a<T> f30376b;

        d(AtomicReference<ReplayObserver<T>> atomicReference, a<T> aVar) {
            this.f30375a = atomicReference;
            this.f30376b = aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e(qj.u<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r3.f30375a
                java.lang.Object r0 = r0.get()
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver) r0
                if (r0 != 0) goto L_0x0020
                io.reactivex.internal.operators.observable.ObservableReplay$a<T> r0 = r3.f30376b
                io.reactivex.internal.operators.observable.ObservableReplay$b r0 = r0.call()
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r1 = new io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver
                r1.<init>(r0)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r3.f30375a
                r2 = 0
                boolean r0 = androidx.camera.view.h.a(r0, r2, r1)
                if (r0 != 0) goto L_0x001f
                goto L_0x0000
            L_0x001f:
                r0 = r1
            L_0x0020:
                io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable r1 = new io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable
                r1.<init>(r0, r4)
                r4.a(r1)
                r0.b(r1)
                boolean r4 = r1.c()
                if (r4 == 0) goto L_0x0035
                r0.e(r1)
                return
            L_0x0035:
                io.reactivex.internal.operators.observable.ObservableReplay$b<T> r4 = r0.buffer
                r4.b(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.d.e(qj.u):void");
        }
    }

    static final class e implements a<Object> {
        e() {
        }

        public b<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    private ObservableReplay(s<T> sVar, s<T> sVar2, AtomicReference<ReplayObserver<T>> atomicReference, a<T> aVar) {
        this.f30371d = sVar;
        this.f30368a = sVar2;
        this.f30369b = atomicReference;
        this.f30370c = aVar;
    }

    public static <T> zj.a<T> D0(s<T> sVar, int i10) {
        if (i10 == Integer.MAX_VALUE) {
            return F0(sVar);
        }
        return E0(sVar, new c(i10));
    }

    static <T> zj.a<T> E0(s<T> sVar, a<T> aVar) {
        AtomicReference atomicReference = new AtomicReference();
        return bk.a.p(new ObservableReplay(new d(atomicReference, aVar), sVar, atomicReference, aVar));
    }

    public static <T> zj.a<T> F0(s<? extends T> sVar) {
        return E0(sVar, f30367e);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A0(vj.f<? super tj.b> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r4.f30369b
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.c()
            if (r1 == 0) goto L_0x0025
        L_0x0010:
            io.reactivex.internal.operators.observable.ObservableReplay$a<T> r1 = r4.f30370c
            io.reactivex.internal.operators.observable.ObservableReplay$b r1 = r1.call()
            io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r2 = new io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver
            r2.<init>(r1)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r1 = r4.f30369b
            boolean r0 = androidx.camera.view.h.a(r1, r0, r2)
            if (r0 != 0) goto L_0x0024
            goto L_0x0000
        L_0x0024:
            r0 = r2
        L_0x0025:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.shouldConnect
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0039
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.shouldConnect
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0039
            r1 = r2
            goto L_0x003a
        L_0x0039:
            r1 = r3
        L_0x003a:
            r5.accept(r0)     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0044
            qj.s<T> r5 = r4.f30368a
            r5.e(r0)
        L_0x0044:
            return
        L_0x0045:
            r5 = move-exception
            if (r1 == 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.shouldConnect
            r0.compareAndSet(r2, r3)
        L_0x004d:
            uj.a.b(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.e(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.A0(vj.f):void");
    }

    public void f(tj.b bVar) {
        h.a(this.f30369b, (ReplayObserver) bVar, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        this.f30371d.e(uVar);
    }
}
