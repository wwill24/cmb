package com.mparticle.internal;

import android.content.Context;
import android.os.Looper;
import com.mparticle.MParticle;
import com.mparticle.b;
import com.mparticle.c;
import com.mparticle.d0;
import com.mparticle.internal.g;
import com.mparticle.internal.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

class i extends b {

    /* renamed from: d  reason: collision with root package name */
    private final Context f22480d;

    /* renamed from: e  reason: collision with root package name */
    d0 f22481e;

    /* renamed from: f  reason: collision with root package name */
    private final k f22482f;

    /* renamed from: g  reason: collision with root package name */
    String f22483g;

    /* renamed from: h  reason: collision with root package name */
    Integer f22484h;

    public i(Looper looper, k kVar, Context context, d0 d0Var, String str, Integer num) {
        super(looper);
        this.f22482f = kVar;
        this.f22480d = context;
        this.f22481e = d0Var;
        this.f22483g = str;
        this.f22484h = num;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:66|67|68|69|70) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:39|40|41|42|43|44|135) */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0113 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x01d4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.os.Message r13) {
        /*
            r12 = this;
            r0 = 0
            r1 = 1
            boolean r2 = r12.b()     // Catch:{ Exception -> 0x000f }
            if (r2 != 0) goto L_0x0009
            return
        L_0x0009:
            com.mparticle.internal.k r2 = r12.f22482f     // Catch:{ Exception -> 0x000f }
            r2.e()     // Catch:{ Exception -> 0x000f }
            goto L_0x001b
        L_0x000f:
            r2 = move-exception
            java.lang.String[] r3 = new java.lang.String[r1]
            java.lang.String r2 = r2.toString()
            r3[r0] = r2
            com.mparticle.internal.Logger.verbose(r3)
        L_0x001b:
            int r2 = r13.what
            java.lang.String r3 = "id"
            java.lang.String r4 = "Error updating session attributes in mParticle DB."
            java.lang.String r5 = "Unable to process uploads, API key and/or API Secret are missing."
            r6 = 2
            switch(r2) {
                case 0: goto L_0x0244;
                case 1: goto L_0x021e;
                case 2: goto L_0x01ff;
                case 3: goto L_0x017a;
                case 4: goto L_0x0128;
                case 5: goto L_0x00f7;
                case 6: goto L_0x0027;
                case 7: goto L_0x0027;
                case 8: goto L_0x0027;
                case 9: goto L_0x00d6;
                case 10: goto L_0x00b7;
                case 11: goto L_0x009c;
                case 12: goto L_0x0081;
                case 13: goto L_0x0060;
                case 14: goto L_0x0059;
                case 15: goto L_0x0029;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x02b3
        L_0x0029:
            java.lang.Object r13 = r13.obj     // Catch:{ b -> 0x004e, Exception -> 0x0043 }
            com.mparticle.s r13 = (com.mparticle.s) r13     // Catch:{ b -> 0x004e, Exception -> 0x0043 }
            com.mparticle.d0 r0 = r12.f22481e     // Catch:{ b -> 0x004e, Exception -> 0x0043 }
            com.mparticle.internal.k r1 = r12.f22482f     // Catch:{ b -> 0x004e, Exception -> 0x0043 }
            java.lang.String r1 = r1.d()     // Catch:{ b -> 0x004e, Exception -> 0x0043 }
            r0.a((java.lang.String) r1, (org.json.b) r13)     // Catch:{ b -> 0x004e, Exception -> 0x0043 }
            com.mparticle.MParticle r13 = com.mparticle.MParticle.getInstance()     // Catch:{ b -> 0x004e, Exception -> 0x0043 }
            if (r13 == 0) goto L_0x02b3
            r13.upload()     // Catch:{ b -> 0x004e, Exception -> 0x0043 }
            goto L_0x02b3
        L_0x0043:
            java.lang.String r13 = "Error sending Alias Request"
            java.lang.String[] r13 = new java.lang.String[]{r13}
            com.mparticle.internal.Logger.error(r13)
            goto L_0x02b3
        L_0x004e:
            java.lang.String r13 = "Unable to Alias Request, API key and or API Secret is missing"
            java.lang.String[] r13 = new java.lang.String[]{r13}
            com.mparticle.internal.Logger.error(r13)
            goto L_0x02b3
        L_0x0059:
            com.mparticle.internal.k r13 = r12.f22482f
            r13.a()
            goto L_0x02b3
        L_0x0060:
            com.mparticle.d0 r0 = r12.f22481e     // Catch:{ Exception -> 0x0077 }
            java.lang.Object r13 = r13.obj     // Catch:{ Exception -> 0x0077 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x0077 }
            com.mparticle.internal.k r2 = r12.f22482f     // Catch:{ Exception -> 0x0077 }
            com.mparticle.internal.c r2 = r2.b()     // Catch:{ Exception -> 0x0077 }
            android.content.Context r3 = r12.f22480d     // Catch:{ Exception -> 0x0077 }
            org.json.b r1 = r2.a((android.content.Context) r3, (boolean) r1)     // Catch:{ Exception -> 0x0077 }
            r0.b((java.lang.String) r13, (org.json.b) r1)     // Catch:{ Exception -> 0x0077 }
            goto L_0x02b3
        L_0x0077:
            r13 = move-exception
            java.lang.String[] r0 = new java.lang.String[]{r4}
            com.mparticle.internal.Logger.error(r13, r0)
            goto L_0x02b3
        L_0x0081:
            java.lang.Object r13 = r13.obj     // Catch:{ Exception -> 0x008a }
            com.mparticle.internal.j$b r13 = (com.mparticle.internal.j.b) r13     // Catch:{ Exception -> 0x008a }
            r12.a((com.mparticle.internal.j.b) r13)     // Catch:{ Exception -> 0x008a }
            goto L_0x02b3
        L_0x008a:
            r13 = move-exception
            java.lang.String[] r2 = new java.lang.String[r6]
            java.lang.String r3 = "Error while incrementing user attribute: "
            r2[r0] = r3
            java.lang.String r0 = r13.toString()
            r2[r1] = r0
            com.mparticle.internal.Logger.error(r13, r2)
            goto L_0x02b3
        L_0x009c:
            java.lang.Object r13 = r13.obj     // Catch:{ Exception -> 0x00a5 }
            com.mparticle.d0$f r13 = (com.mparticle.d0.f) r13     // Catch:{ Exception -> 0x00a5 }
            r12.a((com.mparticle.d0.f) r13)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x02b3
        L_0x00a5:
            r13 = move-exception
            java.lang.String[] r2 = new java.lang.String[r6]
            java.lang.String r3 = "Error while setting user attribute: "
            r2[r0] = r3
            java.lang.String r0 = r13.toString()
            r2[r1] = r0
            com.mparticle.internal.Logger.error(r13, r2)
            goto L_0x02b3
        L_0x00b7:
            com.mparticle.d0 r2 = r12.f22481e     // Catch:{ Exception -> 0x00c4 }
            java.lang.Object r13 = r13.obj     // Catch:{ Exception -> 0x00c4 }
            com.mparticle.d0$e r13 = (com.mparticle.d0.e) r13     // Catch:{ Exception -> 0x00c4 }
            com.mparticle.internal.k r3 = r12.f22482f     // Catch:{ Exception -> 0x00c4 }
            r2.a((com.mparticle.d0.e) r13, (com.mparticle.internal.k) r3)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x02b3
        L_0x00c4:
            r13 = move-exception
            java.lang.String[] r2 = new java.lang.String[r6]
            java.lang.String r3 = "Error while removing user attribute: "
            r2[r0] = r3
            java.lang.String r0 = r13.toString()
            r2[r1] = r0
            com.mparticle.internal.Logger.error(r13, r2)
            goto L_0x02b3
        L_0x00d6:
            java.lang.Object r13 = r13.obj     // Catch:{ Exception -> 0x00e5 }
            com.mparticle.internal.j$c r13 = (com.mparticle.internal.j.c) r13     // Catch:{ Exception -> 0x00e5 }
            com.mparticle.d0 r2 = r12.f22481e     // Catch:{ Exception -> 0x00e5 }
            java.util.List<? extends com.mparticle.internal.JsonReportingMessage> r3 = r13.f22510b     // Catch:{ Exception -> 0x00e5 }
            long r4 = r13.f22509a     // Catch:{ Exception -> 0x00e5 }
            r2.a((java.util.List<com.mparticle.internal.JsonReportingMessage>) r3, (long) r4)     // Catch:{ Exception -> 0x00e5 }
            goto L_0x02b3
        L_0x00e5:
            r13 = move-exception
            java.lang.String[] r2 = new java.lang.String[r6]
            java.lang.String r3 = "Error while inserting reporting messages: "
            r2[r0] = r3
            java.lang.String r0 = r13.toString()
            r2[r1] = r0
            com.mparticle.internal.Logger.verbose(r13, r2)
            goto L_0x02b3
        L_0x00f7:
            java.lang.Object r13 = r13.obj     // Catch:{ Exception -> 0x011c }
            com.mparticle.c r13 = (com.mparticle.c) r13     // Catch:{ Exception -> 0x011c }
            java.util.UUID r0 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x011c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x011c }
            r13.put((java.lang.String) r3, (java.lang.Object) r0)     // Catch:{ Exception -> 0x011c }
            com.mparticle.d0 r0 = r12.f22481e     // Catch:{ b -> 0x0113 }
            com.mparticle.internal.k r1 = r12.f22482f     // Catch:{ b -> 0x0113 }
            java.lang.String r1 = r1.d()     // Catch:{ b -> 0x0113 }
            r0.a((com.mparticle.c) r13, (java.lang.String) r1)     // Catch:{ b -> 0x0113 }
            goto L_0x02b3
        L_0x0113:
            java.lang.String[] r13 = new java.lang.String[]{r5}     // Catch:{ Exception -> 0x011c }
            com.mparticle.internal.Logger.error(r13)     // Catch:{ Exception -> 0x011c }
            goto L_0x02b3
        L_0x011c:
            r13 = move-exception
            java.lang.String r0 = "Error saving breadcrumb to mParticle DB."
            java.lang.String[] r0 = new java.lang.String[]{r0}
            com.mparticle.internal.Logger.error(r13, r0)
            goto L_0x02b3
        L_0x0128:
            java.lang.String r1 = "Ending orphaned sessions."
            java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            com.mparticle.internal.Logger.verbose(r1)     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            java.lang.Object r13 = r13.obj     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            com.mparticle.d0 r1 = r12.f22481e     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            com.mparticle.internal.k r2 = r12.f22482f     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            java.lang.String r2 = r2.d()     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            java.util.List r1 = r1.c((java.lang.String) r2)     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
        L_0x0145:
            boolean r2 = r1.hasNext()     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            if (r2 == 0) goto L_0x02b3
            java.lang.Object r2 = r1.next()     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            java.util.AbstractMap$SimpleEntry r3 = new java.util.AbstractMap$SimpleEntry     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            java.util.Set r4 = java.util.Collections.singleton(r13)     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            r3.<init>(r2, r4)     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            r2 = 3
            android.os.Message r2 = r12.obtainMessage(r2, r0, r0, r3)     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            r12.sendMessage(r2)     // Catch:{ b -> 0x016f, Exception -> 0x0163 }
            goto L_0x0145
        L_0x0163:
            r13 = move-exception
            java.lang.String r0 = "Error processing initialization in mParticle DB."
            java.lang.String[] r0 = new java.lang.String[]{r0}
            com.mparticle.internal.Logger.error(r13, r0)
            goto L_0x02b3
        L_0x016f:
            java.lang.String r13 = "Unable to process initialization, API key and or API Secret is missing."
            java.lang.String[] r13 = new java.lang.String[]{r13}
            com.mparticle.internal.Logger.error(r13)
            goto L_0x02b3
        L_0x017a:
            java.lang.Object r2 = r13.obj     // Catch:{ Exception -> 0x01f2 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ Exception -> 0x01f2 }
            r3 = 0
            java.lang.Object r4 = r2.getKey()     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x01f2 }
            com.mparticle.d0 r6 = r12.f22481e     // Catch:{ JSONException -> 0x019a }
            com.mparticle.internal.k r7 = r12.f22482f     // Catch:{ JSONException -> 0x019a }
            com.mparticle.internal.j r7 = (com.mparticle.internal.j) r7     // Catch:{ JSONException -> 0x019a }
            android.location.Location r7 = r7.k()     // Catch:{ JSONException -> 0x019a }
            java.lang.Object r2 = r2.getValue()     // Catch:{ JSONException -> 0x019a }
            java.util.Set r2 = (java.util.Set) r2     // Catch:{ JSONException -> 0x019a }
            com.mparticle.c r3 = r6.a((java.lang.String) r4, (android.location.Location) r7, (java.util.Set<java.lang.Long>) r2)     // Catch:{ JSONException -> 0x019a }
            goto L_0x01a3
        L_0x019a:
            java.lang.String r2 = "Failed to create mParticle session end message."
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x01f2 }
            com.mparticle.internal.Logger.warning(r2)     // Catch:{ Exception -> 0x01f2 }
        L_0x01a3:
            if (r3 == 0) goto L_0x01dc
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ b -> 0x01d4 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ b -> 0x01d4 }
            r6.<init>()     // Catch:{ b -> 0x01d4 }
            java.lang.String r7 = "Creating session end message for session ID: "
            r6.append(r7)     // Catch:{ b -> 0x01d4 }
            r6.append(r4)     // Catch:{ b -> 0x01d4 }
            java.lang.String r6 = r6.toString()     // Catch:{ b -> 0x01d4 }
            r2[r0] = r6     // Catch:{ b -> 0x01d4 }
            com.mparticle.internal.Logger.verbose(r2)     // Catch:{ b -> 0x01d4 }
            com.mparticle.d0 r0 = r12.f22481e     // Catch:{ b -> 0x01d4 }
            com.mparticle.internal.k r2 = r12.f22482f     // Catch:{ b -> 0x01d4 }
            java.lang.String r2 = r2.d()     // Catch:{ b -> 0x01d4 }
            java.lang.String r6 = r12.f22483g     // Catch:{ b -> 0x01d4 }
            java.lang.Integer r7 = r12.f22484h     // Catch:{ b -> 0x01d4 }
            r0.a((java.lang.String) r2, (com.mparticle.c) r3, (java.lang.String) r6, (java.lang.Integer) r7)     // Catch:{ b -> 0x01d4 }
            com.mparticle.d0 r0 = r12.f22481e     // Catch:{ b -> 0x01d4 }
            java.lang.String r2 = "1"
            r0.b((java.lang.String) r4, (java.lang.String) r2)     // Catch:{ b -> 0x01d4 }
            goto L_0x01e5
        L_0x01d4:
            java.lang.String[] r13 = new java.lang.String[]{r5}     // Catch:{ Exception -> 0x01f2 }
            com.mparticle.internal.Logger.error(r13)     // Catch:{ Exception -> 0x01f2 }
            return
        L_0x01dc:
            java.lang.String r0 = "Error creating session end, no entry for sessionId in mParticle DB."
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x01f2 }
            com.mparticle.internal.Logger.error(r0)     // Catch:{ Exception -> 0x01f2 }
        L_0x01e5:
            int r13 = r13.arg1     // Catch:{ Exception -> 0x01f2 }
            if (r13 != r1) goto L_0x02b3
            com.mparticle.internal.k r13 = r12.f22482f     // Catch:{ Exception -> 0x01f2 }
            r13.c()     // Catch:{ Exception -> 0x01f2 }
            goto L_0x02b3
        L_0x01f0:
            r13 = move-exception
            goto L_0x01fe
        L_0x01f2:
            r13 = move-exception
            java.lang.String r0 = "Error creating session end message in mParticle DB."
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ all -> 0x01f0 }
            com.mparticle.internal.Logger.error(r13, r0)     // Catch:{ all -> 0x01f0 }
            goto L_0x02b3
        L_0x01fe:
            throw r13
        L_0x01ff:
            java.lang.Object r13 = r13.obj     // Catch:{ Exception -> 0x0212 }
            com.mparticle.internal.InternalSession r13 = (com.mparticle.internal.InternalSession) r13     // Catch:{ Exception -> 0x0212 }
            com.mparticle.d0 r0 = r12.f22481e     // Catch:{ Exception -> 0x0212 }
            java.lang.String r1 = r13.mSessionID     // Catch:{ Exception -> 0x0212 }
            long r2 = r13.mLastEventTime     // Catch:{ Exception -> 0x0212 }
            long r4 = r13.getForegroundTime()     // Catch:{ Exception -> 0x0212 }
            r0.a((java.lang.String) r1, (long) r2, (long) r4)     // Catch:{ Exception -> 0x0212 }
            goto L_0x02b3
        L_0x0212:
            r13 = move-exception
            java.lang.String r0 = "Error updating session end time in mParticle DB."
            java.lang.String[] r0 = new java.lang.String[]{r0}
            com.mparticle.internal.Logger.error(r13, r0)
            goto L_0x02b3
        L_0x021e:
            java.lang.Object r13 = r13.obj     // Catch:{ Exception -> 0x023b }
            org.json.b r13 = (org.json.b) r13     // Catch:{ Exception -> 0x023b }
            java.lang.String r0 = "sid"
            java.lang.String r0 = r13.getString(r0)     // Catch:{ Exception -> 0x023b }
            java.lang.String r1 = "attrs"
            java.lang.String r13 = r13.optString(r1)     // Catch:{ Exception -> 0x023b }
            boolean r1 = com.mparticle.internal.MPUtility.isEmpty((java.lang.CharSequence) r13)     // Catch:{ Exception -> 0x023b }
            if (r1 != 0) goto L_0x02b3
            com.mparticle.d0 r1 = r12.f22481e     // Catch:{ Exception -> 0x023b }
            r1.a((java.lang.String) r0, (java.lang.String) r13)     // Catch:{ Exception -> 0x023b }
            goto L_0x02b3
        L_0x023b:
            r13 = move-exception
            java.lang.String[] r0 = new java.lang.String[]{r4}
            com.mparticle.internal.Logger.error(r13, r0)
            goto L_0x02b3
        L_0x0244:
            java.lang.Object r13 = r13.obj     // Catch:{ Exception -> 0x02a9 }
            com.mparticle.c r13 = (com.mparticle.c) r13     // Catch:{ Exception -> 0x02a9 }
            java.lang.String r0 = "cs"
            org.json.b r1 = com.mparticle.internal.j.n()     // Catch:{ Exception -> 0x02a9 }
            r13.put((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ Exception -> 0x02a9 }
            java.lang.String r0 = "dt"
            java.lang.String r0 = r13.getString(r0)     // Catch:{ Exception -> 0x02a9 }
            java.lang.String r1 = "ss"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x02a9 }
            if (r1 == 0) goto L_0x0263
            r12.a((com.mparticle.c) r13)     // Catch:{ Exception -> 0x02a9 }
            goto L_0x027f
        L_0x0263:
            com.mparticle.d0 r6 = r12.f22481e     // Catch:{ Exception -> 0x02a9 }
            java.lang.String r7 = r13.d()     // Catch:{ Exception -> 0x02a9 }
            java.lang.String r1 = "ct"
            long r8 = r13.getLong(r1)     // Catch:{ Exception -> 0x02a9 }
            r10 = 0
            r6.a((java.lang.String) r7, (long) r8, (long) r10)     // Catch:{ Exception -> 0x02a9 }
            java.util.UUID r1 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x02a9 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02a9 }
            r13.put((java.lang.String) r3, (java.lang.Object) r1)     // Catch:{ Exception -> 0x02a9 }
        L_0x027f:
            java.lang.String r1 = "x"
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x02a9 }
            if (r0 == 0) goto L_0x028c
            com.mparticle.d0 r0 = r12.f22481e     // Catch:{ Exception -> 0x02a9 }
            r0.a((com.mparticle.c) r13)     // Catch:{ Exception -> 0x02a9 }
        L_0x028c:
            com.mparticle.d0 r0 = r12.f22481e     // Catch:{ b -> 0x02a1 }
            com.mparticle.internal.k r1 = r12.f22482f     // Catch:{ b -> 0x02a1 }
            java.lang.String r1 = r1.d()     // Catch:{ b -> 0x02a1 }
            java.lang.String r2 = r12.f22483g     // Catch:{ b -> 0x02a1 }
            java.lang.Integer r3 = r12.f22484h     // Catch:{ b -> 0x02a1 }
            r0.a((java.lang.String) r1, (com.mparticle.c) r13, (java.lang.String) r2, (java.lang.Integer) r3)     // Catch:{ b -> 0x02a1 }
            com.mparticle.internal.k r0 = r12.f22482f     // Catch:{ Exception -> 0x02a9 }
            r0.a(r13)     // Catch:{ Exception -> 0x02a9 }
            goto L_0x02b3
        L_0x02a1:
            java.lang.String[] r13 = new java.lang.String[]{r5}     // Catch:{ Exception -> 0x02a9 }
            com.mparticle.internal.Logger.error(r13)     // Catch:{ Exception -> 0x02a9 }
            return
        L_0x02a9:
            r13 = move-exception
            java.lang.String r0 = "Error saving message to mParticle DB."
            java.lang.String[] r0 = new java.lang.String[]{r0}
            com.mparticle.internal.Logger.error(r13, r0)
        L_0x02b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.i.a(android.os.Message):void");
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        try {
            if (this.f22481e.c() != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            Logger.error("Database unavailable.");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(d0.f fVar) {
        for (d0.b a10 : this.f22481e.a(fVar)) {
            a(a10);
        }
    }

    private void a(j.b bVar) {
        Map<String, Object> c10 = this.f22481e.c(bVar.f22507b.longValue());
        if (c10.containsKey(bVar.f22506a) || !this.f22481e.b(bVar.f22507b.longValue()).containsKey(bVar.f22506a)) {
            String str = null;
            Object obj = c10.get(bVar.f22506a);
            if (obj == null) {
                str = bVar.f22508c.toString();
            } else if (obj instanceof Number) {
                str = MPUtility.addNumbers((Number) obj, bVar.f22508c).toString();
                Logger.info("incrementing attribute: \"" + bVar.f22506a + "\" from: " + obj + " by: " + bVar.f22508c + " to: " + str);
            }
            String str2 = str;
            d0.f fVar = new d0.f();
            HashMap hashMap = new HashMap(1);
            fVar.f22299a = hashMap;
            hashMap.put(bVar.f22506a, str2);
            fVar.f22302d = bVar.f22507b.longValue();
            for (d0.b a10 : this.f22481e.a(fVar)) {
                a(a10);
            }
            MParticle instance = MParticle.getInstance();
            if (instance != null && instance.Internal().c() != null) {
                instance.Internal().c().incrementUserAttribute(bVar.f22506a, bVar.f22508c, str2, bVar.f22507b.longValue());
                return;
            }
            return;
        }
        Logger.error("Error while attempting to increment user attribute - existing attribute is a list, which can't be incremented.");
    }

    private void a(c cVar) throws JSONException {
        try {
            c b10 = this.f22482f.b();
            this.f22481e.a(cVar, this.f22482f.d(), b10.a(this.f22480d), b10.b(this.f22480d));
        } catch (g.b unused) {
            Logger.error("Unable to process uploads, API key and/or API Secret are missing.");
        }
    }

    private void a(d0.b bVar) {
        this.f22482f.a(bVar.a(), bVar.c(), bVar.d(), bVar.f(), bVar.g(), bVar.e(), bVar.b());
    }
}
