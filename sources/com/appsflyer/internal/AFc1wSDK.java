package com.appsflyer.internal;

import android.os.Build;
import android.text.TextUtils;
import com.appsflyer.internal.AFc1vSDK;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import gk.f;
import gk.h;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import kotlin.text.d;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.beanutils.PropertyUtils;

public final class AFc1wSDK implements AFc1uSDK {
    private static int AFLogger$LogLevel = 0;
    private static int[] afDebugLog = {-1738095187, 1834906142, 1827906695, 1955966352, -937538432, -1634077668, -1526616300, 642933902, 1185377755, 1528790409, -1756558490, -77919810, -775634893, 192278897, -106703006, -2126434171, 582203754, 1763923543};
    private static int getLevel = 1;
    private final f AFInAppEventParameterName = b.b(new Function0<AFe1xSDK>(this) {
        private /* synthetic */ AFc1wSDK AFKeystoreWrapper;

        {
            this.AFKeystoreWrapper = r1;
        }

        /* renamed from: AFInAppEventParameterName */
        public final AFe1xSDK invoke() {
            AFe1xSDK AFVersionDeclaration = AFc1wSDK.AFInAppEventParameterName(this.AFKeystoreWrapper).AFVersionDeclaration();
            j.f(AFVersionDeclaration, "");
            return AFVersionDeclaration;
        }
    });
    private AFc1xSDK AFInAppEventType;
    private final f AFKeystoreWrapper = b.b(new Function0<AFb1gSDK>(this) {
        private /* synthetic */ AFc1wSDK values;

        {
            this.values = r1;
        }

        /* renamed from: AFKeystoreWrapper */
        public final AFb1gSDK invoke() {
            AFb1gSDK afErrorLog = AFc1wSDK.AFInAppEventParameterName(this.values).afErrorLog();
            j.f(afErrorLog, "");
            return afErrorLog;
        }
    });
    private final f AFLogger = b.b(new Function0<AFa1bSDK>(this) {
        private /* synthetic */ AFc1wSDK AFKeystoreWrapper;

        {
            this.AFKeystoreWrapper = r1;
        }

        /* renamed from: AFKeystoreWrapper */
        public final AFa1bSDK invoke() {
            AFc1ySDK afErrorLogForExcManagerOnly = AFc1wSDK.AFInAppEventParameterName(this.AFKeystoreWrapper).afErrorLogForExcManagerOnly();
            j.f(afErrorLogForExcManagerOnly, "");
            return new AFa1bSDK(afErrorLogForExcManagerOnly);
        }
    });
    private final f afErrorLog = b.b(new Function0<AFa1dSDK>(this) {
        private /* synthetic */ AFc1wSDK values;

        {
            this.values = r1;
        }

        /* renamed from: AFInAppEventParameterName */
        public final AFa1dSDK invoke() {
            return new AFa1dSDK(this.values.AFKeystoreWrapper());
        }
    });
    private final f afInfoLog = b.b(new Function0<ExecutorService>(this) {
        private /* synthetic */ AFc1wSDK values;

        {
            this.values = r1;
        }

        /* renamed from: AFInAppEventParameterName */
        public final ExecutorService invoke() {
            ExecutorService AFInAppEventParameterName = AFc1wSDK.AFInAppEventParameterName(this.values).AFInAppEventParameterName();
            j.f(AFInAppEventParameterName, "");
            return AFInAppEventParameterName;
        }
    });
    private final String afRDLog = "6.10.0";
    private final f valueOf = b.b(new Function0<AFb1fSDK>(this) {
        private /* synthetic */ AFc1wSDK AFKeystoreWrapper;

        {
            this.AFKeystoreWrapper = r1;
        }

        /* renamed from: AFInAppEventParameterName */
        public final AFb1fSDK invoke() {
            AFb1fSDK values = AFc1wSDK.AFInAppEventParameterName(this.AFKeystoreWrapper).values();
            j.f(values, "");
            return values;
        }
    });
    private final f values = b.b(new Function0<AFb1vSDK>(this) {
        private /* synthetic */ AFc1wSDK valueOf;

        {
            this.valueOf = r1;
        }

        /* renamed from: values */
        public final AFb1vSDK invoke() {
            AFb1vSDK afInfoLog = AFc1wSDK.AFInAppEventParameterName(this.valueOf).afInfoLog();
            j.f(afInfoLog, "");
            return afInfoLog;
        }
    });

