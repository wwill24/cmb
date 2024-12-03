package com.mparticle.networking;

import android.content.SharedPreferences;
import com.facebook.internal.security.CertificateUtil;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.networking.b;
import com.mparticle.u;
import java.io.IOException;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f22609a;

    protected a(SharedPreferences sharedPreferences) {
        this.f22609a = sharedPreferences;
    }

    public abstract u a(b.C0262b bVar, u uVar, String str, boolean z10) throws IOException;

    public void a(u uVar, b.C0262b bVar) {
        long j10;
        if (uVar != null) {
            String b10 = uVar.b("Retry-After");
            if (MPUtility.isEmpty((CharSequence) b10)) {
                b10 = uVar.b("retry-after");
            }
            try {
                long parseLong = Long.parseLong(b10) * 1000;
                if (parseLong > 0) {
                    j10 = Math.min(parseLong, 86400000);
                    a(bVar, System.currentTimeMillis() + j10);
                }
            } catch (NumberFormatException unused) {
                Logger.debug("Unable to parse retry-after header, using default.");
            }
        }
        j10 = 7200000;
        a(bVar, System.currentTimeMillis() + j10);
    }

    public void a(b.C0262b bVar, long j10) {
        SharedPreferences.Editor edit = this.f22609a.edit();
        edit.putLong(bVar.name() + CertificateUtil.DELIMITER + "mp::next_valid_request_time", j10).apply();
    }
}
