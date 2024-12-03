package oe;

import android.content.Context;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f41332a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f41333b;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:17|18|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(@androidx.annotation.NonNull android.content.Context r4) {
        /*
            java.lang.Class<oe.a> r0 = oe.a.class
            monitor-enter(r0)
            android.content.Context r1 = r4.getApplicationContext()     // Catch:{ all -> 0x004c }
            android.content.Context r2 = f41332a     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x0018
            java.lang.Boolean r3 = f41333b     // Catch:{ all -> 0x004c }
            if (r3 == 0) goto L_0x0018
            if (r2 == r1) goto L_0x0012
            goto L_0x0018
        L_0x0012:
            boolean r4 = r3.booleanValue()     // Catch:{ all -> 0x004c }
            monitor-exit(r0)
            return r4
        L_0x0018:
            r2 = 0
            f41333b = r2     // Catch:{ all -> 0x004c }
            boolean r2 = me.p.h()     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x0030
            android.content.pm.PackageManager r4 = r1.getPackageManager()     // Catch:{ all -> 0x004c }
            boolean r4 = r4.isInstantApp()     // Catch:{ all -> 0x004c }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x004c }
            f41333b = r4     // Catch:{ all -> 0x004c }
            goto L_0x0042
        L_0x0030:
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x003e }
            java.lang.String r2 = "com.google.android.instantapps.supervisor.InstantAppsRuntime"
            r4.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x003e }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ ClassNotFoundException -> 0x003e }
            f41333b = r4     // Catch:{ ClassNotFoundException -> 0x003e }
            goto L_0x0042
        L_0x003e:
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x004c }
            f41333b = r4     // Catch:{ all -> 0x004c }
        L_0x0042:
            f41332a = r1     // Catch:{ all -> 0x004c }
            java.lang.Boolean r4 = f41333b     // Catch:{ all -> 0x004c }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x004c }
            monitor-exit(r0)
            return r4
        L_0x004c:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: oe.a.a(android.content.Context):boolean");
    }
}
