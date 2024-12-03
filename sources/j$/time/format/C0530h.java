package j$.time.format;

import com.mparticle.kits.AppsFlyerKit;
import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.s;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import org.jivesoftware.smackx.xdata.FormField;

/* renamed from: j$.time.format.h  reason: case insensitive filesystem */
final class C0530h implements C0529g {

    /* renamed from: a  reason: collision with root package name */
    private final m f42631a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42632b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42633c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f42634d;

    C0530h(a aVar, int i10, int i11, boolean z10) {
        Objects.requireNonNull(aVar, FormField.ELEMENT);
        if (!aVar.e().f()) {
            throw new IllegalArgumentException("Field must have a fixed set of values: " + aVar);
        } else if (i10 < 0 || i10 > 9) {
            throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i10);
        } else if (i11 < 1 || i11 > 9) {
            throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i11);
        } else if (i11 >= i10) {
            this.f42631a = aVar;
            this.f42632b = i10;
            this.f42633c = i11;
            this.f42634d = z10;
        } else {
            throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i11 + " < " + i10);
        }
    }

    public final boolean b(A a10, StringBuilder sb2) {
        Long e10 = a10.e(this.f42631a);
        if (e10 == null) {
            return false;
        }
        D b10 = a10.b();
        long longValue = e10.longValue();
        s e11 = this.f42631a.e();
        e11.b(longValue, this.f42631a);
        BigDecimal valueOf = BigDecimal.valueOf(e11.e());
        BigDecimal divide = BigDecimal.valueOf(longValue).subtract(valueOf).divide(BigDecimal.valueOf(e11.d()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
        BigDecimal stripTrailingZeros = divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
        if (stripTrailingZeros.scale() != 0) {
            String substring = stripTrailingZeros.setScale(Math.min(Math.max(stripTrailingZeros.scale(), this.f42632b), this.f42633c), RoundingMode.FLOOR).toPlainString().substring(2);
            b10.getClass();
            if (this.f42634d) {
                sb2.append('.');
            }
            sb2.append(substring);
            return true;
        } else if (this.f42632b <= 0) {
            return true;
        } else {
            if (this.f42634d) {
                b10.getClass();
                sb2.append('.');
            }
            for (int i10 = 0; i10 < this.f42632b; i10++) {
                b10.getClass();
                sb2.append('0');
            }
            return true;
        }
    }

    public final int d(x xVar, CharSequence charSequence, int i10) {
        int i11;
        int i12 = xVar.l() ? this.f42632b : 0;
        int i13 = xVar.l() ? this.f42633c : 9;
        int length = charSequence.length();
        if (i10 == length) {
            return i12 > 0 ? ~i10 : i10;
        }
        if (this.f42634d) {
            char charAt = charSequence.charAt(i10);
            xVar.g().getClass();
            if (charAt != '.') {
                return i12 > 0 ? ~i10 : i10;
            }
            i10++;
        }
        int i14 = i10;
        int i15 = i12 + i14;
        if (i15 > length) {
            return ~i14;
        }
        int min = Math.min(i13 + i14, length);
        int i16 = 0;
        int i17 = i14;
        while (true) {
            if (i17 >= min) {
                i11 = i17;
                break;
            }
            int i18 = i17 + 1;
            int a10 = xVar.g().a(charSequence.charAt(i17));
            if (a10 >= 0) {
                i16 = (i16 * 10) + a10;
                i17 = i18;
            } else if (i18 < i15) {
                return ~i14;
            } else {
                i11 = i18 - 1;
            }
        }
        BigDecimal movePointLeft = new BigDecimal(i16).movePointLeft(i11 - i14);
        s e10 = this.f42631a.e();
        BigDecimal valueOf = BigDecimal.valueOf(e10.e());
        return xVar.o(this.f42631a, movePointLeft.multiply(BigDecimal.valueOf(e10.d()).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact(), i14, i11);
    }

    public final String toString() {
        String str = this.f42634d ? ",DecimalPoint" : "";
        StringBuilder a10 = j$.time.a.a("Fraction(");
        a10.append(this.f42631a);
        a10.append(AppsFlyerKit.COMMA);
        a10.append(this.f42632b);
        a10.append(AppsFlyerKit.COMMA);
        a10.append(this.f42633c);
        a10.append(str);
        a10.append(")");
        return a10.toString();
    }
}
