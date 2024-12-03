package ih;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import jh.a;

final class f {

    /* renamed from: f  reason: collision with root package name */
    static final f f23568f = new f(g.f23574b, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final int f23569a;

    /* renamed from: b  reason: collision with root package name */
    private final g f23570b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23571c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23572d;

    /* renamed from: e  reason: collision with root package name */
    private final int f23573e;

    private f(g gVar, int i10, int i11, int i12) {
        this.f23570b = gVar;
        this.f23569a = i10;
        this.f23571c = i11;
        this.f23572d = i12;
        this.f23573e = c(i11);
    }

    private static int c(int i10) {
        if (i10 > 62) {
            return 21;
        }
        if (i10 > 31) {
            return 20;
        }
        return i10 > 0 ? 10 : 0;
    }

    /* access modifiers changed from: package-private */
    public f a(int i10) {
        int i11;
        g gVar = this.f23570b;
        int i12 = this.f23569a;
        int i13 = this.f23572d;
        if (i12 == 4 || i12 == 2) {
            int i14 = d.f23560d[i12][0];
            int i15 = 65535 & i14;
            int i16 = i14 >> 16;
            gVar = gVar.a(i15, i16);
            i13 += i16;
            i12 = 0;
        }
        int i17 = this.f23571c;
        if (i17 == 0 || i17 == 31) {
            i11 = 18;
        } else if (i17 == 62) {
            i11 = 9;
        } else {
            i11 = 8;
        }
        f fVar = new f(gVar, i12, i17 + 1, i13 + i11);
        if (fVar.f23571c == 2078) {
            return fVar.d(i10 + 1);
        }
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public f b(int i10) {
        g gVar;
        g gVar2 = j(4, 0).f23570b;
        int i11 = 3;
        if (i10 < 0) {
            gVar = gVar2.a(0, 3);
        } else if (i10 <= 999999) {
            byte[] bytes = Integer.toString(i10).getBytes(StandardCharsets.ISO_8859_1);
            g a10 = gVar2.a(bytes.length, 3);
            int length = bytes.length;
            for (int i12 = 0; i12 < length; i12++) {
                a10 = a10.a((bytes[i12] - 48) + 2, 4);
            }
            i11 = 3 + (bytes.length * 4);
            gVar = a10;
        } else {
            throw new IllegalArgumentException("ECI code must be between 0 and 999999");
        }
        return new f(gVar, this.f23569a, 0, this.f23572d + i11);
    }

    /* access modifiers changed from: package-private */
    public f d(int i10) {
        int i11 = this.f23571c;
        if (i11 == 0) {
            return this;
        }
        return new f(this.f23570b.b(i10 - i11, i11), this.f23569a, 0, this.f23572d);
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f23571c;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f23572d;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f23569a;
    }

    /* access modifiers changed from: package-private */
    public boolean h(f fVar) {
        int i10 = this.f23572d + (d.f23560d[this.f23569a][fVar.f23569a] >> 16);
        int i11 = this.f23571c;
        int i12 = fVar.f23571c;
        if (i11 < i12) {
            i10 += fVar.f23573e - this.f23573e;
        } else if (i11 > i12 && i12 > 0) {
            i10 += 10;
        }
        if (i10 <= fVar.f23572d) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public f i(int i10, int i11) {
        int i12;
        int i13 = this.f23572d;
        g gVar = this.f23570b;
        int i14 = this.f23569a;
        if (i10 != i14) {
            int i15 = d.f23560d[i14][i10];
            int i16 = 65535 & i15;
            int i17 = i15 >> 16;
            gVar = gVar.a(i16, i17);
            i13 += i17;
        }
        if (i10 == 2) {
            i12 = 4;
        } else {
            i12 = 5;
        }
        return new f(gVar.a(i11, i12), i10, 0, i13 + i12);
    }

    /* access modifiers changed from: package-private */
    public f j(int i10, int i11) {
        int i12;
        g gVar = this.f23570b;
        int i13 = this.f23569a;
        if (i13 == 2) {
            i12 = 4;
        } else {
            i12 = 5;
        }
        return new f(gVar.a(d.f23562f[i13][i10], i12).a(i11, 5), this.f23569a, 0, this.f23572d + i12 + 5);
    }

    /* access modifiers changed from: package-private */
    public a k(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        for (g gVar = d(bArr.length).f23570b; gVar != null; gVar = gVar.d()) {
            arrayList.add(gVar);
        }
        a aVar = new a();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((g) arrayList.get(size)).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{d.f23559c[this.f23569a], Integer.valueOf(this.f23572d), Integer.valueOf(this.f23571c)});
    }
}
