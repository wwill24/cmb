package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlinx.coroutines.internal.b0;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0002 \u0000*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000f\u0010\t\u001a\u00020\bH\u0010¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/u2;", "U", "T", "Lkotlinx/coroutines/internal/b0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "run", "", "H0", "()Ljava/lang/String;", "", "d", "J", "time", "Lkotlin/coroutines/c;", "uCont", "<init>", "(JLkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class u2<U, T extends U> extends b0<T> implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    public final long f32730d;

    public u2(long j10, c<? super U> cVar) {
        super(cVar.getContext(), cVar);
        this.f32730d = j10;
    }

    public String H0() {
        return super.H0() + "(timeMillis=" + this.f32730d + PropertyUtils.MAPPED_DELIM2;
    }

    public void run() {
        W(v2.a(this.f32730d, this));
    }
}
