package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;

public class ServiceStarter {
    static final String ACTION_MESSAGING_EVENT = "com.google.firebase.MESSAGING_EVENT";
    static final int ERROR_ILLEGAL_STATE_EXCEPTION = 402;
    static final int ERROR_ILLEGAL_STATE_EXCEPTION_FALLBACK_TO_BIND = 403;
    static final int ERROR_NOT_FOUND = 404;
    static final int ERROR_SECURITY_EXCEPTION = 401;
    public static final int ERROR_UNKNOWN = 500;
    private static final String EXTRA_WRAPPED_INTENT = "wrapped_intent";
    private static final String PERMISSIONS_MISSING_HINT = "this should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    public static final int SUCCESS = -1;
    private static ServiceStarter instance;
    private String firebaseMessagingServiceClassName = null;
    private Boolean hasAccessNetworkStatePermission = null;
    private Boolean hasWakeLockPermission = null;
    private final Queue<Intent> messagingEvents = new ArrayDeque();

    private ServiceStarter() {
    }

    private int doStartService(Context context, Intent intent) {
        ComponentName componentName;
        String resolveServiceClassName = resolveServiceClassName(context, intent);
        if (resolveServiceClassName != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Restricting intent to a specific service: ");
                sb2.append(resolveServiceClassName);
            }
            intent.setClassName(context.getPackageName(), resolveServiceClassName);
        }
        try {
            if (hasWakeLockPermission(context)) {
                componentName = WakeLockHolder.startWakefulService(context, intent);
            } else {
                componentName = context.startService(intent);
            }
            if (componentName == null) {
                return 404;
            }
            return -1;
        } catch (SecurityException unused) {
            return 401;
        } catch (IllegalStateException e10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to start service while in background: ");
            sb3.append(e10);
            return ERROR_ILLEGAL_STATE_EXCEPTION;
        }
    }

    static synchronized ServiceStarter getInstance() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            if (instance == null) {
                instance = new ServiceStarter();
            }
            serviceStarter = instance;
        }
        return serviceStarter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006d, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String resolveServiceClassName(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.firebaseMessagingServiceClassName     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return r0
        L_0x0007:
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch:{ all -> 0x006e }
            r1 = 0
            android.content.pm.ResolveInfo r5 = r0.resolveService(r5, r1)     // Catch:{ all -> 0x006e }
            r0 = 0
            if (r5 == 0) goto L_0x006c
            android.content.pm.ServiceInfo r5 = r5.serviceInfo     // Catch:{ all -> 0x006e }
            if (r5 != 0) goto L_0x0018
            goto L_0x006c
        L_0x0018:
            java.lang.String r1 = r4.getPackageName()     // Catch:{ all -> 0x006e }
            java.lang.String r2 = r5.packageName     // Catch:{ all -> 0x006e }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x0051
            java.lang.String r1 = r5.name     // Catch:{ all -> 0x006e }
            if (r1 != 0) goto L_0x0029
            goto L_0x0051
        L_0x0029:
            java.lang.String r0 = "."
            boolean r0 = r1.startsWith(r0)     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x0049
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            r0.<init>()     // Catch:{ all -> 0x006e }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x006e }
            r0.append(r4)     // Catch:{ all -> 0x006e }
            java.lang.String r4 = r5.name     // Catch:{ all -> 0x006e }
            r0.append(r4)     // Catch:{ all -> 0x006e }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x006e }
            r3.firebaseMessagingServiceClassName = r4     // Catch:{ all -> 0x006e }
            goto L_0x004d
        L_0x0049:
            java.lang.String r4 = r5.name     // Catch:{ all -> 0x006e }
            r3.firebaseMessagingServiceClassName = r4     // Catch:{ all -> 0x006e }
        L_0x004d:
            java.lang.String r4 = r3.firebaseMessagingServiceClassName     // Catch:{ all -> 0x006e }
            monitor-exit(r3)
            return r4
        L_0x0051:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            r4.<init>()     // Catch:{ all -> 0x006e }
            java.lang.String r1 = "Error resolving target intent service, skipping classname enforcement. Resolved service was: "
            r4.append(r1)     // Catch:{ all -> 0x006e }
            java.lang.String r1 = r5.packageName     // Catch:{ all -> 0x006e }
            r4.append(r1)     // Catch:{ all -> 0x006e }
            java.lang.String r1 = "/"
            r4.append(r1)     // Catch:{ all -> 0x006e }
            java.lang.String r5 = r5.name     // Catch:{ all -> 0x006e }
            r4.append(r5)     // Catch:{ all -> 0x006e }
            monitor-exit(r3)
            return r0
        L_0x006c:
            monitor-exit(r3)
            return r0
        L_0x006e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.ServiceStarter.resolveServiceClassName(android.content.Context, android.content.Intent):java.lang.String");
    }

    public static void setForTesting(ServiceStarter serviceStarter) {
        instance = serviceStarter;
    }

    /* access modifiers changed from: package-private */
    public Intent getMessagingEvent() {
        return this.messagingEvents.poll();
    }

    /* access modifiers changed from: package-private */
    public boolean hasAccessNetworkStatePermission(Context context) {
        boolean z10;
        if (this.hasAccessNetworkStatePermission == null) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.hasAccessNetworkStatePermission = Boolean.valueOf(z10);
        }
        if (!this.hasWakeLockPermission.booleanValue()) {
            Log.isLoggable(Constants.TAG, 3);
        }
        return this.hasAccessNetworkStatePermission.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean hasWakeLockPermission(Context context) {
        boolean z10;
        if (this.hasWakeLockPermission == null) {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.hasWakeLockPermission = Boolean.valueOf(z10);
        }
        if (!this.hasWakeLockPermission.booleanValue()) {
            Log.isLoggable(Constants.TAG, 3);
        }
        return this.hasWakeLockPermission.booleanValue();
    }

    public int startMessagingService(Context context, Intent intent) {
        Log.isLoggable(Constants.TAG, 3);
        this.messagingEvents.offer(intent);
        Intent intent2 = new Intent(ACTION_MESSAGING_EVENT);
        intent2.setPackage(context.getPackageName());
        return doStartService(context, intent2);
    }
}