    public AFc1wSDK(AFc1xSDK aFc1xSDK) {
        j.g(aFc1xSDK, "");
        this.AFInAppEventType = aFc1xSDK;
    }

    public static final /* synthetic */ AFc1xSDK AFInAppEventParameterName(AFc1wSDK aFc1wSDK) {
        int i10 = getLevel;
        int i11 = i10 + 125;
        AFLogger$LogLevel = i11 % 128;
        int i12 = i11 % 2;
        AFc1xSDK aFc1xSDK = aFc1wSDK.AFInAppEventType;
        int i13 = i10 + 105;
        AFLogger$LogLevel = i13 % 128;
        if (i13 % 2 == 0) {
            return aFc1xSDK;
        }
        int i14 = 77 / 0;
        return aFc1xSDK;
    }

    /* access modifiers changed from: private */
    public static final void AFInAppEventType(AFc1wSDK aFc1wSDK, Throwable th2, String str) {
        int i10 = getLevel + 7;
        AFLogger$LogLevel = i10 % 128;
        if ((i10 % 2 != 0 ? 'Q' : '@') == '@') {
            j.g(aFc1wSDK, "");
            j.g(th2, "");
            j.g(str, "");
            aFc1wSDK.AFKeystoreWrapper().values(th2, str);
            return;
        }
        j.g(aFc1wSDK, "");
        j.g(th2, "");
        j.g(str, "");
        aFc1wSDK.AFKeystoreWrapper().values(th2, str);
        throw null;
    }

