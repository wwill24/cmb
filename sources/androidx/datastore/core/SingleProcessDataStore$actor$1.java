package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"T", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class SingleProcessDataStore$actor$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$actor$1(SingleProcessDataStore<T> singleProcessDataStore) {
        super(1);
        this.this$0 = singleProcessDataStore;
    }

    public final void a(Throwable th2) {
        if (th2 != null) {
            this.this$0.f5013h.setValue(new f(th2));
        }
        SingleProcessDataStore.a aVar = SingleProcessDataStore.f5003k;
        Object b10 = aVar.b();
        SingleProcessDataStore<T> singleProcessDataStore = this.this$0;
        synchronized (b10) {
            aVar.a().remove(singleProcessDataStore.q().getAbsolutePath());
            Unit unit = Unit.f32013a;
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
