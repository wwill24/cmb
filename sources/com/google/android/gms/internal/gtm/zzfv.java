package com.google.android.gms.internal.gtm;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.Method;

@TargetApi(24)
public final class zzfv {
    private static final Method zza;
    private static final Method zzb;

    static {
        Method method;
        Class<String> cls = String.class;
        Method method2 = null;
        try {
            method = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", new Class[]{JobInfo.class, cls, Integer.TYPE, cls});
        } catch (NoSuchMethodException unused) {
            Log.isLoggable("JobSchedulerCompat", 6);
            method = null;
        }
        zza = method;
        try {
            method2 = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
        } catch (NoSuchMethodException unused2) {
            Log.isLoggable("JobSchedulerCompat", 6);
        }
        zzb = method2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.content.Context r5, android.app.job.JobInfo r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r7 = "jobscheduler"
            java.lang.Object r7 = r5.getSystemService(r7)
            android.app.job.JobScheduler r7 = (android.app.job.JobScheduler) r7
            r7.getClass()
            java.lang.reflect.Method r8 = zza
            if (r8 == 0) goto L_0x0061
            java.lang.String r8 = "android.permission.UPDATE_DEVICE_STATS"
            int r5 = r5.checkSelfPermission(r8)
            if (r5 == 0) goto L_0x0018
            goto L_0x0061
        L_0x0018:
            java.lang.reflect.Method r5 = zzb
            r8 = 0
            if (r5 == 0) goto L_0x0034
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x002e }
            java.lang.Object r5 = r5.invoke(r0, r1)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x002e }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x002e }
            if (r5 == 0) goto L_0x0034
            int r5 = r5.intValue()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x002e }
            goto L_0x0035
        L_0x002e:
            r5 = 6
            java.lang.String r0 = "JobSchedulerCompat"
            android.util.Log.isLoggable(r0, r5)
        L_0x0034:
            r5 = r8
        L_0x0035:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r1 = "DispatchAlarm"
            java.lang.reflect.Method r2 = zza
            if (r2 == 0) goto L_0x005c
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005c }
            r3[r8] = r6     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005c }
            r4 = 1
            r3[r4] = r0     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005c }
            r0 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005c }
            r3[r0] = r5     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005c }
            r5 = 3
            r3[r5] = r1     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005c }
            java.lang.Object r5 = r2.invoke(r7, r3)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005c }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005c }
            if (r5 == 0) goto L_0x0060
            int r8 = r5.intValue()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005c }
            goto L_0x0060
        L_0x005c:
            int r8 = r7.schedule(r6)
        L_0x0060:
            return r8
        L_0x0061:
            int r5 = r7.schedule(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfv.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
