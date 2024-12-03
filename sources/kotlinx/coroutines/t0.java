package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.j;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\u0001\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u0001\u0010\nJ\u0019\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/t0;", "T", "Lkotlinx/coroutines/internal/b0;", "", "l1", "()Z", "k1", "", "state", "", "(Ljava/lang/Object;)V", "e1", "j1", "()Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/c;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class t0<T> extends b0<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f32720d = AtomicIntegerFieldUpdater.newUpdater(t0.class, "_decision");
    private volatile /* synthetic */ int _decision = 0;

    public t0(CoroutineContext coroutineContext, c<? super T> cVar) {
        super(coroutineContext, cVar);
    }

    private final boolean k1() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f32720d.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean l1() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f32720d.compareAndSet(this, 0, 1));
        return true;
    }

    /* access modifiers changed from: protected */
    public void T(Object obj) {
        e1(obj);
    }

    /* access modifiers changed from: protected */
    public void e1(Object obj) {
        if (!k1()) {
            j.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.f32519c), e0.a(obj, this.f32519c), (Function1) null, 2, (Object) null);
        }
    }

    public final Object j1() {
        if (l1()) {
            return b.d();
        }
        Object h10 = z1.h(q0());
        if (!(h10 instanceof b0)) {
            return h10;
        }
        throw ((b0) h10).f32285a;
    }
}
