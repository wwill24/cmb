package com.coffeemeetsbagel.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.fragments.d1;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.facebook.appevents.AppEventsLogger;
import com.uber.autodispose.a;
import com.uber.autodispose.p;
import j5.h;
import j5.x;
import lc.c;

public class ActivityCaption extends h {

    /* renamed from: w  reason: collision with root package name */
    private d1 f10836w;

    /* access modifiers changed from: private */
    public /* synthetic */ void C1() {
        c.e(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D1(x xVar) throws Exception {
        onBackPressed();
    }

    private void E1() {
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.setTitle("");
            this.f15597h.X();
            ((p) this.f15597h.T().g(a.a(this))).c(new b(this));
        }
    }

    public Fragment O0() {
        this.f10836w = new d1();
        this.f10836w.setArguments(getIntent().getExtras());
        return this.f10836w;
    }

    public String Z0() {
        return "KEY_CAPTION";
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f10836w = (d1) O0();
            getSupportFragmentManager().p().c(Y0(), this.f10836w, "FragmentCaption").i();
        } else if (m1(bundle, "FragmentCaption")) {
            this.f10836w = (d1) getSupportFragmentManager().s0(bundle, "FragmentCaption");
        } else {
            this.f10836w = (d1) O0();
            getSupportFragmentManager().p().c(Y0(), this.f10836w, "FragmentCaption").i();
        }
        E1();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(Bakery.w());
        new Handler().post(new a(this));
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        if (n1(this.f10836w)) {
            getSupportFragmentManager().i1(bundle, "FragmentCaption", this.f10836w);
        }
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    /* access modifiers changed from: protected */
    public boolean w1() {
        if (getIntent().getBooleanExtra(Extra.USE_2020_DESIGN_LANGUAGE, false) || !super.w1()) {
            return false;
        }
        return true;
    }

    public boolean x1() {
        return false;
    }
}
