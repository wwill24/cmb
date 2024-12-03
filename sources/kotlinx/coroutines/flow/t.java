package kotlinx.coroutines.flow;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.internal.b;
import kotlinx.coroutines.flow.internal.c;
import kotlinx.coroutines.o;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\rJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/flow/t;", "Lkotlinx/coroutines/flow/internal/c;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "flow", "", "c", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "Lkotlin/coroutines/c;", "", "e", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/c;", "f", "()V", "g", "()Z", "d", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class t extends c<StateFlowImpl<?>> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f32486a = AtomicReferenceFieldUpdater.newUpdater(t.class, Object.class, "_state");
    volatile /* synthetic */ Object _state = null;

    /* renamed from: c */
    public boolean a(StateFlowImpl<?> stateFlowImpl) {
        if (this._state != null) {
            return false;
        }
        this._state = s.f32484a;
        return true;
    }

    public final Object d(kotlin.coroutines.c<? super Unit> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        oVar.y();
        if (!a.a(f32486a, this, s.f32484a, oVar)) {
            Result.a aVar = Result.f32010a;
            oVar.resumeWith(Result.b(Unit.f32013a));
        }
        Object v10 = oVar.v();
        if (v10 == b.d()) {
            f.c(cVar);
        }
        if (v10 == b.d()) {
            return v10;
        }
        return Unit.f32013a;
    }

    /* renamed from: e */
    public kotlin.coroutines.c<Unit>[] b(StateFlowImpl<?> stateFlowImpl) {
        this._state = null;
        return b.f32458a;
    }

    public final void f() {
        while (true) {
            Object obj = this._state;
            if (obj != null && obj != s.f32485b) {
                if (obj == s.f32484a) {
                    if (a.a(f32486a, this, obj, s.f32485b)) {
                        return;
                    }
                } else if (a.a(f32486a, this, obj, s.f32484a)) {
                    Result.a aVar = Result.f32010a;
                    ((o) obj).resumeWith(Result.b(Unit.f32013a));
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean g() {
        Object andSet = f32486a.getAndSet(this, s.f32484a);
        j.d(andSet);
        if (andSet == s.f32485b) {
            return true;
        }
        return false;
    }
}
