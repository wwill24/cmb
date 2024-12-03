package kotlinx.coroutines.flow.internal;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;

@d(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {27}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H@"}, d2 = {"T", "R", "Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.c<R> $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, kotlinx.coroutines.flow.c<? super R> cVar, c<? super ChannelFlowTransformLatest$flowCollect$3> cVar2) {
        super(2, cVar2);
        this.this$0 = channelFlowTransformLatest;
        this.$collector = cVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.this$0, this.$collector, cVar);
        channelFlowTransformLatest$flowCollect$3.L$0 = obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            final k0 k0Var = (k0) this.L$0;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            final ChannelFlowTransformLatest<T, R> channelFlowTransformLatest = this.this$0;
            b<S> bVar = channelFlowTransformLatest.f32438d;
            final kotlinx.coroutines.flow.c<R> cVar = this.$collector;
            AnonymousClass1 r52 = new kotlinx.coroutines.flow.c() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object c(final T r8, kotlin.coroutines.c<? super kotlin.Unit> r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r9
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L_0x0018
                    L_0x0013:
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                        r0.<init>(r7, r9)
                    L_0x0018:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L_0x003b
                        if (r2 != r3) goto L_0x0033
                        java.lang.Object r8 = r0.L$2
                        kotlinx.coroutines.s1 r8 = (kotlinx.coroutines.s1) r8
                        java.lang.Object r8 = r0.L$1
                        java.lang.Object r0 = r0.L$0
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1) r0
                        gk.g.b(r9)
                        goto L_0x005e
                    L_0x0033:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L_0x003b:
                        gk.g.b(r9)
                        kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.s1> r9 = r1
                        T r9 = r9.element
                        kotlinx.coroutines.s1 r9 = (kotlinx.coroutines.s1) r9
                        if (r9 == 0) goto L_0x005d
                        kotlinx.coroutines.flow.internal.ChildCancelledException r2 = new kotlinx.coroutines.flow.internal.ChildCancelledException
                        r2.<init>()
                        r9.b(r2)
                        r0.L$0 = r7
                        r0.L$1 = r8
                        r0.L$2 = r9
                        r0.label = r3
                        java.lang.Object r9 = r9.r0(r0)
                        if (r9 != r1) goto L_0x005d
                        return r1
                    L_0x005d:
                        r0 = r7
                    L_0x005e:
                        kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.s1> r9 = r1
                        kotlinx.coroutines.k0 r1 = r8
                        r2 = 0
                        kotlinx.coroutines.CoroutineStart r3 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2 r4 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest<T, R> r5 = r3
                        kotlinx.coroutines.flow.c<R> r0 = r6
                        r6 = 0
                        r4.<init>(r5, r0, r8, r6)
                        r5 = 1
                        kotlinx.coroutines.s1 r8 = kotlinx.coroutines.j.d(r1, r2, r3, r4, r5, r6)
                        r9.element = r8
                        kotlin.Unit r8 = kotlin.Unit.f32013a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1.c(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            };
            this.label = 1;
            if (bVar.a(r52, this) == d10) {
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
