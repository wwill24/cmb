package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J%\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH'¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\tH'J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004H'J\u0014\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tH&J\"\u0010\u0017\u001a\u00020\n2\u0018\u0010\u0016\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u0015H&J\u001b\u0010\u0019\u001a\u00020\n*\u00020\u00182\u0006\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u00002\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH'¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lkotlinx/coroutines/n;", "T", "Lkotlin/coroutines/c;", "value", "", "idempotent", "d", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "", "onCancellation", "B", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "p", "token", "M", "cause", "", "r", "Lkotlinx/coroutines/CompletionHandler;", "handler", "o", "Lkotlinx/coroutines/CoroutineDispatcher;", "D", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "q", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "a", "()Z", "isActive", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface n<T> extends c<T> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ boolean a(n nVar, Throwable th2, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    th2 = null;
                }
                return nVar.r(th2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ Object b(n nVar, Object obj, Object obj2, int i10, Object obj3) {
            if (obj3 == null) {
                if ((i10 & 2) != 0) {
                    obj2 = null;
                }
                return nVar.d(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    Object B(T t10, Object obj, Function1<? super Throwable, Unit> function1);

    void D(CoroutineDispatcher coroutineDispatcher, T t10);

    void M(Object obj);

    boolean a();

    Object d(T t10, Object obj);

    void o(Function1<? super Throwable, Unit> function1);

    Object p(Throwable th2);

    void q(T t10, Function1<? super Throwable, Unit> function1);

    boolean r(Throwable th2);
}
