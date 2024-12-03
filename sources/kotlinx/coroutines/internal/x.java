package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.n;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.z0;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0016J\u001e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u0004\u0018\u00010\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lkotlinx/coroutines/internal/x;", "Lkotlinx/coroutines/c2;", "Lkotlinx/coroutines/r0;", "", "i0", "Lkotlin/coroutines/CoroutineContext;", "context", "", "O", "", "parallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "S", "", "timeMillis", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/z0;", "u", "f0", "Lkotlinx/coroutines/n;", "", "continuation", "m0", "", "toString", "", "c", "Ljava/lang/Throwable;", "cause", "d", "Ljava/lang/String;", "errorHint", "Y", "()Lkotlinx/coroutines/c2;", "immediate", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class x extends c2 implements r0 {

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f32570c;

    /* renamed from: d  reason: collision with root package name */
    private final String f32571d;

    public x(Throwable th2, String str) {
        this.f32570c = th2;
        this.f32571d = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Void i0() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f32570c
            if (r0 == 0) goto L_0x0036
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f32571d
            if (r1 == 0) goto L_0x0025
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L_0x0027
        L_0x0025:
            java.lang.String r1 = ""
        L_0x0027:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f32570c
            r1.<init>(r0, r2)
            throw r1
        L_0x0036:
            kotlinx.coroutines.internal.w.d()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.x.i0():java.lang.Void");
    }

    public boolean O(CoroutineContext coroutineContext) {
        i0();
        throw new KotlinNothingValueException();
    }

    public CoroutineDispatcher S(int i10) {
        i0();
        throw new KotlinNothingValueException();
    }

    public c2 Y() {
        return this;
    }

    /* renamed from: f0 */
    public Void E(CoroutineContext coroutineContext, Runnable runnable) {
        i0();
        throw new KotlinNothingValueException();
    }

    /* renamed from: m0 */
    public Void k(long j10, n<? super Unit> nVar) {
        i0();
        throw new KotlinNothingValueException();
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Dispatchers.Main[missing");
        if (this.f32570c != null) {
            str = ", cause=" + this.f32570c;
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        return sb2.toString();
    }

    public z0 u(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        i0();
        throw new KotlinNothingValueException();
    }
}
