package j$.time.format;

import com.mparticle.kits.AppsFlyerKit;
import j$.time.LocalDate;
import j$.time.a;
import j$.time.chrono.b;
import j$.time.chrono.f;
import j$.time.chrono.g;
import j$.time.temporal.m;

final class q extends k {

    /* renamed from: i  reason: collision with root package name */
    static final LocalDate f42661i = LocalDate.w(2000, 1, 1);

    /* renamed from: g  reason: collision with root package name */
    private final int f42662g;

    /* renamed from: h  reason: collision with root package name */
    private final b f42663h;

    private q(m mVar, int i10, int i11, int i12, b bVar, int i13) {
        super(mVar, i10, i11, 4, i13);
        this.f42662g = i12;
        this.f42663h = bVar;
    }

    q(m mVar, LocalDate localDate) {
        this(mVar, 2, 2, 0, localDate, 0);
    }

    /* synthetic */ q(m mVar, LocalDate localDate, int i10) {
        this(mVar, 2, 2, 0, localDate, 0);
    }

    /* access modifiers changed from: package-private */
    public final long c(A a10, long j10) {
        long abs = Math.abs(j10);
        int i10 = this.f42662g;
        if (this.f42663h != null) {
            f c10 = f.c(a10.d());
            b bVar = this.f42663h;
            ((g) c10).getClass();
            i10 = LocalDate.o(bVar).a(this.f42638a);
        }
        long j11 = (long) i10;
        if (j10 >= j11) {
            long j12 = k.f42637f[this.f42639b];
            if (j10 < j11 + j12) {
                return abs % j12;
            }
        }
        return abs % k.f42637f[this.f42640c];
    }

    /* access modifiers changed from: package-private */
    public final boolean e(x xVar) {
        if (!xVar.l()) {
            return false;
        }
        return super.e(xVar);
    }

    /* access modifiers changed from: package-private */
    public final int f(x xVar, long j10, int i10, int i11) {
        int i12 = this.f42662g;
        if (this.f42663h != null) {
            f h10 = xVar.h();
            b bVar = this.f42663h;
            ((g) h10).getClass();
            i12 = LocalDate.o(bVar).a(this.f42638a);
            xVar.a(new p(this, xVar, j10, i10, i11));
        }
        int i13 = i11 - i10;
        int i14 = this.f42639b;
        if (i13 == i14 && j10 >= 0) {
            long j11 = k.f42637f[i14];
            long j12 = (long) i12;
            long j13 = j12 - (j12 % j11);
            j10 = i12 > 0 ? j13 + j10 : j13 - j10;
            if (j10 < j12) {
                j10 += j11;
            }
        }
        return xVar.o(this.f42638a, j10, i10, i11);
    }

    /* access modifiers changed from: package-private */
    public final k g() {
        return this.f42642e == -1 ? this : new q(this.f42638a, this.f42639b, this.f42640c, this.f42662g, this.f42663h, -1);
    }

    /* access modifiers changed from: package-private */
    public final k h(int i10) {
        return new q(this.f42638a, this.f42639b, this.f42640c, this.f42662g, this.f42663h, this.f42642e + i10);
    }

    public final String toString() {
        StringBuilder a10 = a.a("ReducedValue(");
        a10.append(this.f42638a);
        a10.append(AppsFlyerKit.COMMA);
        a10.append(this.f42639b);
        a10.append(AppsFlyerKit.COMMA);
        a10.append(this.f42640c);
        a10.append(AppsFlyerKit.COMMA);
        Object obj = this.f42663h;
        if (obj == null) {
            obj = Integer.valueOf(this.f42662g);
        }
        a10.append(obj);
        a10.append(")");
        return a10.toString();
    }
}
