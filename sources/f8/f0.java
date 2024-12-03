package f8;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.dialogs.p;
import com.coffeemeetsbagel.feature.likepassflow.ActivityLikePassFlow;
import com.coffeemeetsbagel.models.Height;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.enums.EventType;
import h5.i;
import j5.n;
import lc.c;
import sb.a;

public class f0 extends n {

    /* renamed from: k  reason: collision with root package name */
    private Dialog f14885k;

    /* renamed from: l  reason: collision with root package name */
    private Dialog f14886l;

    /* renamed from: m  reason: collision with root package name */
    private CmbTextView f14887m;

    /* renamed from: n  reason: collision with root package name */
    private int f14888n;

    /* renamed from: p  reason: collision with root package name */
    private int f14889p;

    /* renamed from: q  reason: collision with root package name */
    private int f14890q;

    /* renamed from: t  reason: collision with root package name */
    private NetworkProfile f14891t;

    /* renamed from: w  reason: collision with root package name */
    private View f14892w;

    public static boolean Z0() {
        return Bakery.w().G().j().getHeightFeet() > 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b1(Height height) {
        c.h(this.f14885k);
        this.f14888n = height.getHeightFeet();
        this.f14889p = height.getHeightInches();
        this.f14890q = height.getHeightCentimetres();
        this.f14887m.setText(getString(R.string.height_feet_and_inches_format, Integer.valueOf(this.f14888n), Integer.valueOf(this.f14889p)));
        f1(height);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c1(Height height) {
        c.h(this.f14886l);
        this.f14888n = height.getHeightFeet();
        this.f14889p = height.getHeightInches();
        int heightCentimetres = height.getHeightCentimetres();
        this.f14890q = heightCentimetres;
        this.f14887m.setText(getString(R.string.height_metric_format, Integer.valueOf(heightCentimetres)));
        f1(height);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d1(View view) {
        g1();
    }

    private boolean e1() {
        NetworkProfile networkProfile = this.f14891t;
        if (networkProfile == null || networkProfile.getHeightCm() > 0 || this.f14891t.getHeightFeet() > 0 || this.f14891t.getHeightInches() > 0 || !TextUtils.isEmpty(this.f14887m.getText())) {
            return false;
        }
        return true;
    }

    private void f1(Height height) {
        boolean z10;
        M0().j().setHeight(height);
        NetworkProfile networkProfile = this.f14891t;
        if (networkProfile != null) {
            z10 = networkProfile.isHeightUnitMetric();
        } else {
            z10 = false;
        }
        ((ActivityLikePassFlow) requireActivity()).Y().updateHeight(height, z10);
        i.b(EventType.HEIGHT_UPDATED);
        i.b(EventType.PROFILE_UPDATE);
        this.f15615d.next();
    }

    private void g1() {
        if (this.f14891t.isHeightUnitMetric()) {
            if (!this.f14886l.isShowing()) {
                this.f14886l.show();
            }
        } else if (!this.f14885k.isShowing()) {
            this.f14885k.show();
        }
    }

    /* access modifiers changed from: protected */
    public String Q0() {
        return "Height";
    }

    public void T0() {
        super.T0();
        if (e1()) {
            g1();
        }
    }

    public void V0() {
        C0().f("Onboarding - Height");
    }

    public boolean b0(boolean z10) {
        if (this.f14888n > 0) {
            return true;
        }
        if (!z10) {
            return false;
        }
        a.k(this.f14892w, R.string.error_height_required);
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f14891t = M0().j();
        } else {
            this.f14891t = (NetworkProfile) bundle.getSerializable(n.f15614j);
        }
        NetworkProfile networkProfile = this.f14891t;
        if (networkProfile != null) {
            this.f14888n = networkProfile.getHeightFeet();
            this.f14889p = this.f14891t.getHeightInches();
            this.f14890q = this.f14891t.getHeightCm();
        }
        Height height = new Height(this.f14888n, this.f14889p);
        this.f14885k = new com.coffeemeetsbagel.dialogs.n(requireActivity(), height, new c0(this));
        this.f14886l = new p(requireActivity(), height, new d0(this));
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_profile_height_dls, viewGroup, false);
        this.f14892w = inflate;
        CmbTextView cmbTextView = (CmbTextView) inflate.findViewById(R.id.edit_profile_field_height);
        this.f14887m = cmbTextView;
        cmbTextView.setOnClickListener(new e0(this));
        return this.f14892w;
    }

    public void onPause() {
        super.onPause();
        c.i(this.f14885k, this.f14886l);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(n.f15614j, this.f14891t);
    }
}
