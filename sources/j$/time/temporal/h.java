package j$.time.temporal;

import j$.time.LocalDate;
import j$.time.chrono.a;
import j$.time.chrono.f;
import j$.time.chrono.g;
import j$.time.d;
import j$.time.e;
import net.bytebuddy.jar.asm.Opcodes;

enum h implements m {
    ;
    
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f42728a = null;

    static {
        f42728a = new int[]{0, 90, Opcodes.PUTFIELD, 273, 0, 91, Opcodes.INVOKEVIRTUAL, 274};
    }

    static boolean j(TemporalAccessor temporalAccessor) {
        return ((a) f.c(temporalAccessor)).equals(g.f42585a);
    }

    static void m(TemporalAccessor temporalAccessor) {
        if (!((a) f.c(temporalAccessor)).equals(g.f42585a)) {
            throw new d("Resolve requires IsoChronology");
        }
    }

    static s n(LocalDate localDate) {
        return s.i(1, (long) s(r(localDate)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
        if ((r0 == -3 || (r0 == -2 && r5.u())) == false) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int o(j$.time.LocalDate r5) {
        /*
            j$.time.e r0 = r5.q()
            int r0 = r0.ordinal()
            int r1 = r5.r()
            r2 = 1
            int r1 = r1 - r2
            int r0 = 3 - r0
            int r0 = r0 + r1
            int r3 = r0 / 7
            int r3 = r3 * 7
            int r0 = r0 - r3
            r3 = -3
            int r0 = r0 + r3
            if (r0 >= r3) goto L_0x001c
            int r0 = r0 + 7
        L_0x001c:
            if (r1 >= r0) goto L_0x003f
            r0 = 180(0xb4, float:2.52E-43)
            j$.time.LocalDate r5 = r5.J(r0)
            r0 = -1
            j$.time.LocalDate r5 = r5.D(r0)
            int r5 = r(r5)
            int r5 = s(r5)
            long r0 = (long) r5
            r2 = 1
            j$.time.temporal.s r5 = j$.time.temporal.s.i(r2, r0)
            long r0 = r5.d()
            int r5 = (int) r0
            goto L_0x005b
        L_0x003f:
            int r1 = r1 - r0
            int r1 = r1 / 7
            int r1 = r1 + r2
            r4 = 53
            if (r1 != r4) goto L_0x0059
            if (r0 == r3) goto L_0x0055
            r3 = -2
            if (r0 != r3) goto L_0x0053
            boolean r5 = r5.u()
            if (r5 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r5 = 0
            goto L_0x0056
        L_0x0055:
            r5 = r2
        L_0x0056:
            if (r5 != 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r2 = r1
        L_0x005a:
            r5 = r2
        L_0x005b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.temporal.h.o(j$.time.LocalDate):int");
    }

    /* access modifiers changed from: private */
    public static int r(LocalDate localDate) {
        int t10 = localDate.t();
        int r10 = localDate.r();
        if (r10 <= 3) {
            return r10 - localDate.q().ordinal() < -2 ? t10 - 1 : t10;
        }
        if (r10 < 363) {
            return t10;
        }
        return ((r10 - 363) - (localDate.u() ? 1 : 0)) - localDate.q().ordinal() >= 0 ? t10 + 1 : t10;
    }

    /* access modifiers changed from: private */
    public static int s(int i10) {
        LocalDate w10 = LocalDate.w(i10, 1, 1);
        if (w10.q() != e.THURSDAY) {
            return (w10.q() != e.WEDNESDAY || !w10.u()) ? 52 : 53;
        }
        return 53;
    }

    public s d(TemporalAccessor temporalAccessor) {
        return e();
    }

    public final boolean isDateBased() {
        return true;
    }

    public final boolean isTimeBased() {
        return false;
    }
}
