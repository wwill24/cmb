package com.coffeemeetsbagel.deactivate;

import android.os.Bundle;
import android.view.ViewGroup;
import b6.g;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.deactivate.q;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.view.CmbToolbar;
import j5.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class DeactivateScreenComponentActivity extends t<q, DeactivateCompRouter> {

    /* renamed from: m  reason: collision with root package name */
    public static final a f12008m = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public String K0() {
        return "DeactivateScreenComponentActivity";
    }

    /* access modifiers changed from: protected */
    public int Q0() {
        return R.string.settings_section_title_membership;
    }

    /* access modifiers changed from: protected */
    /* renamed from: S0 */
    public q G0() {
        return new q();
    }

    /* access modifiers changed from: protected */
    /* renamed from: T0 */
    public DeactivateCompRouter H0(ViewGroup viewGroup) {
        j.g(viewGroup, "parentViewGroup");
        boolean booleanExtra = getIntent().getBooleanExtra(Extra.IS_ACCOUNT_DELETION, false);
        g A0 = ((q) this.f7848e).A0();
        j.f(A0, "dependencyFragment.component");
        return new g((q.a) A0, booleanExtra).b(viewGroup);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CmbToolbar cmbToolbar = this.f15624j;
        if (cmbToolbar == null) {
            return;
        }
        if (!getIntent().getBooleanExtra(Extra.IS_ACCOUNT_DELETION, false)) {
            cmbToolbar.setTitle(getResources().getString(R.string.settings_section_title_membership));
        } else {
            cmbToolbar.setTitle(getResources().getString(R.string.account_delete));
        }
    }
}
