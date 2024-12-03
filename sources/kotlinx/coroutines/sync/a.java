package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.l;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/sync/a;", "Lkotlinx/coroutines/l;", "", "cause", "", "a", "", "toString", "Lkotlinx/coroutines/sync/g;", "Lkotlinx/coroutines/sync/g;", "segment", "", "b", "I", "index", "<init>", "(Lkotlinx/coroutines/sync/g;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class a extends l {

    /* renamed from: a  reason: collision with root package name */
    private final g f32704a;

    /* renamed from: b  reason: collision with root package name */
    private final int f32705b;

    public a(g gVar, int i10) {
        this.f32704a = gVar;
        this.f32705b = i10;
    }

    public void a(Throwable th2) {
        this.f32704a.q(this.f32705b);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }

    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + this.f32704a + ", " + this.f32705b + PropertyUtils.INDEXED_DELIM2;
    }
}
