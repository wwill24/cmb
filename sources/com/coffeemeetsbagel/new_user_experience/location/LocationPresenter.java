package com.coffeemeetsbagel.new_user_experience.location;

import android.view.ViewGroup;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class LocationPresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f35122e;

    public interface a {
        void a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f35122e = aVar;
    }

    /* access modifiers changed from: private */
    public static final void k(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.location_message)).setText(t9.a.onboardingLocation);
        ((com.uber.autodispose.p) ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new h(new LocationPresenter$didLoad$1(this)));
    }

    public final a l() {
        return this.f35122e;
    }
}
