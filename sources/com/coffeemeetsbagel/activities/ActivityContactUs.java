package com.coffeemeetsbagel.activities;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import com.coffeemeetsbagel.fragments.ContactUsFragment;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.facebook.appevents.AppEventsLogger;
import com.uber.autodispose.p;
import j5.h;
import j5.x;
import lc.c;
import sj.a;

public class ActivityContactUs extends h {

    /* renamed from: w  reason: collision with root package name */
    private ContactUsFragment f10837w;

    /* renamed from: x  reason: collision with root package name */
    private CmbLinearLayout f10838x;

    /* renamed from: y  reason: collision with root package name */
    private CmbImageView f10839y;

    /* access modifiers changed from: private */
    public /* synthetic */ void C1(x xVar) throws Exception {
        this.f10837w.B0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D1(x xVar) throws Exception {
        onBackPressed();
    }

    public void E1(boolean z10) {
        int i10;
        CmbImageView cmbImageView = this.f10839y;
        if (cmbImageView != null) {
            Resources resources = getResources();
            if (z10) {
                i10 = R.color.main_color;
            } else {
                i10 = R.color.gray;
            }
            cmbImageView.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(i10)));
        }
    }

    public Fragment O0() {
        this.f10837w = new ContactUsFragment();
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("source")) {
            this.f10837w.setArguments(extras);
        }
        Bakery.j().N1(this.f10837w);
        return this.f10837w;
    }

    public String Z0() {
        return "KEY_CONTACT_US";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15598j = false;
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.setTitle(getString(R.string.contact_us));
            CmbLinearLayout cmbLinearLayout = (CmbLinearLayout) getLayoutInflater().inflate(R.layout.send_menu_item, this.f15597h, false);
            this.f10838x = cmbLinearLayout;
            this.f10839y = (CmbImageView) cmbLinearLayout.findViewById(R.id.send_menu_icon);
            ((p) this.f10838x.a().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new c(this));
            this.f15597h.C(this.f10838x);
            this.f15597h.X();
            ((p) this.f15597h.T().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new d(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(Bakery.w());
        c.e(this);
    }
}
