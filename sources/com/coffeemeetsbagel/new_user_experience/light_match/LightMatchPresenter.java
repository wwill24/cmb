package com.coffeemeetsbagel.new_user_experience.light_match;

import android.view.ViewGroup;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class LightMatchPresenter extends p<ViewGroup> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final a f35112e;

    public interface a {
        void a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LightMatchPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f35112e = aVar;
    }

    /* access modifiers changed from: private */
    public static final void l(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.light_match_header)).setText(t9.a.onboardingLightMatchesHeader);
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.light_match_sub_header)).setText(t9.a.onboardingLightMatchesSubHeader);
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.light_match_button)).setText(t9.a.onboardingLightMatchesButton);
        ((com.uber.autodispose.p) ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.light_match_button)).a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new h(new LightMatchPresenter$didLoad$1(this)));
    }
}
