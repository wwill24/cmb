package j$.time.format;

import com.mparticle.kits.AppsFlyerKit;
import j$.time.a;
import j$.time.d;

final class m implements C0529g {

    /* renamed from: a  reason: collision with root package name */
    private final C0529g f42648a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42649b;

    /* renamed from: c  reason: collision with root package name */
    private final char f42650c;

    m(C0529g gVar, int i10, char c10) {
        this.f42648a = gVar;
        this.f42649b = i10;
        this.f42650c = c10;
    }

    public final boolean b(A a10, StringBuilder sb2) {
        int length = sb2.length();
        if (!this.f42648a.b(a10, sb2)) {
            return false;
        }
        int length2 = sb2.length() - length;
        if (length2 <= this.f42649b) {
            for (int i10 = 0; i10 < this.f42649b - length2; i10++) {
                sb2.insert(length, this.f42650c);
            }
            return true;
        }
        throw new d("Cannot print as output of " + length2 + " characters exceeds pad width of " + this.f42649b);
    }

    public final int d(x xVar, CharSequence charSequence, int i10) {
        boolean l10 = xVar.l();
        if (i10 > charSequence.length()) {
            throw new IndexOutOfBoundsException();
        } else if (i10 == charSequence.length()) {
            return ~i10;
        } else {
            int i11 = this.f42649b + i10;
            if (i11 > charSequence.length()) {
                if (l10) {
                    return ~i10;
                }
                i11 = charSequence.length();
            }
            int i12 = i10;
            while (i12 < i11 && xVar.b(charSequence.charAt(i12), this.f42650c)) {
                i12++;
            }
            int d10 = this.f42648a.d(xVar, charSequence.subSequence(0, i11), i12);
            return (d10 == i11 || !l10) ? d10 : ~(i10 + i12);
        }
    }

    public final String toString() {
        String str;
        StringBuilder a10 = a.a("Pad(");
        a10.append(this.f42648a);
        a10.append(AppsFlyerKit.COMMA);
        a10.append(this.f42649b);
        if (this.f42650c == ' ') {
            str = ")";
        } else {
            StringBuilder a11 = a.a(",'");
            a11.append(this.f42650c);
            a11.append("')");
            str = a11.toString();
        }
        a10.append(str);
        return a10.toString();
    }
}
