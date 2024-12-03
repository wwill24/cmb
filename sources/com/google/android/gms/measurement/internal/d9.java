package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzrd;
import java.util.HashMap;

public final class d9 extends a9 {
    d9(n9 n9Var) {
        super(n9Var);
    }

    private final String j(String str) {
        String w10 = this.f39651b.Z().w(str);
        if (TextUtils.isEmpty(w10)) {
            return (String) g3.f39841s.a((Object) null);
        }
        Uri parse = Uri.parse((String) g3.f39841s.a((Object) null));
        Uri.Builder buildUpon = parse.buildUpon();
        String authority = parse.getAuthority();
        buildUpon.authority(w10 + "." + authority);
        return buildUpon.build().toString();
    }

    public final c9 i(String str) {
        String str2;
        zzrd.zzc();
        c9 c9Var = null;
        if (this.f40059a.z().B((String) null, g3.f39842s0)) {
            this.f40059a.d().v().a("sgtm feature flag enabled.");
            q5 R = this.f39651b.V().R(str);
            if (R == null) {
                return new c9(j(str));
            }
            if (R.Q()) {
                this.f40059a.d().v().a("sgtm upload enabled in manifest.");
                zzff t10 = this.f39651b.Z().t(R.l0());
                if (t10 != null) {
                    String zzj = t10.zzj();
                    if (!TextUtils.isEmpty(zzj)) {
                        String zzi = t10.zzi();
                        o3 v10 = this.f40059a.d().v();
                        if (true != TextUtils.isEmpty(zzi)) {
                            str2 = "N";
                        } else {
                            str2 = "Y";
                        }
                        v10.c("sgtm configured with upload_url, server_info", zzj, str2);
                        if (TextUtils.isEmpty(zzi)) {
                            this.f40059a.b();
                            c9Var = new c9(zzj);
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.put("x-google-sgtm-server-info", zzi);
                            c9Var = new c9(zzj, hashMap);
                        }
                    }
                }
            }
            if (c9Var != null) {
                return c9Var;
            }
        }
        return new c9(j(str));
    }
}
