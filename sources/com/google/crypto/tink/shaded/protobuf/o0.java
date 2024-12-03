package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.Writer;
import com.google.crypto.tink.shaded.protobuf.e;
import com.google.crypto.tink.shaded.protobuf.f0;
import com.google.crypto.tink.shaded.protobuf.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class o0<T> implements z0<T> {

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f20870r = new int[0];

    /* renamed from: s  reason: collision with root package name */
    private static final Unsafe f20871s = j1.B();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f20872a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f20873b;

    /* renamed from: c  reason: collision with root package name */
    private final int f20874c;

    /* renamed from: d  reason: collision with root package name */
    private final int f20875d;

    /* renamed from: e  reason: collision with root package name */
    private final l0 f20876e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f20877f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f20878g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f20879h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f20880i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f20881j;

    /* renamed from: k  reason: collision with root package name */
    private final int f20882k;

    /* renamed from: l  reason: collision with root package name */
    private final int f20883l;

    /* renamed from: m  reason: collision with root package name */
    private final q0 f20884m;

    /* renamed from: n  reason: collision with root package name */
    private final c0 f20885n;

    /* renamed from: o  reason: collision with root package name */
    private final f1<?, ?> f20886o;

    /* renamed from: p  reason: collision with root package name */
    private final p<?> f20887p;

    /* renamed from: q  reason: collision with root package name */
    private final g0 f20888q;

    private o0(int[] iArr, Object[] objArr, int i10, int i11, l0 l0Var, boolean z10, boolean z11, int[] iArr2, int i12, int i13, q0 q0Var, c0 c0Var, f1<?, ?> f1Var, p<?> pVar, g0 g0Var) {
        boolean z12;
        this.f20872a = iArr;
        this.f20873b = objArr;
        this.f20874c = i10;
        this.f20875d = i11;
        this.f20878g = l0Var instanceof GeneratedMessageLite;
        this.f20879h = z10;
        if (pVar == null || !pVar.e(l0Var)) {
            z12 = false;
        } else {
            z12 = true;
        }
        this.f20877f = z12;
        this.f20880i = z11;
        this.f20881j = iArr2;
        this.f20882k = i12;
        this.f20883l = i13;
        this.f20884m = q0Var;
        this.f20885n = c0Var;
        this.f20886o = f1Var;
        this.f20887p = pVar;
        this.f20876e = l0Var;
        this.f20888q = g0Var;
    }

    private static boolean A(Object obj, int i10, z0 z0Var) {
        return z0Var.c(j1.A(obj, R(i10)));
    }

    private <N> boolean B(Object obj, int i10, int i11) {
        List list = (List) j1.A(obj, R(i10));
        if (list.isEmpty()) {
            return true;
        }
        z0 r10 = r(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (!r10.c(list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    private boolean C(T t10, int i10, int i11) {
        if (this.f20888q.e(j1.A(t10, R(i10))).isEmpty()) {
            return true;
        }
        this.f20888q.b(q(i11));
        throw null;
    }

    private boolean D(T t10, T t11, int i10) {
        long e02 = (long) (e0(i10) & 1048575);
        if (j1.x(t10, e02) == j1.x(t11, e02)) {
            return true;
        }
        return false;
    }

    private boolean E(T t10, int i10, int i11) {
        if (j1.x(t10, (long) (e0(i11) & 1048575)) == i10) {
            return true;
        }
        return false;
    }

    private static boolean F(int i10) {
        return (i10 & 268435456) != 0;
    }

    private static List<?> G(Object obj, long j10) {
        return (List) j1.A(obj, j10);
    }

    private static <T> long H(T t10, long j10) {
        return j1.y(t10, j10);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private <UT, UB, ET extends com.google.crypto.tink.shaded.protobuf.t.b<ET>> void I(com.google.crypto.tink.shaded.protobuf.f1<UT, UB> r17, com.google.crypto.tink.shaded.protobuf.p<ET> r18, T r19, com.google.crypto.tink.shaded.protobuf.y0 r20, com.google.crypto.tink.shaded.protobuf.o r21) throws java.io.IOException {
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
            int r3 = r8.c0(r1)     // Catch:{ all -> 0x0612 }
            if (r3 >= 0) goto L_0x008e
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0033
            int r0 = r8.f20882k
        L_0x001e:
            int r1 = r8.f20883l
            if (r0 >= r1) goto L_0x002d
            int[] r1 = r8.f20881j
            r1 = r1[r0]
            java.lang.Object r13 = r8.m(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x001e
        L_0x002d:
            if (r13 == 0) goto L_0x0032
            r9.o(r10, r13)
        L_0x0032:
            return
        L_0x0033:
            boolean r2 = r8.f20877f     // Catch:{ all -> 0x0612 }
            if (r2 != 0) goto L_0x003b
            r15 = r18
            r3 = r12
            goto L_0x0044
        L_0x003b:
            com.google.crypto.tink.shaded.protobuf.l0 r2 = r8.f20876e     // Catch:{ all -> 0x0612 }
            r15 = r18
            java.lang.Object r1 = r15.b(r11, r2, r1)     // Catch:{ all -> 0x0612 }
            r3 = r1
        L_0x0044:
            if (r3 == 0) goto L_0x005c
            if (r14 != 0) goto L_0x004d
            com.google.crypto.tink.shaded.protobuf.t r1 = r18.d(r19)     // Catch:{ all -> 0x0612 }
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
            int r0 = r8.f20882k
        L_0x0079:
            int r1 = r8.f20883l
            if (r0 >= r1) goto L_0x0088
            int[] r1 = r8.f20881j
            r1 = r1[r0]
            java.lang.Object r13 = r8.m(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x0079
        L_0x0088:
            if (r13 == 0) goto L_0x008d
            r9.o(r10, r13)
        L_0x008d:
            return
        L_0x008e:
            r15 = r18
            int r4 = r8.o0(r3)     // Catch:{ all -> 0x0612 }
            int r2 = n0(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
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
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.z0 r2 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.J(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00b7:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.y()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00cb:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.l()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00df:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.f()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00f3:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.E()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0107:
            int r2 = r20.k()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.x$e r5 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x011e
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x0118
            goto L_0x011e
        L_0x0118:
            java.lang.Object r13 = com.google.crypto.tink.shaded.protobuf.b1.L(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x011e:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x012e:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.h()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0142:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.ByteString r2 = r20.o()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0152:
            boolean r2 = r8.E(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r2 == 0) goto L_0x0174
            long r5 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = com.google.crypto.tink.shaded.protobuf.j1.A(r10, r5)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.z0 r5 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r5 = r0.N(r5, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = com.google.crypto.tink.shaded.protobuf.x.h(r2, r5)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x0186
        L_0x0174:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.z0 r2 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.N(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
        L_0x0186:
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x018b:
            r8.h0(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0193:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            boolean r2 = r20.e()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01a7:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.u()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01bb:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.b()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01cf:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.p()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01e3:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.s()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01f7:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.H()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x020b:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            float r2 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x021f:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            double r6 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Double r2 = java.lang.Double.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.l0(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0233:
            java.lang.Object r4 = r8.q(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r1 = r16
            r2 = r19
            r5 = r21
            r6 = r20
            r1.J(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0244:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.z0 r6 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r1 = r16
            r2 = r19
            r3 = r4
            r5 = r20
            r7 = r21
            r1.f0(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x025a:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.d(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0269:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.r(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0278:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.v(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0287:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.c(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0296:
            com.google.crypto.tink.shaded.protobuf.c0 r2 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r2 = r2.e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.j(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.x$e r3 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r13 = com.google.crypto.tink.shaded.protobuf.b1.A(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02ad:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.t(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02bc:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.m(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02cb:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.x(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02da:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.q(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02e9:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.w(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02f8:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.g(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0307:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.i(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0316:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.C(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0325:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.G(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0334:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.d(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0343:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.r(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0352:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.v(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0361:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.c(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0370:
            com.google.crypto.tink.shaded.protobuf.c0 r2 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r2 = r2.e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.j(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.x$e r3 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r13 = com.google.crypto.tink.shaded.protobuf.b1.A(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0387:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.t(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0396:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.F(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03a5:
            com.google.crypto.tink.shaded.protobuf.z0 r5 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r1 = r16
            r2 = r19
            r3 = r4
            r4 = r20
            r6 = r21
            r1.g0(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03b7:
            r8.i0(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03bc:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.m(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03cb:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.x(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03da:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.q(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03e9:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.w(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03f8:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.g(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0407:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.i(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0416:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.C(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0425:
            com.google.crypto.tink.shaded.protobuf.c0 r1 = r8.f20885n     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.G(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0434:
            boolean r1 = r8.y(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r1 == 0) goto L_0x0457
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.j1.A(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.z0 r2 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.J(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.x.h(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0457:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.z0 r4 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r4 = r0.J(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x046b:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.y()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.N(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x047b:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.l()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.M(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x048b:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.f()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.N(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x049b:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.E()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.M(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04ab:
            int r2 = r20.k()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.x$e r5 = r8.p(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x04c2
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x04bc
            goto L_0x04c2
        L_0x04bc:
            java.lang.Object r13 = com.google.crypto.tink.shaded.protobuf.b1.L(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04c2:
            long r4 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.M(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04ce:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.h()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.M(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04de:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.ByteString r4 = r20.o()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04ee:
            boolean r1 = r8.y(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r1 == 0) goto L_0x0511
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.j1.A(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.z0 r2 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.N(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.x.h(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0511:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.z0 r4 = r8.r(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r4 = r0.N(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.O(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0525:
            r8.h0(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x052d:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            boolean r4 = r20.e()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.E(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x053d:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.u()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.M(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x054d:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.b()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.N(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x055d:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.p()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.M(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x056d:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.s()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.N(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x057d:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.H()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.N(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x058d:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            float r4 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.L(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x059d:
            long r1 = R(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            double r4 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.j1.K(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.k0(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x05ad:
            r13 = r1
        L_0x05ae:
            boolean r1 = r9.m(r13, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.f20882k
        L_0x05b6:
            int r1 = r8.f20883l
            if (r0 >= r1) goto L_0x05c5
            int[] r1 = r8.f20881j
            r1 = r1[r0]
            java.lang.Object r13 = r8.m(r10, r1, r13, r9)
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
            int r0 = r8.f20882k
        L_0x05d9:
            int r1 = r8.f20883l
            if (r0 >= r1) goto L_0x05e8
            int[] r1 = r8.f20881j
            r1 = r1[r0]
            java.lang.Object r13 = r8.m(r10, r1, r13, r9)
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
            int r0 = r8.f20882k
        L_0x05fd:
            int r1 = r8.f20883l
            if (r0 >= r1) goto L_0x060c
            int[] r1 = r8.f20881j
            r1 = r1[r0]
            java.lang.Object r13 = r8.m(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05fd
        L_0x060c:
            if (r13 == 0) goto L_0x0611
            r9.o(r10, r13)
        L_0x0611:
            return
        L_0x0612:
            r0 = move-exception
            int r1 = r8.f20882k
        L_0x0615:
            int r2 = r8.f20883l
            if (r1 >= r2) goto L_0x0624
            int[] r2 = r8.f20881j
            r2 = r2[r1]
            java.lang.Object r13 = r8.m(r10, r2, r13, r9)
            int r1 = r1 + 1
            goto L_0x0615
        L_0x0624:
            if (r13 == 0) goto L_0x0629
            r9.o(r10, r13)
        L_0x0629:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o0.I(com.google.crypto.tink.shaded.protobuf.f1, com.google.crypto.tink.shaded.protobuf.p, java.lang.Object, com.google.crypto.tink.shaded.protobuf.y0, com.google.crypto.tink.shaded.protobuf.o):void");
    }

    private final <K, V> void J(Object obj, int i10, Object obj2, o oVar, y0 y0Var) throws IOException {
        long R = R(o0(i10));
        Object A = j1.A(obj, R);
        if (A == null) {
            A = this.f20888q.d(obj2);
            j1.O(obj, R, A);
        } else if (this.f20888q.h(A)) {
            Object d10 = this.f20888q.d(obj2);
            this.f20888q.a(d10, A);
            j1.O(obj, R, d10);
            A = d10;
        }
        Map<?, ?> c10 = this.f20888q.c(A);
        this.f20888q.b(obj2);
        y0Var.L(c10, (f0.a) null, oVar);
    }

    private void K(T t10, T t11, int i10) {
        long R = R(o0(i10));
        if (y(t11, i10)) {
            Object A = j1.A(t10, R);
            Object A2 = j1.A(t11, R);
            if (A != null && A2 != null) {
                j1.O(t10, R, x.h(A, A2));
                k0(t10, i10);
            } else if (A2 != null) {
                j1.O(t10, R, A2);
                k0(t10, i10);
            }
        }
    }

    private void L(T t10, T t11, int i10) {
        int o02 = o0(i10);
        int Q = Q(i10);
        long R = R(o02);
        if (E(t11, Q, i10)) {
            Object A = j1.A(t10, R);
            Object A2 = j1.A(t11, R);
            if (A != null && A2 != null) {
                j1.O(t10, R, x.h(A, A2));
                l0(t10, Q, i10);
            } else if (A2 != null) {
                j1.O(t10, R, A2);
                l0(t10, Q, i10);
            }
        }
    }

    private void M(T t10, T t11, int i10) {
        int o02 = o0(i10);
        long R = R(o02);
        int Q = Q(i10);
        switch (n0(o02)) {
            case 0:
                if (y(t11, i10)) {
                    j1.K(t10, R, j1.v(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 1:
                if (y(t11, i10)) {
                    j1.L(t10, R, j1.w(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 2:
                if (y(t11, i10)) {
                    j1.N(t10, R, j1.y(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 3:
                if (y(t11, i10)) {
                    j1.N(t10, R, j1.y(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 4:
                if (y(t11, i10)) {
                    j1.M(t10, R, j1.x(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 5:
                if (y(t11, i10)) {
                    j1.N(t10, R, j1.y(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 6:
                if (y(t11, i10)) {
                    j1.M(t10, R, j1.x(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 7:
                if (y(t11, i10)) {
                    j1.E(t10, R, j1.p(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 8:
                if (y(t11, i10)) {
                    j1.O(t10, R, j1.A(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 9:
                K(t10, t11, i10);
                return;
            case 10:
                if (y(t11, i10)) {
                    j1.O(t10, R, j1.A(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 11:
                if (y(t11, i10)) {
                    j1.M(t10, R, j1.x(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 12:
                if (y(t11, i10)) {
                    j1.M(t10, R, j1.x(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 13:
                if (y(t11, i10)) {
                    j1.M(t10, R, j1.x(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 14:
                if (y(t11, i10)) {
                    j1.N(t10, R, j1.y(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 15:
                if (y(t11, i10)) {
                    j1.M(t10, R, j1.x(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 16:
                if (y(t11, i10)) {
                    j1.N(t10, R, j1.y(t11, R));
                    k0(t10, i10);
                    return;
                }
                return;
            case 17:
                K(t10, t11, i10);
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
                this.f20885n.d(t10, t11, R);
                return;
            case 50:
                b1.F(this.f20888q, t10, t11, R);
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
                if (E(t11, Q, i10)) {
                    j1.O(t10, R, j1.A(t11, R));
                    l0(t10, Q, i10);
                    return;
                }
                return;
            case 60:
                L(t10, t11, i10);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (E(t11, Q, i10)) {
                    j1.O(t10, R, j1.A(t11, R));
                    l0(t10, Q, i10);
                    return;
                }
                return;
            case 68:
                L(t10, t11, i10);
                return;
            default:
                return;
        }
    }

    static <T> o0<T> N(Class<T> cls, j0 j0Var, q0 q0Var, c0 c0Var, f1<?, ?> f1Var, p<?> pVar, g0 g0Var) {
        if (j0Var instanceof x0) {
            return P((x0) j0Var, q0Var, c0Var, f1Var, pVar, g0Var);
        }
        return O((d1) j0Var, q0Var, c0Var, f1Var, pVar, g0Var);
    }

    static <T> o0<T> O(d1 d1Var, q0 q0Var, c0 c0Var, f1<?, ?> f1Var, p<?> pVar, g0 g0Var) {
        boolean z10;
        if (d1Var.c() == ProtoSyntax.PROTO3) {
            z10 = true;
        } else {
            z10 = false;
        }
        s[] e10 = d1Var.e();
        if (e10.length == 0) {
            int length = e10.length;
            int[] iArr = new int[(length * 3)];
            Object[] objArr = new Object[(length * 2)];
            if (e10.length <= 0) {
                int[] d10 = d1Var.d();
                if (d10 == null) {
                    d10 = f20870r;
                }
                if (e10.length <= 0) {
                    int[] iArr2 = f20870r;
                    int[] iArr3 = f20870r;
                    int[] iArr4 = new int[(d10.length + iArr2.length + iArr3.length)];
                    System.arraycopy(d10, 0, iArr4, 0, d10.length);
                    System.arraycopy(iArr2, 0, iArr4, d10.length, iArr2.length);
                    System.arraycopy(iArr3, 0, iArr4, d10.length + iArr2.length, iArr3.length);
                    return new o0(iArr, objArr, 0, 0, d1Var.b(), z10, true, iArr4, d10.length, d10.length + iArr2.length, q0Var, c0Var, f1Var, pVar, g0Var);
                }
                s sVar = e10[0];
                throw null;
            }
            s sVar2 = e10[0];
            throw null;
        }
        s sVar3 = e10[0];
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0391  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.crypto.tink.shaded.protobuf.o0<T> P(com.google.crypto.tink.shaded.protobuf.x0 r36, com.google.crypto.tink.shaded.protobuf.q0 r37, com.google.crypto.tink.shaded.protobuf.c0 r38, com.google.crypto.tink.shaded.protobuf.f1<?, ?> r39, com.google.crypto.tink.shaded.protobuf.p<?> r40, com.google.crypto.tink.shaded.protobuf.g0 r41) {
        /*
            com.google.crypto.tink.shaded.protobuf.ProtoSyntax r0 = r36.c()
            com.google.crypto.tink.shaded.protobuf.ProtoSyntax r1 = com.google.crypto.tink.shaded.protobuf.ProtoSyntax.PROTO3
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
            int[] r8 = f20870r
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
            sun.misc.Unsafe r5 = f20871s
            java.lang.Object[] r18 = r36.d()
            com.google.crypto.tink.shaded.protobuf.l0 r19 = r36.b()
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
            java.lang.reflect.Field r9 = j0(r3, r9)
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
            java.lang.reflect.Field r7 = j0(r3, r7)
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
            java.lang.reflect.Field r7 = j0(r3, r7)
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
            java.lang.reflect.Field r10 = j0(r3, r10)
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
            com.google.crypto.tink.shaded.protobuf.o0 r0 = new com.google.crypto.tink.shaded.protobuf.o0
            com.google.crypto.tink.shaded.protobuf.l0 r9 = r36.b()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o0.P(com.google.crypto.tink.shaded.protobuf.x0, com.google.crypto.tink.shaded.protobuf.q0, com.google.crypto.tink.shaded.protobuf.c0, com.google.crypto.tink.shaded.protobuf.f1, com.google.crypto.tink.shaded.protobuf.p, com.google.crypto.tink.shaded.protobuf.g0):com.google.crypto.tink.shaded.protobuf.o0");
    }

    private int Q(int i10) {
        return this.f20872a[i10];
    }

    private static long R(int i10) {
        return (long) (i10 & 1048575);
    }

    private static <T> boolean S(T t10, long j10) {
        return ((Boolean) j1.A(t10, j10)).booleanValue();
    }

    private static <T> double T(T t10, long j10) {
        return ((Double) j1.A(t10, j10)).doubleValue();
    }

    private static <T> float U(T t10, long j10) {
        return ((Float) j1.A(t10, j10)).floatValue();
    }

    private static <T> int V(T t10, long j10) {
        return ((Integer) j1.A(t10, j10)).intValue();
    }

    private static <T> long W(T t10, long j10) {
        return ((Long) j1.A(t10, j10)).longValue();
    }

    private <K, V> int X(T t10, byte[] bArr, int i10, int i11, int i12, long j10, e.b bVar) throws IOException {
        T t11 = t10;
        long j11 = j10;
        Unsafe unsafe = f20871s;
        int i13 = i12;
        Object q10 = q(i12);
        Object object = unsafe.getObject(t10, j11);
        if (this.f20888q.h(object)) {
            Object d10 = this.f20888q.d(q10);
            this.f20888q.a(d10, object);
            unsafe.putObject(t10, j11, d10);
            object = d10;
        }
        this.f20888q.b(q10);
        return j(bArr, i10, i11, (f0.a) null, this.f20888q.c(object), bVar);
    }

    private int Y(T t10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, e.b bVar) throws IOException {
        T t11 = t10;
        byte[] bArr2 = bArr;
        int i18 = i10;
        int i19 = i12;
        int i20 = i13;
        int i21 = i14;
        long j11 = j10;
        int i22 = i17;
        e.b bVar2 = bVar;
        Unsafe unsafe = f20871s;
        long j12 = (long) (this.f20872a[i22 + 2] & 1048575);
        switch (i16) {
            case 51:
                if (i21 == 1) {
                    unsafe.putObject(t11, j11, Double.valueOf(e.d(bArr, i10)));
                    int i23 = i18 + 8;
                    unsafe.putInt(t11, j12, i20);
                    return i23;
                }
                break;
            case 52:
                if (i21 == 5) {
                    unsafe.putObject(t11, j11, Float.valueOf(e.l(bArr, i10)));
                    int i24 = i18 + 4;
                    unsafe.putInt(t11, j12, i20);
                    return i24;
                }
                break;
            case 53:
            case 54:
                if (i21 == 0) {
                    int L = e.L(bArr2, i18, bVar2);
                    unsafe.putObject(t11, j11, Long.valueOf(bVar2.f20784b));
                    unsafe.putInt(t11, j12, i20);
                    return L;
                }
                break;
            case 55:
            case 62:
                if (i21 == 0) {
                    int I = e.I(bArr2, i18, bVar2);
                    unsafe.putObject(t11, j11, Integer.valueOf(bVar2.f20783a));
                    unsafe.putInt(t11, j12, i20);
                    return I;
                }
                break;
            case 56:
            case 65:
                if (i21 == 1) {
                    unsafe.putObject(t11, j11, Long.valueOf(e.j(bArr, i10)));
                    int i25 = i18 + 8;
                    unsafe.putInt(t11, j12, i20);
                    return i25;
                }
                break;
            case 57:
            case 64:
                if (i21 == 5) {
                    unsafe.putObject(t11, j11, Integer.valueOf(e.h(bArr, i10)));
                    int i26 = i18 + 4;
                    unsafe.putInt(t11, j12, i20);
                    return i26;
                }
                break;
            case 58:
                if (i21 == 0) {
                    int L2 = e.L(bArr2, i18, bVar2);
                    unsafe.putObject(t11, j11, Boolean.valueOf(bVar2.f20784b != 0));
                    unsafe.putInt(t11, j12, i20);
                    return L2;
                }
                break;
            case 59:
                if (i21 == 2) {
                    int I2 = e.I(bArr2, i18, bVar2);
                    int i27 = bVar2.f20783a;
                    if (i27 == 0) {
                        unsafe.putObject(t11, j11, "");
                    } else if ((i15 & 536870912) == 0 || Utf8.n(bArr2, I2, I2 + i27)) {
                        unsafe.putObject(t11, j11, new String(bArr2, I2, i27, x.f20917a));
                        I2 += i27;
                    } else {
                        throw InvalidProtocolBufferException.c();
                    }
                    unsafe.putInt(t11, j12, i20);
                    return I2;
                }
                break;
            case 60:
                if (i21 == 2) {
                    int p10 = e.p(r(i22), bArr2, i18, i11, bVar2);
                    Object object = unsafe.getInt(t11, j12) == i20 ? unsafe.getObject(t11, j11) : null;
                    if (object == null) {
                        unsafe.putObject(t11, j11, bVar2.f20785c);
                    } else {
                        unsafe.putObject(t11, j11, x.h(object, bVar2.f20785c));
                    }
                    unsafe.putInt(t11, j12, i20);
                    return p10;
                }
                break;
            case 61:
                if (i21 == 2) {
                    int b10 = e.b(bArr2, i18, bVar2);
                    unsafe.putObject(t11, j11, bVar2.f20785c);
                    unsafe.putInt(t11, j12, i20);
                    return b10;
                }
                break;
            case 63:
                if (i21 == 0) {
                    int I3 = e.I(bArr2, i18, bVar2);
                    int i28 = bVar2.f20783a;
                    x.e p11 = p(i22);
                    if (p11 == null || p11.isInRange(i28)) {
                        unsafe.putObject(t11, j11, Integer.valueOf(i28));
                        unsafe.putInt(t11, j12, i20);
                    } else {
                        s(t10).n(i19, Long.valueOf((long) i28));
                    }
                    return I3;
                }
                break;
            case 66:
                if (i21 == 0) {
                    int I4 = e.I(bArr2, i18, bVar2);
                    unsafe.putObject(t11, j11, Integer.valueOf(i.b(bVar2.f20783a)));
                    unsafe.putInt(t11, j12, i20);
                    return I4;
                }
                break;
            case 67:
                if (i21 == 0) {
                    int L3 = e.L(bArr2, i18, bVar2);
                    unsafe.putObject(t11, j11, Long.valueOf(i.c(bVar2.f20784b)));
                    unsafe.putInt(t11, j12, i20);
                    return L3;
                }
                break;
            case 68:
                if (i21 == 3) {
                    int n10 = e.n(r(i22), bArr, i10, i11, (i19 & -8) | 4, bVar);
                    Object object2 = unsafe.getInt(t11, j12) == i20 ? unsafe.getObject(t11, j11) : null;
                    if (object2 == null) {
                        unsafe.putObject(t11, j11, bVar2.f20785c);
                    } else {
                        unsafe.putObject(t11, j11, x.h(object2, bVar2.f20785c));
                    }
                    unsafe.putInt(t11, j12, i20);
                    return n10;
                }
                break;
        }
        return i18;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0107, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0139, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0155, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0157, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015c, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01de, code lost:
        if (r0 != r15) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x020c, code lost:
        if (r0 != r15) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x022b, code lost:
        if (r0 != r15) goto L_0x023f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a0(T r28, byte[] r29, int r30, int r31, com.google.crypto.tink.shaded.protobuf.e.b r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            sun.misc.Unsafe r9 = f20871s
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = r10
            r2 = r16
        L_0x0014:
            if (r0 >= r13) goto L_0x0253
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0026
            int r0 = com.google.crypto.tink.shaded.protobuf.e.H(r0, r12, r3, r11)
            int r3 = r11.f20783a
            r8 = r0
            r17 = r3
            goto L_0x0029
        L_0x0026:
            r17 = r0
            r8 = r3
        L_0x0029:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x0036
            int r2 = r2 / 3
            int r0 = r15.d0(r7, r2)
            goto L_0x003a
        L_0x0036:
            int r0 = r15.c0(r7)
        L_0x003a:
            r4 = r0
            if (r4 != r10) goto L_0x0048
            r24 = r7
            r2 = r8
            r18 = r9
            r26 = r10
            r19 = r16
            goto L_0x022f
        L_0x0048:
            int[] r0 = r15.f20872a
            int r1 = r4 + 1
            r5 = r0[r1]
            int r3 = n0(r5)
            long r1 = R(r5)
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x0164
            r0 = 1
            switch(r3) {
                case 0: goto L_0x014a;
                case 1: goto L_0x013b;
                case 2: goto L_0x0129;
                case 3: goto L_0x0129;
                case 4: goto L_0x011b;
                case 5: goto L_0x010b;
                case 6: goto L_0x00fa;
                case 7: goto L_0x00e3;
                case 8: goto L_0x00cc;
                case 9: goto L_0x00ab;
                case 10: goto L_0x009e;
                case 11: goto L_0x011b;
                case 12: goto L_0x008f;
                case 13: goto L_0x00fa;
                case 14: goto L_0x010b;
                case 15: goto L_0x007c;
                case 16: goto L_0x0061;
                default: goto L_0x005f;
            }
        L_0x005f:
            goto L_0x01a0
        L_0x0061:
            if (r6 != 0) goto L_0x01a0
            int r6 = com.google.crypto.tink.shaded.protobuf.e.L(r12, r8, r11)
            r19 = r1
            long r0 = r11.f20784b
            long r21 = com.google.crypto.tink.shaded.protobuf.i.c(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x0139
        L_0x007c:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015c
            int r0 = com.google.crypto.tink.shaded.protobuf.e.I(r12, r8, r11)
            int r1 = r11.f20783a
            int r1 = com.google.crypto.tink.shaded.protobuf.i.b(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x0157
        L_0x008f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015c
            int r0 = com.google.crypto.tink.shaded.protobuf.e.I(r12, r8, r11)
            int r1 = r11.f20783a
            r9.putInt(r14, r2, r1)
            goto L_0x0157
        L_0x009e:
            r2 = r1
            if (r6 != r10) goto L_0x01a0
            int r0 = com.google.crypto.tink.shaded.protobuf.e.b(r12, r8, r11)
            java.lang.Object r1 = r11.f20785c
            r9.putObject(r14, r2, r1)
            goto L_0x0107
        L_0x00ab:
            r2 = r1
            if (r6 != r10) goto L_0x01a0
            com.google.crypto.tink.shaded.protobuf.z0 r0 = r15.r(r4)
            int r0 = com.google.crypto.tink.shaded.protobuf.e.p(r0, r12, r8, r13, r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c2
            java.lang.Object r1 = r11.f20785c
            r9.putObject(r14, r2, r1)
            goto L_0x0107
        L_0x00c2:
            java.lang.Object r5 = r11.f20785c
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.x.h(r1, r5)
            r9.putObject(r14, r2, r1)
            goto L_0x0107
        L_0x00cc:
            r2 = r1
            if (r6 != r10) goto L_0x01a0
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00d9
            int r0 = com.google.crypto.tink.shaded.protobuf.e.C(r12, r8, r11)
            goto L_0x00dd
        L_0x00d9:
            int r0 = com.google.crypto.tink.shaded.protobuf.e.F(r12, r8, r11)
        L_0x00dd:
            java.lang.Object r1 = r11.f20785c
            r9.putObject(r14, r2, r1)
            goto L_0x0107
        L_0x00e3:
            r2 = r1
            if (r6 != 0) goto L_0x01a0
            int r1 = com.google.crypto.tink.shaded.protobuf.e.L(r12, r8, r11)
            long r5 = r11.f20784b
            r19 = 0
            int r5 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r5 == 0) goto L_0x00f3
            goto L_0x00f5
        L_0x00f3:
            r0 = r16
        L_0x00f5:
            com.google.crypto.tink.shaded.protobuf.j1.E(r14, r2, r0)
            r0 = r1
            goto L_0x0107
        L_0x00fa:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a0
            int r0 = com.google.crypto.tink.shaded.protobuf.e.h(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x0107:
            r2 = r4
            r1 = r7
            goto L_0x0159
        L_0x010b:
            r2 = r1
            if (r6 != r0) goto L_0x01a0
            long r5 = com.google.crypto.tink.shaded.protobuf.e.j(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x0155
        L_0x011b:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015c
            int r0 = com.google.crypto.tink.shaded.protobuf.e.I(r12, r8, r11)
            int r1 = r11.f20783a
            r9.putInt(r14, r2, r1)
            goto L_0x0157
        L_0x0129:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015c
            int r6 = com.google.crypto.tink.shaded.protobuf.e.L(r12, r8, r11)
            long r4 = r11.f20784b
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
        L_0x0139:
            r0 = r6
            goto L_0x0157
        L_0x013b:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x015c
            float r0 = com.google.crypto.tink.shaded.protobuf.e.l(r12, r8)
            com.google.crypto.tink.shaded.protobuf.j1.L(r14, r2, r0)
            int r0 = r8 + 4
            goto L_0x0157
        L_0x014a:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x015c
            double r0 = com.google.crypto.tink.shaded.protobuf.e.d(r12, r8)
            com.google.crypto.tink.shaded.protobuf.j1.K(r14, r2, r0)
        L_0x0155:
            int r0 = r8 + 8
        L_0x0157:
            r1 = r7
            r2 = r10
        L_0x0159:
            r10 = -1
            goto L_0x0014
        L_0x015c:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x01a7
        L_0x0164:
            r0 = 27
            if (r3 != r0) goto L_0x01ab
            if (r6 != r10) goto L_0x01a0
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.crypto.tink.shaded.protobuf.x$i r0 = (com.google.crypto.tink.shaded.protobuf.x.i) r0
            boolean r3 = r0.h()
            if (r3 != 0) goto L_0x0188
            int r3 = r0.size()
            if (r3 != 0) goto L_0x017f
            r3 = 10
            goto L_0x0181
        L_0x017f:
            int r3 = r3 * 2
        L_0x0181:
            com.google.crypto.tink.shaded.protobuf.x$i r0 = r0.a(r3)
            r9.putObject(r14, r1, r0)
        L_0x0188:
            r5 = r0
            com.google.crypto.tink.shaded.protobuf.z0 r0 = r15.r(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.crypto.tink.shaded.protobuf.e.q(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x0159
        L_0x01a0:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x01a7:
            r26 = -1
            goto L_0x020f
        L_0x01ab:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01e2
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.b0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x022e
        L_0x01e0:
            goto L_0x023f
        L_0x01e2:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x0211
            r7 = r30
            if (r7 != r10) goto L_0x020f
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.X(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x022e
            goto L_0x01e0
        L_0x020f:
            r2 = r15
            goto L_0x022f
        L_0x0211:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.Y(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x022e
            goto L_0x01e0
        L_0x022e:
            r2 = r0
        L_0x022f:
            com.google.crypto.tink.shaded.protobuf.g1 r4 = s(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.crypto.tink.shaded.protobuf.e.G(r0, r1, r2, r3, r4, r5)
        L_0x023f:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            r10 = r26
            goto L_0x0014
        L_0x0253:
            r1 = r13
            if (r0 != r1) goto L_0x0257
            return r0
        L_0x0257:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r0 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.g()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o0.a0(java.lang.Object, byte[], int, int, com.google.crypto.tink.shaded.protobuf.e$b):int");
    }

    private int b0(T t10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, long j10, int i16, long j11, e.b bVar) throws IOException {
        int i17;
        T t11 = t10;
        byte[] bArr2 = bArr;
        int i18 = i10;
        int i19 = i14;
        int i20 = i15;
        long j12 = j11;
        e.b bVar2 = bVar;
        Unsafe unsafe = f20871s;
        x.i iVar = (x.i) unsafe.getObject(t10, j12);
        if (!iVar.h()) {
            int size = iVar.size();
            iVar = iVar.a(size == 0 ? 10 : size * 2);
            unsafe.putObject(t10, j12, iVar);
        }
        switch (i16) {
            case 18:
            case 35:
                if (i19 == 2) {
                    return e.s(bArr, i18, iVar, bVar2);
                }
                if (i19 == 1) {
                    return e.e(i12, bArr, i10, i11, iVar, bVar);
                }
                break;
            case 19:
            case 36:
                if (i19 == 2) {
                    return e.v(bArr, i18, iVar, bVar2);
                }
                if (i19 == 5) {
                    return e.m(i12, bArr, i10, i11, iVar, bVar);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i19 == 2) {
                    return e.z(bArr, i18, iVar, bVar2);
                }
                if (i19 == 0) {
                    return e.M(i12, bArr, i10, i11, iVar, bVar);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i19 == 2) {
                    return e.y(bArr, i18, iVar, bVar2);
                }
                if (i19 == 0) {
                    return e.J(i12, bArr, i10, i11, iVar, bVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i19 == 2) {
                    return e.u(bArr, i18, iVar, bVar2);
                }
                if (i19 == 1) {
                    return e.k(i12, bArr, i10, i11, iVar, bVar);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i19 == 2) {
                    return e.t(bArr, i18, iVar, bVar2);
                }
                if (i19 == 5) {
                    return e.i(i12, bArr, i10, i11, iVar, bVar);
                }
                break;
            case 25:
            case 42:
                if (i19 == 2) {
                    return e.r(bArr, i18, iVar, bVar2);
                }
                if (i19 == 0) {
                    return e.a(i12, bArr, i10, i11, iVar, bVar);
                }
                break;
            case 26:
                if (i19 == 2) {
                    if ((j10 & 536870912) == 0) {
                        return e.D(i12, bArr, i10, i11, iVar, bVar);
                    }
                    return e.E(i12, bArr, i10, i11, iVar, bVar);
                }
                break;
            case 27:
                if (i19 == 2) {
                    return e.q(r(i20), i12, bArr, i10, i11, iVar, bVar);
                }
                break;
            case 28:
                if (i19 == 2) {
                    return e.c(i12, bArr, i10, i11, iVar, bVar);
                }
                break;
            case 30:
            case 44:
                if (i19 == 2) {
                    i17 = e.y(bArr, i18, iVar, bVar2);
                } else if (i19 == 0) {
                    i17 = e.J(i12, bArr, i10, i11, iVar, bVar);
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t11;
                g1 g1Var = generatedMessageLite.unknownFields;
                if (g1Var == g1.e()) {
                    g1Var = null;
                }
                g1 g1Var2 = (g1) b1.A(i13, iVar, p(i20), g1Var, this.f20886o);
                if (g1Var2 != null) {
                    generatedMessageLite.unknownFields = g1Var2;
                }
                return i17;
            case 33:
            case 47:
                if (i19 == 2) {
                    return e.w(bArr, i18, iVar, bVar2);
                }
                if (i19 == 0) {
                    return e.A(i12, bArr, i10, i11, iVar, bVar);
                }
                break;
            case 34:
            case 48:
                if (i19 == 2) {
                    return e.x(bArr, i18, iVar, bVar2);
                }
                if (i19 == 0) {
                    return e.B(i12, bArr, i10, i11, iVar, bVar);
                }
                break;
            case 49:
                if (i19 == 3) {
                    return e.o(r(i20), i12, bArr, i10, i11, iVar, bVar);
                }
                break;
        }
        return i18;
    }

    private int c0(int i10) {
        if (i10 < this.f20874c || i10 > this.f20875d) {
            return -1;
        }
        return m0(i10, 0);
    }

    private int d0(int i10, int i11) {
        if (i10 < this.f20874c || i10 > this.f20875d) {
            return -1;
        }
        return m0(i10, i11);
    }

    private int e0(int i10) {
        return this.f20872a[i10 + 2];
    }

    private <E> void f0(Object obj, long j10, y0 y0Var, z0<E> z0Var, o oVar) throws IOException {
        y0Var.P(this.f20885n.e(obj, j10), z0Var, oVar);
    }

    private <E> void g0(Object obj, int i10, y0 y0Var, z0<E> z0Var, o oVar) throws IOException {
        y0Var.M(this.f20885n.e(obj, R(i10)), z0Var, oVar);
    }

    private boolean h(T t10, T t11, int i10) {
        return y(t10, i10) == y(t11, i10);
    }

    private void h0(Object obj, int i10, y0 y0Var) throws IOException {
        if (x(i10)) {
            j1.O(obj, R(i10), y0Var.I());
        } else if (this.f20878g) {
            j1.O(obj, R(i10), y0Var.z());
        } else {
            j1.O(obj, R(i10), y0Var.o());
        }
    }

    private static <T> boolean i(T t10, long j10) {
        return j1.p(t10, j10);
    }

    private void i0(Object obj, int i10, y0 y0Var) throws IOException {
        if (x(i10)) {
            y0Var.n(this.f20885n.e(obj, R(i10)));
        } else {
            y0Var.B(this.f20885n.e(obj, R(i10)));
        }
    }

    private <K, V> int j(byte[] bArr, int i10, int i11, f0.a<K, V> aVar, Map<K, V> map, e.b bVar) throws IOException {
        int I = e.I(bArr, i10, bVar);
        int i12 = bVar.f20783a;
        if (i12 < 0 || i12 > i11 - I) {
            throw InvalidProtocolBufferException.j();
        }
        throw null;
    }

    private static Field j0(Class<?> cls, String str) {
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

    private static <T> double k(T t10, long j10) {
        return j1.v(t10, j10);
    }

    private void k0(T t10, int i10) {
        if (!this.f20879h) {
            int e02 = e0(i10);
            long j10 = (long) (e02 & 1048575);
            j1.M(t10, j10, j1.x(t10, j10) | (1 << (e02 >>> 20)));
        }
    }

    private boolean l(T t10, T t11, int i10) {
        int o02 = o0(i10);
        long R = R(o02);
        switch (n0(o02)) {
            case 0:
                if (!h(t10, t11, i10) || Double.doubleToLongBits(j1.v(t10, R)) != Double.doubleToLongBits(j1.v(t11, R))) {
                    return false;
                }
                return true;
            case 1:
                if (!h(t10, t11, i10) || Float.floatToIntBits(j1.w(t10, R)) != Float.floatToIntBits(j1.w(t11, R))) {
                    return false;
                }
                return true;
            case 2:
                if (!h(t10, t11, i10) || j1.y(t10, R) != j1.y(t11, R)) {
                    return false;
                }
                return true;
            case 3:
                if (!h(t10, t11, i10) || j1.y(t10, R) != j1.y(t11, R)) {
                    return false;
                }
                return true;
            case 4:
                if (!h(t10, t11, i10) || j1.x(t10, R) != j1.x(t11, R)) {
                    return false;
                }
                return true;
            case 5:
                if (!h(t10, t11, i10) || j1.y(t10, R) != j1.y(t11, R)) {
                    return false;
                }
                return true;
            case 6:
                if (!h(t10, t11, i10) || j1.x(t10, R) != j1.x(t11, R)) {
                    return false;
                }
                return true;
            case 7:
                if (!h(t10, t11, i10) || j1.p(t10, R) != j1.p(t11, R)) {
                    return false;
                }
                return true;
            case 8:
                if (!h(t10, t11, i10) || !b1.K(j1.A(t10, R), j1.A(t11, R))) {
                    return false;
                }
                return true;
            case 9:
                if (!h(t10, t11, i10) || !b1.K(j1.A(t10, R), j1.A(t11, R))) {
                    return false;
                }
                return true;
            case 10:
                if (!h(t10, t11, i10) || !b1.K(j1.A(t10, R), j1.A(t11, R))) {
                    return false;
                }
                return true;
            case 11:
                if (!h(t10, t11, i10) || j1.x(t10, R) != j1.x(t11, R)) {
                    return false;
                }
                return true;
            case 12:
                if (!h(t10, t11, i10) || j1.x(t10, R) != j1.x(t11, R)) {
                    return false;
                }
                return true;
            case 13:
                if (!h(t10, t11, i10) || j1.x(t10, R) != j1.x(t11, R)) {
                    return false;
                }
                return true;
            case 14:
                if (!h(t10, t11, i10) || j1.y(t10, R) != j1.y(t11, R)) {
                    return false;
                }
                return true;
            case 15:
                if (!h(t10, t11, i10) || j1.x(t10, R) != j1.x(t11, R)) {
                    return false;
                }
                return true;
            case 16:
                if (!h(t10, t11, i10) || j1.y(t10, R) != j1.y(t11, R)) {
                    return false;
                }
                return true;
            case 17:
                if (!h(t10, t11, i10) || !b1.K(j1.A(t10, R), j1.A(t11, R))) {
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
                return b1.K(j1.A(t10, R), j1.A(t11, R));
            case 50:
                return b1.K(j1.A(t10, R), j1.A(t11, R));
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
                if (!D(t10, t11, i10) || !b1.K(j1.A(t10, R), j1.A(t11, R))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    private void l0(T t10, int i10, int i11) {
        j1.M(t10, (long) (e0(i11) & 1048575), i10);
    }

    private final <UT, UB> UB m(Object obj, int i10, UB ub2, f1<UT, UB> f1Var) {
        x.e p10;
        int Q = Q(i10);
        Object A = j1.A(obj, R(o0(i10)));
        if (A == null || (p10 = p(i10)) == null) {
            return ub2;
        }
        return n(i10, Q, this.f20888q.c(A), p10, ub2, f1Var);
    }

    private int m0(int i10, int i11) {
        int length = (this.f20872a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int Q = Q(i13);
            if (i10 == Q) {
                return i13;
            }
            if (i10 < Q) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    private final <K, V, UT, UB> UB n(int i10, int i11, Map<K, V> map, x.e eVar, UB ub2, f1<UT, UB> f1Var) {
        this.f20888q.b(q(i10));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!eVar.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = f1Var.n();
                }
                ByteString.g r10 = ByteString.r(f0.b((f0.a) null, next.getKey(), next.getValue()));
                try {
                    f0.d(r10.b(), (f0.a) null, next.getKey(), next.getValue());
                    f1Var.d(ub2, i11, r10.a());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub2;
    }

    private static int n0(int i10) {
        return (i10 & 267386880) >>> 20;
    }

    private static <T> float o(T t10, long j10) {
        return j1.w(t10, j10);
    }

    private int o0(int i10) {
        return this.f20872a[i10 + 1];
    }

    private x.e p(int i10) {
        return (x.e) this.f20873b[((i10 / 3) * 2) + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void p0(T r18, com.google.crypto.tink.shaded.protobuf.Writer r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.f20877f
            if (r3 == 0) goto L_0x0021
            com.google.crypto.tink.shaded.protobuf.p<?> r3 = r0.f20887p
            com.google.crypto.tink.shaded.protobuf.t r3 = r3.c(r1)
            boolean r5 = r3.m()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.r()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            r6 = -1
            int[] r7 = r0.f20872a
            int r7 = r7.length
            sun.misc.Unsafe r8 = f20871s
            r10 = 0
            r11 = 0
        L_0x002b:
            if (r10 >= r7) goto L_0x049a
            int r12 = r0.o0(r10)
            int r13 = r0.Q(r10)
            int r14 = n0(r12)
            boolean r15 = r0.f20879h
            if (r15 != 0) goto L_0x005e
            r15 = 17
            if (r14 > r15) goto L_0x005e
            int[] r15 = r0.f20872a
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
            com.google.crypto.tink.shaded.protobuf.p<?> r9 = r0.f20887p
            int r9 = r9.a(r5)
            if (r9 > r13) goto L_0x0081
            com.google.crypto.tink.shaded.protobuf.p<?> r9 = r0.f20887p
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
            long r5 = R(r12)
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
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r8.getObject(r1, r5)
            com.google.crypto.tink.shaded.protobuf.z0 r5 = r0.r(r10)
            r2.K(r13, r4, r5)
            goto L_0x008a
        L_0x009f:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = W(r1, r5)
            r2.m(r13, r4)
            goto L_0x008a
        L_0x00ad:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = V(r1, r5)
            r2.H(r13, r4)
            goto L_0x008a
        L_0x00bb:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = W(r1, r5)
            r2.i(r13, r4)
            goto L_0x008a
        L_0x00c9:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = V(r1, r5)
            r2.w(r13, r4)
            goto L_0x008a
        L_0x00d7:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = V(r1, r5)
            r2.E(r13, r4)
            goto L_0x008a
        L_0x00e5:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = V(r1, r5)
            r2.o(r13, r4)
            goto L_0x008a
        L_0x00f3:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r8.getObject(r1, r5)
            com.google.crypto.tink.shaded.protobuf.ByteString r4 = (com.google.crypto.tink.shaded.protobuf.ByteString) r4
            r2.M(r13, r4)
            goto L_0x008a
        L_0x0103:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r8.getObject(r1, r5)
            com.google.crypto.tink.shaded.protobuf.z0 r5 = r0.r(r10)
            r2.N(r13, r4, r5)
            goto L_0x008a
        L_0x0116:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r8.getObject(r1, r5)
            r0.t0(r13, r4, r2)
            goto L_0x008a
        L_0x0125:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            boolean r4 = S(r1, r5)
            r2.v(r13, r4)
            goto L_0x008a
        L_0x0134:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = V(r1, r5)
            r2.c(r13, r4)
            goto L_0x008a
        L_0x0143:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = W(r1, r5)
            r2.s(r13, r4)
            goto L_0x008a
        L_0x0152:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = V(r1, r5)
            r2.h(r13, r4)
            goto L_0x008a
        L_0x0161:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = W(r1, r5)
            r2.f(r13, r4)
            goto L_0x008a
        L_0x0170:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = W(r1, r5)
            r2.u(r13, r4)
            goto L_0x008a
        L_0x017f:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            float r4 = U(r1, r5)
            r2.B(r13, r4)
            goto L_0x008a
        L_0x018e:
            boolean r4 = r0.E(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            double r4 = T(r1, r5)
            r2.p(r13, r4)
            goto L_0x008a
        L_0x019d:
            java.lang.Object r4 = r8.getObject(r1, r5)
            r0.s0(r2, r13, r4, r10)
            goto L_0x008a
        L_0x01a6:
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.z0 r6 = r0.r(r10)
            com.google.crypto.tink.shaded.protobuf.b1.U(r4, r5, r2, r6)
            goto L_0x008a
        L_0x01b9:
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 1
            com.google.crypto.tink.shaded.protobuf.b1.b0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01c9:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.a0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01d9:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.Z(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01e9:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.Y(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01f9:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.Q(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0209:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.d0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0219:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.N(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0229:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.R(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0239:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.S(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0249:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.V(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0259:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.e0(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0269:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.W(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0279:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.T(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0289:
            r12 = 1
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.P(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0299:
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            com.google.crypto.tink.shaded.protobuf.b1.b0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02a9:
            r12 = 0
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.a0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02b9:
            r12 = 0
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.Z(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02c9:
            r12 = 0
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.Y(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02d9:
            r12 = 0
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.Q(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02e9:
            r12 = 0
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.d0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02f9:
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.O(r4, r5, r2)
            goto L_0x008a
        L_0x0308:
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.z0 r6 = r0.r(r10)
            com.google.crypto.tink.shaded.protobuf.b1.X(r4, r5, r2, r6)
            goto L_0x008a
        L_0x031b:
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.c0(r4, r5, r2)
            goto L_0x008a
        L_0x032a:
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            com.google.crypto.tink.shaded.protobuf.b1.N(r4, r5, r2, r12)
            goto L_0x0494
        L_0x033a:
            r12 = 0
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.R(r4, r5, r2, r12)
            goto L_0x0494
        L_0x034a:
            r12 = 0
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.S(r4, r5, r2, r12)
            goto L_0x0494
        L_0x035a:
            r12 = 0
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.V(r4, r5, r2, r12)
            goto L_0x0494
        L_0x036a:
            r12 = 0
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.e0(r4, r5, r2, r12)
            goto L_0x0494
        L_0x037a:
            r12 = 0
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.W(r4, r5, r2, r12)
            goto L_0x0494
        L_0x038a:
            r12 = 0
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.T(r4, r5, r2, r12)
            goto L_0x0494
        L_0x039a:
            r12 = 0
            int r4 = r0.Q(r10)
            java.lang.Object r5 = r8.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.crypto.tink.shaded.protobuf.b1.P(r4, r5, r2, r12)
            goto L_0x0494
        L_0x03aa:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r8.getObject(r1, r5)
            com.google.crypto.tink.shaded.protobuf.z0 r5 = r0.r(r10)
            r2.K(r13, r4, r5)
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
            com.google.crypto.tink.shaded.protobuf.ByteString r4 = (com.google.crypto.tink.shaded.protobuf.ByteString) r4
            r2.M(r13, r4)
            goto L_0x0494
        L_0x0418:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r8.getObject(r1, r5)
            com.google.crypto.tink.shaded.protobuf.z0 r5 = r0.r(r10)
            r2.N(r13, r4, r5)
            goto L_0x0494
        L_0x0429:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r8.getObject(r1, r5)
            r0.t0(r13, r4, r2)
            goto L_0x0494
        L_0x0435:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            boolean r4 = i(r1, r5)
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
            float r4 = o(r1, r5)
            r2.B(r13, r4)
            goto L_0x0494
        L_0x0489:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            double r4 = k(r1, r5)
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
            com.google.crypto.tink.shaded.protobuf.p<?> r4 = r0.f20887p
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
            com.google.crypto.tink.shaded.protobuf.f1<?, ?> r3 = r0.f20886o
            r0.u0(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o0.p0(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Writer):void");
    }

    private Object q(int i10) {
        return this.f20873b[(i10 / 3) * 2];
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0588  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q0(T r13, com.google.crypto.tink.shaded.protobuf.Writer r14) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.f20877f
            r1 = 0
            if (r0 == 0) goto L_0x001c
            com.google.crypto.tink.shaded.protobuf.p<?> r0 = r12.f20887p
            com.google.crypto.tink.shaded.protobuf.t r0 = r0.c(r13)
            boolean r2 = r0.m()
            if (r2 != 0) goto L_0x001c
            java.util.Iterator r0 = r0.r()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x001e
        L_0x001c:
            r0 = r1
            r2 = r0
        L_0x001e:
            int[] r3 = r12.f20872a
            int r3 = r3.length
            r4 = 0
            r5 = r4
        L_0x0023:
            if (r5 >= r3) goto L_0x0586
            int r6 = r12.o0(r5)
            int r7 = r12.Q(r5)
        L_0x002d:
            if (r2 == 0) goto L_0x004b
            com.google.crypto.tink.shaded.protobuf.p<?> r8 = r12.f20887p
            int r8 = r8.a(r2)
            if (r8 > r7) goto L_0x004b
            com.google.crypto.tink.shaded.protobuf.p<?> r8 = r12.f20887p
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
            int r8 = n0(r6)
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
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            com.google.crypto.tink.shaded.protobuf.z0 r8 = r12.r(r5)
            r14.K(r7, r6, r8)
            goto L_0x0582
        L_0x006c:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            long r8 = W(r13, r8)
            r14.m(r7, r8)
            goto L_0x0582
        L_0x007f:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            int r6 = V(r13, r8)
            r14.H(r7, r6)
            goto L_0x0582
        L_0x0092:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            long r8 = W(r13, r8)
            r14.i(r7, r8)
            goto L_0x0582
        L_0x00a5:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            int r6 = V(r13, r8)
            r14.w(r7, r6)
            goto L_0x0582
        L_0x00b8:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            int r6 = V(r13, r8)
            r14.E(r7, r6)
            goto L_0x0582
        L_0x00cb:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            int r6 = V(r13, r8)
            r14.o(r7, r6)
            goto L_0x0582
        L_0x00de:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            com.google.crypto.tink.shaded.protobuf.ByteString r6 = (com.google.crypto.tink.shaded.protobuf.ByteString) r6
            r14.M(r7, r6)
            goto L_0x0582
        L_0x00f3:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            com.google.crypto.tink.shaded.protobuf.z0 r8 = r12.r(r5)
            r14.N(r7, r6, r8)
            goto L_0x0582
        L_0x010a:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            r12.t0(r7, r6, r14)
            goto L_0x0582
        L_0x011d:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            boolean r6 = S(r13, r8)
            r14.v(r7, r6)
            goto L_0x0582
        L_0x0130:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            int r6 = V(r13, r8)
            r14.c(r7, r6)
            goto L_0x0582
        L_0x0143:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            long r8 = W(r13, r8)
            r14.s(r7, r8)
            goto L_0x0582
        L_0x0156:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            int r6 = V(r13, r8)
            r14.h(r7, r6)
            goto L_0x0582
        L_0x0169:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            long r8 = W(r13, r8)
            r14.f(r7, r8)
            goto L_0x0582
        L_0x017c:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            long r8 = W(r13, r8)
            r14.u(r7, r8)
            goto L_0x0582
        L_0x018f:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            float r6 = U(r13, r8)
            r14.B(r7, r6)
            goto L_0x0582
        L_0x01a2:
            boolean r8 = r12.E(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            double r8 = T(r13, r8)
            r14.p(r7, r8)
            goto L_0x0582
        L_0x01b5:
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            r12.s0(r14, r7, r6, r5)
            goto L_0x0582
        L_0x01c2:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.z0 r8 = r12.r(r5)
            com.google.crypto.tink.shaded.protobuf.b1.U(r7, r6, r14, r8)
            goto L_0x0582
        L_0x01d9:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.b0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ec:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.a0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ff:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.Z(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0212:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.Y(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0225:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.Q(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0238:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.d0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x024b:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.N(r7, r6, r14, r9)
            goto L_0x0582
        L_0x025e:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.R(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0271:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.S(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0284:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.V(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0297:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.e0(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02aa:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.W(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02bd:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.T(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02d0:
            int r7 = r12.Q(r5)
            long r10 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.P(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02e3:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.b0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x02f6:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.a0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0309:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.Z(r7, r6, r14, r4)
            goto L_0x0582
        L_0x031c:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.Y(r7, r6, r14, r4)
            goto L_0x0582
        L_0x032f:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.Q(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0342:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.d0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0355:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.O(r7, r6, r14)
            goto L_0x0582
        L_0x0368:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.z0 r8 = r12.r(r5)
            com.google.crypto.tink.shaded.protobuf.b1.X(r7, r6, r14, r8)
            goto L_0x0582
        L_0x037f:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.c0(r7, r6, r14)
            goto L_0x0582
        L_0x0392:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.N(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03a5:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.R(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03b8:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.S(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03cb:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.V(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03de:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.e0(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03f1:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.W(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0404:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.T(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0417:
            int r7 = r12.Q(r5)
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.b1.P(r7, r6, r14, r4)
            goto L_0x0582
        L_0x042a:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            com.google.crypto.tink.shaded.protobuf.z0 r8 = r12.r(r5)
            r14.K(r7, r6, r8)
            goto L_0x0582
        L_0x0441:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            long r8 = H(r13, r8)
            r14.m(r7, r8)
            goto L_0x0582
        L_0x0454:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            int r6 = w(r13, r8)
            r14.H(r7, r6)
            goto L_0x0582
        L_0x0467:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            long r8 = H(r13, r8)
            r14.i(r7, r8)
            goto L_0x0582
        L_0x047a:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            int r6 = w(r13, r8)
            r14.w(r7, r6)
            goto L_0x0582
        L_0x048d:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            int r6 = w(r13, r8)
            r14.E(r7, r6)
            goto L_0x0582
        L_0x04a0:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            int r6 = w(r13, r8)
            r14.o(r7, r6)
            goto L_0x0582
        L_0x04b3:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            com.google.crypto.tink.shaded.protobuf.ByteString r6 = (com.google.crypto.tink.shaded.protobuf.ByteString) r6
            r14.M(r7, r6)
            goto L_0x0582
        L_0x04c8:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            com.google.crypto.tink.shaded.protobuf.z0 r8 = r12.r(r5)
            r14.N(r7, r6, r8)
            goto L_0x0582
        L_0x04df:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r13, r8)
            r12.t0(r7, r6, r14)
            goto L_0x0582
        L_0x04f2:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            boolean r6 = i(r13, r8)
            r14.v(r7, r6)
            goto L_0x0582
        L_0x0505:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            int r6 = w(r13, r8)
            r14.c(r7, r6)
            goto L_0x0582
        L_0x0517:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            long r8 = H(r13, r8)
            r14.s(r7, r8)
            goto L_0x0582
        L_0x0529:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            int r6 = w(r13, r8)
            r14.h(r7, r6)
            goto L_0x0582
        L_0x053b:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            long r8 = H(r13, r8)
            r14.f(r7, r8)
            goto L_0x0582
        L_0x054d:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            long r8 = H(r13, r8)
            r14.u(r7, r8)
            goto L_0x0582
        L_0x055f:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            float r6 = o(r13, r8)
            r14.B(r7, r6)
            goto L_0x0582
        L_0x0571:
            boolean r8 = r12.y(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = R(r6)
            double r8 = k(r13, r8)
            r14.p(r7, r8)
        L_0x0582:
            int r5 = r5 + 3
            goto L_0x0023
        L_0x0586:
            if (r2 == 0) goto L_0x059c
            com.google.crypto.tink.shaded.protobuf.p<?> r3 = r12.f20887p
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
            com.google.crypto.tink.shaded.protobuf.f1<?, ?> r0 = r12.f20886o
            r12.u0(r0, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o0.q0(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Writer):void");
    }

    private z0 r(int i10) {
        int i11 = (i10 / 3) * 2;
        z0 z0Var = (z0) this.f20873b[i11];
        if (z0Var != null) {
            return z0Var;
        }
        z0 d10 = v0.a().d((Class) this.f20873b[i11 + 1]);
        this.f20873b[i11] = d10;
        return d10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r0(T r11, com.google.crypto.tink.shaded.protobuf.Writer r12) throws java.io.IOException {
        /*
            r10 = this;
            com.google.crypto.tink.shaded.protobuf.f1<?, ?> r0 = r10.f20886o
            r10.u0(r0, r11, r12)
            boolean r0 = r10.f20877f
            r1 = 0
            if (r0 == 0) goto L_0x0021
            com.google.crypto.tink.shaded.protobuf.p<?> r0 = r10.f20887p
            com.google.crypto.tink.shaded.protobuf.t r0 = r0.c(r11)
            boolean r2 = r0.m()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.g()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0023
        L_0x0021:
            r0 = r1
            r2 = r0
        L_0x0023:
            int[] r3 = r10.f20872a
            int r3 = r3.length
            int r3 = r3 + -3
        L_0x0028:
            if (r3 < 0) goto L_0x058c
            int r4 = r10.o0(r3)
            int r5 = r10.Q(r3)
        L_0x0032:
            if (r2 == 0) goto L_0x0050
            com.google.crypto.tink.shaded.protobuf.p<?> r6 = r10.f20887p
            int r6 = r6.a(r2)
            if (r6 <= r5) goto L_0x0050
            com.google.crypto.tink.shaded.protobuf.p<?> r6 = r10.f20887p
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
            int r6 = n0(r4)
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
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            com.google.crypto.tink.shaded.protobuf.z0 r6 = r10.r(r3)
            r12.K(r5, r4, r6)
            goto L_0x0588
        L_0x0072:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            long r6 = W(r11, r6)
            r12.m(r5, r6)
            goto L_0x0588
        L_0x0085:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            int r4 = V(r11, r6)
            r12.H(r5, r4)
            goto L_0x0588
        L_0x0098:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            long r6 = W(r11, r6)
            r12.i(r5, r6)
            goto L_0x0588
        L_0x00ab:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            int r4 = V(r11, r6)
            r12.w(r5, r4)
            goto L_0x0588
        L_0x00be:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            int r4 = V(r11, r6)
            r12.E(r5, r4)
            goto L_0x0588
        L_0x00d1:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            int r4 = V(r11, r6)
            r12.o(r5, r4)
            goto L_0x0588
        L_0x00e4:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            com.google.crypto.tink.shaded.protobuf.ByteString r4 = (com.google.crypto.tink.shaded.protobuf.ByteString) r4
            r12.M(r5, r4)
            goto L_0x0588
        L_0x00f9:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            com.google.crypto.tink.shaded.protobuf.z0 r6 = r10.r(r3)
            r12.N(r5, r4, r6)
            goto L_0x0588
        L_0x0110:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            r10.t0(r5, r4, r12)
            goto L_0x0588
        L_0x0123:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            boolean r4 = S(r11, r6)
            r12.v(r5, r4)
            goto L_0x0588
        L_0x0136:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            int r4 = V(r11, r6)
            r12.c(r5, r4)
            goto L_0x0588
        L_0x0149:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            long r6 = W(r11, r6)
            r12.s(r5, r6)
            goto L_0x0588
        L_0x015c:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            int r4 = V(r11, r6)
            r12.h(r5, r4)
            goto L_0x0588
        L_0x016f:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            long r6 = W(r11, r6)
            r12.f(r5, r6)
            goto L_0x0588
        L_0x0182:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            long r6 = W(r11, r6)
            r12.u(r5, r6)
            goto L_0x0588
        L_0x0195:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            float r4 = U(r11, r6)
            r12.B(r5, r4)
            goto L_0x0588
        L_0x01a8:
            boolean r6 = r10.E(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            double r6 = T(r11, r6)
            r12.p(r5, r6)
            goto L_0x0588
        L_0x01bb:
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            r10.s0(r12, r5, r4, r3)
            goto L_0x0588
        L_0x01c8:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.z0 r6 = r10.r(r3)
            com.google.crypto.tink.shaded.protobuf.b1.U(r5, r4, r12, r6)
            goto L_0x0588
        L_0x01df:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.b0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x01f2:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.a0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0205:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.Z(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0218:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.Y(r5, r4, r12, r7)
            goto L_0x0588
        L_0x022b:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.Q(r5, r4, r12, r7)
            goto L_0x0588
        L_0x023e:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.d0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0251:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.N(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0264:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.R(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0277:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.S(r5, r4, r12, r7)
            goto L_0x0588
        L_0x028a:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.V(r5, r4, r12, r7)
            goto L_0x0588
        L_0x029d:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.e0(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02b0:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.W(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02c3:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.T(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02d6:
            int r5 = r10.Q(r3)
            long r8 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.P(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02e9:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.b0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02fc:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.a0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x030f:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.Z(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0322:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.Y(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0335:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.Q(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0348:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.d0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x035b:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.O(r5, r4, r12)
            goto L_0x0588
        L_0x036e:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.z0 r6 = r10.r(r3)
            com.google.crypto.tink.shaded.protobuf.b1.X(r5, r4, r12, r6)
            goto L_0x0588
        L_0x0385:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.c0(r5, r4, r12)
            goto L_0x0588
        L_0x0398:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.N(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03ab:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.R(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03be:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.S(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03d1:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.V(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03e4:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.e0(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03f7:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.W(r5, r4, r12, r8)
            goto L_0x0588
        L_0x040a:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.T(r5, r4, r12, r8)
            goto L_0x0588
        L_0x041d:
            int r5 = r10.Q(r3)
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.b1.P(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0430:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            com.google.crypto.tink.shaded.protobuf.z0 r6 = r10.r(r3)
            r12.K(r5, r4, r6)
            goto L_0x0588
        L_0x0447:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            long r6 = H(r11, r6)
            r12.m(r5, r6)
            goto L_0x0588
        L_0x045a:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            int r4 = w(r11, r6)
            r12.H(r5, r4)
            goto L_0x0588
        L_0x046d:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            long r6 = H(r11, r6)
            r12.i(r5, r6)
            goto L_0x0588
        L_0x0480:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            int r4 = w(r11, r6)
            r12.w(r5, r4)
            goto L_0x0588
        L_0x0493:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            int r4 = w(r11, r6)
            r12.E(r5, r4)
            goto L_0x0588
        L_0x04a6:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            int r4 = w(r11, r6)
            r12.o(r5, r4)
            goto L_0x0588
        L_0x04b9:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            com.google.crypto.tink.shaded.protobuf.ByteString r4 = (com.google.crypto.tink.shaded.protobuf.ByteString) r4
            r12.M(r5, r4)
            goto L_0x0588
        L_0x04ce:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            com.google.crypto.tink.shaded.protobuf.z0 r6 = r10.r(r3)
            r12.N(r5, r4, r6)
            goto L_0x0588
        L_0x04e5:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.j1.A(r11, r6)
            r10.t0(r5, r4, r12)
            goto L_0x0588
        L_0x04f8:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            boolean r4 = i(r11, r6)
            r12.v(r5, r4)
            goto L_0x0588
        L_0x050b:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            int r4 = w(r11, r6)
            r12.c(r5, r4)
            goto L_0x0588
        L_0x051d:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            long r6 = H(r11, r6)
            r12.s(r5, r6)
            goto L_0x0588
        L_0x052f:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            int r4 = w(r11, r6)
            r12.h(r5, r4)
            goto L_0x0588
        L_0x0541:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            long r6 = H(r11, r6)
            r12.f(r5, r6)
            goto L_0x0588
        L_0x0553:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            long r6 = H(r11, r6)
            r12.u(r5, r6)
            goto L_0x0588
        L_0x0565:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            float r4 = o(r11, r6)
            r12.B(r5, r4)
            goto L_0x0588
        L_0x0577:
            boolean r6 = r10.y(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = R(r4)
            double r6 = k(r11, r6)
            r12.p(r5, r6)
        L_0x0588:
            int r3 = r3 + -3
            goto L_0x0028
        L_0x058c:
            if (r2 == 0) goto L_0x05a3
            com.google.crypto.tink.shaded.protobuf.p<?> r11 = r10.f20887p
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o0.r0(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Writer):void");
    }

    static g1 s(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        g1 g1Var = generatedMessageLite.unknownFields;
        if (g1Var != g1.e()) {
            return g1Var;
        }
        g1 l10 = g1.l();
        generatedMessageLite.unknownFields = l10;
        return l10;
    }

    private <K, V> void s0(Writer writer, int i10, Object obj, int i11) throws IOException {
        if (obj != null) {
            this.f20888q.b(q(i11));
            writer.J(i10, (f0.a) null, this.f20888q.e(obj));
        }
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
    private int t(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            sun.misc.Unsafe r2 = f20871s
            r4 = -1
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x000a:
            int[] r8 = r0.f20872a
            int r8 = r8.length
            if (r5 >= r8) goto L_0x0522
            int r8 = r0.o0(r5)
            int r9 = r0.Q(r5)
            int r10 = n0(r8)
            r11 = 17
            r12 = 1048575(0xfffff, float:1.469367E-39)
            r13 = 1
            if (r10 > r11) goto L_0x0039
            int[] r11 = r0.f20872a
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
            boolean r11 = r0.f20880i
            if (r11 == 0) goto L_0x0055
            com.google.crypto.tink.shaded.protobuf.FieldType r11 = com.google.crypto.tink.shaded.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r11 = r11.a()
            if (r10 < r11) goto L_0x0055
            com.google.crypto.tink.shaded.protobuf.FieldType r11 = com.google.crypto.tink.shaded.protobuf.FieldType.SINT64_LIST_PACKED
            int r11 = r11.a()
            if (r10 > r11) goto L_0x0055
            int[] r11 = r0.f20872a
            int r13 = r5 + 2
            r11 = r11[r13]
            r11 = r11 & r12
            goto L_0x0056
        L_0x0055:
            r11 = 0
        L_0x0056:
            r14 = 0
        L_0x0057:
            long r12 = R(r8)
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
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            com.google.crypto.tink.shaded.protobuf.l0 r3 = (com.google.crypto.tink.shaded.protobuf.l0) r3
            com.google.crypto.tink.shaded.protobuf.z0 r4 = r0.r(r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.s(r9, r3, r4)
            goto L_0x0422
        L_0x007b:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            long r3 = W(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.Q(r9, r3)
            goto L_0x0422
        L_0x008b:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = V(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.O(r9, r3)
            goto L_0x0422
        L_0x009b:
            boolean r8 = r0.E(r1, r9, r5)
            if (r8 == 0) goto L_0x0423
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.M(r9, r3)
            goto L_0x0422
        L_0x00a7:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            r3 = 0
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.K(r9, r3)
            goto L_0x0465
        L_0x00b4:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = V(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.k(r9, r3)
            goto L_0x0422
        L_0x00c4:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = V(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.V(r9, r3)
            goto L_0x0422
        L_0x00d4:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            com.google.crypto.tink.shaded.protobuf.ByteString r3 = (com.google.crypto.tink.shaded.protobuf.ByteString) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.g(r9, r3)
            goto L_0x0422
        L_0x00e6:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            com.google.crypto.tink.shaded.protobuf.z0 r4 = r0.r(r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.o(r9, r3, r4)
            goto L_0x0422
        L_0x00fa:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            boolean r4 = r3 instanceof com.google.crypto.tink.shaded.protobuf.ByteString
            if (r4 == 0) goto L_0x0110
            com.google.crypto.tink.shaded.protobuf.ByteString r3 = (com.google.crypto.tink.shaded.protobuf.ByteString) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.g(r9, r3)
            goto L_0x0422
        L_0x0110:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.S(r9, r3)
            goto L_0x0422
        L_0x0118:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            r3 = 1
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.d(r9, r3)
            goto L_0x0422
        L_0x0125:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            r3 = 0
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.m(r9, r3)
            goto L_0x0465
        L_0x0132:
            boolean r8 = r0.E(r1, r9, r5)
            if (r8 == 0) goto L_0x0423
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.o(r9, r3)
            goto L_0x0422
        L_0x013e:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = V(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.v(r9, r3)
            goto L_0x0422
        L_0x014e:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            long r3 = W(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.X(r9, r3)
            goto L_0x0422
        L_0x015e:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            long r3 = W(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.x(r9, r3)
            goto L_0x0422
        L_0x016e:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.q(r9, r8)
            goto L_0x0422
        L_0x017a:
            boolean r3 = r0.E(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            r3 = 0
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.i(r9, r3)
            goto L_0x0422
        L_0x0188:
            com.google.crypto.tink.shaded.protobuf.g0 r3 = r0.f20888q
            java.lang.Object r4 = r2.getObject(r1, r12)
            java.lang.Object r8 = r0.q(r5)
            int r3 = r3.g(r9, r4, r8)
            goto L_0x0422
        L_0x0198:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            com.google.crypto.tink.shaded.protobuf.z0 r4 = r0.r(r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.j(r9, r3, r4)
            goto L_0x0422
        L_0x01a8:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.t(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x01bc
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01bc:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x01c6:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.r(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x01da
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01da:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x01e4:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.i(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x01f8
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01f8:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x0202:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.g(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x0216
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0216:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x0220:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.e(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x0234
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0234:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x023e:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.w(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x0252
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0252:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x025c:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.b(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x0270
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0270:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x027a:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.g(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x028e
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x028e:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x0298:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.i(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x02ac
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02ac:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x02b6:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.l(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x02ca
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02ca:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x02d4:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.y(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x02e8
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02e8:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x02f1:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.n(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x0305
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0305:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x030e:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.g(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x0322
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0322:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
            goto L_0x0347
        L_0x032b:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.i(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.f20880i
            if (r4 == 0) goto L_0x033f
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x033f:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r9)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r3)
        L_0x0347:
            int r4 = r4 + r8
            int r4 = r4 + r3
            goto L_0x0465
        L_0x034b:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.s(r9, r3, r4)
            goto L_0x0413
        L_0x0358:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.q(r9, r3, r4)
            goto L_0x0413
        L_0x0365:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.h(r9, r3, r4)
            goto L_0x0413
        L_0x0372:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.f(r9, r3, r4)
            goto L_0x0413
        L_0x037f:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.d(r9, r3, r4)
            goto L_0x0413
        L_0x038c:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.v(r9, r3, r4)
            goto L_0x0422
        L_0x0399:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.c(r9, r3)
            goto L_0x0422
        L_0x03a5:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            com.google.crypto.tink.shaded.protobuf.z0 r4 = r0.r(r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.p(r9, r3, r4)
            goto L_0x0422
        L_0x03b5:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.u(r9, r3)
            goto L_0x0422
        L_0x03c0:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.a(r9, r3, r4)
            goto L_0x0413
        L_0x03cc:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.f(r9, r3, r4)
            goto L_0x0413
        L_0x03d8:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.h(r9, r3, r4)
            goto L_0x0413
        L_0x03e4:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.k(r9, r3, r4)
            goto L_0x0413
        L_0x03f0:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.x(r9, r3, r4)
            goto L_0x0413
        L_0x03fc:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.m(r9, r3, r4)
            goto L_0x0413
        L_0x0408:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.f(r9, r3, r4)
        L_0x0413:
            int r6 = r6 + r3
            r10 = r4
            goto L_0x051c
        L_0x0417:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.h(r9, r3, r4)
        L_0x0422:
            int r6 = r6 + r3
        L_0x0423:
            r10 = 0
            goto L_0x051c
        L_0x0426:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            com.google.crypto.tink.shaded.protobuf.l0 r3 = (com.google.crypto.tink.shaded.protobuf.l0) r3
            com.google.crypto.tink.shaded.protobuf.z0 r4 = r0.r(r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.s(r9, r3, r4)
            goto L_0x0422
        L_0x0439:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            long r3 = r2.getLong(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.Q(r9, r3)
            goto L_0x0422
        L_0x0446:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            int r3 = r2.getInt(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.O(r9, r3)
            goto L_0x0422
        L_0x0453:
            r8 = r7 & r14
            if (r8 == 0) goto L_0x0423
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.M(r9, r3)
            goto L_0x0422
        L_0x045c:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            r3 = 0
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.K(r9, r3)
        L_0x0465:
            int r6 = r6 + r4
            goto L_0x0423
        L_0x0467:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            int r3 = r2.getInt(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.k(r9, r3)
            goto L_0x0422
        L_0x0474:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            int r3 = r2.getInt(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.V(r9, r3)
            goto L_0x0422
        L_0x0481:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            com.google.crypto.tink.shaded.protobuf.ByteString r3 = (com.google.crypto.tink.shaded.protobuf.ByteString) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.g(r9, r3)
            goto L_0x0422
        L_0x0490:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            com.google.crypto.tink.shaded.protobuf.z0 r4 = r0.r(r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.b1.o(r9, r3, r4)
            goto L_0x0422
        L_0x04a1:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            boolean r4 = r3 instanceof com.google.crypto.tink.shaded.protobuf.ByteString
            if (r4 == 0) goto L_0x04b5
            com.google.crypto.tink.shaded.protobuf.ByteString r3 = (com.google.crypto.tink.shaded.protobuf.ByteString) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.g(r9, r3)
            goto L_0x0422
        L_0x04b5:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.S(r9, r3)
            goto L_0x0422
        L_0x04bd:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            r3 = 1
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.d(r9, r3)
            goto L_0x0422
        L_0x04c8:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            r10 = 0
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.m(r9, r10)
            goto L_0x051b
        L_0x04d2:
            r10 = 0
            r8 = r7 & r14
            if (r8 == 0) goto L_0x051c
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.o(r9, r3)
            goto L_0x051b
        L_0x04dc:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            int r3 = r2.getInt(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.v(r9, r3)
            goto L_0x051b
        L_0x04ea:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            long r3 = r2.getLong(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.X(r9, r3)
            goto L_0x051b
        L_0x04f8:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            long r3 = r2.getLong(r1, r12)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.x(r9, r3)
            goto L_0x051b
        L_0x0506:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.q(r9, r8)
            goto L_0x051b
        L_0x0510:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            r3 = 0
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.i(r9, r3)
        L_0x051b:
            int r6 = r6 + r3
        L_0x051c:
            int r5 = r5 + 3
            r4 = r16
            goto L_0x000a
        L_0x0522:
            com.google.crypto.tink.shaded.protobuf.f1<?, ?> r2 = r0.f20886o
            int r2 = r0.v(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.f20877f
            if (r2 == 0) goto L_0x0538
            com.google.crypto.tink.shaded.protobuf.p<?> r2 = r0.f20887p
            com.google.crypto.tink.shaded.protobuf.t r1 = r2.c(r1)
            int r1 = r1.l()
            int r6 = r6 + r1
        L_0x0538:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o0.t(java.lang.Object):int");
    }

    private void t0(int i10, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.e(i10, (String) obj);
        } else {
            writer.M(i10, (ByteString) obj);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int u(T r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = f20871s
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0008:
            int[] r6 = r0.f20872a
            int r6 = r6.length
            if (r4 >= r6) goto L_0x04e3
            int r6 = r15.o0(r4)
            int r7 = n0(r6)
            int r8 = r15.Q(r4)
            long r9 = R(r6)
            com.google.crypto.tink.shaded.protobuf.FieldType r6 = com.google.crypto.tink.shaded.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r6 = r6.a()
            if (r7 < r6) goto L_0x0038
            com.google.crypto.tink.shaded.protobuf.FieldType r6 = com.google.crypto.tink.shaded.protobuf.FieldType.SINT64_LIST_PACKED
            int r6 = r6.a()
            if (r7 > r6) goto L_0x0038
            int[] r6 = r0.f20872a
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
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r1, r9)
            com.google.crypto.tink.shaded.protobuf.l0 r6 = (com.google.crypto.tink.shaded.protobuf.l0) r6
            com.google.crypto.tink.shaded.protobuf.z0 r7 = r15.r(r4)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.s(r8, r6, r7)
            goto L_0x03c4
        L_0x0058:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = W(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.Q(r8, r6)
            goto L_0x03c4
        L_0x0068:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = V(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.O(r8, r6)
            goto L_0x03c4
        L_0x0078:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.M(r8, r13)
            goto L_0x03c4
        L_0x0084:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.K(r8, r3)
            goto L_0x03c4
        L_0x0090:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = V(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.k(r8, r6)
            goto L_0x03c4
        L_0x00a0:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = V(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.V(r8, r6)
            goto L_0x03c4
        L_0x00b0:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r1, r9)
            com.google.crypto.tink.shaded.protobuf.ByteString r6 = (com.google.crypto.tink.shaded.protobuf.ByteString) r6
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.g(r8, r6)
            goto L_0x03c4
        L_0x00c2:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r1, r9)
            com.google.crypto.tink.shaded.protobuf.z0 r7 = r15.r(r4)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.o(r8, r6, r7)
            goto L_0x03c4
        L_0x00d6:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r1, r9)
            boolean r7 = r6 instanceof com.google.crypto.tink.shaded.protobuf.ByteString
            if (r7 == 0) goto L_0x00ec
            com.google.crypto.tink.shaded.protobuf.ByteString r6 = (com.google.crypto.tink.shaded.protobuf.ByteString) r6
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.g(r8, r6)
            goto L_0x03c4
        L_0x00ec:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.S(r8, r6)
            goto L_0x03c4
        L_0x00f4:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.d(r8, r11)
            goto L_0x03c4
        L_0x0100:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.m(r8, r3)
            goto L_0x03c4
        L_0x010c:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.o(r8, r13)
            goto L_0x03c4
        L_0x0118:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = V(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.v(r8, r6)
            goto L_0x03c4
        L_0x0128:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = W(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.X(r8, r6)
            goto L_0x03c4
        L_0x0138:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = W(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.x(r8, r6)
            goto L_0x03c4
        L_0x0148:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.q(r8, r12)
            goto L_0x03c4
        L_0x0154:
            boolean r6 = r15.E(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            r6 = 0
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.i(r8, r6)
            goto L_0x03c4
        L_0x0162:
            com.google.crypto.tink.shaded.protobuf.g0 r6 = r0.f20888q
            java.lang.Object r7 = com.google.crypto.tink.shaded.protobuf.j1.A(r1, r9)
            java.lang.Object r9 = r15.q(r4)
            int r6 = r6.g(r8, r7, r9)
            goto L_0x03c4
        L_0x0172:
            java.util.List r6 = G(r1, r9)
            com.google.crypto.tink.shaded.protobuf.z0 r7 = r15.r(r4)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.j(r8, r6, r7)
            goto L_0x03c4
        L_0x0180:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.t(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x0194
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0194:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x019e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.r(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x01b2
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01b2:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x01bc:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x01d0
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01d0:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x01da:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x01ee
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01ee:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x01f8:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.e(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x020c
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x020c:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x0216:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.w(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x022a
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x022a:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x0234:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.b(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x0248
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0248:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x0252:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x0266
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0266:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x0270:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x0284
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0284:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x028e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.l(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x02a2
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02a2:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x02ac:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.y(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x02c0
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02c0:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x02c9:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.n(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x02dd
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02dd:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x02e6:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x02fa
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02fa:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
            goto L_0x031f
        L_0x0303:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.b1.i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.f20880i
            if (r9 == 0) goto L_0x0317
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0317:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.U(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.W(r7)
        L_0x031f:
            int r6 = r6 + r8
            int r6 = r6 + r7
            goto L_0x03c4
        L_0x0323:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.s(r8, r6, r3)
            goto L_0x03c4
        L_0x032d:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.q(r8, r6, r3)
            goto L_0x03c4
        L_0x0337:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.h(r8, r6, r3)
            goto L_0x03c4
        L_0x0341:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.f(r8, r6, r3)
            goto L_0x03c4
        L_0x034b:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.d(r8, r6, r3)
            goto L_0x03c4
        L_0x0355:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.v(r8, r6, r3)
            goto L_0x03c4
        L_0x035e:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.c(r8, r6)
            goto L_0x03c4
        L_0x0367:
            java.util.List r6 = G(r1, r9)
            com.google.crypto.tink.shaded.protobuf.z0 r7 = r15.r(r4)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.p(r8, r6, r7)
            goto L_0x03c4
        L_0x0374:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.u(r8, r6)
            goto L_0x03c4
        L_0x037d:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.a(r8, r6, r3)
            goto L_0x03c4
        L_0x0386:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.f(r8, r6, r3)
            goto L_0x03c4
        L_0x038f:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.h(r8, r6, r3)
            goto L_0x03c4
        L_0x0398:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.k(r8, r6, r3)
            goto L_0x03c4
        L_0x03a1:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.x(r8, r6, r3)
            goto L_0x03c4
        L_0x03aa:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.m(r8, r6, r3)
            goto L_0x03c4
        L_0x03b3:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.f(r8, r6, r3)
            goto L_0x03c4
        L_0x03bc:
            java.util.List r6 = G(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.h(r8, r6, r3)
        L_0x03c4:
            int r5 = r5 + r6
            goto L_0x04df
        L_0x03c7:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r1, r9)
            com.google.crypto.tink.shaded.protobuf.l0 r6 = (com.google.crypto.tink.shaded.protobuf.l0) r6
            com.google.crypto.tink.shaded.protobuf.z0 r7 = r15.r(r4)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.s(r8, r6, r7)
            goto L_0x03c4
        L_0x03dc:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = com.google.crypto.tink.shaded.protobuf.j1.y(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.Q(r8, r6)
            goto L_0x03c4
        L_0x03eb:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.j1.x(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.O(r8, r6)
            goto L_0x03c4
        L_0x03fa:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.M(r8, r13)
            goto L_0x03c4
        L_0x0405:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.K(r8, r3)
            goto L_0x03c4
        L_0x0410:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.j1.x(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.k(r8, r6)
            goto L_0x03c4
        L_0x041f:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.j1.x(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.V(r8, r6)
            goto L_0x03c4
        L_0x042e:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r1, r9)
            com.google.crypto.tink.shaded.protobuf.ByteString r6 = (com.google.crypto.tink.shaded.protobuf.ByteString) r6
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.g(r8, r6)
            goto L_0x03c4
        L_0x043f:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r1, r9)
            com.google.crypto.tink.shaded.protobuf.z0 r7 = r15.r(r4)
            int r6 = com.google.crypto.tink.shaded.protobuf.b1.o(r8, r6, r7)
            goto L_0x03c4
        L_0x0453:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.j1.A(r1, r9)
            boolean r7 = r6 instanceof com.google.crypto.tink.shaded.protobuf.ByteString
            if (r7 == 0) goto L_0x0469
            com.google.crypto.tink.shaded.protobuf.ByteString r6 = (com.google.crypto.tink.shaded.protobuf.ByteString) r6
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.g(r8, r6)
            goto L_0x03c4
        L_0x0469:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.S(r8, r6)
            goto L_0x03c4
        L_0x0471:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.d(r8, r11)
            goto L_0x03c4
        L_0x047d:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.m(r8, r3)
            goto L_0x03c4
        L_0x0489:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.o(r8, r13)
            goto L_0x03c4
        L_0x0495:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.j1.x(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.v(r8, r6)
            goto L_0x03c4
        L_0x04a5:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = com.google.crypto.tink.shaded.protobuf.j1.y(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.X(r8, r6)
            goto L_0x03c4
        L_0x04b5:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = com.google.crypto.tink.shaded.protobuf.j1.y(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.x(r8, r6)
            goto L_0x03c4
        L_0x04c5:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.q(r8, r12)
            goto L_0x03c4
        L_0x04d1:
            boolean r6 = r15.y(r1, r4)
            if (r6 == 0) goto L_0x04df
            r6 = 0
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.i(r8, r6)
            goto L_0x03c4
        L_0x04df:
            int r4 = r4 + 3
            goto L_0x0008
        L_0x04e3:
            com.google.crypto.tink.shaded.protobuf.f1<?, ?> r2 = r0.f20886o
            int r1 = r15.v(r2, r1)
            int r5 = r5 + r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o0.u(java.lang.Object):int");
    }

    private <UT, UB> void u0(f1<UT, UB> f1Var, T t10, Writer writer) throws IOException {
        f1Var.t(f1Var.g(t10), writer);
    }

    private <UT, UB> int v(f1<UT, UB> f1Var, T t10) {
        return f1Var.h(f1Var.g(t10));
    }

    private static <T> int w(T t10, long j10) {
        return j1.x(t10, j10);
    }

    private static boolean x(int i10) {
        return (i10 & 536870912) != 0;
    }

    private boolean y(T t10, int i10) {
        if (this.f20879h) {
            int o02 = o0(i10);
            long R = R(o02);
            switch (n0(o02)) {
                case 0:
                    if (j1.v(t10, R) != 0.0d) {
                        return true;
                    }
                    return false;
                case 1:
                    if (j1.w(t10, R) != 0.0f) {
                        return true;
                    }
                    return false;
                case 2:
                    if (j1.y(t10, R) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (j1.y(t10, R) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (j1.x(t10, R) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (j1.y(t10, R) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (j1.x(t10, R) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return j1.p(t10, R);
                case 8:
                    Object A = j1.A(t10, R);
                    if (A instanceof String) {
                        return !((String) A).isEmpty();
                    }
                    if (A instanceof ByteString) {
                        return !ByteString.f20615a.equals(A);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (j1.A(t10, R) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    return !ByteString.f20615a.equals(j1.A(t10, R));
                case 11:
                    if (j1.x(t10, R) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (j1.x(t10, R) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (j1.x(t10, R) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (j1.y(t10, R) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (j1.x(t10, R) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (j1.y(t10, R) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (j1.A(t10, R) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int e02 = e0(i10);
            if ((j1.x(t10, (long) (e02 & 1048575)) & (1 << (e02 >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    private boolean z(T t10, int i10, int i11, int i12) {
        if (this.f20879h) {
            return y(t10, i10);
        }
        if ((i11 & i12) != 0) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0359, code lost:
        if (r0 != r15) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x03a2, code lost:
        if (r0 != r15) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03c5, code lost:
        if (r0 != r15) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x03c8, code lost:
        r2 = r0;
        r8 = r18;
        r0 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fc, code lost:
        r12 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0162, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0205, code lost:
        r6 = r6 | r20;
        r2 = r8;
        r3 = r13;
        r1 = r17;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x022f, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0269, code lost:
        r6 = r6 | r20;
        r2 = r8;
        r0 = r11;
        r3 = r13;
        r1 = r17;
        r13 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0272, code lost:
        r11 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02a8, code lost:
        r0 = r11 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02aa, code lost:
        r6 = r6 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02ac, code lost:
        r11 = r35;
        r2 = r8;
        r3 = r13;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02b4, code lost:
        r0 = r35;
        r22 = r6;
        r19 = r7;
        r20 = r8;
        r28 = r10;
        r2 = r11;
        r8 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x03ec  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x03fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int Z(T r31, byte[] r32, int r33, int r34, int r35, com.google.crypto.tink.shaded.protobuf.e.b r36) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            sun.misc.Unsafe r10 = f20871s
            r16 = 0
            r0 = r33
            r2 = r16
            r3 = r2
            r6 = r3
            r1 = -1
            r7 = -1
        L_0x0018:
            if (r0 >= r13) goto L_0x0421
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.crypto.tink.shaded.protobuf.e.H(r0, r12, r3, r9)
            int r3 = r9.f20783a
            r4 = r0
            r5 = r3
            goto L_0x002b
        L_0x0029:
            r5 = r0
            r4 = r3
        L_0x002b:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x0038
            int r2 = r2 / r8
            int r1 = r15.d0(r3, r2)
            goto L_0x003c
        L_0x0038:
            int r1 = r15.c0(r3)
        L_0x003c:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004f
            r17 = r3
            r2 = r4
            r8 = r5
            r22 = r6
            r19 = r7
            r28 = r10
            r0 = r11
            r20 = r16
            goto L_0x03cd
        L_0x004f:
            int[] r1 = r15.f20872a
            int r18 = r2 + 1
            r1 = r1[r18]
            int r8 = n0(r1)
            long r11 = R(r1)
            r18 = r5
            r5 = 17
            r19 = r1
            if (r8 > r5) goto L_0x02c2
            int[] r5 = r15.f20872a
            int r20 = r2 + 2
            r5 = r5[r20]
            int r20 = r5 >>> 20
            r1 = 1
            int r20 = r1 << r20
            r22 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r22
            if (r5 == r7) goto L_0x0087
            r13 = -1
            r17 = r2
            if (r7 == r13) goto L_0x0080
            long r1 = (long) r7
            r10.putInt(r14, r1, r6)
        L_0x0080:
            long r1 = (long) r5
            int r6 = r10.getInt(r14, r1)
            r7 = r5
            goto L_0x008a
        L_0x0087:
            r17 = r2
            r13 = -1
        L_0x008a:
            r1 = 5
            switch(r8) {
                case 0: goto L_0x0290;
                case 1: goto L_0x0276;
                case 2: goto L_0x024d;
                case 3: goto L_0x024d;
                case 4: goto L_0x0232;
                case 5: goto L_0x020e;
                case 6: goto L_0x01eb;
                case 7: goto L_0x01c6;
                case 8: goto L_0x019f;
                case 9: goto L_0x0167;
                case 10: goto L_0x014b;
                case 11: goto L_0x0232;
                case 12: goto L_0x011a;
                case 13: goto L_0x01eb;
                case 14: goto L_0x020e;
                case 15: goto L_0x0100;
                case 16: goto L_0x00df;
                case 17: goto L_0x009d;
                default: goto L_0x008e;
            }
        L_0x008e:
            r12 = r32
            r11 = r4
            r8 = r17
            r17 = r3
            r29 = r18
            r18 = r13
            r13 = r29
            goto L_0x02b4
        L_0x009d:
            r2 = 3
            if (r0 != r2) goto L_0x00d8
            int r0 = r3 << 3
            r5 = r0 | 4
            r2 = r17
            com.google.crypto.tink.shaded.protobuf.z0 r0 = r15.r(r2)
            r1 = r32
            r8 = r2
            r2 = r4
            r17 = r3
            r3 = r34
            r4 = r5
            r13 = r18
            r5 = r36
            int r0 = com.google.crypto.tink.shaded.protobuf.e.n(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x00c5
            java.lang.Object r1 = r9.f20785c
            r10.putObject(r14, r11, r1)
            goto L_0x00d2
        L_0x00c5:
            java.lang.Object r1 = r10.getObject(r14, r11)
            java.lang.Object r2 = r9.f20785c
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.x.h(r1, r2)
            r10.putObject(r14, r11, r1)
        L_0x00d2:
            r6 = r6 | r20
            r12 = r32
            goto L_0x02ac
        L_0x00d8:
            r8 = r17
            r13 = r18
            r17 = r3
            goto L_0x00fc
        L_0x00df:
            r8 = r17
            r13 = r18
            r17 = r3
            if (r0 != 0) goto L_0x00fc
            r2 = r11
            r12 = r32
            int r11 = com.google.crypto.tink.shaded.protobuf.e.L(r12, r4, r9)
            long r0 = r9.f20784b
            long r4 = com.google.crypto.tink.shaded.protobuf.i.c(r0)
            r0 = r10
            r1 = r31
            r0.putLong(r1, r2, r4)
            goto L_0x0269
        L_0x00fc:
            r12 = r32
            goto L_0x0162
        L_0x0100:
            r8 = r17
            r13 = r18
            r17 = r3
            r2 = r11
            r12 = r32
            if (r0 != 0) goto L_0x0162
            int r0 = com.google.crypto.tink.shaded.protobuf.e.I(r12, r4, r9)
            int r1 = r9.f20783a
            int r1 = com.google.crypto.tink.shaded.protobuf.i.b(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x02aa
        L_0x011a:
            r8 = r17
            r13 = r18
            r17 = r3
            r2 = r11
            r12 = r32
            if (r0 != 0) goto L_0x0162
            int r0 = com.google.crypto.tink.shaded.protobuf.e.I(r12, r4, r9)
            int r1 = r9.f20783a
            com.google.crypto.tink.shaded.protobuf.x$e r4 = r15.p(r8)
            if (r4 == 0) goto L_0x0146
            boolean r4 = r4.isInRange(r1)
            if (r4 == 0) goto L_0x0138
            goto L_0x0146
        L_0x0138:
            com.google.crypto.tink.shaded.protobuf.g1 r2 = s(r31)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.n(r13, r1)
            goto L_0x02ac
        L_0x0146:
            r10.putInt(r14, r2, r1)
            goto L_0x02aa
        L_0x014b:
            r8 = r17
            r13 = r18
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r32
            if (r0 != r1) goto L_0x0162
            int r0 = com.google.crypto.tink.shaded.protobuf.e.b(r12, r4, r9)
            java.lang.Object r1 = r9.f20785c
            r10.putObject(r14, r2, r1)
            goto L_0x02aa
        L_0x0162:
            r11 = r4
            r18 = -1
            goto L_0x02b4
        L_0x0167:
            r8 = r17
            r13 = r18
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r32
            if (r0 != r1) goto L_0x0199
            com.google.crypto.tink.shaded.protobuf.z0 r0 = r15.r(r8)
            r11 = r34
            r18 = -1
            int r0 = com.google.crypto.tink.shaded.protobuf.e.p(r0, r12, r4, r11, r9)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x018a
            java.lang.Object r1 = r9.f20785c
            r10.putObject(r14, r2, r1)
            goto L_0x0205
        L_0x018a:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.f20785c
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.x.h(r1, r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0205
        L_0x0199:
            r11 = r34
            r18 = -1
            goto L_0x022f
        L_0x019f:
            r8 = r17
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r34
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != r1) goto L_0x022f
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r19 & r0
            if (r0 != 0) goto L_0x01bc
            int r0 = com.google.crypto.tink.shaded.protobuf.e.C(r12, r4, r9)
            goto L_0x01c0
        L_0x01bc:
            int r0 = com.google.crypto.tink.shaded.protobuf.e.F(r12, r4, r9)
        L_0x01c0:
            java.lang.Object r1 = r9.f20785c
            r10.putObject(r14, r2, r1)
            goto L_0x0205
        L_0x01c6:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r34
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != 0) goto L_0x022f
            int r0 = com.google.crypto.tink.shaded.protobuf.e.L(r12, r4, r9)
            long r4 = r9.f20784b
            r23 = 0
            int r1 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r1 == 0) goto L_0x01e5
            r1 = 1
            goto L_0x01e7
        L_0x01e5:
            r1 = r16
        L_0x01e7:
            com.google.crypto.tink.shaded.protobuf.j1.E(r14, r2, r1)
            goto L_0x0205
        L_0x01eb:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r34
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != r1) goto L_0x022f
            int r0 = com.google.crypto.tink.shaded.protobuf.e.h(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x0205:
            r6 = r6 | r20
            r2 = r8
            r3 = r13
            r1 = r17
            r13 = r11
            goto L_0x0272
        L_0x020e:
            r8 = r17
            r1 = 1
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r34
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != r1) goto L_0x022f
            long r21 = com.google.crypto.tink.shaded.protobuf.e.j(r12, r4)
            r0 = r10
            r1 = r31
            r11 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x02a8
        L_0x022f:
            r11 = r4
            goto L_0x02b4
        L_0x0232:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r4
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != 0) goto L_0x02b4
            int r0 = com.google.crypto.tink.shaded.protobuf.e.I(r12, r11, r9)
            int r1 = r9.f20783a
            r10.putInt(r14, r2, r1)
            goto L_0x02aa
        L_0x024d:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r4
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != 0) goto L_0x02b4
            int r11 = com.google.crypto.tink.shaded.protobuf.e.L(r12, r11, r9)
            long r4 = r9.f20784b
            r0 = r10
            r1 = r31
            r0.putLong(r1, r2, r4)
        L_0x0269:
            r6 = r6 | r20
            r2 = r8
            r0 = r11
            r3 = r13
            r1 = r17
            r13 = r34
        L_0x0272:
            r11 = r35
            goto L_0x0018
        L_0x0276:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r4
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != r1) goto L_0x02b4
            float r0 = com.google.crypto.tink.shaded.protobuf.e.l(r12, r11)
            com.google.crypto.tink.shaded.protobuf.j1.L(r14, r2, r0)
            int r0 = r11 + 4
            goto L_0x02aa
        L_0x0290:
            r8 = r17
            r1 = 1
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r4
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != r1) goto L_0x02b4
            double r0 = com.google.crypto.tink.shaded.protobuf.e.d(r12, r11)
            com.google.crypto.tink.shaded.protobuf.j1.K(r14, r2, r0)
        L_0x02a8:
            int r0 = r11 + 8
        L_0x02aa:
            r6 = r6 | r20
        L_0x02ac:
            r11 = r35
            r2 = r8
            r3 = r13
            r1 = r17
            goto L_0x0311
        L_0x02b4:
            r0 = r35
            r22 = r6
            r19 = r7
            r20 = r8
            r28 = r10
            r2 = r11
            r8 = r13
            goto L_0x03cd
        L_0x02c2:
            r5 = r2
            r17 = r3
            r2 = r11
            r13 = r18
            r18 = -1
            r12 = r32
            r11 = r4
            r1 = 27
            if (r8 != r1) goto L_0x0322
            r1 = 2
            if (r0 != r1) goto L_0x0315
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.crypto.tink.shaded.protobuf.x$i r0 = (com.google.crypto.tink.shaded.protobuf.x.i) r0
            boolean r1 = r0.h()
            if (r1 != 0) goto L_0x02f2
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02e9
            r1 = 10
            goto L_0x02eb
        L_0x02e9:
            int r1 = r1 * 2
        L_0x02eb:
            com.google.crypto.tink.shaded.protobuf.x$i r0 = r0.a(r1)
            r10.putObject(r14, r2, r0)
        L_0x02f2:
            r8 = r0
            com.google.crypto.tink.shaded.protobuf.z0 r0 = r15.r(r5)
            r1 = r13
            r2 = r32
            r3 = r11
            r4 = r34
            r20 = r5
            r5 = r8
            r22 = r6
            r6 = r36
            int r0 = com.google.crypto.tink.shaded.protobuf.e.q(r0, r1, r2, r3, r4, r5, r6)
            r11 = r35
            r3 = r13
            r1 = r17
            r2 = r20
            r6 = r22
        L_0x0311:
            r13 = r34
            goto L_0x0018
        L_0x0315:
            r20 = r5
            r22 = r6
            r19 = r7
            r28 = r10
            r15 = r11
            r18 = r13
            goto L_0x03a5
        L_0x0322:
            r20 = r5
            r22 = r6
            r1 = 49
            if (r8 > r1) goto L_0x0375
            r1 = r19
            long r5 = (long) r1
            r4 = r0
            r0 = r30
            r1 = r31
            r23 = r2
            r2 = r32
            r3 = r11
            r33 = r4
            r4 = r34
            r25 = r5
            r5 = r13
            r6 = r17
            r19 = r7
            r7 = r33
            r27 = r8
            r8 = r20
            r28 = r10
            r9 = r25
            r15 = r11
            r11 = r27
            r18 = r13
            r12 = r23
            r14 = r36
            int r0 = r0.b0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x03c8
        L_0x035b:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            r1 = r17
            r3 = r18
            r7 = r19
            r2 = r20
            r6 = r22
        L_0x0371:
            r10 = r28
            goto L_0x0018
        L_0x0375:
            r33 = r0
            r23 = r2
            r27 = r8
            r28 = r10
            r15 = r11
            r18 = r13
            r1 = r19
            r19 = r7
            r0 = 50
            r9 = r27
            if (r9 != r0) goto L_0x03ab
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x03a5
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r20
            r6 = r23
            r8 = r36
            int r0 = r0.X(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x03c8
            goto L_0x035b
        L_0x03a5:
            r0 = r35
            r2 = r15
            r8 = r18
            goto L_0x03cd
        L_0x03ab:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r18
            r6 = r17
            r10 = r23
            r12 = r20
            r13 = r36
            int r0 = r0.Y(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x03c8
            goto L_0x035b
        L_0x03c8:
            r2 = r0
            r8 = r18
            r0 = r35
        L_0x03cd:
            if (r8 != r0) goto L_0x03db
            if (r0 == 0) goto L_0x03db
            r9 = r30
            r10 = r0
            r0 = r2
            r3 = r8
            r7 = r19
            r6 = r22
            goto L_0x0429
        L_0x03db:
            r9 = r30
            r10 = r0
            boolean r0 = r9.f20877f
            r11 = r36
            if (r0 == 0) goto L_0x03fe
            com.google.crypto.tink.shaded.protobuf.o r0 = r11.f20786d
            com.google.crypto.tink.shaded.protobuf.o r1 = com.google.crypto.tink.shaded.protobuf.o.b()
            if (r0 == r1) goto L_0x03fe
            com.google.crypto.tink.shaded.protobuf.l0 r5 = r9.f20876e
            com.google.crypto.tink.shaded.protobuf.f1<?, ?> r6 = r9.f20886o
            r0 = r8
            r1 = r32
            r3 = r34
            r4 = r31
            r7 = r36
            int r0 = com.google.crypto.tink.shaded.protobuf.e.g(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x040d
        L_0x03fe:
            com.google.crypto.tink.shaded.protobuf.g1 r4 = s(r31)
            r0 = r8
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.google.crypto.tink.shaded.protobuf.e.G(r0, r1, r2, r3, r4, r5)
        L_0x040d:
            r14 = r31
            r12 = r32
            r13 = r34
            r3 = r8
            r15 = r9
            r9 = r11
            r1 = r17
            r7 = r19
            r2 = r20
            r6 = r22
            r11 = r10
            goto L_0x0371
        L_0x0421:
            r22 = r6
            r19 = r7
            r28 = r10
            r10 = r11
            r9 = r15
        L_0x0429:
            r1 = -1
            if (r7 == r1) goto L_0x0435
            long r1 = (long) r7
            r4 = r31
            r5 = r28
            r5.putInt(r4, r1, r6)
            goto L_0x0437
        L_0x0435:
            r4 = r31
        L_0x0437:
            r1 = 0
            int r2 = r9.f20882k
        L_0x043a:
            int r5 = r9.f20883l
            if (r2 >= r5) goto L_0x044d
            int[] r5 = r9.f20881j
            r5 = r5[r2]
            com.google.crypto.tink.shaded.protobuf.f1<?, ?> r6 = r9.f20886o
            java.lang.Object r1 = r9.m(r4, r5, r1, r6)
            com.google.crypto.tink.shaded.protobuf.g1 r1 = (com.google.crypto.tink.shaded.protobuf.g1) r1
            int r2 = r2 + 1
            goto L_0x043a
        L_0x044d:
            if (r1 == 0) goto L_0x0454
            com.google.crypto.tink.shaded.protobuf.f1<?, ?> r2 = r9.f20886o
            r2.o(r4, r1)
        L_0x0454:
            if (r10 != 0) goto L_0x0460
            r1 = r34
            if (r0 != r1) goto L_0x045b
            goto L_0x0466
        L_0x045b:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r0 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.g()
            throw r0
        L_0x0460:
            r1 = r34
            if (r0 > r1) goto L_0x0467
            if (r3 != r10) goto L_0x0467
        L_0x0466:
            return r0
        L_0x0467:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r0 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.g()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o0.Z(java.lang.Object, byte[], int, int, int, com.google.crypto.tink.shaded.protobuf.e$b):int");
    }

    public void a(T t10, T t11) {
        t11.getClass();
        for (int i10 = 0; i10 < this.f20872a.length; i10 += 3) {
            M(t10, t11, i10);
        }
        b1.G(this.f20886o, t10, t11);
        if (this.f20877f) {
            b1.E(this.f20887p, t10, t11);
        }
    }

    public void b(T t10) {
        int i10;
        int i11 = this.f20882k;
        while (true) {
            i10 = this.f20883l;
            if (i11 >= i10) {
                break;
            }
            long R = R(o0(this.f20881j[i11]));
            Object A = j1.A(t10, R);
            if (A != null) {
                j1.O(t10, R, this.f20888q.f(A));
            }
            i11++;
        }
        int length = this.f20881j.length;
        while (i10 < length) {
            this.f20885n.c(t10, (long) this.f20881j[i10]);
            i10++;
        }
        this.f20886o.j(t10);
        if (this.f20877f) {
            this.f20887p.f(t10);
        }
    }

    public final boolean c(T t10) {
        int i10;
        int i11 = -1;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f20882k; i13++) {
            int i14 = this.f20881j[i13];
            int Q = Q(i14);
            int o02 = o0(i14);
            if (!this.f20879h) {
                int i15 = this.f20872a[i14 + 2];
                int i16 = 1048575 & i15;
                i10 = 1 << (i15 >>> 20);
                if (i16 != i11) {
                    i12 = f20871s.getInt(t10, (long) i16);
                    i11 = i16;
                }
            } else {
                i10 = 0;
            }
            if (F(o02) && !z(t10, i14, i12, i10)) {
                return false;
            }
            int n02 = n0(o02);
            if (n02 != 9 && n02 != 17) {
                if (n02 != 27) {
                    if (n02 == 60 || n02 == 68) {
                        if (E(t10, Q, i14) && !A(t10, o02, r(i14))) {
                            return false;
                        }
                    } else if (n02 != 49) {
                        if (n02 == 50 && !C(t10, o02, i14)) {
                            return false;
                        }
                    }
                }
                if (!B(t10, o02, i14)) {
                    return false;
                }
            } else if (z(t10, i14, i12, i10) && !A(t10, o02, r(i14))) {
                return false;
            }
        }
        if (!this.f20877f || this.f20887p.c(t10).o()) {
            return true;
        }
        return false;
    }

    public int d(T t10) {
        return this.f20879h ? u(t10) : t(t10);
    }

    public void e(T t10, byte[] bArr, int i10, int i11, e.b bVar) throws IOException {
        if (this.f20879h) {
            a0(t10, bArr, i10, i11, bVar);
        } else {
            Z(t10, bArr, i10, i11, 0, bVar);
        }
    }

    public boolean equals(T t10, T t11) {
        int length = this.f20872a.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            if (!l(t10, t11, i10)) {
                return false;
            }
        }
        if (!this.f20886o.g(t10).equals(this.f20886o.g(t11))) {
            return false;
        }
        if (this.f20877f) {
            return this.f20887p.c(t10).equals(this.f20887p.c(t11));
        }
        return true;
    }

    public void f(T t10, y0 y0Var, o oVar) throws IOException {
        oVar.getClass();
        I(this.f20886o, this.f20887p, t10, y0Var, oVar);
    }

    public void g(T t10, Writer writer) throws IOException {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            r0(t10, writer);
        } else if (this.f20879h) {
            q0(t10, writer);
        } else {
            p0(t10, writer);
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
            int[] r0 = r8.f20872a
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022a
            int r3 = r8.o0(r1)
            int r4 = r8.Q(r1)
            long r5 = R(r3)
            int r3 = n0(r3)
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
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.j1.A(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0030:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = W(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.f(r3)
            goto L_0x0225
        L_0x0042:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = V(r9, r5)
            goto L_0x0225
        L_0x0050:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = W(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.f(r3)
            goto L_0x0225
        L_0x0062:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = V(r9, r5)
            goto L_0x0225
        L_0x0070:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = V(r9, r5)
            goto L_0x0225
        L_0x007e:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = V(r9, r5)
            goto L_0x0225
        L_0x008c:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.j1.A(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x009e:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.j1.A(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00b0:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.j1.A(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00c4:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            boolean r3 = S(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.c(r3)
            goto L_0x0225
        L_0x00d6:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = V(r9, r5)
            goto L_0x0225
        L_0x00e4:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = W(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.f(r3)
            goto L_0x0225
        L_0x00f6:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = V(r9, r5)
            goto L_0x0225
        L_0x0104:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = W(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.f(r3)
            goto L_0x0225
        L_0x0116:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = W(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.f(r3)
            goto L_0x0225
        L_0x0128:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            float r3 = U(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x013a:
            boolean r3 = r8.E(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            double r3 = T(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.f(r3)
            goto L_0x0225
        L_0x0150:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.j1.A(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x015c:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.j1.A(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0168:
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.j1.A(r9, r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
            goto L_0x01c1
        L_0x0173:
            int r2 = r2 * 53
            long r3 = com.google.crypto.tink.shaded.protobuf.j1.y(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.f(r3)
            goto L_0x0225
        L_0x017f:
            int r2 = r2 * 53
            int r3 = com.google.crypto.tink.shaded.protobuf.j1.x(r9, r5)
            goto L_0x0225
        L_0x0187:
            int r2 = r2 * 53
            long r3 = com.google.crypto.tink.shaded.protobuf.j1.y(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.f(r3)
            goto L_0x0225
        L_0x0193:
            int r2 = r2 * 53
            int r3 = com.google.crypto.tink.shaded.protobuf.j1.x(r9, r5)
            goto L_0x0225
        L_0x019b:
            int r2 = r2 * 53
            int r3 = com.google.crypto.tink.shaded.protobuf.j1.x(r9, r5)
            goto L_0x0225
        L_0x01a3:
            int r2 = r2 * 53
            int r3 = com.google.crypto.tink.shaded.protobuf.j1.x(r9, r5)
            goto L_0x0225
        L_0x01ab:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.j1.A(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01b7:
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.j1.A(r9, r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
        L_0x01c1:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0226
        L_0x01c5:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.j1.A(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01d2:
            int r2 = r2 * 53
            boolean r3 = com.google.crypto.tink.shaded.protobuf.j1.p(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.c(r3)
            goto L_0x0225
        L_0x01dd:
            int r2 = r2 * 53
            int r3 = com.google.crypto.tink.shaded.protobuf.j1.x(r9, r5)
            goto L_0x0225
        L_0x01e4:
            int r2 = r2 * 53
            long r3 = com.google.crypto.tink.shaded.protobuf.j1.y(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.f(r3)
            goto L_0x0225
        L_0x01ef:
            int r2 = r2 * 53
            int r3 = com.google.crypto.tink.shaded.protobuf.j1.x(r9, r5)
            goto L_0x0225
        L_0x01f6:
            int r2 = r2 * 53
            long r3 = com.google.crypto.tink.shaded.protobuf.j1.y(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.f(r3)
            goto L_0x0225
        L_0x0201:
            int r2 = r2 * 53
            long r3 = com.google.crypto.tink.shaded.protobuf.j1.y(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.f(r3)
            goto L_0x0225
        L_0x020c:
            int r2 = r2 * 53
            float r3 = com.google.crypto.tink.shaded.protobuf.j1.w(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x0217:
            int r2 = r2 * 53
            double r3 = com.google.crypto.tink.shaded.protobuf.j1.v(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.crypto.tink.shaded.protobuf.x.f(r3)
        L_0x0225:
            int r2 = r2 + r3
        L_0x0226:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022a:
            int r2 = r2 * 53
            com.google.crypto.tink.shaded.protobuf.f1<?, ?> r0 = r8.f20886o
            java.lang.Object r0 = r0.g(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f20877f
            if (r0 == 0) goto L_0x0248
            int r2 = r2 * 53
            com.google.crypto.tink.shaded.protobuf.p<?> r0 = r8.f20887p
            com.google.crypto.tink.shaded.protobuf.t r9 = r0.c(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x0248:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.o0.hashCode(java.lang.Object):int");
    }

    public T newInstance() {
        return this.f20884m.a(this.f20876e);
    }
}
