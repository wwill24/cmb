package com.coffeemeetsbagel.match;

import a7.a;
import gk.h;
import kotlin.jvm.internal.j;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    private final a f34526a;

    public z(a aVar) {
        j.g(aVar, "analyticsManager");
        this.f34526a = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r8, com.coffeemeetsbagel.models.Bagel r9, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            java.lang.String r0 = "bagel"
            kotlin.jvm.internal.j.g(r9, r0)
            java.lang.String r0 = "bagelAction"
            kotlin.jvm.internal.j.g(r10, r0)
            java.lang.String r0 = "source"
            kotlin.jvm.internal.j.g(r11, r0)
            int r1 = r9.getAction()
            com.coffeemeetsbagel.models.enums.BagelAction r2 = com.coffeemeetsbagel.models.enums.BagelAction.LIKE
            int r3 = r2.getId()
            if (r1 != r3) goto L_0x0028
            int r1 = r9.getPairAction()
            int r3 = r2.getId()
            if (r1 != r3) goto L_0x0028
            java.lang.String r1 = "connected"
            goto L_0x002a
        L_0x0028:
            java.lang.String r1 = "not connected"
        L_0x002a:
            int r3 = r9.getPairAction()
            int r4 = r2.getId()
            if (r3 != r4) goto L_0x004a
            java.lang.Integer r3 = r9.getPurchaseAttributionValue()
            com.coffeemeetsbagel.models.enums.PurchaseAttribution r4 = com.coffeemeetsbagel.models.enums.PurchaseAttribution.PAID_LIKE
            int r4 = r4.getPurchaseAttributionInteger()
            if (r3 != 0) goto L_0x0041
            goto L_0x004a
        L_0x0041:
            int r3 = r3.intValue()
            if (r3 != r4) goto L_0x004a
            java.lang.String r3 = "true"
            goto L_0x004c
        L_0x004a:
            java.lang.String r3 = "false"
        L_0x004c:
            int r4 = r9.getPairAction()
            int r2 = r2.getId()
            if (r4 != r2) goto L_0x0059
            java.lang.String r2 = "liked"
            goto L_0x0071
        L_0x0059:
            com.coffeemeetsbagel.models.enums.BagelAction r2 = com.coffeemeetsbagel.models.enums.BagelAction.CHECK
            int r2 = r2.getId()
            if (r4 != r2) goto L_0x0064
            java.lang.String r2 = "checked"
            goto L_0x0071
        L_0x0064:
            com.coffeemeetsbagel.models.enums.BagelAction r2 = com.coffeemeetsbagel.models.enums.BagelAction.PASS
            int r2 = r2.getId()
            if (r4 != r2) goto L_0x006f
            java.lang.String r2 = "passed"
            goto L_0x0071
        L_0x006f:
            java.lang.String r2 = "none"
        L_0x0071:
            r4 = 8
            kotlin.Pair[] r4 = new kotlin.Pair[r4]
            r5 = 0
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r6 = "is_subscriber"
            kotlin.Pair r8 = gk.h.a(r6, r8)
            r4[r5] = r8
            java.lang.String r8 = r9.getId()
            java.lang.String r5 = "bagel_id"
            kotlin.Pair r8 = gk.h.a(r5, r8)
            r5 = 1
            r4[r5] = r8
            r8 = 2
            java.lang.String r9 = r9.getProfileId()
            java.lang.String r6 = "bagel_profile_id"
            kotlin.Pair r9 = gk.h.a(r6, r9)
            r4[r8] = r9
            r8 = 3
            java.lang.String r9 = "connection state"
            kotlin.Pair r9 = gk.h.a(r9, r1)
            r4[r8] = r9
            r8 = 4
            java.lang.String r9 = "action"
            kotlin.Pair r9 = gk.h.a(r9, r10)
            r4[r8] = r9
            r8 = 5
            kotlin.Pair r9 = gk.h.a(r0, r11)
            r4[r8] = r9
            r8 = 6
            java.lang.String r9 = "received_paid_like"
            kotlin.Pair r9 = gk.h.a(r9, r3)
            r4[r8] = r9
            r8 = 7
            java.lang.String r9 = "pair_action"
            kotlin.Pair r9 = gk.h.a(r9, r2)
            r4[r8] = r9
            java.util.Map r8 = kotlin.collections.h0.l(r4)
            a7.a r9 = r7.f34526a
            java.lang.String r11 = "Bagel Action"
            r9.j(r11, r8)
            long r8 = java.lang.System.currentTimeMillis()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r9 = "user_action_timestamp"
            kotlin.Pair r8 = gk.h.a(r9, r8)
            java.util.Map r8 = kotlin.collections.g0.f(r8)
            java.lang.String r9 = "like"
            boolean r9 = kotlin.jvm.internal.j.b(r10, r9)
            if (r9 == 0) goto L_0x00ed
            goto L_0x00f3
        L_0x00ed:
            java.lang.String r9 = "paidlike"
            boolean r5 = kotlin.jvm.internal.j.b(r10, r9)
        L_0x00f3:
            if (r5 == 0) goto L_0x00fc
            a7.a r9 = r7.f34526a
            java.lang.String r10 = "bagel_liked_action"
            r9.trackEvent(r10, r8)
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.match.z.a(boolean, com.coffeemeetsbagel.models.Bagel, java.lang.String, java.lang.String):void");
    }

    public final void b(String str, String str2) {
        j.g(str, "source");
        j.g(str2, "action");
        if (j.b(str2, "like")) {
            str2 = "regular";
        } else if (j.b(str2, "paidlike")) {
            str2 = "flower";
        }
        if (j.b(str, "suggested_history")) {
            str = "suggested history";
        } else if (j.b(str, "discover_infinite_scroll")) {
            str = "discover scroll";
        }
        this.f34526a.trackEvent("like_profile", h0.l(h.a("source", str), h.a("type", str2), h.a("timestamp", String.valueOf(System.currentTimeMillis() / ((long) 1000)))));
    }
}
