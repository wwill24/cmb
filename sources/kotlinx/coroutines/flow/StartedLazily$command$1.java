package kotlinx.coroutines.flow;

import gk.g;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;

@d(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", l = {155}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/SharingCommand;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class StartedLazily$command$1 extends SuspendLambda implements Function2<c<? super SharingCommand>, c<? super Unit>, Object> {
    final /* synthetic */ r<Integer> $subscriptionCount;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StartedLazily$command$1(r<Integer> rVar, c<? super StartedLazily$command$1> cVar) {
        super(2, cVar);
        this.$subscriptionCount = rVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        StartedLazily$command$1 startedLazily$command$1 = new StartedLazily$command$1(this.$subscriptionCount, cVar);
        startedLazily$command$1.L$0 = obj;
        return startedLazily$command$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super SharingCommand> cVar, c<? super Unit> cVar2) {
        return ((StartedLazily$command$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            final c cVar = (c) this.L$0;
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            r<Integer> rVar = this.$subscriptionCount;
            AnonymousClass1 r42 = new c() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object a(int r5, kotlin.coroutines.c<? super kotlin.Unit> r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1 r0 = (kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L_0x0018
                    L_0x0013:
                        kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1 r0 = new kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        gk.g.b(r6)
                        goto L_0x004b
                    L_0x0029:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0031:
                        gk.g.b(r6)
                        if (r5 <= 0) goto L_0x004e
                        kotlin.jvm.internal.Ref$BooleanRef r5 = r1
                        boolean r6 = r5.element
                        if (r6 != 0) goto L_0x004e
                        r5.element = r3
                        kotlinx.coroutines.flow.c<kotlinx.coroutines.flow.SharingCommand> r5 = r6
                        kotlinx.coroutines.flow.SharingCommand r6 = kotlinx.coroutines.flow.SharingCommand.START
                        r0.label = r3
                        java.lang.Object r5 = r5.c(r6, r0)
                        if (r5 != r1) goto L_0x004b
                        return r1
                    L_0x004b:
                        kotlin.Unit r5 = kotlin.Unit.f32013a
                        return r5
                    L_0x004e:
                        kotlin.Unit r5 = kotlin.Unit.f32013a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedLazily$command$1.AnonymousClass1.a(int, kotlin.coroutines.c):java.lang.Object");
                }

                public /* bridge */ /* synthetic */ Object c(Object obj, c cVar) {
                    return a(((Number) obj).intValue(), cVar);
                }
            };
            this.label = 1;
            if (rVar.a(r42, this) == d10) {
                return d10;
            }
        } else if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            g.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
