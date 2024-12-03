package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/flow/c;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class SingleProcessDataStore$data$1 extends SuspendLambda implements Function2<c<? super T>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    @d(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Landroidx/datastore/core/j;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<j<T>, kotlin.coroutines.c<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            AnonymousClass1 r02 = new AnonymousClass1(jVar, cVar);
            r02.L$0 = obj;
            return r02;
        }

        /* renamed from: i */
        public final Object invoke(j<T> jVar, kotlin.coroutines.c<? super Boolean> cVar) {
            return ((AnonymousClass1) create(jVar, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = b.d();
            if (this.label == 0) {
                g.b(obj);
                j<T> jVar = (j) this.L$0;
                j<T> jVar2 = jVar;
                boolean z10 = false;
                if (!(jVar2 instanceof b) && !(jVar2 instanceof f) && jVar == jVar2) {
                    z10 = true;
                }
                return a.a(z10);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$data$1(SingleProcessDataStore<T> singleProcessDataStore, kotlin.coroutines.c<? super SingleProcessDataStore$data$1> cVar) {
        super(2, cVar);
        this.this$0 = singleProcessDataStore;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        SingleProcessDataStore$data$1 singleProcessDataStore$data$1 = new SingleProcessDataStore$data$1(this.this$0, cVar);
        singleProcessDataStore$data$1.L$0 = obj;
        return singleProcessDataStore$data$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super T> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((SingleProcessDataStore$data$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            c cVar = (c) this.L$0;
            final j jVar = (j) this.this$0.f5013h.getValue();
            if (!(jVar instanceof b)) {
                this.this$0.f5015j.e(new SingleProcessDataStore.b.a(jVar));
            }
            SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1 singleProcessDataStore$data$1$invokeSuspend$$inlined$map$1 = new SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1(kotlinx.coroutines.flow.d.o(this.this$0.f5013h, new AnonymousClass1((kotlin.coroutines.c<? super AnonymousClass1>) null)));
            this.label = 1;
            if (kotlinx.coroutines.flow.d.q(cVar, singleProcessDataStore$data$1$invokeSuspend$$inlined$map$1, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
