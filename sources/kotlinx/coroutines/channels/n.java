package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.i0;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u0014\u0010\u000f\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/channels/n;", "E", "Lkotlinx/coroutines/channels/e;", "Lkotlinx/coroutines/channels/o;", "", "value", "k1", "(Lkotlin/Unit;)V", "", "cause", "", "handled", "f1", "a", "()Z", "isActive", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lkotlinx/coroutines/channels/d;", "channel", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/d;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class n<E> extends e<E> implements o<E> {
    public n(CoroutineContext coroutineContext, d<E> dVar) {
        super(coroutineContext, dVar, true, true);
    }

    public boolean a() {
        return super.a();
    }

    /* access modifiers changed from: protected */
    public void f1(Throwable th2, boolean z10) {
        if (!j1().F(th2) && !z10) {
            i0.a(getContext(), th2);
        }
    }

    public /* bridge */ /* synthetic */ u k() {
        return i1();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k1 */
    public void g1(Unit unit) {
        u.a.a(j1(), (Throwable) null, 1, (Object) null);
    }
}
