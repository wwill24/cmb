package com.coffeemeetsbagel.google_play;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.i;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class CmbBillingClient$observeSubscriptions$1 extends Lambda implements Function1<Pair<? extends i, ? extends List<? extends Purchase>>, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final CmbBillingClient$observeSubscriptions$1 f13916a = new CmbBillingClient$observeSubscriptions$1();

    CmbBillingClient$observeSubscriptions$1() {
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (r4 != false) goto L_0x0044;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(kotlin.Pair<com.android.billingclient.api.i, ? extends java.util.List<? extends com.android.billingclient.api.Purchase>> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "pair"
            kotlin.jvm.internal.j.g(r4, r0)
            java.lang.Object r0 = r4.c()
            com.android.billingclient.api.i r0 = (com.android.billingclient.api.i) r0
            int r0 = r0.b()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0043
            java.lang.Object r0 = r4.d()
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x0024
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r0 = r2
            goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            if (r0 != 0) goto L_0x0043
            java.lang.Object r4 = r4.d()
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L_0x003f
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.N(r4)
            com.android.billingclient.api.Purchase r4 = (com.android.billingclient.api.Purchase) r4
            if (r4 == 0) goto L_0x003f
            int r4 = r4.c()
            if (r1 != r4) goto L_0x003f
            r4 = r1
            goto L_0x0040
        L_0x003f:
            r4 = r2
        L_0x0040:
            if (r4 == 0) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r1 = r2
        L_0x0044:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.google_play.CmbBillingClient$observeSubscriptions$1.invoke(kotlin.Pair):java.lang.Boolean");
    }
}
