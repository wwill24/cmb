package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.a;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* renamed from: j$.time.format.i  reason: case insensitive filesystem */
final class C0531i implements C0529g {
    C0531i() {
    }

    public final boolean b(A a10, StringBuilder sb2) {
        StringBuilder sb3 = sb2;
        Long e10 = a10.e(a.INSTANT_SECONDS);
        TemporalAccessor d10 = a10.d();
        a aVar = a.NANO_OF_SECOND;
        Long valueOf = d10.i(aVar) ? Long.valueOf(a10.d().j(aVar)) : null;
        int i10 = 0;
        if (e10 == null) {
            return false;
        }
        long longValue = e10.longValue();
        int j10 = aVar.j(valueOf != null ? valueOf.longValue() : 0);
        if (longValue >= -62167219200L) {
            long j11 = (longValue - 315569520000L) + 62167219200L;
            long floorDiv = Math.floorDiv(j11, 315569520000L) + 1;
            LocalDateTime x10 = LocalDateTime.x(Math.floorMod(j11, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
            if (floorDiv > 0) {
                sb3.append(SignatureVisitor.EXTENDS);
                sb3.append(floorDiv);
            }
            sb3.append(x10);
            if (x10.q() == 0) {
                sb3.append(":00");
            }
        } else {
            long j12 = longValue + 62167219200L;
            long j13 = j12 / 315569520000L;
            long j14 = j12 % 315569520000L;
            LocalDateTime x11 = LocalDateTime.x(j14 - 62167219200L, 0, ZoneOffset.UTC);
            int length = sb2.length();
            sb3.append(x11);
            if (x11.q() == 0) {
                sb3.append(":00");
            }
            if (j13 < 0) {
                if (x11.r() == -10000) {
                    sb3.replace(length, length + 2, Long.toString(j13 - 1));
                } else if (j14 == 0) {
                    sb3.insert(length, j13);
                } else {
                    sb3.insert(length + 1, Math.abs(j13));
                }
            }
        }
        if (j10 > 0) {
            sb3.append('.');
            int i11 = 100000000;
            while (true) {
                if (j10 <= 0 && i10 % 3 == 0 && i10 >= -2) {
                    break;
                }
                int i12 = j10 / i11;
                sb3.append((char) (i12 + 48));
                j10 -= i12 * i11;
                i11 /= 10;
                i10++;
            }
        }
        sb3.append(Matrix.MATRIX_TYPE_ZERO);
        return true;
    }

    public final int d(x xVar, CharSequence charSequence, int i10) {
        int i11;
        int i12;
        int i13 = i10;
        w wVar = new w();
        wVar.a(DateTimeFormatter.ISO_LOCAL_DATE);
        wVar.e('T');
        a aVar = a.HOUR_OF_DAY;
        wVar.l(aVar, 2);
        wVar.e(':');
        a aVar2 = a.MINUTE_OF_HOUR;
        wVar.l(aVar2, 2);
        wVar.e(':');
        a aVar3 = a.SECOND_OF_MINUTE;
        wVar.l(aVar3, 2);
        a aVar4 = a.NANO_OF_SECOND;
        int i14 = 0;
        wVar.b(aVar4, 0, 9, true);
        wVar.e(Matrix.MATRIX_TYPE_ZERO);
        C0528f h10 = wVar.t().h();
        x d10 = xVar.d();
        int d11 = h10.d(d10, charSequence, i13);
        if (d11 < 0) {
            return d11;
        }
        long longValue = d10.j(a.YEAR).longValue();
        int intValue = d10.j(a.MONTH_OF_YEAR).intValue();
        int intValue2 = d10.j(a.DAY_OF_MONTH).intValue();
        int intValue3 = d10.j(aVar).intValue();
        int intValue4 = d10.j(aVar2).intValue();
        Long j10 = d10.j(aVar3);
        Long j11 = d10.j(aVar4);
        int intValue5 = j10 != null ? j10.intValue() : 0;
        int intValue6 = j11 != null ? j11.intValue() : 0;
        if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
            i12 = 0;
            i11 = intValue5;
            i14 = 1;
        } else if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
            xVar.p();
            i12 = intValue3;
            i11 = 59;
        } else {
            i12 = intValue3;
            i11 = intValue5;
        }
        try {
            x xVar2 = xVar;
            int i15 = i10;
            return xVar2.o(aVar4, (long) intValue6, i15, xVar2.o(a.INSTANT_SECONDS, Math.multiplyExact(longValue / 10000, 315569520000L) + LocalDateTime.v(((int) longValue) % 10000, intValue, intValue2, i12, intValue4, i11, 0).z((long) i14).g(ZoneOffset.UTC), i15, d11));
        } catch (RuntimeException unused) {
            return ~i13;
        }
    }

    public final String toString() {
        return "Instant()";
    }
}
