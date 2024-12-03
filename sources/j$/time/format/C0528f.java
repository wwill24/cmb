package j$.time.format;

import java.util.ArrayList;

/* renamed from: j$.time.format.f  reason: case insensitive filesystem */
final class C0528f implements C0529g {

    /* renamed from: a  reason: collision with root package name */
    private final C0529g[] f42629a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f42630b;

    C0528f(ArrayList arrayList, boolean z10) {
        this((C0529g[]) arrayList.toArray(new C0529g[arrayList.size()]), z10);
    }

    C0528f(C0529g[] gVarArr, boolean z10) {
        this.f42629a = gVarArr;
        this.f42630b = z10;
    }

    public final C0528f a() {
        return !this.f42630b ? this : new C0528f(this.f42629a, false);
    }

    public final boolean b(A a10, StringBuilder sb2) {
        int length = sb2.length();
        if (this.f42630b) {
            a10.g();
        }
        try {
            for (C0529g b10 : this.f42629a) {
                if (!b10.b(a10, sb2)) {
                    sb2.setLength(length);
                    return true;
                }
            }
            if (this.f42630b) {
                a10.a();
            }
            return true;
        } finally {
            if (this.f42630b) {
                a10.a();
            }
        }
    }

    public final int d(x xVar, CharSequence charSequence, int i10) {
        if (this.f42630b) {
            xVar.r();
            int i11 = i10;
            for (C0529g d10 : this.f42629a) {
                i11 = d10.d(xVar, charSequence, i11);
                if (i11 < 0) {
                    xVar.f(false);
                    return i10;
                }
            }
            xVar.f(true);
            return i11;
        }
        for (C0529g d11 : this.f42629a) {
            i10 = d11.d(xVar, charSequence, i10);
            if (i10 < 0) {
                break;
            }
        }
        return i10;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f42629a != null) {
            sb2.append(this.f42630b ? "[" : "(");
            for (C0529g append : this.f42629a) {
                sb2.append(append);
            }
            sb2.append(this.f42630b ? "]" : ")");
        }
        return sb2.toString();
    }
}
