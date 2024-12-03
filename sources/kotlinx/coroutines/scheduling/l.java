package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0017J\u001c\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/scheduling/l;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "F", "E", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class l extends CoroutineDispatcher {

    /* renamed from: c  reason: collision with root package name */
    public static final l f32667c = new l();

    private l() {
    }

    public void E(CoroutineContext coroutineContext, Runnable runnable) {
        b.f32649j.f0(runnable, k.f32666g, false);
    }

    public void F(CoroutineContext coroutineContext, Runnable runnable) {
        b.f32649j.f0(runnable, k.f32666g, true);
    }
}
