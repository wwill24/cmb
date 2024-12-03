package yk;

import com.mparticle.kits.MPSideloadedKit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.time.DurationUnit;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.beanutils.PropertyUtils;
import vk.g;

public final class a implements Comparable<a> {

    /* renamed from: b  reason: collision with root package name */
    public static final C0403a f33993b = new C0403a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final long f33994c = h(0);

    /* renamed from: d  reason: collision with root package name */
    private static final long f33995d = c.i(4611686018427387903L);

    /* renamed from: e  reason: collision with root package name */
    private static final long f33996e = c.i(-4611686018427387903L);

    /* renamed from: a  reason: collision with root package name */
    private final long f33997a;

    /* renamed from: yk.a$a  reason: collision with other inner class name */
    public static final class C0403a {
        private C0403a() {
        }

        public /* synthetic */ C0403a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ a(long j10) {
        this.f33997a = j10;
    }

    private static final boolean A(long j10) {
        return (((int) j10) & 1) == 0;
    }

    public static final boolean B(long j10) {
        return j10 == f33995d || j10 == f33996e;
    }

    public static final boolean C(long j10) {
        return j10 < 0;
    }

    public static final boolean D(long j10) {
        return j10 > 0;
    }

    public static final long G(long j10, long j11) {
        return H(j10, K(j11));
    }

