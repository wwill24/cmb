package androidx.datastore.core;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", l = {402}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/k0;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class SingleProcessDataStore$transformAndWrite$newData$1 extends SuspendLambda implements Function2<k0, c<? super T>, Object> {
    final /* synthetic */ T $curData;
    final /* synthetic */ Function2<T, c<? super T>, Object> $transform;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$transformAndWrite$newData$1(Function2<? super T, ? super c<? super T>, ? extends Object> function2, T t10, c<? super SingleProcessDataStore$transformAndWrite$newData$1> cVar) {
        super(2, cVar);
        this.$transform = function2;
        this.$curData = t10;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SingleProcessDataStore$transformAndWrite$newData$1(this.$transform, this.$curData, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super T> cVar) {
        return ((SingleProcessDataStore$transformAndWrite$newData$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            Function2<T, c<? super T>, Object> function2 = this.$transform;
            T t10 = this.$curData;
            this.label = 1;
            obj = function2.invoke(t10, this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
