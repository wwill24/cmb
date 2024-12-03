package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static f f38896c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f38897a;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f38898b;

    public f(@NonNull Context context) {
        this.f38897a = context.getApplicationContext();
    }

    @NonNull
    public static f a(@NonNull Context context) {
        p.k(context);
        synchronized (f.class) {
            if (f38896c == null) {
                v.d(context);
                f38896c = new f(context);
            }
        }
        return f38896c;
    }

    static final r d(PackageInfo packageInfo, r... rVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        s sVar = new s(packageInfo.signatures[0].toByteArray());
        for (int i10 = 0; i10 < rVarArr.length; i10++) {
            if (rVarArr[i10].equals(sVar)) {
                return rVarArr[i10];
            }
        }
        return null;
    }

    public static final boolean e(@NonNull PackageInfo packageInfo, boolean z10) {
        r rVar;
        if (z10 && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null || (applicationInfo.flags & 129) == 0) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z10) {
                rVar = d(packageInfo, u.f39187a);
            } else {
                rVar = d(packageInfo, u.f39187a[0]);
            }
            if (rVar != null) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final c0 f(String str, boolean z10, boolean z11) {
        c0 c0Var;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return c0.c("null pkg");
        }
        if (str.equals(this.f38898b)) {
            return c0.b();
        }
        if (v.e()) {
            c0Var = v.b(str, e.honorsDebugCertificates(this.f38897a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f38897a.getPackageManager().getPackageInfo(str, 64);
                boolean honorsDebugCertificates = e.honorsDebugCertificates(this.f38897a);
                if (packageInfo == null) {
                    c0Var = c0.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        c0Var = c0.c("single cert required");
                    } else {
                        s sVar = new s(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        c0 a10 = v.a(str2, sVar, honorsDebugCertificates, false);
                        if (!a10.f38870a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !v.a(str2, sVar, false, true).f38870a) {
                            c0Var = a10;
                        } else {
                            c0Var = c0.c("debuggable release cert app rejected");
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e10) {
                return c0.d("no pkg ".concat(str), e10);
            }
        }
        if (c0Var.f38870a) {
            this.f38898b = str;
        }
        return c0Var;
    }

    public boolean b(@NonNull PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (!e(packageInfo, true) || !e.honorsDebugCertificates(this.f38897a)) {
            return false;
        }
        return true;
    }

    public boolean c(int i10) {
        c0 c0Var;
        int length;
        String[] packagesForUid = this.f38897a.getPackageManager().getPackagesForUid(i10);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            c0Var = null;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    p.k(c0Var);
                    break;
                }
                c0Var = f(packagesForUid[i11], false, false);
                if (c0Var.f38870a) {
                    break;
                }
                i11++;
            }
        } else {
            c0Var = c0.c("no pkgs");
        }
        c0Var.e();
        return c0Var.f38870a;
    }
}
