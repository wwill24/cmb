package kotlinx.coroutines.reactive;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.m;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import rn.b;
import rn.c;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/reactive/d;", "T", "Lkotlinx/coroutines/channels/m;", "Lrn/b;", "", "a0", "()V", "Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "closed", "D", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lrn/c;", "s", "e", "(Lrn/c;)V", "t", "d", "(Ljava/lang/Object;)V", "onComplete", "", "onError", "(Ljava/lang/Throwable;)V", "", "I", "request", "<init>", "(I)V", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 6, 0})
final class d<T> extends m<T> implements b<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32610e;

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f32611f;
    private volatile /* synthetic */ int _requested;
    private volatile /* synthetic */ Object _subscription;

    /* renamed from: d  reason: collision with root package name */
    private final int f32612d;

    static {
        Class<d> cls = d.class;
        f32610e = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_subscription");
        f32611f = AtomicIntegerFieldUpdater.newUpdater(cls, "_requested");
    }

    public d(int i10) {
        super((Function1) null);
        boolean z10;
        this.f32612d = i10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this._subscription = null;
            this._requested = 0;
            return;
        }
        throw new IllegalArgumentException(("Invalid request size: " + i10).toString());
    }

    public void D(LockFreeLinkedListNode lockFreeLinkedListNode) {
        c cVar = (c) f32610e.getAndSet(this, (Object) null);
        if (cVar != null) {
            cVar.cancel();
        }
    }

    public void Z() {
        f32611f.incrementAndGet(this);
    }

    public void a0() {
        c cVar;
        int i10;
        while (true) {
            int i11 = this._requested;
            cVar = (c) this._subscription;
            i10 = i11 - 1;
            if (cVar != null && i10 < 0) {
                int i12 = this.f32612d;
                if (i11 == i12 || f32611f.compareAndSet(this, i11, i12)) {
                    cVar.r((long) (this.f32612d - i10));
                }
            } else if (f32611f.compareAndSet(this, i11, i10)) {
                return;
            }
        }
        cVar.r((long) (this.f32612d - i10));
    }

    public void d(T t10) {
        f32611f.decrementAndGet(this);
        t(t10);
    }

    public void e(c cVar) {
        this._subscription = cVar;
        while (!K()) {
            int i10 = this._requested;
            int i11 = this.f32612d;
            if (i10 < i11) {
                if (f32611f.compareAndSet(this, i10, i11)) {
                    cVar.r((long) (this.f32612d - i10));
                    return;
                }
            } else {
                return;
            }
        }
        cVar.cancel();
    }

    public void onComplete() {
        F((Throwable) null);
    }

    public void onError(Throwable th2) {
        F(th2);
    }
}
