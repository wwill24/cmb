package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.messaging.Constants;

public final class z9 {

    /* renamed from: a  reason: collision with root package name */
    private final u4 f40478a;

    public z9(u4 u4Var) {
        this.f40478a = u4Var;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, Bundle bundle) {
        String str2;
        this.f40478a.f().h();
        if (!this.f40478a.o()) {
            if (bundle.isEmpty()) {
                str2 = null;
            } else {
                if (true == str.isEmpty()) {
                    str = "auto";
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String next : bundle.keySet()) {
                    builder.appendQueryParameter(next, bundle.getString(next));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f40478a.F().f39757v.b(str2);
                this.f40478a.F().f39758w.b(this.f40478a.a().currentTimeMillis());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        String str;
        this.f40478a.f().h();
        if (d()) {
            if (e()) {
                this.f40478a.F().f39757v.b((String) null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", SDKConstants.PARAM_INTENT);
                bundle.putLong("_cc", 1);
                this.f40478a.I().u("auto", "_cmpx", bundle);
            } else {
                String a10 = this.f40478a.F().f39757v.a();
                if (TextUtils.isEmpty(a10)) {
                    this.f40478a.d().t().a("Cache still valid but referrer not found");
                } else {
                    long a11 = this.f40478a.F().f39758w.a() / DateUtils.MILLIS_IN_HOUR;
                    Uri parse = Uri.parse(a10);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String next : parse.getQueryParameterNames()) {
                        bundle2.putString(next, parse.getQueryParameter(next));
                    }
                    ((Bundle) pair.second).putLong("_cc", (a11 - 1) * DateUtils.MILLIS_IN_HOUR);
                    Object obj = pair.first;
                    if (obj == null) {
                        str = "app";
                    } else {
                        str = (String) obj;
                    }
                    this.f40478a.I().u(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
                }
                this.f40478a.F().f39757v.b((String) null);
            }
            this.f40478a.F().f39758w.b(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (d() && e()) {
            this.f40478a.F().f39757v.b((String) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return this.f40478a.F().f39758w.a() > 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        if (d() && this.f40478a.a().currentTimeMillis() - this.f40478a.F().f39758w.a() > this.f40478a.z().r((String) null, g3.U)) {
            return true;
        }
        return false;
    }
}