    private String AFLogger() {
        int i10 = getLevel + 47;
        int i11 = i10 % 128;
        AFLogger$LogLevel = i11;
        int i12 = i10 % 2;
        String str = this.afRDLog;
        int i13 = i11 + 11;
        getLevel = i13 % 128;
        if ((i13 % 2 == 0 ? 'b' : '!') != 'b') {
            return str;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r0 != null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        r0 = AFLogger$LogLevel + 67;
        getLevel = r0 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        if ((r0 % 2) == 0) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (r2 != 28) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void AFLogger$LogLevel() {
        /*
            r4 = this;
            int r0 = AFLogger$LogLevel
            int r0 = r0 + 55
            int r1 = r0 % 128
            getLevel = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0021
            com.appsflyer.internal.AFb1tSDK r0 = r4.afErrorLogForExcManagerOnly()
            r1 = 35
            int r1 = r1 / 0
            r1 = 28
            if (r0 == 0) goto L_0x001b
            r2 = 27
            goto L_0x001c
        L_0x001b:
            r2 = r1
        L_0x001c:
            if (r2 == r1) goto L_0x007b
            goto L_0x0027
        L_0x001f:
            r0 = move-exception
            throw r0
        L_0x0021:
            com.appsflyer.internal.AFb1tSDK r0 = r4.afErrorLogForExcManagerOnly()
            if (r0 == 0) goto L_0x007b
        L_0x0027:
            boolean r1 = r4.AFInAppEventParameterName((com.appsflyer.internal.AFb1tSDK) r0)
            r2 = 21
            if (r1 == 0) goto L_0x0032
            r1 = 97
            goto L_0x0033
        L_0x0032:
            r1 = r2
        L_0x0033:
            java.lang.String r3 = ""
            if (r1 == r2) goto L_0x006c
            int r1 = AFLogger$LogLevel
            int r1 = r1 + 57
            int r2 = r1 % 128
            getLevel = r2
            int r1 = r1 % 2
            com.appsflyer.internal.AFe1xSDK r1 = r4.afDebugLog()
            java.lang.String r1 = r1.AFInAppEventType
            if (r1 == 0) goto L_0x006b
            java.util.Map r0 = r4.AFKeystoreWrapper((com.appsflyer.internal.AFb1tSDK) r0)
            com.appsflyer.internal.AFc1zSDK r2 = r4.AFKeystoreWrapper()
            java.util.List r2 = r2.AFKeystoreWrapper()
            java.util.Map r0 = AFInAppEventParameterName((java.util.Map<java.lang.String, ? extends java.lang.Object>) r0, (java.util.List<com.appsflyer.internal.AFb1aSDK>) r2)
            org.json.b r2 = new org.json.b
            r2.<init>((java.util.Map<?, ?>) r0)
            java.lang.String r0 = r2.toString()
            kotlin.jvm.internal.j.f(r0, r3)
            kotlin.jvm.internal.j.f(r1, r3)
            r4.values(r0, r1)
        L_0x006b:
            return
        L_0x006c:
            java.lang.String r0 = "skipping"
            kotlin.jvm.internal.j.g(r0, r3)
            java.lang.String r1 = "[Exception Manager]: "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.afRDLog(r0)
            return
        L_0x007b:
            int r0 = AFLogger$LogLevel
            int r0 = r0 + 67
            int r1 = r0 % 128
            getLevel = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0088
            return
        L_0x0088:
            r0 = 0
            throw r0     // Catch:{ all -> 0x008a }
        L_0x008a:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1wSDK.AFLogger$LogLevel():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void AFVersionDeclaration() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.appsflyer.internal.AFb1tSDK r0 = r8.afErrorLogForExcManagerOnly()     // Catch:{ all -> 0x0087 }
            r1 = 0
            r2 = 2
            if (r0 == 0) goto L_0x006f
            int r3 = r0.valueOf     // Catch:{ all -> 0x0087 }
            r4 = -1
            if (r3 != r4) goto L_0x0036
            int r0 = getLevel     // Catch:{ all -> 0x0087 }
            int r0 = r0 + 7
            int r3 = r0 % 128
            AFLogger$LogLevel = r3     // Catch:{ all -> 0x0087 }
            int r0 = r0 % r2
            if (r0 == 0) goto L_0x001c
            r0 = 91
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            if (r0 != r2) goto L_0x002a
            com.appsflyer.internal.AFb1gSDK r0 = r8.afErrorLog()     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = "af_send_exc_to_server_window"
            r0.AFKeystoreWrapper(r1)     // Catch:{ all -> 0x0087 }
            monitor-exit(r8)
            return
        L_0x002a:
            com.appsflyer.internal.AFb1gSDK r0 = r8.afErrorLog()     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "af_send_exc_to_server_window"
            r0.AFKeystoreWrapper(r2)     // Catch:{ all -> 0x0087 }
            throw r1     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0087 }
        L_0x0036:
            com.appsflyer.internal.AFb1gSDK r1 = r8.afErrorLog()     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = "af_send_exc_to_server_window"
            r4 = -1
            long r6 = r1.valueOf((java.lang.String) r3, (long) r4)     // Catch:{ all -> 0x0087 }
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x006d
            int r1 = AFLogger$LogLevel     // Catch:{ all -> 0x0087 }
            int r1 = r1 + 123
            int r3 = r1 % 128
            getLevel = r3     // Catch:{ all -> 0x0087 }
            int r1 = r1 % r2
            int r1 = r0.values     // Catch:{ all -> 0x0087 }
            int r0 = r0.valueOf     // Catch:{ all -> 0x0087 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0087 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.DAYS     // Catch:{ all -> 0x0087 }
            long r5 = (long) r0     // Catch:{ all -> 0x0087 }
            long r4 = r4.toMillis(r5)     // Catch:{ all -> 0x0087 }
            long r2 = r2 + r4
            com.appsflyer.internal.AFb1gSDK r0 = r8.afErrorLog()     // Catch:{ all -> 0x0087 }
            java.lang.String r4 = "af_send_exc_to_server_window"
            r0.AFInAppEventType((java.lang.String) r4, (long) r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "af_send_exc_min"
            r0.AFInAppEventParameterName((java.lang.String) r2, (int) r1)     // Catch:{ all -> 0x0087 }
        L_0x006d:
            monitor-exit(r8)
            return
        L_0x006f:
            int r0 = getLevel     // Catch:{ all -> 0x0087 }
            int r0 = r0 + 27
            int r3 = r0 % 128
            AFLogger$LogLevel = r3     // Catch:{ all -> 0x0087 }
            int r0 = r0 % r2
            r2 = 90
            if (r0 == 0) goto L_0x007e
            r0 = r2
            goto L_0x0080
        L_0x007e:
            r0 = 78
        L_0x0080:
            if (r0 == r2) goto L_0x0084
            monitor-exit(r8)
            return
        L_0x0084:
            throw r1     // Catch:{ all -> 0x0085 }
        L_0x0085:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0087 }
        L_0x0087:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1wSDK.AFVersionDeclaration():void");
    }

    private final AFe1xSDK afDebugLog() {
        int i10 = getLevel + 77;
        AFLogger$LogLevel = i10 % 128;
        int i11 = i10 % 2;
        AFe1xSDK aFe1xSDK = (AFe1xSDK) this.AFInAppEventParameterName.getValue();
        int i12 = getLevel + 97;
        AFLogger$LogLevel = i12 % 128;
        int i13 = i12 % 2;
        return aFe1xSDK;
    }

    private final AFb1gSDK afErrorLog() {
        AFb1gSDK aFb1gSDK;
        int i10 = AFLogger$LogLevel + 79;
        getLevel = i10 % 128;
        if ((i10 % 2 == 0 ? 13 : '\"') != '\"') {
            aFb1gSDK = (AFb1gSDK) this.AFKeystoreWrapper.getValue();
            int i11 = 31 / 0;
        } else {
            aFb1gSDK = (AFb1gSDK) this.AFKeystoreWrapper.getValue();
        }
        int i12 = getLevel + 35;
        AFLogger$LogLevel = i12 % 128;
        int i13 = i12 % 2;
        return aFb1gSDK;
    }

    private final AFb1tSDK afErrorLogForExcManagerOnly() {
        boolean z10;
        char c10;
        AFb1oSDK aFb1oSDK = values().valueOf.AFInAppEventParameterName;
        if (aFb1oSDK != null) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            int i10 = AFLogger$LogLevel + 85;
            getLevel = i10 % 128;
            if (i10 % 2 != 0) {
                AFb1nSDK aFb1nSDK = aFb1oSDK.valueOf;
                if (aFb1nSDK != null) {
                    return aFb1nSDK.valueOf;
                }
            } else {
                AFb1nSDK aFb1nSDK2 = aFb1oSDK.valueOf;
                throw null;
            }
        }
        int i11 = AFLogger$LogLevel + 57;
        getLevel = i11 % 128;
        if (i11 % 2 == 0) {
            c10 = '%';
        } else {
            c10 = 'c';
        }
        if (c10 != '%') {
            return null;
        }
        int i12 = 5 / 0;
        return null;
    }

    private final AFb1fSDK afInfoLog() {
        int i10 = AFLogger$LogLevel + 81;
        getLevel = i10 % 128;
        int i11 = i10 % 2;
        AFb1fSDK aFb1fSDK = (AFb1fSDK) this.valueOf.getValue();
        int i12 = getLevel + 33;
        AFLogger$LogLevel = i12 % 128;
        if (i12 % 2 == 0) {
            return aFb1fSDK;
        }
        throw null;
    }

    private final ExecutorService afRDLog() {
        int i10 = AFLogger$LogLevel + 73;
        getLevel = i10 % 128;
        if (!(i10 % 2 == 0)) {
            return (ExecutorService) this.afInfoLog.getValue();
        }
        ExecutorService executorService = (ExecutorService) this.afInfoLog.getValue();
        throw null;
    }

    private final synchronized void afWarnLog() {
        String str;
        char c10;
        try {
            AFb1tSDK afErrorLogForExcManagerOnly = afErrorLogForExcManagerOnly();
            if (afErrorLogForExcManagerOnly != null) {
                str = afErrorLogForExcManagerOnly.AFInAppEventType;
                int i10 = getLevel + 117;
                AFLogger$LogLevel = i10 % 128;
                if (i10 % 2 != 0) {
                }
            } else {
                str = null;
                int i11 = AFLogger$LogLevel + 29;
                getLevel = i11 % 128;
                int i12 = i11 % 2;
            }
            if (str == null) {
                str = "";
            }
            int i13 = getLevel + 61;
            AFLogger$LogLevel = i13 % 128;
            int i14 = i13 % 2;
        } catch (NullPointerException unused) {
            str = "NOT_DETECTED";
        } catch (Throwable th2) {
            throw th2;
        }
        if (AFc1vSDK.AFa1wSDK.valueOf(str) != -1) {
            c10 = 27;
        } else {
            c10 = ' ';
        }
        if (c10 == ' ' || AFc1vSDK.AFa1wSDK.valueOf(str) > AFc1vSDK.AFa1wSDK.valueOf(AFLogger())) {
            afErrorLog().AFKeystoreWrapper("af_send_exc_to_server_window");
            AFKeystoreWrapper().AFInAppEventParameterName();
            return;
        }
        AFKeystoreWrapper().AFInAppEventType(AFLogger());
    }

    private AFc1vSDK getLevel() {
        int i10 = getLevel + 55;
        AFLogger$LogLevel = i10 % 128;
        if ((i10 % 2 != 0 ? '4' : '1') != '4') {
            AFc1vSDK aFc1vSDK = (AFc1vSDK) this.afErrorLog.getValue();
            int i11 = getLevel + 51;
            AFLogger$LogLevel = i11 % 128;
            if (!(i11 % 2 != 0)) {
                return aFc1vSDK;
            }
            throw null;
        }
        AFc1vSDK aFc1vSDK2 = (AFc1vSDK) this.afErrorLog.getValue();
        throw null;
    }

    private final AFb1vSDK values() {
        int i10 = getLevel + 85;
        AFLogger$LogLevel = i10 % 128;
        int i11 = i10 % 2;
        AFb1vSDK aFb1vSDK = (AFb1vSDK) this.values.getValue();
        int i12 = AFLogger$LogLevel + 49;
        getLevel = i12 % 128;
        if ((i12 % 2 == 0 ? 15 : ',') != 15) {
            return aFb1vSDK;
        }
        throw null;
    }

    public final AFc1zSDK AFKeystoreWrapper() {
        int i10 = AFLogger$LogLevel + 17;
        getLevel = i10 % 128;
        if ((i10 % 2 == 0 ? 'I' : 'H') == 'H') {
            return (AFc1zSDK) this.AFLogger.getValue();
        }
        AFc1zSDK aFc1zSDK = (AFc1zSDK) this.AFLogger.getValue();
        throw null;
    }

    public final void valueOf() {
        int i10 = AFLogger$LogLevel + 1;
        getLevel = i10 % 128;
        int i11 = i10 % 2;
        afRDLog().execute(new g(this));
        int i12 = AFLogger$LogLevel + 89;
        getLevel = i12 % 128;
        if (i12 % 2 == 0) {
            int i13 = 86 / 0;
        }
    }

    /* access modifiers changed from: private */
    public static final void AFKeystoreWrapper(AFc1wSDK aFc1wSDK) {
        int i10 = AFLogger$LogLevel + 113;
        getLevel = i10 % 128;
        if (i10 % 2 != 0) {
            j.g(aFc1wSDK, "");
            aFc1wSDK.AFVersionDeclaration();
            return;
        }
        j.g(aFc1wSDK, "");
        aFc1wSDK.AFVersionDeclaration();
        throw null;
    }

    /* access modifiers changed from: private */
    public static final void valueOf(AFc1wSDK aFc1wSDK) {
        int i10 = AFLogger$LogLevel + 13;
        getLevel = i10 % 128;
        if (!(i10 % 2 == 0)) {
            j.g(aFc1wSDK, "");
            aFc1wSDK.AFLogger$LogLevel();
            return;
        }
        j.g(aFc1wSDK, "");
        aFc1wSDK.AFLogger$LogLevel();
        throw null;
    }

    /* access modifiers changed from: private */
    public static final void values(AFc1wSDK aFc1wSDK) {
        int i10 = getLevel + 21;
        AFLogger$LogLevel = i10 % 128;
        int i11 = i10 % 2;
        j.g(aFc1wSDK, "");
        aFc1wSDK.afWarnLog();
        int i12 = AFLogger$LogLevel + 77;
        getLevel = i12 % 128;
        if (!(i12 % 2 != 0)) {
            throw null;
        }
    }

    public final void AFInAppEventParameterName(Throwable th2, String str) {
        int i10 = getLevel + 13;
        AFLogger$LogLevel = i10 % 128;
        int i11 = i10 % 2;
        j.g(th2, "");
        j.g(str, "");
        afRDLog().execute(new h(this, th2, str));
        int i12 = getLevel + 105;
        AFLogger$LogLevel = i12 % 128;
        int i13 = i12 % 2;
    }

    public final void AFInAppEventType() {
        int i10 = getLevel + 69;
        AFLogger$LogLevel = i10 % 128;
        if ((i10 % 2 != 0 ? 'A' : 'I') == 'I') {
            afRDLog().execute(new i(this));
            int i11 = AFLogger$LogLevel + 113;
            getLevel = i11 % 128;
            int i12 = i11 % 2;
            return;
        }
        afRDLog().execute(new i(this));
        throw null;
    }

    private final Map<String, String> AFKeystoreWrapper(AFb1tSDK aFb1tSDK) {
        Object[] objArr = new Object[1];
        AFKeystoreWrapper(new int[]{904326648, -1151615226, 559669833, 422288252}, 5 - TextUtils.indexOf("", "", 0), objArr);
        Map<String, String> l10 = h0.l(h.a(((String) objArr[0]).intern(), Build.BRAND), h.a(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL), h.a("app_id", afInfoLog().valueOf.values.getPackageName()), h.a("p_ex", new AFb1rSDK().values()), h.a("api", String.valueOf(Build.VERSION.SDK_INT)), h.a("sdk", AFLogger()), h.a("uid", AFb1xSDK.AFInAppEventParameterName(new WeakReference(afInfoLog().valueOf.values))), h.a("exc_config", aFb1tSDK.AFInAppEventType()));
        int i10 = getLevel + 23;
        AFLogger$LogLevel = i10 % 128;
        int i11 = i10 % 2;
        return l10;
    }

    private final void values(String str, String str2) {
        int i10 = getLevel + 99;
        AFLogger$LogLevel = i10 % 128;
        int i11 = i10 % 2;
        byte[] bytes = str.getBytes(d.f32216b);
        j.f(bytes, "");
        getLevel().values(bytes, g0.f(h.a("Authorization", AFa1aSDK.values(str, str2))), 2000);
        int i12 = AFLogger$LogLevel + 101;
        getLevel = i12 % 128;
        int i13 = i12 % 2;
    }

    public final void AFInAppEventParameterName() {
        int i10 = getLevel + 25;
        AFLogger$LogLevel = i10 % 128;
        int i11 = i10 % 2;
        afRDLog().execute(new f(this));
        int i12 = AFLogger$LogLevel + 89;
        getLevel = i12 % 128;
        if ((i12 % 2 == 0 ? '@' : 'C') != 'C') {
            int i13 = 5 / 0;
        }
    }

    private static Map<String, Object> AFInAppEventParameterName(Map<String, ? extends Object> map, List<AFb1aSDK> list) {
        Map<String, Object> map2;
        int i10 = getLevel + 5;
        AFLogger$LogLevel = i10 % 128;
        if (i10 % 2 == 0) {
            map2 = h0.l(h.a("deviceInfo", map), h.a("excs", AFc1vSDK.AFa1wSDK.valueOf(list)));
        } else {
            Pair[] pairArr = new Pair[4];
            pairArr[1] = h.a("deviceInfo", map);
            pairArr[1] = h.a("excs", AFc1vSDK.AFa1wSDK.valueOf(list));
            map2 = h0.l(pairArr);
        }
        int i11 = getLevel + 9;
        AFLogger$LogLevel = i11 % 128;
        int i12 = i11 % 2;
        return map2;
    }

    private final boolean AFInAppEventParameterName(AFb1tSDK aFb1tSDK) {
        long valueOf2 = afErrorLog().valueOf("af_send_exc_to_server_window", -1);
        if (valueOf2 != -1) {
            if ((valueOf2 < System.currentTimeMillis() ? PropertyUtils.MAPPED_DELIM2 : 4) == 4) {
                int AFInAppEventType2 = afErrorLog().AFInAppEventType("af_send_exc_min", -1);
                if ((AFInAppEventType2 != -1 ? 17 : '>') != '>') {
                    int i10 = AFLogger$LogLevel + 99;
                    getLevel = i10 % 128;
                    if (i10 % 2 == 0) {
                        AFKeystoreWrapper().valueOf();
                        throw null;
                    } else if (AFKeystoreWrapper().valueOf() >= AFInAppEventType2) {
                        String str = aFb1tSDK.AFInAppEventType;
                        j.f(str, "");
                        if (AFc1vSDK.AFa1wSDK.valueOf(str) == AFc1vSDK.AFa1wSDK.valueOf(AFLogger())) {
                            return true;
                        }
                        int i11 = getLevel + 69;
                        AFLogger$LogLevel = i11 % 128;
                        if ((i11 % 2 != 0 ? 23 : SignatureVisitor.SUPER) != 23) {
                            return false;
                        }
                        throw null;
                    }
                }
            }
        }
        return false;
    }

    private static void AFKeystoreWrapper(int[] iArr, int i10, Object[] objArr) {
        String str;
        synchronized (AFg1zSDK.AFInAppEventParameterName) {
            char[] cArr = new char[4];
            char[] cArr2 = new char[(iArr.length << 1)];
            int[] iArr2 = (int[]) afDebugLog.clone();
            AFg1zSDK.AFInAppEventType = 0;
            while (true) {
                int i11 = AFg1zSDK.AFInAppEventType;
                if (i11 < iArr.length) {
                    int i12 = iArr[i11];
                    char c10 = (char) (i12 >> 16);
                    cArr[0] = c10;
                    char c11 = (char) i12;
                    cArr[1] = c11;
                    char c12 = (char) (iArr[i11 + 1] >> 16);
                    cArr[2] = c12;
                    char c13 = (char) iArr[i11 + 1];
                    cArr[3] = c13;
                    AFg1zSDK.valueOf = (c10 << 16) + c11;
                    AFg1zSDK.values = (c12 << 16) + c13;
                    AFg1zSDK.AFInAppEventParameterName(iArr2);
                    for (int i13 = 0; i13 < 16; i13++) {
                        int i14 = AFg1zSDK.valueOf ^ iArr2[i13];
                        AFg1zSDK.valueOf = i14;
                        AFg1zSDK.values = AFg1zSDK.values(i14) ^ AFg1zSDK.values;
                        int i15 = AFg1zSDK.valueOf;
                        AFg1zSDK.valueOf = AFg1zSDK.values;
                        AFg1zSDK.values = i15;
                    }
                    int i16 = AFg1zSDK.valueOf;
                    AFg1zSDK.valueOf = AFg1zSDK.values;
                    AFg1zSDK.values = i16;
                    AFg1zSDK.values = i16 ^ iArr2[16];
                    AFg1zSDK.valueOf ^= iArr2[17];
                    int i17 = AFg1zSDK.AFInAppEventType;
                    int i18 = AFg1zSDK.valueOf;
                    cArr[0] = (char) (i18 >>> 16);
                    cArr[1] = (char) i18;
                    int i19 = AFg1zSDK.values;
                    cArr[2] = (char) (i19 >>> 16);
                    cArr[3] = (char) i19;
                    AFg1zSDK.AFInAppEventParameterName(iArr2);
                    int i20 = AFg1zSDK.AFInAppEventType;
                    cArr2[i20 << 1] = cArr[0];
                    cArr2[(i20 << 1) + 1] = cArr[1];
                    cArr2[(i20 << 1) + 2] = cArr[2];
                    cArr2[(i20 << 1) + 3] = cArr[3];
                    AFg1zSDK.AFInAppEventType = i20 + 2;
                } else {
                    str = new String(cArr2, 0, i10);
                }
            }
        }
        objArr[0] = str;
    }
}
