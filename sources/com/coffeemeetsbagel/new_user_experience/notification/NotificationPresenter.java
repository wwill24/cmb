package com.coffeemeetsbagel.new_user_experience.notification;

import android.view.ViewGroup;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class NotificationPresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f35537e;

    public interface a {
        void a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f35537e = aVar;
    }

    /* access modifiers changed from: private */
    public static final void k(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.notification_header)).setText(t9.a.onboardingNotificationHeader);
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.notification_message)).setText(t9.a.onboardingNotificationBody);
        ((com.uber.autodispose.p) ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new h(new NotificationPresenter$didLoad$1(this)));
    }

    public final a l() {
        return this.f35537e;
    }
}
