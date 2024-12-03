package com.google.android.gms.measurement.internal;

import android.util.Log;
import com.facebook.internal.security.CertificateUtil;

final class n3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f40051a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f40052b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f40053c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Object f40054d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Object f40055e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ q3 f40056f;

    n3(q3 q3Var, int i10, String str, Object obj, Object obj2, Object obj3) {
        this.f40056f = q3Var;
        this.f40051a = i10;
        this.f40052b = str;
        this.f40053c = obj;
        this.f40054d = obj2;
        this.f40055e = obj3;
    }

    public final void run() {
        e4 F = this.f40056f.f40059a.F();
        if (F.n()) {
            q3 q3Var = this.f40056f;
            if (q3Var.f40159c == 0) {
                if (q3Var.f40059a.z().H()) {
                    q3 q3Var2 = this.f40056f;
                    q3Var2.f40059a.b();
                    q3Var2.f40159c = 'C';
                } else {
                    q3 q3Var3 = this.f40056f;
                    q3Var3.f40059a.b();
                    q3Var3.f40159c = 'c';
                }
            }
            q3 q3Var4 = this.f40056f;
            if (q3Var4.f40160d < 0) {
                q3Var4.f40059a.z().q();
                q3Var4.f40160d = 79000;
            }
            char charAt = "01VDIWEA?".charAt(this.f40051a);
            q3 q3Var5 = this.f40056f;
            String str = "2" + charAt + q3Var5.f40159c + q3Var5.f40160d + CertificateUtil.DELIMITER + q3.A(true, this.f40052b, this.f40053c, this.f40054d, this.f40055e);
            if (str.length() > 1024) {
                str = this.f40052b.substring(0, 1024);
            }
            c4 c4Var = F.f39739d;
            if (c4Var != null) {
                c4Var.b(str, 1);
                return;
            }
            return;
        }
        Log.println(6, this.f40056f.D(), "Persisted config not initialized. Not logging error/warn");
    }
}
