package a8;

import android.content.Context;
import android.text.TextUtils;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.util.StringUtils;
import z7.b;
import z7.c;

public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    private final c f197a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f198b;

    /* renamed from: c  reason: collision with root package name */
    private final ProfileContract$Manager f199c;

    /* renamed from: d  reason: collision with root package name */
    private NetworkProfile f200d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f201e;

    public i(c cVar, Context context, ProfileContract$Manager profileContract$Manager) {
        this.f197a = cVar;
        this.f198b = context;
        this.f199c = profileContract$Manager;
    }

    private boolean P() {
        NetworkProfile j10 = this.f199c.j();
        if (j10 != null) {
            return j10.isFemale();
        }
        return false;
    }

    private void S() {
        this.f197a.c(this.f199c.o(this.f198b, this.f200d));
    }

    private void V() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        if (StringUtils.isProfileStringComplete(this.f200d.getOccupation())) {
            sb2.append(this.f200d.getOccupation());
            z10 = true;
        } else {
            z10 = false;
        }
        if (StringUtils.isProfileStringComplete(this.f200d.getEmployer())) {
            if (z10) {
                sb2.append(", ");
            }
            sb2.append(this.f200d.getEmployer());
        }
        this.f197a.e(sb2.toString());
    }

    private void W() {
        StringBuilder sb2 = new StringBuilder();
        if (StringUtils.isProfileStringComplete(this.f200d.getAgeString())) {
            sb2.append(this.f200d.getAgeString());
        }
        if (StringUtils.isProfileStringComplete(this.f200d.getCity())) {
            if (!sb2.toString().equals("")) {
                sb2.append(", ");
            }
            sb2.append(this.f200d.getCity());
        } else if (StringUtils.isProfileStringComplete(this.f200d.getState())) {
            if (!sb2.toString().equals("")) {
                sb2.append(", ");
            }
            sb2.append(this.f200d.getState());
        } else if (StringUtils.isProfileStringComplete(this.f200d.getCountry())) {
            if (!sb2.toString().equals("")) {
                sb2.append(", ");
            }
            sb2.append(this.f200d.getCountry());
        }
        this.f197a.h(sb2.toString());
    }

    private void X(String str) {
        if (this.f201e) {
            this.f197a.a();
        } else if (!P() || str == null) {
            this.f197a.b();
        } else {
            this.f197a.g();
        }
    }

    public void C(NetworkProfile networkProfile, boolean z10, int i10, int i11, int i12, String str, String str2, RisingGiveTake risingGiveTake) {
        this.f200d = networkProfile;
        this.f201e = z10;
        W();
        V();
        S();
        X(str2);
        if (risingGiveTake == null || TextUtils.isEmpty(risingGiveTake.getPairLikeComment())) {
            this.f197a.d();
            return;
        }
        this.f197a.f(String.format(this.f198b.getResources().getString(R.string.like_comment_with_quotations), new Object[]{risingGiveTake.getPairLikeComment()}));
    }

    public void start() {
    }
}
