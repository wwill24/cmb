package com.coffeemeetsbagel.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory;
import com.coffeemeetsbagel.fragments.FragmentProfileEdit;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.material.tabs.TabLayout;
import com.uber.autodispose.p;
import h5.l;
import j5.m;
import j5.x;
import sj.a;
import x8.f;
import z9.i;

public class ActivityProfileEdit extends m implements i {
    private boolean B = true;
    private boolean C;
    public TabLayout D;
    private CmbLinearLayout E;
    public f F;

    /* renamed from: z  reason: collision with root package name */
    private FragmentProfileEdit f10869z;

    /* access modifiers changed from: private */
    public /* synthetic */ void W1(x xVar) throws Exception {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X1(x xVar) throws Exception {
        this.f10869z.b1();
    }

    public static Intent Y1(Context context, String str, ProfileCategory profileCategory, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putString(Extra.TAB_NAME, str);
        if (profileCategory != null) {
            bundle.putSerializable(Extra.PROFILE_CATEGORY, profileCategory);
        }
        bundle.putBoolean(Extra.IS_FROM_NUX, z10);
        Intent intent = new Intent(context, ActivityProfileEdit.class);
        intent.putExtras(bundle);
        return intent;
    }

    private void Z1() {
        if (this.F == null) {
            this.F = (f) getSupportFragmentManager().j0("DEPENDENCY_FRAGMENT_TAG");
        }
        if (this.F == null) {
            this.F = new f();
            getSupportFragmentManager().p().e(this.F, "DEPENDENCY_FRAGMENT_TAG").i();
        }
    }

    private void a2() {
        getSupportFragmentManager().p().y(this.f10869z).j();
        this.B = true;
    }

    /* access modifiers changed from: protected */
    public Fragment O0() {
        return null;
    }

    public void V(int i10) {
        View view = this.f10869z.getView();
        if (view != null) {
            view.clearFocus();
        }
        onBackPressed();
    }

    public void V1() {
        this.F.B0(this);
    }

    public int Y0() {
        return R.id.fragmentContainer;
    }

    /* access modifiers changed from: protected */
    public String Z0() {
        return null;
    }

    public int b1() {
        return R.layout.activity_profile_edit_dls;
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        c1().i(this, i10, i11, intent);
        l.h().onActivityResult(i10, i11, intent);
        if (i10 == 7002) {
            this.C = true;
        }
        this.f10869z.onActivityResult(i10, i11, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Z1();
        Intent intent = getIntent();
        if (bundle == null) {
            FragmentProfileEdit Z0 = FragmentProfileEdit.Z0(intent);
            this.f10869z = Z0;
            N0(Z0);
        } else {
            if (m1(bundle, "FragmentProfileEdit")) {
                this.f10869z = (FragmentProfileEdit) getSupportFragmentManager().s0(bundle, "FragmentProfileEdit");
            } else {
                this.f10869z = FragmentProfileEdit.Z0(intent);
            }
            this.B = bundle.getBoolean(Extra.IS_ON_EDIT);
            this.C = bundle.getBoolean(Extra.HAS_LOCATION_CHANGED, false);
        }
        this.D = (TabLayout) findViewById(R.id.tabLayout);
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.setTitle(getString(R.string.my_profile));
            this.f15597h.X();
            CmbLinearLayout cmbLinearLayout = (CmbLinearLayout) getLayoutInflater().inflate(R.layout.done_menu_item, this.f15597h, false);
            this.E = cmbLinearLayout;
            this.f15597h.C(cmbLinearLayout);
        }
        a2();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.V(this.E);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f10869z.c1(intent);
    }

    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("requestCode=");
        sb2.append(i10);
        sb2.append(", permissions=");
        sb2.append(strArr);
        sb2.append(", grantResults=");
        sb2.append(iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(Bakery.w());
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (n1(this.f10869z)) {
            getSupportFragmentManager().i1(bundle, "FragmentProfileEdit", this.f10869z);
        }
        bundle.putBoolean(Extra.IS_ON_EDIT, this.B);
        bundle.putBoolean(Extra.HAS_LOCATION_CHANGED, this.C);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            ((p) cmbToolbar.T().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new u(this));
            ((p) this.E.a().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new v(this));
        }
    }

    public boolean w1() {
        return true;
    }

    public boolean x1() {
        return false;
    }
}
