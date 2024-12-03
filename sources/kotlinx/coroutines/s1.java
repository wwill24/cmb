package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 !2\u00020\u0001:\u0001\tJ\f\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'J\b\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH'J\u0013\u0010\u000e\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0015\u001a\u00020\u00142\u0018\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\b0\u0010j\u0002`\u0012H&J6\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\u0018\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\b0\u0010j\u0002`\u0012H'R\u0014\u0010\u001b\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00000\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lkotlinx/coroutines/s1;", "Lkotlin/coroutines/CoroutineContext$Element;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "n", "", "start", "cause", "", "b", "Lkotlinx/coroutines/v;", "child", "Lkotlinx/coroutines/t;", "A0", "r0", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/z0;", "y", "onCancelling", "invokeImmediately", "m", "a", "()Z", "isActive", "isCancelled", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "v", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface s1 extends CoroutineContext.Element {

    /* renamed from: v  reason: collision with root package name */
    public static final b f32618v = b.f32619a;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(s1 s1Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    cancellationException = null;
                }
                s1Var.b(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R b(s1 s1Var, R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return CoroutineContext.Element.a.a(s1Var, r10, function2);
        }

        public static <E extends CoroutineContext.Element> E c(s1 s1Var, CoroutineContext.a<E> aVar) {
            return CoroutineContext.Element.a.b(s1Var, aVar);
        }

        public static /* synthetic */ z0 d(s1 s1Var, boolean z10, boolean z11, Function1 function1, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    z10 = false;
                }
                if ((i10 & 2) != 0) {
                    z11 = true;
                }
                return s1Var.m(z10, z11, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static CoroutineContext e(s1 s1Var, CoroutineContext.a<?> aVar) {
            return CoroutineContext.Element.a.c(s1Var, aVar);
        }

        public static CoroutineContext f(s1 s1Var, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.a.d(s1Var, coroutineContext);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/s1$b;", "Lkotlin/coroutines/CoroutineContext$a;", "Lkotlinx/coroutines/s1;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class b implements CoroutineContext.a<s1> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f32619a = new b();

        private b() {
        }
    }

    t A0(v vVar);

    boolean a();

    void b(CancellationException cancellationException);

    Sequence<s1> getChildren();

    boolean isCancelled();

    z0 m(boolean z10, boolean z11, Function1<? super Throwable, Unit> function1);

    CancellationException n();

    Object r0(c<? super Unit> cVar);

    boolean start();

    z0 y(Function1<? super Throwable, Unit> function1);
}
