package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import androidx.datastore.preferences.protobuf.e0;
import androidx.datastore.preferences.protobuf.w;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class n0<T> implements y0<T> {

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f5335r = new int[0];

    /* renamed from: s  reason: collision with root package name */
    private static final Unsafe f5336s = i1.B();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f5337a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f5338b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5339c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5340d;

    /* renamed from: e  reason: collision with root package name */
    private final k0 f5341e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f5342f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f5343g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f5344h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f5345i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f5346j;

    /* renamed from: k  reason: collision with root package name */
    private final int f5347k;

    /* renamed from: l  reason: collision with root package name */
    private final int f5348l;

    /* renamed from: m  reason: collision with root package name */
    private final p0 f5349m;

    /* renamed from: n  reason: collision with root package name */
    private final b0 f5350n;

    /* renamed from: o  reason: collision with root package name */
    private final e1<?, ?> f5351o;

    /* renamed from: p  reason: collision with root package name */
    private final o<?> f5352p;

    /* renamed from: q  reason: collision with root package name */
    private final f0 f5353q;

    private n0(int[] iArr, Object[] objArr, int i10, int i11, k0 k0Var, boolean z10, boolean z11, int[] iArr2, int i12, int i13, p0 p0Var, b0 b0Var, e1<?, ?> e1Var, o<?> oVar, f0 f0Var) {
        boolean z12;
        this.f5337a = iArr;
        this.f5338b = objArr;
        this.f5339c = i10;
        this.f5340d = i11;
        this.f5343g = k0Var instanceof GeneratedMessageLite;
        this.f5344h = z10;
        if (oVar == null || !oVar.e(k0Var)) {
            z12 = false;
        } else {
            z12 = true;
        }
        this.f5342f = z12;
        this.f5345i = z11;
        this.f5346j = iArr2;
        this.f5347k = i12;
        this.f5348l = i13;
        this.f5349m = p0Var;
        this.f5350n = b0Var;
        this.f5351o = e1Var;
        this.f5352p = oVar;
        this.f5341e = k0Var;
        this.f5353q = f0Var;
    }

    private boolean A(T t10, T t11, int i10) {
        long V = (long) (V(i10) & 1048575);
        if (i1.x(t10, V) == i1.x(t11, V)) {
            return true;
        }
        return false;
    }

    private boolean B(T t10, int i10, int i11) {
        if (i1.x(t10, (long) (V(i11) & 1048575)) == i10) {
            return true;
        }
        return false;
    }

    private static boolean C(int i10) {
        return (i10 & 268435456) != 0;
    }

    private static List<?> D(Object obj, long j10) {
        return (List) i1.A(obj, j10);
    }

    private static <T> long E(T t10, long j10) {
        return i1.y(t10, j10);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private <UT, UB, ET extends androidx.datastore.preferences.protobuf.s.b<ET>> void F(androidx.datastore.preferences.protobuf.e1<UT, UB> r17, androidx.datastore.preferences.protobuf.o<ET> r18, T r19, androidx.datastore.preferences.protobuf.x0 r20, androidx.datastore.preferences.protobuf.n r21) throws java.io.IOException {
        /*
            r16 = this;
            r8 = r16
            r9 = r17
            r10 = r19
            r0 = r20
            r11 = r21
            r12 = 0
            r13 = r12
            r14 = r13
        L_0x000d:
            int r1 = r20.A()     // Catch:{ all -> 0x0612 }
            int r3 = r8.U(r1)     // Catch:{ all -> 0x0612 }
            if (r3 >= 0) goto L_0x008e
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0033
            int r0 = r8.f5347k
        L_0x001e:
            int r1 = r8.f5348l
            if (r0 >= r1) goto L_0x002d
            int[] r1 = r8.f5346j
            r1 = r1[r0]
            java.lang.Object r13 = r8.k(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x001e
        L_0x002d:
            if (r13 == 0) goto L_0x0032
            r9.o(r10, r13)
        L_0x0032:
            return
        L_0x0033:
            boolean r2 = r8.f5342f     // Catch:{ all -> 0x0612 }
            if (r2 != 0) goto L_0x003b
            r15 = r18
            r3 = r12
            goto L_0x0044
        L_0x003b:
            androidx.datastore.preferences.protobuf.k0 r2 = r8.f5341e     // Catch:{ all -> 0x0612 }
            r15 = r18
            java.lang.Object r1 = r15.b(r11, r2, r1)     // Catch:{ all -> 0x0612 }
            r3 = r1
        L_0x0044:
            if (r3 == 0) goto L_0x005c
            if (r14 != 0) goto L_0x004d
            androidx.datastore.preferences.protobuf.s r1 = r18.d(r19)     // Catch:{ all -> 0x0612 }
            r14 = r1
        L_0x004d:
            r1 = r18
            r2 = r20
            r4 = r21
            r5 = r14
            r6 = r13
            r7 = r17
            java.lang.Object r13 = r1.g(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0612 }
            goto L_0x000d
        L_0x005c:
            boolean r1 = r9.q(r0)     // Catch:{ all -> 0x0612 }
            if (r1 == 0) goto L_0x0069
            boolean r1 = r20.D()     // Catch:{ all -> 0x0612 }
            if (r1 == 0) goto L_0x0077
            goto L_0x000d
        L_0x0069:
            if (r13 != 0) goto L_0x0070
            java.lang.Object r1 = r9.f(r10)     // Catch:{ all -> 0x0612 }
            r13 = r1
        L_0x0070:
            boolean r1 = r9.m(r13, r0)     // Catch:{ all -> 0x0612 }
            if (r1 == 0) goto L_0x0077
            goto L_0x000d
        L_0x0077:
            int r0 = r8.f5347k
        L_0x0079:
            int r1 = r8.f5348l
            if (r0 >= r1) goto L_0x0088
            int[] r1 = r8.f5346j
            r1 = r1[r0]
            java.lang.Object r13 = r8.k(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x0079
        L_0x0088:
            if (r13 == 0) goto L_0x008d
            r9.o(r10, r13)
        L_0x008d:
            return
        L_0x008e:
            r15 = r18
            int r4 = r8.f0(r3)     // Catch:{ all -> 0x0612 }
            int r2 = e0(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            switch(r2) {
                case 0: goto L_0x059d;
                case 1: goto L_0x058d;
                case 2: goto L_0x057d;
                case 3: goto L_0x056d;
                case 4: goto L_0x055d;
                case 5: goto L_0x054d;
                case 6: goto L_0x053d;
                case 7: goto L_0x052d;
                case 8: goto L_0x0525;
                case 9: goto L_0x04ee;
                case 10: goto L_0x04de;
                case 11: goto L_0x04ce;
                case 12: goto L_0x04ab;
                case 13: goto L_0x049b;
                case 14: goto L_0x048b;
                case 15: goto L_0x047b;
                case 16: goto L_0x046b;
                case 17: goto L_0x0434;
                case 18: goto L_0x0425;
                case 19: goto L_0x0416;
                case 20: goto L_0x0407;
                case 21: goto L_0x03f8;
                case 22: goto L_0x03e9;
                case 23: goto L_0x03da;
                case 24: goto L_0x03cb;
                case 25: goto L_0x03bc;
                case 26: goto L_0x03b7;
                case 27: goto L_0x03a5;
                case 28: goto L_0x0396;
                case 29: goto L_0x0387;
                case 30: goto L_0x0370;
                case 31: goto L_0x0361;
                case 32: goto L_0x0352;
                case 33: goto L_0x0343;
                case 34: goto L_0x0334;
                case 35: goto L_0x0325;
                case 36: goto L_0x0316;
                case 37: goto L_0x0307;
                case 38: goto L_0x02f8;
                case 39: goto L_0x02e9;
                case 40: goto L_0x02da;
                case 41: goto L_0x02cb;
                case 42: goto L_0x02bc;
                case 43: goto L_0x02ad;
                case 44: goto L_0x0296;
                case 45: goto L_0x0287;
                case 46: goto L_0x0278;
                case 47: goto L_0x0269;
                case 48: goto L_0x025a;
                case 49: goto L_0x0244;
                case 50: goto L_0x0233;
                case 51: goto L_0x021f;
                case 52: goto L_0x020b;
                case 53: goto L_0x01f7;
                case 54: goto L_0x01e3;
                case 55: goto L_0x01cf;
                case 56: goto L_0x01bb;
                case 57: goto L_0x01a7;
                case 58: goto L_0x0193;
                case 59: goto L_0x018b;
                case 60: goto L_0x0152;
                case 61: goto L_0x0142;
                case 62: goto L_0x012e;
                case 63: goto L_0x0107;
                case 64: goto L_0x00f3;
                case 65: goto L_0x00df;
                case 66: goto L_0x00cb;
                case 67: goto L_0x00b7;
                case 68: goto L_0x00a3;
                default: goto L_0x009b;
            }     // Catch:{ InvalidWireTypeException -> 0x05cb }
        L_0x009b:
            if (r13 != 0) goto L_0x05ae
            java.lang.Object r1 = r17.n()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x05ad
        L_0x00a3:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.y0 r2 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.L(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00b7:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.y()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00cb:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.l()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00df:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.f()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00f3:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.E()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0107:
            int r2 = r20.k()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.w$e r5 = r8.n(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x011e
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x0118
            goto L_0x011e
        L_0x0118:
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.a1.L(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x011e:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x012e:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.h()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0142:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.ByteString r2 = r20.o()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0152:
            boolean r2 = r8.B(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r2 == 0) goto L_0x0174
            long r5 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = androidx.datastore.preferences.protobuf.i1.A(r10, r5)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.y0 r5 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r5 = r0.J(r5, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = androidx.datastore.preferences.protobuf.w.h(r2, r5)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x0186
        L_0x0174:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.y0 r2 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.J(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
        L_0x0186:
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x018b:
            r8.Y(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0193:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            boolean r2 = r20.e()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01a7:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.u()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01bb:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.b()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01cf:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.p()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01e3:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.s()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01f7:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.H()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x020b:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            float r2 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x021f:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            double r6 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Double r2 = java.lang.Double.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.c0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0233:
            java.lang.Object r4 = r8.o(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r1 = r16
            r2 = r19
            r5 = r21
            r6 = r20
            r1.G(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0244:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.y0 r6 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r1 = r16
            r2 = r19
            r3 = r4
            r5 = r20
            r7 = r21
            r1.W(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x025a:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.d(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0269:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.r(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0278:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.v(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0287:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.c(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0296:
            androidx.datastore.preferences.protobuf.b0 r2 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r2 = r2.e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.j(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.w$e r3 = r8.n(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.a1.A(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02ad:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.t(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02bc:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.m(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02cb:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.x(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02da:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.q(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02e9:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.w(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02f8:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.g(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0307:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.i(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0316:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.C(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0325:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.G(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0334:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.d(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0343:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.r(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0352:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.v(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0361:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.c(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0370:
            androidx.datastore.preferences.protobuf.b0 r2 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r2 = r2.e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.j(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.w$e r3 = r8.n(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.a1.A(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0387:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.t(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0396:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.F(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03a5:
            androidx.datastore.preferences.protobuf.y0 r5 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r1 = r16
            r2 = r19
            r3 = r4
            r4 = r20
            r6 = r21
            r1.X(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03b7:
            r8.Z(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03bc:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.m(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03cb:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.x(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03da:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.q(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03e9:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.w(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03f8:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.g(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0407:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.i(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0416:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.C(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0425:
            androidx.datastore.preferences.protobuf.b0 r1 = r8.f5350n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.G(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0434:
            boolean r1 = r8.v(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r1 == 0) goto L_0x0457
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.i1.A(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.y0 r2 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.L(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.w.h(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0457:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.y0 r4 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r4 = r0.L(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x046b:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.y()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.N(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x047b:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.l()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.M(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x048b:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.f()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.N(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x049b:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.E()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.M(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04ab:
            int r2 = r20.k()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.w$e r5 = r8.n(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x04c2
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x04bc
            goto L_0x04c2
        L_0x04bc:
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.a1.L(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04c2:
            long r4 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.M(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04ce:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.h()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.M(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04de:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.ByteString r4 = r20.o()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04ee:
            boolean r1 = r8.v(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r1 == 0) goto L_0x0511
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.i1.A(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.y0 r2 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.J(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.w.h(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0511:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.y0 r4 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r4 = r0.J(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.O(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0525:
            r8.Y(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x052d:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            boolean r4 = r20.e()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.E(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x053d:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.u()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.M(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x054d:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.b()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.N(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x055d:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.p()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.M(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x056d:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.s()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.N(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x057d:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.H()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.N(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x058d:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            float r4 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.L(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x059d:
            long r1 = O(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            double r4 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.i1.K(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.b0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x05ad:
            r13 = r1
        L_0x05ae:
            boolean r1 = r9.m(r13, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f5347k
        L_0x05b6:
            int r1 = r8.f5348l
            if (r0 >= r1) goto L_0x05c5
            int[] r1 = r8.f5346j
            r1 = r1[r0]
            java.lang.Object r13 = r8.k(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05b6
        L_0x05c5:
            if (r13 == 0) goto L_0x05ca
            r9.o(r10, r13)
        L_0x05ca:
            return
        L_0x05cb:
            boolean r1 = r9.q(r0)     // Catch:{ all -> 0x0612 }
            if (r1 == 0) goto L_0x05ee
            boolean r1 = r20.D()     // Catch:{ all -> 0x0612 }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f5347k
        L_0x05d9:
            int r1 = r8.f5348l
            if (r0 >= r1) goto L_0x05e8
            int[] r1 = r8.f5346j
            r1 = r1[r0]
            java.lang.Object r13 = r8.k(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05d9
        L_0x05e8:
            if (r13 == 0) goto L_0x05ed
            r9.o(r10, r13)
        L_0x05ed:
            return
        L_0x05ee:
            if (r13 != 0) goto L_0x05f5
            java.lang.Object r1 = r9.f(r10)     // Catch:{ all -> 0x0612 }
            r13 = r1
        L_0x05f5:
            boolean r1 = r9.m(r13, r0)     // Catch:{ all -> 0x0612 }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f5347k
        L_0x05fd:
            int r1 = r8.f5348l
            if (r0 >= r1) goto L_0x060c
            int[] r1 = r8.f5346j
            r1 = r1[r0]
            java.lang.Object r13 = r8.k(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05fd
        L_0x060c:
            if (r13 == 0) goto L_0x0611
            r9.o(r10, r13)
        L_0x0611:
            return
        L_0x0612:
            r0 = move-exception
            int r1 = r8.f5347k
        L_0x0615:
            int r2 = r8.f5348l
            if (r1 >= r2) goto L_0x0624
            int[] r2 = r8.f5346j
            r2 = r2[r1]
            java.lang.Object r13 = r8.k(r10, r2, r13, r9)
            int r1 = r1 + 1
            goto L_0x0615
        L_0x0624:
            if (r13 == 0) goto L_0x0629
            r9.o(r10, r13)
        L_0x0629:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.F(androidx.datastore.preferences.protobuf.e1, androidx.datastore.preferences.protobuf.o, java.lang.Object, androidx.datastore.preferences.protobuf.x0, androidx.datastore.preferences.protobuf.n):void");
    }

    private final <K, V> void G(Object obj, int i10, Object obj2, n nVar, x0 x0Var) throws IOException {
        long O = O(f0(i10));
        Object A = i1.A(obj, O);
        if (A == null) {
            A = this.f5353q.d(obj2);
            i1.O(obj, O, A);
        } else if (this.f5353q.h(A)) {
            Object d10 = this.f5353q.d(obj2);
            this.f5353q.a(d10, A);
            i1.O(obj, O, d10);
            A = d10;
        }
        x0Var.O(this.f5353q.c(A), this.f5353q.b(obj2), nVar);
    }

    private void H(T t10, T t11, int i10) {
        long O = O(f0(i10));
        if (v(t11, i10)) {
            Object A = i1.A(t10, O);
            Object A2 = i1.A(t11, O);
            if (A != null && A2 != null) {
                i1.O(t10, O, w.h(A, A2));
                b0(t10, i10);
            } else if (A2 != null) {
                i1.O(t10, O, A2);
                b0(t10, i10);
            }
        }
    }

    private void I(T t10, T t11, int i10) {
        int f02 = f0(i10);
        int N = N(i10);
        long O = O(f02);
        if (B(t11, N, i10)) {
            Object A = i1.A(t10, O);
            Object A2 = i1.A(t11, O);
            if (A != null && A2 != null) {
                i1.O(t10, O, w.h(A, A2));
                c0(t10, N, i10);
            } else if (A2 != null) {
                i1.O(t10, O, A2);
                c0(t10, N, i10);
            }
        }
    }

    private void J(T t10, T t11, int i10) {
        int f02 = f0(i10);
        long O = O(f02);
        int N = N(i10);
        switch (e0(f02)) {
            case 0:
                if (v(t11, i10)) {
                    i1.K(t10, O, i1.v(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 1:
                if (v(t11, i10)) {
                    i1.L(t10, O, i1.w(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 2:
                if (v(t11, i10)) {
                    i1.N(t10, O, i1.y(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 3:
                if (v(t11, i10)) {
                    i1.N(t10, O, i1.y(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 4:
                if (v(t11, i10)) {
                    i1.M(t10, O, i1.x(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 5:
                if (v(t11, i10)) {
                    i1.N(t10, O, i1.y(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 6:
                if (v(t11, i10)) {
                    i1.M(t10, O, i1.x(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 7:
                if (v(t11, i10)) {
                    i1.E(t10, O, i1.p(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 8:
                if (v(t11, i10)) {
                    i1.O(t10, O, i1.A(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 9:
                H(t10, t11, i10);
                return;
            case 10:
                if (v(t11, i10)) {
                    i1.O(t10, O, i1.A(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 11:
                if (v(t11, i10)) {
                    i1.M(t10, O, i1.x(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 12:
                if (v(t11, i10)) {
                    i1.M(t10, O, i1.x(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 13:
                if (v(t11, i10)) {
                    i1.M(t10, O, i1.x(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 14:
                if (v(t11, i10)) {
                    i1.N(t10, O, i1.y(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 15:
                if (v(t11, i10)) {
                    i1.M(t10, O, i1.x(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 16:
                if (v(t11, i10)) {
                    i1.N(t10, O, i1.y(t11, O));
                    b0(t10, i10);
                    return;
                }
                return;
            case 17:
                H(t10, t11, i10);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f5350n.d(t10, t11, O);
                return;
            case 50:
                a1.F(this.f5353q, t10, t11, O);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (B(t11, N, i10)) {
                    i1.O(t10, O, i1.A(t11, O));
                    c0(t10, N, i10);
                    return;
                }
                return;
            case 60:
                I(t10, t11, i10);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (B(t11, N, i10)) {
                    i1.O(t10, O, i1.A(t11, O));
                    c0(t10, N, i10);
                    return;
                }
                return;
            case 68:
                I(t10, t11, i10);
                return;
            default:
                return;
        }
    }

    static <T> n0<T> K(Class<T> cls, i0 i0Var, p0 p0Var, b0 b0Var, e1<?, ?> e1Var, o<?> oVar, f0 f0Var) {
        if (i0Var instanceof w0) {
            return M((w0) i0Var, p0Var, b0Var, e1Var, oVar, f0Var);
        }
        return L((c1) i0Var, p0Var, b0Var, e1Var, oVar, f0Var);
    }

    static <T> n0<T> L(c1 c1Var, p0 p0Var, b0 b0Var, e1<?, ?> e1Var, o<?> oVar, f0 f0Var) {
        boolean z10;
        if (c1Var.c() == ProtoSyntax.PROTO3) {
            z10 = true;
        } else {
            z10 = false;
        }
        r[] e10 = c1Var.e();
        if (e10.length == 0) {
            int length = e10.length;
            int[] iArr = new int[(length * 3)];
            Object[] objArr = new Object[(length * 2)];
            if (e10.length <= 0) {
                int[] d10 = c1Var.d();
                if (d10 == null) {
                    d10 = f5335r;
                }
                if (e10.length <= 0) {
                    int[] iArr2 = f5335r;
                    int[] iArr3 = f5335r;
                    int[] iArr4 = new int[(d10.length + iArr2.length + iArr3.length)];
                    System.arraycopy(d10, 0, iArr4, 0, d10.length);
                    System.arraycopy(iArr2, 0, iArr4, d10.length, iArr2.length);
                    System.arraycopy(iArr3, 0, iArr4, d10.length + iArr2.length, iArr3.length);
                    return new n0(iArr, objArr, 0, 0, c1Var.b(), z10, true, iArr4, d10.length, d10.length + iArr2.length, p0Var, b0Var, e1Var, oVar, f0Var);
                }
                r rVar = e10[0];
                throw null;
            }
            r rVar2 = e10[0];
            throw null;
        }
        r rVar3 = e10[0];
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0391  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> androidx.datastore.preferences.protobuf.n0<T> M(androidx.datastore.preferences.protobuf.w0 r36, androidx.datastore.preferences.protobuf.p0 r37, androidx.datastore.preferences.protobuf.b0 r38, androidx.datastore.preferences.protobuf.e1<?, ?> r39, androidx.datastore.preferences.protobuf.o<?> r40, androidx.datastore.preferences.protobuf.f0 r41) {
        /*
            androidx.datastore.preferences.protobuf.ProtoSyntax r0 = r36.c()
            androidx.datastore.preferences.protobuf.ProtoSyntax r1 = androidx.datastore.preferences.protobuf.ProtoSyntax.PROTO3
            r2 = 0
            if (r0 != r1) goto L_0x000b
            r10 = 1
            goto L_0x000c
        L_0x000b:
            r10 = r2
        L_0x000c:
            java.lang.String r0 = r36.e()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r6) goto L_0x0035
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r7 = 1
            r8 = 13
        L_0x0022:
            int r9 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0032
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r8
            r4 = r4 | r7
            int r8 = r8 + 13
            r7 = r9
            goto L_0x0022
        L_0x0032:
            int r7 = r7 << r8
            r4 = r4 | r7
            goto L_0x0036
        L_0x0035:
            r9 = 1
        L_0x0036:
            int r7 = r9 + 1
            char r8 = r0.charAt(r9)
            if (r8 < r6) goto L_0x0055
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0042:
            int r11 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0052
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r8 = r8 | r7
            int r9 = r9 + 13
            r7 = r11
            goto L_0x0042
        L_0x0052:
            int r7 = r7 << r9
            r8 = r8 | r7
            r7 = r11
        L_0x0055:
            if (r8 != 0) goto L_0x0062
            int[] r8 = f5335r
            r9 = r2
            r11 = r9
            r12 = r11
            r14 = r12
            r15 = r14
            r13 = r8
            r8 = r15
            goto L_0x0177
        L_0x0062:
            int r8 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0081
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006e:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x007e
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r7 = r7 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x006e
        L_0x007e:
            int r8 = r8 << r9
            r7 = r7 | r8
            r8 = r11
        L_0x0081:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x00a0
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x008d:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r6) goto L_0x009d
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x008d
        L_0x009d:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00a0:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r6) goto L_0x00bf
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00ac:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r6) goto L_0x00bc
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00ac
        L_0x00bc:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00bf:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r6) goto L_0x00de
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00cb:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r6) goto L_0x00db
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00cb
        L_0x00db:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00de:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r6) goto L_0x00fd
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ea:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r6) goto L_0x00fa
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00ea
        L_0x00fa:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00fd:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r6) goto L_0x011e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0109:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r6) goto L_0x011a
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0109
        L_0x011a:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x011e:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r6) goto L_0x0141
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x012a:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r6) goto L_0x013c
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x012a
        L_0x013c:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0141:
            int r16 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r6) goto L_0x0166
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r2 = r16
            r16 = 13
        L_0x014f:
            int r18 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r6) goto L_0x0161
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r16
            r15 = r15 | r2
            int r16 = r16 + 13
            r2 = r18
            goto L_0x014f
        L_0x0161:
            int r2 = r2 << r16
            r15 = r15 | r2
            r16 = r18
        L_0x0166:
            int r2 = r15 + r13
            int r2 = r2 + r14
            int[] r2 = new int[r2]
            int r14 = r7 * 2
            int r14 = r14 + r8
            r8 = r7
            r7 = r16
            r35 = r13
            r13 = r2
            r2 = r9
            r9 = r35
        L_0x0177:
            sun.misc.Unsafe r5 = f5336s
            java.lang.Object[] r18 = r36.d()
            androidx.datastore.preferences.protobuf.k0 r19 = r36.b()
            java.lang.Class r3 = r19.getClass()
            int r6 = r12 * 3
            int[] r6 = new int[r6]
            int r12 = r12 * 2
            java.lang.Object[] r12 = new java.lang.Object[r12]
            int r21 = r15 + r9
            r23 = r15
            r24 = r21
            r9 = 0
            r22 = 0
        L_0x0196:
            if (r7 >= r1) goto L_0x03e9
            int r25 = r7 + 1
            char r7 = r0.charAt(r7)
            r26 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r1) goto L_0x01ca
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r1 = r25
            r25 = 13
        L_0x01ab:
            int r27 = r1 + 1
            char r1 = r0.charAt(r1)
            r28 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r15) goto L_0x01c4
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r25
            r7 = r7 | r1
            int r25 = r25 + 13
            r1 = r27
            r15 = r28
            goto L_0x01ab
        L_0x01c4:
            int r1 = r1 << r25
            r7 = r7 | r1
            r1 = r27
            goto L_0x01ce
        L_0x01ca:
            r28 = r15
            r1 = r25
        L_0x01ce:
            int r15 = r1 + 1
            char r1 = r0.charAt(r1)
            r25 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r15) goto L_0x0200
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r15 = r25
            r25 = 13
        L_0x01e1:
            int r27 = r15 + 1
            char r15 = r0.charAt(r15)
            r29 = r10
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r10) goto L_0x01fa
            r10 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r25
            r1 = r1 | r10
            int r25 = r25 + 13
            r15 = r27
            r10 = r29
            goto L_0x01e1
        L_0x01fa:
            int r10 = r15 << r25
            r1 = r1 | r10
            r15 = r27
            goto L_0x0204
        L_0x0200:
            r29 = r10
            r15 = r25
        L_0x0204:
            r10 = r1 & 255(0xff, float:3.57E-43)
            r25 = r11
            r11 = r1 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0211
            int r11 = r9 + 1
            r13[r9] = r22
            r9 = r11
        L_0x0211:
            r11 = 51
            r31 = r9
            if (r10 < r11) goto L_0x02b0
            int r11 = r15 + 1
            char r15 = r0.charAt(r15)
            r9 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r9) goto L_0x0240
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r33 = 13
        L_0x0226:
            int r34 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r9) goto L_0x023b
            r9 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r33
            r15 = r15 | r9
            int r33 = r33 + 13
            r11 = r34
            r9 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0226
        L_0x023b:
            int r9 = r11 << r33
            r15 = r15 | r9
            r11 = r34
        L_0x0240:
            int r9 = r10 + -51
            r33 = r11
            r11 = 9
            if (r9 == r11) goto L_0x0262
            r11 = 17
            if (r9 != r11) goto L_0x024d
            goto L_0x0262
        L_0x024d:
            r11 = 12
            if (r9 != r11) goto L_0x026f
            r9 = r4 & 1
            r11 = 1
            if (r9 != r11) goto L_0x026f
            int r9 = r22 / 3
            int r9 = r9 * 2
            int r9 = r9 + r11
            int r11 = r14 + 1
            r14 = r18[r14]
            r12[r9] = r14
            goto L_0x026e
        L_0x0262:
            int r9 = r22 / 3
            int r9 = r9 * 2
            r11 = 1
            int r9 = r9 + r11
            int r11 = r14 + 1
            r14 = r18[r14]
            r12[r9] = r14
        L_0x026e:
            r14 = r11
        L_0x026f:
            int r15 = r15 * 2
            r9 = r18[r15]
            boolean r11 = r9 instanceof java.lang.reflect.Field
            if (r11 == 0) goto L_0x027a
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x0282
        L_0x027a:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = a0(r3, r9)
            r18[r15] = r9
        L_0x0282:
            r11 = r6
            r34 = r7
            long r6 = r5.objectFieldOffset(r9)
            int r6 = (int) r6
            int r15 = r15 + 1
            r7 = r18[r15]
            boolean r9 = r7 instanceof java.lang.reflect.Field
            if (r9 == 0) goto L_0x0295
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x029d
        L_0x0295:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = a0(r3, r7)
            r18[r15] = r7
        L_0x029d:
            r9 = r6
            long r6 = r5.objectFieldOffset(r7)
            int r6 = (int) r6
            r32 = r0
            r19 = r3
            r0 = r4
            r3 = r6
            r6 = r9
            r9 = r10
            r7 = r33
            r15 = 0
            goto L_0x03ae
        L_0x02b0:
            r11 = r6
            r34 = r7
            int r6 = r14 + 1
            r7 = r18[r14]
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = a0(r3, r7)
            r9 = 49
            r14 = 9
            if (r10 == r14) goto L_0x0325
            r14 = 17
            if (r10 != r14) goto L_0x02c8
            goto L_0x0325
        L_0x02c8:
            r14 = 27
            if (r10 == r14) goto L_0x0315
            if (r10 != r9) goto L_0x02cf
            goto L_0x0315
        L_0x02cf:
            r14 = 12
            if (r10 == r14) goto L_0x0304
            r14 = 30
            if (r10 == r14) goto L_0x0304
            r14 = 44
            if (r10 != r14) goto L_0x02dc
            goto L_0x0304
        L_0x02dc:
            r14 = 50
            if (r10 != r14) goto L_0x0302
            int r14 = r23 + 1
            r13[r23] = r22
            int r23 = r22 / 3
            int r23 = r23 * 2
            int r27 = r6 + 1
            r6 = r18[r6]
            r12[r23] = r6
            r6 = r1 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x02fd
            int r23 = r23 + 1
            int r6 = r27 + 1
            r27 = r18[r27]
            r12[r23] = r27
            r23 = r14
            goto L_0x0331
        L_0x02fd:
            r23 = r14
            r6 = r27
            goto L_0x0331
        L_0x0302:
            r9 = 1
            goto L_0x0331
        L_0x0304:
            r14 = r4 & 1
            r9 = 1
            if (r14 != r9) goto L_0x0331
            int r14 = r22 / 3
            int r14 = r14 * 2
            int r14 = r14 + r9
            int r20 = r6 + 1
            r6 = r18[r6]
            r12[r14] = r6
            goto L_0x0321
        L_0x0315:
            r9 = 1
            int r14 = r22 / 3
            int r14 = r14 * 2
            int r14 = r14 + r9
            int r20 = r6 + 1
            r6 = r18[r6]
            r12[r14] = r6
        L_0x0321:
            r14 = r10
            r6 = r20
            goto L_0x0332
        L_0x0325:
            r9 = 1
            int r14 = r22 / 3
            int r14 = r14 * 2
            int r14 = r14 + r9
            java.lang.Class r20 = r7.getType()
            r12[r14] = r20
        L_0x0331:
            r14 = r10
        L_0x0332:
            long r9 = r5.objectFieldOffset(r7)
            int r7 = (int) r9
            r9 = r4 & 1
            r10 = 1
            if (r9 != r10) goto L_0x0391
            r9 = r14
            r14 = 17
            if (r9 > r14) goto L_0x038b
            int r14 = r15 + 1
            char r15 = r0.charAt(r15)
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r10) goto L_0x0367
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r19 = 13
        L_0x0350:
            int r30 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r10) goto L_0x0362
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r19
            r15 = r15 | r14
            int r19 = r19 + 13
            r14 = r30
            goto L_0x0350
        L_0x0362:
            int r14 = r14 << r19
            r15 = r15 | r14
            r14 = r30
        L_0x0367:
            int r19 = r8 * 2
            int r30 = r15 / 32
            int r19 = r19 + r30
            r10 = r18[r19]
            r32 = r0
            boolean r0 = r10 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0378
            java.lang.reflect.Field r10 = (java.lang.reflect.Field) r10
            goto L_0x0380
        L_0x0378:
            java.lang.String r10 = (java.lang.String) r10
            java.lang.reflect.Field r10 = a0(r3, r10)
            r18[r19] = r10
        L_0x0380:
            r19 = r3
            r0 = r4
            long r3 = r5.objectFieldOffset(r10)
            int r3 = (int) r3
            int r15 = r15 % 32
            goto L_0x039a
        L_0x038b:
            r32 = r0
            r19 = r3
            r0 = r4
            goto L_0x0397
        L_0x0391:
            r32 = r0
            r19 = r3
            r0 = r4
            r9 = r14
        L_0x0397:
            r14 = r15
            r3 = 0
            r15 = 0
        L_0x039a:
            r4 = 18
            if (r9 < r4) goto L_0x03a8
            r4 = 49
            if (r9 > r4) goto L_0x03a8
            int r4 = r24 + 1
            r13[r24] = r7
            r24 = r4
        L_0x03a8:
            r35 = r14
            r14 = r6
            r6 = r7
            r7 = r35
        L_0x03ae:
            int r4 = r22 + 1
            r11[r22] = r34
            int r10 = r4 + 1
            r22 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x03bd
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03be
        L_0x03bd:
            r0 = 0
        L_0x03be:
            r1 = r1 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x03c5
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03c6
        L_0x03c5:
            r1 = 0
        L_0x03c6:
            r0 = r0 | r1
            int r1 = r9 << 20
            r0 = r0 | r1
            r0 = r0 | r6
            r11[r4] = r0
            int r0 = r10 + 1
            int r1 = r15 << 20
            r1 = r1 | r3
            r11[r10] = r1
            r6 = r11
            r3 = r19
            r4 = r22
            r11 = r25
            r1 = r26
            r15 = r28
            r10 = r29
            r9 = r31
            r22 = r0
            r0 = r32
            goto L_0x0196
        L_0x03e9:
            r29 = r10
            r25 = r11
            r28 = r15
            r11 = r6
            androidx.datastore.preferences.protobuf.n0 r0 = new androidx.datastore.preferences.protobuf.n0
            androidx.datastore.preferences.protobuf.k0 r9 = r36.b()
            r1 = 0
            r4 = r0
            r5 = r11
            r6 = r12
            r7 = r2
            r8 = r25
            r11 = r1
            r12 = r13
            r13 = r28
            r14 = r21
            r15 = r37
            r16 = r38
            r17 = r39
            r18 = r40
            r19 = r41
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.M(androidx.datastore.preferences.protobuf.w0, androidx.datastore.preferences.protobuf.p0, androidx.datastore.preferences.protobuf.b0, androidx.datastore.preferences.protobuf.e1, androidx.datastore.preferences.protobuf.o, androidx.datastore.preferences.protobuf.f0):androidx.datastore.preferences.protobuf.n0");
    }

    private int N(int i10) {
        return this.f5337a[i10];
    }

    private static long O(int i10) {
        return (long) (i10 & 1048575);
    }

    private static <T> boolean P(T t10, long j10) {
        return ((Boolean) i1.A(t10, j10)).booleanValue();
    }

    private static <T> double Q(T t10, long j10) {
        return ((Double) i1.A(t10, j10)).doubleValue();
    }

    private static <T> float R(T t10, long j10) {
        return ((Float) i1.A(t10, j10)).floatValue();
    }

    private static <T> int S(T t10, long j10) {
        return ((Integer) i1.A(t10, j10)).intValue();
    }

    private static <T> long T(T t10, long j10) {
        return ((Long) i1.A(t10, j10)).longValue();
    }

    private int U(int i10) {
        if (i10 < this.f5339c || i10 > this.f5340d) {
            return -1;
        }
        return d0(i10, 0);
    }

    private int V(int i10) {
        return this.f5337a[i10 + 2];
    }

    private <E> void W(Object obj, long j10, x0 x0Var, y0<E> y0Var, n nVar) throws IOException {
        x0Var.P(this.f5350n.e(obj, j10), y0Var, nVar);
    }

    private <E> void X(Object obj, int i10, x0 x0Var, y0<E> y0Var, n nVar) throws IOException {
        x0Var.K(this.f5350n.e(obj, O(i10)), y0Var, nVar);
    }

    private void Y(Object obj, int i10, x0 x0Var) throws IOException {
        if (u(i10)) {
            i1.O(obj, O(i10), x0Var.I());
        } else if (this.f5343g) {
            i1.O(obj, O(i10), x0Var.z());
        } else {
            i1.O(obj, O(i10), x0Var.o());
        }
    }

    private void Z(Object obj, int i10, x0 x0Var) throws IOException {
        if (u(i10)) {
            x0Var.n(this.f5350n.e(obj, O(i10)));
        } else {
            x0Var.B(this.f5350n.e(obj, O(i10)));
        }
    }

    private static Field a0(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void b0(T t10, int i10) {
        if (!this.f5344h) {
            int V = V(i10);
            long j10 = (long) (V & 1048575);
            i1.M(t10, j10, i1.x(t10, j10) | (1 << (V >>> 20)));
        }
    }

    private void c0(T t10, int i10, int i11) {
        i1.M(t10, (long) (V(i11) & 1048575), i10);
    }

    private int d0(int i10, int i11) {
        int length = (this.f5337a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int N = N(i13);
            if (i10 == N) {
                return i13;
            }
            if (i10 < N) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    private static int e0(int i10) {
        return (i10 & 267386880) >>> 20;
    }

    private int f0(int i10) {
        return this.f5337a[i10 + 1];
    }

    private boolean g(T t10, T t11, int i10) {
        return v(t10, i10) == v(t11, i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g0(T r18, androidx.datastore.preferences.protobuf.Writer r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.f5342f
            if (r3 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.o<?> r3 = r0.f5352p
            androidx.datastore.preferences.protobuf.s r3 = r3.c(r1)
            boolean r5 = r3.n()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.s()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            r6 = -1
            int[] r7 = r0.f5337a
            int r7 = r7.length
            sun.misc.Unsafe r8 = f5336s
            r10 = 0
            r11 = 0
        L_0x002b:
            if (r10 >= r7) goto L_0x049a
            int r12 = r0.f0(r10)
            int r13 = r0.N(r10)
            int r14 = e0(r12)
            boolean r15 = r0.f5344h
            if (r15 != 0) goto L_0x005e
            r15 = 17
            if (r14 > r15) goto L_0x005e
            int[] r15 = r0.f5337a
            int r16 = r10 + 2
            r15 = r15[r16]
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r15 & r16
            r16 = r5
            if (r9 == r6) goto L_0x0056
            long r4 = (long) r9
            int r11 = r8.getInt(r1, r4)
            r6 = r9
        L_0x0056:
            int r4 = r15 >>> 20
            r5 = 1
            int r4 = r5 << r4
            r5 = r16
            goto L_0x0063
        L_0x005e:
            r16 = r5
            r5 = r16
            r4 = 0
        L_0x0063:
            if (r5 == 0) goto L_0x0081
            androidx.datastore.preferences.protobuf.o<?> r9 = r0.f5352p
            int r9 = r9.a(r5)
            if (r9 > r13) goto L_0x0081
            androidx.datastore.preferences.protobuf.o<?> r9 = r0.f5352p
            r9.j(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007f
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0063
        L_0x007f:
            r5 = 0
            goto L_0x0063
        L_0x0081:
            r15 = r5
            r9 = r6
            long r5 = O(r12)
            switch(r14) {
                case 0: goto L_0x0489;
                case 1: goto L_0x047d;
                case 2: goto L_0x0471;
                case 3: goto L_0x0465;
                case 4: goto L_0x0459;
                case 5: goto L_0x044d;
                case 6: goto L_0x0441;
                case 7: goto L_0x0435;
                case 8: goto L_0x0429;
                case 9: goto L_0x0418;
                case 10: goto L_0x0409;
                case 11: goto L_0x03fc;
                case 12: goto L_0x03ef;
                case 13: goto L_0x03e2;
                case 14: goto L_0x03d5;
                case 15: goto L_0x03c8;
                case 16: goto L_0x03bb;
                case 17: goto L_0x03aa;
                case 18: goto L_0x039a;
                case 19: goto L_0x038a;
                case 20: goto L_0x037a;
                case 21: goto L_0x036a;
                case 22: goto L_0x035a;
                case 23: goto L_0x034a;
                case 24: goto L_0x033a;
                case 25: goto L_0x032a;
                case 26: goto L_0x031b;
                case 27: goto L_0x0308;
                case 28: goto L_0x02f9;
                case 29: goto L_0x02e9;
                case 30: goto L_0x02d9;
                case 31: goto L_0x02c9;
                case 32: goto L_0x02b9;
                case 33: goto L_0x02a9;
                case 34: goto L_0x0299;
                case 35: goto L_0x0289;
                case 36: goto L_0x0279;
                case 37: goto L_0x0269;
                case 38: goto L_0x0259;
                case 39: goto L_0x0249;
                case 40: goto L_0x0239;
                case 41: goto L_0x0229;
                case 42: goto L_0x0219;
                case 43: goto L_0x0209;
                case 44: goto L_0x01f9;
                case 45: goto L_0x01e9;
                case 46: goto L_0x01d9;
                case 47: goto L_0x01c9;
                case 48: goto L_0x01b9;
                case 49: goto L_0x01a6;
                case 50: goto L_0x019d;
                case 51: goto L_0x018e;
                case 52: goto L_0x017f;
                case 53: goto L_0x0170;
                case 54: goto L_0x0161;
                case 55: goto L_0x0152;
                case 56: goto L_0x0143;
                case 57: goto L_0x0134;
                case 58: goto L_0x0125;
                case 59: goto L_0x0116;
                case 60: goto L_0x0103;
                case 61: goto L_0x00f3;
                case 62: goto L_0x00e5;
                case 63: goto L_0x00d7;
                case 64: goto L_0x00c9;
                case 65: goto L_0x00bb;
                case 66: goto L_0x00ad;
                case 67: goto L_0x009f;
                case 68: goto L_0x008d;
                default: goto L_0x008a;
            }
        L_0x008a:
            r12 = 0
            goto L_0x0494
        L_0x008d:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r8.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.y0 r5 = r0.p(r10)
            r2.N(r13, r4, r5)
            goto L_0x008a
        L_0x009f:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = T(r1, r5)
            r2.m(r13, r4)
            goto L_0x008a
        L_0x00ad:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = S(r1, r5)
            r2.H(r13, r4)
            goto L_0x008a
        L_0x00bb:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = T(r1, r5)
            r2.i(r13, r4)
            goto L_0x008a
        L_0x00c9:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = S(r1, r5)
            r2.w(r13, r4)
            goto L_0x008a
        L_0x00d7:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = S(r1, r5)
            r2.E(r13, r4)
            goto L_0x008a
        L_0x00e5:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = S(r1, r5)
            r2.o(r13, r4)
            goto L_0x008a
        L_0x00f3:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r8.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r2.K(r13, r4)
            goto L_0x008a
        L_0x0103:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r8.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.y0 r5 = r0.p(r10)
            r2.L(r13, r4, r5)
            goto L_0x008a
        L_0x0116:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r8.getObject(r1, r5)
            r0.k0(r13, r4, r2)
            goto L_0x008a
        L_0x0125:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            boolean r4 = P(r1, r5)
            r2.v(r13, r4)
            goto L_0x008a
        L_0x0134:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = S(r1, r5)
            r2.c(r13, r4)
            goto L_0x008a
        L_0x0143:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = T(r1, r5)
            r2.s(r13, r4)
            goto L_0x008a
        L_0x0152:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = S(r1, r5)
            r2.h(r13, r4)
            goto L_0x008a
        L_0x0161:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = T(r1, r5)
            r2.f(r13, r4)
            goto L_0x008a
        L_0x0170:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = T(r1, r5)
            r2.u(r13, r4)
            goto L_0x008a
        L_0x017f:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            float r4 = R(r1, r5)
            r2.B(r13, r4)
            goto L_0x008a
        L_0x018e:
            boolean r4 = r0.B(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            double r4 = Q(r1, r5)
            r2.p(r13, r4)
            goto L_0x008a
        L_0x019d:
            java.lang.Object r4 = r8.getObject(r1, r5)
            r0.j0(r2, r13, r4, r10)
            goto L_0x008a
        L_0x01a6:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.y0 r6 = r0.p(r10)
            androidx.datastore.preferences.protobuf.a1.U(r4, r5, r2, r6)
            goto L_0x008a
        L_0x01b9:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 1
            androidx.datastore.preferences.protobuf.a1.b0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01c9:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.a0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01d9:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.Z(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01e9:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.Y(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01f9:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.Q(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0209:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.d0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0219:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.N(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0229:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.R(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0239:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.S(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0249:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.V(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0259:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.e0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0269:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.W(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0279:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.T(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0289:
            r12 = 1
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.P(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0299:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            androidx.datastore.preferences.protobuf.a1.b0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02a9:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.a0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02b9:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.Z(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02c9:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.Y(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02d9:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.Q(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02e9:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.d0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02f9:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.O(r4, r5, r2)
            goto L_0x008a
        L_0x0308:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.y0 r6 = r0.p(r10)
            androidx.datastore.preferences.protobuf.a1.X(r4, r5, r2, r6)
            goto L_0x008a
        L_0x031b:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.c0(r4, r5, r2)
            goto L_0x008a
        L_0x032a:
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            androidx.datastore.preferences.protobuf.a1.N(r4, r5, r2, r12)
            goto L_0x0494
        L_0x033a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.R(r4, r5, r2, r12)
            goto L_0x0494
        L_0x034a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.S(r4, r5, r2, r12)
            goto L_0x0494
        L_0x035a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.V(r4, r5, r2, r12)
            goto L_0x0494
        L_0x036a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.e0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x037a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.W(r4, r5, r2, r12)
            goto L_0x0494
        L_0x038a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.T(r4, r5, r2, r12)
            goto L_0x0494
        L_0x039a:
            r12 = 0
            int r4 = r0.N(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.a1.P(r4, r5, r2, r12)
            goto L_0x0494
        L_0x03aa:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r8.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.y0 r5 = r0.p(r10)
            r2.N(r13, r4, r5)
            goto L_0x0494
        L_0x03bb:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r8.getLong(r1, r5)
            r2.m(r13, r4)
            goto L_0x0494
        L_0x03c8:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r8.getInt(r1, r5)
            r2.H(r13, r4)
            goto L_0x0494
        L_0x03d5:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r8.getLong(r1, r5)
            r2.i(r13, r4)
            goto L_0x0494
        L_0x03e2:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r8.getInt(r1, r5)
            r2.w(r13, r4)
            goto L_0x0494
        L_0x03ef:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r8.getInt(r1, r5)
            r2.E(r13, r4)
            goto L_0x0494
        L_0x03fc:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r8.getInt(r1, r5)
            r2.o(r13, r4)
            goto L_0x0494
        L_0x0409:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r8.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r2.K(r13, r4)
            goto L_0x0494
        L_0x0418:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r8.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.y0 r5 = r0.p(r10)
            r2.L(r13, r4, r5)
            goto L_0x0494
        L_0x0429:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r8.getObject(r1, r5)
            r0.k0(r13, r4, r2)
            goto L_0x0494
        L_0x0435:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            boolean r4 = h(r1, r5)
            r2.v(r13, r4)
            goto L_0x0494
        L_0x0441:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r8.getInt(r1, r5)
            r2.c(r13, r4)
            goto L_0x0494
        L_0x044d:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r8.getLong(r1, r5)
            r2.s(r13, r4)
            goto L_0x0494
        L_0x0459:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r8.getInt(r1, r5)
            r2.h(r13, r4)
            goto L_0x0494
        L_0x0465:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r8.getLong(r1, r5)
            r2.f(r13, r4)
            goto L_0x0494
        L_0x0471:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r8.getLong(r1, r5)
            r2.u(r13, r4)
            goto L_0x0494
        L_0x047d:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            float r4 = m(r1, r5)
            r2.B(r13, r4)
            goto L_0x0494
        L_0x0489:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            double r4 = i(r1, r5)
            r2.p(r13, r4)
        L_0x0494:
            int r10 = r10 + 3
            r6 = r9
            r5 = r15
            goto L_0x002b
        L_0x049a:
            r16 = r5
        L_0x049c:
            if (r5 == 0) goto L_0x04b3
            androidx.datastore.preferences.protobuf.o<?> r4 = r0.f5352p
            r4.j(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04b1
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x049c
        L_0x04b1:
            r5 = 0
            goto L_0x049c
        L_0x04b3:
            androidx.datastore.preferences.protobuf.e1<?, ?> r3 = r0.f5351o
            r0.l0(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.g0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    private static <T> boolean h(T t10, long j10) {
        return i1.p(t10, j10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0588  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h0(T r13, androidx.datastore.preferences.protobuf.Writer r14) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.f5342f
            r1 = 0
            if (r0 == 0) goto L_0x001c
            androidx.datastore.preferences.protobuf.o<?> r0 = r12.f5352p
            androidx.datastore.preferences.protobuf.s r0 = r0.c(r13)
            boolean r2 = r0.n()
            if (r2 != 0) goto L_0x001c
            java.util.Iterator r0 = r0.s()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x001e
        L_0x001c:
            r0 = r1
            r2 = r0
        L_0x001e:
            int[] r3 = r12.f5337a
            int r3 = r3.length
            r4 = 0
            r5 = r4
        L_0x0023:
            if (r5 >= r3) goto L_0x0586
            int r6 = r12.f0(r5)
            int r7 = r12.N(r5)
        L_0x002d:
            if (r2 == 0) goto L_0x004b
            androidx.datastore.preferences.protobuf.o<?> r8 = r12.f5352p
            int r8 = r8.a(r2)
            if (r8 > r7) goto L_0x004b
            androidx.datastore.preferences.protobuf.o<?> r8 = r12.f5352p
            r8.j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x002d
        L_0x0049:
            r2 = r1
            goto L_0x002d
        L_0x004b:
            int r8 = e0(r6)
            r9 = 1
            switch(r8) {
                case 0: goto L_0x0571;
                case 1: goto L_0x055f;
                case 2: goto L_0x054d;
                case 3: goto L_0x053b;
                case 4: goto L_0x0529;
                case 5: goto L_0x0517;
                case 6: goto L_0x0505;
                case 7: goto L_0x04f2;
                case 8: goto L_0x04df;
                case 9: goto L_0x04c8;
                case 10: goto L_0x04b3;
                case 11: goto L_0x04a0;
                case 12: goto L_0x048d;
                case 13: goto L_0x047a;
                case 14: goto L_0x0467;
                case 15: goto L_0x0454;
                case 16: goto L_0x0441;
                case 17: goto L_0x042a;
                case 18: goto L_0x0417;
                case 19: goto L_0x0404;
                case 20: goto L_0x03f1;
                case 21: goto L_0x03de;
                case 22: goto L_0x03cb;
                case 23: goto L_0x03b8;
                case 24: goto L_0x03a5;
                case 25: goto L_0x0392;
                case 26: goto L_0x037f;
                case 27: goto L_0x0368;
                case 28: goto L_0x0355;
                case 29: goto L_0x0342;
                case 30: goto L_0x032f;
                case 31: goto L_0x031c;
                case 32: goto L_0x0309;
                case 33: goto L_0x02f6;
                case 34: goto L_0x02e3;
                case 35: goto L_0x02d0;
                case 36: goto L_0x02bd;
                case 37: goto L_0x02aa;
                case 38: goto L_0x0297;
                case 39: goto L_0x0284;
                case 40: goto L_0x0271;
                case 41: goto L_0x025e;
                case 42: goto L_0x024b;
                case 43: goto L_0x0238;
                case 44: goto L_0x0225;
                case 45: goto L_0x0212;
                case 46: goto L_0x01ff;
                case 47: goto L_0x01ec;
                case 48: goto L_0x01d9;
                case 49: goto L_0x01c2;
                case 50: goto L_0x01b5;
                case 51: goto L_0x01a2;
                case 52: goto L_0x018f;
                case 53: goto L_0x017c;
                case 54: goto L_0x0169;
                case 55: goto L_0x0156;
                case 56: goto L_0x0143;
                case 57: goto L_0x0130;
                case 58: goto L_0x011d;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f3;
                case 61: goto L_0x00de;
                case 62: goto L_0x00cb;
                case 63: goto L_0x00b8;
                case 64: goto L_0x00a5;
                case 65: goto L_0x0092;
                case 66: goto L_0x007f;
                case 67: goto L_0x006c;
                case 68: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x0582
        L_0x0055:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            androidx.datastore.preferences.protobuf.y0 r8 = r12.p(r5)
            r14.N(r7, r6, r8)
            goto L_0x0582
        L_0x006c:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = T(r13, r8)
            r14.m(r7, r8)
            goto L_0x0582
        L_0x007f:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = S(r13, r8)
            r14.H(r7, r6)
            goto L_0x0582
        L_0x0092:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = T(r13, r8)
            r14.i(r7, r8)
            goto L_0x0582
        L_0x00a5:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = S(r13, r8)
            r14.w(r7, r6)
            goto L_0x0582
        L_0x00b8:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = S(r13, r8)
            r14.E(r7, r6)
            goto L_0x0582
        L_0x00cb:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = S(r13, r8)
            r14.o(r7, r6)
            goto L_0x0582
        L_0x00de:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            r14.K(r7, r6)
            goto L_0x0582
        L_0x00f3:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            androidx.datastore.preferences.protobuf.y0 r8 = r12.p(r5)
            r14.L(r7, r6, r8)
            goto L_0x0582
        L_0x010a:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            r12.k0(r7, r6, r14)
            goto L_0x0582
        L_0x011d:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            boolean r6 = P(r13, r8)
            r14.v(r7, r6)
            goto L_0x0582
        L_0x0130:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = S(r13, r8)
            r14.c(r7, r6)
            goto L_0x0582
        L_0x0143:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = T(r13, r8)
            r14.s(r7, r8)
            goto L_0x0582
        L_0x0156:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = S(r13, r8)
            r14.h(r7, r6)
            goto L_0x0582
        L_0x0169:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = T(r13, r8)
            r14.f(r7, r8)
            goto L_0x0582
        L_0x017c:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = T(r13, r8)
            r14.u(r7, r8)
            goto L_0x0582
        L_0x018f:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            float r6 = R(r13, r8)
            r14.B(r7, r6)
            goto L_0x0582
        L_0x01a2:
            boolean r8 = r12.B(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            double r8 = Q(r13, r8)
            r14.p(r7, r8)
            goto L_0x0582
        L_0x01b5:
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            r12.j0(r14, r7, r6, r5)
            goto L_0x0582
        L_0x01c2:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.y0 r8 = r12.p(r5)
            androidx.datastore.preferences.protobuf.a1.U(r7, r6, r14, r8)
            goto L_0x0582
        L_0x01d9:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.b0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ec:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.a0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ff:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.Z(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0212:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.Y(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0225:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.Q(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0238:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.d0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x024b:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.N(r7, r6, r14, r9)
            goto L_0x0582
        L_0x025e:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.R(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0271:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.S(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0284:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.V(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0297:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.e0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02aa:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.W(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02bd:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.T(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02d0:
            int r7 = r12.N(r5)
            long r10 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.P(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02e3:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.b0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x02f6:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.a0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0309:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.Z(r7, r6, r14, r4)
            goto L_0x0582
        L_0x031c:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.Y(r7, r6, r14, r4)
            goto L_0x0582
        L_0x032f:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.Q(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0342:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.d0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0355:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.O(r7, r6, r14)
            goto L_0x0582
        L_0x0368:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.y0 r8 = r12.p(r5)
            androidx.datastore.preferences.protobuf.a1.X(r7, r6, r14, r8)
            goto L_0x0582
        L_0x037f:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.c0(r7, r6, r14)
            goto L_0x0582
        L_0x0392:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.N(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03a5:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.R(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03b8:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.S(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03cb:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.V(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03de:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.e0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03f1:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.W(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0404:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.T(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0417:
            int r7 = r12.N(r5)
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.a1.P(r7, r6, r14, r4)
            goto L_0x0582
        L_0x042a:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            androidx.datastore.preferences.protobuf.y0 r8 = r12.p(r5)
            r14.N(r7, r6, r8)
            goto L_0x0582
        L_0x0441:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = E(r13, r8)
            r14.m(r7, r8)
            goto L_0x0582
        L_0x0454:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = t(r13, r8)
            r14.H(r7, r6)
            goto L_0x0582
        L_0x0467:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = E(r13, r8)
            r14.i(r7, r8)
            goto L_0x0582
        L_0x047a:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = t(r13, r8)
            r14.w(r7, r6)
            goto L_0x0582
        L_0x048d:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = t(r13, r8)
            r14.E(r7, r6)
            goto L_0x0582
        L_0x04a0:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = t(r13, r8)
            r14.o(r7, r6)
            goto L_0x0582
        L_0x04b3:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            r14.K(r7, r6)
            goto L_0x0582
        L_0x04c8:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            androidx.datastore.preferences.protobuf.y0 r8 = r12.p(r5)
            r14.L(r7, r6, r8)
            goto L_0x0582
        L_0x04df:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r13, r8)
            r12.k0(r7, r6, r14)
            goto L_0x0582
        L_0x04f2:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            boolean r6 = h(r13, r8)
            r14.v(r7, r6)
            goto L_0x0582
        L_0x0505:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = t(r13, r8)
            r14.c(r7, r6)
            goto L_0x0582
        L_0x0517:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = E(r13, r8)
            r14.s(r7, r8)
            goto L_0x0582
        L_0x0529:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            int r6 = t(r13, r8)
            r14.h(r7, r6)
            goto L_0x0582
        L_0x053b:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = E(r13, r8)
            r14.f(r7, r8)
            goto L_0x0582
        L_0x054d:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            long r8 = E(r13, r8)
            r14.u(r7, r8)
            goto L_0x0582
        L_0x055f:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            float r6 = m(r13, r8)
            r14.B(r7, r6)
            goto L_0x0582
        L_0x0571:
            boolean r8 = r12.v(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = O(r6)
            double r8 = i(r13, r8)
            r14.p(r7, r8)
        L_0x0582:
            int r5 = r5 + 3
            goto L_0x0023
        L_0x0586:
            if (r2 == 0) goto L_0x059c
            androidx.datastore.preferences.protobuf.o<?> r3 = r12.f5352p
            r3.j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x059a
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0586
        L_0x059a:
            r2 = r1
            goto L_0x0586
        L_0x059c:
            androidx.datastore.preferences.protobuf.e1<?, ?> r0 = r12.f5351o
            r12.l0(r0, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.h0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    private static <T> double i(T t10, long j10) {
        return i1.v(t10, j10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i0(T r11, androidx.datastore.preferences.protobuf.Writer r12) throws java.io.IOException {
        /*
            r10 = this;
            androidx.datastore.preferences.protobuf.e1<?, ?> r0 = r10.f5351o
            r10.l0(r0, r11, r12)
            boolean r0 = r10.f5342f
            r1 = 0
            if (r0 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.o<?> r0 = r10.f5352p
            androidx.datastore.preferences.protobuf.s r0 = r0.c(r11)
            boolean r2 = r0.n()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.g()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0023
        L_0x0021:
            r0 = r1
            r2 = r0
        L_0x0023:
            int[] r3 = r10.f5337a
            int r3 = r3.length
            int r3 = r3 + -3
        L_0x0028:
            if (r3 < 0) goto L_0x058c
            int r4 = r10.f0(r3)
            int r5 = r10.N(r3)
        L_0x0032:
            if (r2 == 0) goto L_0x0050
            androidx.datastore.preferences.protobuf.o<?> r6 = r10.f5352p
            int r6 = r6.a(r2)
            if (r6 <= r5) goto L_0x0050
            androidx.datastore.preferences.protobuf.o<?> r6 = r10.f5352p
            r6.j(r12, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0032
        L_0x004e:
            r2 = r1
            goto L_0x0032
        L_0x0050:
            int r6 = e0(r4)
            r7 = 1
            r8 = 0
            switch(r6) {
                case 0: goto L_0x0577;
                case 1: goto L_0x0565;
                case 2: goto L_0x0553;
                case 3: goto L_0x0541;
                case 4: goto L_0x052f;
                case 5: goto L_0x051d;
                case 6: goto L_0x050b;
                case 7: goto L_0x04f8;
                case 8: goto L_0x04e5;
                case 9: goto L_0x04ce;
                case 10: goto L_0x04b9;
                case 11: goto L_0x04a6;
                case 12: goto L_0x0493;
                case 13: goto L_0x0480;
                case 14: goto L_0x046d;
                case 15: goto L_0x045a;
                case 16: goto L_0x0447;
                case 17: goto L_0x0430;
                case 18: goto L_0x041d;
                case 19: goto L_0x040a;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03e4;
                case 22: goto L_0x03d1;
                case 23: goto L_0x03be;
                case 24: goto L_0x03ab;
                case 25: goto L_0x0398;
                case 26: goto L_0x0385;
                case 27: goto L_0x036e;
                case 28: goto L_0x035b;
                case 29: goto L_0x0348;
                case 30: goto L_0x0335;
                case 31: goto L_0x0322;
                case 32: goto L_0x030f;
                case 33: goto L_0x02fc;
                case 34: goto L_0x02e9;
                case 35: goto L_0x02d6;
                case 36: goto L_0x02c3;
                case 37: goto L_0x02b0;
                case 38: goto L_0x029d;
                case 39: goto L_0x028a;
                case 40: goto L_0x0277;
                case 41: goto L_0x0264;
                case 42: goto L_0x0251;
                case 43: goto L_0x023e;
                case 44: goto L_0x022b;
                case 45: goto L_0x0218;
                case 46: goto L_0x0205;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01df;
                case 49: goto L_0x01c8;
                case 50: goto L_0x01bb;
                case 51: goto L_0x01a8;
                case 52: goto L_0x0195;
                case 53: goto L_0x0182;
                case 54: goto L_0x016f;
                case 55: goto L_0x015c;
                case 56: goto L_0x0149;
                case 57: goto L_0x0136;
                case 58: goto L_0x0123;
                case 59: goto L_0x0110;
                case 60: goto L_0x00f9;
                case 61: goto L_0x00e4;
                case 62: goto L_0x00d1;
                case 63: goto L_0x00be;
                case 64: goto L_0x00ab;
                case 65: goto L_0x0098;
                case 66: goto L_0x0085;
                case 67: goto L_0x0072;
                case 68: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0588
        L_0x005b:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            androidx.datastore.preferences.protobuf.y0 r6 = r10.p(r3)
            r12.N(r5, r4, r6)
            goto L_0x0588
        L_0x0072:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = T(r11, r6)
            r12.m(r5, r6)
            goto L_0x0588
        L_0x0085:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = S(r11, r6)
            r12.H(r5, r4)
            goto L_0x0588
        L_0x0098:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = T(r11, r6)
            r12.i(r5, r6)
            goto L_0x0588
        L_0x00ab:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = S(r11, r6)
            r12.w(r5, r4)
            goto L_0x0588
        L_0x00be:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = S(r11, r6)
            r12.E(r5, r4)
            goto L_0x0588
        L_0x00d1:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = S(r11, r6)
            r12.o(r5, r4)
            goto L_0x0588
        L_0x00e4:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.K(r5, r4)
            goto L_0x0588
        L_0x00f9:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            androidx.datastore.preferences.protobuf.y0 r6 = r10.p(r3)
            r12.L(r5, r4, r6)
            goto L_0x0588
        L_0x0110:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            r10.k0(r5, r4, r12)
            goto L_0x0588
        L_0x0123:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            boolean r4 = P(r11, r6)
            r12.v(r5, r4)
            goto L_0x0588
        L_0x0136:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = S(r11, r6)
            r12.c(r5, r4)
            goto L_0x0588
        L_0x0149:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = T(r11, r6)
            r12.s(r5, r6)
            goto L_0x0588
        L_0x015c:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = S(r11, r6)
            r12.h(r5, r4)
            goto L_0x0588
        L_0x016f:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = T(r11, r6)
            r12.f(r5, r6)
            goto L_0x0588
        L_0x0182:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = T(r11, r6)
            r12.u(r5, r6)
            goto L_0x0588
        L_0x0195:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            float r4 = R(r11, r6)
            r12.B(r5, r4)
            goto L_0x0588
        L_0x01a8:
            boolean r6 = r10.B(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            double r6 = Q(r11, r6)
            r12.p(r5, r6)
            goto L_0x0588
        L_0x01bb:
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            r10.j0(r12, r5, r4, r3)
            goto L_0x0588
        L_0x01c8:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.y0 r6 = r10.p(r3)
            androidx.datastore.preferences.protobuf.a1.U(r5, r4, r12, r6)
            goto L_0x0588
        L_0x01df:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.b0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x01f2:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.a0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0205:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.Z(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0218:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.Y(r5, r4, r12, r7)
            goto L_0x0588
        L_0x022b:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.Q(r5, r4, r12, r7)
            goto L_0x0588
        L_0x023e:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.d0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0251:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.N(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0264:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.R(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0277:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.S(r5, r4, r12, r7)
            goto L_0x0588
        L_0x028a:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.V(r5, r4, r12, r7)
            goto L_0x0588
        L_0x029d:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.e0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02b0:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.W(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02c3:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.T(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02d6:
            int r5 = r10.N(r3)
            long r8 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.P(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02e9:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.b0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02fc:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.a0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x030f:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.Z(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0322:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.Y(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0335:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.Q(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0348:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.d0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x035b:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.O(r5, r4, r12)
            goto L_0x0588
        L_0x036e:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.y0 r6 = r10.p(r3)
            androidx.datastore.preferences.protobuf.a1.X(r5, r4, r12, r6)
            goto L_0x0588
        L_0x0385:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.c0(r5, r4, r12)
            goto L_0x0588
        L_0x0398:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.N(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03ab:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.R(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03be:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.S(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03d1:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.V(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03e4:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.e0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03f7:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.W(r5, r4, r12, r8)
            goto L_0x0588
        L_0x040a:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.T(r5, r4, r12, r8)
            goto L_0x0588
        L_0x041d:
            int r5 = r10.N(r3)
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.a1.P(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0430:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            androidx.datastore.preferences.protobuf.y0 r6 = r10.p(r3)
            r12.N(r5, r4, r6)
            goto L_0x0588
        L_0x0447:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = E(r11, r6)
            r12.m(r5, r6)
            goto L_0x0588
        L_0x045a:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = t(r11, r6)
            r12.H(r5, r4)
            goto L_0x0588
        L_0x046d:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = E(r11, r6)
            r12.i(r5, r6)
            goto L_0x0588
        L_0x0480:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = t(r11, r6)
            r12.w(r5, r4)
            goto L_0x0588
        L_0x0493:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = t(r11, r6)
            r12.E(r5, r4)
            goto L_0x0588
        L_0x04a6:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = t(r11, r6)
            r12.o(r5, r4)
            goto L_0x0588
        L_0x04b9:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.K(r5, r4)
            goto L_0x0588
        L_0x04ce:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            androidx.datastore.preferences.protobuf.y0 r6 = r10.p(r3)
            r12.L(r5, r4, r6)
            goto L_0x0588
        L_0x04e5:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.i1.A(r11, r6)
            r10.k0(r5, r4, r12)
            goto L_0x0588
        L_0x04f8:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            boolean r4 = h(r11, r6)
            r12.v(r5, r4)
            goto L_0x0588
        L_0x050b:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = t(r11, r6)
            r12.c(r5, r4)
            goto L_0x0588
        L_0x051d:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = E(r11, r6)
            r12.s(r5, r6)
            goto L_0x0588
        L_0x052f:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            int r4 = t(r11, r6)
            r12.h(r5, r4)
            goto L_0x0588
        L_0x0541:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = E(r11, r6)
            r12.f(r5, r6)
            goto L_0x0588
        L_0x0553:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            long r6 = E(r11, r6)
            r12.u(r5, r6)
            goto L_0x0588
        L_0x0565:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            float r4 = m(r11, r6)
            r12.B(r5, r4)
            goto L_0x0588
        L_0x0577:
            boolean r6 = r10.v(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = O(r4)
            double r6 = i(r11, r6)
            r12.p(r5, r6)
        L_0x0588:
            int r3 = r3 + -3
            goto L_0x0028
        L_0x058c:
            if (r2 == 0) goto L_0x05a3
            androidx.datastore.preferences.protobuf.o<?> r11 = r10.f5352p
            r11.j(r12, r2)
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x05a1
            java.lang.Object r11 = r0.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            r2 = r11
            goto L_0x058c
        L_0x05a1:
            r2 = r1
            goto L_0x058c
        L_0x05a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.i0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    private boolean j(T t10, T t11, int i10) {
        int f02 = f0(i10);
        long O = O(f02);
        switch (e0(f02)) {
            case 0:
                if (!g(t10, t11, i10) || Double.doubleToLongBits(i1.v(t10, O)) != Double.doubleToLongBits(i1.v(t11, O))) {
                    return false;
                }
                return true;
            case 1:
                if (!g(t10, t11, i10) || Float.floatToIntBits(i1.w(t10, O)) != Float.floatToIntBits(i1.w(t11, O))) {
                    return false;
                }
                return true;
            case 2:
                if (!g(t10, t11, i10) || i1.y(t10, O) != i1.y(t11, O)) {
                    return false;
                }
                return true;
            case 3:
                if (!g(t10, t11, i10) || i1.y(t10, O) != i1.y(t11, O)) {
                    return false;
                }
                return true;
            case 4:
                if (!g(t10, t11, i10) || i1.x(t10, O) != i1.x(t11, O)) {
                    return false;
                }
                return true;
            case 5:
                if (!g(t10, t11, i10) || i1.y(t10, O) != i1.y(t11, O)) {
                    return false;
                }
                return true;
            case 6:
                if (!g(t10, t11, i10) || i1.x(t10, O) != i1.x(t11, O)) {
                    return false;
                }
                return true;
            case 7:
                if (!g(t10, t11, i10) || i1.p(t10, O) != i1.p(t11, O)) {
                    return false;
                }
                return true;
            case 8:
                if (!g(t10, t11, i10) || !a1.K(i1.A(t10, O), i1.A(t11, O))) {
                    return false;
                }
                return true;
            case 9:
                if (!g(t10, t11, i10) || !a1.K(i1.A(t10, O), i1.A(t11, O))) {
                    return false;
                }
                return true;
            case 10:
                if (!g(t10, t11, i10) || !a1.K(i1.A(t10, O), i1.A(t11, O))) {
                    return false;
                }
                return true;
            case 11:
                if (!g(t10, t11, i10) || i1.x(t10, O) != i1.x(t11, O)) {
                    return false;
                }
                return true;
            case 12:
                if (!g(t10, t11, i10) || i1.x(t10, O) != i1.x(t11, O)) {
                    return false;
                }
                return true;
            case 13:
                if (!g(t10, t11, i10) || i1.x(t10, O) != i1.x(t11, O)) {
                    return false;
                }
                return true;
            case 14:
                if (!g(t10, t11, i10) || i1.y(t10, O) != i1.y(t11, O)) {
                    return false;
                }
                return true;
            case 15:
                if (!g(t10, t11, i10) || i1.x(t10, O) != i1.x(t11, O)) {
                    return false;
                }
                return true;
            case 16:
                if (!g(t10, t11, i10) || i1.y(t10, O) != i1.y(t11, O)) {
                    return false;
                }
                return true;
            case 17:
                if (!g(t10, t11, i10) || !a1.K(i1.A(t10, O), i1.A(t11, O))) {
                    return false;
                }
                return true;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return a1.K(i1.A(t10, O), i1.A(t11, O));
            case 50:
                return a1.K(i1.A(t10, O), i1.A(t11, O));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!A(t10, t11, i10) || !a1.K(i1.A(t10, O), i1.A(t11, O))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    private <K, V> void j0(Writer writer, int i10, Object obj, int i11) throws IOException {
        if (obj != null) {
            writer.M(i10, this.f5353q.b(o(i11)), this.f5353q.e(obj));
        }
    }

    private final <UT, UB> UB k(Object obj, int i10, UB ub2, e1<UT, UB> e1Var) {
        w.e n10;
        int N = N(i10);
        Object A = i1.A(obj, O(f0(i10)));
        if (A == null || (n10 = n(i10)) == null) {
            return ub2;
        }
        return l(i10, N, this.f5353q.c(A), n10, ub2, e1Var);
    }

    private void k0(int i10, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.e(i10, (String) obj);
        } else {
            writer.K(i10, (ByteString) obj);
        }
    }

    private final <K, V, UT, UB> UB l(int i10, int i11, Map<K, V> map, w.e eVar, UB ub2, e1<UT, UB> e1Var) {
        e0.a<?, ?> b10 = this.f5353q.b(o(i10));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!eVar.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = e1Var.n();
                }
                ByteString.g r10 = ByteString.r(e0.b(b10, next.getKey(), next.getValue()));
                try {
                    e0.e(r10.b(), b10, next.getKey(), next.getValue());
                    e1Var.d(ub2, i11, r10.a());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub2;
    }

    private <UT, UB> void l0(e1<UT, UB> e1Var, T t10, Writer writer) throws IOException {
        e1Var.t(e1Var.g(t10), writer);
    }

    private static <T> float m(T t10, long j10) {
        return i1.w(t10, j10);
    }

    private w.e n(int i10) {
        return (w.e) this.f5338b[((i10 / 3) * 2) + 1];
    }

    private Object o(int i10) {
        return this.f5338b[(i10 / 3) * 2];
    }

    private y0 p(int i10) {
        int i11 = (i10 / 3) * 2;
        y0 y0Var = (y0) this.f5338b[i11];
        if (y0Var != null) {
            return y0Var;
        }
        y0 d10 = u0.a().d((Class) this.f5338b[i11 + 1]);
        this.f5338b[i11] = d10;
        return d10;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0347, code lost:
        r4 = (r4 + r8) + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0413, code lost:
        r6 = r6 + r3;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0465, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x051c, code lost:
        r5 = r5 + 3;
        r4 = r16;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int q(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            sun.misc.Unsafe r2 = f5336s
            r4 = -1
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x000a:
            int[] r8 = r0.f5337a
            int r8 = r8.length
            if (r5 >= r8) goto L_0x0522
            int r8 = r0.f0(r5)
            int r9 = r0.N(r5)
            int r10 = e0(r8)
            r11 = 17
            r12 = 1048575(0xfffff, float:1.469367E-39)
            r13 = 1
            if (r10 > r11) goto L_0x0039
            int[] r11 = r0.f5337a
            int r14 = r5 + 2
            r11 = r11[r14]
            r12 = r12 & r11
            int r14 = r11 >>> 20
            int r14 = r13 << r14
            r15 = r14
            if (r12 == r4) goto L_0x0037
            long r13 = (long) r12
            int r7 = r2.getInt(r1, r13)
            r4 = r12
        L_0x0037:
            r14 = r15
            goto L_0x0057
        L_0x0039:
            boolean r11 = r0.f5345i
            if (r11 == 0) goto L_0x0055
            androidx.datastore.preferences.protobuf.FieldType r11 = androidx.datastore.preferences.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r11 = r11.a()
            if (r10 < r11) goto L_0x0055
            androidx.datastore.preferences.protobuf.FieldType r11 = androidx.datastore.preferences.protobuf.FieldType.SINT64_LIST_PACKED
            int r11 = r11.a()
            if (r10 > r11) goto L_0x0055
            int[] r11 = r0.f5337a
            int r13 = r5 + 2
            r11 = r11[r13]
            r11 = r11 & r12
            goto L_0x0056
        L_0x0055:
            r11 = 0
        L_0x0056:
            r14 = 0
        L_0x0057:
            long r12 = O(r8)
            r8 = 0
            r16 = r4
            r3 = 0
            switch(r10) {
                case 0: goto L_0x0510;
                case 1: goto L_0x0506;
                case 2: goto L_0x04f8;
                case 3: goto L_0x04ea;
                case 4: goto L_0x04dc;
                case 5: goto L_0x04d2;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04bd;
                case 8: goto L_0x04a1;
                case 9: goto L_0x0490;
                case 10: goto L_0x0481;
                case 11: goto L_0x0474;
                case 12: goto L_0x0467;
                case 13: goto L_0x045c;
                case 14: goto L_0x0453;
                case 15: goto L_0x0446;
                case 16: goto L_0x0439;
                case 17: goto L_0x0426;
                case 18: goto L_0x0417;
                case 19: goto L_0x0408;
                case 20: goto L_0x03fc;
                case 21: goto L_0x03f0;
                case 22: goto L_0x03e4;
                case 23: goto L_0x03d8;
                case 24: goto L_0x03cc;
                case 25: goto L_0x03c0;
                case 26: goto L_0x03b5;
                case 27: goto L_0x03a5;
                case 28: goto L_0x0399;
                case 29: goto L_0x038c;
                case 30: goto L_0x037f;
                case 31: goto L_0x0372;
                case 32: goto L_0x0365;
                case 33: goto L_0x0358;
                case 34: goto L_0x034b;
                case 35: goto L_0x032b;
                case 36: goto L_0x030e;
                case 37: goto L_0x02f1;
                case 38: goto L_0x02d4;
                case 39: goto L_0x02b6;
                case 40: goto L_0x0298;
                case 41: goto L_0x027a;
                case 42: goto L_0x025c;
                case 43: goto L_0x023e;
                case 44: goto L_0x0220;
                case 45: goto L_0x0202;
                case 46: goto L_0x01e4;
                case 47: goto L_0x01c6;
                case 48: goto L_0x01a8;
                case 49: goto L_0x0198;
                case 50: goto L_0x0188;
                case 51: goto L_0x017a;
                case 52: goto L_0x016e;
                case 53: goto L_0x015e;
                case 54: goto L_0x014e;
                case 55: goto L_0x013e;
                case 56: goto L_0x0132;
                case 57: goto L_0x0125;
                case 58: goto L_0x0118;
                case 59: goto L_0x00fa;
                case 60: goto L_0x00e6;
                case 61: goto L_0x00d4;
                case 62: goto L_0x00c4;
                case 63: goto L_0x00b4;
                case 64: goto L_0x00a7;
                case 65: goto L_0x009b;
                case 66: goto L_0x008b;
                case 67: goto L_0x007b;
                case 68: goto L_0x0065;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x0423
        L_0x0065:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.k0 r3 = (androidx.datastore.preferences.protobuf.k0) r3
            androidx.datastore.preferences.protobuf.y0 r4 = r0.p(r5)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.s(r9, r3, r4)
            goto L_0x0422
        L_0x007b:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            long r3 = T(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.R(r9, r3)
            goto L_0x0422
        L_0x008b:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = S(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.P(r9, r3)
            goto L_0x0422
        L_0x009b:
            boolean r8 = r0.B(r1, r9, r5)
            if (r8 == 0) goto L_0x0423
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.N(r9, r3)
            goto L_0x0422
        L_0x00a7:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            r3 = 0
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.L(r9, r3)
            goto L_0x0465
        L_0x00b4:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = S(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.k(r9, r3)
            goto L_0x0422
        L_0x00c4:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = S(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.W(r9, r3)
            goto L_0x0422
        L_0x00d4:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.g(r9, r3)
            goto L_0x0422
        L_0x00e6:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.y0 r4 = r0.p(r5)
            int r3 = androidx.datastore.preferences.protobuf.a1.o(r9, r3, r4)
            goto L_0x0422
        L_0x00fa:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            boolean r4 = r3 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r4 == 0) goto L_0x0110
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.g(r9, r3)
            goto L_0x0422
        L_0x0110:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.T(r9, r3)
            goto L_0x0422
        L_0x0118:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            r3 = 1
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.d(r9, r3)
            goto L_0x0422
        L_0x0125:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            r3 = 0
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.m(r9, r3)
            goto L_0x0465
        L_0x0132:
            boolean r8 = r0.B(r1, r9, r5)
            if (r8 == 0) goto L_0x0423
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.o(r9, r3)
            goto L_0x0422
        L_0x013e:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = S(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.v(r9, r3)
            goto L_0x0422
        L_0x014e:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            long r3 = T(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.Y(r9, r3)
            goto L_0x0422
        L_0x015e:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            long r3 = T(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.x(r9, r3)
            goto L_0x0422
        L_0x016e:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.q(r9, r8)
            goto L_0x0422
        L_0x017a:
            boolean r3 = r0.B(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            r3 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.i(r9, r3)
            goto L_0x0422
        L_0x0188:
            androidx.datastore.preferences.protobuf.f0 r3 = r0.f5353q
            java.lang.Object r4 = r2.getObject(r1, r12)
            java.lang.Object r8 = r0.o(r5)
            int r3 = r3.g(r9, r4, r8)
            goto L_0x0422
        L_0x0198:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.y0 r4 = r0.p(r5)
            int r3 = androidx.datastore.preferences.protobuf.a1.j(r9, r3, r4)
            goto L_0x0422
        L_0x01a8:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.t(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x01bc
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01bc:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x01c6:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.r(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x01da
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01da:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x01e4:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.i(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x01f8
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01f8:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x0202:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.g(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x0216
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0216:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x0220:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.e(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x0234
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0234:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x023e:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.w(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x0252
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0252:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x025c:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.b(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x0270
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0270:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x027a:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.g(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x028e
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x028e:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x0298:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.i(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x02ac
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02ac:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x02b6:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.l(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x02ca
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02ca:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x02d4:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.y(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x02e8
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02e8:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x02f1:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.n(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x0305
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0305:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x030e:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.g(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x0322
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0322:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
            goto L_0x0347
        L_0x032b:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.i(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f5345i
            if (r4 == 0) goto L_0x033f
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x033f:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r3)
        L_0x0347:
            int r4 = r4 + r8
            int r4 = r4 + r3
            goto L_0x0465
        L_0x034b:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = androidx.datastore.preferences.protobuf.a1.s(r9, r3, r4)
            goto L_0x0413
        L_0x0358:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.q(r9, r3, r4)
            goto L_0x0413
        L_0x0365:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.h(r9, r3, r4)
            goto L_0x0413
        L_0x0372:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.f(r9, r3, r4)
            goto L_0x0413
        L_0x037f:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.d(r9, r3, r4)
            goto L_0x0413
        L_0x038c:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.v(r9, r3, r4)
            goto L_0x0422
        L_0x0399:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.c(r9, r3)
            goto L_0x0422
        L_0x03a5:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.y0 r4 = r0.p(r5)
            int r3 = androidx.datastore.preferences.protobuf.a1.p(r9, r3, r4)
            goto L_0x0422
        L_0x03b5:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.u(r9, r3)
            goto L_0x0422
        L_0x03c0:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = androidx.datastore.preferences.protobuf.a1.a(r9, r3, r4)
            goto L_0x0413
        L_0x03cc:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.f(r9, r3, r4)
            goto L_0x0413
        L_0x03d8:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.h(r9, r3, r4)
            goto L_0x0413
        L_0x03e4:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.k(r9, r3, r4)
            goto L_0x0413
        L_0x03f0:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.x(r9, r3, r4)
            goto L_0x0413
        L_0x03fc:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.m(r9, r3, r4)
            goto L_0x0413
        L_0x0408:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.f(r9, r3, r4)
        L_0x0413:
            int r6 = r6 + r3
            r10 = r4
            goto L_0x051c
        L_0x0417:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.a1.h(r9, r3, r4)
        L_0x0422:
            int r6 = r6 + r3
        L_0x0423:
            r10 = 0
            goto L_0x051c
        L_0x0426:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.k0 r3 = (androidx.datastore.preferences.protobuf.k0) r3
            androidx.datastore.preferences.protobuf.y0 r4 = r0.p(r5)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.s(r9, r3, r4)
            goto L_0x0422
        L_0x0439:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            long r3 = r2.getLong(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.R(r9, r3)
            goto L_0x0422
        L_0x0446:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.P(r9, r3)
            goto L_0x0422
        L_0x0453:
            r8 = r7 & r14
            if (r8 == 0) goto L_0x0423
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.N(r9, r3)
            goto L_0x0422
        L_0x045c:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            r3 = 0
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.L(r9, r3)
        L_0x0465:
            int r6 = r6 + r4
            goto L_0x0423
        L_0x0467:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.k(r9, r3)
            goto L_0x0422
        L_0x0474:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.W(r9, r3)
            goto L_0x0422
        L_0x0481:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.g(r9, r3)
            goto L_0x0422
        L_0x0490:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.y0 r4 = r0.p(r5)
            int r3 = androidx.datastore.preferences.protobuf.a1.o(r9, r3, r4)
            goto L_0x0422
        L_0x04a1:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            boolean r4 = r3 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r4 == 0) goto L_0x04b5
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.g(r9, r3)
            goto L_0x0422
        L_0x04b5:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.T(r9, r3)
            goto L_0x0422
        L_0x04bd:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            r3 = 1
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.d(r9, r3)
            goto L_0x0422
        L_0x04c8:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            r10 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.m(r9, r10)
            goto L_0x051b
        L_0x04d2:
            r10 = 0
            r8 = r7 & r14
            if (r8 == 0) goto L_0x051c
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.o(r9, r3)
            goto L_0x051b
        L_0x04dc:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.v(r9, r3)
            goto L_0x051b
        L_0x04ea:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            long r3 = r2.getLong(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.Y(r9, r3)
            goto L_0x051b
        L_0x04f8:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            long r3 = r2.getLong(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.x(r9, r3)
            goto L_0x051b
        L_0x0506:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.q(r9, r8)
            goto L_0x051b
        L_0x0510:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            r3 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.i(r9, r3)
        L_0x051b:
            int r6 = r6 + r3
        L_0x051c:
            int r5 = r5 + 3
            r4 = r16
            goto L_0x000a
        L_0x0522:
            androidx.datastore.preferences.protobuf.e1<?, ?> r2 = r0.f5351o
            int r2 = r0.s(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.f5342f
            if (r2 == 0) goto L_0x0538
            androidx.datastore.preferences.protobuf.o<?> r2 = r0.f5352p
            androidx.datastore.preferences.protobuf.s r1 = r2.c(r1)
            int r1 = r1.l()
            int r6 = r6 + r1
        L_0x0538:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.q(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int r(T r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = f5336s
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0008:
            int[] r6 = r0.f5337a
            int r6 = r6.length
            if (r4 >= r6) goto L_0x04e3
            int r6 = r15.f0(r4)
            int r7 = e0(r6)
            int r8 = r15.N(r4)
            long r9 = O(r6)
            androidx.datastore.preferences.protobuf.FieldType r6 = androidx.datastore.preferences.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r6 = r6.a()
            if (r7 < r6) goto L_0x0038
            androidx.datastore.preferences.protobuf.FieldType r6 = androidx.datastore.preferences.protobuf.FieldType.SINT64_LIST_PACKED
            int r6 = r6.a()
            if (r7 > r6) goto L_0x0038
            int[] r6 = r0.f5337a
            int r11 = r4 + 2
            r6 = r6[r11]
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r6 & r11
            goto L_0x0039
        L_0x0038:
            r6 = r3
        L_0x0039:
            r11 = 1
            r12 = 0
            r13 = 0
            switch(r7) {
                case 0: goto L_0x04d1;
                case 1: goto L_0x04c5;
                case 2: goto L_0x04b5;
                case 3: goto L_0x04a5;
                case 4: goto L_0x0495;
                case 5: goto L_0x0489;
                case 6: goto L_0x047d;
                case 7: goto L_0x0471;
                case 8: goto L_0x0453;
                case 9: goto L_0x043f;
                case 10: goto L_0x042e;
                case 11: goto L_0x041f;
                case 12: goto L_0x0410;
                case 13: goto L_0x0405;
                case 14: goto L_0x03fa;
                case 15: goto L_0x03eb;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03bc;
                case 19: goto L_0x03b3;
                case 20: goto L_0x03aa;
                case 21: goto L_0x03a1;
                case 22: goto L_0x0398;
                case 23: goto L_0x038f;
                case 24: goto L_0x0386;
                case 25: goto L_0x037d;
                case 26: goto L_0x0374;
                case 27: goto L_0x0367;
                case 28: goto L_0x035e;
                case 29: goto L_0x0355;
                case 30: goto L_0x034b;
                case 31: goto L_0x0341;
                case 32: goto L_0x0337;
                case 33: goto L_0x032d;
                case 34: goto L_0x0323;
                case 35: goto L_0x0303;
                case 36: goto L_0x02e6;
                case 37: goto L_0x02c9;
                case 38: goto L_0x02ac;
                case 39: goto L_0x028e;
                case 40: goto L_0x0270;
                case 41: goto L_0x0252;
                case 42: goto L_0x0234;
                case 43: goto L_0x0216;
                case 44: goto L_0x01f8;
                case 45: goto L_0x01da;
                case 46: goto L_0x01bc;
                case 47: goto L_0x019e;
                case 48: goto L_0x0180;
                case 49: goto L_0x0172;
                case 50: goto L_0x0162;
                case 51: goto L_0x0154;
                case 52: goto L_0x0148;
                case 53: goto L_0x0138;
                case 54: goto L_0x0128;
                case 55: goto L_0x0118;
                case 56: goto L_0x010c;
                case 57: goto L_0x0100;
                case 58: goto L_0x00f4;
                case 59: goto L_0x00d6;
                case 60: goto L_0x00c2;
                case 61: goto L_0x00b0;
                case 62: goto L_0x00a0;
                case 63: goto L_0x0090;
                case 64: goto L_0x0084;
                case 65: goto L_0x0078;
                case 66: goto L_0x0068;
                case 67: goto L_0x0058;
                case 68: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x04df
        L_0x0042:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r1, r9)
            androidx.datastore.preferences.protobuf.k0 r6 = (androidx.datastore.preferences.protobuf.k0) r6
            androidx.datastore.preferences.protobuf.y0 r7 = r15.p(r4)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.s(r8, r6, r7)
            goto L_0x03c4
        L_0x0058:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = T(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.R(r8, r6)
            goto L_0x03c4
        L_0x0068:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = S(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.P(r8, r6)
            goto L_0x03c4
        L_0x0078:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.N(r8, r13)
            goto L_0x03c4
        L_0x0084:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.L(r8, r3)
            goto L_0x03c4
        L_0x0090:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = S(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.k(r8, r6)
            goto L_0x03c4
        L_0x00a0:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = S(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.W(r8, r6)
            goto L_0x03c4
        L_0x00b0:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r1, r9)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.g(r8, r6)
            goto L_0x03c4
        L_0x00c2:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r1, r9)
            androidx.datastore.preferences.protobuf.y0 r7 = r15.p(r4)
            int r6 = androidx.datastore.preferences.protobuf.a1.o(r8, r6, r7)
            goto L_0x03c4
        L_0x00d6:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r1, r9)
            boolean r7 = r6 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r7 == 0) goto L_0x00ec
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.g(r8, r6)
            goto L_0x03c4
        L_0x00ec:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.T(r8, r6)
            goto L_0x03c4
        L_0x00f4:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d(r8, r11)
            goto L_0x03c4
        L_0x0100:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.m(r8, r3)
            goto L_0x03c4
        L_0x010c:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.o(r8, r13)
            goto L_0x03c4
        L_0x0118:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = S(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.v(r8, r6)
            goto L_0x03c4
        L_0x0128:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = T(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.Y(r8, r6)
            goto L_0x03c4
        L_0x0138:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = T(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.x(r8, r6)
            goto L_0x03c4
        L_0x0148:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.q(r8, r12)
            goto L_0x03c4
        L_0x0154:
            boolean r6 = r15.B(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            r6 = 0
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.i(r8, r6)
            goto L_0x03c4
        L_0x0162:
            androidx.datastore.preferences.protobuf.f0 r6 = r0.f5353q
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.i1.A(r1, r9)
            java.lang.Object r9 = r15.o(r4)
            int r6 = r6.g(r8, r7, r9)
            goto L_0x03c4
        L_0x0172:
            java.util.List r6 = D(r1, r9)
            androidx.datastore.preferences.protobuf.y0 r7 = r15.p(r4)
            int r6 = androidx.datastore.preferences.protobuf.a1.j(r8, r6, r7)
            goto L_0x03c4
        L_0x0180:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.t(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x0194
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0194:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x019e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.r(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x01b2
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01b2:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x01bc:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x01d0
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01d0:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x01da:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x01ee
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01ee:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x01f8:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.e(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x020c
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x020c:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x0216:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.w(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x022a
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x022a:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x0234:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.b(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x0248
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0248:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x0252:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x0266
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0266:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x0270:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x0284
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0284:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x028e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.l(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x02a2
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02a2:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x02ac:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.y(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x02c0
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02c0:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x02c9:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.n(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x02dd
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02dd:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x02e6:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x02fa
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02fa:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
            goto L_0x031f
        L_0x0303:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.a1.i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f5345i
            if (r9 == 0) goto L_0x0317
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0317:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.V(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.X(r7)
        L_0x031f:
            int r6 = r6 + r8
            int r6 = r6 + r7
            goto L_0x03c4
        L_0x0323:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.s(r8, r6, r3)
            goto L_0x03c4
        L_0x032d:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.q(r8, r6, r3)
            goto L_0x03c4
        L_0x0337:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.h(r8, r6, r3)
            goto L_0x03c4
        L_0x0341:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.f(r8, r6, r3)
            goto L_0x03c4
        L_0x034b:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.d(r8, r6, r3)
            goto L_0x03c4
        L_0x0355:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.v(r8, r6, r3)
            goto L_0x03c4
        L_0x035e:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.c(r8, r6)
            goto L_0x03c4
        L_0x0367:
            java.util.List r6 = D(r1, r9)
            androidx.datastore.preferences.protobuf.y0 r7 = r15.p(r4)
            int r6 = androidx.datastore.preferences.protobuf.a1.p(r8, r6, r7)
            goto L_0x03c4
        L_0x0374:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.u(r8, r6)
            goto L_0x03c4
        L_0x037d:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.a(r8, r6, r3)
            goto L_0x03c4
        L_0x0386:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.f(r8, r6, r3)
            goto L_0x03c4
        L_0x038f:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.h(r8, r6, r3)
            goto L_0x03c4
        L_0x0398:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.k(r8, r6, r3)
            goto L_0x03c4
        L_0x03a1:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.x(r8, r6, r3)
            goto L_0x03c4
        L_0x03aa:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.m(r8, r6, r3)
            goto L_0x03c4
        L_0x03b3:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.f(r8, r6, r3)
            goto L_0x03c4
        L_0x03bc:
            java.util.List r6 = D(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.a1.h(r8, r6, r3)
        L_0x03c4:
            int r5 = r5 + r6
            goto L_0x04df
        L_0x03c7:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r1, r9)
            androidx.datastore.preferences.protobuf.k0 r6 = (androidx.datastore.preferences.protobuf.k0) r6
            androidx.datastore.preferences.protobuf.y0 r7 = r15.p(r4)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.s(r8, r6, r7)
            goto L_0x03c4
        L_0x03dc:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = androidx.datastore.preferences.protobuf.i1.y(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.R(r8, r6)
            goto L_0x03c4
        L_0x03eb:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.i1.x(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.P(r8, r6)
            goto L_0x03c4
        L_0x03fa:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.N(r8, r13)
            goto L_0x03c4
        L_0x0405:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.L(r8, r3)
            goto L_0x03c4
        L_0x0410:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.i1.x(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.k(r8, r6)
            goto L_0x03c4
        L_0x041f:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.i1.x(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.W(r8, r6)
            goto L_0x03c4
        L_0x042e:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r1, r9)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.g(r8, r6)
            goto L_0x03c4
        L_0x043f:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r1, r9)
            androidx.datastore.preferences.protobuf.y0 r7 = r15.p(r4)
            int r6 = androidx.datastore.preferences.protobuf.a1.o(r8, r6, r7)
            goto L_0x03c4
        L_0x0453:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.i1.A(r1, r9)
            boolean r7 = r6 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r7 == 0) goto L_0x0469
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.g(r8, r6)
            goto L_0x03c4
        L_0x0469:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.T(r8, r6)
            goto L_0x03c4
        L_0x0471:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.d(r8, r11)
            goto L_0x03c4
        L_0x047d:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.m(r8, r3)
            goto L_0x03c4
        L_0x0489:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.o(r8, r13)
            goto L_0x03c4
        L_0x0495:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.i1.x(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.v(r8, r6)
            goto L_0x03c4
        L_0x04a5:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = androidx.datastore.preferences.protobuf.i1.y(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.Y(r8, r6)
            goto L_0x03c4
        L_0x04b5:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = androidx.datastore.preferences.protobuf.i1.y(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.x(r8, r6)
            goto L_0x03c4
        L_0x04c5:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.q(r8, r12)
            goto L_0x03c4
        L_0x04d1:
            boolean r6 = r15.v(r1, r4)
            if (r6 == 0) goto L_0x04df
            r6 = 0
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.i(r8, r6)
            goto L_0x03c4
        L_0x04df:
            int r4 = r4 + 3
            goto L_0x0008
        L_0x04e3:
            androidx.datastore.preferences.protobuf.e1<?, ?> r2 = r0.f5351o
            int r1 = r15.s(r2, r1)
            int r5 = r5 + r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.r(java.lang.Object):int");
    }

    private <UT, UB> int s(e1<UT, UB> e1Var, T t10) {
        return e1Var.h(e1Var.g(t10));
    }

    private static <T> int t(T t10, long j10) {
        return i1.x(t10, j10);
    }

    private static boolean u(int i10) {
        return (i10 & 536870912) != 0;
    }

    private boolean v(T t10, int i10) {
        if (this.f5344h) {
            int f02 = f0(i10);
            long O = O(f02);
            switch (e0(f02)) {
                case 0:
                    if (i1.v(t10, O) != 0.0d) {
                        return true;
                    }
                    return false;
                case 1:
                    if (i1.w(t10, O) != 0.0f) {
                        return true;
                    }
                    return false;
                case 2:
                    if (i1.y(t10, O) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (i1.y(t10, O) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (i1.x(t10, O) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (i1.y(t10, O) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (i1.x(t10, O) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return i1.p(t10, O);
                case 8:
                    Object A = i1.A(t10, O);
                    if (A instanceof String) {
                        return !((String) A).isEmpty();
                    }
                    if (A instanceof ByteString) {
                        return !ByteString.f5064a.equals(A);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (i1.A(t10, O) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    return !ByteString.f5064a.equals(i1.A(t10, O));
                case 11:
                    if (i1.x(t10, O) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (i1.x(t10, O) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (i1.x(t10, O) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (i1.y(t10, O) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (i1.x(t10, O) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (i1.y(t10, O) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (i1.A(t10, O) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int V = V(i10);
            if ((i1.x(t10, (long) (V & 1048575)) & (1 << (V >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    private boolean w(T t10, int i10, int i11, int i12) {
        if (this.f5344h) {
            return v(t10, i10);
        }
        if ((i11 & i12) != 0) {
            return true;
        }
        return false;
    }

    private static boolean x(Object obj, int i10, y0 y0Var) {
        return y0Var.c(i1.A(obj, O(i10)));
    }

    private <N> boolean y(Object obj, int i10, int i11) {
        List list = (List) i1.A(obj, O(i10));
        if (list.isEmpty()) {
            return true;
        }
        y0 p10 = p(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (!p10.c(list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    private boolean z(T t10, int i10, int i11) {
        Map<?, ?> e10 = this.f5353q.e(i1.A(t10, O(i10)));
        if (e10.isEmpty()) {
            return true;
        }
        if (this.f5353q.b(o(i11)).f5250c.a() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        y0<?> y0Var = null;
        for (Object next : e10.values()) {
            if (y0Var == null) {
                y0Var = u0.a().d(next.getClass());
            }
            if (!y0Var.c(next)) {
                return false;
            }
        }
        return true;
    }

    public void a(T t10, T t11) {
        t11.getClass();
        for (int i10 = 0; i10 < this.f5337a.length; i10 += 3) {
            J(t10, t11, i10);
        }
        if (!this.f5344h) {
            a1.G(this.f5351o, t10, t11);
            if (this.f5342f) {
                a1.E(this.f5352p, t10, t11);
            }
        }
    }

    public void b(T t10) {
        int i10;
        int i11 = this.f5347k;
        while (true) {
            i10 = this.f5348l;
            if (i11 >= i10) {
                break;
            }
            long O = O(f0(this.f5346j[i11]));
            Object A = i1.A(t10, O);
            if (A != null) {
                i1.O(t10, O, this.f5353q.f(A));
            }
            i11++;
        }
        int length = this.f5346j.length;
        while (i10 < length) {
            this.f5350n.c(t10, (long) this.f5346j[i10]);
            i10++;
        }
        this.f5351o.j(t10);
        if (this.f5342f) {
            this.f5352p.f(t10);
        }
    }

    public final boolean c(T t10) {
        int i10;
        int i11 = -1;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f5347k; i13++) {
            int i14 = this.f5346j[i13];
            int N = N(i14);
            int f02 = f0(i14);
            if (!this.f5344h) {
                int i15 = this.f5337a[i14 + 2];
                int i16 = 1048575 & i15;
                i10 = 1 << (i15 >>> 20);
                if (i16 != i11) {
                    i12 = f5336s.getInt(t10, (long) i16);
                    i11 = i16;
                }
            } else {
                i10 = 0;
            }
            if (C(f02) && !w(t10, i14, i12, i10)) {
                return false;
            }
            int e02 = e0(f02);
            if (e02 != 9 && e02 != 17) {
                if (e02 != 27) {
                    if (e02 == 60 || e02 == 68) {
                        if (B(t10, N, i14) && !x(t10, f02, p(i14))) {
                            return false;
                        }
                    } else if (e02 != 49) {
                        if (e02 == 50 && !z(t10, f02, i14)) {
                            return false;
                        }
                    }
                }
                if (!y(t10, f02, i14)) {
                    return false;
                }
            } else if (w(t10, i14, i12, i10) && !x(t10, f02, p(i14))) {
                return false;
            }
        }
        if (!this.f5342f || this.f5352p.c(t10).p()) {
            return true;
        }
        return false;
    }

    public int d(T t10) {
        return this.f5344h ? r(t10) : q(t10);
    }

    public void e(T t10, x0 x0Var, n nVar) throws IOException {
        nVar.getClass();
        F(this.f5351o, this.f5352p, t10, x0Var, nVar);
    }

    public boolean equals(T t10, T t11) {
        int length = this.f5337a.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            if (!j(t10, t11, i10)) {
                return false;
            }
        }
        if (!this.f5351o.g(t10).equals(this.f5351o.g(t11))) {
            return false;
        }
        if (this.f5342f) {
            return this.f5352p.c(t10).equals(this.f5352p.c(t11));
        }
        return true;
    }

    public void f(T t10, Writer writer) throws IOException {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            i0(t10, writer);
        } else if (this.f5344h) {
            h0(t10, writer);
        } else {
            g0(t10, writer);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c1, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0225, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0226, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.f5337a
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022a
            int r3 = r8.f0(r1)
            int r4 = r8.N(r1)
            long r5 = O(r3)
            int r3 = e0(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0217;
                case 1: goto L_0x020c;
                case 2: goto L_0x0201;
                case 3: goto L_0x01f6;
                case 4: goto L_0x01ef;
                case 5: goto L_0x01e4;
                case 6: goto L_0x01dd;
                case 7: goto L_0x01d2;
                case 8: goto L_0x01c5;
                case 9: goto L_0x01b7;
                case 10: goto L_0x01ab;
                case 11: goto L_0x01a3;
                case 12: goto L_0x019b;
                case 13: goto L_0x0193;
                case 14: goto L_0x0187;
                case 15: goto L_0x017f;
                case 16: goto L_0x0173;
                case 17: goto L_0x0168;
                case 18: goto L_0x015c;
                case 19: goto L_0x015c;
                case 20: goto L_0x015c;
                case 21: goto L_0x015c;
                case 22: goto L_0x015c;
                case 23: goto L_0x015c;
                case 24: goto L_0x015c;
                case 25: goto L_0x015c;
                case 26: goto L_0x015c;
                case 27: goto L_0x015c;
                case 28: goto L_0x015c;
                case 29: goto L_0x015c;
                case 30: goto L_0x015c;
                case 31: goto L_0x015c;
                case 32: goto L_0x015c;
                case 33: goto L_0x015c;
                case 34: goto L_0x015c;
                case 35: goto L_0x015c;
                case 36: goto L_0x015c;
                case 37: goto L_0x015c;
                case 38: goto L_0x015c;
                case 39: goto L_0x015c;
                case 40: goto L_0x015c;
                case 41: goto L_0x015c;
                case 42: goto L_0x015c;
                case 43: goto L_0x015c;
                case 44: goto L_0x015c;
                case 45: goto L_0x015c;
                case 46: goto L_0x015c;
                case 47: goto L_0x015c;
                case 48: goto L_0x015c;
                case 49: goto L_0x015c;
                case 50: goto L_0x0150;
                case 51: goto L_0x013a;
                case 52: goto L_0x0128;
                case 53: goto L_0x0116;
                case 54: goto L_0x0104;
                case 55: goto L_0x00f6;
                case 56: goto L_0x00e4;
                case 57: goto L_0x00d6;
                case 58: goto L_0x00c4;
                case 59: goto L_0x00b0;
                case 60: goto L_0x009e;
                case 61: goto L_0x008c;
                case 62: goto L_0x007e;
                case 63: goto L_0x0070;
                case 64: goto L_0x0062;
                case 65: goto L_0x0050;
                case 66: goto L_0x0042;
                case 67: goto L_0x0030;
                case 68: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0226
        L_0x001e:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.i1.A(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0030:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = T(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0042:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = S(r9, r5)
            goto L_0x0225
        L_0x0050:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = T(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0062:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = S(r9, r5)
            goto L_0x0225
        L_0x0070:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = S(r9, r5)
            goto L_0x0225
        L_0x007e:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = S(r9, r5)
            goto L_0x0225
        L_0x008c:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.i1.A(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x009e:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.i1.A(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00b0:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.i1.A(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00c4:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            boolean r3 = P(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.w.c(r3)
            goto L_0x0225
        L_0x00d6:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = S(r9, r5)
            goto L_0x0225
        L_0x00e4:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = T(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.w.f(r3)
            goto L_0x0225
        L_0x00f6:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = S(r9, r5)
            goto L_0x0225
        L_0x0104:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = T(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0116:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = T(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0128:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            float r3 = R(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x013a:
            boolean r3 = r8.B(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            double r3 = Q(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = androidx.datastore.preferences.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0150:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.i1.A(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x015c:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.i1.A(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0168:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.i1.A(r9, r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
            goto L_0x01c1
        L_0x0173:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.i1.y(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.w.f(r3)
            goto L_0x0225
        L_0x017f:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.i1.x(r9, r5)
            goto L_0x0225
        L_0x0187:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.i1.y(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0193:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.i1.x(r9, r5)
            goto L_0x0225
        L_0x019b:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.i1.x(r9, r5)
            goto L_0x0225
        L_0x01a3:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.i1.x(r9, r5)
            goto L_0x0225
        L_0x01ab:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.i1.A(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01b7:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.i1.A(r9, r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
        L_0x01c1:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0226
        L_0x01c5:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.i1.A(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01d2:
            int r2 = r2 * 53
            boolean r3 = androidx.datastore.preferences.protobuf.i1.p(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.w.c(r3)
            goto L_0x0225
        L_0x01dd:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.i1.x(r9, r5)
            goto L_0x0225
        L_0x01e4:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.i1.y(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.w.f(r3)
            goto L_0x0225
        L_0x01ef:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.i1.x(r9, r5)
            goto L_0x0225
        L_0x01f6:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.i1.y(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.w.f(r3)
            goto L_0x0225
        L_0x0201:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.i1.y(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.w.f(r3)
            goto L_0x0225
        L_0x020c:
            int r2 = r2 * 53
            float r3 = androidx.datastore.preferences.protobuf.i1.w(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x0217:
            int r2 = r2 * 53
            double r3 = androidx.datastore.preferences.protobuf.i1.v(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = androidx.datastore.preferences.protobuf.w.f(r3)
        L_0x0225:
            int r2 = r2 + r3
        L_0x0226:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022a:
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.e1<?, ?> r0 = r8.f5351o
            java.lang.Object r0 = r0.g(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f5342f
            if (r0 == 0) goto L_0x0248
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.o<?> r0 = r8.f5352p
            androidx.datastore.preferences.protobuf.s r9 = r0.c(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x0248:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.hashCode(java.lang.Object):int");
    }

    public T newInstance() {
        return this.f5349m.a(this.f5341e);
    }
}
