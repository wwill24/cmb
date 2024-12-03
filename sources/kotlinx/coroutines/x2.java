package kotlinx.coroutines;

import gk.h;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.b0;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0014R*\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/x2;", "T", "Lkotlinx/coroutines/internal/b0;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "oldValue", "", "k1", "", "j1", "state", "e1", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "d", "Ljava/lang/ThreadLocal;", "threadStateToRecover", "Lkotlin/coroutines/c;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class x2<T> extends b0<T> {

    /* renamed from: d  reason: collision with root package name */
    private ThreadLocal<Pair<CoroutineContext, Object>> f32737d;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public x2(kotlin.coroutines.CoroutineContext r3, kotlin.coroutines.c<? super T> r4) {
        /*
            r2 = this;
            kotlinx.coroutines.y2 r0 = kotlinx.coroutines.y2.f32740a
            kotlin.coroutines.CoroutineContext$Element r1 = r3.c(r0)
            if (r1 != 0) goto L_0x000d
            kotlin.coroutines.CoroutineContext r0 = r3.e0(r0)
            goto L_0x000e
        L_0x000d:
            r0 = r3
        L_0x000e:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f32737d = r0
            kotlin.coroutines.CoroutineContext r4 = r4.getContext()
            kotlin.coroutines.d$b r0 = kotlin.coroutines.d.f32074s
            kotlin.coroutines.CoroutineContext$Element r4 = r4.c(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.CoroutineDispatcher
            if (r4 != 0) goto L_0x0031
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r4)
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r4)
            r2.k1(r3, r4)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.x2.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.c):void");
    }

    /* access modifiers changed from: protected */
    public void e1(Object obj) {
        Pair pair = this.f32737d.get();
        x2<?> x2Var = null;
        if (pair != null) {
            ThreadContextKt.a((CoroutineContext) pair.a(), pair.b());
            this.f32737d.set(x2Var);
        }
        Object a10 = e0.a(obj, this.f32519c);
        c<T> cVar = this.f32519c;
        CoroutineContext context = cVar.getContext();
        Object c10 = ThreadContextKt.c(context, x2Var);
        if (c10 != ThreadContextKt.f32507a) {
            x2Var = CoroutineContextKt.g(cVar, context, c10);
        }
        try {
            this.f32519c.resumeWith(a10);
            Unit unit = Unit.f32013a;
        } finally {
            if (x2Var == null || x2Var.j1()) {
                ThreadContextKt.a(context, c10);
            }
        }
    }

    public final boolean j1() {
        if (this.f32737d.get() == null) {
            return false;
        }
        this.f32737d.set((Object) null);
        return true;
    }

    public final void k1(CoroutineContext coroutineContext, Object obj) {
        this.f32737d.set(h.a(coroutineContext, obj));
    }
}
