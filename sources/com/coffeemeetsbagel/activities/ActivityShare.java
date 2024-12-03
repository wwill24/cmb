package com.coffeemeetsbagel.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.fragments.o5;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.facebook.internal.AnalyticsEvents;
import com.uber.autodispose.p;
import j5.h;
import j5.x;
import java.util.HashMap;
import org.jivesoftware.smackx.mam.element.MamElements;
import sj.a;

public class ActivityShare extends h {
    /* access modifiers changed from: private */
    public /* synthetic */ void C1(x xVar) throws Exception {
        onBackPressed();
    }

    public int B1() {
        return R.string.refer;
    }

    public Fragment O0() {
        return o5.L0(getIntent().getExtras());
    }

    public String Z0() {
        return "FragmentShare";
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 9000) {
            finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("request_code") && extras.getInt("request_code") == 9000) {
            HashMap hashMap = new HashMap();
            hashMap.put(MamElements.MamResultExtension.ELEMENT, AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
            Bakery.w().z().j("Give Composer", hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.X();
            ((p) this.f15597h.T().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new y(this));
            this.f15597h.setTitle(getResources().getString(B1()));
        }
    }
}