    public static final long H(long j10, long j11) {
        if (B(j10)) {
            if (y(j11) || (j11 ^ j10) >= 0) {
                return j10;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (B(j11)) {
            return j11;
        } else {
            if ((((int) j10) & 1) == (((int) j11) & 1)) {
                long w10 = w(j10) + w(j11);
                if (A(j10)) {
                    return c.l(w10);
                }
                return c.j(w10);
            } else if (z(j10)) {
                return a(j10, w(j10), w(j11));
            } else {
                return a(j10, w(j11), w(j10));
            }
        }
    }

    public static final long I(long j10, DurationUnit durationUnit) {
        j.g(durationUnit, "unit");
        if (j10 == f33995d) {
            return Long.MAX_VALUE;
        }
        if (j10 == f33996e) {
            return Long.MIN_VALUE;
        }
        return d.a(w(j10), v(j10), durationUnit);
    }

    public static String J(long j10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (j10 == 0) {
            return "0s";
        }
        if (j10 == f33995d) {
            return "Infinity";
        }
        if (j10 == f33996e) {
            return "-Infinity";
        }
        boolean C = C(j10);
        StringBuilder sb2 = new StringBuilder();
        if (C) {
            sb2.append(SignatureVisitor.SUPER);
        }
        long j11 = j(j10);
        long l10 = l(j11);
        int k10 = k(j11);
        int r10 = r(j11);
        int t10 = t(j11);
        int s10 = s(j11);
        int i10 = 0;
        if (l10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (k10 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (r10 != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (t10 == 0 && s10 == 0) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z10) {
            sb2.append(l10);
            sb2.append(Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL);
            i10 = 1;
        }
        if (z11 || (z10 && (z12 || z13))) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            sb2.append(k10);
            sb2.append('h');
            i10 = i11;
        }
        if (z12 || (z13 && (z11 || z10))) {
            int i12 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            sb2.append(r10);
            sb2.append(Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL);
            i10 = i12;
        }
        if (z13) {
            int i13 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            if (t10 != 0 || z10 || z11 || z12) {
                b(j10, sb2, t10, s10, 9, "s", false);
            } else if (s10 >= 1000000) {
                b(j10, sb2, s10 / MPSideloadedKit.MIN_SIDELOADED_KIT, s10 % MPSideloadedKit.MIN_SIDELOADED_KIT, 6, "ms", false);
            } else if (s10 >= 1000) {
                b(j10, sb2, s10 / 1000, s10 % 1000, 3, "us", false);
            } else {
                sb2.append(s10);
                sb2.append("ns");
            }
            i10 = i13;
        }
        if (C && i10 > 1) {
            sb2.insert(1, PropertyUtils.MAPPED_DELIM).append(PropertyUtils.MAPPED_DELIM2);
        }
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public static final long K(long j10) {
        return c.h(-w(j10), ((int) j10) & 1);
    }

    private static final long a(long j10, long j11, long j12) {
        long g10 = c.n(j12);
        long j13 = j11 + g10;
        if (!new g(-4611686018426L, 4611686018426L).g(j13)) {
            return c.i(j.k(j13, -4611686018427387903L, 4611686018427387903L));
        }
        return c.k(c.m(j13) + (j12 - c.m(g10)));
    }

    private static final void b(long j10, StringBuilder sb2, int i10, int i11, int i12, String str, boolean z10) {
        boolean z11;
        sb2.append(i10);
        if (i11 != 0) {
            sb2.append('.');
            String o02 = StringsKt__StringsKt.o0(String.valueOf(i11), i12, '0');
            int i13 = -1;
            int length = o02.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i14 = length - 1;
                    if (o02.charAt(length) != '0') {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        i13 = length;
                        break;
                    } else if (i14 < 0) {
                        break;
                    } else {
                        length = i14;
                    }
                }
            }
            int i15 = i13 + 1;
            if (z10 || i15 >= 3) {
                sb2.append(o02, 0, ((i15 + 2) / 3) * 3);
                j.f(sb2, "this.append(value, startIndex, endIndex)");
            } else {
                sb2.append(o02, 0, i15);
                j.f(sb2, "this.append(value, startIndex, endIndex)");
            }
        }
        sb2.append(str);
    }

    public static final /* synthetic */ a c(long j10) {
        return new a(j10);
    }

    public static int e(long j10, long j11) {
        long j12 = j10 ^ j11;
        if (j12 < 0 || (((int) j12) & 1) == 0) {
            return j.j(j10, j11);
        }
        int i10 = (((int) j10) & 1) - (((int) j11) & 1);
        if (C(j10)) {
            return -i10;
        }
        return i10;
    }

    public static long h(long j10) {
        if (b.a()) {
            if (A(j10)) {
                if (!new g(-4611686018426999999L, 4611686018426999999L).g(w(j10))) {
                    throw new AssertionError(w(j10) + " ns is out of nanoseconds range");
                }
            } else if (!new g(-4611686018427387903L, 4611686018427387903L).g(w(j10))) {
                throw new AssertionError(w(j10) + " ms is out of milliseconds range");
            } else if (new g(-4611686018426L, 4611686018426L).g(w(j10))) {
                throw new AssertionError(w(j10) + " ms is denormalized");
            }
        }
        return j10;
    }

    public static boolean i(long j10, Object obj) {
        return (obj instanceof a) && j10 == ((a) obj).M();
    }

    public static final long j(long j10) {
        return C(j10) ? K(j10) : j10;
    }

    public static final int k(long j10) {
        if (B(j10)) {
            return 0;
        }
        return (int) (o(j10) % ((long) 24));
    }

    public static final long l(long j10) {
        return I(j10, DurationUnit.DAYS);
    }

    public static final long o(long j10) {
        return I(j10, DurationUnit.HOURS);
    }

    public static final long p(long j10) {
        return I(j10, DurationUnit.MINUTES);
    }

    public static final long q(long j10) {
        return I(j10, DurationUnit.SECONDS);
    }

    public static final int r(long j10) {
        if (B(j10)) {
            return 0;
        }
        return (int) (p(j10) % ((long) 60));
    }

    public static final int s(long j10) {
        long j11;
        if (B(j10)) {
            return 0;
        }
        if (z(j10)) {
            j11 = c.m(w(j10) % ((long) 1000));
        } else {
            j11 = w(j10) % ((long) 1000000000);
        }
        return (int) j11;
    }

    public static final int t(long j10) {
        if (B(j10)) {
            return 0;
        }
        return (int) (q(j10) % ((long) 60));
    }

    private static final DurationUnit v(long j10) {
        return A(j10) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    private static final long w(long j10) {
        return j10 >> 1;
    }

    public static int x(long j10) {
        return Long.hashCode(j10);
    }

    public static final boolean y(long j10) {
        return !B(j10);
    }

    private static final boolean z(long j10) {
        return (((int) j10) & 1) == 1;
    }

    public final /* synthetic */ long M() {
        return this.f33997a;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return d(((a) obj).M());
    }

    public int d(long j10) {
        return e(this.f33997a, j10);
    }

    public boolean equals(Object obj) {
        return i(this.f33997a, obj);
    }

    public int hashCode() {
        return x(this.f33997a);
    }

    public String toString() {
        return J(this.f33997a);
    }
}
