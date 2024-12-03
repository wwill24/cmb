package com.coffeemeetsbagel.activities;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.fragments.i5;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.uber.autodispose.p;
import j5.h;
import j5.x;
import sj.a;

public class ActivityPhotoSelectProfile extends h {
    /* access modifiers changed from: private */
    public /* synthetic */ void C1(x xVar) throws Exception {
        onBackPressed();
    }

    public int B1() {
        return R.string.select_profile_photo;
    }

    public Fragment O0() {
        i5 i5Var = new i5();
        i5Var.setArguments(getIntent().getExtras());
        return i5Var;
    }

    public String Z0() {
        return "KEY_PHOTO_SELECT_PROFILE";
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1003 && i11 == -1) {
            setResult(i11, intent);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.X();
            this.f15597h.setTitle(getString(B1()));
            ((p) this.f15597h.T().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new t(this));
        }
    }
}
