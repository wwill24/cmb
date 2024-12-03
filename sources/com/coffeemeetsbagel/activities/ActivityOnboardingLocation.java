package com.coffeemeetsbagel.activities;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.uber.autodispose.p;
import g8.l;
import j5.m;
import j5.x;
import sj.a;

public class ActivityOnboardingLocation extends m {
    /* access modifiers changed from: private */
    public /* synthetic */ void U1(x xVar) throws Exception {
        onBackPressed();
    }

    public Fragment O0() {
        return new l();
    }

    /* access modifiers changed from: protected */
    public String Z0() {
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.X();
            ((p) this.f15597h.T().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new r(this));
            this.f15597h.setTitle(getResources().getString(R.string.location));
        }
    }
}
