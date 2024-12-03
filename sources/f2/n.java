package f2;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import d2.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BS\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0002\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000e\u0010\u0006R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0018"}, d2 = {"Lf2/n;", "", "Lf2/h;", "", "a", "Lf2/h;", "()Lf2/h;", "batteryChargingTracker", "Lf2/c;", "b", "Lf2/c;", "()Lf2/c;", "batteryNotLowTracker", "Ld2/b;", "c", "networkStateTracker", "d", "storageNotLowTracker", "Landroid/content/Context;", "context", "Li2/b;", "taskExecutor", "<init>", "(Landroid/content/Context;Li2/b;Lf2/h;Lf2/c;Lf2/h;Lf2/h;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final h<Boolean> f14659a;

    /* renamed from: b  reason: collision with root package name */
    private final c f14660b;

    /* renamed from: c  reason: collision with root package name */
    private final h<b> f14661c;

    /* renamed from: d  reason: collision with root package name */
    private final h<Boolean> f14662d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public n(Context context, i2.b bVar) {
        this(context, bVar, (h) null, (c) null, (h) null, (h) null, 60, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(bVar, "taskExecutor");
    }

    public n(Context context, i2.b bVar, h<Boolean> hVar, c cVar, h<b> hVar2, h<Boolean> hVar3) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(bVar, "taskExecutor");
        j.g(hVar, "batteryChargingTracker");
        j.g(cVar, "batteryNotLowTracker");
        j.g(hVar2, "networkStateTracker");
        j.g(hVar3, "storageNotLowTracker");
        this.f14659a = hVar;
        this.f14660b = cVar;
        this.f14661c = hVar2;
        this.f14662d = hVar3;
    }

    public final h<Boolean> a() {
        return this.f14659a;
    }

    public final c b() {
        return this.f14660b;
    }

    public final h<b> c() {
        return this.f14661c;
    }

    public final h<Boolean> d() {
        return this.f14662d;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ n(android.content.Context r8, i2.b r9, f2.h r10, f2.c r11, f2.h r12, f2.h r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r0 = r14 & 4
            java.lang.String r1 = "context.applicationContext"
            if (r0 == 0) goto L_0x0014
            f2.a r0 = new f2.a
            android.content.Context r3 = r8.getApplicationContext()
            kotlin.jvm.internal.j.f(r3, r1)
            r0.<init>(r3, r9)
            r3 = r0
            goto L_0x0015
        L_0x0014:
            r3 = r10
        L_0x0015:
            r0 = r14 & 8
            if (r0 == 0) goto L_0x0027
            f2.c r0 = new f2.c
            android.content.Context r4 = r8.getApplicationContext()
            kotlin.jvm.internal.j.f(r4, r1)
            r0.<init>(r4, r9)
            r4 = r0
            goto L_0x0028
        L_0x0027:
            r4 = r11
        L_0x0028:
            r0 = r14 & 16
            if (r0 == 0) goto L_0x0039
            android.content.Context r0 = r8.getApplicationContext()
            kotlin.jvm.internal.j.f(r0, r1)
            f2.h r0 = f2.k.a(r0, r9)
            r5 = r0
            goto L_0x003a
        L_0x0039:
            r5 = r12
        L_0x003a:
            r0 = r14 & 32
            if (r0 == 0) goto L_0x004c
            f2.l r0 = new f2.l
            android.content.Context r6 = r8.getApplicationContext()
            kotlin.jvm.internal.j.f(r6, r1)
            r0.<init>(r6, r9)
            r6 = r0
            goto L_0x004d
        L_0x004c:
            r6 = r13
        L_0x004d:
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.n.<init>(android.content.Context, i2.b, f2.h, f2.c, f2.h, f2.h, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
