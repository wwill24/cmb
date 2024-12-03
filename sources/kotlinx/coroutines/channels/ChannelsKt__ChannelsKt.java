package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.channels.h;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"E", "Lkotlinx/coroutines/channels/u;", "element", "Lkotlinx/coroutines/channels/h;", "", "a", "(Lkotlinx/coroutines/channels/u;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/channels/ChannelsKt")
final /* synthetic */ class ChannelsKt__ChannelsKt {
    public static final <E> Object a(u<? super E> uVar, E e10) {
        Object t10 = uVar.t(e10);
        if (t10 instanceof h.c) {
            return ((h) i.b((CoroutineContext) null, new ChannelsKt__ChannelsKt$trySendBlocking$2(uVar, e10, (c<? super ChannelsKt__ChannelsKt$trySendBlocking$2>) null), 1, (Object) null)).l();
        }
        Unit unit = (Unit) t10;
        return h.f32331b.c(Unit.f32013a);
    }
}
