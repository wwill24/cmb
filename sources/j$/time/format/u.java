package j$.time.format;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.d;
import j$.time.temporal.a;
import j$.time.temporal.p;
import j$.time.zone.g;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.HashSet;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

class u implements C0529g {

    /* renamed from: c  reason: collision with root package name */
    private static volatile AbstractMap.SimpleImmutableEntry f42671c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile AbstractMap.SimpleImmutableEntry f42672d;

    /* renamed from: a  reason: collision with root package name */
    private final p f42673a;

    /* renamed from: b  reason: collision with root package name */
    private final String f42674b;

    u(p pVar, String str) {
        this.f42673a = pVar;
        this.f42674b = str;
    }

    private static int c(x xVar, CharSequence charSequence, int i10, int i11, l lVar) {
        String upperCase = charSequence.toString().substring(i10, i11).toUpperCase();
        if (i11 < charSequence.length() && charSequence.charAt(i11) != '0' && !xVar.b(charSequence.charAt(i11), Matrix.MATRIX_TYPE_ZERO)) {
            x d10 = xVar.d();
            int d11 = lVar.d(d10, charSequence, i11);
            if (d11 < 0) {
                try {
                    if (lVar == l.f42644d) {
                        return ~i10;
                    }
                    xVar.n(ZoneId.of(upperCase));
                    return i11;
                } catch (d unused) {
                    return ~i10;
                }
            } else {
                xVar.n(ZoneId.p(upperCase, ZoneOffset.u((int) d10.j(a.OFFSET_SECONDS).longValue())));
                return d11;
            }
        } else {
            xVar.n(ZoneId.of(upperCase));
            return i11;
        }
    }

    /* access modifiers changed from: protected */
    public o a(x xVar) {
        HashSet a10 = g.a();
        int size = a10.size();
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = xVar.k() ? f42671c : f42672d;
        if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
            synchronized (this) {
                try {
                    AbstractMap.SimpleImmutableEntry simpleImmutableEntry2 = xVar.k() ? f42671c : f42672d;
                    if (simpleImmutableEntry2 == null || ((Integer) simpleImmutableEntry2.getKey()).intValue() != size) {
                        simpleImmutableEntry2 = new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), o.g(a10, xVar));
                        if (xVar.k()) {
                            f42671c = simpleImmutableEntry2;
                        } else {
                            f42672d = simpleImmutableEntry2;
                        }
                    }
                } catch (Throwable th2) {
                    while (true) {
                        throw th2;
                    }
                }
            }
        }
        return (o) simpleImmutableEntry.getValue();
    }

    public boolean b(A a10, StringBuilder sb2) {
        ZoneId zoneId = (ZoneId) a10.f(this.f42673a);
        if (zoneId == null) {
            return false;
        }
        sb2.append(zoneId.n());
        return true;
    }

    public final int d(x xVar, CharSequence charSequence, int i10) {
        int i11;
        int length = charSequence.length();
        if (i10 > length) {
            throw new IndexOutOfBoundsException();
        } else if (i10 == length) {
            return ~i10;
        } else {
            char charAt = charSequence.charAt(i10);
            if (charAt == '+' || charAt == '-') {
                return c(xVar, charSequence, i10, i10, l.f42644d);
            }
            int i12 = i10 + 2;
            if (length >= i12) {
                char charAt2 = charSequence.charAt(i10 + 1);
                if (xVar.b(charAt, Matrix.MATRIX_TYPE_RANDOM_UT) && xVar.b(charAt2, 'T')) {
                    int i13 = i10 + 3;
                    return (length < i13 || !xVar.b(charSequence.charAt(i12), 'C')) ? c(xVar, charSequence, i10, i12, l.f42645e) : c(xVar, charSequence, i10, i13, l.f42645e);
                } else if (xVar.b(charAt, 'G') && length >= (i11 = i10 + 3) && xVar.b(charAt2, 'M') && xVar.b(charSequence.charAt(i12), 'T')) {
                    return c(xVar, charSequence, i10, i11, l.f42645e);
                }
            }
            o a10 = a(xVar);
            ParsePosition parsePosition = new ParsePosition(i10);
            String d10 = a10.d(charSequence, parsePosition);
            if (d10 != null) {
                xVar.n(ZoneId.of(d10));
                return parsePosition.getIndex();
            } else if (!xVar.b(charAt, Matrix.MATRIX_TYPE_ZERO)) {
                return ~i10;
            } else {
                xVar.n(ZoneOffset.UTC);
                return i10 + 1;
            }
        }
    }

    public final String toString() {
        return this.f42674b;
    }
}
