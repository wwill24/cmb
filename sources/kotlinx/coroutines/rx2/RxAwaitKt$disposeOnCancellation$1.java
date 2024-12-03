package kotlinx.coroutines.rx2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tj.b;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0})
final class RxAwaitKt$disposeOnCancellation$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ b $d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RxAwaitKt$disposeOnCancellation$1(b bVar) {
        super(1);
        this.$d = bVar;
    }

    public final void a(Throwable th2) {
        this.$d.dispose();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
