package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.e0;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u001e\u0010\u0010\u001a\u00020\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00040\u000eH'J\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00028\u0000H\u0017¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/channels/u;", "E", "", "element", "", "H", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/h;", "t", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "cause", "", "F", "Lkotlin/Function1;", "handler", "s", "offer", "(Ljava/lang/Object;)Z", "K", "()Z", "isClosedForSend$annotations", "()V", "isClosedForSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface u<E> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ boolean a(u uVar, Throwable th2, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    th2 = null;
                }
                return uVar.F(th2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }

        public static <E> boolean b(u<? super E> uVar, E e10) {
            Object t10 = uVar.t(e10);
            if (h.j(t10)) {
                return true;
            }
            Throwable e11 = h.e(t10);
            if (e11 == null) {
                return false;
            }
            throw e0.a(e11);
        }
    }

    boolean F(Throwable th2);

    Object H(E e10, c<? super Unit> cVar);

    boolean K();

    boolean offer(E e10);

    void s(Function1<? super Throwable, Unit> function1);

    Object t(E e10);
}
