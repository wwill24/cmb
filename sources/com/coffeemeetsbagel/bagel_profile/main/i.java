package com.coffeemeetsbagel.bagel_profile.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityProfileEdit;
import com.coffeemeetsbagel.bagel_profile.main.d;
import com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory;
import com.coffeemeetsbagel.hidereport.main.HideReportComponentActivity;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import com.coffeemeetsbagel.match_view.MatchViewInteractor;
import com.coffeemeetsbagel.match_view.m;
import com.coffeemeetsbagel.match_view.u0;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.util.RequestCode;
import kotlin.jvm.internal.j;
import lc.a;
import org.jivesoftware.smack.packet.Message;
import qj.q;

public final class i extends u<GenericMatchContainerView, d.a, GenericMatchContainerV2Interactor> {

    /* renamed from: f  reason: collision with root package name */
    private final ViewGroup f11045f;

    /* renamed from: g  reason: collision with root package name */
    private u<?, ?, ?> f11046g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(GenericMatchContainerView genericMatchContainerView, d.a aVar, GenericMatchContainerV2Interactor genericMatchContainerV2Interactor, ViewGroup viewGroup) {
        super(genericMatchContainerView, aVar, genericMatchContainerV2Interactor);
        j.g(genericMatchContainerView, "view");
        j.g(aVar, "component");
        j.g(genericMatchContainerV2Interactor, "interactor");
        j.g(viewGroup, "parentViewGroup");
        this.f11045f = viewGroup;
    }

    private final int m() {
        u<?, ?, ?> uVar = this.f11046g;
        if (uVar == null || !(uVar instanceof u0)) {
            return 0;
        }
        j.e(uVar, "null cannot be cast to non-null type com.coffeemeetsbagel.match_view.MatchViewRouter");
        return ((MatchViewInteractor) ((u0) uVar).f()).L2();
    }

    private final void p() {
        if (this.f11046g != null) {
            View l10 = l();
            j.d(l10);
            u uVar = this.f11046g;
            j.d(uVar);
            ((GenericMatchContainerView) l10).removeView(uVar.l());
            b(this.f11046g);
        }
    }

    private final void r() {
        if (this.f11046g != null) {
            View l10 = l();
            j.d(l10);
            u uVar = this.f11046g;
            j.d(uVar);
            ((GenericMatchContainerView) l10).addView(uVar.l());
            a(this.f11046g);
        }
    }

    public final void n() {
        Intent intent = new Intent();
        intent.putExtra(Extra.VIEW_PAGER_POSITION, m());
        Intent intent2 = ((d.a) e()).n().getIntent();
        if (intent2 != null) {
            intent.putExtra(Extra.GIVE_TAKE_POSITION, intent2.getIntExtra(Extra.GIVE_TAKE_POSITION, 0));
        }
        ((d.a) e()).n().setResult(-1, intent);
    }

    public final void o(String str, boolean z10, boolean z11) {
        boolean z12;
        Intent intent = new Intent();
        if (str != null) {
            if (str.length() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                intent.putExtra(Extra.BAGEL_ID, str);
            }
        }
        intent.putExtra(Extra.WAS_REPORTED, z10);
        intent.putExtra(Extra.IS_CONNECTED, z11);
        ((d.a) e()).n().setResult(50, intent);
        ((d.a) e()).n().finish();
    }

    public final void q(String str, boolean z10, boolean z11) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(Extra.PROFILE_ID, str);
        bundle.putBoolean(Extra.WAS_REPORTED, z10);
        bundle.putBoolean(Extra.IS_CONNECTED, z11);
        intent.putExtras(bundle);
        ((d.a) e()).n().setResult(67, intent);
        ((d.a) e()).n().finish();
    }

    public final void s(ProfileCategory profileCategory, boolean z10) {
        String str;
        if (profileCategory == null) {
            str = "FRAGMENT_INDEX_PHOTOS";
        } else {
            str = "FRAGMENT_INDEX_DETAILS";
        }
        a.d(((d.a) e()).n(), ActivityProfileEdit.Y1(((d.a) e()).n(), str, profileCategory, z10), RequestCode.PROFILE_EDIT);
    }

    public final void t(String str, String str2, boolean z10, boolean z11, String str3, String str4) {
        j.g(str, "bagelId");
        j.g(str2, "profileId");
        j.g(str3, "source");
        j.g(str4, "matchType");
        HideReportComponentActivity.f13953j.a(((d.a) e()).n(), str2, str, z11, z10, str3, str4);
    }

    public final void u(String str, boolean z10, boolean z11, String str2, String str3) {
        j.g(str, "profileId");
        j.g(str2, "source");
        j.g(str3, "matchType");
        HideReportComponentActivity.f13953j.a(((d.a) e()).n(), str, (String) null, z11, z10, str2, str3);
    }

    public final void v() {
        if (((d.a) e()).n().getIntent() != null) {
            Intent intent = new Intent();
            intent.putExtra(Extra.GIVE_TAKE_POSITION, ((d.a) e()).n().getIntent().getIntExtra(Extra.GIVE_TAKE_POSITION, 0));
            intent.putExtra(Extra.VIEW_PAGER_POSITION, m());
            ((d.a) e()).n().setResult(68, intent);
            ((d.a) e()).n().finish();
        }
    }

    public final void w() {
        View findViewById = ((d.a) e()).n().getWindow().getDecorView().findViewById(16908290);
        j.f(findViewById, Message.Thread.PARENT_ATTRIBUTE_NAME);
        sb.a.i(findViewById, R.string.preferences_saved);
    }

    public final void x(Integer num, String str, MatchIdAttribution matchIdAttribution, boolean z10, String str2, boolean z11, MatchViewInteractor.b bVar, int i10, int i11, q<Boolean> qVar, boolean z12, String str3) {
        j.g(str, "profileId");
        j.g(bVar, "listener");
        j.g(qVar, "matchIsSeen");
        u<?, ?, ?> uVar = this.f11046g;
        if (uVar == null || !(uVar instanceof u0)) {
            p();
            m mVar = r1;
            b6.j e10 = e();
            j.f(e10, "component");
            m mVar2 = new m((m.c) e10);
            this.f11046g = m.c(mVar, this.f11045f, false, num, z12, matchIdAttribution, str, z10, str2, z11, bVar, qVar, i10, i11, false, str3, (String) null, 40960, (Object) null);
            r();
        }
    }

    public final void y() {
        if (((d.a) e()).n().getIntent() != null) {
            Intent intent = new Intent();
            intent.putExtra(Extra.GIVE_TAKE_POSITION, ((d.a) e()).n().getIntent().getIntExtra(Extra.GIVE_TAKE_POSITION, 0));
            intent.putExtra(Extra.VIEW_PAGER_POSITION, m());
            ((d.a) e()).n().setResult(64, intent);
            ((d.a) e()).n().finish();
        }
    }
}
