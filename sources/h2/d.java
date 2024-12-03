package h2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.e0;
import androidx.work.impl.o;
import androidx.work.impl.u;
import androidx.work.impl.x;
import b2.f;
import b2.h;
import java.util.List;

public class d implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static final String f15281c = f.i("EnqueueRunnable");

    /* renamed from: a  reason: collision with root package name */
    private final x f15282a;

    /* renamed from: b  reason: collision with root package name */
    private final o f15283b;

    public d(@NonNull x xVar) {
        this(xVar, new o());
    }

    private static boolean b(@NonNull x xVar) {
        boolean c10 = c(xVar.g(), xVar.f(), (String[]) x.l(xVar).toArray(new String[0]), xVar.d(), xVar.b());
        xVar.k();
        return c10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(androidx.work.impl.e0 r18, @androidx.annotation.NonNull java.util.List<? extends b2.n> r19, java.lang.String[] r20, java.lang.String r21, androidx.work.ExistingWorkPolicy r22) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            long r3 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r5 = r18.o()
            r6 = 1
            r7 = 0
            if (r0 == 0) goto L_0x0017
            int r8 = r0.length
            if (r8 <= 0) goto L_0x0017
            r8 = r6
            goto L_0x0018
        L_0x0017:
            r8 = r7
        L_0x0018:
            if (r8 == 0) goto L_0x0065
            int r9 = r0.length
            r11 = r6
            r10 = r7
            r12 = r10
            r13 = r12
        L_0x001f:
            if (r10 >= r9) goto L_0x0068
            r14 = r0[r10]
            g2.v r15 = r5.K()
            g2.u r15 = r15.h(r14)
            if (r15 != 0) goto L_0x004d
            b2.f r0 = b2.f.e()
            java.lang.String r1 = f15281c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Prerequisite "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r3 = " doesn't exist; not enqueuing"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.c(r1, r2)
            return r7
        L_0x004d:
            androidx.work.WorkInfo$State r14 = r15.f15078b
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r14 != r15) goto L_0x0055
            r15 = r6
            goto L_0x0056
        L_0x0055:
            r15 = r7
        L_0x0056:
            r11 = r11 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r14 != r15) goto L_0x005d
            r13 = r6
            goto L_0x0062
        L_0x005d:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r14 != r15) goto L_0x0062
            r12 = r6
        L_0x0062:
            int r10 = r10 + 1
            goto L_0x001f
        L_0x0065:
            r11 = r6
            r12 = r7
            r13 = r12
        L_0x0068:
            boolean r9 = android.text.TextUtils.isEmpty(r21)
            r9 = r9 ^ r6
            if (r9 == 0) goto L_0x0073
            if (r8 != 0) goto L_0x0073
            r10 = r6
            goto L_0x0074
        L_0x0073:
            r10 = r7
        L_0x0074:
            if (r10 == 0) goto L_0x0152
            g2.v r10 = r5.K()
            java.util.List r10 = r10.n(r1)
            boolean r14 = r10.isEmpty()
            if (r14 != 0) goto L_0x0152
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND
            if (r2 == r14) goto L_0x00cf
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r14) goto L_0x008d
            goto L_0x00cf
        L_0x008d:
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.KEEP
            if (r2 != r14) goto L_0x00ac
            java.util.Iterator r2 = r10.iterator()
        L_0x0095:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x00ac
            java.lang.Object r14 = r2.next()
            g2.u$b r14 = (g2.u.b) r14
            androidx.work.WorkInfo$State r14 = r14.f15098b
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.ENQUEUED
            if (r14 == r15) goto L_0x00ab
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.RUNNING
            if (r14 != r15) goto L_0x0095
        L_0x00ab:
            return r7
        L_0x00ac:
            r14 = r18
            h2.c r2 = h2.c.c(r1, r14, r7)
            r2.run()
            g2.v r2 = r5.K()
            java.util.Iterator r10 = r10.iterator()
        L_0x00bd:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x0155
            java.lang.Object r15 = r10.next()
            g2.u$b r15 = (g2.u.b) r15
            java.lang.String r15 = r15.f15097a
            r2.a(r15)
            goto L_0x00bd
        L_0x00cf:
            r14 = r18
            g2.b r8 = r5.F()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00de:
            boolean r16 = r10.hasNext()
            if (r16 == 0) goto L_0x0119
            java.lang.Object r16 = r10.next()
            r6 = r16
            g2.u$b r6 = (g2.u.b) r6
            java.lang.String r7 = r6.f15097a
            boolean r7 = r8.d(r7)
            if (r7 != 0) goto L_0x0112
            androidx.work.WorkInfo$State r7 = r6.f15098b
            r17 = r8
            androidx.work.WorkInfo$State r8 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r7 != r8) goto L_0x00fe
            r8 = 1
            goto L_0x00ff
        L_0x00fe:
            r8 = 0
        L_0x00ff:
            r8 = r8 & r11
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.FAILED
            if (r7 != r11) goto L_0x0106
            r13 = 1
            goto L_0x010b
        L_0x0106:
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.CANCELLED
            if (r7 != r11) goto L_0x010b
            r12 = 1
        L_0x010b:
            java.lang.String r6 = r6.f15097a
            r15.add(r6)
            r11 = r8
            goto L_0x0114
        L_0x0112:
            r17 = r8
        L_0x0114:
            r8 = r17
            r6 = 1
            r7 = 0
            goto L_0x00de
        L_0x0119:
            androidx.work.ExistingWorkPolicy r6 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r6) goto L_0x0145
            if (r12 != 0) goto L_0x0121
            if (r13 == 0) goto L_0x0145
        L_0x0121:
            g2.v r2 = r5.K()
            java.util.List r6 = r2.n(r1)
            java.util.Iterator r6 = r6.iterator()
        L_0x012d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x013f
            java.lang.Object r7 = r6.next()
            g2.u$b r7 = (g2.u.b) r7
            java.lang.String r7 = r7.f15097a
            r2.a(r7)
            goto L_0x012d
        L_0x013f:
            java.util.List r15 = java.util.Collections.emptyList()
            r12 = 0
            r13 = 0
        L_0x0145:
            java.lang.Object[] r0 = r15.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            int r2 = r0.length
            if (r2 <= 0) goto L_0x0150
            r8 = 1
            goto L_0x0154
        L_0x0150:
            r8 = 0
            goto L_0x0154
        L_0x0152:
            r14 = r18
        L_0x0154:
            r6 = 0
        L_0x0155:
            java.util.Iterator r2 = r19.iterator()
        L_0x0159:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x01e6
            java.lang.Object r7 = r2.next()
            b2.n r7 = (b2.n) r7
            g2.u r10 = r7.d()
            if (r8 == 0) goto L_0x0180
            if (r11 != 0) goto L_0x0180
            if (r13 == 0) goto L_0x0174
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            r10.f15078b = r15
            goto L_0x0182
        L_0x0174:
            if (r12 == 0) goto L_0x017b
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            r10.f15078b = r15
            goto L_0x0182
        L_0x017b:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.BLOCKED
            r10.f15078b = r15
            goto L_0x0182
        L_0x0180:
            r10.f15090n = r3
        L_0x0182:
            androidx.work.WorkInfo$State r15 = r10.f15078b
            r19 = r2
            androidx.work.WorkInfo$State r2 = androidx.work.WorkInfo.State.ENQUEUED
            if (r15 != r2) goto L_0x018b
            r6 = 1
        L_0x018b:
            g2.v r2 = r5.K()
            java.util.List r15 = r18.m()
            g2.u r10 = h2.e.b(r15, r10)
            r2.f(r10)
            if (r8 == 0) goto L_0x01bd
            int r2 = r0.length
            r10 = 0
        L_0x019e:
            if (r10 >= r2) goto L_0x01bd
            r15 = r0[r10]
            r17 = r0
            g2.a r0 = new g2.a
            r20 = r2
            java.lang.String r2 = r7.b()
            r0.<init>(r2, r15)
            g2.b r2 = r5.F()
            r2.b(r0)
            int r10 = r10 + 1
            r2 = r20
            r0 = r17
            goto L_0x019e
        L_0x01bd:
            r17 = r0
            g2.z r0 = r5.L()
            java.lang.String r2 = r7.b()
            java.util.Set r10 = r7.c()
            r0.c(r2, r10)
            if (r9 == 0) goto L_0x01e0
            g2.o r0 = r5.I()
            g2.n r2 = new g2.n
            java.lang.String r7 = r7.b()
            r2.<init>(r1, r7)
            r0.a(r2)
        L_0x01e0:
            r2 = r19
            r0 = r17
            goto L_0x0159
        L_0x01e6:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.d.c(androidx.work.impl.e0, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static boolean e(@NonNull x xVar) {
        List<x> e10 = xVar.e();
        boolean z10 = false;
        if (e10 != null) {
            for (x next : e10) {
                if (!next.j()) {
                    z10 |= e(next);
                } else {
                    f e11 = f.e();
                    String str = f15281c;
                    e11.k(str, "Already enqueued work ids (" + TextUtils.join(", ", next.c()) + ")");
                }
            }
        }
        return b(xVar) | z10;
    }

    public boolean a() {
        WorkDatabase o10 = this.f15282a.g().o();
        o10.e();
        try {
            boolean e10 = e(this.f15282a);
            o10.C();
            return e10;
        } finally {
            o10.j();
        }
    }

    @NonNull
    public h d() {
        return this.f15283b;
    }

    public void f() {
        e0 g10 = this.f15282a.g();
        u.b(g10.h(), g10.o(), g10.m());
    }

    public void run() {
        try {
            if (!this.f15282a.h()) {
                if (a()) {
                    n.a(this.f15282a.g().g(), RescheduleReceiver.class, true);
                    f();
                }
                this.f15283b.a(h.f7743a);
                return;
            }
            throw new IllegalStateException("WorkContinuation has cycles (" + this.f15282a + ")");
        } catch (Throwable th2) {
            this.f15283b.a(new h.b.a(th2));
        }
    }

    public d(@NonNull x xVar, @NonNull o oVar) {
        this.f15282a = xVar;
        this.f15283b = oVar;
    }
}
