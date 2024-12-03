package com.coffeemeetsbagel.activities;

import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.uber.autodispose.p;
import g8.l;
import j5.m;
import j5.x;
import sj.a;

public class ActivityLocation extends m {
    /* access modifiers changed from: private */
    public /* synthetic */ void V1(x xVar) throws Exception {
        onBackPressed();
    }

    public Fragment O0() {
        return new l();
    }

    public int U1() {
        return R.string.my_location;
    }

    public String Z0() {
        return "KEY_LOCATION";
    }

    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        super.onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.X();
            ((p) this.f15597h.T().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new e(this));
            this.f15597h.setTitle(getResources().getString(U1()));
        }
    }
}
