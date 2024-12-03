package com.coffeemeetsbagel.new_user_experience.introductions;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class r extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final a f35106a;

    public interface a {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(Context context, a aVar) {
        super(context, R.style.onboarding_flow_dialog);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(aVar, "tracker");
        this.f35106a = aVar;
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        setContentView(R.layout.onboarding_last_name_dialog);
        ((CmbButton) findViewById(R.id.next_button)).setOnClickListener(new q(this));
        ((TextView) findViewById(R.id.message)).setText(t9.a.onboardingIntroductionsWhy);
    }

    /* access modifiers changed from: private */
    public static final void b(r rVar, View view) {
        j.g(rVar, "this$0");
        rVar.dismiss();
        rVar.f35106a.c();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f35106a.b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        j.g(motionEvent, "event");
        if (4 == motionEvent.getAction()) {
            this.f35106a.a();
        }
        return super.onTouchEvent(motionEvent);
    }
}
