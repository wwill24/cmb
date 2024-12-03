package com.google.firebase.sessions.settings;

import android.content.Context;
import androidx.datastore.core.d;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.a;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.mparticle.identity.IdentityHttpResponse;
import d1.b;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.j;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.k0;
import tk.c;
import wk.l;
import yk.a;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aB1\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b\u0019\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\u00020\u000bH@ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u00068Fø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006&"}, d2 = {"Lcom/google/firebase/sessions/settings/SessionsSettings;", "", "", "samplingRate", "", "isValidSamplingRate", "Lyk/a;", "sessionRestartTimeout", "isValidSessionRestartTimeout-LRDsOJo", "(J)Z", "isValidSessionRestartTimeout", "", "updateSettings", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "localOverrideSettings", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "remoteSettings", "getSessionsEnabled", "()Z", "sessionsEnabled", "getSamplingRate", "()D", "getSessionRestartTimeout-UwyO8pc", "()J", "<init>", "(Lcom/google/firebase/sessions/settings/SettingsProvider;Lcom/google/firebase/sessions/settings/SettingsProvider;)V", "Landroid/content/Context;", "context", "Lkotlin/coroutines/CoroutineContext;", "blockingDispatcher", "backgroundDispatcher", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallationsApi", "Lcom/google/firebase/sessions/ApplicationInfo;", "appInfo", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class SessionsSettings {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String SESSION_CONFIGS_NAME = "firebase_session_settings";
    /* access modifiers changed from: private */
    @Deprecated
    public static final c<Context, d<a>> dataStore$delegate = PreferenceDataStoreDelegateKt.b(SESSION_CONFIGS_NAME, (b) null, (Function1) null, (k0) null, 14, (Object) null);
    private final SettingsProvider localOverrideSettings;
    private final SettingsProvider remoteSettings;

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/google/firebase/sessions/settings/SessionsSettings$Companion;", "", "Landroid/content/Context;", "Landroidx/datastore/core/d;", "Landroidx/datastore/preferences/core/a;", "dataStore$delegate", "Ltk/c;", "getDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/d;", "dataStore", "", "SESSION_CONFIGS_NAME", "Ljava/lang/String;", "<init>", "()V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
    private static final class Companion {
        static final /* synthetic */ l<Object>[] $$delegatedProperties = {kotlin.jvm.internal.l.h(new PropertyReference2Impl(Companion.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final d<a> getDataStore(Context context) {
            return (d) SessionsSettings.dataStore$delegate.getValue(context, $$delegatedProperties[0]);
        }
    }

    public SessionsSettings(SettingsProvider settingsProvider, SettingsProvider settingsProvider2) {
        j.g(settingsProvider, "localOverrideSettings");
        j.g(settingsProvider2, "remoteSettings");
        this.localOverrideSettings = settingsProvider;
        this.remoteSettings = settingsProvider2;
    }

    private final boolean isValidSamplingRate(double d10) {
        return 0.0d <= d10 && d10 <= 1.0d;
    }

    /* renamed from: isValidSessionRestartTimeout-LRDsOJo  reason: not valid java name */
    private final boolean m9isValidSessionRestartTimeoutLRDsOJo(long j10) {
        return yk.a.D(j10) && yk.a.y(j10);
    }

    public final double getSamplingRate() {
        Double samplingRate = this.localOverrideSettings.getSamplingRate();
        if (samplingRate != null) {
            double doubleValue = samplingRate.doubleValue();
            if (isValidSamplingRate(doubleValue)) {
                return doubleValue;
            }
        }
        Double samplingRate2 = this.remoteSettings.getSamplingRate();
        if (samplingRate2 == null) {
            return 1.0d;
        }
        double doubleValue2 = samplingRate2.doubleValue();
        if (isValidSamplingRate(doubleValue2)) {
            return doubleValue2;
        }
        return 1.0d;
    }

    /* renamed from: getSessionRestartTimeout-UwyO8pc  reason: not valid java name */
    public final long m10getSessionRestartTimeoutUwyO8pc() {
        yk.a r02 = this.localOverrideSettings.m11getSessionRestartTimeoutFghU774();
        if (r02 != null) {
            long M = r02.M();
            if (m9isValidSessionRestartTimeoutLRDsOJo(M)) {
                return M;
            }
        }
        yk.a r03 = this.remoteSettings.m11getSessionRestartTimeoutFghU774();
        if (r03 != null) {
            long M2 = r03.M();
            if (m9isValidSessionRestartTimeoutLRDsOJo(M2)) {
                return M2;
            }
        }
        a.C0403a aVar = yk.a.f33993b;
        return yk.c.o(30, DurationUnit.MINUTES);
    }

    public final boolean getSessionsEnabled() {
        Boolean sessionEnabled = this.localOverrideSettings.getSessionEnabled();
        if (sessionEnabled != null) {
            return sessionEnabled.booleanValue();
        }
        Boolean sessionEnabled2 = this.remoteSettings.getSessionEnabled();
        if (sessionEnabled2 != null) {
            return sessionEnabled2.booleanValue();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateSettings(kotlin.coroutines.c<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = (com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = new com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            gk.g.b(r6)
            goto L_0x005b
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0034:
            java.lang.Object r2 = r0.L$0
            com.google.firebase.sessions.settings.SessionsSettings r2 = (com.google.firebase.sessions.settings.SessionsSettings) r2
            gk.g.b(r6)
            goto L_0x004d
        L_0x003c:
            gk.g.b(r6)
            com.google.firebase.sessions.settings.SettingsProvider r6 = r5.localOverrideSettings
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.updateSettings(r0)
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r2 = r5
        L_0x004d:
            com.google.firebase.sessions.settings.SettingsProvider r6 = r2.remoteSettings
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.updateSettings(r0)
            if (r6 != r1) goto L_0x005b
            return r1
        L_0x005b:
            kotlin.Unit r6 = kotlin.Unit.f32013a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SessionsSettings.updateSettings(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SessionsSettings(Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo applicationInfo) {
        this(new LocalOverrideSettings(context), new RemoteSettings(coroutineContext2, firebaseInstallationsApi, applicationInfo, new RemoteSettingsFetcher(applicationInfo, coroutineContext, (String) null, 4, (DefaultConstructorMarker) null), Companion.getDataStore(context)));
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(coroutineContext, "blockingDispatcher");
        j.g(coroutineContext2, "backgroundDispatcher");
        j.g(firebaseInstallationsApi, "firebaseInstallationsApi");
        j.g(applicationInfo, "appInfo");
    }
}
