package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.flow.c;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/internal/m;", "T", "Lkotlinx/coroutines/flow/c;", "value", "", "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/u;", "a", "Lkotlinx/coroutines/channels/u;", "channel", "<init>", "(Lkotlinx/coroutines/channels/u;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class m<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final u<T> f32467a;

    public m(u<? super T> uVar) {
        this.f32467a = uVar;
    }

    public Object c(T t10, kotlin.coroutines.c<? super Unit> cVar) {
        Object H = this.f32467a.H(t10, cVar);
        return H == b.d() ? H : Unit.f32013a;
    }
}
