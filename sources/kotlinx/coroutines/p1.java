package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\bj\u0002`\t¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R&\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\bj\u0002`\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/p1;", "Lkotlinx/coroutines/l;", "", "cause", "", "a", "", "toString", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlin/jvm/functions/Function1;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class p1 extends l {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<Throwable, Unit> f32595a;

    public p1(Function1<? super Throwable, Unit> function1) {
        this.f32595a = function1;
    }

    public void a(Throwable th2) {
        this.f32595a.invoke(th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }

    public String toString() {
        return "InvokeOnCancel[" + m0.a(this.f32595a) + '@' + m0.b(this) + PropertyUtils.INDEXED_DELIM2;
    }
}
