package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;

@d(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Landroidx/datastore/core/SingleProcessDataStore$b;", "msg", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class SingleProcessDataStore$actor$3 extends SuspendLambda implements Function2<SingleProcessDataStore.b<T>, c<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$actor$3(SingleProcessDataStore<T> singleProcessDataStore, c<? super SingleProcessDataStore$actor$3> cVar) {
        super(2, cVar);
        this.this$0 = singleProcessDataStore;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SingleProcessDataStore$actor$3 singleProcessDataStore$actor$3 = new SingleProcessDataStore$actor$3(this.this$0, cVar);
        singleProcessDataStore$actor$3.L$0 = obj;
        return singleProcessDataStore$actor$3;
    }

    /* renamed from: i */
    public final Object invoke(SingleProcessDataStore.b<T> bVar, c<? super Unit> cVar) {
        return ((SingleProcessDataStore$actor$3) create(bVar, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            SingleProcessDataStore.b bVar = (SingleProcessDataStore.b) this.L$0;
            if (bVar instanceof SingleProcessDataStore.b.a) {
                this.label = 1;
                if (this.this$0.r((SingleProcessDataStore.b.a) bVar, this) == d10) {
                    return d10;
                }
            } else if (bVar instanceof SingleProcessDataStore.b.C0050b) {
                this.label = 2;
                if (this.this$0.s((SingleProcessDataStore.b.C0050b) bVar, this) == d10) {
                    return d10;
                }
            }
        } else if (i10 == 1 || i10 == 2) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
