package kotlinx.coroutines.channels;

import gk.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", l = {39}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"E", "Lkotlinx/coroutines/k0;", "Lkotlinx/coroutines/channels/h;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<k0, c<? super h<? extends Unit>>, Object> {
    final /* synthetic */ E $element;
    final /* synthetic */ u<E> $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__ChannelsKt$trySendBlocking$2(u<? super E> uVar, E e10, c<? super ChannelsKt__ChannelsKt$trySendBlocking$2> cVar) {
        super(2, cVar);
        this.$this_trySendBlocking = uVar;
        this.$element = e10;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, cVar);
        channelsKt__ChannelsKt$trySendBlocking$2.L$0 = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    public final Object invoke(k0 k0Var, c<? super h<Unit>> cVar) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3;
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            k0 k0Var = (k0) this.L$0;
            u<E> uVar = this.$this_trySendBlocking;
            E e10 = this.$element;
            Result.a aVar = Result.f32010a;
            this.label = 1;
            if (uVar.H(e10, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            try {
                g.b(obj);
            } catch (Throwable th2) {
                Result.a aVar2 = Result.f32010a;
                obj2 = Result.b(g.a(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.b(Unit.f32013a);
        if (Result.h(obj2)) {
            obj3 = h.f32331b.c(Unit.f32013a);
        } else {
            obj3 = h.f32331b.a(Result.e(obj2));
        }
        return h.b(obj3);
    }
}
