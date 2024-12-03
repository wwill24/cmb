package oe;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import me.p;

public class c {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    protected final Context f41334a;

    public c(@NonNull Context context) {
        this.f41334a = context;
    }

    public int a(@NonNull String str) {
        return this.f41334a.checkCallingOrSelfPermission(str);
    }

    public int b(@NonNull String str, @NonNull String str2) {
        return this.f41334a.getPackageManager().checkPermission(str, str2);
    }

    @NonNull
    public ApplicationInfo c(@NonNull String str, int i10) throws PackageManager.NameNotFoundException {
        return this.f41334a.getPackageManager().getApplicationInfo(str, i10);
    }

    @NonNull
    public CharSequence d(@NonNull String str) throws PackageManager.NameNotFoundException {
        return this.f41334a.getPackageManager().getApplicationLabel(this.f41334a.getPackageManager().getApplicationInfo(str, 0));
    }

    @NonNull
    public PackageInfo e(@NonNull String str, int i10) throws PackageManager.NameNotFoundException {
        return this.f41334a.getPackageManager().getPackageInfo(str, i10);
    }

    public boolean f() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return a.a(this.f41334a);
        }
        if (!p.h() || (nameForUid = this.f41334a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f41334a.getPackageManager().isInstantApp(nameForUid);
    }

    @TargetApi(19)
    public final boolean g(int i10, @NonNull String str) {
        if (p.d()) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) this.f41334a.getSystemService("appops");
                if (appOpsManager != null) {
                    appOpsManager.checkPackage(i10, str);
                    return true;
                }
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            } catch (SecurityException unused) {
                return false;
            }
        } else {
            String[] packagesForUid = this.f41334a.getPackageManager().getPackagesForUid(i10);
            if (!(str == null || packagesForUid == null)) {
                for (String equals : packagesForUid) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
