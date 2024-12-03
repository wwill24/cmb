package com.withpersona.sdk2.inquiry.shared.device;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import td.a;
import td.b;
import td.c;

public final class RealAppSetIDHelper implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f27500a = "";

    /* access modifiers changed from: private */
    public static final void e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public void a(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        b a10 = a.a(context);
        j.f(a10, "getClient(context)");
        Task<c> appSetIdInfo = a10.getAppSetIdInfo();
        j.f(appSetIdInfo, "client.appSetIdInfo");
        appSetIdInfo.addOnSuccessListener(new d(new RealAppSetIDHelper$refreshAppSetId$1(this)));
    }

    public String b(Context context) {
        boolean z10;
        j.g(context, IdentityHttpResponse.CONTEXT);
        if (this.f27500a.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            a(context);
        }
        return this.f27500a;
    }
}
