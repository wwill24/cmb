package com.coffemeetsbagel.hide_report;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import b6.u;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffemeetsbagel.hide_report.i;
import com.coffemeetsbagel.hide_report.list.f;
import com.coffemeetsbagel.hide_report.list.m;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.jingle.element.JingleReason;
import rc.a;

public final class w extends u<View, i.a, HideReportMainInteractor> {

    /* renamed from: f  reason: collision with root package name */
    private final a f37723f;

    /* renamed from: g  reason: collision with root package name */
    private u<?, ?, ?> f37724g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(a aVar, i.a aVar2, HideReportMainInteractor hideReportMainInteractor) {
        super(aVar.getRoot(), aVar2, hideReportMainInteractor);
        j.g(aVar, "binding");
        j.g(aVar2, "component");
        j.g(hideReportMainInteractor, "interactor");
        this.f37723f = aVar;
    }

    private final void r(u<?, ?, ?> uVar) {
        u<?, ?, ?> uVar2 = this.f37724g;
        if (uVar2 != null) {
            b(uVar2);
            this.f37723f.f41817c.removeAllViews();
        }
        this.f37724g = uVar;
        a(uVar);
        FrameLayout frameLayout = this.f37723f.f41817c;
        u uVar3 = this.f37724g;
        j.d(uVar3);
        frameLayout.addView(uVar3.l());
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        if (p()) {
            return super.h();
        }
        ((HideReportMainInteractor) f()).k0();
        return true;
    }

    public final void m(String str, boolean z10, boolean z11) {
        j.g(str, "bagelId");
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        bundle.putString(Extra.BAGEL_ID, str);
        bundle.putBoolean(Extra.WAS_REPORTED, !z10);
        bundle.putBoolean(Extra.IS_CONNECTED, z11);
        intent.putExtras(bundle);
        ((i.a) e()).a().setResult(50, intent);
        ((i.a) e()).a().finish();
    }

    public final void n() {
        ((i.a) e()).a().onBackPressed();
    }

    public final void o(String str, boolean z10, boolean z11) {
        j.g(str, "profileId");
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        bundle.putString(Extra.PROFILE_ID, str);
        bundle.putBoolean(Extra.WAS_REPORTED, !z10);
        bundle.putBoolean(Extra.IS_CONNECTED, z11);
        intent.putExtras(bundle);
        ((i.a) e()).a().setResult(67, intent);
        ((i.a) e()).a().finish();
    }

    public final boolean p() {
        return this.f37724g instanceof m;
    }

    public final void q(HideReportType hideReportType, boolean z10, b bVar) {
        j.g(hideReportType, "type");
        j.g(bVar, "listListener");
        b6.j e10 = e();
        j.f(e10, "component");
        f fVar = new f((h) e10);
        FrameLayout frameLayout = this.f37723f.f41817c;
        j.f(frameLayout, "binding.hideReportContent");
        r(fVar.b(frameLayout, hideReportType, z10, bVar));
    }

    public final void s(Resource resource, b bVar, HideReportType hideReportType, boolean z10) {
        j.g(resource, JingleReason.ELEMENT);
        j.g(bVar, "childInteractionListener");
        j.g(hideReportType, "type");
        b6.j e10 = e();
        j.f(e10, "component");
        sc.f fVar = new sc.f((h) e10);
        FrameLayout frameLayout = this.f37723f.f41817c;
        j.f(frameLayout, "binding.hideReportContent");
        r(fVar.b(frameLayout, resource, hideReportType, bVar, z10));
    }
}
