package me;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import java.lang.reflect.Method;
import oe.d;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private static final int f41277a = Process.myUid();

    /* renamed from: b  reason: collision with root package name */
    private static final Method f41278b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f41279c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f41280d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f41281e;

    /* renamed from: f  reason: collision with root package name */
    private static final Method f41282f;

    /* renamed from: g  reason: collision with root package name */
    private static final Method f41283g;

    /* renamed from: h  reason: collision with root package name */
    private static final Method f41284h;

    /* renamed from: i  reason: collision with root package name */
    private static final Method f41285i;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c A[SYNTHETIC, Splitter:B:23:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a6  */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "add"
            int r2 = android.os.Process.myUid()
            f41277a = r2
            r2 = 1
            r3 = 0
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x001a }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x001a }
            r5[r3] = r6     // Catch:{ Exception -> 0x001a }
            java.lang.Class<android.os.WorkSource> r6 = android.os.WorkSource.class
            java.lang.reflect.Method r5 = r6.getMethod(r1, r5)     // Catch:{ Exception -> 0x001a }
            goto L_0x001b
        L_0x001a:
            r5 = r4
        L_0x001b:
            f41278b = r5
            boolean r5 = me.p.c()
            r6 = 2
            if (r5 == 0) goto L_0x0033
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x0033 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0033 }
            r5[r3] = r7     // Catch:{ Exception -> 0x0033 }
            r5[r2] = r0     // Catch:{ Exception -> 0x0033 }
            java.lang.Class<android.os.WorkSource> r7 = android.os.WorkSource.class
            java.lang.reflect.Method r1 = r7.getMethod(r1, r5)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0034
        L_0x0033:
            r1 = r4
        L_0x0034:
            f41279c = r1
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "size"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0041 }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0042
        L_0x0041:
            r1 = r4
        L_0x0042:
            f41280d = r1
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0053 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0053 }
            r1[r3] = r5     // Catch:{ Exception -> 0x0053 }
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.String r7 = "get"
            java.lang.reflect.Method r1 = r5.getMethod(r7, r1)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0054
        L_0x0053:
            r1 = r4
        L_0x0054:
            f41281e = r1
            boolean r1 = me.p.c()
            if (r1 == 0) goto L_0x006b
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x006b }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x006b }
            r1[r3] = r5     // Catch:{ Exception -> 0x006b }
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.String r7 = "getName"
            java.lang.reflect.Method r1 = r5.getMethod(r7, r1)     // Catch:{ Exception -> 0x006b }
            goto L_0x006c
        L_0x006b:
            r1 = r4
        L_0x006c:
            f41282f = r1
            boolean r1 = me.p.i()
            if (r1 == 0) goto L_0x007f
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "createWorkChain"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x007f }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch:{ Exception -> 0x007f }
            goto L_0x0080
        L_0x007f:
            r1 = r4
        L_0x0080:
            f41283g = r1
            boolean r1 = me.p.i()
            if (r1 == 0) goto L_0x009d
            java.lang.String r1 = "android.os.WorkSource$WorkChain"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x009d }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x009d }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x009d }
            r5[r3] = r6     // Catch:{ Exception -> 0x009d }
            r5[r2] = r0     // Catch:{ Exception -> 0x009d }
            java.lang.String r0 = "addNode"
            java.lang.reflect.Method r0 = r1.getMethod(r0, r5)     // Catch:{ Exception -> 0x009d }
            goto L_0x009e
        L_0x009d:
            r0 = r4
        L_0x009e:
            f41284h = r0
            boolean r0 = me.p.i()
            if (r0 == 0) goto L_0x00b3
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r1 = "isEmpty"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00b3 }
            java.lang.reflect.Method r4 = r0.getMethod(r1, r3)     // Catch:{ Exception -> 0x00b3 }
            r4.setAccessible(r2)     // Catch:{ Exception -> 0x00b3 }
        L_0x00b3:
            f41285i = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: me.t.<clinit>():void");
    }

    public static void a(@NonNull WorkSource workSource, int i10, @NonNull String str) {
        Method method = f41279c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i10), str});
            } catch (Exception e10) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
            }
        } else {
            Method method2 = f41278b;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i10)});
                } catch (Exception e11) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
                }
            }
        }
    }

    @NonNull
    public static WorkSource b(@NonNull Context context, @NonNull String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo c10 = d.a(context).c(str, 0);
                if (c10 == null) {
                    "Could not get applicationInfo from package: ".concat(str);
                    return null;
                }
                int i10 = c10.uid;
                WorkSource workSource = new WorkSource();
                a(workSource, i10, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                "Could not find package: ".concat(str);
            }
        }
        return null;
    }

    public static boolean c(@NonNull Context context) {
        if (context == null || context.getPackageManager() == null || d.a(context).b("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static boolean d(@NonNull WorkSource workSource) {
        Method method = f41285i;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                p.k(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception unused) {
            }
        }
        if (e(workSource) == 0) {
            return true;
        }
        return false;
    }

    public static int e(@NonNull WorkSource workSource) {
        Method method = f41280d;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                p.k(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e10) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
            }
        }
        return 0;
    }
}
