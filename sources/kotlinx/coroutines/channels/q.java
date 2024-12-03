package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.c;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0001\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0003J\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH¦\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH&R\u001a\u0010\u0014\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00158&X¦\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/channels/q;", "E", "", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/h;", "A", "z", "()Ljava/lang/Object;", "Lkotlinx/coroutines/channels/f;", "iterator", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "b", "", "j", "()Z", "isClosedForReceive$annotations", "()V", "isClosedForReceive", "Lkotlinx/coroutines/selects/c;", "u", "()Lkotlinx/coroutines/selects/c;", "onReceive", "w", "onReceiveCatching", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface q<E> {
    Object A(c<? super h<? extends E>> cVar);

    Object E(c<? super E> cVar);

    void b(CancellationException cancellationException);

    f<E> iterator();

    boolean j();

    kotlinx.coroutines.selects.c<E> u();

    kotlinx.coroutines.selects.c<h<E>> w();

    Object z();
}
