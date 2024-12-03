package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {122, 122}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class SimpleActor$offer$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SimpleActor<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleActor$offer$2(SimpleActor<T> simpleActor, c<? super SimpleActor$offer$2> cVar) {
        super(2, cVar);
        this.this$0 = simpleActor;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SimpleActor$offer$2(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((SimpleActor$offer$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            gk.g.b(r8)
            r8 = r7
            goto L_0x006e
        L_0x0013:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001b:
            java.lang.Object r1 = r7.L$0
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            gk.g.b(r8)
            r4 = r1
            r1 = r0
            r0 = r7
            goto L_0x0060
        L_0x0026:
            gk.g.b(r8)
            androidx.datastore.core.SimpleActor<T> r8 = r7.this$0
            java.util.concurrent.atomic.AtomicInteger r8 = r8.f5002d
            int r8 = r8.get()
            if (r8 <= 0) goto L_0x0037
            r8 = r3
            goto L_0x0038
        L_0x0037:
            r8 = 0
        L_0x0038:
            if (r8 == 0) goto L_0x007d
            r8 = r7
        L_0x003b:
            androidx.datastore.core.SimpleActor<T> r1 = r8.this$0
            kotlinx.coroutines.k0 r1 = r1.f4999a
            kotlinx.coroutines.l0.h(r1)
            androidx.datastore.core.SimpleActor<T> r1 = r8.this$0
            kotlin.jvm.functions.Function2 r1 = r1.f5000b
            androidx.datastore.core.SimpleActor<T> r4 = r8.this$0
            kotlinx.coroutines.channels.d r4 = r4.f5001c
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r4 = r4.E(r8)
            if (r4 != r0) goto L_0x005b
            return r0
        L_0x005b:
            r6 = r0
            r0 = r8
            r8 = r4
            r4 = r1
            r1 = r6
        L_0x0060:
            r5 = 0
            r0.L$0 = r5
            r0.label = r2
            java.lang.Object r8 = r4.invoke(r8, r0)
            if (r8 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r8 = r0
            r0 = r1
        L_0x006e:
            androidx.datastore.core.SimpleActor<T> r1 = r8.this$0
            java.util.concurrent.atomic.AtomicInteger r1 = r1.f5002d
            int r1 = r1.decrementAndGet()
            if (r1 != 0) goto L_0x003b
            kotlin.Unit r8 = kotlin.Unit.f32013a
            return r8
        L_0x007d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
