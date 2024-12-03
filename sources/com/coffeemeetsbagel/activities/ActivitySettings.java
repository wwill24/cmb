package com.coffeemeetsbagel.activities;

import a7.a;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.fragments.l5;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.uber.autodispose.p;
import j5.h;
import j5.x;

public class ActivitySettings extends h {

    /* renamed from: w  reason: collision with root package name */
    private boolean f10870w;

    /* renamed from: x  reason: collision with root package name */
    a f10871x;

    /* access modifiers changed from: private */
    public /* synthetic */ void B1(x xVar) throws Exception {
        onBackPressed();
    }

    public void C1(boolean z10) {
        this.f10870w = z10;
    }

    public Fragment O0() {
        return new l5();
    }

    public String Z0() {
        return "FragmentSettings";
    }

    public void onBackPressed() {
        if (this.f10870w) {
            setResult(51);
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().M1(this);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f10871x.f("Settings");
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.setTitle(getString(R.string.settings));
            this.f15597h.X();
            ((p) this.f15597h.T().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new w(this));
        }
    }
}
