package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.c;
import kotlin.coroutines.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import zk.b;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JY\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\b\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\r8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", "R", "T", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "receiver", "completion", "", "b", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/c;)V", "", "c", "()Z", "isLazy$annotations", "()V", "isLazy", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32253a = null;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            iArr[CoroutineStart.LAZY.ordinal()] = 4;
            f32253a = iArr;
        }
    }

    public final <R, T> void b(Function2<? super R, ? super c<? super T>, ? extends Object> function2, R r10, c<? super T> cVar) {
        int i10 = a.f32253a[ordinal()];
        if (i10 == 1) {
            zk.a.e(function2, r10, cVar, (Function1) null, 4, (Object) null);
        } else if (i10 == 2) {
            e.a(function2, r10, cVar);
        } else if (i10 == 3) {
            b.a(function2, r10, cVar);
        } else if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean c() {
        return this == LAZY;
    }
}
