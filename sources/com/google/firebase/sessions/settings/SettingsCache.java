package com.google.firebase.sessions.settings;

import androidx.datastore.core.d;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.datastore.preferences.core.a;
import androidx.datastore.preferences.core.c;
import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;

@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 22\u00020\u0001:\u00012B\u0015\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020*¢\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J1\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\b\u0010\t\u001a\u0004\u0018\u00018\u0000H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015H@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0015H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010 J\u001d\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0013\u0010)\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b'\u0010(R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b.\u0010/\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache;", "", "Landroidx/datastore/preferences/core/a;", "preferences", "", "updateSessionConfigs", "T", "Landroidx/datastore/preferences/core/a$a;", "key", "value", "updateConfigValue", "(Landroidx/datastore/preferences/core/a$a;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "hasCacheExpired$com_google_firebase_firebase_sessions", "()Z", "hasCacheExpired", "sessionsEnabled", "()Ljava/lang/Boolean;", "", "sessionSamplingRate", "()Ljava/lang/Double;", "", "sessionRestartTimeout", "()Ljava/lang/Integer;", "enabled", "updateSettingsEnabled", "(Ljava/lang/Boolean;Lkotlin/coroutines/c;)Ljava/lang/Object;", "rate", "updateSamplingRate", "(Ljava/lang/Double;Lkotlin/coroutines/c;)Ljava/lang/Object;", "timeoutInSeconds", "updateSessionRestartTimeout", "(Ljava/lang/Integer;Lkotlin/coroutines/c;)Ljava/lang/Object;", "cacheDurationInSeconds", "updateSessionCacheDuration", "", "cacheUpdatedTime", "updateSessionCacheUpdatedTime", "(Ljava/lang/Long;Lkotlin/coroutines/c;)Ljava/lang/Object;", "removeConfigs$com_google_firebase_firebase_sessions", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "removeConfigs", "Landroidx/datastore/core/d;", "dataStore", "Landroidx/datastore/core/d;", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "sessionConfigs", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "<init>", "(Landroidx/datastore/core/d;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class SettingsCache {
    /* access modifiers changed from: private */
    @Deprecated
    public static final a.C0051a<Integer> CACHE_DURATION_SECONDS = c.d("firebase_sessions_cache_duration");
    /* access modifiers changed from: private */
    @Deprecated
    public static final a.C0051a<Long> CACHE_UPDATED_TIME = c.e("firebase_sessions_cache_updated_time");
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Deprecated
    public static final a.C0051a<Integer> RESTART_TIMEOUT_SECONDS = c.d("firebase_sessions_restart_timeout");
    /* access modifiers changed from: private */
    @Deprecated
    public static final a.C0051a<Double> SAMPLING_RATE = c.b(LocalOverrideSettings.SAMPLING_RATE);
    /* access modifiers changed from: private */
    @Deprecated
    public static final a.C0051a<Boolean> SESSIONS_ENABLED = c.a(LocalOverrideSettings.SESSIONS_ENABLED);
    @Deprecated
    public static final String TAG = "SettingsCache";
    /* access modifiers changed from: private */
    public final d<a> dataStore;
    private SessionConfigs sessionConfigs;

    @kotlin.coroutines.jvm.internal.d(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", l = {46}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, kotlin.coroutines.c<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ SettingsCache this$0;

        {
            this.this$0 = r1;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        public final Object invoke(k0 k0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            SettingsCache settingsCache;
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                SettingsCache settingsCache2 = this.this$0;
                b data = settingsCache2.dataStore.getData();
                this.L$0 = settingsCache2;
                this.label = 1;
                Object t10 = kotlinx.coroutines.flow.d.t(data, this);
                if (t10 == d10) {
                    return d10;
                }
                settingsCache = settingsCache2;
                obj = t10;
            } else if (i10 == 1) {
                settingsCache = (SettingsCache) this.L$0;
                g.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            settingsCache.updateSessionConfigs(((a) obj).d());
            return Unit.f32013a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00138\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache$Companion;", "", "Landroidx/datastore/preferences/core/a$a;", "", "SESSIONS_ENABLED", "Landroidx/datastore/preferences/core/a$a;", "getSESSIONS_ENABLED", "()Landroidx/datastore/preferences/core/a$a;", "", "SAMPLING_RATE", "getSAMPLING_RATE", "", "RESTART_TIMEOUT_SECONDS", "getRESTART_TIMEOUT_SECONDS", "CACHE_DURATION_SECONDS", "getCACHE_DURATION_SECONDS", "", "CACHE_UPDATED_TIME", "getCACHE_UPDATED_TIME", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a.C0051a<Integer> getCACHE_DURATION_SECONDS() {
            return SettingsCache.CACHE_DURATION_SECONDS;
        }

        public final a.C0051a<Long> getCACHE_UPDATED_TIME() {
            return SettingsCache.CACHE_UPDATED_TIME;
        }

        public final a.C0051a<Integer> getRESTART_TIMEOUT_SECONDS() {
            return SettingsCache.RESTART_TIMEOUT_SECONDS;
        }

        public final a.C0051a<Double> getSAMPLING_RATE() {
            return SettingsCache.SAMPLING_RATE;
        }

        public final a.C0051a<Boolean> getSESSIONS_ENABLED() {
            return SettingsCache.SESSIONS_ENABLED;
        }
    }

    public SettingsCache(d<a> dVar) {
        j.g(dVar, "dataStore");
        this.dataStore = dVar;
        Object unused = i.b((CoroutineContext) null, new AnonymousClass1(this, (kotlin.coroutines.c<? super AnonymousClass1>) null), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object updateConfigValue(androidx.datastore.preferences.core.a.C0051a<T> r6, T r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = (com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            gk.g.b(r8)     // Catch:{ IOException -> 0x0029 }
            goto L_0x0054
        L_0x0029:
            r6 = move-exception
            goto L_0x0047
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            gk.g.b(r8)
            androidx.datastore.core.d<androidx.datastore.preferences.core.a> r8 = r5.dataStore     // Catch:{ IOException -> 0x0029 }
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2     // Catch:{ IOException -> 0x0029 }
            r4 = 0
            r2.<init>(r7, r6, r5, r4)     // Catch:{ IOException -> 0x0029 }
            r0.label = r3     // Catch:{ IOException -> 0x0029 }
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.a(r8, r2, r0)     // Catch:{ IOException -> 0x0029 }
            if (r6 != r1) goto L_0x0054
            return r1
        L_0x0047:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to update cache config value: "
            r7.append(r8)
            r7.append(r6)
        L_0x0054:
            kotlin.Unit r6 = kotlin.Unit.f32013a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.updateConfigValue(androidx.datastore.preferences.core.a$a, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void updateSessionConfigs(a aVar) {
        this.sessionConfigs = new SessionConfigs((Boolean) aVar.b(SESSIONS_ENABLED), (Double) aVar.b(SAMPLING_RATE), (Integer) aVar.b(RESTART_TIMEOUT_SECONDS), (Integer) aVar.b(CACHE_DURATION_SECONDS), (Long) aVar.b(CACHE_UPDATED_TIME));
    }

    public final boolean hasCacheExpired$com_google_firebase_firebase_sessions() {
        SessionConfigs sessionConfigs2 = this.sessionConfigs;
        SessionConfigs sessionConfigs3 = null;
        if (sessionConfigs2 == null) {
            j.y("sessionConfigs");
            sessionConfigs2 = null;
        }
        Long cacheUpdatedTime = sessionConfigs2.getCacheUpdatedTime();
        SessionConfigs sessionConfigs4 = this.sessionConfigs;
        if (sessionConfigs4 == null) {
            j.y("sessionConfigs");
        } else {
            sessionConfigs3 = sessionConfigs4;
        }
        Integer cacheDuration = sessionConfigs3.getCacheDuration();
        if (cacheUpdatedTime == null || cacheDuration == null || (System.currentTimeMillis() - cacheUpdatedTime.longValue()) / ((long) 1000) >= ((long) cacheDuration.intValue())) {
            return true;
        }
        return false;
    }

    public final Object removeConfigs$com_google_firebase_firebase_sessions(kotlin.coroutines.c<? super Unit> cVar) {
        Object a10 = PreferencesKt.a(this.dataStore, new SettingsCache$removeConfigs$2(this, (kotlin.coroutines.c<? super SettingsCache$removeConfigs$2>) null), cVar);
        return a10 == b.d() ? a10 : Unit.f32013a;
    }

    public final Integer sessionRestartTimeout() {
        SessionConfigs sessionConfigs2 = this.sessionConfigs;
        if (sessionConfigs2 == null) {
            j.y("sessionConfigs");
            sessionConfigs2 = null;
        }
        return sessionConfigs2.getSessionRestartTimeout();
    }

    public final Double sessionSamplingRate() {
        SessionConfigs sessionConfigs2 = this.sessionConfigs;
        if (sessionConfigs2 == null) {
            j.y("sessionConfigs");
            sessionConfigs2 = null;
        }
        return sessionConfigs2.getSessionSamplingRate();
    }

    public final Boolean sessionsEnabled() {
        SessionConfigs sessionConfigs2 = this.sessionConfigs;
        if (sessionConfigs2 == null) {
            j.y("sessionConfigs");
            sessionConfigs2 = null;
        }
        return sessionConfigs2.getSessionEnabled();
    }

    public final Object updateSamplingRate(Double d10, kotlin.coroutines.c<? super Unit> cVar) {
        Object updateConfigValue = updateConfigValue(SAMPLING_RATE, d10, cVar);
        return updateConfigValue == b.d() ? updateConfigValue : Unit.f32013a;
    }

    public final Object updateSessionCacheDuration(Integer num, kotlin.coroutines.c<? super Unit> cVar) {
        Object updateConfigValue = updateConfigValue(CACHE_DURATION_SECONDS, num, cVar);
        return updateConfigValue == b.d() ? updateConfigValue : Unit.f32013a;
    }

    public final Object updateSessionCacheUpdatedTime(Long l10, kotlin.coroutines.c<? super Unit> cVar) {
        Object updateConfigValue = updateConfigValue(CACHE_UPDATED_TIME, l10, cVar);
        return updateConfigValue == b.d() ? updateConfigValue : Unit.f32013a;
    }

    public final Object updateSessionRestartTimeout(Integer num, kotlin.coroutines.c<? super Unit> cVar) {
        Object updateConfigValue = updateConfigValue(RESTART_TIMEOUT_SECONDS, num, cVar);
        return updateConfigValue == b.d() ? updateConfigValue : Unit.f32013a;
    }

    public final Object updateSettingsEnabled(Boolean bool, kotlin.coroutines.c<? super Unit> cVar) {
        Object updateConfigValue = updateConfigValue(SESSIONS_ENABLED, bool, cVar);
        return updateConfigValue == b.d() ? updateConfigValue : Unit.f32013a;
    }
}
