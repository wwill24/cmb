package com.appsflyer.internal;

import android.content.pm.PackageManager;
import android.os.Build;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.PropertyUtils;

public final class AFb1uSDK {
    private static int AFLogger$LogLevel = 1;
    private static boolean AFVersionDeclaration = true;
    private static int afErrorLogForExcManagerOnly = 29;
    private static char[] afRDLog = {127, 143, '~', 139, 129};
    private static boolean afWarnLog = true;
    private static int getLevel;
    private static AFb1uSDK valueOf;
    private boolean AFInAppEventParameterName = true;
    @NonNull
    private final Map<String, Object> AFInAppEventType = new HashMap();
    private List<String> AFKeystoreWrapper = new ArrayList();
    private String AFLogger = "-1";
    private int afDebugLog = 0;
    private boolean afErrorLog = false;
    private boolean afInfoLog = (true ^ AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false));
    private final String values = "yyyy-MM-dd HH:mm:ssZ";

    private AFb1uSDK() {
    }

    @Deprecated
    public static AFb1uSDK AFInAppEventType() {
        int i10 = getLevel + 15;
        AFLogger$LogLevel = i10 % 128;
        int i11 = i10 % 2;
        if (valueOf == null) {
            valueOf = new AFb1uSDK();
        }
        AFb1uSDK aFb1uSDK = valueOf;
        int i12 = getLevel + 69;
        AFLogger$LogLevel = i12 % 128;
        if ((i12 % 2 == 0 ? '$' : '4') == '4') {
            return aFb1uSDK;
        }
        throw null;
    }

    private boolean AFLogger() {
        int i10 = getLevel + 71;
        int i11 = i10 % 128;
        AFLogger$LogLevel = i11;
        int i12 = i10 % 2;
        if ((this.afInfoLog ? 'V' : 31) == 'V') {
            int i13 = i11 + 97;
            getLevel = i13 % 128;
            int i14 = i13 % 2;
            if (!(this.AFInAppEventParameterName)) {
                int i15 = i11 + 119;
                getLevel = i15 % 128;
                int i16 = i15 % 2;
                if (this.afErrorLog) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    @NonNull
    private synchronized Map<String, Object> afErrorLog() {
        boolean z10;
        int i10 = AFLogger$LogLevel + 61;
        getLevel = i10 % 128;
        int i11 = i10 % 2;
        this.AFInAppEventType.put("data", this.AFKeystoreWrapper);
        afInfoLog();
        Map<String, Object> map = this.AFInAppEventType;
        int i12 = getLevel + 99;
        AFLogger$LogLevel = i12 % 128;
        if (i12 % 2 == 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return map;
        }
        int i13 = 30 / 0;
        return map;
    }

    private synchronized void afInfoLog() {
        boolean z10;
        this.AFKeystoreWrapper = new ArrayList();
        this.afDebugLog = 0;
        int i10 = AFLogger$LogLevel + 1;
        getLevel = i10 % 128;
        if (i10 % 2 != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            int i11 = 61 / 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void AFInAppEventParameterName() {
        boolean z10 = false;
        values("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.afErrorLog = false;
        this.AFInAppEventParameterName = false;
        int i10 = getLevel + 47;
        AFLogger$LogLevel = i10 % 128;
        if (i10 % 2 == 0) {
            z10 = true;
        }
        if (z10) {
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void AFKeystoreWrapper() {
        int i10 = AFLogger$LogLevel + 55;
        getLevel = i10 % 128;
        int i11 = i10 % 2;
        this.AFInAppEventType.clear();
        valueOf = null;
        int i12 = AFLogger$LogLevel + 115;
        getLevel = i12 % 128;
        if (!(i12 % 2 == 0)) {
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean afDebugLog() {
        int i10 = getLevel + 101;
        AFLogger$LogLevel = i10 % 128;
        if (i10 % 2 != 0) {
            return this.afErrorLog;
        }
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final void afRDLog() {
        int i10 = AFLogger$LogLevel;
        int i11 = i10 + 93;
        getLevel = i11 % 128;
        int i12 = i11 % 2;
        this.afInfoLog = false;
        int i13 = i10 + 43;
        getLevel = i13 % 128;
        if ((i13 % 2 != 0 ? 'J' : 'C') == 'J') {
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void valueOf() {
        this.afErrorLog = true;
        values("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        int i10 = getLevel + 7;
        AFLogger$LogLevel = i10 % 128;
        int i11 = i10 % 2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void values(String str) {
        int i10 = getLevel + 77;
        int i11 = i10 % 128;
        AFLogger$LogLevel = i11;
        int i12 = i10 % 2;
        this.AFLogger = str;
        int i13 = i11 + 81;
        getLevel = i13 % 128;
        int i14 = i13 % 2;
    }

    public final void values(Throwable th2) {
        String str;
        int i10 = AFLogger$LogLevel + 37;
        getLevel = i10 % 128;
        int i11 = i10 % 2;
        Throwable cause = th2.getCause();
        String simpleName = th2.getClass().getSimpleName();
        if (cause == null) {
            int i12 = getLevel + 59;
            AFLogger$LogLevel = i12 % 128;
            int i13 = i12 % 2;
            str = th2.getMessage();
        } else {
            str = cause.getMessage();
        }
        values("exception", simpleName, valueOf(str, (cause == null ? '3' : 25) != '3' ? cause.getStackTrace() : th2.getStackTrace()));
    }

    /* access modifiers changed from: package-private */
    public final void valueOf(String str, PackageManager packageManager, AFc1xSDK aFc1xSDK) {
        try {
            valueOf(str, packageManager, aFc1xSDK.AFVersionDeclaration());
            AFd1bSDK aFd1bSDK = new AFd1bSDK(afErrorLog(), aFc1xSDK);
            AFd1xSDK afDebugLog2 = aFc1xSDK.afDebugLog();
            afDebugLog2.AFKeystoreWrapper.execute(new Runnable(aFd1bSDK) {
                private /* synthetic */ AFd1tSDK AFInAppEventParameterName;

                {
                    this.AFInAppEventParameterName = r2;
                }

                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r6 = this;
                        com.appsflyer.internal.AFd1xSDK r0 = com.appsflyer.internal.AFd1xSDK.this
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r0 = r0.afInfoLog
                        monitor-enter(r0)
                        com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                        java.util.Set<com.appsflyer.internal.AFd1tSDK<?>> r1 = r1.afErrorLog     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x018f }
                        if (r1 == 0) goto L_0x0026
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018f }
                        java.lang.String r2 = "QUEUE: tried to add already running task: "
                        r1.<init>(r2)     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        r1.append(r2)     // Catch:{ all -> 0x018f }
                        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018f }
                        com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x018f }
                        monitor-exit(r0)     // Catch:{ all -> 0x018f }
                        return
                    L_0x0026:
                        com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r1 = r1.afInfoLog     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x018f }
                        if (r1 != 0) goto L_0x017a
                        com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r1 = r1.AFLogger     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x018f }
                        if (r1 == 0) goto L_0x0040
                        goto L_0x017a
                    L_0x0040:
                        com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        java.util.Set<com.appsflyer.internal.AFd1wSDK> r3 = r2.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x018f }
                    L_0x004a:
                        boolean r4 = r3.hasNext()     // Catch:{ all -> 0x018f }
                        if (r4 == 0) goto L_0x0064
                        java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1wSDK r4 = (com.appsflyer.internal.AFd1wSDK) r4     // Catch:{ all -> 0x018f }
                        java.util.Set<com.appsflyer.internal.AFd1wSDK> r5 = r1.values     // Catch:{ all -> 0x018f }
                        boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x018f }
                        if (r5 == 0) goto L_0x004a
                        java.util.Set<com.appsflyer.internal.AFd1wSDK> r5 = r2.values     // Catch:{ all -> 0x018f }
                        r5.add(r4)     // Catch:{ all -> 0x018f }
                        goto L_0x004a
                    L_0x0064:
                        com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        boolean r1 = r1.AFInAppEventParameterName((com.appsflyer.internal.AFd1tSDK<?>) r2)     // Catch:{ all -> 0x018f }
                        if (r1 == 0) goto L_0x0079
                        com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r1 = r1.afInfoLog     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        boolean r1 = r1.add(r2)     // Catch:{ all -> 0x018f }
                        goto L_0x009d
                    L_0x0079:
                        com.appsflyer.internal.AFd1xSDK r1 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r1 = r1.AFLogger     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        boolean r1 = r1.add(r2)     // Catch:{ all -> 0x018f }
                        if (r1 == 0) goto L_0x009d
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x018f }
                        java.lang.String r3 = "QUEUE: new task was blocked: "
                        r2.<init>(r3)     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1tSDK r3 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        r2.append(r3)     // Catch:{ all -> 0x018f }
                        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x018f }
                        com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        r2.values()     // Catch:{ all -> 0x018f }
                    L_0x009d:
                        if (r1 == 0) goto L_0x00b0
                        com.appsflyer.internal.AFd1xSDK r2 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r2.afInfoLog     // Catch:{ all -> 0x018f }
                        java.util.List<com.appsflyer.internal.AFd1tSDK<?>> r2 = r2.afDebugLog     // Catch:{ all -> 0x018f }
                        r3.addAll(r2)     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1xSDK r2 = com.appsflyer.internal.AFd1xSDK.this     // Catch:{ all -> 0x018f }
                        java.util.List<com.appsflyer.internal.AFd1tSDK<?>> r2 = r2.afDebugLog     // Catch:{ all -> 0x018f }
                        r2.clear()     // Catch:{ all -> 0x018f }
                        goto L_0x00c3
                    L_0x00b0:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x018f }
                        java.lang.String r3 = "QUEUE: task not added, it's already in the queue: "
                        r2.<init>(r3)     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1tSDK r3 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        r2.append(r3)     // Catch:{ all -> 0x018f }
                        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x018f }
                        com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x018f }
                    L_0x00c3:
                        monitor-exit(r0)     // Catch:{ all -> 0x018f }
                        if (r1 == 0) goto L_0x0166
                        com.appsflyer.internal.AFd1xSDK r0 = com.appsflyer.internal.AFd1xSDK.this
                        java.util.Set<com.appsflyer.internal.AFd1wSDK> r0 = r0.values
                        com.appsflyer.internal.AFd1tSDK r1 = r6.AFInAppEventParameterName
                        com.appsflyer.internal.AFd1wSDK r1 = r1.AFKeystoreWrapper
                        r0.add(r1)
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        java.lang.String r1 = "QUEUE: new task added: "
                        r0.<init>(r1)
                        com.appsflyer.internal.AFd1tSDK r1 = r6.AFInAppEventParameterName
                        r0.append(r1)
                        java.lang.String r0 = r0.toString()
                        com.appsflyer.AFLogger.afDebugLog(r0)
                        com.appsflyer.internal.AFd1xSDK r0 = com.appsflyer.internal.AFd1xSDK.this
                        java.util.List<com.appsflyer.internal.AFd1zSDK> r0 = r0.AFInAppEventParameterName
                        java.util.Iterator r0 = r0.iterator()
                    L_0x00ec:
                        boolean r1 = r0.hasNext()
                        if (r1 == 0) goto L_0x00f9
                        java.lang.Object r1 = r0.next()
                        com.appsflyer.internal.AFd1zSDK r1 = (com.appsflyer.internal.AFd1zSDK) r1
                        goto L_0x00ec
                    L_0x00f9:
                        com.appsflyer.internal.AFd1xSDK r0 = com.appsflyer.internal.AFd1xSDK.this
                        java.util.concurrent.ExecutorService r1 = r0.valueOf
                        r1.submit(r0)
                        com.appsflyer.internal.AFd1xSDK r0 = com.appsflyer.internal.AFd1xSDK.this
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r1 = r0.afInfoLog
                        monitor-enter(r1)
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r2 = r0.afInfoLog     // Catch:{ all -> 0x0163 }
                        int r2 = r2.size()     // Catch:{ all -> 0x0163 }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0163 }
                        int r3 = r3.size()     // Catch:{ all -> 0x0163 }
                        int r2 = r2 + r3
                        int r2 = r2 + -40
                    L_0x0114:
                        if (r2 <= 0) goto L_0x0161
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0163 }
                        boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0163 }
                        r4 = 1
                        if (r3 != 0) goto L_0x0121
                        r3 = r4
                        goto L_0x0122
                    L_0x0121:
                        r3 = 0
                    L_0x0122:
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r5 = r0.afInfoLog     // Catch:{ all -> 0x0163 }
                        boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0163 }
                        r4 = r4 ^ r5
                        if (r4 == 0) goto L_0x014f
                        if (r3 == 0) goto L_0x014f
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.afInfoLog     // Catch:{ all -> 0x0163 }
                        java.lang.Object r3 = r3.first()     // Catch:{ all -> 0x0163 }
                        com.appsflyer.internal.AFd1tSDK r3 = (com.appsflyer.internal.AFd1tSDK) r3     // Catch:{ all -> 0x0163 }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r4 = r0.AFLogger     // Catch:{ all -> 0x0163 }
                        java.lang.Object r4 = r4.first()     // Catch:{ all -> 0x0163 }
                        com.appsflyer.internal.AFd1tSDK r4 = (com.appsflyer.internal.AFd1tSDK) r4     // Catch:{ all -> 0x0163 }
                        int r3 = r3.AFInAppEventParameterName(r4)     // Catch:{ all -> 0x0163 }
                        if (r3 <= 0) goto L_0x0149
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.afInfoLog     // Catch:{ all -> 0x0163 }
                        r0.values(r3)     // Catch:{ all -> 0x0163 }
                        goto L_0x015e
                    L_0x0149:
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0163 }
                        r0.values(r3)     // Catch:{ all -> 0x0163 }
                        goto L_0x015e
                    L_0x014f:
                        if (r4 == 0) goto L_0x0157
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.afInfoLog     // Catch:{ all -> 0x0163 }
                        r0.values(r3)     // Catch:{ all -> 0x0163 }
                        goto L_0x015e
                    L_0x0157:
                        if (r3 == 0) goto L_0x015e
                        java.util.NavigableSet<com.appsflyer.internal.AFd1tSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0163 }
                        r0.values(r3)     // Catch:{ all -> 0x0163 }
                    L_0x015e:
                        int r2 = r2 + -1
                        goto L_0x0114
                    L_0x0161:
                        monitor-exit(r1)     // Catch:{ all -> 0x0163 }
                        return
                    L_0x0163:
                        r0 = move-exception
                        monitor-exit(r1)
                        throw r0
                    L_0x0166:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        java.lang.String r1 = "QUEUE: tried to add already pending task: "
                        r0.<init>(r1)
                        com.appsflyer.internal.AFd1tSDK r1 = r6.AFInAppEventParameterName
                        r0.append(r1)
                        java.lang.String r0 = r0.toString()
                        com.appsflyer.AFLogger.afWarnLog(r0)
                        return
                    L_0x017a:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018f }
                        java.lang.String r2 = "QUEUE: tried to add already scheduled task: "
                        r1.<init>(r2)     // Catch:{ all -> 0x018f }
                        com.appsflyer.internal.AFd1tSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x018f }
                        r1.append(r2)     // Catch:{ all -> 0x018f }
                        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018f }
                        com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x018f }
                        monitor-exit(r0)     // Catch:{ all -> 0x018f }
                        return
                    L_0x018f:
                        r1 = move-exception
                        monitor-exit(r0)
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1xSDK.AnonymousClass2.run():void");
                }
            });
            int i10 = AFLogger$LogLevel + 53;
            getLevel = i10 % 128;
            int i11 = i10 % 2;
        } catch (Throwable th2) {
            AFLogger.afErrorLogForExcManagerOnly("could not send proxy data", th2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void AFInAppEventParameterName(java.lang.String r6, java.lang.String r7, int[] r8, int r9, java.lang.Object[] r10) {
        /*
            if (r7 == 0) goto L_0x0008
            java.lang.String r0 = "ISO-8859-1"
            byte[] r7 = r7.getBytes(r0)
        L_0x0008:
            byte[] r7 = (byte[]) r7
            if (r6 == 0) goto L_0x0010
            char[] r6 = r6.toCharArray()
        L_0x0010:
            char[] r6 = (char[]) r6
            java.lang.Object r0 = com.appsflyer.internal.AFf1eSDK.AFInAppEventParameterName
            monitor-enter(r0)
            char[] r1 = afRDLog     // Catch:{ all -> 0x00a9 }
            int r2 = afErrorLogForExcManagerOnly     // Catch:{ all -> 0x00a9 }
            boolean r3 = AFVersionDeclaration     // Catch:{ all -> 0x00a9 }
            r4 = 0
            if (r3 == 0) goto L_0x004b
            int r6 = r7.length     // Catch:{ all -> 0x00a9 }
            com.appsflyer.internal.AFf1eSDK.values = r6     // Catch:{ all -> 0x00a9 }
            char[] r6 = new char[r6]     // Catch:{ all -> 0x00a9 }
            com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper = r4     // Catch:{ all -> 0x00a9 }
        L_0x0025:
            int r8 = com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00a9 }
            int r3 = com.appsflyer.internal.AFf1eSDK.values     // Catch:{ all -> 0x00a9 }
            if (r8 >= r3) goto L_0x0042
            int r8 = com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00a9 }
            int r3 = com.appsflyer.internal.AFf1eSDK.values     // Catch:{ all -> 0x00a9 }
            int r3 = r3 + -1
            int r5 = com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00a9 }
            int r3 = r3 - r5
            byte r3 = r7[r3]     // Catch:{ all -> 0x00a9 }
            int r3 = r3 + r9
            char r3 = r1[r3]     // Catch:{ all -> 0x00a9 }
            int r3 = r3 - r2
            char r3 = (char) r3     // Catch:{ all -> 0x00a9 }
            r6[r8] = r3     // Catch:{ all -> 0x00a9 }
            int r5 = r5 + 1
            com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper = r5     // Catch:{ all -> 0x00a9 }
            goto L_0x0025
        L_0x0042:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x00a9 }
            r7.<init>(r6)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            r10[r4] = r7
            return
        L_0x004b:
            boolean r7 = afWarnLog     // Catch:{ all -> 0x00a9 }
            if (r7 == 0) goto L_0x007c
            int r7 = r6.length     // Catch:{ all -> 0x00a9 }
            com.appsflyer.internal.AFf1eSDK.values = r7     // Catch:{ all -> 0x00a9 }
            char[] r7 = new char[r7]     // Catch:{ all -> 0x00a9 }
            com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper = r4     // Catch:{ all -> 0x00a9 }
        L_0x0056:
            int r8 = com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00a9 }
            int r3 = com.appsflyer.internal.AFf1eSDK.values     // Catch:{ all -> 0x00a9 }
            if (r8 >= r3) goto L_0x0073
            int r8 = com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00a9 }
            int r3 = com.appsflyer.internal.AFf1eSDK.values     // Catch:{ all -> 0x00a9 }
            int r3 = r3 + -1
            int r5 = com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00a9 }
            int r3 = r3 - r5
            char r3 = r6[r3]     // Catch:{ all -> 0x00a9 }
            int r3 = r3 - r9
            char r3 = r1[r3]     // Catch:{ all -> 0x00a9 }
            int r3 = r3 - r2
            char r3 = (char) r3     // Catch:{ all -> 0x00a9 }
            r7[r8] = r3     // Catch:{ all -> 0x00a9 }
            int r5 = r5 + 1
            com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper = r5     // Catch:{ all -> 0x00a9 }
            goto L_0x0056
        L_0x0073:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x00a9 }
            r6.<init>(r7)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            r10[r4] = r6
            return
        L_0x007c:
            int r6 = r8.length     // Catch:{ all -> 0x00a9 }
            com.appsflyer.internal.AFf1eSDK.values = r6     // Catch:{ all -> 0x00a9 }
            char[] r6 = new char[r6]     // Catch:{ all -> 0x00a9 }
            com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper = r4     // Catch:{ all -> 0x00a9 }
        L_0x0083:
            int r7 = com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00a9 }
            int r3 = com.appsflyer.internal.AFf1eSDK.values     // Catch:{ all -> 0x00a9 }
            if (r7 >= r3) goto L_0x00a0
            int r7 = com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00a9 }
            int r3 = com.appsflyer.internal.AFf1eSDK.values     // Catch:{ all -> 0x00a9 }
            int r3 = r3 + -1
            int r5 = com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00a9 }
            int r3 = r3 - r5
            r3 = r8[r3]     // Catch:{ all -> 0x00a9 }
            int r3 = r3 - r9
            char r3 = r1[r3]     // Catch:{ all -> 0x00a9 }
            int r3 = r3 - r2
            char r3 = (char) r3     // Catch:{ all -> 0x00a9 }
            r6[r7] = r3     // Catch:{ all -> 0x00a9 }
            int r5 = r5 + 1
            com.appsflyer.internal.AFf1eSDK.AFKeystoreWrapper = r5     // Catch:{ all -> 0x00a9 }
            goto L_0x0083
        L_0x00a0:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x00a9 }
            r7.<init>(r6)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            r10[r4] = r7
            return
        L_0x00a9:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1uSDK.AFInAppEventParameterName(java.lang.String, java.lang.String, int[], int, java.lang.Object[]):void");
    }

    private synchronized void AFKeystoreWrapper(String str, String str2, String str3) {
        try {
            Map<String, Object> map = this.AFInAppEventType;
            Object[] objArr = new Object[1];
            AFInAppEventParameterName((String) null, "", (int[]) null, (ViewConfiguration.getPressedStateDuration() >> 16) + Opcodes.LAND, objArr);
            boolean z10 = false;
            map.put(((String) objArr[0]).intern(), Build.BRAND);
            this.AFInAppEventType.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
            this.AFInAppEventType.put("platform", "Android");
            this.AFInAppEventType.put("platform_version", Build.VERSION.RELEASE);
            if (str != null) {
                int i10 = AFLogger$LogLevel + 109;
                getLevel = i10 % 128;
                int i11 = i10 % 2;
                if ((str.length() > 0 ? 'M' : 'S') == 'M') {
                    int i12 = AFLogger$LogLevel + 3;
                    getLevel = i12 % 128;
                    int i13 = i12 % 2;
                    this.AFInAppEventType.put("advertiserId", str);
                    int i14 = AFLogger$LogLevel + 67;
                    getLevel = i14 % 128;
                    int i15 = i14 % 2;
                }
            }
            if (str2 != null) {
                if (!(str2.length() <= 0)) {
                    this.AFInAppEventType.put("imei", str2);
                }
            }
            if (!(str3 == null)) {
                if (str3.length() <= 0) {
                    z10 = true;
                }
                if (!z10) {
                    this.AFInAppEventType.put("android_id", str3);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void AFInAppEventType(String str, int i10, String str2) {
        int i11 = AFLogger$LogLevel + 87;
        getLevel = i11 % 128;
        int i12 = i11 % 2;
        values("server_response", str, String.valueOf(i10), str2);
        int i13 = getLevel + 63;
        AFLogger$LogLevel = i13 % 128;
        if ((i13 % 2 == 0 ? (char) 21 : 29) != 29) {
            throw null;
        }
    }

    private synchronized void valueOf(String str, String str2, String str3, String str4) {
        int i10 = getLevel + 101;
        AFLogger$LogLevel = i10 % 128;
        if (i10 % 2 != 0) {
            try {
                this.AFInAppEventType.put("sdk_version", str);
                boolean z10 = false;
                if ((str2 != null ? 28 : 'W') == 28) {
                    if (!(str2.length() <= 0)) {
                        this.AFInAppEventType.put("devkey", str2);
                    }
                }
                if (!(str3 == null)) {
                    if (str3.length() > 0) {
                        z10 = true;
                    }
                    if (z10) {
                        this.AFInAppEventType.put("originalAppsFlyerId", str3);
                        int i11 = getLevel + 109;
                        AFLogger$LogLevel = i11 % 128;
                        if (i11 % 2 == 0) {
                        }
                    }
                }
                if (str4 != null) {
                    int i12 = getLevel + 123;
                    AFLogger$LogLevel = i12 % 128;
                    int i13 = i12 % 2;
                    if ((str4.length() > 0 ? 'O' : 'D') != 'D') {
                        this.AFInAppEventType.put("uid", str4);
                    }
                }
            } catch (Throwable unused) {
            }
        } else {
            this.AFInAppEventType.put("sdk_version", str);
            throw null;
        }
    }

    public final void values(String str, String str2) {
        int i10 = AFLogger$LogLevel + 39;
        getLevel = i10 % 128;
        int i11 = i10 % 2;
        values((String) null, str, str2);
        int i12 = AFLogger$LogLevel + 35;
        getLevel = i12 % 128;
        if ((i12 % 2 != 0 ? 'P' : 'E') == 'P') {
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002d, code lost:
        if (r5.afDebugLog >= 98304) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0030, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void values(java.lang.String r6, java.lang.String r7, java.lang.String... r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.AFLogger()     // Catch:{ all -> 0x00bd }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000b
            r0 = r1
            goto L_0x000c
        L_0x000b:
            r0 = r2
        L_0x000c:
            if (r0 == 0) goto L_0x000f
            goto L_0x002f
        L_0x000f:
            int r0 = AFLogger$LogLevel     // Catch:{ all -> 0x00bd }
            int r0 = r0 + 71
            int r3 = r0 % 128
            getLevel = r3     // Catch:{ all -> 0x00bd }
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x001d
            r0 = r1
            goto L_0x001e
        L_0x001d:
            r0 = r2
        L_0x001e:
            r3 = 98304(0x18000, float:1.37753E-40)
            if (r0 == 0) goto L_0x0028
            int r0 = r5.afDebugLog     // Catch:{ all -> 0x00bd }
            if (r0 < r3) goto L_0x0031
            goto L_0x002f
        L_0x0028:
            int r0 = r5.afDebugLog     // Catch:{ all -> 0x00bd }
            r4 = 47
            int r4 = r4 / r1
            if (r0 < r3) goto L_0x0031
        L_0x002f:
            monitor-exit(r5)
            return
        L_0x0031:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00b9 }
            java.lang.String r3 = ", "
            java.lang.String r8 = android.text.TextUtils.join(r3, r8)     // Catch:{ all -> 0x00b9 }
            if (r6 == 0) goto L_0x0072
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r3.<init>()     // Catch:{ all -> 0x00b9 }
            r3.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = " "
            r3.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00b9 }
            long r0 = r0.getId()     // Catch:{ all -> 0x00b9 }
            r3.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = " _/AppsFlyer_6.10.0 ["
            r3.append(r0)     // Catch:{ all -> 0x00b9 }
            r3.append(r6)     // Catch:{ all -> 0x00b9 }
            java.lang.String r6 = "] "
            r3.append(r6)     // Catch:{ all -> 0x00b9 }
            r3.append(r7)     // Catch:{ all -> 0x00b9 }
            java.lang.String r6 = " "
            r3.append(r6)     // Catch:{ all -> 0x00b9 }
            r3.append(r8)     // Catch:{ all -> 0x00b9 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x00b9 }
            goto L_0x009e
        L_0x0072:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r6.<init>()     // Catch:{ all -> 0x00b9 }
            r6.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = " "
            r6.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00b9 }
            long r0 = r0.getId()     // Catch:{ all -> 0x00b9 }
            r6.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = " "
            r6.append(r0)     // Catch:{ all -> 0x00b9 }
            r6.append(r7)     // Catch:{ all -> 0x00b9 }
            java.lang.String r7 = "/AppsFlyer_6.10.0 "
            r6.append(r7)     // Catch:{ all -> 0x00b9 }
            r6.append(r8)     // Catch:{ all -> 0x00b9 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00b9 }
        L_0x009e:
            java.util.List<java.lang.String> r7 = r5.AFKeystoreWrapper     // Catch:{ all -> 0x00b9 }
            r7.add(r6)     // Catch:{ all -> 0x00b9 }
            int r7 = r5.afDebugLog     // Catch:{ all -> 0x00b9 }
            int r6 = r6.length()     // Catch:{ all -> 0x00b9 }
            int r6 = r6 << r2
            int r7 = r7 + r6
            r5.afDebugLog = r7     // Catch:{ all -> 0x00b9 }
            int r6 = AFLogger$LogLevel     // Catch:{ all -> 0x00bd }
            int r6 = r6 + 93
            int r7 = r6 % 128
            getLevel = r7     // Catch:{ all -> 0x00bd }
            int r6 = r6 % 2
            monitor-exit(r5)
            return
        L_0x00b9:
            monitor-exit(r5)
            return
        L_0x00bb:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00bd }
        L_0x00bd:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1uSDK.values(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    private synchronized void AFKeystoreWrapper(String str, String str2, String str3, String str4) {
        if (!(str == null)) {
            try {
                if ((str.length() > 0 ? 9 : '\'') == 9) {
                    this.AFInAppEventType.put("app_id", str);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (str2 != null) {
            int i10 = getLevel + 3;
            AFLogger$LogLevel = i10 % 128;
            int i11 = i10 % 2;
            if (str2.length() > 0) {
                int i12 = getLevel + 91;
                AFLogger$LogLevel = i12 % 128;
                int i13 = i12 % 2;
                this.AFInAppEventType.put("app_version", str2);
            }
        }
        if (str3 != null) {
            if (!(str3.length() <= 0)) {
                this.AFInAppEventType.put("channel", str3);
                int i14 = AFLogger$LogLevel + 9;
                getLevel = i14 % 128;
                if (i14 % 2 != 0) {
                }
            }
        }
        if (str4 != null) {
            int i15 = getLevel + 23;
            AFLogger$LogLevel = i15 % 128;
            if (i15 % 2 == 0) {
                int i16 = 99 / 0;
                if (str4.length() > 0) {
                }
            } else {
                if ((str4.length() > 0 ? 16 : 'Y') != 16) {
                }
            }
            this.AFInAppEventType.put("preInstall", str4);
        }
    }

    public final void valueOf(String str, String str2) {
        int i10 = AFLogger$LogLevel + 37;
        getLevel = i10 % 128;
        if (!(i10 % 2 == 0)) {
            values("server_request", str, str2);
        } else {
            values("server_request", str, str2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0089 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void valueOf(java.lang.String r6, android.content.pm.PackageManager r7, com.appsflyer.internal.AFe1xSDK r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = AFLogger$LogLevel     // Catch:{ all -> 0x00a2 }
            int r0 = r0 + 3
            int r1 = r0 % 128
            getLevel = r1     // Catch:{ all -> 0x00a2 }
            int r0 = r0 % 2
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = "remote_debug_static_data"
            java.lang.String r2 = r0.getString(r1)     // Catch:{ all -> 0x00a2 }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            r3.clear()     // Catch:{ all -> 0x00a2 }
            if (r2 == 0) goto L_0x0035
            java.util.Map<java.lang.String, java.lang.Object> r6 = r5.AFInAppEventType     // Catch:{ all -> 0x0097 }
            org.json.b r7 = new org.json.b     // Catch:{ all -> 0x0097 }
            r7.<init>((java.lang.String) r2)     // Catch:{ all -> 0x0097 }
            java.util.Map r7 = com.appsflyer.internal.AFa1lSDK.AFInAppEventType((org.json.b) r7)     // Catch:{ all -> 0x0097 }
            r6.putAll(r7)     // Catch:{ all -> 0x0097 }
            int r6 = AFLogger$LogLevel     // Catch:{ all -> 0x00a2 }
            int r6 = r6 + 55
            int r7 = r6 % 128
            getLevel = r7     // Catch:{ all -> 0x00a2 }
            int r6 = r6 % 2
            goto L_0x0097
        L_0x0035:
            com.appsflyer.internal.AFb1zSDK r2 = com.appsflyer.internal.AFb1zSDK.AFInAppEventType()     // Catch:{ all -> 0x00a2 }
            java.lang.String r3 = "advertiserId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x00a2 }
            java.lang.String r8 = r8.valueOf     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = r2.afDebugLog     // Catch:{ all -> 0x00a2 }
            r5.AFKeystoreWrapper(r3, r8, r4)     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            java.lang.String r3 = "6.10.0."
            r8.<init>(r3)     // Catch:{ all -> 0x00a2 }
            java.lang.String r3 = com.appsflyer.internal.AFb1zSDK.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            r8.append(r3)     // Catch:{ all -> 0x00a2 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00a2 }
            com.appsflyer.internal.AFc1xSDK r2 = r2.AFInAppEventParameterName()     // Catch:{ all -> 0x00a2 }
            com.appsflyer.internal.AFe1xSDK r2 = r2.AFVersionDeclaration()     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = r2.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            java.lang.String r3 = "KSAppsFlyerId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = "uid"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x00a2 }
            r5.valueOf(r8, r2, r3, r4)     // Catch:{ all -> 0x00a2 }
            r8 = 0
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r6, r8)     // Catch:{ all -> 0x0089 }
            int r7 = r7.versionCode     // Catch:{ all -> 0x0089 }
            java.lang.String r8 = "channel"
            java.lang.String r8 = r0.getString(r8)     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = "preInstallName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0089 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0089 }
            r5.AFKeystoreWrapper(r6, r7, r8, r2)     // Catch:{ all -> 0x0089 }
        L_0x0089:
            org.json.b r6 = new org.json.b     // Catch:{ all -> 0x00a2 }
            java.util.Map<java.lang.String, java.lang.Object> r7 = r5.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            r6.<init>((java.util.Map<?, ?>) r7)     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00a2 }
            r0.set((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ all -> 0x00a2 }
        L_0x0097:
            java.util.Map<java.lang.String, java.lang.Object> r6 = r5.AFInAppEventType     // Catch:{ all -> 0x00a2 }
            java.lang.String r7 = "launch_counter"
            java.lang.String r8 = r5.AFLogger     // Catch:{ all -> 0x00a2 }
            r6.put(r7, r8)     // Catch:{ all -> 0x00a2 }
            monitor-exit(r5)
            return
        L_0x00a2:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1uSDK.valueOf(java.lang.String, android.content.pm.PackageManager, com.appsflyer.internal.AFe1xSDK):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void values() {
        int i10 = AFLogger$LogLevel + 71;
        getLevel = i10 % 128;
        if ((i10 % 2 != 0 ? PropertyUtils.INDEXED_DELIM2 : 'B') != 'B') {
            this.AFInAppEventParameterName = true;
        } else {
            this.AFInAppEventParameterName = false;
        }
        afInfoLog();
        int i11 = AFLogger$LogLevel + 95;
        getLevel = i11 % 128;
        int i12 = i11 % 2;
    }

    /* access modifiers changed from: package-private */
    public final void AFKeystoreWrapper(String str, String... strArr) {
        int i10 = getLevel + 99;
        AFLogger$LogLevel = i10 % 128;
        int i11 = i10 % 2;
        values("public_api_call", str, strArr);
        int i12 = AFLogger$LogLevel + 31;
        getLevel = i12 % 128;
        if (i12 % 2 != 0) {
            int i13 = 65 / 0;
        }
    }

    private static String[] valueOf(String str, StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null) {
            String[] strArr = new String[(stackTraceElementArr.length + 1)];
            strArr[0] = str;
            int i10 = 1;
            while (true) {
                if (!(i10 < stackTraceElementArr.length)) {
                    return strArr;
                }
                int i11 = getLevel + 117;
                AFLogger$LogLevel = i11 % 128;
                int i12 = i11 % 2;
                strArr[i10] = stackTraceElementArr[i10].toString();
                i10++;
                int i13 = AFLogger$LogLevel + 89;
                getLevel = i13 % 128;
                int i14 = i13 % 2;
            }
        } else {
            int i15 = AFLogger$LogLevel + 19;
            getLevel = i15 % 128;
            int i16 = i15 % 2;
            return new String[]{str};
        }
    }
}
