package retrofit2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "L;", "it", "", "invoke", "(L;)V", "kotlin/Throwable", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ b $this_awaitResponse$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(b bVar) {
        super(1);
        this.$this_awaitResponse$inlined = bVar;
    }

    public final void a(Throwable th2) {
        this.$this_awaitResponse$inlined.cancel();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
