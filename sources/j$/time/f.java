package j$.time;

import com.coffeemeetsbagel.models.util.DateUtils;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;

public final class f implements Comparable, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final f f42588c = new f(0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final long f42589a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42590b;

    static {
        BigInteger.valueOf(1000000000);
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    private f(long j10, int i10) {
        this.f42589a = j10;
        this.f42590b = i10;
    }

    private static f b(long j10, int i10) {
        return (((long) i10) | j10) == 0 ? f42588c : new f(j10, i10);
    }

    public static f e(long j10) {
        long j11 = j10 / 1000000000;
        int i10 = (int) (j10 % 1000000000);
        if (i10 < 0) {
            i10 = (int) (((long) i10) + 1000000000);
            j11--;
        }
        return b(j11, i10);
    }

    public static f f() {
        return b(Math.addExact(Long.MAX_VALUE, Math.floorDiv(999999999, 1000000000)), (int) Math.floorMod(999999999, 1000000000));
    }

    public static f h(long j10) {
        return b(j10, 0);
    }

    public final int compareTo(Object obj) {
        f fVar = (f) obj;
        int compare = Long.compare(this.f42589a, fVar.f42589a);
        return compare != 0 ? compare : this.f42590b - fVar.f42590b;
    }

    public final long d() {
        return this.f42589a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f42589a == fVar.f42589a && this.f42590b == fVar.f42590b;
    }

    public final int hashCode() {
        long j10 = this.f42589a;
        return (this.f42590b * 51) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        if (this == f42588c) {
            return "PT0S";
        }
        long j10 = this.f42589a;
        long j11 = j10 / DateUtils.SEC_IN_HOUR;
        int i10 = (int) ((j10 % DateUtils.SEC_IN_HOUR) / 60);
        int i11 = (int) (j10 % 60);
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("PT");
        if (j11 != 0) {
            sb2.append(j11);
            sb2.append('H');
        }
        if (i10 != 0) {
            sb2.append(i10);
            sb2.append('M');
        }
        if (i11 == 0 && this.f42590b == 0 && sb2.length() > 2) {
            return sb2.toString();
        }
        if (i11 >= 0 || this.f42590b <= 0) {
            sb2.append(i11);
        } else if (i11 == -1) {
            sb2.append("-0");
        } else {
            sb2.append(i11 + 1);
        }
        if (this.f42590b > 0) {
            int length = sb2.length();
            sb2.append(i11 < 0 ? 2000000000 - ((long) this.f42590b) : ((long) this.f42590b) + 1000000000);
            while (sb2.charAt(sb2.length() - 1) == '0') {
                sb2.setLength(sb2.length() - 1);
            }
            sb2.setCharAt(length, '.');
        }
        sb2.append('S');
        return sb2.toString();
    }
}
