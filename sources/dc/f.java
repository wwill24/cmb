package dc;

import b6.s;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.today_view.main.e;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.facebook.internal.ServerProtocol;
import dc.i;
import java.util.HashMap;
import jc.b;

public class f extends s<i, j> implements i.a {

    /* renamed from: f  reason: collision with root package name */
    ProfileContract$Manager f40596f;

    /* renamed from: g  reason: collision with root package name */
    e.a f40597g;

    /* renamed from: h  reason: collision with root package name */
    a7.a f40598h;

    class a implements b<Void> {
        a() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            ((i) f.this.f7875e).k();
            ((i) f.this.f7875e).o();
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            ((i) f.this.f7875e).k();
            f.this.f40597g.e();
        }
    }

    private void K1() {
        this.f40598h.trackEvent("Suggested - Account Paused - Unpause Tapped", M1());
    }

    private HashMap<String, String> M1() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.f40596f.j().getNumRisingBagels() > 0) {
            hashMap.put("has_rising_bagel", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        } else {
            hashMap.put("has_rising_bagel", "false");
        }
        return hashMap;
    }

    public void L1() {
        this.f40598h.trackEvent("Suggested - Account Paused - Viewed", M1());
    }

    /* access modifiers changed from: package-private */
    public void N1() {
        int numRisingBagels = this.f40596f.j().getNumRisingBagels();
        if (numRisingBagels <= 0) {
            ((i) this.f7875e).m();
        } else if (numRisingBagels == 1) {
            ((i) this.f7875e).n(R.string.paused_account_title_has_a_rising_bagel, (Integer) null);
        } else if (numRisingBagels < 6 || numRisingBagels == 10) {
            ((i) this.f7875e).n(R.string.paused_account_title_has_x_number_of_rising_bagel, Integer.valueOf(numRisingBagels));
        } else if (numRisingBagels < 10) {
            ((i) this.f7875e).n(R.string.paused_account_title_has_x_plus_number_of_rising_bagel, 5);
        } else {
            ((i) this.f7875e).n(R.string.paused_account_title_has_x_plus_number_of_rising_bagel, 10);
        }
    }

    public void y0() {
        ((i) this.f7875e).p();
        K1();
        this.f40596f.d(new a());
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        N1();
        L1();
        this.f40597g.c();
    }
}
