package e9;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.coffeemeetsbagel.activities.OutageModeActivity;
import com.coffeemeetsbagel.analytics_common.AnalyticsConstants$Logout;
import com.coffeemeetsbagel.bakery.i1;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.VerificationStatus;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import lc.g;
import okhttp3.a0;
import okhttp3.u;
import okhttp3.y;
import y7.a;

public class c implements u {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14611a;

    /* renamed from: b  reason: collision with root package name */
    private final d7.c f14612b;

    /* renamed from: c  reason: collision with root package name */
    private final a f14613c;

    /* renamed from: d  reason: collision with root package name */
    private final hb.c f14614d;

    /* renamed from: e  reason: collision with root package name */
    private final r f14615e;

    public c(Context context, d7.c cVar, a aVar, hb.c cVar2, r rVar) {
        this.f14611a = context;
        this.f14612b = cVar;
        this.f14613c = aVar;
        this.f14614d = cVar2;
        this.f14615e = rVar;
    }

    private void d(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(Extra.PURGE_HEADER, str);
        this.f14613c.b(EventType.PURGE_LOCAL_DATABASE, bundle);
    }

    private void e(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(Extra.UPGRADE_AVAILABILITY, str);
        this.f14613c.b(EventType.UPGRADE_AVAILABLE, bundle);
    }

    public String a(a0 a0Var) {
        if (!g.c() || !this.f14614d.p("key_is_force_purge_header_present")) {
            return a0Var.k("purge-local-database");
        }
        return this.f14614d.r("key_purge_header_content");
    }

    public void b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            e(str);
        } else if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Server asked for database #purge with #header=");
            sb2.append(str2);
            Set z10 = this.f14614d.z("previous_purge_headers");
            if (z10 == null) {
                z10 = new HashSet();
            }
            if (!z10.contains(str2)) {
                d(str2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(String str, a0 a0Var) {
        String str2;
        BannedReason bannedReason = BannedReason.NONE;
        VerificationStatus verificationStatus = VerificationStatus.NONE;
        if (a0Var.f() == 401) {
            try {
                str2 = a0Var.a().string();
            } catch (IOException e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("logOutOrCloseApp():");
                sb2.append(e10);
                str2 = "";
            }
            bannedReason = BannedReason.Companion.fromJsonString(str2);
            verificationStatus = VerificationStatus.Companion.fromJsonString(str2);
        }
        BannedReason bannedReason2 = bannedReason;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("logOutOrCloseApp(): ");
        sb3.append(bannedReason2.getApiReason());
        d7.c cVar = this.f14612b;
        Context context = this.f14611a;
        AnalyticsConstants$Logout analyticsConstants$Logout = AnalyticsConstants$Logout.AUTOMATIC;
        cVar.a(context, analyticsConstants$Logout, bannedReason2, verificationStatus, "Status Code Unauthorized 401: " + str);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        r rVar = this.f14615e;
        if (rVar != null && rVar.a("NoLogoutMaintenance.Android")) {
            OutageModeActivity.I0(this.f14611a);
        }
    }

    public a0 intercept(u.a aVar) throws IOException {
        y g10 = aVar.g();
        a0 a10 = aVar.a(g10);
        b(a10.k("upgrade-available"), a(a10));
        int f10 = a10.f();
        if (i1.e(f10)) {
            f();
        } else if (f10 == 401) {
            String tVar = g10.j().toString();
            if (!tVar.contains("/authenticate") && !tVar.contains("/analytics")) {
                c(tVar, a10);
            }
        }
        return a10;
    }
}
