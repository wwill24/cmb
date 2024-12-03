package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import org.json.b;

@d(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", l = {122, 125, 128, 130, 131, 133}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lorg/json/b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class RemoteSettings$updateSettings$2$1 extends SuspendLambda implements Function2<b, c<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, c<? super RemoteSettings$updateSettings$2$1> cVar) {
        super(2, cVar);
        this.this$0 = remoteSettings;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, cVar);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    public final Object invoke(b bVar, c<? super Unit> cVar) {
        return ((RemoteSettings$updateSettings$2$1) create(bVar, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d6, code lost:
        r12 = (java.lang.Integer) r7.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00da, code lost:
        if (r12 == null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00dc, code lost:
        r2 = r11.this$0;
        r12.intValue();
        r11.L$0 = r1;
        r11.L$1 = r0;
        r11.L$2 = null;
        r11.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f6, code lost:
        if (r2.settingsCache.updateSessionRestartTimeout((java.lang.Integer) r7.element, r11) != r4) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f8, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f9, code lost:
        r12 = (java.lang.Double) r1.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fd, code lost:
        if (r12 == null) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ff, code lost:
        r2 = r11.this$0;
        r12.doubleValue();
        r11.L$0 = r0;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0119, code lost:
        if (r2.settingsCache.updateSamplingRate((java.lang.Double) r1.element, r11) != r4) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011b, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x011c, code lost:
        r12 = (java.lang.Integer) r0.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0120, code lost:
        if (r12 == null) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0122, code lost:
        r1 = r11.this$0;
        r12.intValue();
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x013c, code lost:
        if (r1.settingsCache.updateSessionCacheDuration((java.lang.Integer) r0.element, r11) != r4) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013e, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013f, code lost:
        r12 = kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0142, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0143, code lost:
        if (r12 != null) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0145, code lost:
        r12 = r11.this$0.settingsCache;
        r0 = kotlin.coroutines.jvm.internal.a.b(86400);
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x015f, code lost:
        if (r12.updateSessionCacheDuration(r0, r11) != r4) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0161, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0162, code lost:
        r12 = r11.this$0.settingsCache;
        r0 = kotlin.coroutines.jvm.internal.a.c(java.lang.System.currentTimeMillis());
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x017d, code lost:
        if (r12.updateSessionCacheUpdatedTime(r0, r11) != r4) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017f, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0182, code lost:
        return kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.String r0 = "cache_duration"
            java.lang.String r1 = "session_timeout_seconds"
            java.lang.String r2 = "sampling_rate"
            java.lang.String r3 = "sessions_enabled"
            java.lang.Object r4 = kotlin.coroutines.intrinsics.b.d()
            int r5 = r11.label
            r6 = 0
            switch(r5) {
                case 0: goto L_0x0050;
                case 1: goto L_0x003f;
                case 2: goto L_0x0032;
                case 3: goto L_0x0029;
                case 4: goto L_0x0024;
                case 5: goto L_0x001f;
                case 6: goto L_0x001a;
                default: goto L_0x0012;
            }
        L_0x0012:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001a:
            gk.g.b(r12)
            goto L_0x0180
        L_0x001f:
            gk.g.b(r12)
            goto L_0x0162
        L_0x0024:
            gk.g.b(r12)
            goto L_0x013f
        L_0x0029:
            java.lang.Object r0 = r11.L$0
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref$ObjectRef) r0
            gk.g.b(r12)
            goto L_0x011c
        L_0x0032:
            java.lang.Object r0 = r11.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref$ObjectRef) r0
            java.lang.Object r1 = r11.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
            gk.g.b(r12)
            goto L_0x00f9
        L_0x003f:
            java.lang.Object r0 = r11.L$2
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref$ObjectRef) r0
            java.lang.Object r1 = r11.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
            java.lang.Object r2 = r11.L$0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            gk.g.b(r12)
            goto L_0x00d1
        L_0x0050:
            gk.g.b(r12)
            java.lang.Object r12 = r11.L$0
            org.json.b r12 = (org.json.b) r12
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            java.lang.String r9 = "app_quality"
            boolean r10 = r12.has(r9)
            if (r10 == 0) goto L_0x00b2
            java.lang.Object r12 = r12.get(r9)
            java.lang.String r9 = "null cannot be cast to non-null type org.json.JSONObject"
            kotlin.jvm.internal.j.e(r12, r9)
            org.json.b r12 = (org.json.b) r12
            boolean r9 = r12.has(r3)     // Catch:{ JSONException -> 0x00b2 }
            if (r9 == 0) goto L_0x0086
            java.lang.Object r3 = r12.get(r3)     // Catch:{ JSONException -> 0x00b2 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x00b2 }
            goto L_0x0087
        L_0x0086:
            r3 = r6
        L_0x0087:
            boolean r9 = r12.has(r2)     // Catch:{ JSONException -> 0x00b3 }
            if (r9 == 0) goto L_0x0095
            java.lang.Object r2 = r12.get(r2)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ JSONException -> 0x00b3 }
            r5.element = r2     // Catch:{ JSONException -> 0x00b3 }
        L_0x0095:
            boolean r2 = r12.has(r1)     // Catch:{ JSONException -> 0x00b3 }
            if (r2 == 0) goto L_0x00a3
            java.lang.Object r1 = r12.get(r1)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ JSONException -> 0x00b3 }
            r7.element = r1     // Catch:{ JSONException -> 0x00b3 }
        L_0x00a3:
            boolean r1 = r12.has(r0)     // Catch:{ JSONException -> 0x00b3 }
            if (r1 == 0) goto L_0x00b3
            java.lang.Object r12 = r12.get(r0)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ JSONException -> 0x00b3 }
            r8.element = r12     // Catch:{ JSONException -> 0x00b3 }
            goto L_0x00b3
        L_0x00b2:
            r3 = r6
        L_0x00b3:
            if (r3 == 0) goto L_0x00d4
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            r3.booleanValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.settingsCache
            r11.L$0 = r5
            r11.L$1 = r7
            r11.L$2 = r8
            r0 = 1
            r11.label = r0
            java.lang.Object r12 = r12.updateSettingsEnabled(r3, r11)
            if (r12 != r4) goto L_0x00ce
            return r4
        L_0x00ce:
            r2 = r5
            r1 = r7
            r0 = r8
        L_0x00d1:
            r7 = r1
            r1 = r2
            goto L_0x00d6
        L_0x00d4:
            r1 = r5
            r0 = r8
        L_0x00d6:
            T r12 = r7.element
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto L_0x00f9
            com.google.firebase.sessions.settings.RemoteSettings r2 = r11.this$0
            r12.intValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r2.settingsCache
            T r2 = r7.element
            java.lang.Integer r2 = (java.lang.Integer) r2
            r11.L$0 = r1
            r11.L$1 = r0
            r11.L$2 = r6
            r3 = 2
            r11.label = r3
            java.lang.Object r12 = r12.updateSessionRestartTimeout(r2, r11)
            if (r12 != r4) goto L_0x00f9
            return r4
        L_0x00f9:
            T r12 = r1.element
            java.lang.Double r12 = (java.lang.Double) r12
            if (r12 == 0) goto L_0x011c
            com.google.firebase.sessions.settings.RemoteSettings r2 = r11.this$0
            r12.doubleValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r2.settingsCache
            T r1 = r1.element
            java.lang.Double r1 = (java.lang.Double) r1
            r11.L$0 = r0
            r11.L$1 = r6
            r11.L$2 = r6
            r2 = 3
            r11.label = r2
            java.lang.Object r12 = r12.updateSamplingRate(r1, r11)
            if (r12 != r4) goto L_0x011c
            return r4
        L_0x011c:
            T r12 = r0.element
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto L_0x0142
            com.google.firebase.sessions.settings.RemoteSettings r1 = r11.this$0
            r12.intValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r1.settingsCache
            T r0 = r0.element
            java.lang.Integer r0 = (java.lang.Integer) r0
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 4
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheDuration(r0, r11)
            if (r12 != r4) goto L_0x013f
            return r4
        L_0x013f:
            kotlin.Unit r12 = kotlin.Unit.f32013a
            goto L_0x0143
        L_0x0142:
            r12 = r6
        L_0x0143:
            if (r12 != 0) goto L_0x0162
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.settingsCache
            r0 = 86400(0x15180, float:1.21072E-40)
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.a.b(r0)
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 5
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheDuration(r0, r11)
            if (r12 != r4) goto L_0x0162
            return r4
        L_0x0162:
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.settingsCache
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.a.c(r0)
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 6
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheUpdatedTime(r0, r11)
            if (r12 != r4) goto L_0x0180
            return r4
        L_0x0180:
            kotlin.Unit r12 = kotlin.Unit.f32013a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
