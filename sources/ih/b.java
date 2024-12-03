package ih;

import jh.a;

final class b extends g {

    /* renamed from: c  reason: collision with root package name */
    private final int f23556c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23557d;

    b(g gVar, int i10, int i11) {
        super(gVar);
        this.f23556c = i10;
        this.f23557d = i11;
    }

    public void c(a aVar, byte[] bArr) {
        int i10 = this.f23557d;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 == 0 || (i11 == 31 && i10 <= 62)) {
                aVar.c(31, 5);
                if (i10 > 62) {
                    aVar.c(i10 - 31, 16);
                } else if (i11 == 0) {
                    aVar.c(Math.min(i10, 31), 5);
                } else {
                    aVar.c(i10 - 31, 5);
                }
            }
            aVar.c(bArr[this.f23556c + i11], 8);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append(this.f23556c);
        sb2.append("::");
        sb2.append((this.f23556c + this.f23557d) - 1);
        sb2.append('>');
        return sb2.toString();
    }
}
