package ih;

import jh.a;

final class e extends g {

    /* renamed from: c  reason: collision with root package name */
    private final short f23566c;

    /* renamed from: d  reason: collision with root package name */
    private final short f23567d;

    e(g gVar, int i10, int i11) {
        super(gVar);
        this.f23566c = (short) i10;
        this.f23567d = (short) i11;
    }

    /* access modifiers changed from: package-private */
    public void c(a aVar, byte[] bArr) {
        aVar.c(this.f23566c, this.f23567d);
    }

    public String toString() {
        short s10 = this.f23566c;
        short s11 = this.f23567d;
        short s12 = (s10 & ((1 << s11) - 1)) | (1 << s11);
        return '<' + Integer.toBinaryString(s12 | (1 << this.f23567d)).substring(1) + '>';
    }
}
