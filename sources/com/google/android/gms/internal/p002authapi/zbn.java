package com.google.android.gms.internal.p002authapi;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.internal.p;
import fe.b;
import vd.a;

/* renamed from: com.google.android.gms.internal.auth-api.zbn  reason: invalid package */
public final class zbn {
    public static PendingIntent zba(Context context, a.C0509a aVar, HintRequest hintRequest, String str) {
        String str2;
        p.l(context, "context must not be null");
        p.l(hintRequest, "request must not be null");
        if (TextUtils.isEmpty(str)) {
            str2 = zbbb.zba();
        } else {
            str2 = (String) p.k(str);
        }
        Intent putExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("claimedCallingPackage", (String) null);
        putExtra.putExtra("logSessionId", str2);
        b.e(hintRequest, putExtra, "com.google.android.gms.credentials.HintRequest");
        return PendingIntent.getActivity(context, 2000, putExtra, zbbc.zba | 134217728);
    }
}
