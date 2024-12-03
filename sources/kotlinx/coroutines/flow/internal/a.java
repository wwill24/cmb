package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.internal.c;
import kotlinx.coroutines.flow.r;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b(\u0010\u0017J\u000f\u0010\u0005\u001a\u00028\u0000H$¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t2\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000f\u0010\u0010R>\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t2\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t8\u0004@BX\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00078\u0004@BX\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070$8F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lkotlinx/coroutines/flow/internal/a;", "Lkotlinx/coroutines/flow/internal/c;", "S", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "j", "()Lkotlinx/coroutines/flow/internal/c;", "", "size", "", "k", "(I)[Lkotlinx/coroutines/flow/internal/c;", "i", "slot", "", "l", "(Lkotlinx/coroutines/flow/internal/c;)V", "<set-?>", "a", "[Lkotlinx/coroutines/flow/internal/c;", "n", "()[Lkotlinx/coroutines/flow/internal/c;", "getSlots$annotations", "()V", "slots", "b", "I", "m", "()I", "nCollectors", "c", "nextIndex", "Lkotlinx/coroutines/flow/internal/o;", "d", "Lkotlinx/coroutines/flow/internal/o;", "_subscriptionCount", "Lkotlinx/coroutines/flow/r;", "f", "()Lkotlinx/coroutines/flow/r;", "subscriptionCount", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class a<S extends c<?>> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public S[] f32454a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f32455b;

    /* renamed from: c  reason: collision with root package name */
    private int f32456c;

    /* renamed from: d  reason: collision with root package name */
    private o f32457d;

    public final r<Integer> f() {
        o oVar;
        synchronized (this) {
            oVar = this.f32457d;
            if (oVar == null) {
                oVar = new o(this.f32455b);
                this.f32457d = oVar;
            }
        }
        return oVar;
    }

    /* access modifiers changed from: protected */
    public final S i() {
        S s10;
        o oVar;
        synchronized (this) {
            S[] sArr = this.f32454a;
            if (sArr == null) {
                sArr = k(2);
                this.f32454a = sArr;
            } else if (this.f32455b >= sArr.length) {
                S[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                j.f(copyOf, "copyOf(this, newSize)");
                this.f32454a = (c[]) copyOf;
                sArr = (c[]) copyOf;
            }
            int i10 = this.f32456c;
            do {
                s10 = sArr[i10];
                if (s10 == null) {
                    s10 = j();
                    sArr[i10] = s10;
                }
                i10++;
                if (i10 >= sArr.length) {
                    i10 = 0;
                }
            } while (!s10.a(this));
            this.f32456c = i10;
            this.f32455b++;
            oVar = this.f32457d;
        }
        if (oVar != null) {
            oVar.a0(1);
        }
        return s10;
    }

    /* access modifiers changed from: protected */
    public abstract S j();

    /* access modifiers changed from: protected */
    public abstract S[] k(int i10);

    /* access modifiers changed from: protected */
    public final void l(S s10) {
        o oVar;
        int i10;
        kotlin.coroutines.c[] b10;
        synchronized (this) {
            int i11 = this.f32455b - 1;
            this.f32455b = i11;
            oVar = this.f32457d;
            if (i11 == 0) {
                this.f32456c = 0;
            }
            b10 = s10.b(this);
        }
        for (kotlin.coroutines.c cVar : b10) {
            if (cVar != null) {
                Result.a aVar = Result.f32010a;
                cVar.resumeWith(Result.b(Unit.f32013a));
            }
        }
        if (oVar != null) {
            oVar.a0(-1);
        }
    }

    /* access modifiers changed from: protected */
    public final int m() {
        return this.f32455b;
    }

    /* access modifiers changed from: protected */
    public final S[] n() {
        return this.f32454a;
    }
}
