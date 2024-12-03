package ih;

import jh.a;

abstract class g {

    /* renamed from: b  reason: collision with root package name */
    static final g f23574b = new e((g) null, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final g f23575a;

    g(g gVar) {
        this.f23575a = gVar;
    }

    /* access modifiers changed from: package-private */
    public final g a(int i10, int i11) {
        return new e(this, i10, i11);
    }

    /* access modifiers changed from: package-private */
    public final g b(int i10, int i11) {
        return new b(this, i10, i11);
    }

    /* access modifiers changed from: package-private */
    public abstract void c(a aVar, byte[] bArr);

    /* access modifiers changed from: package-private */
    public final g d() {
        return this.f23575a;
    }
}
