package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/a1;", "Lkotlinx/coroutines/l;", "", "cause", "", "a", "", "toString", "Lkotlinx/coroutines/z0;", "Lkotlinx/coroutines/z0;", "handle", "<init>", "(Lkotlinx/coroutines/z0;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class a1 extends l {

    /* renamed from: a  reason: collision with root package name */
    private final z0 f32273a;

    public a1(z0 z0Var) {
        this.f32273a = z0Var;
    }

    public void a(Throwable th2) {
        this.f32273a.dispose();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f32273a + PropertyUtils.INDEXED_DELIM2;
    }
}
