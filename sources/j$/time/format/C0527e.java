package j$.time.format;

import j$.time.a;

/* renamed from: j$.time.format.e  reason: case insensitive filesystem */
final class C0527e implements C0529g {

    /* renamed from: a  reason: collision with root package name */
    private final char f42628a;

    C0527e(char c10) {
        this.f42628a = c10;
    }

    public final boolean b(A a10, StringBuilder sb2) {
        sb2.append(this.f42628a);
        return true;
    }

    public final int d(x xVar, CharSequence charSequence, int i10) {
        if (i10 == charSequence.length()) {
            return ~i10;
        }
        char charAt = charSequence.charAt(i10);
        return (charAt == this.f42628a || (!xVar.k() && (Character.toUpperCase(charAt) == Character.toUpperCase(this.f42628a) || Character.toLowerCase(charAt) == Character.toLowerCase(this.f42628a)))) ? i10 + 1 : ~i10;
    }

    public final String toString() {
        if (this.f42628a == '\'') {
            return "''";
        }
        StringBuilder a10 = a.a("'");
        a10.append(this.f42628a);
        a10.append("'");
        return a10.toString();
    }
}
